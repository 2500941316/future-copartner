package com.shu.copartner.service;

import com.shu.copartner.pojo.ProProject;
import com.shu.copartner.pojo.request.ProjectApplyVO;
import com.shu.copartner.utils.returnobj.TableModel;

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

    TableModel searchProjectById(String projectId);

    TableModel searchProjectByFour(int currentPage, String projectName, String projectType, String projectCreater, String projectTwoStatus);

    TableModel searchOtherProjectById(int currentPage, String projectId);

    TableModel searchAllProject();

    TableModel deleteProject(String projectId);

    boolean uploadProjectPlan(String planUrl, String projectId);

    boolean uploadProjectVideo(String videoUrl, String projectId);


}
