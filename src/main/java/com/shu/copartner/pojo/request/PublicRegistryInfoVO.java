package com.shu.copartner.pojo.request;

import lombok.Data;

import java.util.Date;

/**
 * @author cxy
 */
@Data
public class PublicRegistryInfoVO {

    private Long id;

    private String type;

    private Integer applystatus;

    private String advice;

    private String phone;

    private Date applydate;

    private Date birthday;

    private String campus;

    private String company;

    private String education;

    private Date gradutedate;

    private String major;

    private String workername;

    private String description;

    private Boolean supervisor;

    private String expect;

    private String name;

    private String department;

    private String sex;

    private Date admissiondate;

    private String studentnumber;

    private String teachernumber;

    private String mail;

    private String verifycode;
}
