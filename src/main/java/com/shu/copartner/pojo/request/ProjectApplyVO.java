package com.shu.copartner.pojo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author cxy
 */
@Data
public class ProjectApplyVO implements Serializable {
    private Long projectId;

    private String projectCreater;

    private String description;

    private Date endtime;

    private String projectFollowers;

    private Integer isDeleted;

    private Integer isLock;

    private String planUrl;

    private String primaryJob;

    @NotBlank(message = "项目名称不能为空")
    private String projectName;

    @NotNull(message = "开始时间不能为空")
    private Date starttime;

    private String projectStatus;

    @NotBlank(message = "类型不能为空")
    private String projectType;

    private String videoUrl;

    private String projectPeople;

    @NotBlank(message = "负责人不能为空")
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

    private String projectStateToken;

    private String projectAuditMsg;

}