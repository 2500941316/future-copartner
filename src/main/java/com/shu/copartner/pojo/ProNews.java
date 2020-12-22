package com.shu.copartner.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cxy
 */
public class ProNews implements Serializable {
    private Long newsId;

    private String newsTitle;

    private String newsIntroduction;

    private String newsContent;

    private String newsAuthor;

    private String newsCategory;

    private Date newsPublistime;

    private Integer newsBrowsecount;

    private String istopping;

    private String isdeleted;

    private String newsKeywords;

    private String isaudit;

    private String newsAdvice;

    private static final long serialVersionUID = 1L;

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public String getNewsIntroduction() {
        return newsIntroduction;
    }

    public void setNewsIntroduction(String newsIntroduction) {
        this.newsIntroduction = newsIntroduction == null ? null : newsIntroduction.trim();
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }

    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor == null ? null : newsAuthor.trim();
    }

    public String getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(String newsCategory) {
        this.newsCategory = newsCategory == null ? null : newsCategory.trim();
    }

    public Date getNewsPublistime() {
        return newsPublistime;
    }

    public void setNewsPublistime(Date newsPublistime) {
        this.newsPublistime = newsPublistime;
    }

    public Integer getNewsBrowsecount() {
        return newsBrowsecount;
    }

    public void setNewsBrowsecount(Integer newsBrowsecount) {
        this.newsBrowsecount = newsBrowsecount;
    }

    public String getIstopping() {
        return istopping;
    }

    public void setIstopping(String istopping) {
        this.istopping = istopping == null ? null : istopping.trim();
    }

    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted == null ? null : isdeleted.trim();
    }

    public String getNewsKeywords() {
        return newsKeywords;
    }

    public void setNewsKeywords(String newsKeywords) {
        this.newsKeywords = newsKeywords == null ? null : newsKeywords.trim();
    }

    public String getIsaudit() {
        return isaudit;
    }

    public void setIsaudit(String isaudit) {
        this.isaudit = isaudit == null ? null : isaudit.trim();
    }

    public String getNewsAdvice() {
        return newsAdvice;
    }

    public void setNewsAdvice(String newsAdvice) {
        this.newsAdvice = newsAdvice == null ? null : newsAdvice.trim();
    }
}