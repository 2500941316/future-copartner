package com.shu.copartner.pojo;

import java.io.Serializable;

public class ProNewsWithBLOBs extends ProNews implements Serializable {
    private String newsIntroduction;

    private String newsContent;

    private static final long serialVersionUID = 1L;

    public String getNewsIntroduction() {
        return newsIntroduction;
    }

    @Override
    public void setNewsIntroduction(String newsIntroduction) {
        this.newsIntroduction = newsIntroduction == null ? null : newsIntroduction.trim();
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }
}