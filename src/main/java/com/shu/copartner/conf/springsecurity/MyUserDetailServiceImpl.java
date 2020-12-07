package com.shu.copartner.conf.springsecurity;

import com.shu.copartner.utils.constance.Constants;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxy
 * @date 2020/12/6 13:17
 * @Description 登录信息处理类
 * @return
 */
@Component
public class MyUserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) {
        if (username.length() == Constants.USERNAME_LENGTH) {
            String auth = "ROLE_USER";
            String password = "aaa";
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            grantedAuthorities.add(new SimpleGrantedAuthority(auth));
            return new User(username, password, grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("登录失败");
        }
    }
}

