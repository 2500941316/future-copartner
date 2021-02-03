package com.shu.copartner.service;

import com.shu.copartner.pojo.request.PublicRegistryInfoVO;
import com.shu.copartner.utils.returnobj.TableModel;

/**
 * @author
 * @date 2021/2/1 16:36
 * @description
 */
public interface VipUserService {
    TableModel selectPersonalInfo(String username);

    TableModel updatePersonalInfo(PublicRegistryInfoVO publicRegistryInfoVO);
}
