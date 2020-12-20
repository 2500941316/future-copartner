package com.shu.copartner.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProProject implements Serializable {
    private Long id;

    private String creater;

    private String description;

    private Date endtime;

    private String followers;

    private Integer isDeleted;

    private Integer isLock;

    private String planUrl;

    private String primaryjob;

    private String projectName;

    private Date starttime;

    private String status;

    private String type;

    private String videoUrl;

    private String projectPeople;

    private String mainPeople;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
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

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers == null ? null : followers.trim();
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    public String getPlanUrl() {
        return planUrl;
    }

    public void setPlanUrl(String planUrl) {
        this.planUrl = planUrl == null ? null : planUrl.trim();
    }

    public String getPrimaryjob() {
        return primaryjob;
    }

    public void setPrimaryjob(String primaryjob) {
        this.primaryjob = primaryjob == null ? null : primaryjob.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getProjectPeople() {
        return projectPeople;
    }

    public void setProjectPeople(String projectPeople) {
        this.projectPeople = projectPeople == null ? null : projectPeople.trim();
    }

    public String getMainPeople() {
        return mainPeople;
    }

    public void setMainPeople(String mainPeople) {
        this.mainPeople = mainPeople == null ? null : mainPeople.trim();
    }

    @Override
    public String toString() {
        return "ProProject{" +
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