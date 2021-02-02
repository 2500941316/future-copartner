package com.shu.copartner.controller.vipbercontroller;

import com.shu.copartner.service.VipUserService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author
 * @date 2021/2/1 16:19
 * @description
 */
@Slf4j
@RestController
@RequestMapping("vip/user")
@CrossOrigin
public class VipUserController {

    @Autowired
    private VipUserService vipUserService;

    /**
     * 查询我的信息
     * @param principal
     * @return
     */
    @GetMapping(value = "selectPersonalInfo")
    public TableModel selectPersonalInfo(Principal principal) {
        return vipUserService.selectPersonalInfo(principal.getName());
    }

}
