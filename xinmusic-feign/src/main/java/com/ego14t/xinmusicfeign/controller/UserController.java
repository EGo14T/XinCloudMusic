package com.ego14t.xinmusicfeign.controller;

import com.ego14t.xinmusicfeign.pojo.ResponseJsonResult;
import com.ego14t.xinmusicfeign.pojo.UserInfo;
import com.ego14t.xinmusicfeign.service.UserService;
import org.springframework.http.ResponseEntity;
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
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping(value = "/UserInfo/{userID}")
    public ResponseEntity<?> getUserInfo(@PathVariable(value = "userID")String userId){

        return ResponseJsonResult.OK(userService.getUserInfo(userId),"获取用户信息成功");
    }

    @PatchMapping(value = "/UserInfo")
    public ResponseEntity<?> updateUserInfo(@RequestBody UserInfo userInfo){

        Object res = userService.updateUserInfo(userInfo);
        if (res!=null){
            return ResponseJsonResult.CREATED(res,"更新用户信息成功");
        }else  {
            return ResponseJsonResult.OK(null,"更新失败");
        }
    }
}
