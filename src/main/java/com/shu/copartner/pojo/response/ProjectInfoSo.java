package com.shu.copartner.pojo.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author cxy
 */
@Data
public class ProjectInfoSo {
    private Long id;

    // 用于传到前端，然后后端接受来判断具体的审批项
    private String taskId;

    private String creater;

    private String description;

    private Date endtime;

    private String followers;

    private Integer isDeleted;

    private Integer isLock;

    private String planUrl;

    private String primaryjob;

    private String projectName;

    private Date starttime;

    private String status;

    private String type;

    private String videoUrl;

    private String projectPeople;

    private String mainPeople;

}