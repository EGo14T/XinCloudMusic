package com.ego14t.xinmusicfeign.service;

import com.ego14t.xinmusicfeign.pojo.MusiclistUser;
import com.ego14t.xinmusicfeign.pojo.ResponseJsonResult;
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
@FeignClient(value = "music-list-service")
public interface MusicListService {
    /**
     * 根据歌单ID查询歌单
     * @param id 歌单ID
     * @return 歌单信息
     */
    @GetMapping(value = "/my/music/musiclist/{userID}")
    List<Object> getMusicList(@PathVariable(value="userID") Integer id);

    @GetMapping(value = "/my/music/musiclist/{userID}/{musicListID}")
    List<Object> getMusicList(@PathVariable(value="userID") Integer userId,
                              @PathVariable(name="musicListID") Integer musicListID);

    @PostMapping(value = "my/music/musiclist")
    int addMusicList(@RequestBody MusiclistUser musiclistUser);

    @DeleteMapping(value = ("/my/music/musiclist/{musicListID}"))
    ResponseJsonResult delMusicList(@PathVariable(value = "musicListID") Integer id);

    @PatchMapping(value = "/my/music/musiclist/{musicListID}")
    int updateMusicList(@PathVariable(value = "musicListID")Integer musicListID
            ,@RequestBody MusiclistUser musiclistUser);
}
