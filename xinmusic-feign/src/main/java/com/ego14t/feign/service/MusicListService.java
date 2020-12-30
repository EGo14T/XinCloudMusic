package com.ego14t.feign.service;

import com.ego14t.feign.config.FeignConfig;
import com.ego14t.feign.vo.MusicListVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2020/12/30 14:00
 * Description:
 */
@FeignClient(value = "xinmusic-music",configuration = FeignConfig.class)
public interface MusicListService {

    @GetMapping("/musiclist/created/{userId}")
    ResponseEntity<?> getCreateMusicListInfo(@PathVariable("userId") String userId);

    @GetMapping("/musiclist/collected/{userId}")
    ResponseEntity<?> getCollectMusicListInfo(@PathVariable("userId") String userId);

    @GetMapping("/musiclist/discover")
    ResponseEntity<?> getDiscoverMusicListInfo();

    @PostMapping("/musiclist/collect/{musicListId}")
    ResponseEntity<?> collectMusicList(@PathVariable("musicListId")String musicListId);

    @GetMapping("/musiclist/{musicListId}")
    ResponseEntity<?> getUserMusicList(@PathVariable("musicListId")String musicListId);

    @GetMapping("/musiclist/getinfo/{musicListId}")
    ResponseEntity<?> getMusicListInfo(@PathVariable("musicListId")String musicListId);

    @PostMapping("/musiclist/created")
    ResponseEntity<?> createMusicList(@RequestBody MusicListVo musicListVo);

    @DeleteMapping("/musiclist/{musiclistId}")
    ResponseEntity<?> delMusicList(@PathVariable("musiclistId")String musiclistId);

    @PatchMapping("/musiclist/update")
    ResponseEntity<?> updateMusicList(@RequestBody MusicListVo musicListVo);
}