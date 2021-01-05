package com.shu.copartner.controller.managercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.ProjectManagerOperationVO;
import com.shu.copartner.pojo.request.SupervisorPublishVO;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author
 * @date 2021/1/5 13:00
 * @description
 */
@Slf4j
@RestController
@RequestMapping("manager/supervisor")
@CrossOrigin
public class ManageSupervisorController {



    @PostMapping(value = "publishSupervisorInfo")
    @ResponseBody
    public TableModel applySupervisorInfo(@RequestBody @Valid SupervisorPublishVO supervisorPublishVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        log.info(supervisorPublishVO.toString());
        return null;//managerProjectService.operateProjectApply(projectManagerOperationVO)
    }
}
