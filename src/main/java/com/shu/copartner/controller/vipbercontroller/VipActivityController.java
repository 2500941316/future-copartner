package com.shu.copartner.controller.vipbercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.ActivityPublishVO;
import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.service.UserActivityService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.security.Principal;

/**
 * @author
 * @date 2021/1/11 21:21
 * @description
 */
@Slf4j
@RestController
@RequestMapping("vip/activity")
@CrossOrigin
public class VipActivityController {

    @Autowired
    private UserActivityService userActivityService;

    @Autowired
    private FileuploadService fileuploadService;



    /**
     * 查询活动列表
     * @param currentPage
     * @param principal
     * @return
     */
    @GetMapping("searchActivityList")
    public TableModel searchActivityList(@Size(min = 1) @RequestParam int currentPage,Principal principal){

        return userActivityService.searchActivityList(currentPage,principal);
    }


    /**
     * 根据id查询活动详情
     * @param activityId
     * @return
     */
    @GetMapping("searchActivityById")
    public TableModel searchActivityById(@Size(min = 1) @RequestParam String activityId){
        return userActivityService.searchActivityById(activityId);
    }

    /**
     * 活动富文本中的图片上传
     * @param file
     * @return
     */
    @PostMapping(value = "activityImagesUpload")
    public TableModel fileuploadpicture(MultipartFile file) {
        return fileuploadService.managerImageUploadFile(file);
    }

    /**
     * 上传活动照片
     * @param file
     * @return
     */
    @PostMapping(value = "activityImgUpload")
    public TableModel activityImgUpload(MultipartFile file) {
        return fileuploadService.activityImageUpload(file);
    }


    /**
     * 活动创建申请
     * @param activityPublishVO
     * @param result
     * @param principal 用于获取当前用户
     * @return
     */
    @PostMapping(value = "applyActivity")
    public TableModel applyActivityInfo(@RequestBody @Valid ActivityPublishVO activityPublishVO, BindingResult result,Principal principal) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        log.info(activityPublishVO.toString());
        return userActivityService.operateActivityApply(activityPublishVO,principal.getName());
    }

    /**
     * 报名活动
     * @param activityId
     * @param principal
     * @return
     */
    @GetMapping("enrollInActivity")
    public TableModel enrollInActivity(@Size(min = 1) @RequestParam String activityId,Principal principal){
        return userActivityService.enrollInActivity(activityId,principal.getName());
    }

    /**
     * 取消报名
     * @param activityId
     * @param principal
     * @return
     */
    @GetMapping("cancelEnrollActivity")
    public TableModel cancelEnrollActivity(@Size(min = 1) @RequestParam String activityId,Principal principal){
        return userActivityService.cancelEnrollActivity(activityId,principal.getName());
    }

    /**
     * 查询我创建的活动
     * @param currentPage
     * @param principal
     * @return
     */
    @GetMapping("searchMyCreatedActivity")
    public TableModel searchMyCreatedActivity(@Size(min = 1) @RequestParam int currentPage, Principal principal){
        return userActivityService.searchMyCreatedActivity(currentPage,principal.getName());
    }

    /**
     * 删除活动
     * @param activityId
     * @return
     */
    @GetMapping("deleteActivityById")
    public TableModel deleteActivityById(@Size(min = 1) @RequestParam String activityId){
        return userActivityService.deleteActivityById(activityId);
    }
}
