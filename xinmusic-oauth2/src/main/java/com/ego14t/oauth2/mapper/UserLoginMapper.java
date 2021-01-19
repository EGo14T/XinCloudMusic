package com.ego14t.oauth2.mapper;

import com.ego14t.oauth2.entity.UserLogin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2021/1/19 17:10
 * Description:
 */
@Mapper
public interface UserLoginMapper {
    UserLogin queryByUserName(String username);

}
