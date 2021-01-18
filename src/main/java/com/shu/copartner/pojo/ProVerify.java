package com.shu.copartner.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProVerify implements Serializable {
    private String phone;

    private Integer verifycode;

    private Date verifydate;


    public ProVerify(String phone, Integer verifycode, Date verifydate) {
        this.phone = phone;
        this.verifycode = verifycode;
        this.verifydate = verifydate;
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
}