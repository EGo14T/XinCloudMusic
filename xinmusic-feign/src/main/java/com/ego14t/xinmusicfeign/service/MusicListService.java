package com.ego14t.xinmusicfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Create By EGo1ST
 * Date ：Created in 2019/8/10 19:09
 * Description：
 */
@FeignClient(value = "music-list-service")
public interface MusicListService {
    @GetMapping(value = "/my/music/musiclist")
    //调用xinmusic项目的接口
    List<Object> musicList(@RequestParam(value = "id") Integer id);

}
