package com.ego14t.xinmusic.controller;

import com.ego14t.common.controller.AbstractController;
import com.ego14t.common.entity.Result;
import com.ego14t.xinmusic.service.MusicService;
import io.swagger.annotations.*;
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
@Api(value = "歌曲Controller",tags = {"歌曲操作类接口"})
public class MusicController extends AbstractController {

    @Resource
    private MusicService musicService;

    /**
     * 检索歌曲，适用于用户点击单曲显示的信息
     * @param musicId 歌单ID
     * @return 歌单list
     */
    @GetMapping("/song/{musicId}")
    @ApiOperation(value="根据歌曲id返回歌曲信息",notes="根据歌曲id返回歌曲信息")
    @ApiImplicitParam(name = "musicId", value = "单曲ID", required = true)
    public ResponseEntity<?> getMusicInfo(@PathVariable(name="musicId") String musicId){
        return Result.OK(musicService.getMusicInfo(musicId));
    }

    /**
     * 歌曲添加到歌单中
     * @param musiclistId  歌单ID
     * @param musicId  歌曲ID
     * @return 状态码
     */
    @PostMapping("/song/{musiclistId}/{musicId}")
    @ApiOperation(value="将歌曲添加到歌单中",notes="将歌曲添加到歌单中")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "musiclistId", value = "歌单ID", required = true),
            @ApiImplicitParam(name = "musicId", value = "歌曲ID", required = true)
    })
    public ResponseEntity<?> addMusicToList(@PathVariable(name = "musiclistId" )String musiclistId,
                                            @PathVariable(name="musicId") String musicId){
        musicService.addMusicToList(musiclistId, musicId);
        return Result.OK();
    }

    /**
     * 把歌曲从歌单删除
     * @param musiclistId 歌单ID
     * @param musicId 歌曲ID
     * @return 删除信息
     */
    @DeleteMapping("/song/{musiclistId}/{musicId}")
    @ApiOperation(value="根据歌曲id删除歌曲",notes="从歌单中删除歌曲")
    @ApiImplicitParams({
      @ApiImplicitParam(name = "musiclistId", value = "歌单ID", required = true),
      @ApiImplicitParam(name = "musicId", value = "歌曲ID", required = true)
    })
    public ResponseEntity<?> delMusic(@PathVariable(name = "musiclistId" )String musiclistId,
                                 @PathVariable(name="musicId") String musicId){
        musicService.delMusicFromList(musiclistId,musicId);
        return Result.OK();
    }

    /**
     * 歌曲查询功能(登录&&未登录)
     * @return 查询结果
     */
    @GetMapping("/song/search")
    @ApiOperation(value="搜索歌曲",notes="根据关键字")
    @ApiModelProperty(name = "keyword", value = "关键字", required = true)
    public ResponseEntity<?> getSearchList(@RequestParam("keyword")String keyword){
        String userId = getUserId();
        return Result.OK(musicService.getSearchUserList(userId, keyword));
    }

    /**
     * 喜欢音乐
     * @param musicId 歌曲ID
     * @return ResponseEntity<?>
     */
    @PostMapping("/song/likeMusic/{musicId}")
    public ResponseEntity<?> likeMusic(@PathVariable(name="musicId") String musicId){
        musicService.likeMusic(getUserId(),musicId);
        return Result.OK();
    }

    /**
     * 不喜欢音乐
     * @param musicId 歌曲ID
     * @return ResponseEntity<?>
     */
    @DeleteMapping("/song/dislikeMusic/{musicId}")
    public ResponseEntity<?> dislikeMusic(@PathVariable(name="musicId") String musicId){
        musicService.dislikeMusic(getUserId(),musicId);
        return Result.OK();
    }

    @GetMapping("/test")
    public String test() {
        return getUserId();
    }
}
