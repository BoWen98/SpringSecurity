package com.bowen.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: SpringSecurity
 * @Package: com.bowen.security.controller
 * @ClassName: Security
 * @Author: Bowen
 * @Description: Security
 * @Date: 2019/12/12 18:38
 * @Version: 1.0.0
 */
@RequestMapping("/admin/api")
@RestController
public class AdminController {

    @GetMapping("hello")
    public String hello() {
        return "Hello admin";
    }
}
