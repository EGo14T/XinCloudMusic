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

    @PostMapping("/musiclist/collect/{musiclistId}")
    ResponseEntity<?> collectMusicList(@PathVariable("musiclistId")String musiclistId);

    @GetMapping("/musiclist/{musiclistId}")
    ResponseEntity<?> getUserMusicList(@PathVariable("musiclistId")String musiclistId);

    @GetMapping("/musiclist/getinfo/{musiclistId}")
    ResponseEntity<?> getMusicListInfo(@PathVariable("musiclistId")String musiclistId);

    @PostMapping("/musiclist/created")
    ResponseEntity<?> createMusicList(@RequestBody MusicListVo musiclistVo);

    @DeleteMapping("/musiclist/{musiclistId}")
    ResponseEntity<?> delMusicList(@PathVariable("musiclistId")String musiclistId);

    @PatchMapping("/musiclist/update")
    ResponseEntity<?> updateMusicList(@RequestBody MusicListVo musiclistVo);
}
