package com.ego14t.user.controller;

import com.ego14t.user.pojo.UserInfo;
import com.ego14t.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/6
 * Description:
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping(value = "/getUserInfo/{userID}")
    public UserInfo getUserInfo(@PathVariable(value = "userID")String userId){
        return userService.getUserInfo(userId);

    }


}
