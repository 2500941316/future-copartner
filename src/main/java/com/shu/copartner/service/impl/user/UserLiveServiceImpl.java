package com.shu.copartner.service.impl.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProLiveMapper;
import com.shu.copartner.pojo.ProActivity;
import com.shu.copartner.pojo.ProLive;
import com.shu.copartner.service.UserLiveService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @date 2021/1/18 18:35
 * @description
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserLiveServiceImpl implements UserLiveService {

    @Autowired
    private ProLiveMapper proLiveMapper;

    /**
     * 查询直播列表
     * @param currentPage
     * @return
     */
    @Override
    public TableModel searchLiveList(int currentPage) {
        try{
            PageHelper.startPage(currentPage,8);
            List<ProLive> proLiveList = proLiveMapper.selectAllLives();
            PageInfo pageInfo = new PageInfo(proLiveList);
            this.fixTimeRun();// 定时任务

            return TableModel.success(proLiveList,(int)pageInfo.getTotal());
        }catch(Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 定时任务
     */
    public void fixTimeRun() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        long initialDelay = 0;
        service.schedule(new UserLiveServiceImpl.FixedDelayTask(), initialDelay, TimeUnit.SECONDS);
    }
    // 定时任务中执行的方法
     class FixedDelayTask implements Runnable {
        @Override
        public void run() {
            List<ProLive> proLives = proLiveMapper.selectAllLives();
            for (ProLive pl: proLives) {
                if(pl.getStartTime().before(new Date(System.currentTimeMillis()-pl.getLiveDuration()*60*60*1000))){
                    //log.info(pa.getStartTime() + "- 已结束");
                    pl.setLiveStatus(Constants.LIVE_AFTER_START); // 当前时间超过设置的时长，转为‘已结束’
                    try {
                        // 更新数据库中的直播状态
                        proLiveMapper.updateByPrimaryKeySelective(pl);
                    }catch (Exception e){
                        log.error(e.getMessage());
                        throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
                    }
                }else if(pl.getStartTime().before(new Date(System.currentTimeMillis()))) {
                    //log.info(pa.getStartTime() + "- 进行中");
                    pl.setLiveStatus(Constants.LIVE_IN_START);// 直播 '进行中'
                    try {
                        // 更新数据库中的直播状态
                        proLiveMapper.updateByPrimaryKeySelective(pl);
                    }catch (Exception e){
                        log.error(e.getMessage());
                        throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
                    }
                }else if(pl.getStartTime().after(new Date(System.currentTimeMillis()))) {
                    //log.info(pa.getStartTime() + "- 未开始");
                    pl.setLiveStatus(Constants.LIVE_AFTER_START);// 直播 '未开始'
                    try {
                        // 更新数据库中的直播状态
                        proLiveMapper.updateByPrimaryKeySelective(pl);
                    }catch (Exception e){
                        log.error(e.getMessage());
                        throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
                    }
                }
            }
        }
    }
}
