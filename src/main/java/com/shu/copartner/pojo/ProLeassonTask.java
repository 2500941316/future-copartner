package com.shu.copartner.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProLeassonTask implements Serializable {
    private Long courseTaskId;

    private Long courseId;

    private String courseName;

    private String courseTaskContent;

    private Date publishDate;

    private Date updateDate;

    private Date deleteDate;

    private Integer isDeleted;

    private String courseTaskUrl;

    private static final long serialVersionUID = 1L;

    public Long getCourseTaskId() {
        return courseTaskId;
    }

    public void setCourseTaskId(Long courseTaskId) {
        this.courseTaskId = courseTaskId;
    }

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

    public String getCourseTaskContent() {
        return courseTaskContent;
    }

    public void setCourseTaskContent(String courseTaskContent) {
        this.courseTaskContent = courseTaskContent == null ? null : courseTaskContent.trim();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCourseTaskUrl() {
        return courseTaskUrl;
    }

    public void setCourseTaskUrl(String courseTaskUrl) {
        this.courseTaskUrl = courseTaskUrl == null ? null : courseTaskUrl.trim();
    }
}