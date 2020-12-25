package com.shu.copartner.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LeassonApplyVO {
    private Long courseId;
    @NotBlank(message = "课程名称不能为空")
    private String courseName;
    @NotBlank(message = "课程类型不能为空")
    private String courseType;

    private String courseStatus;
    @NotBlank(message = "课程教师不能为空")
    private String courseTeacher;
    @NotBlank(message = "课程总时长不能为空")
    private String courseTotaltime;
    @NotBlank(message = "课程描述不能为空")
    private String courseDescription;
    @NotBlank(message = "课程总的blocks不能为空")
    private Integer courseTotalblocks;

    private Integer courseClicktime;

    LeassonApplyVO() {
        this.courseStatus = "1";
        this.courseClicktime = 0;
    }


}
