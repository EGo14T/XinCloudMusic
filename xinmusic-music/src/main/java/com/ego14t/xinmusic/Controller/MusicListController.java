package com.ego14t.xinmusic.Controller;


import com.ego14t.xinmusic.entity.MusicList;
import com.ego14t.xinmusic.entity.MusicListInfo;
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
     * 检索歌单
     * @param musicListID 歌单ID
     * @param userId 用户ID
     * @return 歌单list
     */
    @GetMapping(value = "/musiclist/{userID}/{musicListID}")
    @ResponseBody
    @ApiOperation(value="根据歌单id返回歌曲列表包括歌曲,还需要用户id",notes="根据歌单id和用户id，组合出带收藏状态的歌单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userID", value = "用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "musicListID", value = "歌单ID", required = true, dataType = "int")
    })
    public List<MusicList> getMusicList(@PathVariable(name="musicListID") Integer musicListID ,
                                        @PathVariable(value="userID") Integer userId){

        return musicListService.getMusicList(musicListID,userId);

    }


    @GetMapping(value = "/musiclist/{userID}")
    @ResponseBody
    @ApiOperation(value="根据歌单id返回用户的歌单列表",notes="歌单列表  而不是歌曲列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userID", value = "用户ID", required = true, dataType = "int")
    })
    public List<MusicListInfo> getMusicListInfo(@PathVariable(value="userID") Integer userId){

        return musicListService.getMusicListInfo(userId);

    }

//    @GetMapping(value = "/musiclist/{musicListID}")
//    @ResponseBody
//    @ApiOperation(value="根据歌单id返回歌单详细信息",notes="歌单信息，谁创建的  创建时间  收藏信息 tag 等")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "musicListID", value = "歌单ID", required = true, dataType = "String")
//    })




    /**
     * 根据歌单id删除歌单
     * @param musicListID 歌单ID
     * @return 状态
     */
    @DeleteMapping(value = "/musiclist/{musicListID}")
    @ResponseBody
    @ApiOperation(value = "根据歌单id删除歌单",notes="注意问题点")
    @ApiImplicitParam(name = "musicListID", value = "歌单ID", required = true, dataType = "int")
    public String delMusicList(@PathVariable(value = "musicListID")Integer musicListID){

        return musicListService.delMusicList(musicListID);

        }

    /**
     * 传入歌单信息 添加到数据库，然后返回新添加的歌单的主键
     * @param musiclistUser 歌单信息实体
     * @return 添加歌单的主键
     */
    @PostMapping(value = "/musiclist")
    @ResponseBody
    @ApiOperation(value = "新建歌单",notes="注意问题点")
    public int addMusicList(
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
    @ApiImplicitParam(name = "musicListID", value = "歌单ID", required = true, dataType = "int")
    public int updateMusicList(@PathVariable(value = "musicListID")Integer musicListID
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
