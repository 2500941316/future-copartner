package com.shu.copartner.service.impl.manager;

import com.shu.copartner.mapper.ActRuVariableMapper;
import com.shu.copartner.mapper.ProNewsMapper;
import com.shu.copartner.pojo.ActRuVariable;
import com.shu.copartner.pojo.ActRuVariableExample;
import com.shu.copartner.pojo.ProNews;
import com.shu.copartner.pojo.request.NewsManagerOperationVO;
import com.shu.copartner.pojo.response.NewsInfoSo;
import com.shu.copartner.service.ManagerNewsService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
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
    private ActRuVariableMapper actRuVariableMapper;

    @Autowired
    private TaskService taskService;

    @Autowired
    ProNewsMapper proNewsMapper;


    @Override
    public TableModel searchNewsApplication(int page) {
        long count = taskService.createTaskQuery().taskAssignee(Constants.MANAGER_ROLE)
                .taskName(Constants.NEWSAPPLY_PROCESS_MANAGERNAME).count();
        List<Task> taskList = taskService.createTaskQuery()
                .taskAssignee(Constants.MANAGER_ROLE)
                .taskName(Constants.NEWSAPPLY_PROCESS_MANAGERNAME)
                .listPage(Constants.pageSize * (page - 1), Constants.pageSize);
        List<NewsInfoSo> arrayList = new ArrayList<>();
        for (Task task : taskList) {
            ActRuVariableExample actRuVariableExample = new ActRuVariableExample();
            actRuVariableExample.createCriteria().andExecutionIdEqualTo(task.getProcessInstanceId()).andLongIsNotNull();
            List<ActRuVariable> actRuVariables = actRuVariableMapper.selectByExample(actRuVariableExample);
            if (actRuVariables.size() == 1) {
                ProNews proNews = proNewsMapper.selectByPrimaryKey(actRuVariables.get(0).getLong());
                NewsInfoSo newsInfoSo = new NewsInfoSo();
                BeanUtils.copyProperties(proNews, newsInfoSo);
                newsInfoSo.setTaskId(task.getId());
                arrayList.add(newsInfoSo);
            }
        }
        return TableModel.tableSuccess(arrayList, (int) count);
    }


    @Override
    public TableModel operateNew(NewsManagerOperationVO newsManagerOperationVO) {
        //如果完成了审批任务，则将结果直接存入news表，同意的和拒绝的
        taskService.complete(newsManagerOperationVO.getTaskId());
        //更新新闻状态:如果status值为1，则表示同意否则就是驳回
        ProNews proNews = new ProNews();
        BeanUtils.copyProperties(newsManagerOperationVO, proNews);
        proNews.setNewsId(Long.parseLong(newsManagerOperationVO.getNewsId()));
        proNewsMapper.updateByPrimaryKeySelective(proNews);
        return TableModel.success("success");
    }
}
