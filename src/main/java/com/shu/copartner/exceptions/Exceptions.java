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
     * 请求类型异常
     */
    SERVER_DATASOURCE_ERROR("0006", "数据库查询异常"),

    /**
     * 文件上传异常
     */
    SERVER_FILEUPLOAD_ERROR("0007", "文件上传异常"),

    /**
     * 手机号已经注册异常
     */
    SERVER_PHONEISREGISTED_ERROR("0008", "手机号已经注册"),

    /**
     * 手机未注册异常
     */
    SERVER_PHONENOTREGISTED_ERROR("0009", "手机号未注册"),

    /**
     * 短信验证码过期异常
     */
    SERVER_PHONECODEOUTOFDATE_ERROR("0010", "短信验证码过期异常"),

    /**
     * 短信验证码错误异常
     */
    SERVER_PHONECODEERROR_ERROR("0011", "短信验证码错误异常"),

    /**
     * 验证码不存在异常
     */
    SERVER_PHONECODENOTEXIST_ERROR("0012", "短信验证码不存在"),

    /**
     * 验证码不存在异常
     */
    SERVER_REGISTERISEXIST_ERROR("0013", "注册申请已经存在"),

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