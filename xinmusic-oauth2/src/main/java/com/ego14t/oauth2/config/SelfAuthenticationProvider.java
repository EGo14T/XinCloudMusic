package com.ego14t.oauth2.config;

import com.ego14t.oauth2.service.Oauth2UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.annotation.Resource;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/1/15 14:14
 * Description:
 */
@Configuration
public class SelfAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private Oauth2UserService oauth2UserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        UserDetails userDetails = oauth2UserService.loadUserByUsername(userName);
        if(userDetails==null){
            throw new BadCredentialsException("用户名不存在！");
        }

        boolean check = BCrypt.checkpw(password, userDetails.getPassword());

        if (!check) {
            throw new BadCredentialsException("密码不正确，请重新登陆！");
        }

        return new UsernamePasswordAuthenticationToken(userName, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
