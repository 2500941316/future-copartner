package com.shu.copartner.controller.publiccontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.service.PublicAuthService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author
 * @date 2020/12/19 12:11
 * @description
 */
@RestController
@RequestMapping("public")
@CrossOrigin
@Slf4j
public class PublichController {

    @Autowired
    PublicAuthService publicAuthService;

    /**
     * 注册申请短信验证码
     *
     * @param phone
     * @return
     */
    @GetMapping("registerGetVrifyCode")
    public TableModel registerGetVerifyCode(@RequestParam("phone") String phone) {
        if (StringUtils.isEmpty(phone)) {
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return publicAuthService.registerGetVrifyCode(phone);
    }

    /**
     * 登录申请短信验证码
     *
     * @param phone
     * @return
     */
    @GetMapping("loginGetVerifyCode")
    public TableModel loginGetVerifyCode(@RequestParam("phone") String phone) {
        if (StringUtils.isEmpty(phone)) {
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return publicAuthService.loginGetVerifyCode(phone);
    }


    /**
     * 提交申请单
     *
     * @return
     */
    @PostMapping("registry")
    public TableModel registry(@RequestBody @Valid NewsPublishVO newsPublishVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return null;
    }

}
