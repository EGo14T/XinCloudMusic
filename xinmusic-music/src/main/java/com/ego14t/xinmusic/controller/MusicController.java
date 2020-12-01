package com.ego14t.xinmusic.controller;

import com.ego14t.xinmusic.service.MusicService;
import com.ego14t.xinmusic.vo.MusicInfoVo;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 王富昕
 * Create By EGo1ST
 * Date ：Created in 2019/9/29 11:36
 * Description：
 */
@RestController
@RequestMapping(value = "/music")
@Api(value = "歌曲Controller",tags = {"歌曲操作类接口"})
public class MusicController extends AbstractController{

    @Resource
    private MusicService musicService;

    /**
     * 检索歌曲，适用于用户点击单曲显示的信息
     * @param musicId 歌单ID
     * @return 歌单list
     */
    @GetMapping(value = "/song/{musicId}")
    @ApiOperation(value="根据歌曲id返回歌曲信息",notes="根据歌曲id返回歌曲信息")
    @ApiImplicitParam(name = "musicId", value = "单曲ID", required = true)
    public MusicInfoVo getMusicInfo(@PathVariable(name="musicId") String musicId){
        return musicService.getMusicInfo(musicId);
    }

    /**
     * 歌曲添加到歌单中
     * @param musiclistId  歌单ID
     * @param musicId  歌曲ID
     * @return 状态码
     */
    @PostMapping(value = "/song/{musiclistId}/{musicId}")
    @ApiOperation(value="将歌曲添加到歌单中",notes="将歌曲添加到歌单中")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "musiclistId", value = "歌单ID", required = true),
            @ApiImplicitParam(name = "musicId", value = "歌曲ID", required = true)
    })
    public String addMusicToList(@PathVariable(name = "musiclistId" )String musiclistId,
                                 @PathVariable(name="musicId") String musicId){
        return musicService.addMusicToList(musiclistId, musicId);
    }

    /**
     * 把歌曲从歌单删除
     * @param musiclistId 歌单ID
     * @param musicId 歌曲ID
     * @return 删除信息
     */
    @DeleteMapping(value = "/song/{musiclistId}/{musicId}")
    @ApiOperation(value="根据歌曲id删除歌曲",notes="从歌单中删除歌曲")
    @ApiImplicitParams({
      @ApiImplicitParam(name = "musiclistId", value = "歌单ID", required = true),
      @ApiImplicitParam(name = "musicId", value = "歌曲ID", required = true)
    })
    public String delMusic(@PathVariable(name = "musiclistId" )String musiclistId,
                           @PathVariable(name="musicId") String musicId){
        return musicService.delMusicFromList(musiclistId,musicId);
    }

    /**
     * 歌曲查询功能(登录&&未登录)
     * @return
     */
    @GetMapping(value = "/song/search")
    @ApiOperation(value="搜索歌曲",notes="根据关键字")
    @ApiModelProperty(name = "keyword", value = "关键字", required = true)
    public List<MusicInfoVo> getSearchList(@RequestParam(value = "keyword")String keyword){
        String userId = getUserId();
        return musicService.getSearchUserList(userId, keyword);
    }

    @GetMapping("/test")
    public String test() {
        return getUserId();
    }
}
