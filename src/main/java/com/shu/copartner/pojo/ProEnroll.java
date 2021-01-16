package com.shu.copartner.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ProEnroll implements Serializable {
    private Long enrollId;

    private Long activityId;

    private Long personId;

    private String personName;

    @JsonFormat(pattern = "yyyy-MM-dd   HH:mm", timezone = "GMT+8")
    private Date enrollTime;

    private Date unerollTime;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public Long getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(Long enrollId) {
        this.enrollId = enrollId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    public Date getEnrollTime() {
        return enrollTime;
    }

    public void setEnrollTime(Date enrollTime) {
        this.enrollTime = enrollTime;
    }

    public Date getUnerollTime() {
        return unerollTime;
    }

    public void setUnerollTime(Date unerollTime) {
        this.unerollTime = unerollTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}