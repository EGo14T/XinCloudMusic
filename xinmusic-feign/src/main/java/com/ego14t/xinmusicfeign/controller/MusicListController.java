package com.ego14t.xinmusicfeign.controller;

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
@RequestMapping(value = "/my/music")
public class MusicListController {
    @Resource
    private MusicListService musicListService;

    @GetMapping(value = "/musiclist")
    public List<Object> musiclist(@RequestParam(value="id") Integer id ){
        return musicListService.musicList(id);
    }


}
