package com.ego14t.user.service.impl;

import com.ego14t.user.mapper.UserInfoMapper;
import com.ego14t.user.pojo.UserInfo;
import com.ego14t.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/6
 * Description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfo(String userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public UserInfo updateUserInfo(UserInfo userInfo) {
        int res = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        System.out.println(res);
        if (res == 1){
            return userInfoMapper.selectByPrimaryKey(userInfo.getId());
        }else {
            return null;
        }
    }
}
