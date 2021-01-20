package com.shu.copartner.controller.usercontroller;

import com.shu.copartner.service.UserLiveService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;

/**
 * @author
 * @date 2021/1/18 18:32
 * @description
 */
@Slf4j
@RestController
@RequestMapping("user/live")
@CrossOrigin
public class UserLiveController {

    @Autowired
    private UserLiveService userLiveService;

    /**
     * 查询直播 列表
     * @param currentPage
     * @return
     */
    @GetMapping("searchLiveList")
    public TableModel searchLiveList(@Size(min = 1) @RequestParam int currentPage){
        return userLiveService.searchLiveList(currentPage);
    }
}
