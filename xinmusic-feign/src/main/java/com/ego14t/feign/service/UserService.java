package com.ego14t.feign.service;

import com.ego14t.feign.config.FeignConfig;
import com.ego14t.feign.vo.BaseUserVo;
import com.ego14t.feign.vo.UpdateUserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2021/1/22 14:09
 * Description:
 */
@FeignClient(value = "xinmusic-user", configuration = FeignConfig.class)
public interface UserService {

    @GetMapping("/users/userinfo/{userid}")
    ResponseEntity<?> getUserInfo(@PathVariable("userid") String userid);

    @PatchMapping("/users/userinfo")
    ResponseEntity<?> updateUserInfo(@RequestBody UpdateUserVo updateUserVo);

    @PostMapping("/users/register")
    ResponseEntity<?> createUser(@RequestBody BaseUserVo createVo);
}
