package com.shu.copartner.service;

import com.shu.copartner.pojo.request.ActivityPublishVO;
import com.shu.copartner.utils.returnobj.TableModel;

/**
 * @author
 * @date 2021/1/11 21:22
 * @description
 */
public interface UserActivityService {
    TableModel searchActivityList(int currentPage,Long userId);

    TableModel searchActivityById(String activityId);

    TableModel operateActivityApply(ActivityPublishVO activityPublishVO,String creater);

    TableModel enrollInActivity(String activityId,Long userId,String creater);

    TableModel cancelEnrollActivity(String activityId,Long userId);
}
