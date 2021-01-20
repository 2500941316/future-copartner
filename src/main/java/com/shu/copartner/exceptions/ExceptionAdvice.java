package com.shu.copartner.exceptions;

import com.shu.copartner.utils.returnobj.TableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.net.BindException;

/**
 * @author cxy
 * @date 2020/12/6 13:17
 * @Description 异常处理类
 * @return
 */
@RestControllerAdvice()
public class ExceptionAdvice {

    private Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler
    @ResponseBody
    public Object exceptionHandler(Exception e) {
        String message = e.getMessage();
        Integer code = Integer.parseInt(message);
        switch (message) {
            case "0001":
                message = Exceptions.SERVER_CONNECTION_ERROR.getEmsg();
                break;

            case "0002":
                message = Exceptions.SERVER_PARAMSETTING_ERROR.getEmsg();
                break;

            case "0003":
                message = Exceptions.SERVER_AUTH_ERROR.getEmsg();
                break;

            case "0004":
                message = Exceptions.SERVER_UNAMEISNULL_ERROR.getEmsg();
                break;

            case "0005":
                message = Exceptions.SERVER_HTTPTYPE_ERROR.getEmsg();
                break;

            case "0006":
                message = Exceptions.SERVER_DATASOURCE_ERROR.getEmsg();
                break;

            case "0007":
                message = Exceptions.SERVER_FILEUPLOAD_ERROR.getEmsg();
                break;

            case "0008":
                message = Exceptions.SERVER_PHONEISREGISTED_ERROR.getEmsg();
                break;

            case "0009":
                message = Exceptions.SERVER_PHONENOTREGISTED_ERROR.getEmsg();
                break;

            case "0010":
                message = Exceptions.SERVER_PHONECODEOUTOFDATE_ERROR.getEmsg();
                break;

            case "0011":
                message = Exceptions.SERVER_PHONECODEERROR_ERROR.getEmsg();
                break;

            case "0012":
                message = Exceptions.SERVER_PHONECODENOTEXIST_ERROR.getEmsg();
                break;
            case "0013":
                message = Exceptions.SERVER_REGISTERISEXIST_ERROR.getEmsg();
                break;

            default:
                message = Exceptions.SERVER_OTHER_ERROR.getEmsg();
                e.printStackTrace();
                break;

        }
        logger.error(message);
        return TableModel.error(code, message);
    }

    @ExceptionHandler
    @ResponseBody
    public Object paramsExceptionHandler(BindException e) {
        logger.error(e.getMessage());
        return TableModel.error(Exceptions.SERVER_PARAMSETTING_ERROR.getEmsg());
    }

    @ExceptionHandler
    @ResponseBody
    public Object typeExceptionHandler(HttpRequestMethodNotSupportedException e) {
        logger.error(e.getMessage());
        return TableModel.error(Exceptions.SERVER_HTTPTYPE_ERROR.getEmsg());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Object constraintViolationExceptionHandler(ConstraintViolationException ex) {
        logger.error(ex.getMessage());
        return TableModel.error("ConstraintViolationException: " + ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        logger.error(ex.getMessage());
        return TableModel.error("参数异常，请检查请求参数是否合法");
    }

}
