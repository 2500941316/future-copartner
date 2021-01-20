package com.shu.copartner.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author
 * @date 2021/1/18 20:25
 * @description
 */
@Data
public class LivePublishVO {
    private Long liveId;

    @NotBlank(message = "直播标题不能为空")
    private String liveTitle;

    @NotBlank(message = "直播链接不能为空")
    private String liveUrl;

    @NotBlank(message = "直播时长不能为空")
    private String liveDuration;

    @NotBlank(message = "直播简述不能为空")
    private String liveDescription;

    private String liveStatus;

    private String liveImage;

    private String clickTimes;

    @NotNull(message = "活动开始时间不能为空")
    private String startTime;

    private Date updateTime;

    private Date endTime;

    private Integer isIssue;

    private Integer isDeleted;

    LivePublishVO(){
        this.updateTime = new Date();
        isDeleted = 0;
    }
}
