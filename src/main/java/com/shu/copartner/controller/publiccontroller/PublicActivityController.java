package com.shu.copartner.controller.publiccontroller;

import com.shu.copartner.service.UserActivityService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.security.Principal;


/**
 * @author
 * @date 2021/1/11 21:21
 * @description
 */
@Slf4j
@RestController
@RequestMapping("public/activity")
@CrossOrigin
public class PublicActivityController {

    @Autowired
    private UserActivityService userActivityService;

    /**
     * 查询活动列表
     * @param currentPage
     * @return
     */
    @GetMapping("searchActivityList")
    public TableModel searchActivityList(@Size(min = 1) @RequestParam int currentPage){
        //return userActivityService.searchActivityList(currentPage);
        return userActivityService.searchActivityListPublic(currentPage);
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

}
