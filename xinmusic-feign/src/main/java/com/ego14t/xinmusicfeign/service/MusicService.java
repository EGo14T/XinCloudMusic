package com.ego14t.xinmusicfeign.service;

import com.ego14t.xinmusicfeign.pojo.MusicList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2019/12/27 10:16
 * Description:
 */

@FeignClient(value = "music-list-service")
public interface MusicService {
    @GetMapping(value = "/music/song/{musicID}")
    MusicList getMusic(@PathVariable(value="musicID") Integer id);
}
