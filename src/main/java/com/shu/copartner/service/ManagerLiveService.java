package com.shu.copartner.service;

import com.shu.copartner.pojo.request.LivePublishVO;
import com.shu.copartner.utils.returnobj.TableModel;

/**
 * @author
 * @date 2021/1/18 20:23
 * @description
 */
public interface ManagerLiveService {
    TableModel publishLiveInfo(LivePublishVO livePublishVO);

    TableModel updateLiveInfo(LivePublishVO livePublishVO);

    TableModel searchAllLives(int page);

    TableModel deleteLiveById(String liveId);

    TableModel searchLiveById(String liveId);
}
