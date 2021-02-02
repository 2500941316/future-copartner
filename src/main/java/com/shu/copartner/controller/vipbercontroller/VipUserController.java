package com.shu.copartner.controller.vipbercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.ProjectApplyVO;
import com.shu.copartner.pojo.request.PublicRegistryInfoVO;
import com.shu.copartner.service.VipUserService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    /**
     * 个人信息修改
     * @param publicRegistryInfoVO
     * @param result
     * @return
     */
    @PostMapping("updatePersonalInfo")
    public TableModel updatePersonalInfo(@RequestBody @Valid PublicRegistryInfoVO publicRegistryInfoVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return vipUserService.updatePersonalInfo(publicRegistryInfoVO);
    }

}
