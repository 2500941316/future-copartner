package com.shu.copartner.service.impl.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProNewsMapper;
import com.shu.copartner.mapper.ProUserMapper;
import com.shu.copartner.pojo.*;
import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.service.UserNewsService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cxy
 * @Date: 2020/12/20 13:39
 * @Description:
 */
@Transactional(rollbackFor = Exception.class)
@Slf4j
@Service
public class UserNewsServiceImpl implements UserNewsService {

    @Autowired
    ProNewsMapper proNewsMapper;

    @Autowired
    private ProUserMapper proUserMapper;

    @Override
    public TableModel publisNews(NewsPublishVO newsPublishVO) {
        // 根据用户手机号查询出其姓名
        ProUserExample proUserExample = new ProUserExample();
        proUserExample.createCriteria().andPhoneEqualTo(newsPublishVO.getNewsAuthor());
        List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
        String authorName = proUsers.get(0).getName();

        //补全用户提交的信息和时间
        newsPublishVO.setNewsPublistime(new Date());
        newsPublishVO.setNewsAuthor(authorName);
        newsPublishVO.setIstopping("0"); // 代表发表的是帖子 ，而不是精彩上大新闻
        //将前端接收的对象之间转为map，map中的参数开启流程
        Map<String, Object> map = new HashMap<>();
        map.put(Constants.NEWSAPPLY_PROCESS_USERALIGN, newsPublishVO.getNewsAuthor());
        try {
            //查询当前task表中得taskid
            //将新闻插入新闻表中，状态isAuth置为0
            ProNewsWithBLOBs proNewsWithBLOBs = new ProNewsWithBLOBs();
            //生成主键插入：作者+时间戳
            BeanUtils.copyProperties(newsPublishVO, proNewsWithBLOBs);
            //插入新闻
            proNewsMapper.insert(proNewsWithBLOBs);
            return TableModel.success();

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }


    @Override
    public TableModel searchNewsById(String newsId) {
        ProNewsWithBLOBs proNewsWithBLOBs = null;
        List<ProNews> recentlyNewsList = null;
        ProNewsExample proNewsExample = new ProNewsExample();
        proNewsExample.setOrderByClause(Constants.NEW_DESCBYCLICKTIME);
        proNewsExample.createCriteria().andIsauditEqualTo(Constants.NEW_AUTHED).andIsdeletedEqualTo(Constants.NO_DELETED);
        try {
            //先查询当前新闻的详情
            proNewsWithBLOBs = proNewsMapper.selectByPrimaryKey(Long.parseLong(newsId));
            //再查询10条热点关注
            PageHelper.startPage(1, Constants.PAGESIZE);
            recentlyNewsList = proNewsMapper.selectByExample(proNewsExample);

            //将该新闻的点击数加1
            proNewsWithBLOBs.setNewsBrowsecount(proNewsWithBLOBs.getNewsBrowsecount() + 1);
            proNewsMapper.updateByPrimaryKeySelective(proNewsWithBLOBs);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        ArrayList<Object> res = new ArrayList<>();
        res.add(proNewsWithBLOBs);
        res.add(recentlyNewsList);
        return TableModel.success(res, 1);
    }


    @Override
    public TableModel getNewsIndexInfo() {

        Map<String, Object> newsTitleMap = new HashMap<>();
        List<ProNews> recentlyNewsList = null;
        List<ProNewsWithBLOBs> topNewsList = null;
        try {
            //查询最新的两个置顶的新闻和新闻内容
            ProNewsExample proNewsExample = new ProNewsExample();
            ProNewsExample recentNewsExample = new ProNewsExample();
            proNewsExample.setOrderByClause(Constants.NEW_DESCBYDATE);
            PageHelper.startPage(1, 2);
            proNewsExample.createCriteria()
                    .andIsauditEqualTo(Constants.NEW_AUTHED)
                   // .andIstoppingEqualTo(Constants.NEW_ISTOP)
                    .andIstoppingEqualTo("1") //  1 代表是上大新闻，而不是帖子
                    .andIsdeletedEqualTo(Constants.NO_DELETED);
            topNewsList = proNewsMapper.selectByExampleWithBLOBs(proNewsExample);

            for (ProNewsWithBLOBs newsWithBLOBs : topNewsList) {
                if (newsWithBLOBs.getNewsContent().length() > 100) {
                    newsWithBLOBs.setNewsContent(delHtmlTag(newsWithBLOBs.getNewsContent().substring(0, 100)));
                }
            }
            // 查询最新的10个点击度最高的新闻
            recentNewsExample.setOrderByClause(Constants.NEW_DESCBYCLICKTIME);
            recentNewsExample.createCriteria()
                    .andIsauditEqualTo(Constants.NEW_AUTHED)
                    .andIsdeletedEqualTo(Constants.NO_DELETED);
            PageHelper.startPage(1, Constants.PAGESIZE);
            recentlyNewsList = proNewsMapper.selectByExample(recentNewsExample);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }

        newsTitleMap.put("topNewsList", topNewsList);
        newsTitleMap.put("recently_NewsList", recentlyNewsList);
        return TableModel.success(newsTitleMap, newsTitleMap.size());
    }


    @Override
    public TableModel getNewsIndexCategoryInfo() {
        String[] newsCatagories = Constants.NEWS_CATAGORIES;
        //根据分类查询3个新闻标题
        List<List<ProNews>> categoriesNewsList = new ArrayList<>();
        try {
            //每个种类查询3条最新的新闻
            for (String newsCatagory : newsCatagories) {
                ProNewsExample proNewsExample = new ProNewsExample();
                proNewsExample.setOrderByClause(Constants.NEW_DESCBYDATE);
                proNewsExample.createCriteria()
                        .andIsauditEqualTo(Constants.NEW_AUTHED)
                        .andNewsCategoryEqualTo(newsCatagory)
                        .andIsdeletedEqualTo(Constants.NO_DELETED);
                PageHelper.startPage(1, 3);
                List<ProNews> proNews = proNewsMapper.selectByExample(proNewsExample);
                categoriesNewsList.add(proNews);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.success(categoriesNewsList, categoriesNewsList.size());
    }


    @Override
    public TableModel searchNewsByKeywords(int page, String keywords) {
        ArrayList<List<ProNews>> resList = new ArrayList<>();
        List<ProNews> proNews = null;
        ProNewsExample proNewsExample = new ProNewsExample();
        proNewsExample.setOrderByClause(Constants.NEW_DESCBYDATE);
        PageHelper.startPage(page, Constants.PAGESIZE);//

        //判断keyword的前两个字符判断是根据种类查询还是根据关键字查询
        if (keywords != null && keywords.substring(0, 2).equals(Constants.NEW_FIRSTKEY)) {
            proNewsExample.createCriteria().andNewsTitleLike("%" + keywords.substring(2, keywords.length() - 1) + "%")
                    .andIsauditEqualTo(Constants.NEW_AUTHED).andIsdeletedEqualTo(Constants.NO_DELETED);
        } else {
            proNewsExample.createCriteria().andNewsCategoryEqualTo(keywords).andIsauditEqualTo(Constants.NEW_AUTHED).andIsdeletedEqualTo(Constants.NO_DELETED);
        }
        try {
            proNews = proNewsMapper.selectByExample(proNewsExample);

            //查询最新的10条记录
            ProNewsExample recentNewsExample = new ProNewsExample();
            recentNewsExample.setOrderByClause(Constants.NEW_DESCBYCLICKTIME);
            recentNewsExample.createCriteria().andIsauditEqualTo(Constants.NEW_AUTHED).andIsdeletedEqualTo(Constants.NO_DELETED);
            PageHelper.startPage(1, 10);
            List<ProNews> recentlyNewsList = proNewsMapper.selectByExample(recentNewsExample);
            for (ProNews news : recentlyNewsList) {
                //  news.setNewsContent(null);
            }

            resList.add(proNews);
            resList.add(recentlyNewsList);
            PageInfo pageInfo = new PageInfo(proNews);
            //TableModel.success(resList, resList.size())
            return TableModel.success(resList, (int)pageInfo.getTotal());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }


    @Override
    public TableModel searchMyNews(int page, String phone) {
        // 根据手机号查询出姓名，然后用作者姓名查询
        ProUserExample proUserExample = new ProUserExample();
        proUserExample.createCriteria().andPhoneEqualTo(phone);
        List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
        String authorName = proUsers.get(0).getName();

        List<ProNews> proNews;
        //根据电话号码查询用户发布的所有新闻并且返回
        ProNewsExample proNewsExample = new ProNewsExample();
        proNewsExample.createCriteria().andNewsAuthorEqualTo(authorName).andIsdeletedEqualTo(Constants.NO_DELETED);
        PageHelper.startPage(page, Constants.PAGESIZE);
        try {
            proNews = proNewsMapper.selectByExample(proNewsExample);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        PageInfo pageInfo = new PageInfo(proNews, 5);
        return TableModel.tableSuccess(proNews, (int) pageInfo.getTotal());
    }


    /**
     * 将字符串过滤掉html
     *
     * @param htmlStr
     * @return
     */
    public String delHtmlTag(String htmlStr) {
        String regExStyle = "<style[^>]*?>[\\s\\S]*?<\\/style>";
        String regExHtml = "<[^>]+>";
        Pattern pStyle = Pattern.compile(regExStyle, Pattern.CASE_INSENSITIVE);
        Matcher mStyle = pStyle.matcher(htmlStr);
        htmlStr = mStyle.replaceAll("");
        Pattern pHtml = Pattern.compile(regExHtml, Pattern.CASE_INSENSITIVE);
        Matcher mHtml = pHtml.matcher(htmlStr);
        htmlStr = mHtml.replaceAll("");
        htmlStr = htmlStr.replace(" ", "");
        htmlStr = htmlStr.replaceAll("\\s*|\t|\r|\n", "");
        htmlStr = htmlStr.replace("“", "");
        htmlStr = htmlStr.replace("”", "");
        htmlStr = htmlStr.replaceAll("　", "");

        return htmlStr.trim();
    }
}
