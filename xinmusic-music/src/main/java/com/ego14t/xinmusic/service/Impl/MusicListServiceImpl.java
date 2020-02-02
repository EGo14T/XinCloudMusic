package com.ego14t.xinmusic.service.Impl;

import com.ego14t.xinmusic.entity.MusicList;
import com.ego14t.xinmusic.entity.MusicListInfo;
import com.ego14t.xinmusic.entity.ResponseJsonResult;
import com.ego14t.xinmusic.mapper.MusicMapper;
import com.ego14t.xinmusic.mapper.MusiclistMusicMapper;
import com.ego14t.xinmusic.mapper.MusiclistUserMapper;

import com.ego14t.xinmusic.pojo.Music;
import com.ego14t.xinmusic.pojo.MusiclistMusic;
import com.ego14t.xinmusic.pojo.MusiclistUser;
import com.ego14t.xinmusic.pojo.example.MusiclistMusicExample;
import com.ego14t.xinmusic.pojo.example.MusiclistUserExample;
import com.ego14t.xinmusic.service.MusicListService;
import com.ego14t.xinmusic.util.BeanCopyUtils;
import com.ego14t.xinmusic.util.TimeUtils;

import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
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


    /**
     *
     * @param musicListID 歌单ID
     * @param userId  用户ID
     * @return MusicList
     * 自定义sql语句进行联表查询
     * Description：查询歌单
     */
    @Override
    public List<MusicList> getMusicList(Integer musicListID,Integer userId) {
        List<Music> musics = musicMapper.searchNumList(musicListID,userId);
        List<MusicList> musicLists = new ArrayList<>();
        for (Music music : musics) {
            MusicList musicList = MusicList.builder()
                    .id(music.getId())
                    .name(music.getName())
                    .artist(music.getSinger())
                    .album(music.getAlbum())
                    .length(music.getLength())
                    .img(music.getImgurl())
                    .lrc(music.getLrcurl())
                    .url("http://source.ego1st.cn/song/id="+music.getId()+".mp3")
                    .build();
            //musicID不为null时，为收藏的歌曲，collection值为1
            if (music.getMusicID() != null) {
                musicList.setCollection(1);
            }
            musicLists.add(musicList);
        }
        return musicLists;
    }

    @Override
    public List<MusicListInfo> getMusicListInfo(Integer userId) {
        MusiclistUserExample musiclistUserExample = new MusiclistUserExample();
        musiclistUserExample.createCriteria().andUseridEqualTo(userId);
        List<MusiclistUser> musiclistUsers = musiclistUserMapper.selectByExample(musiclistUserExample);

        List<MusicListInfo> musicListInfos = new ArrayList<>();

        for (MusiclistUser musiclistUser : musiclistUsers) {
            MusicListInfo musicListInfo = new MusicListInfo();
            //BeanUtils.copyProperties(musiclistUser,musicListInfo);
            BeanCopyUtils.copy(musiclistUser,musicListInfo);
            if (musiclistUser.getStatus()==0){
                musicListInfos.add(0,musicListInfo);
            }else{
                musicListInfos.add(musicListInfo);
            }
        }

        return musicListInfos;
    }

    /**
     *
     * @param id
     * @return ResponseJsonResult
     * Description：删除歌单
     */
    @Override
    public String delMusicList(Integer id) {

        MusiclistUser musiclistUser = musiclistUserMapper.selectByPrimaryKey(id);
        

        MusiclistMusicExample musiclistMusicExample = new MusiclistMusicExample();
        musiclistMusicExample.createCriteria().andMusiclistidEqualTo(id);

        List<MusiclistMusic> musiclistMusics = musiclistMusicMapper.selectByExample(musiclistMusicExample);
        //System.out.println(musiclistMusics.get(0).getMusicid());

        if (musiclistUser==null){
            return "404";
        }else{
            if (musiclistUser.getStatus()==0){
                return "401";
            }else if(musiclistMusics.size() == 0){
                musiclistUserMapper.deleteByPrimaryKey(id);
                return "204";

            }else {
                musicMapper.delMusicListById(id);
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
    public int addMusicList(MusiclistUser musiclistUser) {
        musiclistUser.setCreateTime(LocalDate.now());
        musiclistUser.setMusiclistImg("ego");
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
        public int updateMusicList(Integer id, MusiclistUser musiclistUser) {
            //创建查询条件
            MusiclistUserExample musiclistUserExample = new MusiclistUserExample();
            musiclistUserExample.createCriteria().andMusiclistidEqualTo(id);

            //根据Id修改歌单信息
            musiclistUserMapper.updateByExampleSelective(musiclistUser,musiclistUserExample);
            return id;
    }
}
