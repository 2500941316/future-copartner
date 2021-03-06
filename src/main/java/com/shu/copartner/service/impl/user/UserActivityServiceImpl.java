package com.shu.copartner.service.impl.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProActivityMapper;
import com.shu.copartner.mapper.ProEnrollMapper;
import com.shu.copartner.mapper.ProUserMapper;
import com.shu.copartner.pojo.*;
import com.shu.copartner.pojo.request.ActivityPublishVO;
import com.shu.copartner.service.UserActivityService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author
 * @date 2021/1/11 21:23
 * @description
 */
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class UserActivityServiceImpl implements UserActivityService {
    @Autowired
    private ProActivityMapper proActivityMapper;

    @Autowired
    private ProEnrollMapper proEnrollMapper;

    @Autowired
    private ProUserMapper proUserMapper;

    @Override
    public TableModel searchActivityListPublic(int currentPage) {
        try {
            // 当没有登录查询活动时直接查询出全部活动
            PageHelper.startPage(currentPage, 6);
            List<ProActivity> proActivityList = this.proActivityMapper.selectAllActivityPublished();
            // 定时任务
            this.fixTimeRun();
            PageInfo pageInfo = new PageInfo(proActivityList);
            return TableModel.success(proActivityList, (int) pageInfo.getTotal());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 查询活动列表，每页最多5条
     *
     * @param currentPage
     * @return
     */
    @Override
    public TableModel searchActivityList(int currentPage, Principal principal) {
        try {
            if(principal!=null){
                //先根据用户名查询出其userId
                ProUserExample proUserExample = new ProUserExample();
                proUserExample.createCriteria().andPhoneEqualTo(principal.getName());
                List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
                Long userId = proUsers.get(0).getUserid();

                // 分页查询活动信息
                PageHelper.startPage(currentPage, 6);
                List<ProActivity> proActivityList = this.proActivityMapper.selectAllActivityPublished();
                // 去除活动内容的html标签
                for (ProActivity pa : proActivityList) {
                    pa.setActivityContent(delHtmlTag(pa.getActivityContent()));
                }

                // 查询报名表 设置当前用户的报名活动
                List<ProEnroll> proEnrolls = this.proEnrollMapper.selectEnrollByPersonId(userId);

                // 定时任务
                this.fixTimeRun();
                for (ProActivity pa : proActivityList) {
                    for (ProEnroll pe : proEnrolls) {
                        if (pa.getActivityId() == pe.getActivityId()) {
                            // 代表当前用户已报名该活动
                            pa.setIsEnrolled(1);
                        }
                    }
                }
                PageInfo pageInfo = new PageInfo(proActivityList);
                return TableModel.success(proActivityList, (int) pageInfo.getTotal());
            }

            // 当没有登录查询活动时直接查询出全部活动
            PageHelper.startPage(currentPage, 6);
            List<ProActivity> proActivityList = this.proActivityMapper.selectAllActivityPublished();
            PageInfo pageInfo = new PageInfo(proActivityList);
            return TableModel.success(proActivityList, (int) pageInfo.getTotal());

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 根据id查询活动详情，根据时间倒序
     *
     * @param activityId
     * @return
     */
    @Override
    public TableModel searchActivityById(String activityId) {
        try {
            // 根据id查询活动
            ProActivity proActivity = this.proActivityMapper.selectByPrimaryKey(Long.parseLong(activityId));
            List<ProActivity> activityDetails = new ArrayList<>();
            activityDetails.add(proActivity);
            return TableModel.success(activityDetails, activityDetails.size());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 处理活动创建申请
     *
     * @param activityPublishVO
     * @return
     */
    @Override
    public TableModel operateActivityApply(ActivityPublishVO activityPublishVO, String phone) {
        try {
            // 先通过phone查询出当前人姓名
            ProUserExample proUserExample = new ProUserExample();
            proUserExample.createCriteria().andPhoneEqualTo(phone);
            List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
            String username = proUsers.get(0).getName();

            //补全活动参数信息
            activityPublishVO.setActivityAuthor(username);// 设置当前申请人
            activityPublishVO.setIsPublish(0); // 默认未发布
            activityPublishVO.setActivityStatus(Constants.ACTIVITY_BEFORE_START); // '未开始'

            //先将活动信息写入 活动表
            ProActivity proActivity = new ProActivity();
            BeanUtils.copyProperties(activityPublishVO, proActivity);
            proActivity.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(activityPublishVO.getStartTime()));
            this.proActivityMapper.insert(proActivity);

            return TableModel.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /*ProActivity proActivity = this.proActivityMapper.selectByPrimaryKey(Long.parseLong(activityId));
    String activityPart = proActivity.getActivityParticipator();
            if(StringUtils.isNotEmpty(activityPart)){
        // 报名人非空
        StringBuilder ids = new StringBuilder(activityPart);
        ids.append(userId).append(",");
        proActivity.setActivityParticipator(ids.toString());
    }else{
        // 报名人为空
        StringBuilder ids = new StringBuilder();
        ids.append(userId).append(",");
        proActivity.setActivityParticipator(ids.toString());
    }
    this.proActivityMapper.updateByPrimaryKeySelective(proActivity);
    */

    /**
     * 报名活动
     * @param activityId
     * @param creater
     * @return
     */
    @Override
    public TableModel enrollInActivity(String activityId, String creater) {
        try {
            //先根据用户名查询出其userId
            ProUserExample proUserExample = new ProUserExample();
            proUserExample.createCriteria().andPhoneEqualTo(creater);
            List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
            Long userId = proUsers.get(0).getUserid();
            String username = proUsers.get(0).getName();
            log.info("用户id："+userId);

            // 将活动id与当前用户信息写到报名表中
            ProEnroll proEnroll001 = proEnrollMapper.selectEnrollByPersonActivityId(userId, Long.parseLong(activityId));
            if (proEnroll001!=null) {
                // 如果之前已经取消报名该活动，再次报名时就直接置is_deleted为0
                proEnroll001.setPersonName(username);// 设置报名人名字，不是phone
                proEnroll001.setIsDeleted(0);
                proEnroll001.setEnrollTime(new Date());
                this.proEnrollMapper.updateByPrimaryKeySelective(proEnroll001);
            } else {
                // 第一次报名该活动则将信息写入 报名表
                ProEnroll proEnroll = new ProEnroll();
                proEnroll.setIsDeleted(0);
                proEnroll.setActivityId(Long.parseLong(activityId));
                proEnroll.setPersonId(userId);
                proEnroll.setPersonName(username); // 设置报名人名字，不是phone
                proEnroll.setEnrollTime(new Date());
                proEnrollMapper.insert(proEnroll);
            }
            return TableModel.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 取消报名活动,活动表is_deleted置 1
     *
     * @param activityId
     * @param phone
     * @return
     */
    @Override
    public TableModel cancelEnrollActivity(String activityId, String phone) {
        try {
            //先根据用户名查询出其userId
            ProUserExample proUserExample = new ProUserExample();
            proUserExample.createCriteria().andPhoneEqualTo(phone);
            List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
            String username = proUsers.get(0).getName(); // 获取报名人名字

            // 将活动id与当前用户信息写到报名表中
            ProEnroll proEnroll = new ProEnroll();
            proEnroll.setIsDeleted(1);
            proEnroll.setActivityId(Long.parseLong(activityId));
            proEnroll.setPersonName(username);
            proEnroll.setUnerollTime(new Date()); // 取消关注的时间
            ProEnrollExample proEnrollExample = new ProEnrollExample();
            proEnrollExample.createCriteria().andActivityIdEqualTo(Long.parseLong(activityId)).andPersonNameEqualTo(username);
            this.proEnrollMapper.updateByExampleSelective(proEnroll, proEnrollExample);
            return TableModel.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 查询我创建的活动
     * @param currentPage
     * @param username
     * @return
     */
    @Override
    public TableModel searchMyCreatedActivity(int currentPage, String username) {
        try{
            PageHelper.startPage(currentPage,4);
            ProActivityExample proActivityExample = new ProActivityExample();
            proActivityExample.setOrderByClause(Constants.START_TIME_DESCBYDATE);// 按照开始时间倒序
            proActivityExample.createCriteria().andActivityAuthorEqualTo(username).andIsDeletedEqualTo(0);
            List<ProActivity> proActivityList = proActivityMapper.selectByExample(proActivityExample);
            PageInfo pageInfo = new PageInfo(proActivityList);
             return TableModel.success(proActivityList,(int)pageInfo.getTotal());
        } catch (Exception e) {
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
     * 将字符串过滤掉html
     *
     * @param htmlStr
     * @return
     */
    public String delHtmlTag(String htmlStr) {
        String regExStyle = "<style[^>]*?>[\\s\\S]*?<\\/style>";
        String regExHtml = "<[^>]+>";
        Pattern pStyle = Pattern.compile(regExStyle, Pattern.CASE_INSENSITIVE);
        Matcher mStyle = pStyle.matcher(htmlStr);
        htmlStr = mStyle.replaceAll("");
        Pattern pHtml = Pattern.compile(regExHtml, Pattern.CASE_INSENSITIVE);
        Matcher mHtml = pHtml.matcher(htmlStr);
        htmlStr = mHtml.replaceAll("");
        htmlStr = htmlStr.replace(" ", "");
        htmlStr = htmlStr.replaceAll("\\s*|\t|\r|\n", "");
        htmlStr = htmlStr.replace("“", "");
        htmlStr = htmlStr.replace("”", "");
        htmlStr = htmlStr.replaceAll("　", "");

        return htmlStr.trim();
    }


    /**
     * 定时任务，更新activity状态
     */
    public void fixTimeRun() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        long initialDelay = 1;
        long period = 1;
        service.schedule(new FixedDelayTask(), initialDelay,TimeUnit.SECONDS);
    }
    // 定时任务中执行的方法
     class FixedDelayTask implements Runnable {
        long fiveHours = 5*60*60*1000;
        @Override
        public void run() {
            List<ProActivity> proActivityList = proActivityMapper.selectAllActivityPublished();
            for (ProActivity pa : proActivityList) {
                if(pa.getStartTime().before(new Date(System.currentTimeMillis()-fiveHours))){
                    //log.info(pa.getStartTime() + "- 已结束");
                    pa.setActivityStatus(Constants.ACTIVITY_AFTER_START); // 活动过去5小时，转为‘已结束’
                    try {
                        // 更新数据库中的活动状态
                        proActivityMapper.updateByPrimaryKeySelective(pa);
                    }catch (Exception e){
                        log.error(e.getMessage());
                        throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
                    }
                }else if(pa.getStartTime().before(new Date(System.currentTimeMillis()))) {
                    //log.info(pa.getStartTime() + "- 进行中");
                    pa.setActivityStatus(Constants.ACTIVITY_IN_START);// 活动 '进行中'
                    try {
                        // 更新数据库中的活动状态
                        proActivityMapper.updateByPrimaryKeySelective(pa);
                    }catch (Exception e){
                        log.error(e.getMessage());
                        throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
                    }
                }else if(pa.getStartTime().after(new Date(System.currentTimeMillis()))) {
                    //log.info(pa.getStartTime() + "- 未开始");
                    pa.setActivityStatus(Constants.ACTIVITY_AFTER_START);// 活动 '未开始'
                    try {
                        // 更新数据库中的活动状态
                        proActivityMapper.updateByPrimaryKeySelective(pa);
                    }catch (Exception e){
                        log.error(e.getMessage());
                        throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
                    }
                }
            }
        }
    }
}
