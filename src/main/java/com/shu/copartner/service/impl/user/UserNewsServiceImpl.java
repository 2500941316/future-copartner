package com.shu.copartner.service.impl.user;

import com.github.pagehelper.PageHelper;
import com.shu.copartner.mapper.ActRuTaskMapper;
import com.shu.copartner.mapper.ProNewsMapper;
import com.shu.copartner.pojo.*;
import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.service.UserNewsService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
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
            return TableModel.success("发布成功");
        } else {
            return TableModel.error("网络异常");
        }
    }


    @Override
    public TableModel searchNewsById(String newsId) {
        if (!newsId.isEmpty()) {
            //先查询当前新闻的详情
            ProNews proNews = proNewsMapper.selectByPrimaryKey(Long.parseLong(newsId));
            //再查询10条热点关注
            ProNewsExample proNewsExample = new ProNewsExample();
            proNewsExample.setOrderByClause("news_publisTime desc");
            proNewsExample.createCriteria().andIsauditEqualTo("1");
            PageHelper.startPage(1, 10);
            List<ProNews> recently_NewsList = proNewsMapper.selectByExample(proNewsExample);
            ArrayList<Object> res = new ArrayList<>();
            res.add(proNews);
            res.add(recently_NewsList);
            return TableModel.success(res, 1);
        }
        return TableModel.error("网络错误");
    }


    @Override
    public TableModel getNewsIndexInfo_byCatagories() {
        List<String> news_catagories = Arrays.asList(Constants.NEWS_CATAGORIES);
        Map<String, List<ProNews>> news_titleMap = new HashMap<>();
        //根据分类查询3个新闻标题

        for (String news_catagory : news_catagories) {
            ProNewsExample proNewsExample = new ProNewsExample();
            proNewsExample.setOrderByClause("news_publisTime desc");
            proNewsExample.createCriteria().andIsauditEqualTo("1").andNewsCategoryEqualTo(news_catagory);
            PageHelper.startPage(1, 3);
            List<ProNews> proNews = proNewsMapper.selectByExample(proNewsExample);
            for (ProNews proNew : proNews) {
                proNew.setNewsContent(null);
            }
            news_titleMap.put(news_catagory, proNews);
        }
        return TableModel.success(news_titleMap, news_titleMap.size());
    }


    @Override
    public TableModel getNewsIndexInfo_mostClickTimes() {
        //查询最新的10个热点新闻
        ProNewsExample RecentNewsExample = new ProNewsExample();
        RecentNewsExample.setOrderByClause("news_publisTime desc");
        RecentNewsExample.createCriteria().andIsauditEqualTo("1");
        PageHelper.startPage(1, 10);
        List<ProNews> recently_NewsList = proNewsMapper.selectByExample(RecentNewsExample);
        for (ProNews proNews : recently_NewsList) {
            proNews.setNewsContent(null);
        }
        return TableModel.success(recently_NewsList, recently_NewsList.size());
    }

    @Override
    public TableModel getNewsIndexInfo_topNews() {
        //查询最新的两个置顶的新闻和新闻内容
        ProNewsExample proNewsExample = new ProNewsExample();
        PageHelper.startPage(1, 2);
        proNewsExample.createCriteria().andIsauditEqualTo("1").andIstoppingEqualTo("是");
        List<ProNews> topNewsList = proNewsMapper.selectByExample(proNewsExample);
        for (ProNews proNews : topNewsList) {
            if (proNews.getNewsContent().length() > 90) {
                proNews.setNewsContent(proNews.getNewsContent().substring(0, 90));
            }
        }
        return TableModel.success(topNewsList, topNewsList.size());
    }
}
