package com.shu.copartner.service.impl.manager;

import com.shu.copartner.mapper.ProNewsMapper;
import com.shu.copartner.pojo.ProNews;
import com.shu.copartner.pojo.ProNewsExample;
import com.shu.copartner.pojo.ProNewsWithBLOBs;
import com.shu.copartner.pojo.request.NewsManagerOperationVO;
import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.pojo.response.NewsInfoSo;
import com.shu.copartner.service.ManagerNewsService;
import com.shu.copartner.service.impl.ActivitiServiceImpl;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
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
    ActivitiServiceImpl<NewsPublishVO> activitiService;

    @Autowired
    ProNewsMapper proNewsMapper;


    @Override
    public TableModel searchNewsApplication(int page) {

        activitiService.init();
        List<Task> taskList = activitiService.findMyPersonalTask(page, Constants.NEWSAPPLY_PROCESS_MANAGERNAME, Constants.MANAGER_ROLE);
        //创建返回的list
        List<NewsInfoSo> arrayList = new ArrayList();
        for (Task task : taskList) {
            NewsPublishVO taskObjectParams = activitiService.findTaskObjectParams(task.getId(), Constants.ACTIVITI_OBJECT_NAME, NewsPublishVO.class);
            if (taskObjectParams != null) {
                NewsInfoSo newsInfoSo = new NewsInfoSo();
                BeanUtils.copyProperties(taskObjectParams, newsInfoSo);
                newsInfoSo.setTaskId(task.getId());
                arrayList.add(newsInfoSo);
            }
        }
        return TableModel.tableSuccess(arrayList, arrayList.size());
    }


    @Override
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
}
