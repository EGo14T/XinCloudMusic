package com.ego14t.user.controller;

import com.ego14t.user.entity.RegisterUser;
import com.ego14t.user.pojo.User;
import com.ego14t.user.pojo.UserInfo;
import com.ego14t.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/6
 * Description:
 */

@RestController
@RequestMapping(value = "/users")
public class UserController extends AbstractController{

    @Resource
    private UserService userService;

    @GetMapping(value = "/userInfo")
    public UserInfo getUserInfo(){
        return userService.getUserInfo(getUserId());

    }

    @PatchMapping(value = "/userInfo")
    public UserInfo updateUserInfo(@RequestBody UserInfo userInfo){
        return userService.updateUserInfo(userInfo);

    }

    @PostMapping(value = "/register")
    public String register(@RequestBody RegisterUser user){
        return userService.register(user);
    }


}
