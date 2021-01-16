package com.shu.copartner.service;

import com.shu.copartner.utils.returnobj.TableModel;

/**
 * @author
 * @date 2021/1/4 9:49
 * @description
 */
public interface UserSupervisorService {
    TableModel searchSupervisor(int currnetPage);

    TableModel searchAllSupervisor();

    TableModel searchSupervisorByName(String supervisorName);

    TableModel searchSupervisorById(String supervisorId);

    TableModel searchSupervisorProject(String supervisorId);

    TableModel searchSupervisorAchievement(String supervisorId);
}
