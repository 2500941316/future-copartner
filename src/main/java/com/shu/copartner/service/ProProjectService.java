package com.shu.copartner.service;

import com.shu.copartner.pojo.ProProject;
import com.shu.copartner.pojo.request.ProjectApplyVO;
import com.shu.copartner.utils.returnobj.TableModel;

import java.text.ParseException;

/**
 * @author
 * @date 2020/12/20 14:47
 * @description
 */
public interface ProProjectService {
    int insert(ProProject record);

    TableModel selectByCreater(int currentPage, String projectCreater);

    TableModel projectApply(ProjectApplyVO projectApplyVO, String creater);

    TableModel updateProject(ProjectApplyVO projectApplyVO);

    TableModel searchProjectById(String projectId,String currentUser);

    TableModel searchProjectByFour(int currentPage, String projectName, String projectType, String projectCreater, String projectTwoStatus);

    TableModel searchOtherProjectById(String projectId);

    TableModel searchAllProject();

    TableModel getProjectBytype();

    TableModel deleteProject(String projectId);

    TableModel followProject(String projectId,String creater) throws ParseException;

    TableModel searchMyFollowProject(int currentPage,String follower);

    TableModel cancelFollowProject(String projectId,String follower);

    TableModel searchUserOfFollowMe(String projectId);

    boolean uploadProjectPlan(String planUrl, String projectId);

    boolean uploadProjectVideo(String videoUrl, String projectId);

    TableModel selectCount(String username);

    TableModel selectProjectBeFollowed(int currentPage,String username);

    TableModel applyJoinProject(String projectId,String username);

    TableModel cancelExitProject(String projectId,String phone);

    TableModel searchMemberApply(int page,String projectId);

    TableModel searchMemberByNamePhone(int page,String name,String phone,String projectId);

    TableModel handleMemberApply(String memberId,String isAudit);

    TableModel handleMemberInvite(String name,String phone,String projectId,String currentUserPhone);

    TableModel searchInvitationInfo(int page,String phone);

    TableModel handleInvitationInfo(String memberId,String isAudit);
}
