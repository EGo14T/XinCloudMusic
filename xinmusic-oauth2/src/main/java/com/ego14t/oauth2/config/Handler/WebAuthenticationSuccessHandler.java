package com.ego14t.oauth2.config.Handler;

import com.alibaba.fastjson.JSON;
import com.ego14t.oauth2.pojo.ResponseJsonResult;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/1/15 16:41
 * Description:
 */
@Configuration
public class WebAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
         httpServletResponse.setCharacterEncoding("utf-8");
         httpServletResponse.setContentType("application/json;charset=utf-8");
         httpServletResponse.getWriter().write(JSON.toJSONString(ResponseJsonResult.OK(null,"登录成功！")));
    }

}
