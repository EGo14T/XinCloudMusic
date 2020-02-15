package com.ego14t.xinmusic.service.Impl;

import com.ego14t.xinmusic.entity.MusicList;

import com.ego14t.xinmusic.mapper.MusicMapper;
import com.ego14t.xinmusic.mapper.MusiclistMusicMapper;
import com.ego14t.xinmusic.pojo.Music;
import com.ego14t.xinmusic.pojo.MusiclistMusic;
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
    public MusicList getMusic(int id) {
        if (redisUtil.get("musicList::"+id)==null){
            Music music = musicMapper.selectByPrimaryKey(id);
            if (music==null){
                return null;
            }else{
                MusicList musicList = MusicList.builder()
                        .id(music.getId())
                        .name(music.getName())
                        .artist(music.getSinger())
                        .album(music.getAlbum())
                        .img(music.getImgurl())
                        .lrc(music.getLrcurl())
                        .url("http://source.ego1st.cn/song/id="+music.getId()+".mp3")
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
    public String delMusic(Integer musicListID, Integer musicID) {
        MusiclistMusicExample musiclistMusicExample = new MusiclistMusicExample();
        //创建查询条件
        musiclistMusicExample.createCriteria().andMusiclistidEqualTo(musicListID)
                                              .andMusicidEqualTo(musicID);
        musiclistMusicMapper.deleteByExample(musiclistMusicExample);
        //返回删除报文
        return "204";
    }

    @Override
    public String addMusicToList(Integer musicListID, Integer musicID) {
        MusiclistMusicExample musiclistMusicExample = new MusiclistMusicExample();
        musiclistMusicExample.createCriteria().andMusiclistidEqualTo(musicListID)
                                              .andMusicidEqualTo(musicID);

        List<MusiclistMusic> musiclistMusics = musiclistMusicMapper.selectByExample(musiclistMusicExample);
        if (musiclistMusics.size()==0){
            MusiclistMusic musiclistMusic = new MusiclistMusic();
            musiclistMusic.setMusicid(musicID);
            musiclistMusic.setMusiclistid(musicListID);
            musiclistMusicMapper.insert(musiclistMusic);
            return "200";
        }else{
            return "歌曲已存在！";
        }
    }
}
