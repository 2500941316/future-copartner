package com.shu.copartner.pojo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shu.copartner.utils.constance.Constants;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author cxy
 */
@Data
public class PublicRegistryInfoVO {

    private Long id;

    private String auth;

    private Integer applystatus;

    private String advice;

    private String phone;

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

    private String email;

    private String address;

    PublicRegistryInfoVO() {
        this.applydate = new Date();
        this.applystatus = Constants.REGISTER_CODE[0];
    }
}
