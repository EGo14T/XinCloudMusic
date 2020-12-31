package com.ego14t.user.service.impl;

import com.ego14t.common.error.ErrorCode;
import com.ego14t.common.exception.XMException;
import com.ego14t.common.utils.BeanCopyUtils;
import com.ego14t.user.entity.BaseUserEntity;
import com.ego14t.user.mapper.UserInfoMapper;
import com.ego14t.user.service.UserService;
import com.ego14t.user.vo.BaseUserVo;
import com.ego14t.user.vo.UpdateUserVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 获取用户信息
     * @param userId userid
     * @return userinfo
     */
    @Override
    public BaseUserVo getUserInfo(String userId) {
        BaseUserEntity userInfoEntity = userInfoMapper.getUserInfo(userId);
        if (userInfoEntity == null) {
            throw new XMException(ErrorCode.USER_IS_NOT_EXISTS);
        }
        BaseUserVo userInfo = new BaseUserVo();
        BeanCopyUtils.copy(userInfoEntity,userInfo);
        return userInfo;
    }

    @Override
    @Transactional
    public void updateUserInfo(UpdateUserVo updateUserVo) {
        BaseUserEntity baseUserEntity = new BaseUserEntity();
        BeanCopyUtils.copy(updateUserVo,baseUserEntity);
        Integer res = userInfoMapper.update(baseUserEntity);
        if (res != 1){
            throw new XMException(ErrorCode.USERINFO_UPDATE_FAILURE);
        }
    }

    @Override
    @Transactional
    public void createUser(BaseUserVo createVo) {
        BaseUserEntity baseUserEntity = new BaseUserEntity();
        BeanCopyUtils.copy(createVo, baseUserEntity);
        Integer createRes = userInfoMapper.create(baseUserEntity);
        //Integer initList = userInfoMapper.initMusiclist();
    }


}
