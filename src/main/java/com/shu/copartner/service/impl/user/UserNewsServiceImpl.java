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

import java.util.*;

/**
 * @author cxy
 * @Date: 2020/12/20 13:39
 * @Description:
 */
@Transactional
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
        List<ProNews> recently_NewsList = null;
        ProNewsExample proNewsExample = new ProNewsExample();
        proNewsExample.setOrderByClause(Constants.NEW_DESCBYDATE);
        proNewsExample.createCriteria().andIsauditEqualTo(Constants.NEW_AUTHED);
        try {
            //先查询当前新闻的详情
            proNews = proNewsMapper.selectByPrimaryKey(Long.parseLong(newsId));
            //再查询10条热点关注
            PageHelper.startPage(1, Constants.pageSize);
            recently_NewsList = proNewsMapper.selectByExample(proNewsExample);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        ArrayList<Object> res = new ArrayList<>();
        res.add(proNews);
        res.add(recently_NewsList);
        return TableModel.success(res, 1);
    }


    @Override
    public TableModel getNewsIndexInfo() {

        List<String> news_catagories = Arrays.asList(Constants.NEWS_CATAGORIES);
        Map<String, Object> news_titleMap = new HashMap<>();
        //根据分类查询3个新闻标题
        List<List<ProNews>> categoriesNewsList = new ArrayList<>();
        List<ProNews> recently_NewsList = null;
        List<ProNews> topNewsList = null;
        try {
            for (String newsCatagory : news_catagories) {
                ProNewsExample proNewsExample = new ProNewsExample();
                proNewsExample.setOrderByClause(Constants.NEW_DESCBYDATE);
                proNewsExample.createCriteria().andIsauditEqualTo(Constants.NEW_AUTHED).andNewsCategoryEqualTo(newsCatagory);
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
            PageHelper.startPage(1, 2);
            proNewsExample.createCriteria().andIsauditEqualTo(Constants.NEW_AUTHED).andIstoppingEqualTo(Constants.NEW_ISTOP);
            topNewsList = proNewsMapper.selectByExample(proNewsExample);
            for (ProNews proNews : topNewsList) {
                if (proNews.getNewsContent().length() > 90) {
                    proNews.setNewsContent(proNews.getNewsContent().substring(0, 90));
                }
            }

            //查询最新的10个热点新闻
            recentNewsExample.setOrderByClause(Constants.NEW_DESCBYDATE);
            recentNewsExample.createCriteria().andIsauditEqualTo(Constants.NEW_AUTHED);
            PageHelper.startPage(1, Constants.pageSize);
            recently_NewsList = proNewsMapper.selectByExample(recentNewsExample);
            for (ProNews proNews : recently_NewsList) {
                proNews.setNewsContent(null);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        news_titleMap.put("topNewsList", topNewsList);
        news_titleMap.put("recently_NewsList", recently_NewsList);
        news_titleMap.put("categoriesNewsList", categoriesNewsList);
        return TableModel.success(news_titleMap, news_titleMap.size());
    }

    @Override
    public TableModel searchNewsByKeywords(int page, String keywords) {
        ArrayList<List<ProNews>> resList = new ArrayList<>();
        List<ProNews> proNews = null;
        ProNewsExample proNewsExample = new ProNewsExample();
        proNewsExample.setOrderByClause(Constants.NEW_DESCBYDATE);
        PageHelper.startPage(page, Constants.pageSize);

        //判断keyword的前两个字符判断是根据种类查询还是根据关键字查询
        if (keywords!=null && keywords.substring(0, 2).equals(Constants.NEW_FIRSTKEY)) {
            proNewsExample.createCriteria().andNewsTitleLike("%" + keywords.substring(2, keywords.length() - 1) + "%").andIsauditEqualTo(Constants.NEW_AUTHED);
        } else {
            proNewsExample.createCriteria().andNewsCategoryEqualTo(keywords).andIsauditEqualTo(Constants.NEW_AUTHED);
        }
        try {
            proNews = proNewsMapper.selectByExample(proNewsExample);
            for (ProNews proNew : proNews) {
                proNew.setNewsContent(null);
            }

            //查询最新的10条记录
            ProNewsExample recentNewsExample = new ProNewsExample();
            recentNewsExample.setOrderByClause(Constants.NEW_DESCBYDATE);
            recentNewsExample.createCriteria().andIsauditEqualTo(Constants.NEW_AUTHED);
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
}
