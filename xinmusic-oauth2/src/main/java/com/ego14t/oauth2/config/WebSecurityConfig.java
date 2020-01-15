package com.ego14t.oauth2.config;

import com.ego14t.oauth2.config.Handler.WebAuthenticationFailureHandler;
import com.ego14t.oauth2.config.Handler.WebAuthenticationSuccessHandler;
import com.ego14t.oauth2.service.Oauth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //auth.userDetailsService(oauth2UserService);
        //加入自定义安全认证
        auth.authenticationProvider(selfAuthenticationProvider);


//        auth.inMemoryAuthentication()
//                // 在内存中创建用户并为密码加密
//                .withUser("user").password(passwordEncoder().encode("123456")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN");

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable()
              .httpBasic()
              .and()
              .authorizeRequests()
              .antMatchers("/**").permitAll()
              .anyRequest()
              .authenticated()

              .and()
              .formLogin()  // 开启登录
              .loginProcessingUrl("/user/login")
              .usernameParameter("username")//请求验证参数
              .passwordParameter("password")//请求验证参数
              .successHandler(webAuthenticationSuccessHandler) // 登录成功
              .failureHandler(webAuthenticationFailureHandler) // 登录失败
              .permitAll();

    }

  @Bean
  public AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }
  }
