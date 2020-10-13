package com.ego14t.oauth2.config.JWTconfig;

import com.ego14t.oauth2.mapper.UserInfoMapper;
import com.ego14t.oauth2.mapper.UserMapper;
import com.ego14t.oauth2.pojo.UserInfo;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


@Component
public class CustomTokenEnhancer implements TokenEnhancer {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>();
        //获取登录成功用户的id
        String id = userMapper.selectByUserName(authentication.getName()).getId();
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        //把用户信息放到授权返回信息中
        additionalInfo.put("user",userInfo);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
