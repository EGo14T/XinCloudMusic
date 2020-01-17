package com.ego14t.oauth2.config.Handler;

import com.alibaba.fastjson.JSON;
import com.ego14t.oauth2.entity.ResponseJsonResult;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/1/15 16:18
 * Description:
 */
@Configuration
public class WebAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        AuthenticationException e) throws IOException, ServletException {

        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        ResponseEntity<?> resp = null;
        if (e instanceof BadCredentialsException ||
                e instanceof UsernameNotFoundException) {
            resp = ResponseJsonResult.INTERNAL_SERVER_ERROR(null,"账户名或者密码输入错误!");
        } else if (e instanceof LockedException) {
            resp = ResponseJsonResult.INTERNAL_SERVER_ERROR(null,"账户被锁定，请联系管理员!");
        } else if (e instanceof CredentialsExpiredException) {
            resp = ResponseJsonResult.INTERNAL_SERVER_ERROR(null,"密码过期，请联系管理员!");
        } else if (e instanceof AccountExpiredException) {
            resp = ResponseJsonResult.INTERNAL_SERVER_ERROR(null,"账户过期，请联系管理员!");
        } else if (e instanceof DisabledException) {
            resp = ResponseJsonResult.INTERNAL_SERVER_ERROR(null,"账户被禁用，请联系管理员!");
        } else {
            resp = ResponseJsonResult.INTERNAL_SERVER_ERROR(null,"登录失败!");
        }
        httpServletResponse.setStatus(401);
        httpServletResponse.getWriter().write(JSON.toJSONString(resp));

    }
}
