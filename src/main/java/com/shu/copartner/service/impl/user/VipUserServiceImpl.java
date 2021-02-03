package com.shu.copartner.service.impl.user;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.*;
import com.shu.copartner.pojo.*;
import com.shu.copartner.pojo.request.PublicRegistryInfoVO;
import com.shu.copartner.service.VipUserService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Autowired
    private ProVerifyMapper proVerifyMapper;

    /**
     * 查询我的信息
     * @param username
     * @return
     */
    @Override
    public TableModel selectPersonalInfo(String username) {
        try{
            //根据phone查询出登陆时间，直接用验证码时间代替
            ProVerifyExample proVerifyExample = new ProVerifyExample();
            proVerifyExample.createCriteria().andPhoneEqualTo(username);
            List<ProVerify> proVerifies = proVerifyMapper.selectByExample(proVerifyExample);
            Date logindate = proVerifies.get(0).getVerifydate();
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
                    proStudentList.get(0).setAuth("ROLE_STUDENT");// 设置角色
                    proStudentList.get(0).setLogindate(logindate);// 设置登陆时间
                    return TableModel.success(proStudentList,proStudentList.size());
                case "ROLE_TEACHER":
                    ProTeacherExample proTeacherExample = new ProTeacherExample();
                    proTeacherExample.createCriteria().andPhoneEqualTo(username);
                    List<ProTeacher> proTeacherList = proTeacherMapper.selectByExample(proTeacherExample);
                    proTeacherList.get(0).setAuth("ROLE_TEACHER");// 设置角色
                    proTeacherList.get(0).setLogindate(logindate);// 设置登陆时间
                    return TableModel.success(proTeacherList,proTeacherList.size());
                case "ROLE_PERSON":
                    ProPersonExample proPersonExample = new ProPersonExample();
                    proPersonExample.createCriteria().andPhoneEqualTo(username);
                    List<ProPerson> proPersonList = proPersonMapper.selectByExample(proPersonExample);
                    proPersonList.get(0).setAuth("ROLE_PERSON");// 设置角色
                    proPersonList.get(0).setLogindate(logindate);// 设置登陆时间
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

    /**
     * 修改个人信息
     * @param publicRegistryInfoVO
     * @return
     */
    @Override
    public TableModel updatePersonalInfo(PublicRegistryInfoVO publicRegistryInfoVO) {
        try{
            switch(publicRegistryInfoVO.getAuth()){
                case "ROLE_STUDENT":
                    ProStudent proStudent = new ProStudent();
                    BeanUtils.copyProperties(publicRegistryInfoVO,proStudent);
                    log.info(proStudent.toString());
                    ProStudentExample proStudentExample = new ProStudentExample();
                    proStudentExample.createCriteria().andPhoneEqualTo(proStudent.getPhone());
                    proStudentMapper.updateByExampleSelective(proStudent,proStudentExample);
                    break;
                case "ROLE_TEACHER":
                    ProTeacher proTeacher = new ProTeacher();
                    BeanUtils.copyProperties(publicRegistryInfoVO,proTeacher);
                    proTeacher.setMail(publicRegistryInfoVO.getEmail());
                    log.info(proTeacher.toString());
                    ProTeacherExample proTeacherExample = new ProTeacherExample();
                    proTeacherExample.createCriteria().andPhoneEqualTo(proTeacher.getPhone());
                    proTeacherMapper.updateByExampleSelective(proTeacher,proTeacherExample);
                    break;
                case "ROLE_PERSON":
                    ProPerson proPerson = new ProPerson();
                    BeanUtils.copyProperties(publicRegistryInfoVO,proPerson);
                    log.info(proPerson.toString());
                    ProPersonExample proPersonExample = new ProPersonExample();
                    proPersonExample.createCriteria().andPhoneEqualTo(proPerson.getPhone());
                    proPersonMapper.updateByExampleSelective(proPerson,proPersonExample);
                    break;
                default:
                    break;
            }
        }catch(Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }

        return TableModel.success();
    }
}
