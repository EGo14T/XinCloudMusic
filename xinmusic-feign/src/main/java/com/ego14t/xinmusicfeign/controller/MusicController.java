package com.ego14t.xinmusicfeign.controller;

import com.ego14t.xinmusicfeign.pojo.MusicList;
import com.ego14t.xinmusicfeign.pojo.ResponseJsonResult;
import com.ego14t.xinmusicfeign.service.MusicService;
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
@RequestMapping(value = "/resource")
public class MusicController {
    @Resource
    private MusicService musicService;

    @GetMapping(value = "/song/{musicID}")
    @ResponseBody
    public ResponseEntity<?> getMusicList(@PathVariable(name="musicID") Integer musicID ){
        if (musicService.getMusic(musicID)==null){
            return new ResponseEntity<>("资源不存在",HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(musicService.getMusic(musicID), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/song/{musicListID}/{musicID}")
    @ResponseBody
    public ResponseEntity<?> addMusicToList(@PathVariable(name="musicID") Integer musicID,
                                            @PathVariable(name = "musicListID" )Integer musicListID){

        String result = musicService.addMusicToList(musicID,musicListID);

        if ("200".equals(result)){
            return ResponseJsonResult.OK(null,"添加歌曲成功！");
        }else{
            return ResponseJsonResult.OK(null,result);
        }
    }
}
