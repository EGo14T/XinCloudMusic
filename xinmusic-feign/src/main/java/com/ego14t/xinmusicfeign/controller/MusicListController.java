package com.ego14t.xinmusicfeign.controller;

import com.ego14t.xinmusicfeign.pojo.MusiclistUser;
import com.ego14t.xinmusicfeign.pojo.ResponseJsonResult;
import com.ego14t.xinmusicfeign.service.MusicListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @GetMapping(value = "/create/musiclist/{musicListID}")
    public ResponseEntity<?> getCreateMusicList(@PathVariable(value="musicListID") String id){
        return ResponseJsonResult.OK(musicListService.getCreateMusicList(id),"获取创建歌单成功");
    }

    /**
     * 根据歌单ID获取歌单列表
     * @param id 歌单ID
     * @return 歌单列表
     */
    @GetMapping(value = "/collect/musiclist/{musicListID}")
    public ResponseEntity<?> getCollectMusicList(@PathVariable(value="musicListID") String id){
        return ResponseJsonResult.OK(musicListService.getCollectMusicList(id),"获取收藏歌单成功");
    }


    /**
     * 根据歌单ID 和 用户ID 查询带状态的歌单详细信息
     * @param userId 用户ID
     * @param musicListID 歌单ID
     * @return  歌单的详细信息
     */
    @GetMapping(value = "/musiclist/{userID}/{musicListID}")
    public ResponseEntity<?> getMusicList(@PathVariable(value="userID") String userId,
                                     @PathVariable(name="musicListID") String musicListID){
        return ResponseJsonResult.OK(musicListService.getMusicList(userId,musicListID),"获取成功");
    }

    @GetMapping(value = "/musiclistinfo/{musicListID}")
    public ResponseEntity<?>getMusicListInfo(@PathVariable(value = "musicListID")String musiclistID){

        return ResponseJsonResult.OK(musicListService.getMusicListInfo(musiclistID),"获取成功");
    }


    /**
     * 添加歌单
     * @param musiclistUser 歌单信息实体
     * @return 新建的歌单的主键ID
     */
    @PostMapping(value = "/musiclist")
    public ResponseEntity<?> addMuscilist(@RequestBody MusiclistUser musiclistUser){
        return ResponseJsonResult.CREATED(musicListService.addMusicList(musiclistUser),"创建歌单成功");
    }

    /**
     * 删除歌单
     * @param userID 用户ID
     * @param musicListID  歌单ID
     * @return 无 状态码
     */
    @DeleteMapping(value = "/musiclist/{userID}/{musicListID}")
    public ResponseEntity<?> deleteMusicList(@PathVariable(value="userID")String userID,
                                             @PathVariable(value="musicListID") String musicListID){
        String result = musicListService.delMusicList(userID,musicListID);
        if ("404".equals(result)){
            return ResponseJsonResult.NOT_FOUND(null,"资源未找到！");
        }
        if ("401".equals(result)){
            return ResponseJsonResult.METHOD_NOT_ALLOWED(null,"没有权限！");
        }
        if ("204".equals(result)){
            return ResponseJsonResult.NO_CONTENT(null,null);
        }
        return null;
    }

    /**
     *
     * @param musicListID 歌单ID
     * @param musiclistUser 歌单信息实体
     * @return  修改的歌单ID
     */
    @PatchMapping(value = "/musiclist/{musicListID}")
    public ResponseEntity<?> updateMusicList(@PathVariable(value = "musicListID")String musicListID
                                            ,@RequestBody MusiclistUser musiclistUser)
    {
        return ResponseJsonResult.OK(musicListService.updateMusicList(musicListID,musiclistUser),"修改成功");
    }
}
