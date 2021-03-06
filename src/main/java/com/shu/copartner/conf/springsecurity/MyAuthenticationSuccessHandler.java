package com.shu.copartner.conf.springsecurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shu.copartner.mapper.ProUserMapper;
import com.shu.copartner.mapper.ProVerifyMapper;
import com.shu.copartner.pojo.ProUser;
import com.shu.copartner.pojo.ProUserExample;
import com.shu.copartner.pojo.ProVerify;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author cxy
 * @date 2020/12/6 13:17
 * @Description 用户登录成功的类
 * @return
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    ProVerifyMapper proVerifyMapper;

    @Autowired
    ProUserMapper proUserMapper;

    GrantedAuthority authority = null;
    private ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        TableModel tableModel = new TableModel();
        tableModel.setCode(200);
        tableModel.setMsg(authentication.getName());
        Iterator<? extends GrantedAuthority> iterator = authentication.getAuthorities().iterator();
        if (iterator.hasNext()) {
            authority = iterator.next();
        }
        tableModel.setData(authority.getAuthority());

        //如果验证成功，则将本次的验证码状态置为false
        ProVerify proVerify = new ProVerify();
        proVerify.setPhone(authentication.getName());
        proVerify.setStatus(Constants.FALSE);
        proVerifyMapper.updateByPrimaryKeySelective(proVerify);

        //将用户表中的最后登录时间和次数更新
        ProUserExample proUserExample = new ProUserExample();
        proUserExample.createCriteria().andPhoneEqualTo(authentication.getName());
        List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);

        ProUser proUser = proUsers.get(0);
        proUser.setLastdate(new Date());
        proUser.setLogintime(proUser.getLogintime() + 1);
        proUserMapper.updateByPrimaryKeySelective(proUser);

        String json = objectMapper.writeValueAsString(tableModel);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
