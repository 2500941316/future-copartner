package com.shu.copartner.service;

import com.shu.copartner.pojo.request.PassRegistryVO;
import com.shu.copartner.utils.returnobj.TableModel;

/**
 * @author cxy
 */
public interface ManagerUserService {
    TableModel searchRegistry(int page);

    TableModel rejectRegistry(Long id, String value);

    TableModel passRegistry(PassRegistryVO passRegistryVO);
}
