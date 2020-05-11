package com.ego14t.xinmusicfeign.service;

import com.ego14t.xinmusicfeign.pojo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/6
 * Description:
 */

@FeignClient(value = "xinmusic-user")
public interface UserService {

    //获取用户信息
    @GetMapping("/users/UserInfo/{userID}")
    Object getUserInfo(@PathVariable(value = "userID") String userId);

    //更新用户信息
    @PatchMapping("/users/UserInfo")
    Object updateUserInfo(@RequestBody UserInfo userInfo);
}
