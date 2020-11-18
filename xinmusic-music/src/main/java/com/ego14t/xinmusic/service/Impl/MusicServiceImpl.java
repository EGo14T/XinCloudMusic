package com.ego14t.xinmusic.service.Impl;

import com.ego14t.xinmusic.common.CdnConsts;
import com.ego14t.xinmusic.common.TypePath;

import com.ego14t.xinmusic.newentity.*;
import com.ego14t.xinmusic.newmapper.MusicMapper1;
import com.ego14t.xinmusic.newpojo.SearchUserList;
import com.ego14t.xinmusic.service.MusicService;
import com.ego14t.xinmusic.vo.MusicInfoVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private MusicMapper1 mapper;

    /**
     * 根据歌曲id返回歌曲信息
     * @param musicId 歌曲id
     * @return 歌曲信息
     */
    @Override
    public MusicInfoVo getMusicInfo(String musicId) {
        MusicInfoVo musicInfo = new MusicInfoVo();
        MusicEntity musicEntity = mapper.getMusicInfo(musicId);

        if (musicEntity == null){
            return null;
        }

        musicInfo.setMusicId(musicEntity.getMusicId());
        musicInfo.setMusicName(musicEntity.getMusicName());
        musicInfo.setSinger(musicEntity.getSinger());
        musicInfo.setAlbum(musicEntity.getAlbum());
        musicInfo.setLength(musicEntity.getLength());
        musicInfo.setUrl(CdnConsts.CDN_PATH + CdnConsts.PROJECT_PATH + TypePath.MUSIC_FILE.getPath()+ "/" + musicEntity.getMusicId()+".mp3");

        return musicInfo;

    }

    /**
     * 从歌单中删除歌曲
     * @param musiclistId 歌单id
     * @param musicId 歌曲id
     * @return 删除信息报文
     */
    @Override
    @Transactional
    public String delMusicFromList(String musiclistId, String musicId) {
        //int res = musiclistMusicMapper.deleteByPrimaryKey(new MusiclistMusicKey(musicListID,musicID));
        int res = mapper.delMusicFromList(musiclistId,musicId);
        if (res == 1){
            //返回删除报文
            return "204";
        }else {
            return "删除失败";
        }
    }

    @Override
    @Transactional
    public String addMusicToList(String musicListID, String musicID) {
        MusicListMusicEntity musiclistMusic = mapper.getMusiclistMusic(musicListID, musicID);
        if (musiclistMusic == null){
            MusicListMusicEntity addEntity = new MusicListMusicEntity();
            addEntity.setMusicId(musicListID);
            addEntity.setMusicId(musicID);
            addEntity.setCreateTime(LocalDateTime.now());
            mapper.addMusicToList(addEntity);
            return "200";
        }
        return "歌曲已存在";
    }

    @Override
    public List<MusicInfoVo> getSearchUserList(String userID, String keyword) {
        String defaultId = "";
        if (userID != null){
            MusicListEntity defaultList = mapper.getDefaultList(userID);
            defaultId = defaultList.getMusiclistId();
        }

        List<SearchUserList> searchUserLists = mapper.searchUserList(defaultId, keyword);
        List<MusicInfoVo> musicInfoVos = new ArrayList<>();
        for (SearchUserList s : searchUserLists) {
            MusicInfoVo musicInfoVo = new MusicInfoVo();
            musicInfoVo.setMusicId(s.getMusicId());
            musicInfoVo.setMusicName(s.getMusicName());
            musicInfoVo.setSinger(s.getSinger());
            musicInfoVo.setAlbum(s.getAlbum());
            musicInfoVo.setLength(s.getLength());
            musicInfoVo.setUrl(CdnConsts.CDN_PATH + CdnConsts.PROJECT_PATH + TypePath.MUSIC_FILE + "/" + s.getMusicId()+".mp3");
            if (s.getCollect() != null) {
                musicInfoVo.setCollection(1);
            }
            musicInfoVos.add(musicInfoVo);
        }
        return musicInfoVos;
    }
}
