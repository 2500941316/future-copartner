package com.shu.copartner.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProUser implements Serializable {
    private Long userid;

    private String auth;

    private String followproject;

    private Integer isdeleted;

    private Integer islock;

    private Date lastdate;

    private Integer logintime;

    private String password;

    private Date registrydate;

    private String phone;

    private static final long serialVersionUID = 1L;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth == null ? null : auth.trim();
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

    public Date getRegistrydate() {
        return registrydate;
    }

    public void setRegistrydate(Date registrydate) {
        this.registrydate = registrydate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}