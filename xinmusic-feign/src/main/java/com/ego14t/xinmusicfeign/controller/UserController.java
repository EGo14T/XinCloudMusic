package com.ego14t.xinmusicfeign.controller;

import com.ego14t.xinmusicfeign.pojo.ResponseJsonResult;
import com.ego14t.xinmusicfeign.service.UserService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getUserInfo(@PathVariable(value = "userID")String userId){

        return ResponseJsonResult.OK(userService.getUserInfo(userId),"获取用户信息成功");
    }
}
