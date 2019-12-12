package com.bowen.security.hadnder;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ProjectName: SpringSecurity
 * @Package: com.bowen.security.hadnder
 * @ClassName: HandlerSuccess
 * @Author: Bowen
 * @Description: 成功显示数据
 * @Date: 2019/12/12 19:25
 * @Version: 1.0.0
 */
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("{\"error_code\":\"0\",\"message\":\"欢迎登录系统\"}");
    }
}
