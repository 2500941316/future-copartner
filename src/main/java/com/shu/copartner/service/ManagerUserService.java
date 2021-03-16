package com.shu.copartner.service;

import com.shu.copartner.pojo.request.PassRegistryVO;
import com.shu.copartner.utils.returnobj.TableModel;

/**
 * @author cxy
 */
public interface ManagerUserService {
    TableModel searchRegistry(int page);

    TableModel rejectRegistry(Long id, String phone,String value);

    TableModel passRegistry(PassRegistryVO passRegistryVO);

    TableModel searchUserExceptManager(int page);

    TableModel setManager(String userid);
}
