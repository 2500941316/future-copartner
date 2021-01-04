package com.shu.copartner.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProLog implements Serializable {
    private Long logId;

    private String logType;

    private Date startTime;

    private Date endTime;

    private Date updateTime;

    private String logOperator;

    private Long logSupervisorId;

    private String logSupervisorName;

    private String logSupervisorAchievement;

    private Long logProjectId;

    private String logProjectName;

    private String logProjectDescription;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
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

    public String getLogOperator() {
        return logOperator;
    }

    public void setLogOperator(String logOperator) {
        this.logOperator = logOperator == null ? null : logOperator.trim();
    }

    public Long getLogSupervisorId() {
        return logSupervisorId;
    }

    public void setLogSupervisorId(Long logSupervisorId) {
        this.logSupervisorId = logSupervisorId;
    }

    public String getLogSupervisorName() {
        return logSupervisorName;
    }

    public void setLogSupervisorName(String logSupervisorName) {
        this.logSupervisorName = logSupervisorName == null ? null : logSupervisorName.trim();
    }

    public String getLogSupervisorAchievement() {
        return logSupervisorAchievement;
    }

    public void setLogSupervisorAchievement(String logSupervisorAchievement) {
        this.logSupervisorAchievement = logSupervisorAchievement == null ? null : logSupervisorAchievement.trim();
    }

    public Long getLogProjectId() {
        return logProjectId;
    }

    public void setLogProjectId(Long logProjectId) {
        this.logProjectId = logProjectId;
    }

    public String getLogProjectName() {
        return logProjectName;
    }

    public void setLogProjectName(String logProjectName) {
        this.logProjectName = logProjectName == null ? null : logProjectName.trim();
    }

    public String getLogProjectDescription() {
        return logProjectDescription;
    }

    public void setLogProjectDescription(String logProjectDescription) {
        this.logProjectDescription = logProjectDescription == null ? null : logProjectDescription.trim();
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}