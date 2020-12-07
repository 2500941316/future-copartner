package com.shu.copartner.conf.springsecurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shu.copartner.utils.returnobj.TableModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author cxy
 * @date 2020/12/6 13:17
 * @Description 用户登录成功的类
 * @return
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        TableModel tableModel = new TableModel();
        tableModel.setCode(200);
        tableModel.setMsg(authentication.getName());
        String json = objectMapper.writeValueAsString(tableModel);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
