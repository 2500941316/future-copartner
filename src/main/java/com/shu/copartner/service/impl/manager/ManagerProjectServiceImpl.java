package com.shu.copartner.service.impl.manager;

import com.shu.copartner.mapper.ActRuVariableMapper;
import com.shu.copartner.mapper.ProProjectMapper;
import com.shu.copartner.pojo.ProProject;
import com.shu.copartner.pojo.request.ProjectManagerOperationVO;
import com.shu.copartner.service.ManagerProjectService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询待审批项目
     * @param page
     * @return
     */
/*    @Override
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
   *//* Long endtime = System.currentTimeMillis(); // 获取截止时间
            log.info("程序运行时间："+(endtime-starttime)+" ms");*//*

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
    }*/

    @Override
    public TableModel searchProject(int page) {
        // 查询出所有待审批的项目数据
        String[] tokes = {"21","31","41","51"};
        List<ProProject> auditProject = proProjectMapper.selectProjectByToken(tokes);
        return TableModel.tableSuccess(auditProject, (int)auditProject.size());
    }

/**
     * 审核项目申请
     * @param projectManagerOperationVO
     * @return
     */

    /*@Override
    public TableModel operateProjectApply(ProjectManagerOperationVO projectManagerOperationVO) {
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
    }*/

    /**
     * 审批项目
     * @param projectManagerOperationVO
     * @return
     */
    @Override
    public TableModel operateProjectApply(ProjectManagerOperationVO projectManagerOperationVO) {
        // 根据审批状态值，将转换审批状态，然后根据不同的情况写入数据库
        int isPass = Integer.parseInt(projectManagerOperationVO.getIsPass());
        int stateToken = Integer.parseInt(projectManagerOperationVO.getProjectStateToken());
        // 审批后状态标志值，通过就+1，驳回就+2
        String nextToken =Integer.toString(isPass + stateToken);
        //更新项目状态
        ProProject proProject = new ProProject();
        BeanUtils.copyProperties(projectManagerOperationVO, proProject);
        //设置审批后的状态 和 状态值 和 id
        proProject.setProjectStatus(Constants.PROJECT_STATE_TOKEN.get(nextToken));
        proProject.setProjectStateToken(nextToken);
        proProject.setProjectId(Long.parseLong(projectManagerOperationVO.getProjectId()));

        // 根据状态标签值判断审批的是哪一项
        String tempStateToken = null;
        for(Map.Entry<String,String> entry : Constants.PROJECT_STATE_TOKEN.entrySet()){
            if(projectManagerOperationVO.getProjectStateToken().equals(entry.getKey())){
                tempStateToken = entry.getKey();
                log.info("审批："+tempStateToken);
            }
        }
        if(tempStateToken.equals("21")){
            // 审批项目申请，通过或者驳回，直接更新数据库状态
            proProjectMapper.updateByPrimaryKeySelective(proProject);
            return TableModel.success();
        }else if(tempStateToken.equals("41")){
            // 审批项目视频，如果驳回则将视频路径置空
            if(isPass == 2){
                proProject.setVideoUrl("null");
            }
            // 写到数据库中
            proProjectMapper.updateByPrimaryKeySelective(proProject);
            return TableModel.success();
        }else if(tempStateToken.equals("51")){
            // 审批项目计划书，如果驳回则将计划书路径置空
            if(isPass == 2){
                proProject.setPlanUrl("null");
            }
            // 写到数据库中
            proProjectMapper.updateByPrimaryKeySelective(proProject);
            return TableModel.success();
        }else
        return TableModel.error("网络异常");
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
