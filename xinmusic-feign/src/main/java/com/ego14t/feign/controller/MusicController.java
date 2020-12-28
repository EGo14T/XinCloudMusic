package com.ego14t.feign.controller;

import com.ego14t.feign.pojo.MusicList;
import com.ego14t.feign.pojo.ResponseJsonResult;
import com.ego14t.feign.service.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2019/12/27 10:15
 * Description:
 */

@RestController
@RequestMapping(value = "/music")
public class MusicController {
    @Resource
    private MusicService musicService;

    @GetMapping(value = "/song/{musicID}")
    @ResponseBody
    public ResponseEntity<?> getMusicInfo(@PathVariable(name="musicID") String musicID ){
        MusicList music = musicService.getMusicInfo(musicID);
        if (music == null){
            return new ResponseEntity<>("资源不存在",HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(music, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/song/{musicListID}/{musicID}")
    @ResponseBody
    public ResponseEntity<?> addMusicToList(@PathVariable(name = "musicListID" )String musicListID,
                                            @PathVariable(name="musicID") String musicID){

        String result = musicService.addMusicToList(musicID,musicListID);

        if ("200".equals(result)){
            return ResponseJsonResult.OK(null,"添加歌曲成功！");
        }else{
            return ResponseJsonResult.OK(null,result);
        }
    }

    @DeleteMapping(value = "/song/{musicListID}/{musicID}")
    @ResponseBody
    public ResponseEntity<?> delMusicFromList(@PathVariable(name = "musicListID" )String musicListID,
                                              @PathVariable(name="musicID") String musicID){

        String result = musicService.delMusicFromList(musicID,musicListID);

        if ("204".equals(result)){
            return ResponseJsonResult.NO_CONTENT(null,null);
        }else{
            return ResponseJsonResult.OK(null,result);
        }
    }

    /**
     * 歌曲查询功能(登录&&未登录)
     * @return
     */
    @GetMapping(value = "/musiclist")
    @ResponseBody
    public ResponseEntity<?> getSearchList(@RequestParam(value = "keyword")String keyword){

        return ResponseJsonResult.OK(musicService.getSearchList(keyword),"获取成功");
    }
}
