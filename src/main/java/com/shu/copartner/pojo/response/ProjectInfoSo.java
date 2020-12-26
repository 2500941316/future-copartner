package com.shu.copartner.pojo.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author cxy
 */
@Data
public class ProjectInfoSo {
    // 用于传到前端，然后后端接受来判断具体的审批项
    private String taskId;

    private Long projectId;

    private String projectCreater;

    private String description;

    private Date endtime;

    private String projectFollowers;

    private Integer isDeleted;

    private Integer isLock;

    private String planUrl;

    private String primaryJob;


    private String projectName;

    private Date starttime;

    private String projectStatus;

    private String projectType;

    private String videoUrl;

    private String projectPeople;

    private String mainPeople;

    private String projectTeacher;

    private String projectNeed;

    private String projectMatch;

    private String projectCooperation;

    private String projectActivity;

    private String projectService;

    private String projectFinance;

    private String projectIncome;

    private String projectCompany;

    private String projectElseInfo;

    private String projectActivitiState;

    private String isAudit;

    private String projectAuditMsg;

}