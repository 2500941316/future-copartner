package com.shu.copartner.service.impl.user;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.*;
import com.shu.copartner.pojo.*;
import com.shu.copartner.pojo.request.PublicRegistryInfoVO;
import com.shu.copartner.service.VipUserService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
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
            // 根据phone查询我的角色 和 登录时间
            ProUserExample proUserExample = new ProUserExample();
            proUserExample.createCriteria().andPhoneEqualTo(username);
            List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
            String auth = proUsers.get(0).getAuth();//获取角色类型
            Date logindate = proUsers.get(0).getLastdate();// 获取登录时间
            String imageUrl = null;
            if(StringUtils.isNotEmpty(proUsers.get(0).getImageUrl())){
                imageUrl = proUsers.get(0).getImageUrl(); // 获取个人头像路径
            }

            // 根据角色及phone查询我的个人信息
            switch(auth){
                case "ROLE_STUDENT":
                    ProStudentExample proStudentExample = new ProStudentExample();
                    proStudentExample.createCriteria().andPhoneEqualTo(username);
                    List<ProStudent> proStudentList = proStudentMapper.selectByExample(proStudentExample);
                    proStudentList.get(0).setAuth("ROLE_STUDENT");// 设置角色
                    proStudentList.get(0).setLogindate(logindate);// 设置登陆时间
                    proStudentList.get(0).setImageUrl(imageUrl); // 设置图像路径，临时使用该变量
                    return TableModel.success(proStudentList,proStudentList.size());
                case "ROLE_TEACHER":
                    ProTeacherExample proTeacherExample = new ProTeacherExample();
                    proTeacherExample.createCriteria().andPhoneEqualTo(username);
                    List<ProTeacher> proTeacherList = proTeacherMapper.selectByExample(proTeacherExample);
                    proTeacherList.get(0).setAuth("ROLE_TEACHER");// 设置角色
                    proTeacherList.get(0).setLogindate(logindate);// 设置登陆时间
                    proTeacherList.get(0).setImageUrl(imageUrl); // 设置图像路径，临时使用该变量
                    return TableModel.success(proTeacherList,proTeacherList.size());
                case "ROLE_PERSON":
                    ProPersonExample proPersonExample = new ProPersonExample();
                    proPersonExample.createCriteria().andPhoneEqualTo(username);
                    List<ProPerson> proPersonList = proPersonMapper.selectByExample(proPersonExample);
                    proPersonList.get(0).setAuth("ROLE_PERSON");// 设置角色
                    proPersonList.get(0).setLogindate(logindate);// 设置登陆时间
                    proPersonList.get(0).setImageUrl(imageUrl); // 设置图像路径，临时使用该变量
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

    /**
     * 处理手机号修改
     * @param newPhone
     * @param username
     * @return
     */
    @Override
    public TableModel handleUpdatePhone(String newPhone, String username) {
        try{
            //1 先根据手机号查询出用户信息
            ProUserExample proUserExample = new ProUserExample();
            proUserExample.createCriteria().andPhoneEqualTo(username);
            List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
            String auth = proUsers.get(0).getAuth(); // 获取用户类型
            //2 先修改user表中手机号
            proUsers.get(0).setPhone(newPhone);
            proUserMapper.updateByPrimaryKeySelective(proUsers.get(0));

            //3 再修改verify表中的手机号,由于verify表中phone是主键不能修改，所以先删掉，然后再新增
            ProVerify proVerify = proVerifyMapper.selectByPrimaryKey(username);
            ProVerify proVerifyNew = new ProVerify();
            BeanUtils.copyProperties(proVerify,proVerifyNew);
            proVerifyNew.setPhone(newPhone);
            proVerifyMapper.deleteByPrimaryKey(username);
            proVerifyMapper.insert(proVerifyNew);
            /*ProVerifyExample proVerifyExample = new ProVerifyExample();
            proUserExample.createCriteria().andPhoneEqualTo(username);
            proVerifyMapper.updateByExampleSelective(proVerify,proVerifyExample);*/

            //4 后根据用户类型修改具体表中的手机号
            switch(auth){
                case "ROLE_STUDENT":
                    ProStudent proStudent = new ProStudent();
                    proStudent.setPhone(newPhone); // 设置新的手机号
                    ProStudentExample proStudentExample = new ProStudentExample();
                    proStudentExample.createCriteria().andPhoneEqualTo(username);
                    proStudentMapper.updateByExampleSelective(proStudent,proStudentExample);
                    break;
                case "ROLE_TEACHER":
                    ProTeacher proTeacher = new ProTeacher();
                    proTeacher.setPhone(newPhone); // 设置新的手机号
                    ProTeacherExample proTeacherExample = new ProTeacherExample();
                    proTeacherExample.createCriteria().andPhoneEqualTo(username);
                    proTeacherMapper.updateByExampleSelective(proTeacher,proTeacherExample);
                    break;
                case "ROLE_PERSON":
                    ProPerson proPerson = new ProPerson();
                    proPerson.setPhone(newPhone); // 设置新的手机号
                    ProPersonExample proPersonExample = new ProPersonExample();
                    proPersonExample.createCriteria().andPhoneEqualTo(username);
                    proPersonMapper.updateByExampleSelective(proPerson,proPersonExample);
                    break;
                default:
                    break;
            }
            return TableModel.success();
        } catch(Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }

    }
}
