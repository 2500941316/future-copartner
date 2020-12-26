package com.shu.copartner.service.impl;

import com.shu.copartner.mapper.ActRuTaskMapper;
import com.shu.copartner.mapper.ProProjectMapper;
import com.shu.copartner.pojo.ActRuTask;
import com.shu.copartner.pojo.ActRuTaskExample;
import com.shu.copartner.pojo.ProProject;
import com.shu.copartner.pojo.request.ProjectApplyVO;
import com.shu.copartner.service.ProProjectService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private ProProjectMapper proProjectMapper;

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    ActRuTaskMapper actRuTaskMapper;

    @Autowired
    TaskService taskService;


  /*  *
     * 新增项目信息到数据库
     * @param record
     * @return
     */
    @Override
    public int insert(ProProject record) {
        return this.proProjectMapper.insert(record);
    }

  /*  *
     * 根据创建人查询项目
     * @param projectCreater
     * @return
     */
    @Override
    public TableModel selectByCreater(String projectCreater) {
        List<ProProject> projectData = this.proProjectMapper.selectByCreater(projectCreater);
        return TableModel.success(projectData,projectData.size());
    }

    @Override
    public TableModel projectApply(ProjectApplyVO projectApplyVO, String creater) {

        //补全项目信息
        projectApplyVO.setProjectActivitiState("管理员审批项目申请"); // 状态设置为 管理员审批项目申请
        projectApplyVO.setIsLock(0); // 默认未锁定
        projectApplyVO.setIsDeleted(0); // 默认未删除
        projectApplyVO.setProjectCreater(creater); // 设置当前项目申请者
        //将前端接收的对象之间转为map，map中的参数开启流程
        Map<String, Object> map = new HashMap<>();
        map.put(Constants.PROJECTAPPLY_PROCESS_USERALIGN, projectApplyVO.getProjectCreater());
        runtimeService.startProcessInstanceByKey(Constants.PROJECT_PROCESS_PROCESSKEY, map);
        //查询当前task表中得taskid
        ActRuTaskExample actRuTaskExample = new ActRuTaskExample();
        actRuTaskExample.createCriteria().andAssigneeEqualTo(projectApplyVO.getProjectCreater()).andNameEqualTo(Constants.PROJECTAPPLY_PROCESS_APPLYNAME);
        List<ActRuTask> actRuTasks = actRuTaskMapper.selectByExample(actRuTaskExample);
        //如果查询得任务结果唯一，则完成项目申请任务，指定审批人为manager身份
        if (actRuTasks.size() == 1) {
            //将项目信息插入到项目表中
            ProProject proProject = new ProProject();
            BeanUtils.copyProperties(projectApplyVO, proProject);
            //插入项目信息
            proProjectMapper.insert(proProject);
            log.info("新增项目的id："+proProject.getProjectId());

            String taskId = actRuTasks.get(0).getId();
            log.info("taskId:"+taskId);
            taskService.setVariable(taskId, Constants.MANAGER_ROLE, Constants.MANAGER_ROLE);
            taskService.setVariable(taskId, Constants.ACTIVITI_OBJECT_NAME, proProject.getProjectId());
            taskService.complete(taskId);
            return TableModel.success();
        } else {
            return TableModel.error("网络异常");
        }
    }

    @Override
    public TableModel searchProjectById(String projectId) {
        if(StringUtils.isNotEmpty(projectId)){
            //根据id查询出数据添加到数组返回
            ProProject proProject = this.proProjectMapper.selectByPrimaryKey(Long.parseLong(projectId));
            List<ProProject> proProjects = new ArrayList<>();
            proProjects.add(proProject);
            return TableModel.success(proProjects,proProjects.size());
        }else{
            return  TableModel.error("网络异常");
        }
    }

}
