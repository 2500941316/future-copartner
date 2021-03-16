package com.shu.copartner.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProCarousel implements Serializable {
    private Long carouselId;

    private Integer carouselType;

    private String carouselUrl;

    private String carouselHref;

    private Date uploadDate;

    private Date deleteDate;

    private Integer isDeleted;

    private String description;

    private Integer isIssue;

    private String name;

    private String phone;

    private static final long serialVersionUID = 1L;

    public Long getCarouselId() {
        return carouselId;
    }

    public void setCarouselId(Long carouselId) {
        this.carouselId = carouselId;
    }

    public Integer getCarouselType() {
        return carouselType;
    }

    public void setCarouselType(Integer carouselType) {
        this.carouselType = carouselType;
    }

    public String getCarouselUrl() {
        return carouselUrl;
    }

    public void setCarouselUrl(String carouselUrl) {
        this.carouselUrl = carouselUrl == null ? null : carouselUrl.trim();
    }

    public String getCarouselHref() {
        return carouselHref;
    }

    public void setCarouselHref(String carouselHref) {
        this.carouselHref = carouselHref == null ? null : carouselHref.trim();
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getIsIssue() {
        return isIssue;
    }

    public void setIsIssue(Integer isIssue) {
        this.isIssue = isIssue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}