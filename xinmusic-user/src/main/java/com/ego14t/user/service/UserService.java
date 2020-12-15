package com.ego14t.user.service;

import com.ego14t.user.vo.BaseUserVo;
import com.ego14t.user.vo.UpdateUserVo;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/6
 * Description:
 */


public interface UserService {
    //根据Id获取用户信息
    BaseUserVo getUserInfo(String userId);

    void updateUserInfo(UpdateUserVo updateUserVo);

    void createUser(BaseUserVo createVo);
}
