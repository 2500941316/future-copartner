package com.shu.copartner.service.impl.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.copartner.mapper.ActRuTaskMapper;
import com.shu.copartner.pojo.ActRuTask;
import com.shu.copartner.pojo.ActRuTaskExample;
import com.shu.copartner.pojo.request.NewsManagerOperationVO;
import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.service.ManagerNewsService;
import com.shu.copartner.service.impl.ActivitiServiceImpl;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
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
    ActivitiServiceImpl<NewsPublishVO> activitiService;


    @Override
    public TableModel searchNewsApplication(int page) {

        activitiService.init();
        List<Task> taskList = activitiService.findMyPersonalTask(page, Constants.NEWSAPPLY_PROCESS_MANAGERNAME, Constants.MANAGER_ROLE);
        //创建返回的list
        List<NewsPublishVO> arrayList = new ArrayList();
        for (Task task : taskList) {
            NewsPublishVO taskObjectParams = activitiService.findTaskObjectParams(task.getId(), Constants.ACTIVITI_OBJECT_NAME, NewsPublishVO.class);
            if (taskObjectParams != null) {
                arrayList.add(taskObjectParams);
            }
        }
        return TableModel.tableSuccess(arrayList, arrayList.size());
    }


    @Override
    public TableModel operateNew(NewsManagerOperationVO newsManagerOperationVO) {
        System.out.println(newsManagerOperationVO);
        return null;
    }
}
