package com.ego14t.xinmusic.Controller;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractController {

    //获取用户ID
    protected String getUserId(HttpServletRequest request) {
        return request.getHeader("userId");
    }
}
