package com.bowen.security.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @ProjectName: SpringSecurity
 * @Package: com.bowen.security.configuration
 * @ClassName: WebSecurityConfig
 * @Author: Bowen
 * @Description: 配置
 * @Date: 2019/12/12 18:46
 * @Version: 1.0.0
 */

@Slf4j
@EnableWebSecurity //自动被Spring发现并注册
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /*内存创建用户
    *  5.x SpringSecurity There is no PasswordEncoder mapped for the id "null"应 password("{noop}123")
    *
    * */
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").password("{noop}123").roles("USER").build());
        manager.createUser(User.withUsername("admin").password("{noop}123").roles("ADMIN").build());
        return manager;
    }
    //测试成功后返回数据
/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.debug("Using default configure(HttpSecurity).If subclassed this will potentially override subclass configure(HttpSecurity).");
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/myLogin.html")
                //.loginProcessingUrl("/")
                .successHandler(new SuccessHandler())
                .failureHandler(new FailureHandler())
                .permitAll()
                .and()
                .csrf().disable();
    }*/


    //测试访问权限
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                .antMatchers("/app/api/**").permitAll()
                .and()
                .formLogin();
    }
}
