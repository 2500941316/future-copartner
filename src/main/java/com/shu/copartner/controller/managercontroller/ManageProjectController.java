package com.shu.copartner.controller.managercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.ProActivity;
import com.shu.copartner.pojo.request.ProjectManagerOperationVO;
import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.service.ManagerProjectService;
import com.shu.copartner.service.ProProjectService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.security.Principal;

/**
 * @author
 * @date 2020/12/19 12:07
 * @description
 */
@Slf4j
@RestController
@RequestMapping("manager/project")
@CrossOrigin
public class ManageProjectController {
    @Autowired
    FileuploadService uploadService;

  /**
     * 处理项目表
     */
    @Autowired
    private ManagerProjectService managerProjectService;

    @Autowired
    private ProProjectService proProjectService;

 /**
     * 查询待审批项目
     * @return
     */
    @GetMapping(value = "searchProject")
    public TableModel projectTable(@Size(min = 1) @RequestParam int page) {
        if (page <= 0) {
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return managerProjectService.searchProject(page);
    }

    /**
     * 查询所有项目
     * @param page
     * @return
     */
    @GetMapping(value = "searchAllProject")
    public TableModel searchAllProject(@Size(min = 1) @RequestParam int page) {
        if (page <= 0) {
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return managerProjectService.searchAllProject(page);
    }



    /**
     * 根据id查询项目
     * @param projectId
     * @return
     */
    @GetMapping("getProjectById")
    public TableModel getProjectById(@Size(min = 1) String projectId) {
        return this.managerProjectService.searchProjectById(projectId);
    }

    /**
     * 审批项目处理
     * @param projectManagerOperationVO
     * @param result
     * @return
     */
    @PostMapping(value = "operateProjectApply")
    @ResponseBody
    public TableModel operateProjectApply(@RequestBody @Valid ProjectManagerOperationVO projectManagerOperationVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        //log.info(projectManagerOperationVO.toString());
        return managerProjectService.operateProjectApply(projectManagerOperationVO);
    }

    /**
     * 设置项目状态
     * @param projectId
     * @param isGoing
     * @return
     */
    @GetMapping(value = "updateProjectIsGoing")
    public TableModel updateProjectIsGoing(@Size(min = 1) @RequestParam String projectId,@Size(min = 1) @RequestParam String isGoing) {
        log.info(projectId+isGoing);
        return managerProjectService.updateProjectIsGoing(projectId,isGoing);
    }

    /**
     * 删除项目
     * @param projectId
     * @return
     */
    @GetMapping(value = "deleteProjectById")
    public TableModel deleteProjectById(@Size(min = 1) @RequestParam String projectId) {
        return managerProjectService.deleteProjectById(projectId);
    }

}
