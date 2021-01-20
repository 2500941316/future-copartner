package com.shu.copartner.service.impl.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProActivityMapper;
import com.shu.copartner.mapper.ProEnrollMapper;
import com.shu.copartner.pojo.ProActivity;
import com.shu.copartner.pojo.ProEnroll;
import com.shu.copartner.pojo.request.ActivityPublishVO;
import com.shu.copartner.service.ManagerActivityService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @date 2021/1/12 21:43
 * @description
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ManagerActivityServiceImpl implements ManagerActivityService {

    @Autowired
    private ProActivityMapper proActivityMapper;

    @Autowired
    private ProEnrollMapper proEnrollMapper;

    /**
     * 查询所有待管理活动信息
     * @param page
     * @return
     */
    @Override
    public TableModel searchAllActivityManage(int page) {
        try {
            // 表格每页10条
            PageHelper.startPage(page, 10);
            List<ProActivity> proActivityList = this.proActivityMapper.selectAllActivity();
            PageInfo pageInfo = new PageInfo(proActivityList);
            return TableModel.tableSuccess(proActivityList, (int) pageInfo.getTotal());
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 根据id查询待管理项目
     * @param activityId
     * @return
     */
    @Override
    public TableModel searchActivityById(String activityId) {
        try {
           //ProActivityManage proActivityManage = this.proActivityManageMapper.selectByPrimaryKey(Long.parseLong(activityManageId));
           ProActivity proActivity = this.proActivityMapper.selectByPrimaryKey(Long.parseLong(activityId));
            List<ProActivity> proActivityList = new ArrayList<>();
            proActivityList.add(proActivity);
           return TableModel.success(proActivityList,proActivityList.size());
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 设置活动发布状态
     * @param activityId
     * @param isPublish
     * @return
     */
    @Override
    public TableModel updateActivityStatus(String activityId, String isPublish) {
        try{
            // 更新 活动管理表状态
            ProActivity proActivity = this.proActivityMapper.selectByPrimaryKey(Long.parseLong(activityId));
            proActivity.setIsPublish(Integer.parseInt(isPublish));
            proActivity.setUpdateTime(new Date());
            this.proActivityMapper.updateByPrimaryKeySelective(proActivity);
            return TableModel.success();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 删除活动，is_deleted置 1
     * @param activityId
     * @return
     */
    @Override
    public TableModel deleteActivityById(String activityId) {
        try{
            ProActivity proActivity = new ProActivity();
            proActivity.setActivityId(Long.parseLong(activityId));
            proActivity.setIsDeleted(1);
            proActivity.setUpdateTime(new Date());
            proActivityMapper.updateByPrimaryKeySelective(proActivity);
            return TableModel.success();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 修改活动信息
     * @param activityPublishVO
     * @return
     */
    @Override
    public TableModel updateActivityInfo(ActivityPublishVO activityPublishVO) {
        try{
            ProActivity proActivity = new ProActivity();
            BeanUtils.copyProperties(activityPublishVO,proActivity);
            proActivity.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(activityPublishVO.getStartTime()));
            this.proActivityMapper.updateByPrimaryKeySelective(proActivity);
            return TableModel.success();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 查看活动报名人员
     * @param activityId
     * @return
     */
    @Override
    public TableModel searchEnrolledPeople(int page,String activityId) {
        try{
            // 每页10条
            PageHelper.startPage(page,10);
            List<ProEnroll> proEnrolls = proEnrollMapper.selectEnrollByActivityId(Long.parseLong(activityId));
            PageInfo pageInfo = new PageInfo(proEnrolls);
            return TableModel.tableSuccess(proEnrolls,(int)pageInfo.getTotal());
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }

    }
}
