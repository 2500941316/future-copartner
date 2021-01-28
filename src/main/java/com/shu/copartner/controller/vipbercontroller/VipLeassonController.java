package com.shu.copartner.controller.vipbercontroller;

import com.shu.copartner.service.UserLeassonService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;

/**
 * @author cxy
 */
@Slf4j
@RestController
@RequestMapping("vip/leasson")
@CrossOrigin
public class VipLeassonController {

    @Autowired
    UserLeassonService userLeassonService;

    /**
     * @author cxy
     * @date 2020/12/20 13:42
     */
    @GetMapping(value = "test")
    @ResponseBody
    public TableModel getLeassonInfo() {
        return null;
    }

}
