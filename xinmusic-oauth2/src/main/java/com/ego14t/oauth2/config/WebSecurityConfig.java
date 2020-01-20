package com.ego14t.oauth2.config;

import com.ego14t.oauth2.config.Handler.WebAuthenticationEntryPoint;
import com.ego14t.oauth2.config.Handler.WebAuthenticationFailureHandler;
import com.ego14t.oauth2.config.Handler.WebAuthenticationSuccessHandler;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    @Resource
    private WebAuthenticationFailureHandler webAuthenticationFailureHandler;

    @Resource
    private WebAuthenticationSuccessHandler webAuthenticationSuccessHandler;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private WebAuthenticationEntryPoint webAuthenticationEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //auth.userDetailsService(oauth2UserService);
        //加入自定义安全认证
        auth.authenticationProvider(selfAuthenticationProvider);

        auth.inMemoryAuthentication()
                // 在内存中创建用户并为密码加密
                .withUser("user").password(passwordEncoder.encode("123456")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder.encode("123456")).roles("ADMIN");

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                //使用JWT 关闭session
              .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              .and()
                //设置未登录的处理方式
              .httpBasic().authenticationEntryPoint(webAuthenticationEntryPoint)
              .and()
                //设置过滤地址
              .authorizeRequests()
              .antMatchers("/login","/.well-known/jwks.json","/my","/user/**","/oauth/**","/getCode").permitAll()
              .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
              .anyRequest()
              .authenticated()
              .and()
                //设置自定义登录
              .formLogin()
              .loginProcessingUrl("/user/login")
                //自定义请求参数 账号 密码
              .usernameParameter("username")
              .passwordParameter("password")
                //登录结果处理方式
              .successHandler(webAuthenticationSuccessHandler) // 登录成功
              .failureHandler(webAuthenticationFailureHandler) // 登录失败
              .permitAll();

    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
