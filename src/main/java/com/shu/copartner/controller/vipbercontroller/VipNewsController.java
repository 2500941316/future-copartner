package com.shu.copartner.controller.vipbercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.utils.returnobj.TableModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @date 2020/12/19 12:09
 * @description
 */
@RestController
@RequestMapping("vip")
@CrossOrigin
public class VipNewsController {
    /**
     * 发布新闻
     *
     * @param phone
     * @return
     */
    @GetMapping("applyNews")
    public TableModel registerGetVerifyCode(@RequestParam("phone") String phone) {
        if (StringUtils.isEmpty(phone)) {
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return null;
    }
}
