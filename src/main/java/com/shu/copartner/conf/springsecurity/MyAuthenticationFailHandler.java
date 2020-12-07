package com.shu.copartner.conf.springsecurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shu.copartner.utils.returnobj.TableModel;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cxy
 * @date 2020/12/6 13:17
 * @Description 登录失败的类
 * @return
 */
@Component
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {
    private ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException {
        TableModel tableModel = new TableModel();
        tableModel.setCode(302);
        String json = objectMapper.writeValueAsString(tableModel);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json);

    }
}
