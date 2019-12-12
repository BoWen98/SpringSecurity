package com.bowen.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: SpringSecurity
 * @Package: com.bowen.security.controller
 * @ClassName: AppController
 * @Author: Bowen
 * @Description: 公共
 * @Date: 2019/12/12 19:52
 * @Version: 1.0.0
 */
@RequestMapping("/app/api")
@RestController
public class AppController {

    @GetMapping("hello")
    public String hello() {
        return "Hello app";
    }
}
