package com.shu.copartner.service;

import com.shu.copartner.pojo.request.SupervisorPublishVO;
import com.shu.copartner.utils.returnobj.TableModel;

/**
 * @author
 * @date 2021/1/5 13:50
 * @description
 */
public interface ManagerSupervisorService {

    TableModel operateSupervisorPublish(SupervisorPublishVO supervisorPublishVO);

    TableModel updateSupervisorInfo(SupervisorPublishVO supervisorPublishVO);

    TableModel deleteSuperviosrById(String supervisorId);

    TableModel searchAllSupervisor(int page);

    TableModel addSupervisorAchievement(String supervisorId,String achievement);
}
