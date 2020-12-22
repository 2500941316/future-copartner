package com.shu.copartner.service.impl.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shu.copartner.mapper.ActRuTaskMapper;
import com.shu.copartner.mapper.ProNewsMapper;
import com.shu.copartner.pojo.ActRuTask;
import com.shu.copartner.pojo.ActRuTaskExample;
import com.shu.copartner.pojo.ProNews;
import com.shu.copartner.pojo.ProNewsWithBLOBs;
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
}
