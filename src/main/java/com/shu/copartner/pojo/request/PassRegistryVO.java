package com.shu.copartner.pojo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shu.copartner.utils.constance.Constants;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author cxy
 */
@Data
public class PassRegistryVO {

    private Long id;
    @NotBlank(message = "手机号不能为空")
    private String phone;
    @NotBlank(message = "身份不能为空")
    private String auth;

    private Date applydate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String campus;

    private String company;

    private String education;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date gradutedate;

    private String major;

    private String workername;

    private String description;

    private Boolean supervisor;

    private String name;

    private String department;

    private String sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date admissiondate;

    private String studentnumber;

    private String teachernumber;

    private String mail;

    private String verifycode;

    private String expectproject;

    private String expectstudent;

    private String expectother;

    private String labelperson;

    private String labelalumnus;

    private String labelalumnicompany;

    private String labelincubator;

    private String labelinstitutions;

    private String labelother;

    private int applystatus = Constants.REGISTER_CODE[1];

    private Date registryDate = new Date();

}
