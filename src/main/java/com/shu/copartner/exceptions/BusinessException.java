package com.shu.copartner.exceptions;


/**
 * @author cxy
 * @date 2020/12/6 13:17
 * @Description 自定义异常类
 * @return
 */

public class BusinessException extends RuntimeException {

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

}
