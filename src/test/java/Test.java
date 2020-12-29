import com.github.pagehelper.PageHelper;
import com.shu.copartner.StartApplication;
import com.shu.copartner.mapper.ProProjectMapper;
import com.shu.copartner.pojo.ProNewsExample;
import com.shu.copartner.pojo.ProProject;
import com.shu.copartner.pojo.ProProjectExample;
import com.shu.copartner.pojo.request.ProjectApplyVO;
import com.shu.copartner.service.ProProjectService;
//import com.shu.copartner.service.impl.ActivitiServiceImpl;
import com.shu.copartner.utils.constance.Constants;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.TaskService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2020/12/22 10:22
 * @description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApplication.class)
public class Test {

/*
    @Autowired
    private ActivitiServiceImpl activitiService;

    @Autowired
    private ProProjectService proProjectService;

    @org.junit.Test
    public void test(){
        String creater = "user";
        ProjectApplyVO projectApplyVO = new ProjectApplyVO();
        projectApplyVO.setStarttime(new Date());
        projectApplyVO.setMainPeople("负责人");
        projectApplyVO.setProjectName("项目名称");
        projectApplyVO.setType("k12");
        projectApplyVO.setStatus("审批申请"); // 状态设置为 审批申请
        projectApplyVO.setIsLock(0); // 默认未锁定
        projectApplyVO.setIsDeleted(0); // 默认未删除

       *//* activitiService.init();
        activitiService.deploy("项目流程","processes/project.bpmn");*//*

        proProjectService.projectApply(projectApplyVO,creater);

    }*/

    @org.junit.Test
     public void strToMap(){
        String strWithComma = "张三,李四,王五，周六";
        String[] strWC = strWithComma.split("[\\,\\，]");
        Map<String, String> strMap = new HashMap<String, String>();
        for(String str : strWC){
            strMap.put(str, str);
        }
        log.info(strMap.toString());
        log.info(strMap.get("张三"));

    }

    @Autowired
    private TaskService taskService;

    @org.junit.Test
    public void deleteTask(){
        /*taskService.deleteTask("f225e20b-44cf-11eb-a3e3-00ff60eaa0ae",true);
        taskService.deleteTask("f29ce6cd-44cf-11eb-a3e3-00ff60eaa0ae",true);
        taskService.deleteTask("fe9b1f61-44cf-11eb-a3e3-00ff60eaa0ae",true);*/
       // taskService.deleteTask("50020",true);
        taskService.complete("cc5e98e7-44d0-11eb-beca-00ff60eaa0ae");
        taskService.complete("cd0f7259-44d0-11eb-beca-00ff60eaa0ae");
        taskService.complete("cfecc8bb-44d0-11eb-beca-00ff60eaa0ae");
      //  taskService.complete("eeb7d9d8-44ce-11eb-989e-00ff60eaa0ae");


    }

    @Autowired
    private ProProjectMapper proProjectMapper;
    @org.junit.Test
    public void testPage(){
        ProProjectExample proProjectExample = new ProProjectExample();
        PageHelper.startPage(1, 3);

        proProjectExample.createCriteria().andProjectIdNotEqualTo(Long.parseLong(1+""));
        List<ProProject>  topNewsList = proProjectMapper.selectByExample(proProjectExample);
        log.info(topNewsList.toString());
    }

}
