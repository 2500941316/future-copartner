package com.shu.copartner.pojo.response;


import lombok.Data;

import java.util.Date;

/**
 * @author cxy
 */
@Data
public class NewsInfoSo {
    private Long newsId;
    private String taskId;
    private String newsTitle;
    private String newsAuthor;
    private String newsCategory;
    private String newsContent;

    private Date newsPublistime;

    private Integer newsBrowsecount;
    private String istopping;

    private String isdeleted;
    private String newsKeywords;

    private String isaudit;

}