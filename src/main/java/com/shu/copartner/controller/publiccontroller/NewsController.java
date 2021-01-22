package com.shu.copartner.controller.publiccontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author cxy
 */
@RestController
@RequestMapping("public")
@CrossOrigin
@Slf4j
public class NewsController {

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