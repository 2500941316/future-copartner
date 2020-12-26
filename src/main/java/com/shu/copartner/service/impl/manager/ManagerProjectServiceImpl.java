package com.shu.copartner.service.impl.manager;

import com.shu.copartner.mapper.ActRuVariableMapper;
import com.shu.copartner.mapper.ProProjectMapper;
import com.shu.copartner.pojo.*;
import com.shu.copartner.pojo.request.ProjectManagerOperationVO;
import com.shu.copartner.pojo.response.ProjectInfoSo;
import com.shu.copartner.service.ManagerProjectService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @Date: 2020/12/21 15:19
 * @Description:
 */
@Slf4j
@Service
public class ManagerProjectServiceImpl implements ManagerProjectService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private ActRuVariableMapper actRuVariableMapper;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProProjectMapper proProjectMapper;

    @Override
    public TableModel searchProject(int page) {
        long count = taskService.createTaskQuery().taskAssignee("admin") // Constants.MANAGER_ROLE
                .taskName(Constants.PROJECTAPPLY_PROCESS_MANAGERNAME).count();
        List<Task> taskList = taskService.createTaskQuery()
                .taskAssignee("admin") // Constants.MANAGER_ROLE
                .taskName(Constants.PROJECTAPPLY_PROCESS_MANAGERNAME) // 查询处于'管理员审批项目申请'状态的task
                .listPage(Constants.pageSize * (page - 1), Constants.pageSize);
        log.info("task条数："+taskList.size());

        List<ProjectInfoSo> arrayList = new ArrayList<>();
        for (Task task : taskList) {
            // 根据流程实例id 查询出variable表中的Long列数据，这一Long列数据是在创建流程是setVariable设置进去的
           // Long starttime = System.currentTimeMillis(); // 获取开始时间
            ActRuVariableExample actRuVariableExample = new ActRuVariableExample();
            actRuVariableExample.createCriteria().andExecutionIdEqualTo(task.getProcessInstanceId()).andLongIsNotNull();
            List<ActRuVariable> actRuVariables = actRuVariableMapper.selectByExample(actRuVariableExample);
   /* Long endtime = System.currentTimeMillis(); // 获取截止时间
            log.info("程序运行时间："+(endtime-starttime)+" ms");*/

            if (actRuVariables.size() == 1) {
                // 根据Long列存储的项目记录id查询出项目信息，
                ProProject proProject = proProjectMapper.selectByPrimaryKey(actRuVariables.get(0).getLong());
                ProjectInfoSo projectInfoSo = new ProjectInfoSo();
                // 将taskId添加到该条项目的记录，传到前端，然后前端进行通过或驳回时，通过传入该taskId来判断该项目具体的流程
                BeanUtils.copyProperties(proProject,projectInfoSo);
                projectInfoSo.setTaskId(task.getId());
                arrayList.add(projectInfoSo);
            }
        }
        return TableModel.tableSuccess(arrayList, (int)count);
    }

/**
     * 审核项目申请
     * @param projectManagerOperationVO
     * @return
     */

    @Override
    public TableModel operateProjectApply(ProjectManagerOperationVO projectManagerOperationVO) {
        // 完成审核
     //   taskService.complete(projectManagerOperationVO.getTaskId());
        //更新项目状态
        ProProject proProject = new ProProject();
        BeanUtils.copyProperties(projectManagerOperationVO, proProject);
        if(projectManagerOperationVO.getIsAudit().equals("1")){
            proProject.setProjectStatus("项目申请已通过");
        }else if(projectManagerOperationVO.getIsAudit().equals("2")){
            proProject.setProjectStatus("项目申请已驳回");
        }
        proProject.setProjectId(Long.parseLong(projectManagerOperationVO.getProjectId()));
        proProjectMapper.updateByPrimaryKeySelective(proProject);
        return TableModel.success();
    }






   /* @Override
    public TableModel operateNew(NewsManagerOperationVO newsManagerOperationVO) {
        //完成taskid的审批任务
        activitiService.init();
        //如果完成了审批任务，则将结果直接存入news表，同意的和拒绝的
        if (activitiService.completeTaskWithoutObject(newsManagerOperationVO.getTaskId())) {
            //更新新闻状态
            if (newsManagerOperationVO.getStatus().equals("1")) {
                ProNewsExample proNewsExample = new ProNewsExample();

            }
        }
        return null;
    }

    activitiService.init();
        List<Task> taskList = activitiService.findMyPersonalTask(page, Constants.PROJECT_PROCESS_MANAGERNAME, "admin"); // Constants.PROJECT_PROCESS_MANAGERNAME, Constants.MANAGER_ROLE
        log.info("条数："+taskList.size());
        //创建返回的list
        List<ProjectInfoSo> arrayList = new ArrayList();
        for (Task task : taskList) {
            ProjectApplyVO taskObjectParams = activitiService.findTaskObjectParams(task.getId(), Constants.ACTIVITI_OBJECT_NAME, ProjectApplyVO.class);
            if (taskObjectParams != null) {
                ProjectInfoSo projectInfoSo = new ProjectInfoSo();
                BeanUtils.copyProperties(taskObjectParams, projectInfoSo);
                projectInfoSo.setTaskId(task.getId());
                arrayList.add(projectInfoSo);
            }
        }
        return TableModel.tableSuccess(arrayList, arrayList.size());

    */
}
