package com.shu.copartner.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author cxy
 * @Date: 2020/12/21 18:52
 * @Description:
 */
@Data
public class NewsManagerOperationVO {
    @NotBlank(message = "任务id不能为空")
    private String taskId;
    private String msg;
    @NotBlank(message = "审批状态不能为空")
    private String status;

}
