package com.shu.copartner.controller.managercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.SupervisorPublishVO;
import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.service.ManagerSupervisorService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Size;

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

    @Autowired
    private ManagerSupervisorService managerSupervisorService;

    @Autowired
    private FileuploadService fileuploadService;


    /**
     * 导师信息发布处理
     * @param supervisorPublishVO
     * @param result
     * @return
     */
    @PostMapping(value = "publishSupervisorInfo")
    public TableModel applySupervisorInfo(@RequestBody @Valid SupervisorPublishVO supervisorPublishVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        log.info(supervisorPublishVO.toString());
        return managerSupervisorService.operateSupervisorPublish(supervisorPublishVO);
    }

    /**
     * 上传导师照片
     * @param file
     * @return
     */
    @PostMapping(value = "supervisorImgUpload")
    public TableModel leassonImgUpload(MultipartFile file) {
        return fileuploadService.supervisorImageUpload(file);
    }


    @GetMapping("searchAllSupervisor")
    public TableModel searchAllSupervisor(@Size(min = 1) @RequestParam int page){
        return managerSupervisorService.searchAllSupervisor(page);
    }

    /**
     * 删除导师信息
     * @param supervisorId
     * @return
     */
    @GetMapping("deleteSuperviosrById")
    public TableModel deleteSuperviosrById(@RequestParam String supervisorId){
        return managerSupervisorService.deleteSuperviosrById(supervisorId);
    }

    /**
     * 修改导师信息
     * @param supervisorPublishVO
     * @param result
     * @return
     */
    @PostMapping("updateSupervisorInfo")
    public TableModel updateSupervisorInfo(@RequestBody @Valid SupervisorPublishVO supervisorPublishVO,BindingResult result){
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        //log.info(supervisorPublishVO.toString());
        return managerSupervisorService.updateSupervisorInfo(supervisorPublishVO);
    }
}
