package com.ego14t.xinmusic.service.Impl;


import com.ego14t.xinmusic.common.CdnConsts;
import com.ego14t.xinmusic.common.TypePath;
import com.ego14t.xinmusic.mapper.MusicMapper;
import com.ego14t.xinmusic.mapper.MusiclistCollectMapper;
import com.ego14t.xinmusic.mapper.MusiclistMusicMapper;
import com.ego14t.xinmusic.mapper.MusiclistUserMapper;

import com.ego14t.xinmusic.newentity.MusicListCollectEntity;
import com.ego14t.xinmusic.newentity.MusicListEntity;
import com.ego14t.xinmusic.newmapper.MusicListMapper;
import com.ego14t.xinmusic.newmapper.MusicMapper1;
import com.ego14t.xinmusic.newpojo.MusicListInfo;
import com.ego14t.xinmusic.newpojo.SearchUserList;
import com.ego14t.xinmusic.newpojo.UserMusicList;
import com.ego14t.xinmusic.pojo.*;
import com.ego14t.xinmusic.pojo.example.MusiclistMusicExample;
import com.ego14t.xinmusic.pojo.example.MusiclistUserExample;
import com.ego14t.xinmusic.service.MusicListService;

import com.ego14t.xinmusic.util.IDworker;
import com.ego14t.xinmusic.vo.CreateMusicListVo;
import com.ego14t.xinmusic.vo.MusicInfoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Create By EGo1ST
 * Date ：Created in 2019/8/2 11:17
 * Description：
 */
@Service
public class MusicListServiceImpl implements MusicListService {

    @Resource
    private MusicMapper musicMapper;

    @Resource
    private MusicMapper1 mapper;

    @Resource
    private MusicListMapper musicListMapper;

    @Resource
    private MusiclistUserMapper musiclistUserMapper;

    @Resource
    private MusiclistMusicMapper musiclistMusicMapper;

    @Resource
    private MusiclistCollectMapper musiclistCollectMapper;

    @Override
    public List<UserMusicList> getCreateMusicListInfo(String userId) {
        List<UserMusicList> userCreateMusicList = musicListMapper.getUserCreateMusicList(userId);
        UserMusicList remove = new UserMusicList();
        for (int i = 0; i < userCreateMusicList.size(); i++) {
            if (userCreateMusicList.get(i).getStatus() == 0){
                remove = userCreateMusicList.remove(i);
            }
        }
        userCreateMusicList.add(0,remove);
        return userCreateMusicList;
    }



    @Override
    public List<UserMusicList> getCollectMusicListInfo(String userId) {
        return musicListMapper.getUserCollectMusicList(userId);
    }

    @Override
    public List<UserMusicList> getDiscoverMusicListInfo() {
        //todo 推荐逻辑
        return musicListMapper.getDiscoverMusicList();
    }

    @Override
    public Integer collectMusicList(String userId, String musicListID) {
        MusicListCollectEntity addEntity = new MusicListCollectEntity();
        addEntity.setMusiclistId(musicListID);
        addEntity.setUserid(userId);
        return musicListMapper.collectMusicList(addEntity);
    }

    /**
     * @param musicListID 歌单ID
     * @param userId      用户ID
     * @return MusicInfo
     * Description：查询歌单 中的 所有歌曲
     */
    @Override
    public List<MusicInfoVo> getUserMusicList(String musicListID, String userId) {
        String defaultId = "";
        if (userId != null){
            MusicListEntity defaultList = mapper.getDefaultList(userId);
            defaultId = defaultList.getMusiclistId();
        }

        List<SearchUserList> searchUserLists = mapper.getUserList(defaultId, musicListID);
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

    @Override
    public MusicListInfo getMusicListInfo(String userID, String musicListID) {
        return musicListMapper.getMusicListInfo(userID, musicListID);
    }
    
    /**
     * @param userID      用户ID
     * @param musicListID 歌单ID
     * @return ResponseJsonResult
     * Description：删除歌单
     */
    @Override
    public String delMusicList(String userID, String musicListID) {

        MusiclistUser musiclistUser = musiclistUserMapper.selectByPrimaryKey(new MusiclistUserKey(userID, musicListID));

        MusiclistMusicExample musiclistMusicExample = new MusiclistMusicExample();
        musiclistMusicExample.createCriteria().andMusiclistidEqualTo(musicListID);

        List<MusiclistMusicKey> musiclistMusics = musiclistMusicMapper.selectByExample(musiclistMusicExample);

        if (musiclistUser == null) {
            MusiclistCollect musiclistCollect = new MusiclistCollect();
            musiclistCollect.setUserid(userID);
            musiclistCollect.setMusiclistid(musicListID);
            musiclistCollectMapper.deleteByPrimaryKey(musiclistCollect);
            return "204";
        } else {
            if (musiclistUser.getStatus() == 0) {
                return "401";
            } else if (musiclistMusics.size() == 0) {
                musiclistUserMapper.deleteByPrimaryKey(new MusiclistUserKey(userID, musicListID));
                return "204";

            } else {
                musicMapper.delMusicListById(musicListID);
                return "204";
            }
        }

    }

    /**
     * @param createMusicListVo 歌单信息
     * @return 状态码和信息  返回主键id
     * Description：添加歌单
     */
    @Override
    public String createMusicList(CreateMusicListVo createMusicListVo) {
        MusicListEntity createEntity = new MusicListEntity();

        //createEntity.set

        musicListMapper.createMusicList(createEntity);
        return null;
    }

    /**
     * @param id            歌单ID
     * @param musiclistUser 修改的实体
     * @return 歌单ID
     */
    @Override
    public String updateMusicList(String id, MusiclistUser musiclistUser) {
        //创建查询条件
        MusiclistUserExample musiclistUserExample = new MusiclistUserExample();
        musiclistUserExample.createCriteria().andMusiclistidEqualTo(id);
        //根据Id修改歌单信息
        musiclistUserMapper.updateByExampleSelective(musiclistUser, musiclistUserExample);
        return id;
    }
}
