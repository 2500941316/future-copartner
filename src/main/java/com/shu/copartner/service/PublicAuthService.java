package com.shu.copartner.service;

import com.shu.copartner.utils.returnobj.TableModel;

/**
 * @author cxy
 */
public interface PublicAuthService {
    TableModel  registerGetVrifyCode(String phone);

    TableModel loginGetVerifyCode(String phone);
}
