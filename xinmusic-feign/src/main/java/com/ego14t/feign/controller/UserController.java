package com.ego14t.feign.controller;

import com.ego14t.common.constant.vaildator.group.AddGroup;
import com.ego14t.feign.service.UserService;
import com.ego14t.feign.vo.BaseUserVo;
import com.ego14t.feign.vo.UpdateUserVo;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2021/1/22 14:07
 * Description:
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/userinfo/{userid}")
    public ResponseEntity<?> getUserInfo(@PathVariable("userid")String userid) {
        return userService.getUserInfo(userid);
    }

    @PatchMapping("/userinfo")
    public ResponseEntity<?> updateUserInfo(@RequestBody UpdateUserVo updateUserVo) {
        return userService.updateUserInfo(updateUserVo);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Validated({AddGroup.class}) BaseUserVo createVo) {
        return userService.createUser(createVo);
    }

}
