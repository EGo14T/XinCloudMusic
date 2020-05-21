package com.ego14t.xinmusic.service.Impl;

import com.ego14t.xinmusic.entity.MusicList;
import com.ego14t.xinmusic.mapper.MusicMapper;
import com.ego14t.xinmusic.pojo.Music;
import com.ego14t.xinmusic.pojo.example.MusicExample;
import com.ego14t.xinmusic.service.SearchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/19
 * Description:
 */

@Service
public class SearchServiceImpl implements SearchService {

    @Resource
    private MusicMapper musicMapper;

    @Override
    public List<MusicList> getSearchList(String keyword) {
        MusicExample musicExample = new MusicExample();
        musicExample.createCriteria().andNameLike("%"+keyword+"%");
        List<Music> musics = musicMapper.selectByExample(musicExample);
        List<MusicList> musicLists = new ArrayList<>();
        for (Music music : musics) {
            MusicList musicList = MusicList.builder()
                    .id(music.getId())
                    .name(music.getName())
                    .singer(music.getSinger())
                    .album(music.getAlbum())
                    .length(music.getLength())
                    .url("http://cdn.ego1st.cn/xinmusic/musicFile/"+music.getId()+".mp3")
                    .build();
            musicLists.add(musicList);
        }

        return musicLists;
    }

    @Override
    public List<MusicList> getSearchUserList(String userID, String keyword) {
        List<Music> musics = musicMapper.searchUserMusic(userID,'%'+keyword+'%');
        List<MusicList> musicLists = new ArrayList<>();
        for (Music music : musics) {
            MusicList musicList = MusicList.builder()
                    .id(music.getId())
                    .name(music.getName())
                    .singer(music.getSinger())
                    .album(music.getAlbum())
                    .length(music.getLength())
                    .url("http://cdn.ego1st.cn/xinmusic/musicFile/"+music.getId()+".mp3")
                    .build();
            //musicID不为null时，为收藏的歌曲，collection值为1
            if (music.getMusicID() != null) {
                musicList.setCollection(1);
            }
            musicLists.add(musicList);
        }
        return musicLists;
    }
}
