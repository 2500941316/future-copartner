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

    /**
     * 查询导师列表
     * @param currentPage
     * @return
     */
    @GetMapping("searchSupervisorList")
    public TableModel searchSupervisorList( @Size(min = 1) @RequestParam int currentPage){

        return userSupervisorService.searchSupervisor(currentPage);
    }

    /**
     * 根据名称搜索导师
     * @param supervisorName
     * @return
     */
    @GetMapping("searchSupervisorByName")
    public TableModel searchSupervisorByName(@Size(min = 1) @RequestParam String supervisorName){
        return userSupervisorService.searchSupervisorByName(supervisorName);
    }

    /**
     * 根据id查询导师详情
     * @param supervisorId
     * @return
     */
    @GetMapping("searchSuperviosrById")
    public TableModel searchSuperviosrById(@Size(min = 1) @RequestParam String supervisorId){
        return userSupervisorService.searchSupervisorById(supervisorId);
    }

    /**
     * 根据id查询导师所参与的项目
     * @param supervisorId
     * @return
     */
    @GetMapping("searchSupervisorProject")
    public TableModel searchSupervisorProject(@Size(min = 1) @RequestParam String supervisorId){
        return userSupervisorService.searchSupervisorProject(supervisorId);
    }

    /**
     * 查询导师代表性成就
     * @param supervisorId
     * @return
     */
    @GetMapping("searchSupervisorAchievement")
    public TableModel searchSupervisorAchievement(@Size(min = 1) @RequestParam String supervisorId){
        return userSupervisorService.searchSupervisorAchievement(supervisorId);
    }
}
