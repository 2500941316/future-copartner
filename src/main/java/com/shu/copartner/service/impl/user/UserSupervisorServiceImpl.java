package com.shu.copartner.service.impl.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProSupervisorMapper;
import com.shu.copartner.pojo.ProSupervisor;
import com.shu.copartner.service.UserSupervisorService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        try{
            PageHelper.startPage(currentPage,6);
            List<ProSupervisor> proSupervisors = this.proSupervisorMapper.selectAllSupervisor();
            PageInfo pageInfo = new PageInfo(proSupervisors);
            return TableModel.success(proSupervisors,(int)pageInfo.getTotal());
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 根据姓名查询导师
     * @param supervisorName
     * @return
     */
    @Override
    public TableModel searchSupervisorByName(String supervisorName) {
        try{
            List<ProSupervisor> proSupervisors = this.proSupervisorMapper.selectSupervisorByName(supervisorName);
            return TableModel.success(proSupervisors,proSupervisors.size());
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 根据id查询导师详情
     * @param supervisorId
     * @return
     */
    @Override
    public TableModel searchSupervisorById(String supervisorId) {
        try{
            ProSupervisor proSupervisor = this.proSupervisorMapper.selectByPrimaryKey(Long.parseLong(supervisorId));
            List<ProSupervisor> proSupervisors = new ArrayList<>();
            proSupervisors.add(proSupervisor);
            return TableModel.success(proSupervisors,proSupervisors.size());
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 根据导师id查询该导师参加的项目
     * @param supervisorId
     * @return
     */
    @Override
    public TableModel searchSupervisorProject(String supervisorId) {
        try{
            List<ProSupervisor> proSupervisors = this.proSupervisorMapper.selectSupervisorProject(Long.parseLong(supervisorId));
            return TableModel.success(proSupervisors,proSupervisors.size());
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 根据导师id查询导师代表性成就
     * @param supervisorId
     * @return
     */
    @Override
    public TableModel searchSupervisorAchievement(String supervisorId) {
        try{
            List<ProSupervisor> proSupervisors = this.proSupervisorMapper.selectSupervisorAchievement(Long.parseLong(supervisorId));
            return TableModel.success(proSupervisors,proSupervisors.size());
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

}
