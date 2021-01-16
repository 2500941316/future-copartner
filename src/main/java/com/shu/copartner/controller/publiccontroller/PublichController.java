package com.shu.copartner.controller.publiccontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.service.PublicAuthService;
import com.shu.copartner.utils.returnobj.TableModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @date 2020/12/19 12:08
 * @description
 */
@RestController
@RequestMapping("public")
@CrossOrigin
public class PublichController {

    @Autowired
    PublicAuthService publicAuthService;

    @GetMapping("getverifyCode")
    public TableModel getverifyCode(@RequestParam("phone") String phone) {
        if (StringUtils.isEmpty(phone)) {
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return publicAuthService.getverifyCode(phone);
    }

}
