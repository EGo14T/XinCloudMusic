package com.ego14t.xinmusicfeign.controller;

import com.ego14t.xinmusicfeign.pojo.MusiclistUser;
import com.ego14t.xinmusicfeign.service.MusicListService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create By EGo1ST
 * Date ：Created in 2019/8/10 19:13
 * Description：
 */
@RestController
@RequestMapping(value = "/resource")
public class MusicListController {
    @Resource
    private MusicListService musicListService;

    /**
     * 根据歌单ID获取歌单列表
    * @param id 歌单ID
     * @return 歌单列表
     */
    @GetMapping(value = "/musiclist/{musicListID}")
    public List<Object> getMusiclist(@PathVariable(value="musicListID") Integer id ){
        return musicListService.getMusicList(id);
    }

    @PostMapping(value = "/musiclist")
    public List<Object> addMuscilist(@RequestBody MusiclistUser musiclistUser){
        return musicListService.addMusicList(musiclistUser);
    }
}
