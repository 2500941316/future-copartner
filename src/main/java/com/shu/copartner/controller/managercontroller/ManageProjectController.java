package com.shu.copartner.controller.managercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.ProProject;
import com.shu.copartner.pojo.request.NewsManagerOperationVO;
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
import java.util.List;

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

  /*  *
     * 处理项目表
     */
    @Autowired
    private ManagerProjectService managerProjectService;

    @Autowired
    private ProProjectService  proProjectService;

 /*   *
     * 查询待审批项目
     * @return
     */
    @GetMapping(value = "searchProject")
    public TableModel projectTable(@Size(min = 1) @RequestParam int page) {
        if (page <= 0) {
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        log.info("page:"+page);
       /* List<ProProject> proProjectList = proProjectService.selectByStatus("审批申请");
        TableModel tableModel = TableModel.success(proProjectList,proProjectList.size());
        tableModel.setCode(0);*/
        return managerProjectService.searchProject(page);
    }

    @PostMapping(value = "operateProjectApply")
    @ResponseBody
    public TableModel operateProjectApply(@RequestBody @Valid ProjectManagerOperationVO projectManagerOperationVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        log.info(projectManagerOperationVO.toString());
        return managerProjectService.operateProjectApply(projectManagerOperationVO);
    }


}
