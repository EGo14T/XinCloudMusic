package com.ego14t.common.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public abstract class AbstractController {

    @Resource
    private HttpServletRequest request;

    //获取用户ID
    protected String getUserId() {
        return request.getHeader("userId");
    }
}
