package com.shu.copartner.pojo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author
 * @date 2021/1/5 13:03
 * @description
 */
@Data
public class SupervisorPublishVO {
    private Long supervisorId;
    @NotBlank(message = "导师名称不能为空")
    private String supervisorName;
    @NotBlank(message = "导师状态不能为空")
    private String supervisorStatus;
    @NotBlank(message = "所属学院不能为空")
    private String supervisorInstitute;

    private String supervisorImage;
    @NotBlank(message = "推荐页简述不能为空")
    private String supervisorDescription;
    @NotBlank(message = "导师邮箱不能为空")
    private String supervisorEmail;

    private String supervisorTelephone;
    @NotBlank(message = "所在学校不能为空")
    private String supervisorSchool;
    @NotBlank(message = "导师简介不能为空")
    private String supervisorBriefIntro;

    private String supervisorAchievement;

    private Integer projectId;

    private Integer logId;

    private Integer supervisorRank;

    private Integer isDeleted;

    private Date startTime;

    private Date endTime;

    @JsonFormat(pattern = "MM.dd ", timezone = "GMT+8")//,locale="locale.ENGLISH"
    private Date updateTime;

    SupervisorPublishVO(){
        this.updateTime = new Date();
        this.isDeleted = 0;
       // this.startTime = new Date();
    }
}
