package com.shu.copartner.controller.usercontroller;

import com.shu.copartner.service.UserSupervisorService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;

/**
 * @author
 * @date 2021/1/4 9:35
 * @description
 */
@Slf4j
@RestController
@RequestMapping("user/supervisor")
@CrossOrigin
public class UserSupervisorController {

    @Autowired
    private UserSupervisorService userSupervisorService;

    @GetMapping("searchSupervisorList")
    public TableModel searchSupervisorList( @Size(min = 1) @RequestParam int currentPage){

        return userSupervisorService.searchSupervisor(currentPage);
    }
}
