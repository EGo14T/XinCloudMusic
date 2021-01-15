package com.ego14t.feign.service;

import com.ego14t.feign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2020/12/30 11:54
 * Description:
 */
@FeignClient(value = "XinMusic-Music",configuration = FeignConfig.class)
public interface MusicService {

    @GetMapping("/music/song/{musicId}")
    ResponseEntity<?> getMusicInfo(@PathVariable("musicId") String musicId);

    @PostMapping("/music/song/{musiclistId}/{musicId}")
    ResponseEntity<?> addMusicToList(@PathVariable("musiclistId") String musiclistId, @PathVariable("musicId") String musicId);

    @DeleteMapping("/music/song/{musiclistId}/{musicId}")
    ResponseEntity<?> delMusicFromList(@PathVariable("musiclistId") String musiclistId, @PathVariable("musicId") String musicId);

    @GetMapping("/music/song/search")
    ResponseEntity<?> getSearchUserList(@RequestParam("keyword") String keyword);

    @PostMapping("/music/song/likeMusic/{musicId}")
    ResponseEntity<?> likeMusic(String musicId);

    @DeleteMapping("/music/song/dislikeMusic/{musicId}")
    ResponseEntity<?> dislikeMusic(String musicId);
}
