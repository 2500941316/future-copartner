package com.shu.copartner.pojo.request;

import javafx.application.Application;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author cxy
 * @Date: 2020/12/21 18:52
 * @Description:
 */
@Data
public class ProjectManagerOperationVO {
 /*   @NotBlank(message = "任务id不能为空")
    private String taskId;*/

    @NotBlank(message = "审批id不能为空")
    private String applicationId;

    @NotBlank(message = "项目id不能为空")
    private String projectId;

    @NotBlank(message = "项目状态标志不能为空")
    private String projectStateToken;

    private String projectAuditMsg;

    @NotBlank(message = "审批状态不能为空")
    private String isPass;

}
