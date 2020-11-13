package com.ego14t.xinmusicfeign.service;

import com.ego14t.xinmusicfeign.config.FeignConfig;
import com.ego14t.xinmusicfeign.pojo.MusicList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2019/12/27 10:16
 * Description:
 */

@FeignClient(value = "xinmusic-music",configuration = FeignConfig.class)
@RequestMapping("/music")
public interface MusicService {
    //获取歌曲信息
    @GetMapping(value = "/song/{musicID}")
    MusicList getMusicInfo(@PathVariable(value="musicID") String id);

    //添加歌曲到歌单
    @PostMapping(value = "/song/{musicID}/{musicListID}")
    String addMusicToList(@PathVariable(name="musicID") String musicID,
                          @PathVariable(name = "musicListID" )String musicListID);

    //从歌单中删除歌曲
    @DeleteMapping(value = "/song/{musicID}/{musicListID}")
    String delMusicFromList(@PathVariable(name="musicID") String musicID,
                          @PathVariable(name = "musicListID" )String musicListID);

    //搜索歌曲
    @GetMapping(value = "/song/search")
    List<Object> getSearchList(@RequestParam(value = "keyword")String keyword);

}
