package com.ego14t.xinmusic.mapper;

import com.ego14t.xinmusic.pojo.example.UserMusicExample;
import com.ego14t.xinmusic.pojo.UserMusicKey;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMusicMapper {
    long countByExample(UserMusicExample example);

    int deleteByExample(UserMusicExample example);

    int deleteByPrimaryKey(UserMusicKey key);

    int insert(UserMusicKey record);

    int insertSelective(UserMusicKey record);

    List<UserMusicKey> selectByExample(UserMusicExample example);

    int updateByExampleSelective(@Param("record") UserMusicKey record, @Param("example") UserMusicExample example);

    int updateByExample(@Param("record") UserMusicKey record, @Param("example") UserMusicExample example);
}