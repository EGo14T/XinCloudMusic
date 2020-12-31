package com.ego14t.feign.controller;

import com.ego14t.common.controller.AbstractController;
import com.ego14t.feign.service.MusicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 王富昕
 * Create By EGo1ST
 * Date ：Created in 2019/9/29 11:36
 * Description：
 */
@RestController
@RequestMapping("/music")
public class MusicController extends AbstractController {

    @Resource
    private MusicService musicService;

    /**
     * 检索歌曲，适用于用户点击单曲显示的信息
     * @param musicId 歌单ID
     * @return 歌单list
     */
    @GetMapping("/song/{musicId}")
    public ResponseEntity<?> getMusicInfo(@PathVariable(name="musicId") String musicId){
        return musicService.getMusicInfo(musicId);
    }

    /**
     * 歌曲添加到歌单中
     * @param musiclistId  歌单ID
     * @param musicId  歌曲ID
     * @return 状态码
     */
    @PostMapping("/song/{musiclistId}/{musicId}")
    public ResponseEntity<?> addMusicToList(@PathVariable(name = "musiclistId" )String musiclistId,
                                       @PathVariable(name="musicId") String musicId){
        return musicService.addMusicToList(musiclistId, musicId);

    }

    /**
     * 把歌曲从歌单删除
     * @param musiclistId 歌单ID
     * @param musicId 歌曲ID
     * @return 删除信息
     */
    @DeleteMapping("/song/{musiclistId}/{musicId}")
    public ResponseEntity<?> delMusic(@PathVariable(name = "musiclistId" )String musiclistId,
                                 @PathVariable(name="musicId") String musicId){
        return musicService.delMusicFromList(musiclistId,musicId);
    }

    /**
     * 歌曲查询功能(登录&&未登录)
     * @return
     */
    @GetMapping("/song/search")
    public ResponseEntity<?> getSearchList(@RequestParam("keyword")String keyword){
        return musicService.getSearchUserList(keyword);
    }
}
