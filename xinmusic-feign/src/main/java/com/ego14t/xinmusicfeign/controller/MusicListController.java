package com.ego14t.xinmusicfeign.controller;

import com.ego14t.xinmusicfeign.pojo.MusiclistUser;
import com.ego14t.xinmusicfeign.pojo.ResponseJsonResult;
import com.ego14t.xinmusicfeign.service.MusicListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getMusiclist(@PathVariable(value="musicListID") Integer id){
        return new ResponseEntity<>(musicListService.getMusicList(id), HttpStatus.OK);
    }


    /**
     * 根据歌单ID 和 用户ID 查询带状态的歌单详细信息
     * @param userId 用户ID
     * @param musicListID 歌单ID
     * @return  歌单的详细信息
     */
    @GetMapping(value = "/musiclist/{userID}/{musicListID}")
    public List<Object> getMusicList(@PathVariable(value="userID") Integer userId,
                                     @PathVariable(name="musicListID") Integer musicListID){

        return musicListService.getMusicList(userId,musicListID);
    }


    /**
     * 添加歌单
     * @param musiclistUser 歌单信息实体
     * @return 新建的歌单的主键ID
     */
    @PostMapping(value = "/musiclist")
    public ResponseEntity<?> addMuscilist(@RequestBody MusiclistUser musiclistUser){
        return new ResponseEntity<>(musicListService.addMusicList(musiclistUser),HttpStatus.CREATED);
    }

    /**
     * 删除歌单
     * @param id 歌单ID
     * @return 无 状态码
     */
    @DeleteMapping(value = "/musiclist/{musicListID}")
    public ResponseEntity<?> deleteMusicList(@PathVariable(value="musicListID") Integer id){
        ResponseJsonResult result = musicListService.delMusicList(id);
        int status = result.getStatus();
        if (status == 404){
            return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
        }else if (status == 405){
            return new ResponseEntity<>(result,HttpStatus.METHOD_NOT_ALLOWED);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    /**
     *
     * @param musicListID 歌单ID
     * @param musiclistUser 歌单信息实体
     * @return  修改的歌单ID
     */
    @PatchMapping(value = "/musiclist/{musicListID}")
    public ResponseEntity<?> updateMusicList(@PathVariable(value = "musicListID")Integer musicListID
                                            ,@RequestBody MusiclistUser musiclistUser)
    {
        return new ResponseEntity<>(musicListService.updateMusicList(musicListID,musiclistUser),HttpStatus.OK);
    }
}
