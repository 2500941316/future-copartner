package com.shu.copartner.service.impl.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.*;
import com.shu.copartner.pojo.*;
import com.shu.copartner.pojo.request.PassRegistryVO;
import com.shu.copartner.service.ManagerUserService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author cxy
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class ManagerUserServiceImpl implements ManagerUserService {

    @Autowired
    ProRegisterMapper proRegisterMapper;

    @Autowired
    ProUserMapper proUserMapper;

    @Autowired
    ProTeacherMapper proTeacherMapper;

    @Autowired
    ProPersonMapper proPersonMapper;

    @Autowired
    ProStudentMapper proStudentMapper;

    @Override
    public TableModel searchRegistry(int page) {
        List<ProRegister> proRegisters;
        //查询注册表状态为1的记录
        ProRegisterExample proRegisterExample = new ProRegisterExample();
        proRegisterExample.createCriteria().andApplystatusEqualTo(Constants.REGISTER_CODE[0]);
        PageHelper.startPage(page, Constants.PAGESIZE);
        try {
            proRegisters = proRegisterMapper.selectByExample(proRegisterExample);
        } catch (Exception e) {
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        PageInfo pageInfo = new PageInfo(proRegisters, 5);
        return TableModel.tableSuccess(proRegisters, (int) pageInfo.getTotal());
    }


    @Override
    public TableModel rejectRegistry(Long id, String value) {
        //将注册表中的申请状态设置为驳回
        ProRegister proRegister = new ProRegister();
        proRegister.setId(id);
        proRegister.setAdvice(value);
        proRegister.setApplystatus(Constants.REGISTER_CODE[2]);

        try {
            proRegisterMapper.updateByPrimaryKeySelective(proRegister);
        } catch (Exception e) {
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.success();
    }


    @Override
    public TableModel passRegistry(PassRegistryVO passRegistryVO) {
        //将注册记录状态置为2，插入user表和对应得角色表
        ProRegister proRegister = new ProRegister();
        BeanUtils.copyProperties(passRegistryVO, proRegister);
        proRegister.setApplystatus(Constants.REGISTER_CODE[1]);
        proRegisterMapper.updateByPrimaryKeySelective(proRegister);

        //在User表中创建记录
        ProUser proUser = new ProUser();
        BeanUtils.copyProperties(passRegistryVO, proUser);
        proUserMapper.insert(proUser);

        //根据auth的不同，在角色表中插入记录
        switch (passRegistryVO.getAuth()) {
            case "ROLE_STUDENT":
                ProStudent proStudent = new ProStudent();
                BeanUtils.copyProperties(passRegistryVO, proStudent);
                proStudentMapper.insert(proStudent);
                break;
            case "ROLE_TEACHER":
                ProTeacher proTeacher = new ProTeacher();
                BeanUtils.copyProperties(passRegistryVO, proTeacher);
                proTeacherMapper.insert(proTeacher);
                break;
            case "ROLE_PERSON":
                ProPerson proPerson = new ProPerson();
                BeanUtils.copyProperties(passRegistryVO, proPerson);
                proPersonMapper.insert(proPerson);
                break;
            default:
                break;
        }

        return TableModel.success();
    }

    /**
     * 查询非管理员用户
     * @param page
     * @return
     */
    @Override
    public TableModel searchUserExceptManager(int page) {
        try {
            ProUserExample proUserExample = new ProUserExample();
            proUserExample.createCriteria().andAuthNotEqualTo(Constants.USER_AUTH_MANAGER).andNewAuthNotEqualTo(Constants.USER_AUTH_MANAGER);
            PageHelper.startPage(page,10);
            List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
            PageInfo pageInfo = new PageInfo(proUsers);
            return TableModel.tableSuccess(proUsers,(int)pageInfo.getTotal());
        } catch (Exception e) {
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 设置管理员
     * @param userid
     * @return
     */
    @Override
    public TableModel setManager(String userid) {
        try{
            ProUser proUser = new ProUser();
            proUser.setUserid(Long.parseLong(userid));
            proUser.setNewAuth(Constants.USER_AUTH_MANAGER);
            proUser.setNewAuthDate(new Date(System.currentTimeMillis()));
            proUserMapper.updateByPrimaryKeySelective(proUser);
            return TableModel.success();
        } catch (Exception e) {
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }
}
