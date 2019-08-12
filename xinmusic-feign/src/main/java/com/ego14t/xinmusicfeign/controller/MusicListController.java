package com.ego14t.xinmusicfeign.controller;

import com.ego14t.xinmusicfeign.service.MusicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "musiclist",method = RequestMethod.GET)
    public List<Object> musiclist(@RequestParam(value="id") Integer id ){
        return musicListService.musicList(id);
    }


}
