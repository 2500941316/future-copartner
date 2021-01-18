package com.shu.copartner.service.impl.publics;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProRegisterMapper;
import com.shu.copartner.mapper.ProUserMapper;
import com.shu.copartner.mapper.ProVerifyMapper;
import com.shu.copartner.pojo.*;
import com.shu.copartner.pojo.request.PublicRegistryInfoVO;
import com.shu.copartner.service.PublicAuthService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

/**
 * @author cxy
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class PublicAuthServiceImpl implements PublicAuthService {

    @Autowired
    ProUserMapper proUserMapper;

    @Autowired
    ProRegisterMapper proRegisterMapper;

    @Autowired
    ProVerifyMapper proVerifyMapper;

    /**
     * applystatus: 0.发送验证码  1.提交申请  2.同意  3.驳回
     *
     * @param phone
     * @return
     */
    @Override
    public TableModel registerGetVrifyCode(String phone) {
        List<ProUser> proUsers;
        List<ProRegister> proRegisters;
        //查找该手机号是否注册过，如果注册过则返回已经注册
        ProUserExample proUserExample = new ProUserExample();
        ProRegisterExample proRegisterExample = new ProRegisterExample();
        proRegisterExample.createCriteria().andPhoneEqualTo(phone).andApplystatusEqualTo(Constants.REGISTER_CODE[1]);
        proUserExample.createCriteria().andPhoneEqualTo(phone);
        try {
            proUsers = proUserMapper.selectByExample(proUserExample);
            proRegisters = proRegisterMapper.selectByExample(proRegisterExample);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        if (!proUsers.isEmpty() || !proRegisters.isEmpty()) {
            throw new BusinessException(Exceptions.SERVER_PHONEISREGISTED_ERROR.getEcode());
        }

        int code = (int) ((Math.random() * 9 + 1) * 100000);
        code = 111111;

        //调用短信发送服务
        System.out.println("发送了验证码：" + code);

        //设置验证码过期时间
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.MINUTE, +5);

        //如果没有注册过则插入验证表中
        ProVerify proVerify = new ProVerify(phone, code, beforeTime.getTime());
        if (proVerifyMapper.selectByPrimaryKey(phone) == null) {
            proVerifyMapper.insert(proVerify);
        } else {
            proVerifyMapper.updateByPrimaryKeySelective(proVerify);
        }

        return TableModel.success();
    }


    @Override
    public TableModel loginGetVerifyCode(String phone) {
        List<ProUser> proUsers;
        //查找该手机号是否注册过，如果注册过则返回已经注册
        ProUserExample proUserExample = new ProUserExample();
        proUserExample.createCriteria().andPhoneEqualTo(phone);
        try {
            proUsers = proUserMapper.selectByExample(proUserExample);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        if (proUsers.isEmpty()) {
            throw new BusinessException(Exceptions.SERVER_PHONENOTREGISTED_ERROR.getEcode());
        }

        int code = (int) ((Math.random() * 9 + 1) * 100000);
        code = 111111;
        //调用短信发送服务
        System.out.println("发送了验证码：" + code);

        //将最新的验证码和过期时间存入数据库
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.MINUTE, +5);

        ProVerify proVerify = new ProVerify(phone, code, beforeTime.getTime());
        proVerifyMapper.updateByPrimaryKeySelective(proVerify);

        return TableModel.success();
    }


    @Override
    public TableModel registry(PublicRegistryInfoVO registryInfoVO) {
        System.out.println(registryInfoVO);
        return null;
    }
}
