package com.shu.copartner.controller.usercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.ProProjectExample;
import com.shu.copartner.pojo.request.ProjectApplyVO;
import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.service.ProProjectService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2020/12/19 12:07
 * @description
 */
@Slf4j
@RestController
@RequestMapping("user/project")
@CrossOrigin
public class UserProjectController {
    // 模拟当前用户
    public static String creater = "user";

  /*  *
     * 处理项目表
     */
    @Autowired
    private ProProjectService proProjectService;

    @Autowired
    private TaskService taskService;

    /**
     * 上传文件
     */
    @Autowired
    FileuploadService fileuploadService;

    /*@PostMapping("projectApply")
    public TableModel projectApply(@RequestBody @Valid ProjectApplyVO projectApplyVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        log.info("项目信息：" + projectApplyVO.toString());
        return proProjectService.projectApply(projectApplyVO, creater);
    }*/

    @PostMapping("projectApply")
    public TableModel projectApply(@RequestBody @Valid ProjectApplyVO projectApplyVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        log.info("项目信息：" + projectApplyVO.toString());
        return proProjectService.projectApply(projectApplyVO, creater);
    }

    @PostMapping("searchProjectById")
    public TableModel searchProjectById(@RequestBody Map<String,String> map){
         String projectId = map.get("projectId");
         return this.proProjectService.searchProjectById(projectId);
    }

    @GetMapping("selectByCreater")
    public TableModel selectByCreater() {
   //     log.info("selectByCreater");
        return proProjectService.selectByCreater(creater);
    }

    @GetMapping("getProjectById")
    public TableModel getProjectById(@Size(min = 1) String projectId) {
        log.info("projectId:"+projectId);
        return this.proProjectService.searchProjectById(projectId);
    }

    @GetMapping("getOtherProjectById")
    public TableModel getOtherProjectById(@Size(min = 1) @RequestParam int currentPage, @Size(min = 1) @RequestParam String projectId) {
        log.info("projectId:"+projectId+" currentPage: "+ currentPage);
        return this.proProjectService.searchOtherProjectById(currentPage,projectId);
    }

    /**
     * 上传计划书
     * @param file
     * @return
     */
    @PostMapping(value = "uploadPlan")
    public TableModel uploadPlan(MultipartFile file,@Size(min = 1) @RequestParam String projectId) throws IOException {
        return fileuploadService.managerPlanUploadFile(file, projectId);
    }

    /**
     * 上传计划书
     * @param file
     * @return
     */
    @PostMapping(value = "uploadVideo")
    public TableModel uploadVideo(MultipartFile file,@Size(min = 1) @RequestParam String projectId) throws IOException {
        return fileuploadService.managerVideoUploadFile(file, projectId);
    }

    /**
     * 根据条件搜索项目
     * @param currentPage
     * @param projectName
     * @param projectType
     * @param projectCreater
     * @param projectTwoStatus
     * @return
     */
    @GetMapping("searchProjectByFour")
    public TableModel searchProjectByFour(@Size(min = 1) @RequestParam int currentPage,
                                          @Size(min = 1) @RequestParam String projectName,
                                          @Size(min = 1) @RequestParam String projectType,
                                          @Size(min = 1) @RequestParam String projectCreater,
                                          @Size(min = 1) @RequestParam String projectTwoStatus
                                          ) {
        log.info(currentPage+" "+projectName+" "+projectType+" "+ projectCreater+" "+ projectTwoStatus);

        return proProjectService.searchProjectByFour(currentPage,projectName,projectType,projectCreater,projectTwoStatus);
    }


    @GetMapping("getAllProject")
    public TableModel getAllProject(){
        return proProjectService.searchAllProject();
    }




}
