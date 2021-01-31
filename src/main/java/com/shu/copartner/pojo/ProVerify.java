package com.shu.copartner.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProVerify implements Serializable {
    private String phone;

    private Integer verifycode;

    private Date verifydate;

    private Boolean status;


    public ProVerify(String phone, Integer verifycode, Date verifydate,boolean status) {
        this.phone = phone;
        this.verifycode = verifycode;
        this.verifydate = verifydate;
        this.status = status;
    }

    public ProVerify() {
    }

    private static final long serialVersionUID = 1L;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(Integer verifycode) {
        this.verifycode = verifycode;
    }

    public Date getVerifydate() {
        return verifydate;
    }

    public void setVerifydate(Date verifydate) {
        this.verifydate = verifydate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}