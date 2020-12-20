package com.shu.copartner.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shu.copartner.mapper.ActRuTaskMapper;
import com.shu.copartner.pojo.ActRuTask;
import com.shu.copartner.pojo.ActRuTaskExample;
import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.service.UserNewsService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cxy
 * @Date: 2020/12/20 13:39
 * @Description:
 */
@Transactional
@Service
public class UserNewsServiceImpl implements UserNewsService {

    @Autowired
    ActivitiServiceImpl activitiService;

    @Autowired
    ActRuTaskMapper actRuTaskMapper;

    @Override
    public TableModel publisNews(NewsPublishVO newsPublishVO) {

        //开启一个文章发布的流程
        activitiService.init();

        //补全用户提交的信息和时间
        newsPublishVO.setNewsPublistime(new Date());
        //将前端接收的对象之间转为map，map中的参数开启流程
        Map<String, Object> map = JSONObject.parseObject(JSON.toJSONString(newsPublishVO));
        activitiService.startProcessInstance(map, Constants.NEWSAPPLY_PROCESSKEY);
        //查询当前task表中得taskid
        ActRuTaskExample actRuTaskExample = new ActRuTaskExample();
        actRuTaskExample.createCriteria().andAssigneeEqualTo(newsPublishVO.getNewsAuthor()).andNameEqualTo(Constants.NEWSAPPLY_PROCESS_APPLYNAME);
        List<ActRuTask> actRuTasks = actRuTaskMapper.selectByExample(actRuTaskExample);
        //如果查询得任务结果唯一，则完成申请新闻任务，指定审批人为manager身份
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put(Constants.MANAGER_ROLE, Constants.MANAGER_ROLE);
        if (actRuTasks.size() == 1 && activitiService.completeTask(actRuTasks.get(0).getId(), Constants.MANAGER_ROLE, paramsMap)) {
            return TableModel.success("发布成功");
        } else {
            return TableModel.error("网络异常");
        }
    }
}
