package com.shu.copartner.service;

import com.shu.copartner.pojo.request.LeassonApplyVO;
import com.shu.copartner.pojo.request.LeassonVedioUpdateVO;
import com.shu.copartner.utils.returnobj.TableModel;

public interface ManagerLeassonService {
    TableModel applyLeasson(LeassonApplyVO leassonApplyVO);

    TableModel getLeassonInfo(int page);

    TableModel updateLeasson(LeassonVedioUpdateVO leassonVedioUpdateVO);
}
