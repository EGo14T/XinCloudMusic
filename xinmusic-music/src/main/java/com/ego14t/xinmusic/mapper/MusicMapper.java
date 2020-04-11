package com.ego14t.xinmusic.mapper;

import com.ego14t.xinmusic.pojo.Music;
import com.ego14t.xinmusic.pojo.example.MusicExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MusicMapper {
    long countByExample(MusicExample example);

    int deleteByExample(MusicExample example);

    int deleteByPrimaryKey(String id);

    int insert(Music record);

    int insertSelective(Music record);

    List<Music> selectByExample(MusicExample example);

    Music selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Music record, @Param("example") MusicExample example);

    int updateByExample(@Param("record") Music record, @Param("example") MusicExample example);

    int updateByPrimaryKeySelective(Music record);

    int updateByPrimaryKey(Music record);


    //自定义
    List<Music> searchMusicList(String id);

    List<Music> searchCollection(String userId);

    List<Music> searchUserNumList(String musicListID,String userId);

    List<Music> searchNumList(String musicListID);

    void delMusicListById(String id);
}