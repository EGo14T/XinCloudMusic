package com.ego14t.xinmusic.service.Impl;

import com.ego14t.common.constant.CdnConsts;
import com.ego14t.common.constant.TypePath;

import com.ego14t.common.error.ErrorCode;
import com.ego14t.common.exception.XMException;
import com.ego14t.xinmusic.entity.MusicEntity;
import com.ego14t.xinmusic.entity.MusicListEntity;
import com.ego14t.xinmusic.entity.MusicListMusicEntity;
import com.ego14t.xinmusic.mapper.MusicMapper;
import com.ego14t.xinmusic.pojo.SearchUserList;
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
    private MusicMapper mapper;

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
            throw new XMException(ErrorCode.NOT_FOUND_MUSICINFO);
        }
        musicInfo.setMusicId(musicEntity.getMusicId());
        musicInfo.setMusicName(musicEntity.getMusicName());
        musicInfo.setSinger(musicEntity.getSinger());
        musicInfo.setAlbum(musicEntity.getAlbum());
        musicInfo.setLength(musicEntity.getLength());
        musicInfo.setUrl(CdnConsts.CDN_PATH + CdnConsts.PROJECT_PATH + TypePath.MUSIC_FILE.getPath() + musicEntity.getMusicId()+".mp3");

        return musicInfo;

    }

    @Override
    @Transactional
    public void addMusicToList(String musicListID, String musicID) {
        MusicListMusicEntity musiclistMusic = mapper.getMusiclistMusic(musicListID, musicID);
        if (musiclistMusic != null){
            throw new XMException(ErrorCode.MUSIC_IS_EXISTS);
        }
        MusicListMusicEntity addEntity = new MusicListMusicEntity();
        addEntity.setMusicId(musicID);
        addEntity.setMusiclistId(musicListID);
        addEntity.setCreateTime(LocalDateTime.now());
        mapper.addMusicToList(addEntity);
    }

    /**
     * 从歌单中删除歌曲
     * @param musiclistId 歌单id
     * @param musicId 歌曲id
     * @return 删除信息报文
     */
    @Override
    @Transactional
    public void delMusicFromList(String musiclistId, String musicId) {
        int res = mapper.delMusicFromList(musiclistId,musicId);
        if (res != 1){
            throw new XMException(ErrorCode.ERROR);
        }
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
