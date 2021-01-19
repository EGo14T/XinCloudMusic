package com.ego14t.oauth2.mapper;

import com.ego14t.oauth2.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2021/1/19 17:11
 * Description:
 */
@Mapper
public interface UserInfoMapper {

    UserInfo getUserInfo(String userid);
}
