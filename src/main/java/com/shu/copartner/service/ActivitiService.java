package com.shu.copartner.service;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author cxy
 * @Date: 2020/12/4 16:37
 * @Description:
 */
@Component
public class ActivitiService {

    private ProcessEngine processEngine = null;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    /**
     * @return void
     * @author cxy
     * @date 2020/12/4 16:37
     * @Description 生成工作流的表
     */
    public void init() {
        //流程引擎的配置对象
        ProcessEngineConfiguration engineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        engineConfiguration.setJdbcDriver(driverClassName);
        engineConfiguration.setJdbcUrl(url);
        engineConfiguration.setJdbcUsername(username);
        engineConfiguration.setJdbcPassword(password);

        engineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        processEngine = engineConfiguration.buildProcessEngine();
    }

    /**
     * @return void
     * @author cxy
     * @date 2020/12/5 11:30
     * @Description 部署流程
     */
    public Deployment deploy(String name, String resourcePath) {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        return repositoryService.createDeployment()
                .name(name)
                .addClasspathResource(resourcePath)
                .deploy();
    }

    /**
     * @return void
     * @author cxy
     * @date 2020/12/5 11:30
     * @Description 开始流程
     */
    public void startProcessInstance(Map<String, Object> map, String processKey) {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        runtimeService.startProcessInstanceByKey(processKey, map);
    }

    /**
     * @return void
     * @author cxy
     * @date 2020/12/5 11:30
     * @Description 查询任务
     */
    public List<Task> findMyPersonalTask(String assignee) {
        return processEngine.getTaskService()
                .createTaskQuery()//创建任务查询对象
                .taskAssignee(assignee)
                .list();
    }


    /**
     * @return void
     * @author cxy
     * @date 2020/12/5 11:30
     * @Description 完成任务
     */
    public boolean completeTask(String taskId, Map<String, Object> map) {
        //任务ID
        TaskService taskService = processEngine.getTaskService();
        taskService.setVariable(taskId, "params", map);
        //提交给谁做审批:根据员工表查询主管
        taskService.complete(taskId);
        return true;
    }
}
