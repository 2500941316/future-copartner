package com.shu.copartner.service.impl.publics;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProUserMapper;
import com.shu.copartner.pojo.ProUser;
import com.shu.copartner.pojo.ProUserExample;
import com.shu.copartner.service.PublicAuthService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public TableModel getverifyCode(String phone) {
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
        if (!proUsers.isEmpty()) {
            throw new BusinessException(Exceptions.SERVER_PHONEISREGISTED_ERROR.getEcode());
        }

        int code = (int) Math.round((Math.random() + 1) * 1000);

        //如果没有注册过则插入user表新用户，具体的分类信息在管理员指定
        ProUser proUser = new ProUser(phone, String.valueOf(code));
        proUserMapper.insert(proUser);

        //调用短信发送服务
        System.out.println("发送了验证码：" + code);
        return TableModel.success();

    }
}
