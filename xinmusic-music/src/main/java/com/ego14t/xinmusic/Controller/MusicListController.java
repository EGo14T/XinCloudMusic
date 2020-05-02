package com.ego14t.xinmusic.Controller;


import com.ego14t.xinmusic.entity.MusicList;
import com.ego14t.xinmusic.entity.MusicListInfo;
import com.ego14t.xinmusic.entity.UserMusicListInfo;
import com.ego14t.xinmusic.pojo.Music;
import com.ego14t.xinmusic.pojo.MusiclistUser;
import com.ego14t.xinmusic.service.MusicListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping(value = "/my/music")
@CrossOrigin
@Api(value = "歌单Controller",tags = {"歌单操作类接口"})
public class MusicListController {
    @Resource
    MusicListService musicListService;


    /**
     * 检索用户的歌单列表(创建&默认)
     * @param userId 用户ID
     * @return 返回歌单列表
     */
    @GetMapping(value = "/create/musiclist/{userID}")
    @ResponseBody
    @ApiOperation(value="根据歌单id返回用户的歌单列表（创建&默认）",notes="歌单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userID", value = "用户ID", required = true, dataType = "String")
    })
    public List<UserMusicListInfo> getCreateMusicListInfo(@PathVariable(value="userID") String userId){

        return musicListService.getCreateMusicListInfo(userId);

    }

    /**
     * 检索用户的歌单列表(收藏)
     * @param userId 用户ID
     * @return 返回歌单列表
     */
    @GetMapping(value = "/collect/musiclist/{userID}")
    @ResponseBody
    @ApiOperation(value="根据歌单id返回用户的歌单列表（用户收藏的歌单）",notes="歌单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userID", value = "用户ID", required = true, dataType = "String")
    })
    public List<UserMusicListInfo> getCollectMusicListInfo(@PathVariable(value="userID") String userId){

        return musicListService.getCollectMusicListInfo(userId);

    }

    @PostMapping(value = "/collect/musiclist/{userID}/{musicListID}")
    @ResponseBody
    @ApiOperation(value="用户收藏歌单",notes="歌单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userID", value = "用户ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "musicListID", value = "歌单ID", required = true, dataType = "String")
    })
    public Integer collectMusicList(@PathVariable(value="userID") String userId,
                                   @PathVariable(name="musicListID") String musicListID){

        return musicListService.collectMusicList(userId,musicListID);
    }


    /**
     * 检索歌单中的歌曲
     * @param musicListID 歌单ID
     * @param userId 用户ID
     * @return 歌单list
     */
    @GetMapping(value = "/musiclist/{userID}/{musicListID}")
    @ResponseBody
    @ApiOperation(value="根据歌单id返回歌曲列表包括歌曲,还需要用户id",notes="根据歌单id和用户id，组合出带收藏状态的歌单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userID", value = "用户ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "musicListID", value = "歌单ID", required = true, dataType = "String")
    })
    public List<MusicList> getUserMusicList(@PathVariable(value="userID") String userId,
                                            @PathVariable(name="musicListID") String musicListID){

        return musicListService.getUserMusicList(musicListID,userId);

    }

    /**
     * 检索歌单中的歌曲
     * @param musicListID 歌单ID
     * @return 歌单list
     */
    @GetMapping(value = "/musiclist/{musicListID}")
    @ResponseBody
    @ApiOperation(value="根据歌单id返回歌曲列表包括歌曲",notes="根据歌单id查询歌曲列表")
    @ApiImplicitParam(name = "musicListID", value = "歌单ID", required = true, dataType = "String")
    public List<Music> getMusicList(@PathVariable(name="musicListID") String musicListID){

        return musicListService.getMusicList(musicListID);

    }


    @GetMapping(value = "/musiclistinfo/{musicListID}")
    @ResponseBody
    @ApiOperation(value="根据歌单id返回歌单详细信息",notes="歌单信息，谁创建的  创建时间  收藏信息 tag 等")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "musicListID", value = "歌单ID", required = true, dataType = "String")
    })
    public MusicListInfo getMusicListInfo(@PathVariable(name = "musicListID") String musicListID){

        return musicListService.getMusicListInfo(musicListID);
    }



    /**
     * 根据歌单id删除歌单
     * @param musicListID 歌单ID
     * @return 状态
     */
    @DeleteMapping(value = "/musiclist/{userID}/{musicListID}")
    @ResponseBody
    @ApiOperation(value = "根据歌单id删除歌单",notes="注意问题点")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userID", value = "用户ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "musicListID", value = "歌单ID", required = true, dataType = "String")
    })
    public String delMusicList(@PathVariable(value = "userID")String userID,
                               @PathVariable(value = "musicListID")String musicListID){

        return musicListService.delMusicList(userID,musicListID);

        }

    /**
     * 传入歌单信息 添加到数据库，然后返回新添加的歌单的主键
     * @param musiclistUser 歌单信息实体
     * @return 添加歌单的主键
     */
    @PostMapping(value = "/musiclist")
    @ResponseBody
    @ApiOperation(value = "新建歌单",notes="注意问题点")
    public String addMusicList(
            @RequestBody MusiclistUser musiclistUser)
    {
        return musicListService.addMusicList(musiclistUser);
    }


    /**
     *
     * @param musicListID 歌单ID
     * @param musiclistUser 修改的参数
     * @return 修改结果
     */
    @PatchMapping(value = "/musiclist/{musicListID}")
    @ResponseBody
    @ApiOperation(value = "修改歌单",notes="注意问题点")
    @ApiImplicitParam(name = "musicListID", value = "歌单ID", required = true, dataType = "String")
    public String updateMusicList(@PathVariable(value = "musicListID")String musicListID
                                         ,@RequestBody MusiclistUser musiclistUser)
    {
        return musicListService.updateMusicList(musicListID,musiclistUser);
    }


    /**
     * TEST
     * @param hi hi值
     * @return hi
     */
    @GetMapping(value = "hi")
    @ResponseBody
    public String sayhi(@RequestParam(value = "hi")String hi){
        System.out.print(hi+"");
        return hi;
    }

}
