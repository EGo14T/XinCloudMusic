package com.ego14t.oauth2.config.Handler;

import com.alibaba.fastjson.JSON;
import com.ego14t.oauth2.entity.ResponseJsonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/1/20 14:51
 * Description: 处理用户未登录
 */

@Component
public class WebAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(ResponseJsonResult.UNAUTHORIZED(null,"没有登录，请先登录！")));
    }
}