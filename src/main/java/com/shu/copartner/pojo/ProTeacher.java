package com.shu.copartner.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProTeacher implements Serializable {
    private Long teacherid;

    private String teachernumber;

    private String mail;

    private String department;

    private String phone;

    private String address;

    private Date birthday;

    private String majorname;

    private Date logindate;

    private String description;

    private String name;

    private String auth;

    // 表中没有该字段，临时使用该变量，将数据传到前端
    private String imageUrl;

    private static final long serialVersionUID = 1L;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Long teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachernumber() {
        return teachernumber;
    }

    public void setTeachernumber(String teachernumber) {
        this.teachernumber = teachernumber == null ? null : teachernumber.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname == null ? null : majorname.trim();
    }

    public Date getLogindate() {
        return logindate;
    }

    public void setLogindate(Date logindate) {
        this.logindate = logindate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth == null ? null : auth.trim();
    }

    @Override
    public String toString() {
        return "ProTeacher{" +
                "teacherid=" + teacherid +
                ", teachernumber='" + teachernumber + '\'' +
                ", mail='" + mail + '\'' +
                ", department='" + department + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", majorname='" + majorname + '\'' +
                ", logindate=" + logindate +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", auth='" + auth + '\'' +
                '}';
    }
}