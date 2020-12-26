package com.shu.copartner.controller.managercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.LeassonApplyVO;
import com.shu.copartner.service.ManagerLeassonService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author
 * @date 2020/12/19 12:07
 * @description
 */
@RestController
@RequestMapping("manager/leasson")
@CrossOrigin
@Slf4j
public class ManageLeassonController {

    @Autowired
    ManagerLeassonService managerLeassonService;

    /**
     * @date 2020/12/21 15:21
     * @Description 管理端界面审批新闻的方法
     */
    @PostMapping(value = "applyLeasson")
    @ResponseBody
    public TableModel applyLeasson(@RequestBody @Valid LeassonApplyVO leassonApplyVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return managerLeassonService.operateNew(leassonApplyVO);
    }

}
