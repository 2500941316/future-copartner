package com.shu.copartner.service.impl.manager;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ActRuVariableMapper;
import com.shu.copartner.mapper.ProNewsMapper;
import com.shu.copartner.pojo.ProNews;
import com.shu.copartner.pojo.ProNewsWithBLOBs;
import com.shu.copartner.pojo.request.NewsManagerOperationVO;
import com.shu.copartner.pojo.response.NewsInfoSo;
import com.shu.copartner.service.ManagerNewsService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxy
 * @Date: 2020/12/21 15:19
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class ManagerNewsServiceImpl implements ManagerNewsService {


    @Autowired
    private ActRuVariableMapper actRuVariableMapper;

    @Autowired
    private TaskService taskService;

    @Autowired
    ProNewsMapper proNewsMapper;


    @Override
    public TableModel searchNewsApplication(int page) {
        List<NewsInfoSo> arrayList = new ArrayList<>();
        long count;
        try {
            count = taskService.createTaskQuery().taskAssignee(Constants.MANAGER_ROLE)
                    .taskName(Constants.NEWSAPPLY_PROCESS_MANAGERNAME).count();
            List<Task> taskList = taskService.createTaskQuery()
                    .taskAssignee(Constants.MANAGER_ROLE)
                    .taskName(Constants.NEWSAPPLY_PROCESS_MANAGERNAME)
                    .listPage(Constants.PAGESIZE * (page - 1), Constants.PAGESIZE);
            for (Task task : taskList) {
                Object variable = taskService.getVariable(task.getId(), Constants.ACTIVITI_OBJECT_NAME);
                if (variable != null) {
                    ProNews proNews = proNewsMapper.selectByPrimaryKey((Long) variable);
                    NewsInfoSo newsInfoSo = new NewsInfoSo();
                    BeanUtils.copyProperties(proNews, newsInfoSo);
                    newsInfoSo.setTaskId(task.getId());
                    arrayList.add(newsInfoSo);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.tableSuccess(arrayList, (int) count);
    }


    @Override
    public TableModel operateNew(NewsManagerOperationVO newsManagerOperationVO) {
        //更新新闻状态:如果status值为1，则表示同意否则就是驳回
        ProNewsWithBLOBs proNewsWithBLOBs = new ProNewsWithBLOBs();
        BeanUtils.copyProperties(newsManagerOperationVO, proNewsWithBLOBs);
        proNewsWithBLOBs.setNewsId(Long.parseLong(newsManagerOperationVO.getNewsId()));
        try {
            //如果完成了审批任务，则将结果直接存入news表，同意的和拒绝的
            taskService.complete(newsManagerOperationVO.getTaskId());
            proNewsMapper.updateByPrimaryKeySelective(proNewsWithBLOBs);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.success();
    }
}
