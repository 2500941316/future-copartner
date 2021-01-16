package com.shu.copartner.service;

import com.shu.copartner.pojo.request.ActivityPublishVO;
import com.shu.copartner.utils.returnobj.TableModel;

/**
 * @author
 * @date 2021/1/12 21:42
 * @description
 */
public interface ManagerActivityService {
    TableModel searchAllActivityManage(int page);

    TableModel searchActivityById(String activityId);

    TableModel updateActivityStatus(String activityId,String isPublish);

    TableModel deleteActivityById(String activityId);

    TableModel updateActivityInfo(ActivityPublishVO activityPublishVO);

    TableModel searchEnrolledPeople(int page,String activityId);
}
