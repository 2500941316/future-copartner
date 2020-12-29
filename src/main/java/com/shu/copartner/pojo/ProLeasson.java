package com.shu.copartner.pojo;

import java.io.Serializable;

public class ProLeasson implements Serializable {
    private Long courseId;

    private String courseName;

    private String courseType;

    private String courseStatus;

    private String courseTeacher;

    private String courseTotaltime;

    private String courseDescription;

    private Integer courseTotalblocks;

    private Integer courseClicktime;

    private String courseIsdeleted;

    private static final long serialVersionUID = 1L;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType == null ? null : courseType.trim();
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus == null ? null : courseStatus.trim();
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher == null ? null : courseTeacher.trim();
    }

    public String getCourseTotaltime() {
        return courseTotaltime;
    }

    public void setCourseTotaltime(String courseTotaltime) {
        this.courseTotaltime = courseTotaltime == null ? null : courseTotaltime.trim();
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription == null ? null : courseDescription.trim();
    }

    public Integer getCourseTotalblocks() {
        return courseTotalblocks;
    }

    public void setCourseTotalblocks(Integer courseTotalblocks) {
        this.courseTotalblocks = courseTotalblocks;
    }

    public Integer getCourseClicktime() {
        return courseClicktime;
    }

    public void setCourseClicktime(Integer courseClicktime) {
        this.courseClicktime = courseClicktime;
    }

    public String getCourseIsdeleted() {
        return courseIsdeleted;
    }

    public void setCourseIsdeleted(String courseIsdeleted) {
        this.courseIsdeleted = courseIsdeleted == null ? null : courseIsdeleted.trim();
    }
}