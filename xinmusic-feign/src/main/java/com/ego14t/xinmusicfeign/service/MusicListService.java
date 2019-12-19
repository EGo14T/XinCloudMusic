package com.ego14t.xinmusicfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Create By EGo1ST
 * Date ：Created in 2019/8/10 19:09
 * Description：
 *
 * 这里的getmapping指的是
 */
@FeignClient(value = "music-list-service")
public interface MusicListService {
    @GetMapping(value = "/my/music/musiclist/{userID}")
    //调用xinmusic项目的接口
    List<Object> musicList(@PathVariable(value="userID") Integer id);

}
