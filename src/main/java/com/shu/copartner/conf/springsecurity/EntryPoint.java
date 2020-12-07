package com.shu.copartner.conf.springsecurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shu.copartner.utils.returnobj.TableModel;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cxy
 * @date 2020/12/6 13:17
 * @Description 检测用户身份是否合法
 * @return
 */
@Component
public class EntryPoint implements AuthenticationEntryPoint {
    private ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        TableModel tableModel = new TableModel();
        tableModel.setCode(405);
        tableModel.setMsg("访问权限不足");
        String json = objectMapper.writeValueAsString(tableModel);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
