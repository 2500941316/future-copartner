package com.shu.copartner.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static java.util.Locale.ENGLISH;

public class ProSupervisor implements Serializable {
    private Long supervisorId;

    private String supervisorName;

    private String supervisorStatus;

    private String supervisorInstitute;

    private String supervisorImage;

    private String supervisorDescription;

    private String supervisorEmail;

    private String supervisorTelephone;

    private String supervisorSchool;

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

    // 用于一对多
    private List<ProProject> projects;

    // 用于一对多
    private List<ProLog> logAchievements;

    private static final long serialVersionUID = 1L;

    public List<ProLog> getLogAchievements() {
        return logAchievements;
    }

    public void setLogAchievements(List<ProLog> logAchievements) {
        this.logAchievements = logAchievements;
    }

    public List<ProProject> getProjects() {
        return projects;
    }

    public void setProjects(List<ProProject> projects) {
        this.projects = projects;
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName == null ? null : supervisorName.trim();
    }

    public String getSupervisorStatus() {
        return supervisorStatus;
    }

    public void setSupervisorStatus(String supervisorStatus) {
        this.supervisorStatus = supervisorStatus == null ? null : supervisorStatus.trim();
    }

    public String getSupervisorInstitute() {
        return supervisorInstitute;
    }

    public void setSupervisorInstitute(String supervisorInstitute) {
        this.supervisorInstitute = supervisorInstitute == null ? null : supervisorInstitute.trim();
    }

    public String getSupervisorImage() {
        return supervisorImage;
    }

    public void setSupervisorImage(String supervisorImage) {
        this.supervisorImage = supervisorImage == null ? null : supervisorImage.trim();
    }

    public String getSupervisorDescription() {
        return supervisorDescription;
    }

    public void setSupervisorDescription(String supervisorDescription) {
        this.supervisorDescription = supervisorDescription == null ? null : supervisorDescription.trim();
    }

    public String getSupervisorEmail() {
        return supervisorEmail;
    }

    public void setSupervisorEmail(String supervisorEmail) {
        this.supervisorEmail = supervisorEmail == null ? null : supervisorEmail.trim();
    }

    public String getSupervisorTelephone() {
        return supervisorTelephone;
    }

    public void setSupervisorTelephone(String supervisorTelephone) {
        this.supervisorTelephone = supervisorTelephone == null ? null : supervisorTelephone.trim();
    }

    public String getSupervisorSchool() {
        return supervisorSchool;
    }

    public void setSupervisorSchool(String supervisorSchool) {
        this.supervisorSchool = supervisorSchool == null ? null : supervisorSchool.trim();
    }

    public String getSupervisorBriefIntro() {
        return supervisorBriefIntro;
    }

    public void setSupervisorBriefIntro(String supervisorBriefIntro) {
        this.supervisorBriefIntro = supervisorBriefIntro == null ? null : supervisorBriefIntro.trim();
    }

    public String getSupervisorAchievement() {
        return supervisorAchievement;
    }

    public void setSupervisorAchievement(String supervisorAchievement) {
        this.supervisorAchievement = supervisorAchievement == null ? null : supervisorAchievement.trim();
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getSupervisorRank() {
        return supervisorRank;
    }

    public void setSupervisorRank(Integer supervisorRank) {
        this.supervisorRank = supervisorRank;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}