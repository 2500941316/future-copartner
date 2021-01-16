package com.shu.copartner.service;

import com.shu.copartner.pojo.request.NewsManagerOperationVO;
import com.shu.copartner.pojo.request.ProjectManagerOperationVO;
import com.shu.copartner.utils.returnobj.TableModel;

/**
 * @author
 * @Date: 2020/12/21 15:18
 * @Description:
 */
public interface ManagerProjectService {
    TableModel searchProject(int page);

    TableModel searchAllProject(int page);

    TableModel searchProjectById(String projectId);

    TableModel operateProjectApply(ProjectManagerOperationVO projectManagerOperationVO);

    TableModel updateProjectIsGoing(String projectId,String isGoing);

    TableModel deleteProjectById(String projectId);

}
