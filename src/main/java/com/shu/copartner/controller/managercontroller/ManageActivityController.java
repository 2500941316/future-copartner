package com.shu.copartner.controller.managercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.ActivityPublishVO;
import com.shu.copartner.service.ManagerActivityService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * @author
 * @date 2021/1/12 21:15
 * @description
 */
@Slf4j
@RestController
@RequestMapping("manager/activity")
@CrossOrigin
public class ManageActivityController {

    @Autowired
    private ManagerActivityService managerActivityService;

    /**
     * 查询所有待管理活动信息
     * @param page
     * @return
     */
    @GetMapping("searchAllActivity")
    public TableModel searchAllActivity(@Size(min = 1) @RequestParam int page){
        return managerActivityService.searchAllActivityManage(page);
    }

    /**
     * 根据id查询活动信息
     * @param activityId
     * @return
     */
    @GetMapping("searchActivityById")
    public TableModel searchActivityById(@Size(min = 1) @RequestParam String activityId){
        return managerActivityService.searchActivityById(activityId);
    }

    /**
     * 设置活动发布状态
     * @param activityId
     * @param isPublish
     * @return
     */
    @GetMapping("updateActivityStatus")
    public TableModel updateActivityStatus(@Size(min = 1) @RequestParam String activityId,@Size(min = 1) @RequestParam String isPublish){
        return managerActivityService.updateActivityStatus(activityId,isPublish);
    }

    /**
     * 删除活动
     * @param activityId
     * @return
     */
    @GetMapping("deleteActivityById")
    public TableModel deleteActivityById(@Size(min = 1) @RequestParam String activityId){
        return managerActivityService.deleteActivityById(activityId);
    }

    /**
     * 修改活动信息
     * @param activityPublishVO
     * @param result
     * @return
     */
    @PostMapping(value = "updateActivityInfo")
    public TableModel updateActivityInfo(@RequestBody @Valid ActivityPublishVO activityPublishVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        log.info(activityPublishVO.toString());
        return managerActivityService.updateActivityInfo(activityPublishVO);
    }

    /**
     * 查看活动报名人员
     * @param activityId
     * @return
     */
    @GetMapping("searchEnrolledPeople")
    public TableModel searchEnrolledPeople(@Size(min = 1) @RequestParam int page,@Size(min= 1) @RequestParam String activityId){
        return managerActivityService.searchEnrolledPeople(page,activityId);
    }

}
