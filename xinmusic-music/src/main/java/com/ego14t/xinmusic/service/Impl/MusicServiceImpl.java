package com.ego14t.xinmusic.service.Impl;

import com.ego14t.common.constant.CdnConsts;
import com.ego14t.common.constant.TypePath;

import com.ego14t.common.error.ErrorCode;
import com.ego14t.common.exception.XMException;
import com.ego14t.xinmusic.entity.MusicEntity;
import com.ego14t.xinmusic.entity.MusicListEntity;
import com.ego14t.xinmusic.entity.MusicListMusicEntity;
import com.ego14t.xinmusic.mapper.MusiclistMapper;
import com.ego14t.xinmusic.mapper.MusicMapper;
import com.ego14t.xinmusic.pojo.SearchUserList;
import com.ego14t.xinmusic.service.MusicListService;
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
    private MusicMapper musicMapper;

    @Resource
    private MusiclistMapper musicListMapper;

    @Resource
    private MusicListService musicListService;

    /**
     * 根据歌曲id返回歌曲信息
     * @param musicId 歌曲id
     * @return 歌曲信息
     */
    @Override
    public MusicInfoVo getMusicInfo(String musicId) {
        MusicInfoVo musicInfo = new MusicInfoVo();
        MusicEntity musicEntity = musicMapper.getMusicInfo(musicId);
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
        MusicListEntity musicListEntity = musicListMapper.queryObject(null, musicListID);
        if (musicListEntity == null) {
            throw new XMException(ErrorCode.MUSICLIST_IS_NOT_EXISTS); //歌单不存在
        }
        MusicListMusicEntity musiclistMusic = musicMapper.getMusiclistMusic(musicListID, musicID);
        if (musiclistMusic != null){
            throw new XMException(ErrorCode.MUSIC_IS_EXISTS); //歌曲已存在
        }
        MusicListMusicEntity addEntity = new MusicListMusicEntity();
        addEntity.setMusicId(musicID);
        addEntity.setMusiclistId(musicListID);
        addEntity.setCreateTime(LocalDateTime.now());
        musicMapper.addMusicToList(addEntity);
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
        int res = musicMapper.delMusicFromList(musiclistId,musicId);
        if (res != 1){
            throw new XMException(ErrorCode.ERROR);
        }
    }

    @Override
    public List<MusicInfoVo> getSearchUserList(String userID, String keyword) {
        String defaultId = "";
        if (userID != null){
            MusicListEntity defaultList = musicMapper.getDefaultList(userID);
            defaultId = defaultList.getMusiclistId();
        }

        List<SearchUserList> searchUserLists = musicMapper.searchUserList(defaultId, keyword);
        return musicListService.getMusicInfoVos(searchUserLists);
    }
}
