package com.shu.copartner.conf.springsecurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.SneakyThrows;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author cxy
 * @date 2020/12/6 13:17
 * @Description 用户登出成功的类
 * @return
 */
@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    private ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

        TableModel tableModel = new TableModel();
        tableModel.setCode(200);
        tableModel.setMsg("登出成功");
        String json = objectMapper.writeValueAsString(tableModel);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
