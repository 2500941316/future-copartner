package com.shu.copartner.service.impl.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ActRuVariableMapper;
import com.shu.copartner.mapper.ProApplicationMapper;
import com.shu.copartner.mapper.ProProjectMapper;
import com.shu.copartner.mapper.ProProjectMapper;
import com.shu.copartner.pojo.ProApplication;
import com.shu.copartner.pojo.ProFollow;
import com.shu.copartner.pojo.ProProject;
import com.shu.copartner.pojo.request.ProjectManagerOperationVO;
import com.shu.copartner.service.ManagerProjectService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @Date: 2020/12/21 15:19
 * @Description:
 */
@Slf4j
@Transactional(rollbackFor = Exception.class)
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

    @Autowired
    private ProApplicationMapper proApplicationMapper;

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

    /**
     * 查询待审批项目
     * @param page
     * @return
     */
    @Override
    public TableModel searchProject(int page) {
        try{
            // 查询出所有待审批的项目数据
            String[] tokens = {"21","31","41","51"};
            //List<ProProject> auditProject = proProjectMapper.selectProjectByToken(tokens);
            List<ProApplication> auditProject = proApplicationMapper.selectAuditInfo(tokens);
            return TableModel.tableSuccess(auditProject, (int)auditProject.size());
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 查询所有项目
     * @param page
     * @return
     */
    @Override
    public TableModel searchAllProject(int page) {
        try{
            String[] isgoing = {"在创","可选"};
            PageHelper.startPage(page,10);
            List<ProProject> allProject = proProjectMapper.selectAllProject(isgoing);
            PageInfo pageInfo = new PageInfo(allProject);
            return TableModel.tableSuccess(allProject, (int)pageInfo.getTotal());
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 审批时查看项目的具体信息，此时需要取出计划书和视频信息
     * @param projectId
     * @return
     */
    @Override
    public TableModel searchProjectById(String projectId) {
        try{
            // 查询项目信息
            ProProject proProject = this.proProjectMapper.selectByPrimaryKey(Long.parseLong(projectId));
            // 取出planURL，videoUrl
            List<ProApplication> proApplication = proApplicationMapper.selectByProjectId(Long.parseLong(projectId));
            for(ProApplication p : proApplication){
                if(!p.getVideoUrl().equals("null")){
                    proProject.setVideoUrl(p.getVideoUrl());
                }
                if(!p.getPlanUrl().equals("null")){
                    proProject.setPlanUrl(p.getPlanUrl());
                }
            }
            // 将项目信息加入到数组里面返回
            List<ProProject> proProjects = new ArrayList<>();
            proProjects.add(proProject);
            return TableModel.success(proProjects,proProjects.size());
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

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

        // 根据applicationId查询审批表中具体的审批项
        ProApplication proApplication =
                proApplicationMapper.selectByPrimaryKey(Long.parseLong(projectManagerOperationVO.getApplicationId()));
        // 更新审批表的状态信息
        proApplication.setProjectStateToken(nextToken);
        proApplication.setProjectState(Constants.PROJECT_STATE_TOKEN.get(nextToken));

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
            if(isPass == 1){
                // 如果项目申请通过，则项目进入在创状态
                proProject.setIsGoing(Constants.PROJECT_STATE_TOKEN.get("2"));
            }
            proProjectMapper.updateByPrimaryKeySelective(proProject);
            // 更新审批表信息
            proApplicationMapper.updateByPrimaryKeySelective(proApplication);
            return TableModel.success();
        }else if(tempStateToken.equals("41")){
            // 审批项目视频，如果审批通过，则将视频路径写到项目表中, 如果驳回则将驳回理由更新到审批表中
            if(isPass == 1){
                // 将视频路径设置都项目表
                proProject.setVideoUrl(proApplication.getVideoUrl());
            }else if(isPass == 2){
                proApplication.setResponse(projectManagerOperationVO.getProjectAuditMsg());
            }
            // 更新项目表信息
            proProjectMapper.updateByPrimaryKeySelective(proProject);
            // 更新审批表信息
            proApplicationMapper.updateByPrimaryKeySelective(proApplication);
            return TableModel.success();
        }else if(tempStateToken.equals("51")){
            // 审批项目计划书，如果审批通过，则将计划书路劲写到项目表中, 如果驳回则将驳回理由更新到审批表中
            if(isPass == 1){
                // 将计划书信息设置都项目表
                proProject.setPlanUrl(proApplication.getPlanUrl());
            }else if(isPass == 2){
                proApplication.setResponse(projectManagerOperationVO.getProjectAuditMsg());
            }
            // 写到数据库中
            proProjectMapper.updateByPrimaryKeySelective(proProject);
            // 更新审批表信息
            proApplicationMapper.updateByPrimaryKeySelective(proApplication);
            return TableModel.success();
        }else {
            return TableModel.error("网络异常");
        }
    }

    /**
     * 设置项目状态
     * @param projectId
     * @param isGoing
     * @return
     */
    @Override
    public TableModel updateProjectIsGoing(String projectId, String isGoing) {
        try{
            ProProject proProject = new ProProject();
            proProject.setProjectId(Long.parseLong(projectId));
            proProject.setIsGoing(isGoing);
            this.proProjectMapper.updateByPrimaryKeySelective(proProject);
            return TableModel.success();
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 删除项目，即置is_deleted值的为1
     * @param projectId
     * @return
     */
    @Override
    public TableModel deleteProjectById(String projectId) {
        try{
            ProProject proProject = new ProProject();
            proProject.setProjectId(Long.parseLong(projectId));
            proProject.setIsDeleted(1);
            this.proProjectMapper.updateByPrimaryKeySelective(proProject);
            return TableModel.success();
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
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
