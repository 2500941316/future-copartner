package com.shu.copartner.pojo.response;

import com.shu.copartner.pojo.ProLeasson;
import com.shu.copartner.pojo.ProLeassonVedio;
import lombok.Data;

import java.util.List;

/**
 * @author cxy
 */
@Data
public class LeassonCourse_Vedio_InfoSo {

    private String courseName;

    private String courseType;

    private String courseStatus;

    private String courseTeacher;

    private String courseTotaltime;

    private String courseDescription;

    private Integer courseTotalblocks;

    private Integer courseClicktime;

    private String status;

    private List<ProLeassonVedio> vedioList;

    private List<ProLeasson> clickCourseList;
}
