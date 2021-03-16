package com.shu.copartner.pojo.response;

import lombok.Data;

import java.util.Date;

/**
 * @author
 * @date 2021/3/16 17:15
 * @description
 */
@Data
public class LessonTaskInfoSo {

    private Integer id;

    private Integer pid;

    private Long courseTaskId;

    private Long courseId;

    private String courseName;

    private String courseTaskContent;

    private Date publishDate;

    private Date updateDate;

    private Date deleteDate;

    private Integer isDeleted;

    private String courseTaskUrl;
}
