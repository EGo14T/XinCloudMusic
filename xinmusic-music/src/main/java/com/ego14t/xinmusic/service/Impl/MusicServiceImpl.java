package com.ego14t.xinmusic.service.Impl;

import com.ego14t.xinmusic.entity.MusicList;

import com.ego14t.xinmusic.mapper.MusicMapper;
import com.ego14t.xinmusic.mapper.MusiclistMusicMapper;
import com.ego14t.xinmusic.pojo.Music;
import com.ego14t.xinmusic.pojo.MusiclistMusicKey;
import com.ego14t.xinmusic.pojo.example.MusiclistMusicExample;
import com.ego14t.xinmusic.service.MusicService;
import com.ego14t.xinmusic.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author 王富昕
 * Create By EGo1ST
 * Date ：Created in 2019/9/29 11:33
 * Description：歌曲操作的相关操作
 */
@Service
public class MusicServiceImpl implements MusicService {
    @Resource
    MusicMapper musicMapper;

    @Resource
    MusiclistMusicMapper musiclistMusicMapper;

    @Resource
    RedisUtil redisUtil;


    /**
     * 根据歌曲id返回歌曲信息
     * @param id 歌曲id
     * @return 歌曲信息
     */
    @Override
    public MusicList getMusic(String id) {
        if (redisUtil.get("musicList::"+id)==null){
            Music music = musicMapper.selectByPrimaryKey(id);
            if (music==null){
                return null;
            }else{
                MusicList musicList = MusicList.builder()
                        .id(music.getId())
                        .name(music.getName())
                        .singer(music.getSinger())
                        .album(music.getAlbum())
                        .url("http://cdn.ego1st.cn/xinmusic/musicFile/"+music.getId()+".mp3")
                        .build();

                redisUtil.set("musicList::"+id,musicList,60);
                return musicList;

            }
        }else {
            return (MusicList)redisUtil.get("musicList::"+id);
        }
    }

    /**
     * 从歌单中删除歌曲
     * @param musicListID 歌单id
     * @param musicID 歌曲id
     * @return 删除信息报文
     */
    @Override
    public String delMusic(String musicListID, String musicID) {
        int res = musiclistMusicMapper.deleteByPrimaryKey(new MusiclistMusicKey(musicListID,musicID));
        if (res == 1){
            //返回删除报文
            return "204";
        }else {
            return "删除失败";
        }
    }

    @Override
    public String addMusicToList(String musicListID, String musicID) {
        MusiclistMusicKey ans = new MusiclistMusicKey(musicListID,musicID);
        MusiclistMusicKey musiclistMusicKey = musiclistMusicMapper.selectByPrimaryKey(ans);
        if (musiclistMusicKey==null){
            musiclistMusicMapper.insert(ans);
            return "200";
        }else{
            return "歌曲已存在！";
        }
    }
}
