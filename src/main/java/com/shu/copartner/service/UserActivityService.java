package com.shu.copartner.service;

import com.shu.copartner.pojo.request.ActivityPublishVO;
import com.shu.copartner.utils.returnobj.TableModel;

import java.security.Principal;

/**
 * @author
 * @date 2021/1/11 21:22
 * @description
 */
public interface UserActivityService {
    TableModel searchActivityListPublic(int currentPage);

    TableModel searchActivityList(int currentPage, Principal principal);


    TableModel searchActivityById(String activityId);

    TableModel operateActivityApply(ActivityPublishVO activityPublishVO,String creater);

    TableModel enrollInActivity(String activityId,String creater);

    TableModel cancelEnrollActivity(String activityId,String phone);

    TableModel searchMyCreatedActivity(int currentPage,String username);

    TableModel deleteActivityById(String activityId);
}
