package com.ego14t.xinmusic.mapper;

import com.ego14t.xinmusic.pojo.MusiclistCollect;
import com.ego14t.xinmusic.pojo.example.MusiclistCollectExample;
import com.ego14t.xinmusic.pojo.MusiclistCollectKey;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MusiclistCollectMapper {
    long countByExample(MusiclistCollectExample example);

    int deleteByExample(MusiclistCollectExample example);

    int deleteByPrimaryKey(MusiclistCollectKey key);

    int insert(MusiclistCollect record);

    int insertSelective(MusiclistCollect record);

    List<MusiclistCollect> selectByExample(MusiclistCollectExample example);

    MusiclistCollect selectByPrimaryKey(MusiclistCollectKey key);

    int updateByExampleSelective(@Param("record") MusiclistCollect record, @Param("example") MusiclistCollectExample example);

    int updateByExample(@Param("record") MusiclistCollect record, @Param("example") MusiclistCollectExample example);

    int updateByPrimaryKeySelective(MusiclistCollect record);

    int updateByPrimaryKey(MusiclistCollect record);
}