package com.shu.copartner.controller.publiccontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.ProjectApplyVO;
import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.service.ProProjectService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.TaskService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.text.ParseException;

/**
 * @author
 * @date 2020/12/19 12:07
 * @description
 */
@Slf4j
@RestController
@RequestMapping("public/project")
@CrossOrigin
public class PublicProjectController {
    // 模拟当前用户
    public static String creater = "user";

  /*  *
     * 处理项目表
     */
    @Autowired
    private ProProjectService proProjectService;

    /**
     * 根据id查询项目
     * @param projectId
     * @return
     */
    @GetMapping("getProjectById")
    public TableModel getProjectById(@Size(min = 1) String projectId) {
        return this.proProjectService.searchProjectById(projectId,creater);
    }

    /**
     * 根据id查询当前项目之外的其他项目
     * @param currentPage
     * @param projectId
     * @return
     */
    @GetMapping("getOtherProjectById")
    public TableModel getOtherProjectById(@Size(min = 1) @RequestParam int currentPage, @Size(min = 1) @RequestParam String projectId) {
        return this.proProjectService.searchOtherProjectById(currentPage,projectId);
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
        return proProjectService.searchProjectByFour(currentPage,projectName,projectType,projectCreater,projectTwoStatus);
    }

    @GetMapping("getAllProject")
    public TableModel getAllProject(){
        return proProjectService.searchAllProject();
    }

}
