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

    /**
     * 处理项目表
     */
    @Autowired
    private ProProjectService proProjectService;

    @Autowired
    private TaskService taskService;

    /**
     * 处理流程
     */
    //  @Autowired
    //   private ActivitiServiceImpl activitiService;
    @PostMapping("projectApply")
    public TableModel projectApply(@RequestBody @Valid ProjectApplyVO projectApplyVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        log.info("项目信息：" + projectApplyVO.toString());
        return proProjectService.projectApply(projectApplyVO, creater);
       /* // 1.添加项目信息，写入到数据库中
        proProject.setStatus("审批申请"); // 状态设置为 审批申请
        proProject.setIsLock(0); // 默认未锁定
        proProject.setIsDeleted(0); // 默认未删除
        proProject.setCreater(username); // 设置当前项目申请者

        int insertResult = this.proProjectService.insert(proProject);
        if(insertResult > 0){
            log.info("项目信息写入到数据库成功！");
        }

        //2.初始化流程
        activitiService.init();

        //3.部署项目流程
        Deployment deployment = activitiService.deploy("项目流程","processes/project.bpmn");
        //输出部署信息
        log.info("流程名称：" + deployment.getName());
        log.info("流程ID：" + deployment.getId());
        log.info("流程Key：" + deployment.getKey());

        //4.启动流程
        //Map<String,Object> map = JSONObject.parseObject(JSON.toJSONString(proProject));
        Map<String,Object> map = new HashMap<>();
        map.put("user",username); // 指定当前用户为执行人
        activitiService.startProcessInstance(map, Constants.PROJECT_PROCESS_PROCESSKEY);

        // 5.根据当前用户查询项目申请流程信息
        List<Task> taskList = activitiService.findMyPersonalTask(username);
        List<String> taskIds = new ArrayList<>(); // 存储taskId，字符串类型
        for (Task task : taskList) {
            log.info("任务名称：" + task.getName());
            log.info("任务执行人：" + task.getAssignee());
            log.info("任务ID：" + task.getId());
            log.info("流程实例ID：" + task.getProcessInstanceId());
            taskIds.add(task.getId());
        }

        //6.当前用户已经输入申请数据，完成项目申请，流程进入到下一步：审批项目申请
        for (String taskId : taskIds){
            activitiService.completeTask(taskId,username,map);
        }*/
    }
}
