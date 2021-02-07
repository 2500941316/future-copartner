package com.shu.copartner.conf.springsecurity;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProUserMapper;
import com.shu.copartner.mapper.ProVerifyMapper;
import com.shu.copartner.pojo.ProUser;
import com.shu.copartner.pojo.ProUserExample;
import com.shu.copartner.pojo.ProVerify;
import com.shu.copartner.pojo.ProVerifyExample;
import com.shu.copartner.utils.constance.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author cxy
 * @date 2020/12/6 13:17
 * @Description 登录信息处理类
 * @return
 */
@Component
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    ProUserMapper proUserMapper;

    @Autowired
    ProVerifyMapper proVerifyMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (username.length() == Constants.USERNAME_LENGTH) {

            //查询user表中，判断用户是否已经注册
            ProUserExample proUserExample = new ProUserExample();
            proUserExample.createCriteria().andIsdeletedEqualTo(Integer.valueOf(Constants.NO_DELETED)).andPhoneEqualTo(username)
                    .andIslockEqualTo(Integer.parseInt(Constants.NO_DELETED));
            List<ProUser> proUsersList = proUserMapper.selectByExample(proUserExample);
            if (proUsersList.size() == 0) {
                throw new BusinessException(Exceptions.SERVER_PHONENOTREGISTED_ERROR.getEcode());
            }

            //数据库中查询手机号对应的权限和验证码，并且验证时间是否5分钟内
            ProVerifyExample proVerifyExample = new ProVerifyExample();
            proVerifyExample.createCriteria().andPhoneEqualTo(username).andVerifydateGreaterThanOrEqualTo(new Date()).andStatusEqualTo(Constants.TRUE);
            List<ProVerify> proVerifies = proVerifyMapper.selectByExample(proVerifyExample);
            if (proVerifies.isEmpty()) {
                throw new BusinessException(Exceptions.SERVER_PHONECODEOUTOFDATE_ERROR.getEcode());
            }

            //去user表中查询用户的权限
            ProUserExample newProUserExample = new ProUserExample();
            newProUserExample.createCriteria().andPhoneEqualTo(username).andIsdeletedEqualTo(Integer.parseInt(Constants.NO_DELETED));
            List<ProUser> proUsers = proUserMapper.selectByExample(newProUserExample);
            String auth = proUsers.get(0).getAuth();
            if(Constants.USER_AUTH_MANAGER.equals(proUsers.get(0).getNewAuth())){
                // 如果该人员有被设置为管理员，则将auth置为 管理员，并传到前端
                auth = proUsers.get(0).getNewAuth();
            }
            String password = String.valueOf(proVerifies.get(0).getVerifycode());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            grantedAuthorities.add(new SimpleGrantedAuthority(auth));
            return new User(username, new BCryptPasswordEncoder().encode(password), grantedAuthorities);
        } else {
            throw new BusinessException(Exceptions.SERVER_UNAMEISNULL_ERROR.getEcode());
        }
    }
}

