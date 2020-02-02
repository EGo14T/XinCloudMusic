package com.ego14t.xinmusic.mapper;

import com.ego14t.xinmusic.pojo.UserMusic;
import com.ego14t.xinmusic.pojo.example.UserMusicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMusicMapper {
    int countByExample(UserMusicExample example);

    int deleteByExample(UserMusicExample example);

    int insert(UserMusic record);

    int insertSelective(UserMusic record);

    List<UserMusic> selectByExample(UserMusicExample example);

    int updateByExampleSelective(@Param("record") UserMusic record, @Param("example") UserMusicExample example);

    int updateByExample(@Param("record") UserMusic record, @Param("example") UserMusicExample example);
}