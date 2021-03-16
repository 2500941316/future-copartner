package com.shu.copartner.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author cxy
 */
@Data
public class NewsPublishVO implements Serializable {
    private Long newsId;

    @NotBlank(message = "新闻标题不能为空")
    private String newsTitle;
    @NotBlank(message = "新闻作者不能为空")
    private String newsAuthor;
    //@NotBlank(message = "新闻类别不能为空")
    private String newsCategory;
    @NotBlank(message = "新闻内容不能为空")
    private String newsContent;

    private Date newsPublistime;

    private Integer newsBrowsecount;
   // @NotBlank(message = "新闻是否置顶不能为空")
    private String istopping;

    private String isdeleted;
    @NotBlank(message = "新闻关键词不能为空")
    private String newsKeywords;

    private String isaudit;

    NewsPublishVO() {
        this.newsBrowsecount = 0;
        this.isdeleted = "0";
        this.isaudit = "0";
    }


}