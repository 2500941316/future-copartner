package com.shu.copartner.service.impl.manager;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.pagehelper.PageHelper;
import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProLogMapper;
import com.shu.copartner.mapper.ProSupervisorMapper;
import com.shu.copartner.pojo.ProLog;
import com.shu.copartner.pojo.ProLogExample;
import com.shu.copartner.pojo.ProSupervisor;
import com.shu.copartner.pojo.request.SupervisorPublishVO;
import com.shu.copartner.service.ManagerSupervisorService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author
 * @date 2021/1/5 13:50
 * @description
 */
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class ManagerSupervisorServiceImpl implements ManagerSupervisorService {

    @Autowired
    private ProSupervisorMapper proSupervisorMapper;

    @Autowired
    private ProLogMapper proLogMapper;

    /**
     * 处理导师信息发布
     * @param supervisorPublishVO
     * @return
     */
    @Override
    public TableModel operateSupervisorPublish(SupervisorPublishVO supervisorPublishVO) {
        try{
            ProSupervisor proSupervisor = new ProSupervisor();
            BeanUtils.copyProperties(supervisorPublishVO,proSupervisor);
            proSupervisor.setStartTime(new Date());
            proSupervisorMapper.insert(proSupervisor);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
         }
        return TableModel.success();
    }

    /**
     * 导师信息修改
     * @param supervisorPublishVO
     * @return
     */
    @Override
    public TableModel updateSupervisorInfo(SupervisorPublishVO supervisorPublishVO) {
        try{
            ProSupervisor proSupervisor = new ProSupervisor();
            BeanUtils.copyProperties(supervisorPublishVO,proSupervisor);
            proSupervisorMapper.updateByPrimaryKeySelective(proSupervisor);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
          }
        return TableModel.success();
    }

    /**
     * 根据id删除导师信息，将is_deleted置为 1
     * @param supervisorId
     * @return
     */
    @Override
    public TableModel deleteSuperviosrById(String supervisorId) {
        try {
            ProSupervisor proSupervisor = new ProSupervisor();
            proSupervisor.setSupervisorId(Long.parseLong(supervisorId));
            proSupervisor.setIsDeleted(1);
            // 设置删除时间
            proSupervisor.setEndTime(new Date());
            proSupervisorMapper.updateByPrimaryKeySelective(proSupervisor);

            //删除导师代表性成就
            ProLog proLog = new ProLog();
            proLog.setLogSupervisorId(Long.parseLong(supervisorId));
            proLog.setIsDeleted(1);
            proLog.setEndTime(new Date());
            ProLogExample proLogExample = new ProLogExample();
            proLogExample.createCriteria().andLogSupervisorIdEqualTo(Long.parseLong(supervisorId));
            proLogMapper.updateByExampleSelective(proLog,proLogExample);
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.success();
    }

    /**
     * 查询所有导师信息
     * @return
     */
    @Override
    public TableModel searchAllSupervisor(int page) {
        try{
            //每页10条
            PageHelper.startPage(page,10);
            List<ProSupervisor> proSupervisorList = proSupervisorMapper.selectAllSupervisor();
            return TableModel.tableSuccess(proSupervisorList,proSupervisorList.size());
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 添加导师代表性成就
     * @param supervisorId
     * @param achievement
     * @return
     */
    @Override
    public TableModel addSupervisorAchievement(String supervisorId, String achievement) {
        log.info(supervisorId+achievement);
        try{
            ProLog proLog = new ProLog();
            proLog.setLogSupervisorId(Long.parseLong(supervisorId));
            proLog.setLogSupervisorAchievement(achievement);
            proLog.setLogType("导师");
            proLog.setIsDeleted(0);
            proLog.setStartTime(new Date());
            proLog.setUpdateTime(new Date());
            proLogMapper.insert(proLog);
            return TableModel.success();
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }
}
