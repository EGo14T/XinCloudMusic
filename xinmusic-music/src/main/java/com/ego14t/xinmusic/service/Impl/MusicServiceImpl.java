package com.ego14t.xinmusic.service.Impl;

import com.ego14t.xinmusic.common.CdnConsts;
import com.ego14t.xinmusic.common.TypePath;
import com.ego14t.xinmusic.entity.MusicInfo;

import com.ego14t.xinmusic.mapper.MusicMapper;
import com.ego14t.xinmusic.mapper.MusiclistMusicMapper;
import com.ego14t.xinmusic.newentity.MusicEntity;
import com.ego14t.xinmusic.newmapper.MusicMapper1;
import com.ego14t.xinmusic.pojo.Music;
import com.ego14t.xinmusic.pojo.MusiclistMusicKey;
import com.ego14t.xinmusic.pojo.example.MusicExample;
import com.ego14t.xinmusic.service.MusicService;
import com.ego14t.xinmusic.util.BeanCopyUtils;
import com.ego14t.xinmusic.util.RedisUtil;
import com.ego14t.xinmusic.vo.MusicInfoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    private MusiclistMusicMapper musiclistMusicMapper;

    @Resource
    private MusicMapper1 mapper;

    @Resource
    private RedisUtil redisUtil;


    /**
     * 根据歌曲id返回歌曲信息
     * @param musicId 歌曲id
     * @return 歌曲信息
     */
    @Override
    public MusicInfoVo getMusicInfo(String musicId) {
//        if (redisUtil.get("musicList::"+id)==null){
//            Music music = musicMapper.selectByPrimaryKey(id);
//            if (music==null){
//                return null;
//            }else{
//                MusicInfo musicInfo = new MusicInfo();
//                musicInfo.setId(music.getId());
//                musicInfo.setName(music.getName());
//                musicInfo.setSinger(music.getSinger());
//                musicInfo.setAlbum(music.getAlbum());
//                musicInfo.setLength(music.getLength());
//                musicInfo.setUrl(CdnConsts.CDN_PATH + CdnConsts.PROJECT_PATH + TypePath.MUSIC_FILE+ "/" +music.getId()+".mp3");
//                redisUtil.set("musicInfo::"+id, musicInfo,60);
//                return musicInfo;
//            }
//        }else {
//            return (MusicInfo)redisUtil.get("musicList::"+id);
//        }

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

    @Override
    public List<MusicInfo> getSearchList(String keyword) {
        MusicExample musicExample = new MusicExample();
        musicExample.createCriteria().andNameLike("%"+keyword+"%");
        List<Music> musics = musicMapper.selectByExample(musicExample);
        List<MusicInfo> musicInfos = new ArrayList<>();
        for (Music music : musics) {
            MusicInfo musicInfo = new MusicInfo();
            musicInfo.setId(music.getId());
            musicInfo.setName(music.getName());
            musicInfo.setSinger(music.getSinger());
            musicInfo.setAlbum(music.getAlbum());
            musicInfo.setLength(music.getLength());
            musicInfo.setUrl(CdnConsts.CDN_PATH + CdnConsts.PROJECT_PATH + TypePath.MUSIC_FILE + music.getId()+".mp3");
            musicInfos.add(musicInfo);
        }

        return musicInfos;
    }

    @Override
    public List<MusicInfo> getSearchUserList(String userID, String keyword) {
        List<Music> musics = musicMapper.searchUserMusic(userID,'%'+keyword+'%');
        List<MusicInfo> musicInfos = new ArrayList<>();
        for (Music music : musics) {
            MusicInfo musicInfo = new MusicInfo();
            musicInfo.setId(music.getId());
            musicInfo.setName(music.getName());
            musicInfo.setSinger(music.getSinger());
            musicInfo.setAlbum(music.getAlbum());
            musicInfo.setLength(music.getLength());
            musicInfo.setUrl(CdnConsts.CDN_PATH + CdnConsts.PROJECT_PATH + TypePath.MUSIC_FILE+music.getId()+".mp3");
            //musicID不为null时，为收藏的歌曲，collection值为1
            if (music.getMusicID() != null) {
                musicInfo.setCollection(1);
            }
            musicInfos.add(musicInfo);
        }
        return musicInfos;
    }
}
