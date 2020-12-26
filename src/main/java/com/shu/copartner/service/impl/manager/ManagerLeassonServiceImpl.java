package com.shu.copartner.service.impl.manager;

import com.shu.copartner.pojo.request.LeassonApplyVO;
import com.shu.copartner.service.ManagerLeassonService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ManagerLeassonServiceImpl implements ManagerLeassonService {
    @Override
    public TableModel operateNew(LeassonApplyVO leassonApplyVO) {
        System.out.println(leassonApplyVO);
        return null;
    }
}
