package com.ego14t.xinmusic.controller;

import com.ego14t.xinmusic.pojo.MusicListInfo;
import com.ego14t.xinmusic.pojo.UserMusicList;
import com.ego14t.xinmusic.service.MusicListService;
import com.ego14t.xinmusic.vo.MusicListVo;
import com.ego14t.xinmusic.vo.MusicInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ego14t.xinmusic.common.vaildator.group.AddGroup;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping(value = "/musiclist")
@CrossOrigin
@Api(value = "歌单Controller",tags = {"歌单操作类接口"})
public class MusicListController extends AbstractController{

    @Resource
    MusicListService musicListService;

    @Resource
    private HttpServletRequest request;

    /**
     * 检索用户的歌单列表(创建&默认)
     * @param userId 用户ID
     * @return 返回歌单列表
     */
    @GetMapping(value = "/created/{userID}")
    @ApiOperation(value="根据歌单id返回用户的歌单列表（创建&默认）",notes="歌单列表")
    @ApiImplicitParam(name = "userID", value = "用户ID", required = true)

    public List<UserMusicList> getCreateMusicListInfo(@PathVariable(value="userID") String userId){
        return musicListService.getCreateMusicListInfo(userId);
    }

    /**
     * 检索用户的歌单列表(收藏)
     * @param userId 用户ID
     * @return 返回歌单列表
     */
    @GetMapping(value = "/collected/{userID}")
    @ApiOperation(value="根据歌单id返回用户的歌单列表（用户收藏的歌单）",notes="歌单列表")
    @ApiImplicitParam(name = "userID", value = "用户ID", required = true)
    public List<UserMusicList> getCollectMusicListInfo(@PathVariable(value="userID") String userId){
        return musicListService.getCollectMusicListInfo(userId);
    }

    /**
     * 推荐歌单
     * @return 返回歌单列表
     */
    @GetMapping(value = "/discover")
    @ApiOperation(value="返回推荐歌单",notes="歌单列表")
    public List<UserMusicList> getDiscoverMusicListInfo(){
        return musicListService.getDiscoverMusicListInfo();
    }

    /**
     * 收藏歌单操作
     * @param musicListID
     * @return
     */
    @PostMapping(value = "/collect/{musicListID}")
    @ApiOperation(value="用户收藏歌单",notes="歌单列表")
    @ApiImplicitParam(name = "musicListID", value = "歌单ID", required = true)
    public Integer collectMusicList(@PathVariable(name="musicListID") String musicListID){
        String userId = getUserId(request);
        return musicListService.collectMusicList(userId,musicListID);
    }


    /**
     * 根据歌单ID查询带状态的歌单歌曲列表
     * @param musicListID 歌单ID
     * @return  歌单的详细信息
     */
    @GetMapping(value = "/{musicListID}")
    @ApiOperation(value="根据歌单id返回歌曲列表包括歌曲,还需要用户id",notes="根据歌单id和用户id，组合出带收藏状态的歌单")
    @ApiImplicitParam(name = "musicListID", value = "歌单ID", required = true)
    public List<MusicInfoVo> getUserMusicList(@PathVariable(name="musicListID") String musicListID){
        String userId = getUserId(request);
        return musicListService.getUserMusicList(musicListID,userId);
    }

    /**
     * 根据歌单id返回歌单详细信息
     * @param musicListID
     * @return
     */
    @GetMapping(value = "/getinfo/{musicListID}")
    @ApiOperation(value="根据歌单id返回歌单详细信息",notes="歌单信息，谁创建的  创建时间  收藏信息 tag 等")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userID", value = "用户ID", required = true),
            @ApiImplicitParam(name = "musicListID", value = "歌单ID", required = true)
    })
    public MusicListInfo getMusicListInfo(@PathVariable(name = "musicListID") String musicListID){
        String userId = getUserId(request);
        return musicListService.getMusicListInfo(userId,musicListID);
    }

    /**
     * 新建歌单
     * @param musicListVo 歌单信息实体
     * @return 添加歌单的主键
     */
    @PostMapping(value = "/created")
    @ApiOperation(value = "新建歌单",notes="注意问题点")
    public String addMusicList(@RequestBody @Validated({AddGroup.class}) MusicListVo musicListVo) {
        return musicListService.createMusicList(musicListVo);
    }

    /**
     * 删除歌单
     * @param musicListID 歌单ID
     * @return 状态
     */
    @DeleteMapping(value = "/{musicListID}")
    @ApiOperation(value = "根据歌单id删除歌单",notes="注意问题点")
    @ApiImplicitParam(name = "musicListID", value = "歌单ID", required = true)
    public String delMusicList(@PathVariable(value = "musicListID")String musicListID){
        String userId = getUserId(request);
        return musicListService.delMusicList(userId,musicListID);
    }

    /**
     *
     * @param musicListVo 修改的参数
     * @return 修改结果
     */
    @PatchMapping(value = "/update")
    @ApiOperation(value = "修改歌单",notes="注意问题点")
    @ApiImplicitParam(name = "musicListVo", value = "歌单修改实体", required = true)
    public String updateMusicList(@Validated @RequestBody MusicListVo musicListVo) {
        return musicListService.updateMusicList(musicListVo);
    }
}