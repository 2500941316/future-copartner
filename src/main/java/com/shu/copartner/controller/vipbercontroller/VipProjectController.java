package com.shu.copartner.controller.vipbercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.ProjectApplyVO;
import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.service.ProProjectService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;

/**
 * @author
 * @date 2020/12/19 12:07
 * @description
 */
@Slf4j
@RestController
@RequestMapping("vip/project")
@CrossOrigin
public class VipProjectController {

  /*  *
     * 处理项目表
     */
    @Autowired
    private ProProjectService proProjectService;

    /**
     * 上传文件
     */
    @Autowired
    FileuploadService fileuploadService;

    /**
     * 项目申请
     * @param projectApplyVO
     * @param result
     * @param principal 用于获取当前用户名
     * @return
     */
    @PostMapping("projectApply")
    public TableModel projectApply(@RequestBody @Valid ProjectApplyVO projectApplyVO, BindingResult result,Principal principal) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return proProjectService.projectApply(projectApplyVO, principal.getName());
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

    /**
     * 根据用户查询其所有项目
     * @param currentPage
     * @param principal 获取当前用户
     * @return
     */
    @GetMapping("selectByCreater")
    public TableModel selectByCreater(@Size(min = 1) @RequestParam int currentPage,Principal principal) {
        //log.info("用户名："+principal.getName());
        return proProjectService.selectByCreater(currentPage,principal.getName());
    }

    /**
     * 根据id查询项目
     * @param projectId
     * @param principal
     * @return
     */
    @GetMapping("getProjectById")
    public TableModel getProjectById(@Size(min = 1) String projectId,Principal principal) {
        return this.proProjectService.searchProjectById(projectId,principal.getName());
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
     * @param principal
     * @return
     * @throws ParseException
     */
    @GetMapping("followProject")
    public TableModel followProject(@Size(min = 1) @RequestParam String projectId,Principal principal) throws ParseException {
        return proProjectService.followProject(projectId,principal.getName());
    }

    /**
     * 查询我关注的项目
     * @param currentPage
     * @param principal
     * @return
     */
    @GetMapping("searchMyFollowProject")
    public TableModel searchMyFollowProject(@Size(min = 1) @RequestParam int currentPage,Principal principal){
        return proProjectService.searchMyFollowProject(currentPage,principal.getName());
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

    /**
     * 查询我的项目，我的关注，关注我的个数
     * @param principal
     * @return
     */
    @GetMapping(value = "selectCount")
    public TableModel selectCount(Principal principal) {
        return proProjectService.selectCount(principal.getName());
    }

}
