package com.ego14t.xinmusic.service.Impl;

import com.ego14t.common.constant.CdnConsts;
import com.ego14t.common.constant.TypePath;
import com.ego14t.common.error.ErrorCode;
import com.ego14t.common.exception.XMException;
import com.ego14t.common.utils.BeanCopyUtils;
import com.ego14t.xinmusic.config.WorkID;
import com.ego14t.xinmusic.entity.MusicListCollectEntity;
import com.ego14t.xinmusic.entity.MusicListEntity;
import com.ego14t.xinmusic.mapper.MusicMapper;
import com.ego14t.xinmusic.mapper.MusiclistMapper;
import com.ego14t.xinmusic.pojo.MusicListInfo;
import com.ego14t.xinmusic.pojo.SearchUserList;
import com.ego14t.xinmusic.pojo.UserMusiclist;
import com.ego14t.xinmusic.service.MusicListService;
import com.ego14t.xinmusic.util.EgoCode;
import com.ego14t.xinmusic.util.IDworker;
import com.ego14t.xinmusic.vo.MusicInfoVo;
import com.ego14t.xinmusic.vo.MusicListVo;
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
    private MusicMapper musicMapper;

    @Resource
    private MusiclistMapper musiclistMapper;

    @Resource
    private WorkID workID;

    /**
     * 获取创建歌单的信息
     * @param currentUserId
     * @param userId
     * @return
     */
    @Override
    public List<UserMusiclist> getCreateMusicListInfo(String currentUserId, String userId) {
        List<UserMusiclist> userCreateMusicList = musiclistMapper.getUserCreateMusicList(currentUserId, userId);
        if (userCreateMusicList == null || userCreateMusicList.size() == 0) {
            throw new XMException(ErrorCode.CREATE_MUSICLIST_IS_NOT_EXISTS);
        }
        UserMusiclist remove = new UserMusiclist();
        for (int i = 0; i < userCreateMusicList.size(); i++) {
            if (userCreateMusicList.get(i).getStatus() == 0){
                remove = userCreateMusicList.remove(i);
                break;
            }
        }
        userCreateMusicList.add(0,remove);
        return userCreateMusicList;
    }

    /**
     * 获取收藏歌单的信息
     * @param userId
     * @return
     */
    @Override
    public List<UserMusiclist> getCollectMusicListInfo(String userId) {
        return musiclistMapper.getUserCollectMusicList(userId);
    }

    /**
     * 获取推荐歌单
     * @return
     */
    @Override
    public List<UserMusiclist> getDiscoverMusicListInfo() {
        //todo 推荐逻辑
        return musiclistMapper.getDiscoverMusicList();
    }

    /**
     * 收藏歌单
     * @param userId
     * @param musiclistId
     */
    @Override
    @Transactional
    public void collectMusicList(String userId, String musiclistId) {
        MusicListCollectEntity addEntity = new MusicListCollectEntity();
        addEntity.setMusiclistId(musiclistId);
        addEntity.setUserid(userId);
        Integer res = musiclistMapper.collectMusicList(addEntity);
        if (res != 1) {
            throw new XMException(ErrorCode.COLLECT_MUSICLIST_FAILED); //收藏歌单失败
        }
    }

    @Override
    public void unCollectMusicList(String userId, String musiclistId) {
        MusicListCollectEntity addEntity = new MusicListCollectEntity();
        addEntity.setMusiclistId(musiclistId);
        addEntity.setUserid(userId);
        Integer res = musiclistMapper.unCollectMusicList(addEntity);
        if (res != 1) {
            throw new XMException(ErrorCode.COLLECT_MUSICLIST_FAILED); //收藏歌单失败
        }
    }

    /**
     * @param musiclistId 歌单ID
     * @param userId      用户ID
     * @return MusicInfo
     * Description：查询歌单 中的 所有歌曲
     */
    @Override
    public List<MusicInfoVo> getUserMusicList(String musiclistId, String userId) {
        String defaultId = "";
        if (userId != null){
            MusicListEntity defaultList = musicMapper.getDefaultList(userId);
            defaultId = defaultList.getMusiclistId();
        }
        List<SearchUserList> searchUserLists = musicMapper.getUserList(defaultId, musiclistId);
        return getMusicInfoVos(searchUserLists);
    }


    @Override
    public MusicListInfo getMusicListInfo(String userId, String musiclistId) {
        MusicListInfo musiclistInfo = musiclistMapper.getMusicListInfo(userId, musiclistId);
        if (musiclistInfo == null) {
            throw new XMException(ErrorCode.MUSICLISTINFO_IS_NOT_EXISTS); //歌单信息不存在
        }
        return musiclistInfo;
    }

    /**
     * @param musiclistVo 歌单信息
     * @return 状态码和信息  返回主键id
     * Description：添加歌单
     */
    @Override
    @Transactional
    public String createMusicList(MusicListVo musiclistVo) {
        MusicListEntity createEntity = new MusicListEntity();

        String nextId = new IDworker(workID.getValue(), 0).nextId();
        String musiclistId = EgoCode.encode(Long.parseLong(nextId));

        createEntity.setId(nextId);
        createEntity.setMusiclistId(musiclistId);
        createEntity.setCreateUserId("1");
        createEntity.setMusiclistName(musiclistVo.getMusiclistName());
        createEntity.setTags(musiclistVo.getTags());
        createEntity.setDescription(musiclistVo.getDescription());
        createEntity.setMusiclistImg(CdnConsts.CDN_PATH + CdnConsts.PROJECT_PATH + TypePath.MUSICLIST_IMG.getPath() + "default.jpg");
        createEntity.setStatus(musiclistVo.getStatus());
        Integer res = musiclistMapper.createMusicList(createEntity);
        if (res != 1){
           throw new XMException(ErrorCode.CREATE_MUSICLIST_FAILED); //新建歌单失败
        }
        return musiclistId;
    }

    /**
     * @param userId      用户ID
     * @param musiclistId 歌单ID
     * @return
     * Description：删除歌单
     */
    @Override
    @Transactional
    public void delMusicList(String userId, String musiclistId, String delType) {
        MusicListEntity musiclistEntity = musiclistMapper.queryObject(userId, musiclistId);
        if (musiclistEntity == null) {
            throw new XMException(ErrorCode.MUSICLIST_IS_NOT_EXISTS); //歌单不存在
        }
        if ("created".equals(delType)){
            if (musiclistEntity.getStatus() == 0) {
                throw new XMException(ErrorCode.DEFAULT_MUSICLIST_CANT_DEL); //默认歌单无法删除
            }
        }
        musiclistMapper.delCreatedList(userId,musiclistId);
        musiclistMapper.delMusicFromList(musiclistId);
    }

    /**
     * @param updateMusicListVo 修改的实体
     * @return 歌单ID
     */
    @Override
    @Transactional
    public void updateMusicList(MusicListVo updateMusicListVo) {
        MusicListEntity updateEntity = new MusicListEntity();
        BeanCopyUtils.copy(updateMusicListVo, updateEntity);
        Integer res = musiclistMapper.update(updateEntity);
        if (res != 1){
            throw new XMException(ErrorCode.UPDATE_MUSICLISTINFO_FAILED); //修改歌单信息失败
        }
    }

    @Override
    public List<MusicInfoVo> getMusicInfoVos(List<SearchUserList> searchUserLists) {
        List<MusicInfoVo> musicInfoVos = new ArrayList<>();
        for (SearchUserList s : searchUserLists) {
            MusicInfoVo musicInfoVo = new MusicInfoVo();
            musicInfoVo.setMusicId(s.getMusicId());
            musicInfoVo.setMusicName(s.getMusicName());
            musicInfoVo.setSinger(s.getSinger());
            musicInfoVo.setAlbum(s.getAlbum());
            musicInfoVo.setLength(s.getLength());
            musicInfoVo.setUrl(CdnConsts.CDN_PATH + CdnConsts.PROJECT_PATH + TypePath.MUSIC_FILE.getPath() + "/" + s.getMusicId()+".mp3");
            if (s.getCollect() != null) {
                musicInfoVo.setCollection(1);
            }
            musicInfoVos.add(musicInfoVo);
        }
        return musicInfoVos;
    }
}
