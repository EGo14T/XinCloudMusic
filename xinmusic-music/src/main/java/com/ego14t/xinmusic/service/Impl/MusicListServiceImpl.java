package com.ego14t.xinmusic.service.Impl;

import com.ego14t.xinmusic.entity.MusicList;
import com.ego14t.xinmusic.entity.MusicListInfo;
import com.ego14t.xinmusic.entity.UserMusicListInfo;
import com.ego14t.xinmusic.mapper.MusicMapper;
import com.ego14t.xinmusic.mapper.MusiclistCollectMapper;
import com.ego14t.xinmusic.mapper.MusiclistMusicMapper;
import com.ego14t.xinmusic.mapper.MusiclistUserMapper;

import com.ego14t.xinmusic.pojo.*;
import com.ego14t.xinmusic.pojo.example.MusiclistMusicExample;
import com.ego14t.xinmusic.pojo.example.MusiclistUserExample;
import com.ego14t.xinmusic.service.MusicListService;
import com.ego14t.xinmusic.util.BeanCopyUtils;

import com.ego14t.xinmusic.util.IDworker;
import org.springframework.beans.BeanUtils;
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
    private MusiclistUserMapper musiclistUserMapper;
    
    @Resource
    private MusiclistMusicMapper musiclistMusicMapper;

    @Resource
    private MusiclistCollectMapper musiclistCollectMapper;


    /**
     *
     * @param musicListID 歌单ID
     * @param userId  用户ID
     * @return MusicList
     * 自定义sql语句进行联表查询
     * Description：查询歌单 中的 所有歌曲
     */
    @Override
    public List<MusicList> getUserMusicList(String musicListID,String userId) {
        List<Music> musics = musicMapper.searchUserNumList(musicListID,userId);
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

    /**
     *
     * @param musicListID 歌单ID
     * @return MusicList
     * 自定义sql语句进行联表查询
     * Description：查询歌单 中的 所有歌曲
     */
    @Override
    public List<MusicList> getMusicList(String musicListID) {
        List<Music> musics = musicMapper.searchNumList(musicListID);
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
    public List<UserMusicListInfo> getCreateMusicListInfo(String userId) {
        MusiclistUserExample musiclistUserExample = new MusiclistUserExample();
        musiclistUserExample.createCriteria().andUseridEqualTo(userId);
        musiclistUserExample.setOrderByClause("create_time");
        List<MusiclistUser> musiclistUsers = musiclistUserMapper.selectByExample(musiclistUserExample);

        List<UserMusicListInfo> musicListInfos = new ArrayList<>();

        for (MusiclistUser musiclistUser : musiclistUsers) {
            UserMusicListInfo musicListInfo = new UserMusicListInfo();
            BeanUtils.copyProperties(musiclistUser,musicListInfo);
            BeanCopyUtils.copy(musiclistUser,musicListInfo);
            if (musiclistUser.getStatus()==0){
                musicListInfos.add(0,musicListInfo);
            }else{
                musicListInfos.add(musicListInfo);
            }
        }

        return musicListInfos;
    }

    @Override
    public List<UserMusicListInfo> getCollectMusicListInfo(String userId) {

        return musiclistUserMapper.getCreateMusicListInfo(userId);
    }

    @Override
    public List<UserMusicListInfo> getDiscoverMusicListInfo() {
        return musiclistUserMapper.getDiscoverMusicListInfo();
    }

    @Override
    public Integer collectMusicList(String userId, String musicListID) {

        MusiclistCollect musiclistCollect = new MusiclistCollect();
        musiclistCollect.setCollectingtime(LocalDateTime.now());
        musiclistCollect.setUserid(userId);
        musiclistCollect.setMusiclistid(musicListID);

        return musiclistCollectMapper.insertSelective(musiclistCollect);

    }


    @Override
    public MusicListInfo getMusicListInfo(String musicListID) {
        return musiclistUserMapper.searchMusicListInfo(musicListID);
    }

    /**
     * @param userID 用户ID
     * @param musicListID 歌单ID
     * @return ResponseJsonResult
     * Description：删除歌单
     */
    @Override
    public String delMusicList(String userID,String musicListID) {

        MusiclistUser musiclistUser = musiclistUserMapper.selectByPrimaryKey(new MusiclistUserKey(userID,musicListID));

        MusiclistMusicExample musiclistMusicExample = new MusiclistMusicExample();
        musiclistMusicExample.createCriteria().andMusiclistidEqualTo(musicListID);

        List<MusiclistMusicKey> musiclistMusics = musiclistMusicMapper.selectByExample(musiclistMusicExample);
        //System.out.println(musiclistMusics.get(0).getMusicid());

        if (musiclistUser==null){
            MusiclistCollect musiclistCollect = new MusiclistCollect();
            musiclistCollect.setUserid(userID);
            musiclistCollect.setMusiclistid(musicListID);
            musiclistCollectMapper.deleteByPrimaryKey(musiclistCollect);
            return "204";
        }else{
            if (musiclistUser.getStatus()==0){
                return "401";
            }else if(musiclistMusics.size() == 0){
                musiclistUserMapper.deleteByPrimaryKey(new MusiclistUserKey(userID,musicListID));
                return "204";

            }else {
                musicMapper.delMusicListById(musicListID);
                return "204";
            }
        }

    }

    /**
     *
     * @param musiclistUser 歌单其他信息
     * @return 状态码和信息  返回主键id
     * Description：添加歌单
     */
    @Override
    public String addMusicList(MusiclistUser musiclistUser) {
        musiclistUser.setCreateTime(LocalDateTime.now());
        musiclistUser.setMusiclistImg("http://cdn.ego1st.cn/xinmusic/musiclistIMG/default.jpg");
        musiclistUser.setMusiclistid(new IDworker(0,0).nextId());
        musiclistUserMapper.insertSelective(musiclistUser);
        return musiclistUser.getMusiclistid();
    }

        /**
         *
         * @param id 歌单ID
         * @param musiclistUser 修改的实体
         * @return 歌单ID
         */
        @Override
        public String updateMusicList(String id, MusiclistUser musiclistUser) {
            //创建查询条件
            MusiclistUserExample musiclistUserExample = new MusiclistUserExample();
            musiclistUserExample.createCriteria().andMusiclistidEqualTo(id);
            //根据Id修改歌单信息
            musiclistUserMapper.updateByExampleSelective(musiclistUser,musiclistUserExample);
            return id;
    }



}
