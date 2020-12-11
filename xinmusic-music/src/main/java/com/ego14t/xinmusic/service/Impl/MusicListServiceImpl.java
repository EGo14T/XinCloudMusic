package com.ego14t.xinmusic.service.Impl;


import com.ego14t.common.common.CdnConsts;
import com.ego14t.common.common.DataConsts;
import com.ego14t.common.common.TypePath;
import com.ego14t.xinmusic.config.WorkID;

import com.ego14t.xinmusic.entity.MusicListCollectEntity;
import com.ego14t.xinmusic.entity.MusicListEntity;
import com.ego14t.xinmusic.mapper.MusicListMapper;
import com.ego14t.xinmusic.mapper.MusicMapper;
import com.ego14t.xinmusic.pojo.MusicListInfo;
import com.ego14t.xinmusic.pojo.SearchUserList;
import com.ego14t.xinmusic.pojo.UserMusicList;
import com.ego14t.xinmusic.service.MusicListService;

import com.ego14t.xinmusic.util.EgoCode;
import com.ego14t.xinmusic.util.IDworker;
import com.ego14t.xinmusic.vo.MusicListVo;
import com.ego14t.xinmusic.vo.MusicInfoVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    private MusicMapper mapper;

    @Resource
    private MusicListMapper musicListMapper;

    @Resource
    private WorkID workID;

    @Override
    public List<UserMusicList> getCreateMusicListInfo(String currentUserId, String userId) {
        List<UserMusicList> userCreateMusicList = musicListMapper.getUserCreateMusicList(currentUserId, userId);
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
     * @param musicListVo 歌单信息
     * @return 状态码和信息  返回主键id
     * Description：添加歌单
     */
    @Override
    @Transactional
    public String createMusicList(MusicListVo musicListVo) {
        MusicListEntity createEntity = new MusicListEntity();

        String nextId = new IDworker(workID.getValue(), 0).nextId();
        String musiclistId = EgoCode.encode(Long.parseLong(nextId));

        createEntity.setId(nextId);
        createEntity.setMusiclistId(musiclistId);
        createEntity.setCreateUserId("1");
        createEntity.setMusiclistName(musicListVo.getMusiclistName());
        createEntity.setTags(musicListVo.getTags());
        createEntity.setDescription(musicListVo.getDescription());
        createEntity.setMusiclistImg(CdnConsts.CDN_PATH + CdnConsts.PROJECT_PATH + TypePath.MUSICLIST_IMG.getPath() + musiclistId + ".jpg");
        createEntity.setStatus(DataConsts.NORMAL_STATUS);
        Integer res = musicListMapper.createMusicList(createEntity);
        if (res == 1){
            return createEntity.getMusiclistId();
        }
        return null;
    }

    /**
     * @param userID      用户ID
     * @param musiclistId 歌单ID
     * @return ResponseJsonResult
     * Description：删除歌单
     */
    @Override
    @Transactional
    public String delMusicList(String userID, String musiclistId) {
        MusicListEntity musicListEntity = musicListMapper.queryObject(userID, musiclistId);
        Integer res;
        //不是该用户创建的
        if (musicListEntity == null) {
            //删除收藏表
            res = musicListMapper.delCollect(userID, musiclistId);
        } else {
            if (musicListEntity.getStatus() != 0) {
                res = musicListMapper.delCreatedList(userID, musiclistId);
            }else {
                return "401";
            }
        }

        if (res == 1) {
            musicListMapper.delMusicFromList(musiclistId);
        }

        return "204";

    }

    /**
     * @param updateMusicListVo 修改的实体
     * @return 歌单ID
     */
    @Override
    @Transactional
    public String updateMusicList(MusicListVo updateMusicListVo) {
        MusicListEntity updateEntity = new MusicListEntity();
        updateEntity.setMusiclistId(updateMusicListVo.getMusiclistId());
        updateEntity.setMusiclistName(updateMusicListVo.getMusiclistName());
        updateEntity.setTags(updateMusicListVo.getTags());
        updateEntity.setDescription(updateMusicListVo.getDescription());
        updateEntity.setStatus(DataConsts.NORMAL_STATUS);
        updateEntity.setMusiclistImg(updateMusicListVo.getMusiclistImg());
        Integer res = musicListMapper.update(updateEntity);
        return res.toString();
    }
}
