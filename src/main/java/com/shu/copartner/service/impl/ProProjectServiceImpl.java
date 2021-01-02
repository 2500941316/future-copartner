package com.shu.copartner.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.copartner.mapper.ActRuTaskMapper;
import com.shu.copartner.mapper.ProApplicationMapper;
import com.shu.copartner.mapper.ProFollowMapper;
import com.shu.copartner.mapper.ProProjectMapper;
import com.shu.copartner.pojo.*;
import com.shu.copartner.pojo.request.ProjectApplyVO;
import com.shu.copartner.service.ProProjectService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @date 2020/12/20 14:48
 * @description
 */
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class ProProjectServiceImpl implements ProProjectService {

    @Autowired
    private ProProjectMapper proProjectMapper;

    @Autowired
    private ProApplicationMapper proApplicationMapper;

    @Autowired
    private ProFollowMapper proFollowMapper;

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

  /**
     * 根据创建人查询项目
     * @param projectCreater
     * @return
     */
    @Override
    public TableModel selectByCreater(int currentPage,String projectCreater) {
        ProProjectExample proProjectExample = new ProProjectExample();
        PageHelper.startPage(currentPage, 4);
        proProjectExample.createCriteria().andProjectCreaterEqualTo(projectCreater).andIsDeletedEqualTo(0);
        List<ProProject>  proProjectsList = proProjectMapper.selectByExample(proProjectExample);

        PageInfo<ProProject> pageInfo = new PageInfo<>(proProjectsList);

        return TableModel.success(proProjectsList,(int)pageInfo.getTotal());
    }

   /* @Override
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
    }*/

    /**
     * 处理项目申请
     * @param projectApplyVO
     * @param creater
     * @return
     */
    @Override
    public TableModel projectApply(ProjectApplyVO projectApplyVO, String creater) {
        //补全项目信息
        projectApplyVO.setProjectStatus(Constants.PROJECT_STATE_TOKEN.get("21")); // 状态设置为 '审批项目申请'
        projectApplyVO.setProjectStateToken("21");
        projectApplyVO.setIsLock(0); // 默认未锁定
        projectApplyVO.setIsDeleted(0); // 默认未删除
        projectApplyVO.setPlanUrl("null"); // 项目计划书初始为空
        projectApplyVO.setVideoUrl("null");// 项目视频初始为空
        projectApplyVO.setProjectCreater(creater); // 设置当前项目申请者

        if (StringUtils.isNotEmpty(projectApplyVO.getProjectName())) {
            //将项目信息插入到项目表中，另外也将项目id等信息写到申请管理表中
            ProProject proProject = new ProProject();
            BeanUtils.copyProperties(projectApplyVO, proProject);
            //插入项目信息
            proProjectMapper.insert(proProject);
            log.info("新增项目的id："+proProject.getProjectId());

            // 写到申请管理表中
            ProApplication proApplication = new ProApplication();
            BeanUtils.copyProperties(proProject, proApplication);
            proApplication.setProjectStateToken("21"); // 审批表中将状态设置为 '审批项目申请'
            proApplication.setProjectState(Constants.PROJECT_STATE_TOKEN.get("21"));
            proApplication.setProjectId(proProject.getProjectId());
            proApplication.setApplicationTime(new Date());
            proApplicationMapper.insert(proApplication);
            return TableModel.success();
        } else {
            return TableModel.error("网络异常");
        }
    }

    /**
     * 处理项目修改
     * @param projectApplyVO
     * @return
     */
    @Override
    public TableModel updateProject(ProjectApplyVO projectApplyVO) {
        log.info("update");
        log.info(projectApplyVO.toString());
        ProProject proProject = new ProProject();
        BeanUtils.copyProperties(projectApplyVO, proProject);
        proProjectMapper.updateByPrimaryKeySelective(proProject);
        return TableModel.success();
    }

    /**
     * 根据id查询该项目
     * @param projectId
     * @param currentUser 用于判断当前用户是否已经关注该项目
     * @return
     */
    @Override
    public TableModel searchProjectById(String projectId,String currentUser) {
        if(StringUtils.isNotEmpty(projectId)){
            //根据id查询出数据添加到数组返回, 并判断当前用户关注该项目与否
            ProProject proProject = this.proProjectMapper.selectByPrimaryKey(Long.parseLong(projectId));
            ProFollow proFollow = proFollowMapper.selectByPidFollower(Long.parseLong(projectId),currentUser);
            if(ObjectUtils.isNotEmpty(proFollow)){
                // 代表已关注该项目
                proProject.setProjectFollowers("1");
            }
            // 将项目信息加入到数组里面返回
            List<ProProject> proProjects = new ArrayList<>();
            proProjects.add(proProject);
            return TableModel.success(proProjects,proProjects.size());
        }else{
            return  TableModel.error("网络异常");
        }
    }

    /**
     * 根据输入的值搜索
     * @param projectName
     * @param projectType
     * @param projectCreater
     * @param projectTwoStatus
     * @return
     */
    @Override
    public TableModel searchProjectByFour(int currentPage,String projectName, String projectType, String projectCreater, String projectTwoStatus) {
        ProProjectExample proProjectExample = new ProProjectExample();
        PageHelper.startPage(currentPage, 5);
        /*proProjectExample.createCriteria().andProjectStatusEqualTo(projectTwoStatus).andProjectNameEqualTo(projectName).andProjectTypeEqualTo(projectType)
                .andProjectCreaterEqualTo(projectCreater);*/
        ProProjectExample.Criteria criteria = proProjectExample.createCriteria();
        // 如果搜索值非空，就加上该搜索条件
        if(StringUtils.isNotEmpty(projectName)){
            criteria.andProjectNameEqualTo(projectName);
        }else if(StringUtils.isNotEmpty(projectType)){
            criteria.andProjectTypeEqualTo(projectType);
        }else if(StringUtils.isNotEmpty(projectCreater)){
            criteria.andProjectCreaterEqualTo(projectCreater);
        }
        criteria.andProjectStatusEqualTo(projectTwoStatus).andIsDeletedEqualTo(0);
        List<ProProject> proProjects = proProjectMapper.selectByExample(proProjectExample);
        PageInfo<ProProject> pageInfo = new PageInfo<>(proProjects);
        log.info("search:"+pageInfo.getTotal());
        return TableModel.success(proProjects,(int)pageInfo.getTotal());
    }

    /**
     * 查询其他项目数据
     * @param projectId
     * @return
     */
    /*@Override
    public TableModel searchOtherProjectById(String projectId) {
        if(StringUtils.isNotEmpty(projectId)){
            //根据id查询出数据添加到数组返回
            List<ProProject> proProjects = this.proProjectMapper.selectOtherProjectById(Long.parseLong(projectId));
            return TableModel.success(proProjects,proProjects.size());
        }else{
            return  TableModel.error("网络异常");
        }
    }*/

    @Override
    public TableModel searchOtherProjectById(int currentPage,String projectId) {
        if(StringUtils.isNotEmpty(projectId)){
            //根据id查询出数据添加到数组返回
            ProProjectExample proProjectExample = new ProProjectExample();
            PageHelper.startPage(currentPage, 3);
            proProjectExample.createCriteria().andProjectIdNotEqualTo(Long.parseLong(projectId)).andIsDeletedEqualTo(0);
            List<ProProject>  topNewsList = proProjectMapper.selectByExample(proProjectExample);

            PageInfo<ProProject> pageInfo = new PageInfo<>(topNewsList);
            log.info("pageInfo-total:"+pageInfo.getTotal());
            log.info(topNewsList.toString());

            return TableModel.success(topNewsList,(int)pageInfo.getTotal());
        }else{
            return  TableModel.error("网络异常");
        }
    }

    /**
     * 查询所有项目
     * @return
     */
    @Override
    public TableModel searchAllProject() {
        List<ProProject> proProjects = proProjectMapper.selectAllProject();
        return TableModel.success(proProjects,proProjects.size());
    }

    /**
     * 删除项目
     * @param projectId
     * @return
     */
    @Override
    public TableModel deleteProject(String projectId) {
        // 将该项目id_delete设置为1
        if(StringUtils.isNotEmpty(projectId)){
            ProProject proProject = new ProProject();
            proProject.setProjectId(Long.parseLong(projectId));
            proProject.setIsDeleted(1);
            proProjectMapper.updateByPrimaryKeySelective(proProject);
            return TableModel.success();
        }else {
            return TableModel.error("网络异常");
        }

    }

    /**
     * 关注项目
     * @param projectId
     * @return
     */
    @Override
    public TableModel focusProject(String projectId,String creater) throws ParseException {
        // 将当前用户及关注的项目id写到follow表
        ProFollow proFollow = new ProFollow();
        proFollow.setProjectId(Long.parseLong(projectId));
        proFollow.setFollower(creater);
        proFollow.setFollowTime(new Date());
        proFollow.setIsDelete(0);
        proFollowMapper.insert(proFollow);
        return TableModel.success();
    }

    /**
     * 根据当前用户 查询我的关注
     * @return
     */
    @Override
    public TableModel searchMyFollowProject(int currentPage,String follower) {
        PageHelper.startPage(currentPage,4);
        List<ProProject> proProjects = proProjectMapper.selectMyFollowProject(follower);
        PageInfo pageInfo = new PageInfo(proProjects);
        return TableModel.success(proProjects,(int)pageInfo.getTotal());
    }

    /**
     * 取消关注
     * @param projectId
     * @param follower
     * @return
     */
    @Override
    public TableModel cancelFollowProject(String projectId, String follower) {
        // 将该记录删除标志 置1，并设置取消关注的时间
        ProFollow proFollow = new ProFollow();
        proFollow.setIsDelete(1);
        proFollow.setUnfollowTime(new Date());
        ProFollowExample proFollowExample = new ProFollowExample();
        proFollowExample.createCriteria().andFollowerEqualTo(follower).andProjectIdEqualTo(Long.parseLong(projectId));
        proFollowMapper.updateByExampleSelective(proFollow,proFollowExample);
        return TableModel.success();
    }

    /**
     * 上传计划书
     * 先将计划书信息写到审批表中，审批通过后再写入项目表中，但是两个表的审批状态都要设置
     * @param planUrl
     * @param projectId
     */
    @Override
    public boolean uploadProjectPlan(String planUrl, String projectId) {
        ProProject proProject = new ProProject();
        // 设置项目的状态
        proProject.setProjectStatus(Constants.PROJECT_STATE_TOKEN.get("51"));// 状态设置为 ’项目计划书审批中‘
        proProject.setProjectStateToken("51");
        //proProject.setPlanUrl(planUrl); // 计划书路径
        proProject.setProjectId(Long.parseLong(projectId));
        // 更新项目状态
        int update =  proProjectMapper.updateByPrimaryKeySelective(proProject);

        // 更新审批表状态，并将计划书信息写到审批表中
        ProApplication proApplication = new ProApplication();
        proApplication.setProjectId(Long.parseLong(projectId));
        proApplication.setPlanUrl(planUrl);
        proApplication.setProjectStateToken("51");
        proApplication.setProjectState(Constants.PROJECT_STATE_TOKEN.get("51"));
        ProApplicationExample proApplicationExample = new ProApplicationExample();
        proApplicationExample.createCriteria().andProjectIdEqualTo(Long.parseLong(projectId));
        int updateAudit = proApplicationMapper.updateByExampleSelective(proApplication,proApplicationExample);
        log.info("updateAudit: "+ updateAudit);
        return updateAudit > 0 ? true : false;
    }

    /**
     * 上传视频
     * @param videoUrl
     * @param projectId
     */
    @Override
    public boolean uploadProjectVideo(String videoUrl, String projectId) {
        ProProject proProject = new ProProject();
        // 设置项目的状态
        proProject.setProjectStatus(Constants.PROJECT_STATE_TOKEN.get("41"));// 状态设置为 ’项目视频审批中‘
        proProject.setProjectStateToken("41");
       // proProject.setVideoUrl(videoUrl); // 计划书路径
        proProject.setProjectId(Long.parseLong(projectId));
        // 更新项目状态
        int update =  proProjectMapper.updateByPrimaryKeySelective(proProject);

        // 更新审批表状态，并将视频写到审批表中
        ProApplication proApplication = new ProApplication();
        proApplication.setProjectId(Long.parseLong(projectId));
        proApplication.setVideoUrl(videoUrl);
        proApplication.setProjectStateToken("41");
        proApplication.setProjectState(Constants.PROJECT_STATE_TOKEN.get("41"));
        ProApplicationExample proApplicationExample = new ProApplicationExample();
        proApplicationExample.createCriteria().andProjectIdEqualTo(Long.parseLong(projectId));
        int updateAudit = proApplicationMapper.updateByExampleSelective(proApplication,proApplicationExample);
        log.info("updateAudit: "+ updateAudit);
        return update > 0 ? true : false;
    }


}
