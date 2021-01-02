package com.shu.copartner.pojo;

import java.io.Serializable;

/**
 * @author cxy
 */
public class ProNewsWithBLOBs extends ProNews implements Serializable {
    private String newsIntroduction;

    private String newsContent;

    private static final long serialVersionUID = 1L;

    @Override
    public String getNewsIntroduction() {
        return newsIntroduction;
    }

    @Override
    public void setNewsIntroduction(String newsIntroduction) {
        this.newsIntroduction = newsIntroduction == null ? null : newsIntroduction.trim();
    }

    @Override
    public String getNewsContent() {
        return newsContent;
    }

    @Override
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }
}