package com.shu.copartner.pojo;

import java.io.Serializable;

public class ProLeassonVedio implements Serializable {
    private Long courseVedioId;

    private Long courseId;

    private Integer courseVedioNumber;

    private String courseVedioIntroduction;

    private String courseVedioUrl;

    private String courseVedioName;

    private Integer courseVedioClicktime;

    private String courseVedioDuringtime;

    private String courseVedioStatus;

    private String courseVedioPptUrl;

    private String courseVedioCatalog;

    private static final long serialVersionUID = 1L;

    public Long getCourseVedioId() {
        return courseVedioId;
    }

    public void setCourseVedioId(Long courseVedioId) {
        this.courseVedioId = courseVedioId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getCourseVedioNumber() {
        return courseVedioNumber;
    }

    public void setCourseVedioNumber(Integer courseVedioNumber) {
        this.courseVedioNumber = courseVedioNumber;
    }

    public String getCourseVedioIntroduction() {
        return courseVedioIntroduction;
    }

    public void setCourseVedioIntroduction(String courseVedioIntroduction) {
        this.courseVedioIntroduction = courseVedioIntroduction == null ? null : courseVedioIntroduction.trim();
    }

    public String getCourseVedioUrl() {
        return courseVedioUrl;
    }

    public void setCourseVedioUrl(String courseVedioUrl) {
        this.courseVedioUrl = courseVedioUrl == null ? null : courseVedioUrl.trim();
    }

    public String getCourseVedioName() {
        return courseVedioName;
    }

    public void setCourseVedioName(String courseVedioName) {
        this.courseVedioName = courseVedioName == null ? null : courseVedioName.trim();
    }

    public Integer getCourseVedioClicktime() {
        return courseVedioClicktime;
    }

    public void setCourseVedioClicktime(Integer courseVedioClicktime) {
        this.courseVedioClicktime = courseVedioClicktime;
    }

    public String getCourseVedioDuringtime() {
        return courseVedioDuringtime;
    }

    public void setCourseVedioDuringtime(String courseVedioDuringtime) {
        this.courseVedioDuringtime = courseVedioDuringtime == null ? null : courseVedioDuringtime.trim();
    }

    public String getCourseVedioStatus() {
        return courseVedioStatus;
    }

    public void setCourseVedioStatus(String courseVedioStatus) {
        this.courseVedioStatus = courseVedioStatus == null ? null : courseVedioStatus.trim();
    }

    public String getCourseVedioPptUrl() {
        return courseVedioPptUrl;
    }

    public void setCourseVedioPptUrl(String courseVedioPptUrl) {
        this.courseVedioPptUrl = courseVedioPptUrl == null ? null : courseVedioPptUrl.trim();
    }

    public String getCourseVedioCatalog() {
        return courseVedioCatalog;
    }

    public void setCourseVedioCatalog(String courseVedioCatalog) {
        this.courseVedioCatalog = courseVedioCatalog == null ? null : courseVedioCatalog.trim();
    }
}