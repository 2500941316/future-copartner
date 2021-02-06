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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.*;

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
        proRegisterExample.createCriteria().andPhoneEqualTo(phone).andApplystatusNotEqualTo(Constants.REGISTER_CODE[2]);
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
        //生成验证码
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        code = 111111;
        //设置验证码过期时间
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.MINUTE, +5);

        //如果没有注册过则插入验证表中
        ProVerify proVerify = new ProVerify(phone, code, beforeTime.getTime(), Constants.TRUE);
        if (proVerifyMapper.selectByPrimaryKey(phone) == null) {
            proVerifyMapper.insert(proVerify);
        } else {
            proVerifyMapper.updateByPrimaryKeySelective(proVerify);
        }
        //调用短信发送服务
        //SmSender.sendSmCode(phone, code);

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

        //将最新的验证码和过期时间存入数据库
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.MINUTE, +5);

        ProVerify proVerify = new ProVerify(phone, code, beforeTime.getTime(), Constants.TRUE);
        proVerifyMapper.updateByPrimaryKeySelective(proVerify);
        //调用短信发送服务
        // SmSender.sendSmCode(phone, code);

        return TableModel.success();
    }


    @Override
    public TableModel registry(PublicRegistryInfoVO registryInfoVO) {
        //1.从数据库中查询验证码
        ProVerify proVerify = proVerifyMapper.selectByPrimaryKey(registryInfoVO.getPhone());

        if (proVerify == null) {
            throw new BusinessException(Exceptions.SERVER_PHONECODENOTEXIST_ERROR.getEcode());
        }
        //如果验证码不相等
        if (!registryInfoVO.getVerifycode().equals(proVerify.getVerifycode() + "")) {
            throw new BusinessException(Exceptions.SERVER_PHONECODEERROR_ERROR.getEcode());
        }

        //如果验证码未过期
        if (proVerify.getVerifydate().before(new Date())) {
            throw new BusinessException(Exceptions.SERVER_PHONECODEOUTOFDATE_ERROR.getEcode());
        }

        //如果已经提交注册且状态为正在审核或者同意则不能继续注册
        ProRegisterExample proRegisterExample = new ProRegisterExample();
        proRegisterExample.createCriteria().andPhoneEqualTo(registryInfoVO.getPhone()).andApplystatusEqualTo(Constants.REGISTER_CODE[0]);
        proRegisterExample.or().andPhoneEqualTo(registryInfoVO.getPhone()).andApplystatusEqualTo(Constants.REGISTER_CODE[1]);
        List<ProRegister> proRegisters = proRegisterMapper.selectByExample(proRegisterExample);
        if (!proRegisters.isEmpty()) {
            throw new BusinessException(Exceptions.SERVER_REGISTERISEXIST_ERROR.getEcode());
        }

        //将注册信息插入注册表中
        ProRegister proRegister = new ProRegister();
        BeanUtils.copyProperties(registryInfoVO, proRegister);
        try {
            proRegisterMapper.insert(proRegister);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.success();
    }


    @Override
    public TableModel checkAuth(Principal principal) {
        GrantedAuthority authority = null;
        if (principal==null) {
            return TableModel.error();
        }
        log.info(principal.getName() + "访问");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Iterator<? extends GrantedAuthority> iterator = authentication.getAuthorities().iterator();
        if (iterator.hasNext()) {
            authority = iterator.next();
        }
        TableModel tableModel = new TableModel();
        tableModel.setMsg(authentication.getName());
        tableModel.setData(authority.getAuthority());
        return TableModel.success(tableModel, 1);
    }
}
