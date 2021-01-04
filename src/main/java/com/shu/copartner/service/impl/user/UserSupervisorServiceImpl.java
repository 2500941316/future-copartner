package com.shu.copartner.service.impl.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.copartner.mapper.ProSupervisorMapper;
import com.shu.copartner.pojo.ProSupervisor;
import com.shu.copartner.service.UserSupervisorService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author
 * @date 2021/1/4 9:50
 * @description
 */
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class UserSupervisorServiceImpl implements UserSupervisorService {

    @Autowired
    private ProSupervisorMapper proSupervisorMapper;

    /**
     * 查询导师列表，每页最多6条
     * @param currentPage
     * @return
     */
    @Override
    public TableModel searchSupervisor(int currentPage) {
        PageHelper.startPage(currentPage,6);
        List<ProSupervisor> proSupervisors = this.proSupervisorMapper.selectAllSupervisor();
        PageInfo pageInfo = new PageInfo(proSupervisors);
        return TableModel.success(proSupervisors,(int)pageInfo.getTotal());
    }

}
