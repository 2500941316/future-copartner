package com.shu.copartner.service;

import com.shu.copartner.pojo.request.PublicRegistryInfoVO;
import com.shu.copartner.utils.returnobj.TableModel;

import java.security.Principal;

/**
 * @author cxy
 */
public interface PublicAuthService {
    TableModel  registerGetVrifyCode(String phone);

    TableModel loginGetVerifyCode(String phone);

    TableModel registry(PublicRegistryInfoVO registryInfoVO);

    TableModel checkAuth(Principal principal);
}
