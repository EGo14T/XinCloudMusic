package com.ego14t.xinmusicfeign.service;

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
@FeignClient(value = "music-list-service")
public interface MusicListService {
    /**
     * 根据歌单ID查询歌单
     * @param id 歌单ID
     * @return 歌单信息
     */
    @GetMapping(value = "/my/music/musiclist/{userID}")
    List<Object> getMusicList(@PathVariable(value="userID") Integer id);

    @PostMapping(value = "my/music/musiclist")
    List<Object> addMusicList(@RequestBody MusiclistUser musiclistUser);

}
