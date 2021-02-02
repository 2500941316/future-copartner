package com.shu.copartner.service.impl.user;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.*;
import com.shu.copartner.pojo.*;
import com.shu.copartner.service.VipUserService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2021/2/1 16:37
 * @description
 */
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class VipUserServiceImpl implements VipUserService {

    @Autowired
    private ProUserMapper proUserMapper;

    @Autowired
    private ProStudentMapper proStudentMapper;

    @Autowired
    private ProTeacherMapper proTeacherMapper;

    @Autowired
    private ProPersonMapper proPersonMapper;

    /**
     * 查询我的信息
     * @param username
     * @return
     */
    @Override
    public TableModel selectPersonalInfo(String username) {
        try{
            // 根据phone查询我的角色
            ProUserExample proUserExample = new ProUserExample();
            proUserExample.createCriteria().andPhoneEqualTo(username);
            List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
            String auth = proUsers.get(0).getAuth();
            // 根据角色及phone查询我的个人信息
            switch(auth){
                case "ROLE_STUDENT":
                    ProStudentExample proStudentExample = new ProStudentExample();
                    proStudentExample.createCriteria().andPhoneEqualTo(username);
                    List<ProStudent> proStudentList = proStudentMapper.selectByExample(proStudentExample);
                    proStudentList.get(0).setAuth("ROLE_STUDENT");
                    return TableModel.success(proStudentList,proStudentList.size());
                case "ROLE_TEACHER":
                    ProTeacherExample proTeacherExample = new ProTeacherExample();
                    proTeacherExample.createCriteria().andPhoneEqualTo(username);
                    List<ProTeacher> proTeacherList = proTeacherMapper.selectByExample(proTeacherExample);
                    proTeacherList.get(0).setAuth("ROLE_TEACHER");
                    return TableModel.success(proTeacherList,proTeacherList.size());
                case "ROLE_PERSON":
                    ProPersonExample proPersonExample = new ProPersonExample();
                    proPersonExample.createCriteria().andPhoneEqualTo(username);
                    List<ProPerson> proPersonList = proPersonMapper.selectByExample(proPersonExample);
                    proPersonList.get(0).setAuth("ROLE_PERSON");
                    return TableModel.success(proPersonList,proPersonList.size());
                default:
                    break;
            }
            return TableModel.success();
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }
}
