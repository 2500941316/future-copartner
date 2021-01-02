package com.shu.copartner.controller.managercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.LeassonApplyVO;
import com.shu.copartner.pojo.request.LeassonVedioUpdateVO;
import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.service.ManagerLeassonService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    @Autowired
    FileuploadService uploadService;

    /**
     * @date 2020/12/21 15:21
     * @Description 管理端界面审批课程的方法
     */
    @PostMapping(value = "applyLeasson")
    @ResponseBody
    public TableModel applyLeasson(@RequestBody @Valid LeassonApplyVO leassonApplyVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return managerLeassonService.applyLeasson(leassonApplyVO);
    }


    /**
     * @date 2020/12/21 15:21
     * @Description 管理端界面删除课程的方法
     */
    @GetMapping(value = "deleteLeasson")
    @ResponseBody
    public TableModel deleteLeasson(@Min(1) @RequestParam("courseId") String courseId) {
        if (courseId.isEmpty()) {
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return managerLeassonService.deleteLeasson(courseId);
    }


    /**
     * @date 2020/12/21 15:21
     * @Description 管理端界面更新视频的方法
     */
    @PostMapping(value = "updateLeasson")
    @ResponseBody
    public TableModel updateLeasson(@RequestBody @Valid LeassonVedioUpdateVO leassonVedioUpdateVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return managerLeassonService.updateLeasson(leassonVedioUpdateVO);
    }


    /**
     * @date 2020/12/21 15:21
     * @Description 管理端查询所有的课程的方法
     */
    @GetMapping(value = "getLeassonInfo")
    @ResponseBody
    public TableModel getLeassonInfo(@Size(min = 1) @RequestParam int page) {

        return managerLeassonService.getLeassonInfo(page);
    }


    /**
     * @author cxy
     * @date 2020/12/20 13:42
     * @Description 上传课程视频的方法
     */
    @PostMapping(value = "leassonVedioUpload")
    @ResponseBody
    public TableModel leassonVedioUpload(MultipartFile file, Long course_vedio_id, String fileUpload_type) {

        return uploadService.leassonVedioUpload(file, course_vedio_id, fileUpload_type);
    }

    /**
     * @author cxy
     * @date 2020/12/20 13:42
     * @Description 上传课程图片的方法
     */
    @PostMapping(value = "leassonImgUpload")
    @ResponseBody
    public TableModel leassonImgUpload(MultipartFile file) {

        return uploadService.managerImageUploadFile(file);
    }
}
