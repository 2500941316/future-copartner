package com.shu.copartner.service;

import com.shu.copartner.utils.returnobj.TableModel;

/**
 * @author cxy
 */
public interface PublicAuthService {
    TableModel getverifyCode(String phone);
}
