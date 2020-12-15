package com.ego14t.user.controller;

import com.ego14t.common.constant.vaildator.group.AddGroup;
import com.ego14t.common.constant.vaildator.group.UpdateGroup;
import com.ego14t.common.controller.AbstractController;
import com.ego14t.common.entity.Result;
import com.ego14t.user.service.UserService;
import com.ego14t.user.vo.BaseUserVo;
import com.ego14t.user.vo.UpdateUserVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/6
 * Description:
 */

@RestController
@RequestMapping(value = "/user")
public class UserController extends AbstractController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/userinfo/{userid}")
    public Result getUserInfo(@PathVariable(value = "userid")String userid) {
        return Result.ok(userService.getUserInfo(userid));
    }

    @PatchMapping(value = "/userinfo")
    public Result updateUserInfo(@RequestBody @Validated({UpdateGroup.class}) UpdateUserVo updateUserVo) {
        userService.updateUserInfo(updateUserVo);
        return Result.ok();
    }

    @PostMapping(value = "/register")
    public Result register(@RequestBody @Validated({AddGroup.class}) BaseUserVo createVo) {
        userService.createUser(createVo);
        return Result.ok();
    }
}
