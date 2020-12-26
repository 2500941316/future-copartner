package com.shu.copartner.controller.usercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.ProjectApplyVO;
import com.shu.copartner.service.ProProjectService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
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
        log.info("selectByCreater");
        return proProjectService.selectByCreater(creater);
        //3.部署流程
        //Deployment deployment = activitiService.deploy("项目流程","processes/project.bpmn");
        //输出部署信息
//        log.info("流程名称：" + deployment.getName());
//        log.info("流程ID：" + deployment.getId());
//        log.info("流程Key：" + deployment.getKey());

        //4.启动流程
//        Map<String,Object> map = JSONObject.parseObject(JSON.toJSONString(proProject));
//        activitiService.startProcessInstance(map, Constants.PROJECT_PROCESS_PROCESSKEY);

        return TableModel.success();
    }
}
