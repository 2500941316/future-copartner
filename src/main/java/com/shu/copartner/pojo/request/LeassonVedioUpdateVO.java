package com.shu.copartner.pojo.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class LeassonVedioUpdateVO {
    private Integer id;
    @Min(1)
    private Integer pid;
    @Min(1)
    private Long courseVedioId;
    @Min(1)
    private Long courseId;
    @Min(1)
    private Integer courseVedioNumber;

    private String courseVedioIntroduction;

    private String courseVedioUrl;

    private String courseVedioName;

    private Integer courseVedioClicktime;

    private String courseVedioDuringtime;

    private String courseVedioStatus;

    private String courseVedioPptUrl;

    private String courseVedioCatalog;
    @NotBlank(message = "课程名称不能为空")
    private String courseName;

    private String courseType;

    private String courseStatus;

    private String courseTeacher;

    private String courseTotaltime;

    private String courseDescription;

    private Integer courseTotalblocks;

    private Integer courseClicktime;

    private String status;

}
