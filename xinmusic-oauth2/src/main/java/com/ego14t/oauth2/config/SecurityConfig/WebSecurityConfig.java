package com.ego14t.oauth2.config.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;


/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/1/15 10:34
 * Description:
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private SelfAuthenticationProvider selfAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        //加入自定义安全认证
        auth.authenticationProvider(selfAuthenticationProvider);

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }


    /**
     * 配置这项 支持密码模式
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();

    }
}
