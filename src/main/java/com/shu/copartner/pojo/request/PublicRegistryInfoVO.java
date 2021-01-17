package com.shu.copartner.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class PublicRegistryInfoVO {
    private Long id;

    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotBlank(message = "性别不能为空")
    private String sex;
    @NotBlank(message = "电话不能为空")
    private String phone;
    @NotBlank(message = "邮箱不能为空")
    private String mail;
    @NotBlank(message = "生日不能为空")
    private Date birthday;
    @NotBlank(message = "类型不能为空")
    private String type;
    @NotBlank(message = "专业不能为空")
    private String major;
    @NotBlank(message = "学历不能为空")
    private String education;

    private String campus;
    @NotBlank(message = "验证码不能为空")
    private String verifycode;

    @NotBlank(message = "是否申请导师不能为空")
    private Boolean issupervisor;

    private String company;

    private String jobname;

    private String identity;

    private Integer applystatus;

    private Integer category;

    private Date applytime;

    private String description;

    private Date verifydate;

    private String advice;
}
