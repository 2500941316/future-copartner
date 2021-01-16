package com.shu.copartner.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ProActivity implements Serializable {
    private Long activityId;

    private String activityTitle;

    private String activityContent;

    private String activityStatus;

    private String activityAuthor;

    private String activityParticipator;

    private String activityImage;

    private Integer isPublish;

    private String clickCount;

    @JsonFormat(pattern = "yyyy-MM-dd   HH:mm", timezone = "GMT+8")
    private Date startTime;

    private Date updateTime;

    private Date endTime;

    private Integer isDeleted;

    private Integer isEnrolled;

    private static final long serialVersionUID = 1L;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle == null ? null : activityTitle.trim();
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent == null ? null : activityContent.trim();
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus == null ? null : activityStatus.trim();
    }

    public String getActivityAuthor() {
        return activityAuthor;
    }

    public void setActivityAuthor(String activityAuthor) {
        this.activityAuthor = activityAuthor == null ? null : activityAuthor.trim();
    }

    public String getActivityParticipator() {
        return activityParticipator;
    }

    public void setActivityParticipator(String activityParticipator) {
        this.activityParticipator = activityParticipator == null ? null : activityParticipator.trim();
    }

    public String getActivityImage() {
        return activityImage;
    }

    public void setActivityImage(String activityImage) {
        this.activityImage = activityImage == null ? null : activityImage.trim();
    }

    public Integer getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    public String getClickCount() {
        return clickCount;
    }

    public void setClickCount(String clickCount) {
        this.clickCount = clickCount == null ? null : clickCount.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getIsEnrolled() {
        return isEnrolled;
    }

    public void setIsEnrolled(Integer isEnrolled) {
        this.isEnrolled = isEnrolled;
    }
}