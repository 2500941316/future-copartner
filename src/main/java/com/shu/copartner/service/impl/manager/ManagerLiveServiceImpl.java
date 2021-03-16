package com.shu.copartner.service.impl.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProLiveMapper;
import com.shu.copartner.pojo.ProLive;
import com.shu.copartner.pojo.request.LivePublishVO;
import com.shu.copartner.service.ManagerLiveService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @date 2021/1/18 20:24
 * @description
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ManagerLiveServiceImpl implements ManagerLiveService {

    @Autowired
    private ProLiveMapper proLiveMapper;

    /**
     * 发布直播信息
     * @param livePublishVO
     * @return
     */
    @Override
    public TableModel publishLiveInfo(LivePublishVO livePublishVO) {
        try{
            ProLive proLive = new ProLive();
            BeanUtils.copyProperties(livePublishVO,proLive);
            proLive.setLiveDuration(Integer.parseInt(livePublishVO.getLiveDuration())); // 设置直播时长
            if(proLive.getLiveUrl().indexOf("https://") < 0 && proLive.getLiveUrl().indexOf("http://") < 0){
                proLive.setLiveUrl("https://"+proLive.getLiveUrl());
            }
            proLive.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(livePublishVO.getStartTime()));
            proLive.setLiveStatus(Constants.LIVE_BEFORE_START); // 发布时，直播 '未开始'
            proLiveMapper.insert(proLive);
            return TableModel.success();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 修改直播信息
     * @param livePublishVO
     * @return
     */
    @Override
    public TableModel updateLiveInfo(LivePublishVO livePublishVO) {
        try{
            ProLive proLive = new ProLive();
            BeanUtils.copyProperties(livePublishVO,proLive);
            proLive.setLiveDuration(Integer.parseInt(livePublishVO.getLiveDuration())); // 设置直播时长
            if(proLive.getLiveUrl().indexOf("https://") < 0 && proLive.getLiveUrl().indexOf("http://") < 0){
                proLive.setLiveUrl("https://"+proLive.getLiveUrl());
            }
            proLive.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(livePublishVO.getStartTime()));
            proLiveMapper.updateByPrimaryKeySelective(proLive);
            return TableModel.success();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 查询所有直播信息
     * @param page
     * @return
     */
    @Override
    public TableModel searchAllLives(int page) {
        try{
            this.fixTimeRun(); // 定时任务，确定直播状态
            PageHelper.startPage(page,10);
            List<ProLive> proLiveList = proLiveMapper.selectAllLives();
            PageInfo pageInfo = new PageInfo(proLiveList);
            return TableModel.tableSuccess(proLiveList,(int)pageInfo.getTotal());
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 删除直播
     * @param liveId
     * @return
     */
    @Override
    public TableModel deleteLiveById(String liveId) {
        try{
            ProLive proLive = new ProLive();
            proLive.setLiveId(Long.parseLong(liveId));
            proLive.setIsDeleted(1);
            proLive.setEndTime(new Date());
            proLiveMapper.updateByPrimaryKeySelective(proLive);
            return TableModel.success();
        }catch(Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 根据id查询直播
     * @param liveId
     * @return
     */
    @Override
    public TableModel searchLiveById(String liveId) {
        try {
            ProLive proLive = proLiveMapper.selectByPrimaryKey(Long.parseLong(liveId));
            List<ProLive> proLives = new ArrayList<>();
            proLives.add(proLive);
            return TableModel.success(proLives,proLives.size());
        } catch (Exception e) {
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
        service.schedule(new ManagerLiveServiceImpl.FixedDelayTask(), initialDelay, TimeUnit.SECONDS);
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

    @Test
    public void testStr(){
       /* String regEx = "[https://http://]"; //`~!@#$%^&*()+=|{}':;',\[\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？
        String str = "http://www.baidu.com";
        String newString = str.replaceAll(regEx, "");//不想保留原来的字符串可以直接写成 “str =
        System.out.println(newString);*/

       String str = "https://www.baidu.com";
       if(str.indexOf("https://") < 0 && str.indexOf("http://") < 0){
           System.out.println("不含有https://");
       }
       System.out.println(str.indexOf("https://")+"");
    }
}
