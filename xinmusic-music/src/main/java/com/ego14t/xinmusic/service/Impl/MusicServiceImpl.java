package com.ego14t.xinmusic.service.Impl;

import com.ego14t.common.constant.CdnConsts;
import com.ego14t.common.constant.TypePath;
import com.ego14t.common.error.ErrorCode;
import com.ego14t.common.exception.XMException;
import com.ego14t.common.utils.EgoCode;
import com.ego14t.xinmusic.entity.MusicEntity;
import com.ego14t.xinmusic.entity.MusicListEntity;
import com.ego14t.xinmusic.entity.MusicListMusicEntity;
import com.ego14t.xinmusic.mapper.MusicMapper;
import com.ego14t.xinmusic.mapper.MusiclistMapper;
import com.ego14t.xinmusic.pojo.SearchUserList;
import com.ego14t.xinmusic.service.MusicListService;
import com.ego14t.xinmusic.service.MusicService;
import com.ego14t.xinmusic.vo.MusicInfoVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
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
    private MusiclistMapper musiclistMapper;

    @Resource
    private MusicListService musiclistService;

    /**
     * 根据歌曲id返回歌曲信息
     * @param musicId 歌曲id
     * @return 歌曲信息
     */
    @Override
    public MusicInfoVo getMusicInfo(String musicId) {
        updateMusicId();
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
    public void addMusicToList(String musiclistId, String musicID) {
        MusicListEntity musiclistEntity = musiclistMapper.queryObject(null, musiclistId);
        if (musiclistEntity == null) {
            throw new XMException(ErrorCode.MUSICLIST_IS_NOT_EXISTS); //歌单不存在
        }
        MusicListMusicEntity musiclistMusic = musicMapper.getMusiclistMusic(musiclistId, musicID);
        if (musiclistMusic != null){
            throw new XMException(ErrorCode.MUSIC_IS_EXISTS); //歌曲已存在
        }
        MusicListMusicEntity addEntity = new MusicListMusicEntity();
        addEntity.setMusicId(musicID);
        addEntity.setMusiclistId(musiclistId);
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
    public List<MusicInfoVo> getSearchUserList(String userId, String keyword) {
        String defaultId = "";
        if (userId != null){
            MusicListEntity defaultList = musicMapper.getDefaultList(userId);
            defaultId = defaultList.getMusiclistId();
        }

        List<SearchUserList> searchUserLists = musicMapper.searchUserList(defaultId, keyword);
        return musiclistService.getMusicInfoVos(searchUserLists);
    }

    @Override
    public void likeMusic(String userId, String musicId) {
        MusicListEntity defaultList = musicMapper.getDefaultList(userId);
        String defaultListId = defaultList.getMusiclistId();
        addMusicToList(defaultListId, musicId);
    }

    @Override
    public void dislikeMusic(String userId, String musicId) {
        MusicListEntity defaultList = musicMapper.getDefaultList(userId);
        String defaultListId = defaultList.getMusiclistId();
        delMusicFromList(defaultListId, musicId);
    }

    public void updateMusicId() {
        String[] ids = {"90390131827015680",
                "90390133198553088",
                "90390133555068928",
                "90390133974499328",
                "90390134242934784",
                "90390134708502528",
                "90390135085989888",
                "90390135404756992",
                "90390135887101952",
                "90390136272977920",
                "90390136952455168",
                "90390137644515328",
                "90390138101694464",
                "90390138516930560",
                "90390139007664128",
                "90390139280293888",
                "90390139666169856",
                "90390140161097728",
                "90390140651831296",
                "90390141171924992",
                "90390141910122496",
                "90390142711234560",
                "90390143130664960",
                "90390143554289664",
                "90390144489619456",
                "90390144837746688",
                "90390145223622656",
                "90390145609498624",
                "90390146003763200",
                "90390146616131584"};


        for (String id :
                ids) {
            Long aLong = Long.parseLong(id);
            String encode = EgoCode.encode(aLong);
            musicMapper.updateId(id,encode);
        }
    }
}
