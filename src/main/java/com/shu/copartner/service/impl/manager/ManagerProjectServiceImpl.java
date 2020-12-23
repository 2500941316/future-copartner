package com.shu.copartner.service.impl.manager;

import com.shu.copartner.mapper.ActRuVariableMapper;
import com.shu.copartner.mapper.ProNewsMapper;
import com.shu.copartner.mapper.ProProjectMapper;
import com.shu.copartner.pojo.ActRuVariable;
import com.shu.copartner.pojo.ProNews;
import com.shu.copartner.pojo.ProNewsExample;
import com.shu.copartner.pojo.ProProject;
import com.shu.copartner.pojo.request.NewsManagerOperationVO;
import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.pojo.request.ProjectApplyVO;
import com.shu.copartner.pojo.response.NewsInfoSo;
import com.shu.copartner.pojo.response.ProjectInfoSo;
import com.shu.copartner.service.ManagerNewsService;
import com.shu.copartner.service.ManagerProjectService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @Date: 2020/12/21 15:19
 * @Description:
 */
@Slf4j
@Service
public class ManagerProjectServiceImpl implements ManagerProjectService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private ActRuVariableMapper actRuVariableMapper;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProProjectMapper proProjectMapper;

    @Override
    public TableModel searchProject(int page) {
        long count = taskService.createTaskQuery().taskAssignee("admin") // Constants.MANAGER_ROLE
                .taskName(Constants.PROJECTAPPLY_PROCESS_MANAGERNAME).count();
        List<Task> taskList = taskService.createTaskQuery()
                .taskAssignee("admin") // Constants.MANAGER_ROLE
                .taskName(Constants.PROJECTAPPLY_PROCESS_MANAGERNAME) // 查询处于'管理员审批项目申请'状态的task
                .listPage(Constants.pageSize * (page - 1), Constants.pageSize);
        log.info("task条数："+taskList.size());


        List<ProjectInfoSo> arrayList = new ArrayList<>();
        for (Task task : taskList) {
            long startTime1 = System.currentTimeMillis(); //获取开始时间
            Long variable = taskService.getVariable(task.getId(), Constants.ACTIVITI_OBJECT_NAME, Long.class);
            long endTime1 = System.currentTimeMillis(); //获取结束时间
            log.info("get1程序运行时间：" + (endTime1 - startTime1) + "ms"); //输出程序运行时间
            ProProject proProject = proProjectMapper.selectByPrimaryKey(variable);
            ProjectInfoSo projectInfoSo = new ProjectInfoSo();
            BeanUtils.copyProperties(proProject,projectInfoSo);
            projectInfoSo.setTaskId(task.getId());
            arrayList.add(projectInfoSo);

        }
        return TableModel.tableSuccess(arrayList, (int)count);


    }

   /* @Override
    public TableModel operateNew(NewsManagerOperationVO newsManagerOperationVO) {
        //完成taskid的审批任务
        activitiService.init();
        //如果完成了审批任务，则将结果直接存入news表，同意的和拒绝的
        if (activitiService.completeTaskWithoutObject(newsManagerOperationVO.getTaskId())) {
            //更新新闻状态
            if (newsManagerOperationVO.getStatus().equals("1")) {
                ProNewsExample proNewsExample = new ProNewsExample();

            }
        }
        return null;
    }

    activitiService.init();
        List<Task> taskList = activitiService.findMyPersonalTask(page, Constants.PROJECT_PROCESS_MANAGERNAME, "admin"); // Constants.PROJECT_PROCESS_MANAGERNAME, Constants.MANAGER_ROLE
        log.info("条数："+taskList.size());
        //创建返回的list
        List<ProjectInfoSo> arrayList = new ArrayList();
        for (Task task : taskList) {
            ProjectApplyVO taskObjectParams = activitiService.findTaskObjectParams(task.getId(), Constants.ACTIVITI_OBJECT_NAME, ProjectApplyVO.class);
            if (taskObjectParams != null) {
                ProjectInfoSo projectInfoSo = new ProjectInfoSo();
                BeanUtils.copyProperties(taskObjectParams, projectInfoSo);
                projectInfoSo.setTaskId(task.getId());
                arrayList.add(projectInfoSo);
            }
        }
        return TableModel.tableSuccess(arrayList, arrayList.size());

    */
}
