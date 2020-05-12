package com.ego14t.user.service;

import com.ego14t.user.entity.RegisterUser;
import com.ego14t.user.pojo.User;
import com.ego14t.user.pojo.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/6
 * Description:
 */


public interface UserService {
    //根据Id获取用户信息
    UserInfo getUserInfo(String userId);

    UserInfo updateUserInfo(UserInfo userInfo);

    String register(RegisterUser user);
}
