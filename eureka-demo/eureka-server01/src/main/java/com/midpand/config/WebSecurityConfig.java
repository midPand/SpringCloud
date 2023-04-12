package com.midpand.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author minPand
 * @version 1.0
 * @date 2021/7/18 12:53
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);  //访问eureka 和 actuator 时能做安全控制
        http.csrf().ignoringAntMatchers("/eureka/**");  //忽略 /eureka/**请求
    }


}
