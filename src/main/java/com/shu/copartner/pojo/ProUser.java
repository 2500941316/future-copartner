package com.shu.copartner.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProUser implements Serializable {
    private Long id;

    private String auth;

    private String description;

    private String followproject;

    private Integer isdeleted;

    private Integer islock;

    private Date lastdate;

    private Integer logintime;

    private String password;

    private String position;

    private Date registrydate;

    private Integer type;

    private Date lastverifydate;

    private String verifycode;

    private String phone;

    public ProUser() {

    }

    public ProUser(String phone, String verifycode) {
        this.isdeleted = 0;
        this.islock = 0;
        this.lastdate = new Date();
        this.logintime = 0;
        this.registrydate = new Date();
        this.phone = phone;
        this.verifycode = verifycode;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth == null ? null : auth.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getFollowproject() {
        return followproject;
    }

    public void setFollowproject(String followproject) {
        this.followproject = followproject == null ? null : followproject.trim();
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Integer getIslock() {
        return islock;
    }

    public void setIslock(Integer islock) {
        this.islock = islock;
    }

    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }

    public Integer getLogintime() {
        return logintime;
    }

    public void setLogintime(Integer logintime) {
        this.logintime = logintime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Date getRegistrydate() {
        return registrydate;
    }

    public void setRegistrydate(Date registrydate) {
        this.registrydate = registrydate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getLastverifydate() {
        return lastverifydate;
    }

    public void setLastverifydate(Date lastverifydate) {
        this.lastverifydate = lastverifydate;
    }

    public String getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode == null ? null : verifycode.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}