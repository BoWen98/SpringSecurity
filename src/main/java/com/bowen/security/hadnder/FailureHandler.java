package com.bowen.security.hadnder;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ProjectName: SpringSecurity
 * @Package: com.bowen.security.hadnder
 * @ClassName: FailureHandler
 * @Author: Bowen
 * @Description: 错误
 * @Date: 2019/12/12 19:30
 * @Version: 1.0.0
 */
public class FailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(401);
        PrintWriter out = response.getWriter();
        out.write("{\"error_code\":\"401\",\"" + exception.getClass() + "\":\"401\",\"message\":\"" + exception.getMessage() + "\"}");
    }
}
