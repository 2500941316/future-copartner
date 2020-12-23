package com.shu.copartner.service.impl;

import com.shu.copartner.mapper.ActRuTaskMapper;
import com.shu.copartner.mapper.ProProjectMapper;
import com.shu.copartner.pojo.ActRuTask;
import com.shu.copartner.pojo.ActRuTaskExample;
import com.shu.copartner.pojo.ProNews;
import com.shu.copartner.pojo.ProProject;
import com.shu.copartner.pojo.request.ProjectApplyVO;
import com.shu.copartner.service.ProProjectService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2020/12/20 14:48
 * @description
 */
@Slf4j
@Service
public class ProProjectServiceImpl implements ProProjectService {

    @Resource
    private ProProjectMapper proProjectMapper;

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    ActRuTaskMapper actRuTaskMapper;

    @Autowired
    TaskService taskService;


    /**
     * 新增项目信息到数据库
     * @param record
     * @return
     */
    @Override
    public int insert(ProProject record) {
        return this.proProjectMapper.insert(record);
    }

    @Override
    public TableModel projectApply(ProjectApplyVO projectApplyVO,String creater) {

        //补全项目信息
        projectApplyVO.setStatus("管理员审批项目申请"); // 状态设置为 管理员审批项目申请
        projectApplyVO.setIsLock(0); // 默认未锁定
        projectApplyVO.setIsDeleted(0); // 默认未删除
        projectApplyVO.setCreater(creater); // 设置当前项目申请者
        //将前端接收的对象之间转为map，map中的参数开启流程
        Map<String, Object> map = new HashMap<>();
        map.put(Constants.PROJECTAPPLY_PROCESS_USERALIGN, projectApplyVO.getCreater());
        runtimeService.startProcessInstanceByKey(Constants.PROJECT_PROCESS_PROCESSKEY, map);
        //查询当前task表中得taskid
        ActRuTaskExample actRuTaskExample = new ActRuTaskExample();
        actRuTaskExample.createCriteria().andAssigneeEqualTo(projectApplyVO.getCreater()).andNameEqualTo(Constants.PROJECTAPPLY_PROCESS_APPLYNAME);
        List<ActRuTask> actRuTasks = actRuTaskMapper.selectByExample(actRuTaskExample);
        //如果查询得任务结果唯一，则完成项目申请任务，指定审批人为manager身份
        if (actRuTasks.size() == 1) {
            //将项目信息插入到项目表中
            ProProject proProject = new ProProject();
            BeanUtils.copyProperties(projectApplyVO, proProject);
            //插入项目信息
            proProjectMapper.insert(proProject);
            log.info("新增项目的id："+proProject.getId());

            String taskId = actRuTasks.get(0).getId();
            log.info("taskId:"+taskId);
            taskService.setVariable(taskId, Constants.MANAGER_ROLE, Constants.MANAGER_ROLE);
            taskService.setVariable(taskId, Constants.ACTIVITI_OBJECT_NAME, proProject.getId());
            taskService.complete(taskId);
            return TableModel.success("申请成功");
        } else {
            return TableModel.error("网络异常");
        }
    }

}
