package com.shu.copartner.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ProLive implements Serializable {
    private Long liveId;

    private String liveTitle;

    private String liveUrl;

    private String liveDescription;

    private Integer liveDuration;

    private String liveStatus;

    private String liveImage;

    private String clickTimes;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date startTime;

    private Date updateTime;

    private Date endTime;

    private Integer isIssue;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public Long getLiveId() {
        return liveId;
    }

    public void setLiveId(Long liveId) {
        this.liveId = liveId;
    }

    public String getLiveTitle() {
        return liveTitle;
    }

    public void setLiveTitle(String liveTitle) {
        this.liveTitle = liveTitle == null ? null : liveTitle.trim();
    }

    public String getLiveUrl() {
        return liveUrl;
    }

    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl == null ? null : liveUrl.trim();
    }

    public String getLiveDescription() {
        return liveDescription;
    }

    public void setLiveDescription(String liveDescription) {
        this.liveDescription = liveDescription == null ? null : liveDescription.trim();
    }

    public Integer getLiveDuration() {
        return liveDuration;
    }

    public void setLiveDuration(Integer liveDuration) {
        this.liveDuration = liveDuration;
    }

    public String getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(String liveStatus) {
        this.liveStatus = liveStatus == null ? null : liveStatus.trim();
    }

    public String getLiveImage() {
        return liveImage;
    }

    public void setLiveImage(String liveImage) {
        this.liveImage = liveImage == null ? null : liveImage.trim();
    }

    public String getClickTimes() {
        return clickTimes;
    }

    public void setClickTimes(String clickTimes) {
        this.clickTimes = clickTimes == null ? null : clickTimes.trim();
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

    public Integer getIsIssue() {
        return isIssue;
    }

    public void setIsIssue(Integer isIssue) {
        this.isIssue = isIssue;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}