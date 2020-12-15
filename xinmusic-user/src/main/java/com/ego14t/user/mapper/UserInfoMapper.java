package com.ego14t.user.mapper;

import com.ego14t.user.entity.BaseUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2020/12/15 11:05
 * Description:
 */
@Mapper
public interface UserInfoMapper {

    BaseUserEntity getUserInfo(String userid);

    Integer update(BaseUserEntity baseUserEntity);
}
