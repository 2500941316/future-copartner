package com.shu.copartner.service.impl.user;

import com.github.pagehelper.PageHelper;
import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ActRuTaskMapper;
import com.shu.copartner.mapper.ProNewsMapper;
import com.shu.copartner.pojo.*;
import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.service.UserNewsService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

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
    RuntimeService runtimeService;

    @Autowired
    ActRuTaskMapper actRuTaskMapper;

    @Autowired
    TaskService taskService;

    @Autowired
    ProNewsMapper proNewsMapper;

    @Override
    public TableModel publisNews(NewsPublishVO newsPublishVO) {
        //补全用户提交的信息和时间
        newsPublishVO.setNewsPublistime(new Date());
        //将前端接收的对象之间转为map，map中的参数开启流程
        Map<String, Object> map = new HashMap<>();
        map.put(Constants.NEWSAPPLY_PROCESS_USERALIGN, newsPublishVO.getNewsAuthor());
        try {
            runtimeService.startProcessInstanceByKey(Constants.NEWSAPPLY_PROCESSKEY, map);
            //查询当前task表中得taskid
            ActRuTaskExample actRuTaskExample = new ActRuTaskExample();
            actRuTaskExample.createCriteria().andAssigneeEqualTo(newsPublishVO.getNewsAuthor()).andNameEqualTo(Constants.NEWSAPPLY_PROCESS_APPLYNAME);
            List<ActRuTask> actRuTasks = actRuTaskMapper.selectByExample(actRuTaskExample);
            //如果查询得任务结果唯一，则完成申请新闻任务，指定审批人为manager身份
            if (actRuTasks.size() == 1) {
                //将新闻插入新闻表中，状态isAuth置为0
                ProNews proNews = new ProNews();
                //生成主键插入：作者+时间戳
                BeanUtils.copyProperties(newsPublishVO, proNews);
                //插入新闻
                proNewsMapper.insert(proNews);
                String taskId = actRuTasks.get(0).getId();
                taskService.setVariable(taskId, Constants.MANAGER_ROLE, Constants.MANAGER_ROLE);
                taskService.setVariable(taskId, Constants.ACTIVITI_OBJECT_NAME, proNews.getNewsId());
                taskService.complete(taskId);
                return TableModel.success();
            } else {
                return TableModel.error();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }


    @Override
    public TableModel searchNewsById(String newsId) {
        ProNews proNews = null;
        List<ProNews> recentlyNewsList = null;
        ProNewsExample proNewsExample = new ProNewsExample();
        proNewsExample.setOrderByClause(Constants.NEW_DESCBYCLICKTIME);
        proNewsExample.createCriteria().andIsauditEqualTo(Constants.NEW_AUTHED).andIsdeletedEqualTo(Constants.NO_DELETED);
        try {
            //先查询当前新闻的详情
            proNews = proNewsMapper.selectByPrimaryKey(Long.parseLong(newsId));
            //再查询10条热点关注
            PageHelper.startPage(1, Constants.PAGESIZE);
            recentlyNewsList = proNewsMapper.selectByExample(proNewsExample);

            //将该新闻的点击数加1
            proNews.setNewsBrowsecount(proNews.getNewsBrowsecount() + 1);
            proNewsMapper.updateByPrimaryKeySelective(proNews);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        ArrayList<Object> res = new ArrayList<>();
        res.add(proNews);
        res.add(recentlyNewsList);
        return TableModel.success(res, 1);
    }


    @Override
    public TableModel getNewsIndexInfo() {

        String[] newsCatagories = Constants.NEWS_CATAGORIES;
        Map<String, Object> newsTitleMap = new HashMap<>();
        //根据分类查询3个新闻标题
        List<List<ProNews>> categoriesNewsList = new ArrayList<>();
        List<ProNews> recentlyNewsList = null;
        List<ProNews> topNewsList = null;
        try {
            //每个种类查询3条最新的新闻
            for (String newsCatagory : newsCatagories) {
                ProNewsExample proNewsExample = new ProNewsExample();
                proNewsExample.setOrderByClause(Constants.NEW_DESCBYDATE);
                proNewsExample.createCriteria().andIsauditEqualTo(Constants.NEW_AUTHED)
                        .andNewsCategoryEqualTo(newsCatagory).andIsdeletedEqualTo(Constants.NO_DELETED);
                PageHelper.startPage(1, 3);
                List<ProNews> proNews = proNewsMapper.selectByExample(proNewsExample);

                for (ProNews proNew : proNews) {
                    proNew.setNewsContent(null);
                }
                categoriesNewsList.add(proNews);
            }

            //查询最新的两个置顶的新闻和新闻内容
            ProNewsExample proNewsExample = new ProNewsExample();
            ProNewsExample recentNewsExample = new ProNewsExample();
            proNewsExample.setOrderByClause(Constants.NEW_DESCBYDATE);
            PageHelper.startPage(1, 2);
            proNewsExample.createCriteria().andIsauditEqualTo(Constants.NEW_AUTHED)
                    .andIstoppingEqualTo(Constants.NEW_ISTOP).andIsdeletedEqualTo(Constants.NO_DELETED);
            topNewsList = proNewsMapper.selectByExample(proNewsExample);
            for (ProNews proNews : topNewsList) {
                if (proNews.getNewsContent().length() > 100) {
                    proNews.setNewsContent(delHtmlTag(proNews.getNewsContent().substring(0, 100)));
                }
            }

            //查询最新的10个点击度最高的新闻
            recentNewsExample.setOrderByClause(Constants.NEW_DESCBYCLICKTIME);
            recentNewsExample.createCriteria().andIsauditEqualTo(Constants.NEW_AUTHED).andIsdeletedEqualTo(Constants.NO_DELETED);
            PageHelper.startPage(1, Constants.PAGESIZE);
            recentlyNewsList = proNewsMapper.selectByExample(recentNewsExample);
            for (ProNews proNews : recentlyNewsList) {
                proNews.setNewsContent(null);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        newsTitleMap.put("topNewsList", topNewsList);
        newsTitleMap.put("recently_NewsList", recentlyNewsList);
        newsTitleMap.put("categoriesNewsList", categoriesNewsList);
        return TableModel.success(newsTitleMap, newsTitleMap.size());
    }

    @Override
    public TableModel searchNewsByKeywords(int page, String keywords) {
        ArrayList<List<ProNews>> resList = new ArrayList<>();
        List<ProNews> proNews = null;
        ProNewsExample proNewsExample = new ProNewsExample();
        proNewsExample.setOrderByClause(Constants.NEW_DESCBYDATE);
        PageHelper.startPage(page, Constants.PAGESIZE);

        //判断keyword的前两个字符判断是根据种类查询还是根据关键字查询
        if (keywords != null && keywords.substring(0, 2).equals(Constants.NEW_FIRSTKEY)) {
            proNewsExample.createCriteria().andNewsTitleLike("%" + keywords.substring(2, keywords.length() - 1) + "%")
                    .andIsauditEqualTo(Constants.NEW_AUTHED).andIsdeletedEqualTo(Constants.NO_DELETED);
        } else {
            proNewsExample.createCriteria().andNewsCategoryEqualTo(keywords).andIsauditEqualTo(Constants.NEW_AUTHED).andIsdeletedEqualTo(Constants.NO_DELETED);
        }
        try {
            proNews = proNewsMapper.selectByExample(proNewsExample);
            for (ProNews proNew : proNews) {
                proNew.setNewsContent(null);
            }

            //查询最新的10条记录
            ProNewsExample recentNewsExample = new ProNewsExample();
            recentNewsExample.setOrderByClause(Constants.NEW_DESCBYCLICKTIME);
            recentNewsExample.createCriteria().andIsauditEqualTo(Constants.NEW_AUTHED).andIsdeletedEqualTo(Constants.NO_DELETED);
            PageHelper.startPage(1, 10);
            List<ProNews> recentlyNewsList = proNewsMapper.selectByExample(recentNewsExample);
            for (ProNews news : recentlyNewsList) {
                news.setNewsContent(null);
            }

            resList.add(proNews);
            resList.add(recentlyNewsList);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.success(resList, resList.size());
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
