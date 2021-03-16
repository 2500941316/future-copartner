package com.shu.copartner.controller.managercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.LivePublishVO;
import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.service.ManagerLiveService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * @author
 * @date 2021/1/18 20:22
 * @description
 */
@Slf4j
@RestController
@RequestMapping("manager/live")
@CrossOrigin
public class ManageLiveController {

    @Autowired
    private ManagerLiveService managerLiveService;

    @Autowired
    private FileuploadService fileuploadService;

    /**
     * 直播信息发布处理
     * @param livePublishVO
     * @param result
     * @return
     */
    @PostMapping(value = "publishLiveInfo")
    public TableModel publishLiveInfo(@RequestBody @Valid LivePublishVO livePublishVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        log.info(livePublishVO.toString());
        return managerLiveService.publishLiveInfo(livePublishVO);
    }

    /**
     * 查询所有直播信息
     * @param page
     * @return
     */
    @GetMapping("searchAllLives")
    public TableModel searchAllLives(@Size(min = 1) @RequestParam int page){
        return managerLiveService.searchAllLives(page);
    }

    /**
     * 删除直播
     * @param liveId
     * @return
     */
    @GetMapping("deleteLiveById")
    public TableModel deleteLiveById(@Size(min = 1) @RequestParam String liveId){
        return managerLiveService.deleteLiveById(liveId);
    }

    /**
     * 根据id查询直播
     * @param liveId
     * @return
     */
    @GetMapping("searchLiveById")
    public TableModel searchLiveById(@Size(min = 1) @RequestParam String liveId){
        return managerLiveService.searchLiveById(liveId);
    }

    /**
     * 修改直播信息
     * @param livePublishVO
     * @param result
     * @return
     */
    @PostMapping(value = "updateLiveInfo")
    public TableModel updateLiveInfo(@RequestBody @Valid LivePublishVO livePublishVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        log.info(livePublishVO.toString());
        return managerLiveService.updateLiveInfo(livePublishVO);
    }


    @PostMapping(value = "liveVideoUpload")
    @ResponseBody
    public TableModel liveVideoUpload(MultipartFile file, String liveId) {
        if (StringUtils.isEmpty(liveId)) {
            return TableModel.error();
        }
        //log.info("上传视频liveId:"+liveId);
        return fileuploadService.liveVideoUpload(file, liveId);
    }

}
