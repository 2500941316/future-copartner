package com.shu.copartner.exceptions;

/**
 * @author cxy
 * @date 2020/12/6 13:17
 * @Description 异常枚举
 * @return
 */

public enum Exceptions {

    /**
     * 网络连接异常
     */
    SERVER_CONNECTION_ERROR("0001", "网络连接异常"),

    /**
     * 参数接收异常
     */
    SERVER_PARAMSETTING_ERROR("0002", "参数接收异常"),

    /**
     * 身份认证异常
     */
    SERVER_AUTH_ERROR("0003", "身份认证异常"),

    /**
     * 用户名密码异常
     */
    SERVER_UNAMEISNULL_ERROR("0004", "用户名或密码为空"),

    /**
     * 请求类型异常
     */
    SERVER_HTTPTYPE_ERROR("0005", "请求类型异常"),

    /**
     * 未知异常
     */
    SERVER_OTHER_ERROR("0099", "未知异常");

    private String ecode;

    private String emsg;

    Exceptions(String ecode, String emsg) {
        this.ecode = ecode;
        this.emsg = emsg;
    }

    public String getEcode() {
        return ecode;
    }

    public String getEmsg() {
        return emsg;
    }
}