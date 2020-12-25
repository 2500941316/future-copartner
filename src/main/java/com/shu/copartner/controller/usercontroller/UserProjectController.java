package com.shu.copartner.controller.usercontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shu.copartner.pojo.ProProject;
import com.shu.copartner.service.ProProjectService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public static String username = "user";

    /**
     * 处理项目表
     */
    @Autowired
    private ProProjectService proProjectService;

    /**
     * 处理流程
     */
//    @Autowired
//    private  activitiService;
    @PostMapping("projectApply")
    public TableModel projectApply(@RequestBody ProProject proProject) {
        log.info("项目信息：" + proProject.toString());
        // 1.添加项目信息，写入到数据库中
        proProject.setStatus("审批申请"); // 状态设置为 审批申请
        proProject.setIsLock(0); // 默认未锁定
        proProject.setIsDeleted(0); // 默认未删除
        proProject.setCreater(username); // 设置当前项目申请者
        int insertResult = this.proProjectService.insert(proProject);
        if (insertResult > 0) {
            log.info("项目信息写入到数据库成功！");
        }


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
