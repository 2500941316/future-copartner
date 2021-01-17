package com.shu.copartner.controller.usercontroller;

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
import org.springframework.security.web.authentication.logout.LogoutSuccessEventPublishingLogoutHandler;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.text.ParseException;
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

    /**
     * 项目申请
     * @param projectApplyVO
     * @param result
     * @return
     */
    @PostMapping("projectApply")
    public TableModel projectApply(@RequestBody @Valid ProjectApplyVO projectApplyVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return proProjectService.projectApply(projectApplyVO, creater);
    }

    /**
     * 项目修改
     * @param projectApplyVO
     * @param result
     * @return
     */
    @PostMapping("updateProject")
    public TableModel updateProject(@RequestBody @Valid ProjectApplyVO projectApplyVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return proProjectService.updateProject(projectApplyVO);
    }

   /* @PostMapping("searchProjectById")
    public TableModel searchProjectById(@RequestBody Map<String,String> map){
         String projectId = map.get("projectId");
         return this.proProjectService.searchProjectById(projectId);
    }*/

    /**
     * 根据用户查询其所有项目
     * @param currentPage
     * @return
     */
    @GetMapping("selectByCreater")
    public TableModel selectByCreater(@Size(min = 1) @RequestParam int currentPage) {
        return proProjectService.selectByCreater(currentPage,creater);
    }

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
     * 上传计划书
     * @param file
     * @return
     */
    @PostMapping(value = "uploadPlan")
    public TableModel uploadPlan(MultipartFile file,@Size(min = 1) @RequestParam String projectId) throws IOException {
        return fileuploadService.managerPlanUploadFile(file, projectId);
    }

    /**
     * 上传视频
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
        return proProjectService.searchProjectByFour(currentPage,projectName,projectType,projectCreater,projectTwoStatus);
    }


    @GetMapping("getAllProject")
    public TableModel getAllProject(){
        return proProjectService.searchAllProject();
    }

    /**
     * 删除项目
     * @param projectId
     * @return
     */
    @GetMapping("deleteProject")
    public TableModel deleteProject(@Size(min = 1) @RequestParam String projectId){
        return proProjectService.deleteProject(projectId);
    }

    /**
     * 关注项目
     * @param projectId
     * @return
     * @throws ParseException
     */
    @GetMapping("followProject")
    public TableModel followProject(@Size(min = 1) @RequestParam String projectId) throws ParseException {
        // 登录了才能关注
        if(StringUtils.isNotEmpty(creater)){
            return proProjectService.followProject(projectId,creater);
        }else{
            return TableModel.error("登录后才能关注！");
        }
    }

    /**
     * 查询我关注的项目
     * @param currentPage
     * @return
     */
    @GetMapping("searchMyFollowProject")
    public TableModel searchMyFollowProject(@Size(min = 1) @RequestParam int currentPage){
        return proProjectService.searchMyFollowProject(currentPage,creater);
    }

    /**
     * 取消关注
     * @param projectId
     * @param follower
     * @return
     */
    @GetMapping("cancelFollowProject")
    public TableModel cancelFollowProject(@Size(min = 1) @RequestParam String projectId,@Size(min = 1) @RequestParam String follower){
        return proProjectService.cancelFollowProject(projectId,follower);
    }

    /**
     * 查询关注我的人
     * @param projectId
     * @return
     */
    @GetMapping("searchUserOfFollowMe")
    public TableModel searchUserOfFollowMe(@Size(min = 1) @RequestParam String projectId){
        return proProjectService.searchUserOfFollowMe(projectId);
    }

}
