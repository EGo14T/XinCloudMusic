package com.ego14t.xinmusicfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/6
 * Description:
 */

@FeignClient(value = "xinmusic-user")
public interface UserService {

    //获取用户信息
    @GetMapping("/users/getUserInfo/{userID}")
    Object getUserInfo(@PathVariable(value = "userID") String userId);
}
