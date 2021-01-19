package com.ego14t.oauth2.service;

import com.ego14t.oauth2.mapper.UserLoginMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/1/15 11:37
 * Description:
 */
@Service
public class Oauth2UserService implements UserDetailsService {

    @Resource
    private UserLoginMapper userLoginMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userLoginMapper.queryByUserName(username);
    }
}
