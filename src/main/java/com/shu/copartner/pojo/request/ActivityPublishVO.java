package com.shu.copartner.pojo.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author
 * @date 2021/1/12 15:21
 * @description
 */
@Data
public class ActivityPublishVO {
    private Long activityId;

    @NotBlank(message = "活动标题不能为空")
    private String activityTitle;
    @NotBlank(message = "活动内容不能为空")
    private String activityContent;

    private String activityStatus;

    private String activityAuthor;

    private String activityParticipator;

    private String activityImage;

    private Integer isPublish;

    private String clickCount;

    @NotNull(message = "活动开始时间不能为空")
    private String startTime;

    private Date updateTime;

    private Date endTime;

    private Integer isDeleted;

    ActivityPublishVO(){
        this.updateTime = new Date();
        this.isDeleted = 0;
    }
}
