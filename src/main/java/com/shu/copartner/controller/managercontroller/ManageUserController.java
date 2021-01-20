package com.shu.copartner.controller.managercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.PassRegistryVO;
import com.shu.copartner.service.ManagerUserService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * @author cxy
 */

@Slf4j
@RestController
@RequestMapping("manager/user")
@CrossOrigin
public class ManageUserController {

    @Autowired
    ManagerUserService managerUserService;

    /**
     * 查询待审批注册申请
     */
    @GetMapping(value = "searchAllRegistry")
    public TableModel projectTable(@Size(min = 1) @RequestParam int page) {
        if (page <= 0) {
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return managerUserService.searchRegistry(page);
    }


    /**
     * 驳回注册申请
     */
    @GetMapping(value = "rejectRegistry")
    public TableModel rejectRegistry(@RequestParam Long id, String value) {
        if (value.isEmpty()) {
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return managerUserService.rejectRegistry(id, value);
    }


    /**
     * 通过注册申请
     */
    @PostMapping(value = "passRegistry")
    public TableModel passRegistry(@RequestBody @Valid PassRegistryVO passRegistryVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return managerUserService.passRegistry(passRegistryVO);
    }
}
