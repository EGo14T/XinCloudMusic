package com.ego14t.user.service.impl;

import com.ego14t.user.config.WorkID;
import com.ego14t.user.entity.RegisterUser;
import com.ego14t.user.mapper.MusiclistUserMapper;
import com.ego14t.user.mapper.UserInfoMapper;
import com.ego14t.user.mapper.UserMapper;
import com.ego14t.user.pojo.MusiclistUser;
import com.ego14t.user.pojo.User;
import com.ego14t.user.pojo.UserExample;
import com.ego14t.user.pojo.UserInfo;
import com.ego14t.user.service.UserService;
import com.ego14t.user.utils.IDworker;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

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

    @Resource
    private UserMapper userMapper;

    @Resource
    private MusiclistUserMapper musiclistUserMapper;

    @Resource
    private WorkID workID;

    @Override
    public UserInfo getUserInfo(String userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public UserInfo updateUserInfo(UserInfo userInfo) {
        int res = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        if (res == 1) {
            return userInfoMapper.selectByPrimaryKey(userInfo.getId());
        } else {
            return null;
        }
    }

    @Override
    public String register(RegisterUser user) {

        UserInfo userInfo = new UserInfo();
        MusiclistUser musiclistUser = new MusiclistUser();
        System.out.println(workID.getUser());

        String id = new IDworker(workID.getUser(), 0).nextId();
        String password = new BCryptPasswordEncoder().encode(user.getPassword());

        user.setId(id);
        user.setPassword(password);

        userInfo.setId(id);
        userInfo.setName(user.getNickName());
        userInfo.setGender(0);
        userInfo.setAvatar("https://cdn.ego1st.cn/xinmusic/useravatar/defaultAvatar.jpg");


        musiclistUser.setUserid(id);
        musiclistUser.setMusiclistid(new IDworker(workID.getMusiclist(), 0).nextId());
        musiclistUser.setMusiclistName("我喜欢的音乐");
        musiclistUser.setStatus(0);
        musiclistUser.setCreateTime(LocalDateTime.now());
        musiclistUser.setMusiclistImg("http://cdn.ego1st.cn/xinmusic/musiclistIMG/default.jpg");

        if (isRepeat(user.getUsername())){
            int res = userMapper.insert(user);
            int register = userInfoMapper.insertSelective(userInfo);
            int musiclist = musiclistUserMapper.insertSelective(musiclistUser);

            if (res == 1 && register == 1 && musiclist == 1){
                return "200";
            }else {
                return "208";
            }
        }else {
            return "206";
        }

    }


    public Boolean isRepeat(String id){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(id);

        List<?> user = userMapper.selectByExample(userExample);
        return user.isEmpty();
    }
}
