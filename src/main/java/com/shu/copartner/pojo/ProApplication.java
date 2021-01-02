package com.shu.copartner.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProApplication implements Serializable {
    private Long applicationId;

    private Date applicationTime;

    private Integer applyStatus;

    private String description;

    private Date endtime;

    private Integer isDeleted;

    private Integer isouttime;

    private Long projectId;

    private String response;

    private Date starttime;

    private String title;

    private Long uid;

    private String planUrl;

    private String videoUrl;

    private String projectCreater;

    private String projectName;

    private String projectStateToken;

    private String projectState;

    private static final long serialVersionUID = 1L;

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getIsouttime() {
        return isouttime;
    }

    public void setIsouttime(Integer isouttime) {
        this.isouttime = isouttime;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response == null ? null : response.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getPlanUrl() {
        return planUrl;
    }

    public void setPlanUrl(String planUrl) {
        this.planUrl = planUrl == null ? null : planUrl.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getProjectCreater() {
        return projectCreater;
    }

    public void setProjectCreater(String projectCreater) {
        this.projectCreater = projectCreater == null ? null : projectCreater.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectStateToken() {
        return projectStateToken;
    }

    public void setProjectStateToken(String projectStateToken) {
        this.projectStateToken = projectStateToken == null ? null : projectStateToken.trim();
    }

    public String getProjectState() {
        return projectState;
    }

    public void setProjectState(String projectState) {
        this.projectState = projectState == null ? null : projectState.trim();
    }
}