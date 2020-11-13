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
@RequestMapping(value = "/music")
public class MusicListController {
    @Resource
    private MusicListService musicListService;

    /**
     * 检索用户的歌单列表(创建&默认)
     * @param userID
     * @return
     */
    @GetMapping(value = "/musiclist/created/{userID}")
    public ResponseEntity<?> getCreateMusicList(@PathVariable(value="userID") String userID){
        return ResponseJsonResult.OK(musicListService.getCreateMusicList(userID),"获取创建歌单成功");
    }

    /**
     * 根据歌单ID获取歌单列表
     * @param userId 用户ID
     * @return 歌单列表
     */
    @GetMapping(value = "/musiclist/collected/{userID}")
    public ResponseEntity<?> getCollectMusicList(@PathVariable(value="userID") String userId){
        return ResponseJsonResult.OK(musicListService.getCollectMusicList(userId),"获取收藏歌单成功");
    }

    /**
     * 获取推荐歌单
     * @return 歌单列表
     */
    @GetMapping(value = "/musiclist/discover")
    public ResponseEntity<?> getDiscoverMusicList(){
        return ResponseJsonResult.OK(musicListService.getDiscoverMusicList(),"获取推荐歌单成功");
    }

    /**
     * 收藏歌单操作
     * @param musicListID
     * @return
     */
    @PostMapping(value = "/musiclist/collect/{musicListID}")
    public ResponseEntity<?> collectMusicList(@PathVariable(name="musicListID") String musicListID){
        return ResponseJsonResult.OK(musicListService.collectMusicList(musicListID),"收藏歌单成功");
    }

    /**
     * 根据歌单ID查询带状态的歌单歌曲列表
     * @param musicListID 歌单ID
     * @return  歌单的详细信息
     */
    @GetMapping(value = "/musiclist/{musicListID}")
    public ResponseEntity<?> getUserMusicList(@PathVariable(name="musicListID") String musicListID){
        return ResponseJsonResult.OK(musicListService.getUserMusicList(musicListID),"获取成功");
    }

    /**
     * 根据歌单id返回歌单详细信息
     * @param userID
     * @param musicListID
     * @return
     */
    @GetMapping(value = "/musiclist/getinfo/{userID}/{musicListID}")
    public ResponseEntity<?>getMusicListInfo(@PathVariable(value = "userID")String userID,
                                             @PathVariable(value = "musicListID")String musicListID){
        return ResponseJsonResult.OK(musicListService.getMusicListInfo(userID,musicListID),"获取成功");
    }


    /**
     * 新建歌单
     * @param musiclistUser 歌单信息实体
     * @return 新建的歌单的主键ID
     */
    @PostMapping(value = "/musiclist")
    public ResponseEntity<?> addMuscilist(@RequestBody MusiclistUser musiclistUser){
        return ResponseJsonResult.CREATED(musicListService.addMusicList(musiclistUser),"创建歌单成功");
    }

    /**
     * 删除歌单
     * @param musicListID  歌单ID
     * @return 无 状态码
     */
    @DeleteMapping(value = "/musiclist/{musicListID}")
    public ResponseEntity<?> deleteMusicList(@PathVariable(value="musicListID") String musicListID){
        String result = musicListService.delMusicList(musicListID);
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
    @PatchMapping(value = "/musiclist/update/{musicListID}")
    public ResponseEntity<?> updateMusicList(@PathVariable(value = "musicListID")String musicListID,
                                             @RequestBody MusiclistUser musiclistUser) {
        return ResponseJsonResult.OK(musicListService.updateMusicList(musicListID,musiclistUser),"修改成功");
    }
}
