package com.bowen.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: SpringSecurity
 * @Package: com.bowen.security.controller
 * @ClassName: UserController
 * @Author: Bowen
 * @Description: 用户
 * @Date: 2019/12/12 19:51
 * @Version: 1.0.0
 */
@RequestMapping("/user/api")
@RestController
public class UserController {
    @GetMapping("hello")
    public String hello() {
        return "Hello user";
    }
}
