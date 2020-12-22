package com.shu.copartner.service.impl.manager;

import com.shu.copartner.mapper.ActRuTaskMapper;
import com.shu.copartner.mapper.ActRuVariableMapper;
import com.shu.copartner.mapper.ProNewsMapper;
import com.shu.copartner.pojo.ActRuVariable;
import com.shu.copartner.pojo.ProNewsExample;
import com.shu.copartner.pojo.request.NewsManagerOperationVO;
import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.pojo.response.NewsInfoSo;
import com.shu.copartner.service.ManagerNewsService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxy
 * @Date: 2020/12/21 15:19
 * @Description:
 */
@Service
public class ManagerNewsServiceImpl implements ManagerNewsService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private ActRuVariableMapper actRuVariableMapper;

    @Autowired
    private TaskService taskService;

    @Autowired
    ProNewsMapper proNewsMapper;


    @Override
    public TableModel searchNewsApplication(int page) {
        List<Task> taskList = taskService.createTaskQuery()
                .taskAssignee(Constants.MANAGER_ROLE)
                .taskName(Constants.NEWSAPPLY_PROCESS_MANAGERNAME)
                .listPage(Constants.pageSize * (page - 1), Constants.pageSize);
        List<NewsInfoSo> arrayList = new ArrayList<>();
        for (Task task : taskList) {
            System.out.println(taskService.getVariable(task.getId(), Constants.ACTIVITI_OBJECT_NAME));
            ActRuVariable actRuVariable = actRuVariableMapper.selectByPrimaryKey(task.getId());
            System.out.println(actRuVariable.getText());
        }
        return TableModel.tableSuccess(arrayList, arrayList.size());
    }


    @Override
    public TableModel operateNew(NewsManagerOperationVO newsManagerOperationVO) {
        //如果完成了审批任务，则将结果直接存入news表，同意的和拒绝的
        taskService.complete(newsManagerOperationVO.getTaskId());
        //更新新闻状态
        if (newsManagerOperationVO.getStatus().equals("1")) {
            ProNewsExample proNewsExample = new ProNewsExample();
        }
        return null;
    }
}
