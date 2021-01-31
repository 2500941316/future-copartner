package com.shu.copartner.service.impl.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ActRuVariableMapper;
import com.shu.copartner.mapper.ProNewsMapper;
import com.shu.copartner.pojo.ProNews;
import com.shu.copartner.pojo.ProNewsExample;
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
    ProNewsMapper proNewsMapper;


    @Override
    public TableModel searchNewsApplication(int page) {
        List<ProNews> arrayList = new ArrayList<>();
        int count;
        try {
            ProNewsExample proNewsExample = new ProNewsExample();
            PageHelper.startPage(page, Constants.PAGESIZE);
            proNewsExample.createCriteria().andIsdeletedEqualTo(Constants.NO_DELETED)
                    .andIsauditEqualTo(Constants.NO_DELETED);
            arrayList = proNewsMapper.selectByExample(proNewsExample);
            PageInfo pageInfo = new PageInfo(arrayList, 5);
            count = (int) pageInfo.getTotal();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.tableSuccess(arrayList, count);
    }


    @Override
    public TableModel operateNew(NewsManagerOperationVO newsManagerOperationVO) {
        //更新新闻状态:如果status值为1，则表示同意否则就是驳回
        ProNewsWithBLOBs proNewsWithBLOBs = new ProNewsWithBLOBs();
        BeanUtils.copyProperties(newsManagerOperationVO, proNewsWithBLOBs);
        proNewsWithBLOBs.setNewsId(Long.parseLong(newsManagerOperationVO.getNewsId()));
        try {
            proNewsMapper.updateByPrimaryKeySelective(proNewsWithBLOBs);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.success();
    }
}
