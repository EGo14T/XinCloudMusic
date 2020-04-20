package com.ego14t.xinmusic.Controller;

import com.ego14t.xinmusic.entity.MusicList;
import com.ego14t.xinmusic.service.MusicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 王富昕
 * Create By EGo1ST
 * Date ：Created in 2019/9/29 11:36
 * Description：
 */
@Controller
@RequestMapping(value = "/music")
@Api(value = "歌曲Controller",tags = {"歌曲操作类接口"})
public class MusicController {
    @Resource
    private MusicService musicService;

    /**
     * 检索歌曲，适用于用户点击单曲显示的信息
     * @param musicID 歌单ID
     * @return 歌单list
     */
    @GetMapping(value = "/song/{musicID}")
    @ResponseBody
    @ApiOperation(value="根据歌曲id返回歌曲信息",notes="注意问题点")
    @ApiImplicitParam(name = "musicID", value = "单曲ID", required = true, dataType = "String")
    public MusicList getMusicList(@PathVariable(name="musicID") String musicID ){
        return musicService.getMusic(musicID);
    }

    /**
     * 把歌曲从歌单删除
     * @param musicID 歌曲id
     * @return
     */
    @DeleteMapping(value = "/song/{musicListID}/{musicID}")
    @ResponseBody
    @ApiOperation(value="根据歌曲id删除歌曲",notes="从歌单中删除歌曲")
    @ApiImplicitParams({
      @ApiImplicitParam(name = "musicListID", value = "歌单ID", required = true, dataType = "String"),
      @ApiImplicitParam(name = "musicID", value = "用户ID", required = true, dataType = "String")
    })
    public String delMusic(@PathVariable(name="musicID") String musicID,
                           @PathVariable(name = "musicListID" )String musicListID){
        return musicService.delMusic(musicID,musicListID);
    }


    /**
     * 歌曲添加到歌单中
     * @param musicID  歌曲ID
     * @param musicListID  歌单ID
     * @return 状态码
     */
    @PostMapping(value = "/song/{musicListID}/{musicID}")
    @ResponseBody
    public String addMusicToList(@PathVariable(name="musicID") String musicID,
                                 @PathVariable(name = "musicListID" )String musicListID){
        return musicService.addMusicToList(musicID,musicListID);
    }
}
