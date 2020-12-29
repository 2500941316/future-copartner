package com.shu.copartner.service;

import com.shu.copartner.pojo.ProProject;
import com.shu.copartner.pojo.ProProjectExample;
import com.shu.copartner.pojo.request.ProjectApplyVO;
import com.shu.copartner.utils.returnobj.TableModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author
 * @date 2020/12/20 14:47
 * @description
 */
public interface ProProjectService {
    int insert(ProProject record);

    TableModel selectByCreater(String projectCreater);

    TableModel projectApply(ProjectApplyVO projectApplyVO, String creater);

    TableModel searchProjectById(String projectId);

    TableModel searchProjectByFour(int currentPage,String projectName, String projectType, String projectCreater, String projectTwoStatus);

    TableModel searchOtherProjectById(int currentPage,String projectId);

    TableModel searchAllProject();

    boolean uploadProjectPlan(String planUrl,String projectId);

    boolean uploadProjectVideo(String videoUrl,String projectId);


}
