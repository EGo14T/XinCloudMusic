package com.ego14t.xinmusicfeign.service;

import com.ego14t.xinmusicfeign.config.FeignConfig;
import com.ego14t.xinmusicfeign.pojo.MusiclistUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Create By EGo1ST
 * Date ：Created in 2019/8/10 19:09
 * Description：
 *
 * 调用xinmusic项目的接口
 */
@FeignClient(value = "xinmusic-music",configuration = FeignConfig.class)
public interface MusicListService {
    /**
     * 根据歌单ID查询歌单 创建&默认
     * @param id 歌单ID
     * @return 歌单信息
     */
    @GetMapping(value = "/my/music/create/musiclist/{userID}")
    List<Object> getCreateMusicList(@PathVariable(value="userID") String id);

    /**
     * 根据歌单ID查询歌单 收藏
     * @param id 歌单ID
     * @return 歌单信息
     */
    @GetMapping(value = "/my/music/collect/musiclist/{userID}")
    List<Object> getCollectMusicList(@PathVariable(value="userID") String id);

    @GetMapping(value = "/my/music/discover/musiclist")
    List<Object> getDiscoverMusicList();

    @PostMapping(value = "/my/music/collect/musiclist/{userID}/{musicListID}")
    int collectMusicList(@PathVariable(name="musicListID") String musicListID);

    @GetMapping(value = "/my/music/musiclist/{musicListID}")
    List<Object> getUserMusicList(@PathVariable(name="musicListID") String musicListID);

    @GetMapping(value = "/my/music/musiclist/{musicListID}")
    List<Object> getMusicList(@PathVariable(name="musicListID") String musicListID);

    @GetMapping(value = "/my/music/musiclistinfo/{userID}/{musicListID}")
    Object getMusicListInfo(@PathVariable(value = "userID")String userID,
                            @PathVariable(value = "musicListID") String musicListID);


    @PostMapping(value = "my/music/musiclist")
    String addMusicList(@RequestBody MusiclistUser musiclistUser);

    @DeleteMapping(value = ("/my/music/musiclist/{userID}/{musicListID}"))
    String delMusicList(@PathVariable(value="musicListID") String musicListID);

    @PatchMapping(value = "/my/music/musiclist/{musicListID}")
    String updateMusicList(@PathVariable(value = "musicListID")String musicListID
            ,@RequestBody MusiclistUser musiclistUser);

}
