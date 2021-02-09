package com.shu.copartner.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.*;
import com.shu.copartner.pojo.*;
import com.shu.copartner.pojo.request.ProjectApplyVO;
import com.shu.copartner.service.ProProjectService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;


import java.awt.print.PrinterJob;
import java.lang.reflect.Member;
import java.security.PrivilegedExceptionAction;
import java.text.SimpleDateFormat;
import java.util.*;

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
    private ProUserMapper proUserMapper;

    @Autowired
    private ProStudentMapper proStudentMapper;

    @Autowired
    private ProTeacherMapper proTeacherMapper;

    @Autowired
    private ProPersonMapper proPersonMapper;

    @Autowired
    private ProMemberMapper proMemberMapper;

    /**
     * 新增项目信息到数据库
     *
     * @param record
     * @return
     */
    @Override
    public int insert(ProProject record) {
        return this.proProjectMapper.insert(record);
    }

    /**
     * 根据创建人查询项目
     *
     * @param projectCreater
     * @return
     */
    @Override
    public TableModel selectByCreater(int currentPage, String projectCreater) {
        try {
            // 先根据phone查询当前人姓名
            ProUserExample proUserExample = new ProUserExample();
            proUserExample.createCriteria().andPhoneEqualTo(projectCreater);
            List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
            String name = proUsers.get(0).getName();

            //查询我的项目
            ProProjectExample proProjectExample = new ProProjectExample();
            proProjectExample.setOrderByClause(Constants.PROJECT_DESCBYDATE);
            PageHelper.startPage(currentPage, 4);
            proProjectExample.createCriteria().andProjectCreaterEqualTo(name).andIsDeletedEqualTo(0);//.andIsGoingIsNotNull()
            List<ProProject> proProjectsList = proProjectMapper.selectByExample(proProjectExample);
            PageInfo<ProProject> pageInfo = new PageInfo<>(proProjectsList);

            //查询申请加入项目的人数
            ProMemberExample proMemberExample = new ProMemberExample();
            proMemberExample.createCriteria().andIsAuditEqualTo(0).andIsDeletedEqualTo(0);
            List<ProMember> proMembers = proMemberMapper.selectByExample(proMemberExample);
            for (ProProject pp : proProjectsList) {
                int applyJoinCount = 0;
                for (ProMember pm : proMembers) {
                    if (pm.getProjectId() == pp.getProjectId()) {
                        applyJoinCount++;
                    }
                }
                pp.setPrimaryJob(applyJoinCount + "");// 代表申请该项目的人数，临时用primaryJob存储
                //log.info(pp.getProjectId()+"："+applyJoinCount);
            }

            return TableModel.success(proProjectsList, (int) pageInfo.getTotal());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 处理项目申请
     *
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
        //projectApplyVO.setProjectCreater(creater); // 设置当前项目申请者

        try {
            // 先通过phone查询出当前项目申请者姓名,然后进行设置
            ProUserExample proUserExample = new ProUserExample();
            proUserExample.createCriteria().andPhoneEqualTo(creater);
            List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
            String name = proUsers.get(0).getName();
            projectApplyVO.setProjectCreater(name); // 设置当前项目申请者

            //将项目信息插入到项目表中，另外也将项目id等信息写到申请管理表中
            ProProject proProject = new ProProject();
            BeanUtils.copyProperties(projectApplyVO, proProject);
            //设置项目的指导教师id
            proProject.setSupervisorId(Long.parseLong(projectApplyVO.getSupervisorId()));
            proProject.setStarttime(new SimpleDateFormat("yyyy-MM-dd").parse(projectApplyVO.getStarttime()));
            proProject.setUpdateTime(new Date());
            //插入项目信息
            proProjectMapper.insert(proProject);

            //将当前申请者作为项目成员加入到成员表中
            ProMember proMember = new ProMember();
            proMember.setMemberName(name);
            proMember.setMemberPhone(creater);
            proMember.setProjectId(proProject.getProjectId());
            proMember.setJoinDate(new Date());
            proMember.setIsAudit(1); // 1带代表'已加入状态'
            proMember.setIsDeleted(0);
            proMember.setJoinStatus(Constants.MEMBER_PROJECT_STAUTS[1]); // 已加入状态
            proMemberMapper.insertSelective(proMember);

            // 写到申请管理表中
            ProApplication proApplication = new ProApplication();
            BeanUtils.copyProperties(proProject, proApplication);
            proApplication.setProjectStateToken("21"); // 审批表中将状态设置为 '审批项目申请'
            proApplication.setProjectState(Constants.PROJECT_STATE_TOKEN.get("21"));
            proApplication.setProjectId(proProject.getProjectId());
            proApplication.setApplicationTime(new Date());
            proApplicationMapper.insert(proApplication);
            return TableModel.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 处理项目修改
     *
     * @param projectApplyVO
     * @return
     */
    @Override
    public TableModel updateProject(ProjectApplyVO projectApplyVO) {
        try {
            //log.info(projectApplyVO.toString());
            ProProject proProject = new ProProject();
            BeanUtils.copyProperties(projectApplyVO, proProject);
            // 每次修改就设置当前更新的时间
            proProject.setUpdateTime(new Date());
            proProject.setSupervisorId(Long.parseLong(projectApplyVO.getSupervisorId()));
            proProjectMapper.updateByPrimaryKeySelective(proProject);
            return TableModel.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 根据id查询该项目
     *
     * @param projectId
     * @param phone 用于判断当前用户是否已经关注该项目
     * @return
     */
    @Override
    public TableModel searchProjectById(String projectId, String phone) {
        try {
            Map<String, List> map = new HashMap<>();
            //根据id查询出数据添加到数组返回, 并判断当前用户关注该项目与否
            ProProject proProject = this.proProjectMapper.selectByPrimaryKey(Long.parseLong(projectId));
            ProFollow proFollow = proFollowMapper.selectByPidFollower(Long.parseLong(projectId), phone);
            if (proFollow != null) {
                // 代表已关注该项目
                proProject.setProjectFollowers("1");
            }
            ProMemberExample proMemberExample = new ProMemberExample();
            proMemberExample.createCriteria().andMemberPhoneEqualTo(phone).andProjectIdEqualTo(Long.parseLong(projectId))
                    .andIsDeletedEqualTo(0).andIsAuditBetween(0, 1);
            List<ProMember> members = proMemberMapper.selectByExample(proMemberExample);
            if (members.size() > 0) {
                //代表 已经申请或者加入该项目
                proProject.setPrimaryJob(members.get(0).getJoinStatus());
            }

            //查询该项目成员
            ProMemberExample proMemberExample02 = new ProMemberExample();
            proMemberExample02.createCriteria().andProjectIdEqualTo(Long.parseLong(projectId)).andIsAuditEqualTo(1);
            List<ProMember> proMemberNames = proMemberMapper.selectByExample(proMemberExample02);
            map.put("projectMember", proMemberNames);

            // 将项目信息加入到数组里面返回
            List<ProProject> proProjects = new ArrayList<>();
            proProjects.add(proProject);
            map.put("projectInfo", proProjects);
            return TableModel.success(map, map.size());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 根据输入的值搜索
     *
     * @param projectName
     * @param projectType
     * @param projectCreater
     * @param projectTwoStatus
     * @return
     */
    @Override
    public TableModel searchProjectByFour(int currentPage, String projectName, String projectType, String projectCreater, String projectTwoStatus) {
        try {
            ProProjectExample proProjectExample = new ProProjectExample();
            PageHelper.startPage(currentPage, 8);
            /*proProjectExample.createCriteria().andProjectStatusEqualTo(projectTwoStatus).andProjectNameEqualTo(projectName).andProjectTypeEqualTo(projectType)
                    .andProjectCreaterEqualTo(projectCreater);*/
            proProjectExample.setOrderByClause(Constants.PROJECT_DESCBYDATE); // 按照开始时间倒序查询
            ProProjectExample.Criteria criteria = proProjectExample.createCriteria();
            // 如果搜索值非空，就加上该搜索条件 进行模糊查询
            if (!StringUtils.isEmpty(projectName)) {
                criteria.andProjectNameLike("%" + projectName + "%");
            } else if (!StringUtils.isEmpty(projectType)) {
                //criteria.andProjectTypeLike("%" + projectType + "%");
                criteria.andProjectTypeEqualTo(projectType);
            } else if (!StringUtils.isEmpty(projectCreater)) {
                criteria.andProjectCreaterLike("%" + projectCreater + "%");
            }
            criteria.andIsGoingEqualTo(projectTwoStatus).andIsDeletedEqualTo(0);
            List<ProProject> proProjects = proProjectMapper.selectByExample(proProjectExample);
            PageInfo<ProProject> pageInfo = new PageInfo<>(proProjects);
            return TableModel.success(proProjects, (int) pageInfo.getTotal());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 查询其他项目数据
     *
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
    public TableModel searchOtherProjectById(String projectId) {
        try {
            Map<String, List<ProProject>> map = new HashMap<>();
            //根据id查询出数据添加到数组返回
            ProProjectExample proProjectExample = new ProProjectExample();
            PageHelper.startPage(1, 3);
            proProjectExample.setOrderByClause(Constants.PROJECT_DESCBYDATE);
            proProjectExample.createCriteria().andProjectIdNotEqualTo(Long.parseLong(projectId))
                    .andIsDeletedEqualTo(0).andIsGoingIsNotNull();
            List<ProProject> otherProject = proProjectMapper.selectByExample(proProjectExample);
            //PageInfo<ProProject> pageInfo = new PageInfo<>(topNewsList);
            map.put("otherProject", otherProject);

            //随机查询3个项目
            List<ProProject> guessProject = proProjectMapper.selectRandom();
            map.put("guessProject", guessProject);
            return TableModel.success(map, map.size());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 查询所有项目
     *
     * @return
     */
    @Override
    public TableModel searchAllProject() {
        try {
            //String[] isGoing = {"在创", "可选"};
            List<ProProject> proProjects = proProjectMapper.selectAllProject();
            return TableModel.success(proProjects, proProjects.size());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 根据项目类型分别查询项目
     *
     * @return
     */
    @Override
    public TableModel getProjectBytype() {
        try {
            List<ProProject> finalProjectList = new ArrayList<>();
            // 每种type都循环一次
            for (int i = 0; i < Constants.PROJECT_CATAGORIES.length; i++) {
                String type = Constants.PROJECT_CATAGORIES[i];
                ProProjectExample proProjectExample = new ProProjectExample();
                proProjectExample.setOrderByClause(Constants.PROJECT_DESCBYDATE);// 按照时间倒序
                proProjectExample.createCriteria().andProjectTypeEqualTo(type);
                PageHelper.startPage(1, 6); // 每种类型最多查询6个
                List<ProProject> proProjects = proProjectMapper.selectByExample(proProjectExample);
                for (ProProject p : proProjects) {
                    finalProjectList.add(p);
                }
            }
            return TableModel.success(finalProjectList, finalProjectList.size());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 删除项目
     *
     * @param projectId
     * @return
     */
    @Override
    public TableModel deleteProject(String projectId) {
        // 将该项目id_delete设置为1
        try {
            ProProject proProject = new ProProject();
            proProject.setProjectId(Long.parseLong(projectId));
            proProject.setIsDeleted(1);
            proProjectMapper.updateByPrimaryKeySelective(proProject);
            return TableModel.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 关注项目
     *
     * @param projectId
     * @return
     */
    @Override
    public TableModel followProject(String projectId, String creater) {
        try {
            ProFollow proFollow001 = proFollowMapper.selectByPidFolloer02(Long.parseLong(projectId), creater);
            if (proFollow001 != null) {
                // 如果之前关注过该项目，则直接将is_delete置为0
                proFollow001.setFollowTime(new Date());
                proFollow001.setIsDelete(0);
                proFollowMapper.updateByPrimaryKeySelective(proFollow001);
            } else {
                // 先通过phone查询出当前项目关注者姓名
                ProUserExample proUserExample = new ProUserExample();
                proUserExample.createCriteria().andPhoneEqualTo(creater);
                List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
                String name = proUsers.get(0).getName();

                // 第一次关注该项目，将当前用户及关注的项目id写到follow表
                ProFollow proFollow = new ProFollow();
                proFollow.setProjectId(Long.parseLong(projectId));
                proFollow.setFollower(name);
                proFollow.setFollowTime(new Date());
                proFollow.setIsDelete(0);
                proFollowMapper.insert(proFollow);
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.success();
    }

    /**
     * 根据当前用户 查询我的关注
     *
     * @return
     */
    @Override
    public TableModel searchMyFollowProject(int currentPage, String phone) {
        try {
            // 先通过phone查询出当前项目关注者姓名
            ProUserExample proUserExample = new ProUserExample();
            proUserExample.createCriteria().andPhoneEqualTo(phone);
            List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
            String follower = proUsers.get(0).getName();

            // 每次查询4条
            PageHelper.startPage(currentPage, 4);
            List<ProProject> proProjects = proProjectMapper.selectMyFollowProject(follower);
            PageInfo pageInfo = new PageInfo(proProjects);
            return TableModel.success(proProjects, (int) pageInfo.getTotal());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 取消关注
     *
     * @param projectId
     * @param follower
     * @return
     */
    @Override
    public TableModel cancelFollowProject(String projectId, String follower) {
        try {
            // 将该记录删除标志 置1，并设置取消关注的时间，根据projectId和follower来确定该条记录
            ProFollow proFollow = new ProFollow();
            proFollow.setIsDelete(1);
            proFollow.setUnfollowTime(new Date());
            ProFollowExample proFollowExample = new ProFollowExample();
            proFollowExample.createCriteria().andFollowerEqualTo(follower).andProjectIdEqualTo(Long.parseLong(projectId));
            proFollowMapper.updateByExampleSelective(proFollow, proFollowExample);
            return TableModel.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }

    }

    /**
     * 根据项目id查询 关注当前项目的人
     *
     * @param projectId
     * @return
     */
    @Override
    public TableModel searchUserOfFollowMe(String projectId) {
        try {
            List<ProFollow> proFollows = proFollowMapper.selectUserOfFollowMe(Long.parseLong(projectId));
            return TableModel.tableSuccess(proFollows, proFollows.size());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 上传计划书
     * 先将计划书信息写到审批表中，审批通过后再写入项目表中，但是两个表的审批状态都要设置
     *
     * @param planUrl
     * @param projectId
     */
    @Override
    public boolean uploadProjectPlan(String planUrl, String projectId) {
        try {
            //log.info("上传项目计划书");
            ProProject proProject = new ProProject();
            // 设置项目的状态
            proProject.setProjectStatus(Constants.PROJECT_STATE_TOKEN.get("51"));// 状态设置为 ’项目计划书审批中‘
            proProject.setProjectStateToken("51");
            //proProject.setPlanUrl(planUrl); // 计划书路径
            proProject.setProjectId(Long.parseLong(projectId));
            // 更新项目状态
            int update = proProjectMapper.updateByPrimaryKeySelective(proProject);

            // 更新审批表状态，并将计划书信息写到审批表中
            List<ProApplication> proApplicationList = proApplicationMapper.selectByProjectId(Long.parseLong(projectId));
            if (proApplicationList.size() == 1 && proApplicationList.get(0).getProjectStateToken().equals("41")) {
                log.info("审批计划书1");
                //视频也正在审批中，则新增一条记录代表来审批计划书
                ProApplication proAppPlan = new ProApplication();
                BeanUtils.copyProperties(proApplicationList.get(0), proAppPlan);
                proAppPlan.setApplicationId(null);
                proAppPlan.setPlanUrl(planUrl);
                proAppPlan.setVideoUrl("null");
                proAppPlan.setProjectStateToken("51");
                proAppPlan.setProjectState(Constants.PROJECT_STATE_TOKEN.get("51"));
                int insert = proApplicationMapper.insert(proAppPlan);
                return insert > 0 ? true : false;
            } else if (proApplicationList.size() == 1 && !proApplicationList.get(0).getProjectStateToken().equals("51")) {
                //log.info("审批计划书2");
                // 视频不处于‘正在审批中’，直接更新为审批计划书状态
                ProApplication proApp = proApplicationList.get(0);
                proApp.setPlanUrl(planUrl);
                proApp.setProjectStateToken("51");
                proApp.setProjectState(Constants.PROJECT_STATE_TOKEN.get("51"));
                ProApplicationExample proApplicationExample = new ProApplicationExample();
                proApplicationExample.createCriteria().andProjectIdEqualTo(Long.parseLong(projectId));
                int updateAudit = proApplicationMapper.updateByExampleSelective(proApp, proApplicationExample);
                return updateAudit > 0 ? true : false;
            } else if (proApplicationList.size() > 1) {
                //log.info("审批计划书3");
                // 计划书，视频审批记录都存在，则直接更新计划书路径和审批状态
                for (ProApplication p : proApplicationList) {
                    if (!p.getPlanUrl().equals("null")) {
                        p.setPlanUrl(planUrl);
                        p.setProjectStateToken("51");
                        p.setProjectState(Constants.PROJECT_STATE_TOKEN.get("51"));
                        int updatePlan = proApplicationMapper.updateByPrimaryKeySelective(p);
                        return updatePlan > 0 ? true : false;
                    }
                }
            }
            return update > 0 ? true : false;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }

    }

    /**
     * 上传视频
     *
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
        int update = proProjectMapper.updateByPrimaryKeySelective(proProject);

        // 更新审批表状态，并将视频写到审批表中，
        List<ProApplication> proApplicationList = proApplicationMapper.selectByProjectId(Long.parseLong(projectId));
        if (proApplicationList.size() == 1 && proApplicationList.get(0).getProjectStateToken().equals("51")) {
            //计划书也正在审批中，则新增一条记录代表来审批视频
            ProApplication proAppVideo = new ProApplication();
            BeanUtils.copyProperties(proApplicationList.get(0), proAppVideo);
            proAppVideo.setApplicationId(null);
            proAppVideo.setPlanUrl("null");
            proAppVideo.setVideoUrl(videoUrl);
            proAppVideo.setProjectStateToken("41");
            proAppVideo.setProjectState(Constants.PROJECT_STATE_TOKEN.get("41"));
            int insert = proApplicationMapper.insert(proAppVideo);
            return insert > 0 ? true : false;
        } else if (proApplicationList.size() == 1 && !proApplicationList.get(0).getProjectStateToken().equals("51")) {
            // 计划书不处于‘正在审批中’，直接更新为审批视频状态
            ProApplication proApp = proApplicationList.get(0);
            proApp.setVideoUrl(videoUrl);
            proApp.setProjectStateToken("41");
            proApp.setProjectState(Constants.PROJECT_STATE_TOKEN.get("41"));
            ProApplicationExample proApplicationExample = new ProApplicationExample();
            proApplicationExample.createCriteria().andProjectIdEqualTo(Long.parseLong(projectId));
            int updateAudit = proApplicationMapper.updateByExampleSelective(proApp, proApplicationExample);
            return updateAudit > 0 ? true : false;
        } else if (proApplicationList.size() > 1) {
            // 计划书，视频审批记录都存在，则直接更新视频路径和审批状态
            for (ProApplication p : proApplicationList) {
                if (!p.getVideoUrl().equals("null")) {
                    p.setVideoUrl(videoUrl);
                    p.setProjectStateToken("41");
                    p.setProjectState(Constants.PROJECT_STATE_TOKEN.get("41"));
                    int updateVideo = proApplicationMapper.updateByPrimaryKeySelective(p);
                    return updateVideo > 0 ? true : false;
                }
            }
        }
        return update > 0 ? true : false;
    }

    /**
     * 分别查询我的项目，我的关注，关注我的个数
     *
     * @param phone
     * @return
     */
    @Override
    public TableModel selectCount(String phone) {
        try {
            // 先通过phone查询出当前人姓名
            ProUserExample proUserExample = new ProUserExample();
            proUserExample.createCriteria().andPhoneEqualTo(phone);
            List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
            String username = proUsers.get(0).getName();

            Map<String, Long> countMap = new HashMap<>();
            //我的项目 个数
            Long countOfProject = proProjectMapper.selectCountOfProject(username);
            countMap.put("countOfProject", countOfProject);

            // 我关注的项目 个数
            Long countOfMyFollow = proFollowMapper.selectCountOfMyFollow(username);
            countMap.put("countOfMyFollow", countOfMyFollow);

            // 关注我的项目 个数
            Long countOfFollowMe = proFollowMapper.selectCountOfFollowMe(username);
            countMap.put("countOfFollowMe", countOfFollowMe);

            Long countOfMyInvitation = proMemberMapper.selectCountOfMyInvitation(phone);
            countMap.put("countOfMyInvitation", countOfMyInvitation);

            return TableModel.success(countMap, countMap.size());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }

    }

    /**
     * 查询我被关注的项目
     *
     * @param phone
     * @return
     */
    @Override
    public TableModel selectProjectBeFollowed(int currentPage, String phone) {
        try {
            // 先通过phone查询出当前人姓名
            ProUserExample proUserExample = new ProUserExample();
            proUserExample.createCriteria().andPhoneEqualTo(phone);
            List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
            String username = proUsers.get(0).getName();

            PageHelper.startPage(currentPage, 4);
            List<ProProject> proProjectList = proProjectMapper.selectProjectBeFollowed(username);
            PageInfo pageInfo = new PageInfo(proProjectList);
            return TableModel.success(proProjectList, proProjectList.size());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }

    }

    /**
     * 申请加入项目
     *
     * @param projectId
     * @param username
     * @return
     */
    @Override
    public TableModel applyJoinProject(String projectId, String username) {
        try {
            // 根据phone查询我的角色
            ProUserExample proUserExample = new ProUserExample();
            proUserExample.createCriteria().andPhoneEqualTo(username);
            List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
            String auth = proUsers.get(0).getAuth();
            // 根据角色及phone查询我的个人信息
            String myname = null;
            switch (auth) {
                case "ROLE_STUDENT":
                    ProStudentExample proStudentExample = new ProStudentExample();
                    proStudentExample.createCriteria().andPhoneEqualTo(username);
                    List<ProStudent> proStudentList = proStudentMapper.selectByExample(proStudentExample);
                    proStudentList.get(0).setAuth("ROLE_STUDENT");// 设置角色
                    myname = proStudentList.get(0).getName();
                    break;
                case "ROLE_TEACHER":
                    ProTeacherExample proTeacherExample = new ProTeacherExample();
                    proTeacherExample.createCriteria().andPhoneEqualTo(username);
                    List<ProTeacher> proTeacherList = proTeacherMapper.selectByExample(proTeacherExample);
                    proTeacherList.get(0).setAuth("ROLE_TEACHER");// 设置角色
                    myname = proTeacherList.get(0).getName();
                    break;
                case "ROLE_PERSON":
                    ProPersonExample proPersonExample = new ProPersonExample();
                    proPersonExample.createCriteria().andPhoneEqualTo(username);
                    List<ProPerson> proPersonList = proPersonMapper.selectByExample(proPersonExample);
                    proPersonList.get(0).setAuth("ROLE_PERSON");// 设置角色
                    myname = proPersonList.get(0).getName();
                    break;
                default:
                    break;
            }
            ProMemberExample proMemberExample = new ProMemberExample();
            proMemberExample.createCriteria().andMemberPhoneEqualTo(username).andProjectIdEqualTo((Long.parseLong(projectId)));
            List<ProMember> proMembers = proMemberMapper.selectByExample(proMemberExample);
            if (proMembers.size() > 0) {
                // 如果之前加入过该项目，则直接置is_deleted为o
                ProMember proMemberCurrent = proMembers.get(0);
                proMemberCurrent.setIsDeleted(0);
                proMemberCurrent.setApplyDate(new Date());
                proMemberCurrent.setIsAudit(0);
                proMemberCurrent.setJoinStatus(Constants.MEMBER_PROJECT_STAUTS[0]);
                proMemberMapper.updateByPrimaryKeySelective(proMemberCurrent);
            } else {
                //第一次申请加入该项目，设置成员申请信息
                ProMember proMember = new ProMember();
                proMember.setMemberName(myname);
                proMember.setMemberPhone(username);
                proMember.setProjectId(Long.parseLong(projectId));
                proMember.setApplyDate(new Date());
                proMember.setIsAudit(0); // 0带代表'已申请状态'
                proMember.setIsDeleted(0);
                proMember.setJoinStatus(Constants.MEMBER_PROJECT_STAUTS[0]);
                proMemberMapper.insertSelective(proMember);
            }
            return TableModel.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }

    }

    /**
     * 退出项目
     *
     * @param projectId
     * @return
     */
    @Override
    public TableModel cancelExitProject(String projectId, String phone) {
        try {
            //设置成员信息
            ProMember proMember = new ProMember();
            proMember.setProjectId(Long.parseLong(projectId));
            proMember.setMemberPhone(phone);
            proMember.setExitDate(new Date());
            proMember.setIsAudit(3); // 3代表已退出
            proMember.setJoinStatus(Constants.MEMBER_PROJECT_STAUTS[3]);
            proMember.setIsDeleted(1);
            // 更新到数据库中
            ProMemberExample proMemberExample = new ProMemberExample();
            proMemberExample.createCriteria().andProjectIdEqualTo(Long.parseLong(projectId)).andMemberPhoneEqualTo(phone);
            proMemberMapper.updateByExampleSelective(proMember, proMemberExample);
            return TableModel.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 查询人员申请信息
     *
     * @param page
     * @return
     */
    @Override
    public TableModel searchMemberApply(int page, String projectId) {
        try {
            //log.info(projectId);
            if (StringUtils.isEmpty(projectId)) {
                projectId = Integer.toString(0);
            }
            ProMemberExample proMemberExample = new ProMemberExample();
            proMemberExample.createCriteria().andIsAuditEqualTo(0).andIsDeletedEqualTo(0)
                    .andProjectIdEqualTo(Long.parseLong(projectId));
            PageHelper.startPage(page, 10);
            List<ProMember> proMembers = proMemberMapper.selectByExample(proMemberExample);
            PageInfo pageInfo = new PageInfo(proMembers);
            return TableModel.tableSuccess(proMembers, (int)pageInfo.getTotal());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 根据name，phone查询人员
     *
     * @param page
     * @param name
     * @param phone
     * @return
     */
    @Override
    public TableModel searchMemberByNamePhone(int page, String name, String phone,String projectId) {
        try {
            // 首先在成员表member中查询该项目已加入的成员，搜索时需要排除
            ProMemberExample proMemberExample = new ProMemberExample();
            // 查询出 已申请，已加入，已邀请的人员，在后面查询条件下排除
            proMemberExample.createCriteria().andProjectIdEqualTo(Long.parseLong(projectId)).andIsAuditNotBetween(2,3);
            List<ProMember> proMembers = proMemberMapper.selectByExample(proMemberExample);

            //在用户表中查询用户人员
            PageHelper.startPage(page, 10);
            ProUserExample proUserExample = new ProUserExample();
            ProUserExample.Criteria criteria= proUserExample.createCriteria();
            if(proMembers.size()>0){
                // 排除 已申请，已加入，已邀请的人员
                List<String> memberPhoneList = new ArrayList<>();
                for(ProMember pm : proMembers){
                    memberPhoneList.add(pm.getMemberPhone());
                }
                criteria.andPhoneNotIn(memberPhoneList);
            }
            if(StringUtils.isNotEmpty(name)){
                // 按姓名模糊查询
                criteria.andNameLike("%" + name + "%");
            }
            if(StringUtils.isNotEmpty(phone)){
                // 按手机号模糊查询
                criteria.andPhoneLike("%" + phone + "%");
            }
            List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
            PageInfo pageInfo = new PageInfo(proUsers);
            return TableModel.tableSuccess(proUsers, (int)pageInfo.getTotal());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 处理人员申请
     *
     * @param memberId
     * @param isAudit
     * @return
     */
    @Override
    public TableModel handleMemberApply(String memberId, String isAudit) {
        try {
            ProMember proMember = new ProMember();
            proMember.setMemberId(Long.parseLong(memberId));
            proMember.setIsAudit(Integer.parseInt(isAudit));
            proMember.setJoinStatus(Constants.MEMBER_PROJECT_STAUTS[Integer.parseInt(isAudit)]);
            if("1".equals(isAudit)){
                //同意该申请
                proMember.setJoinDate(new Date());
            }else if("2".equals(isAudit)){
                //拒绝该申请
                proMember.setExitDate(new Date());
            }
            proMemberMapper.updateByPrimaryKeySelective(proMember);
            return TableModel.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }

    }

    /**
     * 处理人员邀请
     * @param name
     * @param phone
     * @param projectId
     * @param currentUserPhone
     * @return
     */
    @Override
    public TableModel handleMemberInvite(String name,String phone,String projectId,String currentUserPhone) {
        try{
            // 先查询出当前邀请人姓名，后面添加到邀请信息中
            ProUserExample proUserExample = new ProUserExample();
            proUserExample.createCriteria().andPhoneEqualTo(currentUserPhone);
            List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
            String inviterName = proUsers.get(0).getName();
            //如果是之前 拒绝或者退出 的该项目的人员，则直接将表状态更新为 ‘已邀请’
            ProMemberExample proMemberExample = new ProMemberExample();
            proMemberExample.createCriteria().andProjectIdEqualTo(Long.parseLong(projectId)).andMemberPhoneEqualTo(phone);
            List<ProMember> proMembers = proMemberMapper.selectByExample(proMemberExample);
            if(proMembers.size()>0){
                // 一次操作只邀请一个人，所以处理完直接返回即可，循环就一次
                for(ProMember pm : proMembers){
                    pm.setIsAudit(4); // 4代表 已邀请
                    pm.setJoinStatus(Constants.MEMBER_PROJECT_STAUTS[4]);
                    pm.setInviteDate(new Date(System.currentTimeMillis()));
                    pm.setInviterName(inviterName);// 设置邀请人名称
                    proMemberMapper.updateByPrimaryKeySelective(pm);
                    return TableModel.success();
                }
            }
            // 如果邀请的人员是第一次加入该项目，则在表中新增一条贾璐
            ProMember proMember = new ProMember();
            proMember.setMemberName(name);
            proMember.setMemberPhone(phone);
            proMember.setInviterName(inviterName);// 设置邀请人名称
            proMember.setProjectId(Long.parseLong(projectId));
            proMember.setIsAudit(4); // 4代表 已邀请
            proMember.setJoinStatus(Constants.MEMBER_PROJECT_STAUTS[4]);// 已邀请 状态
            proMember.setInviteDate(new Date(System.currentTimeMillis()));
            proMember.setIsDeleted(0);
            proMemberMapper.insertSelective(proMember);
            return TableModel.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }


    /**
     * 查询本人被邀请的信息
     * @param page
     * @param phone 本人手机号
     * @return
     */
    @Override
    public TableModel searchInvitationInfo(int page, String phone) {
        try{
            PageHelper.startPage(page,10);// 表格每页10条
            List<ProMember> proMembers = proMemberMapper.selectInvitationInfo(phone);
            PageInfo pageInfo = new PageInfo(proMembers);
            return TableModel.tableSuccess(proMembers,(int)pageInfo.getTotal());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 处理邀请函信息，同意或者拒绝该邀请
     * @param memberId
     * @param isAudit
     * @return
     */
    @Override
    public TableModel handleInvitationInfo(String memberId, String isAudit) {
        try {
            ProMember proMember = new ProMember();
            proMember.setMemberId(Long.parseLong(memberId));
            proMember.setIsAudit(Integer.parseInt(isAudit));
            proMember.setJoinStatus(Constants.MEMBER_PROJECT_STAUTS[Integer.parseInt(isAudit)]);
            if("1".equals(isAudit)){
                //同意该邀请
                proMember.setJoinDate(new Date());
            }else if("2".equals(isAudit)){
                //拒绝该邀请
                proMember.setExitDate(new Date());
            }
            proMemberMapper.updateByPrimaryKeySelective(proMember);
            return TableModel.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }


}
