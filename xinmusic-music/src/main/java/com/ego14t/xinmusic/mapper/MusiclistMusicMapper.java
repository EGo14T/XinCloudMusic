package com.ego14t.xinmusic.mapper;

import com.ego14t.xinmusic.pojo.MusiclistMusic;
import com.ego14t.xinmusic.pojo.example.MusiclistMusicExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MusiclistMusicMapper {
    long countByExample(MusiclistMusicExample example);

    int deleteByExample(MusiclistMusicExample example);

    int insert(MusiclistMusic record);

    int insertSelective(MusiclistMusic record);

    List<MusiclistMusic> selectByExample(MusiclistMusicExample example);

    int updateByExampleSelective(@Param("record") MusiclistMusic record, @Param("example") MusiclistMusicExample example);

    int updateByExample(@Param("record") MusiclistMusic record, @Param("example") MusiclistMusicExample example);
}