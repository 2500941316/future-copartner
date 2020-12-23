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
    private Long id;

    private String creater;

    private String description;

    private Date endtime;

    private String followers;

    private Integer isDeleted;

    private Integer isLock;

    private String planUrl;

    private String primaryjob;

    @NotBlank(message = "项目名称不能为空")
    private String projectName;

    @NotNull(message = "开始时间不能为空")
    private Date starttime;

    private String status;

    @NotBlank(message = "类型不能为空")
    private String type;

    private String videoUrl;

    private String projectPeople;

    @NotBlank(message = "负责人不能为空")
    private String mainPeople;

    @Override
    public String toString() {
        return "ProjectApplyVO{" +
                "id=" + id +
                ", creater='" + creater + '\'' +
                ", description='" + description + '\'' +
                ", endtime=" + endtime +
                ", followers='" + followers + '\'' +
                ", isDeleted=" + isDeleted +
                ", isLock=" + isLock +
                ", planUrl='" + planUrl + '\'' +
                ", primaryjob='" + primaryjob + '\'' +
                ", projectName='" + projectName + '\'' +
                ", starttime=" + starttime +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", projectPeople='" + projectPeople + '\'' +
                ", mainPeople='" + mainPeople + '\'' +
                '}';
    }
}