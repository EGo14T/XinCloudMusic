package com.ego14t.xinmusic.controller;

import com.ego14t.common.controller.AbstractController;
import com.ego14t.common.entity.Result;
import com.ego14t.xinmusic.service.MusicListService;
import com.ego14t.xinmusic.vo.MusicListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ego14t.common.constant.vaildator.group.AddGroup;

import javax.annotation.Resource;


@RestController
@RequestMapping("/musiclist")
@CrossOrigin
@Api(value = "歌单Controller",tags = {"歌单操作类接口"})
public class MusicListController extends AbstractController {

    @Resource
    MusicListService musiclistService;

    /**
     * 检索用户的歌单列表(创建&默认)
     * @param userId 用户ID
     * @return 返回歌单列表
     */
    @GetMapping("/created/{userId}")
    @ApiOperation(value="根据歌单id返回用户的歌单列表（创建&默认）",notes="歌单列表")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true)

    public ResponseEntity<?> getCreateMusicListInfo(@PathVariable(value="userId") String userId){
        return Result.OK(musiclistService.getCreateMusicListInfo(getUserId(), userId));
    }

    /**
     * 检索用户的歌单列表(收藏)
     * @param userId 用户ID
     * @return 返回歌单列表
     */
    @GetMapping("/collected/{userId}")
    @ApiOperation(value="根据歌单id返回用户的歌单列表（用户收藏的歌单）",notes="歌单列表")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true)
    public ResponseEntity<?> getCollectMusicListInfo(@PathVariable(value="userId") String userId){
        return Result.OK(musiclistService.getCollectMusicListInfo(userId));
    }

    /**
     * 推荐歌单
     * @return 返回歌单列表
     */
    @GetMapping("/discover")
    @ApiOperation(value="返回推荐歌单",notes="歌单列表")
    public ResponseEntity<?> getDiscoverMusicListInfo(){
        return Result.OK(musiclistService.getDiscoverMusicListInfo());
    }

    /**
     * 收藏歌单操作
     * @param musiclistId
     * @return
     */
    @PostMapping("/collect/{musiclistId}")
    @ApiOperation(value="用户收藏歌单",notes="歌单列表")
    @ApiImplicitParam(name = "musiclistId", value = "歌单ID", required = true)
    public ResponseEntity<?> collectMusicList(@PathVariable(name="musiclistId") String musiclistId){
        String userId = getUserId();
        musiclistService.collectMusicList(userId,musiclistId);
        return Result.OK();
    }


    /**
     * 根据歌单ID查询带状态的歌单歌曲列表
     * @param musiclistId 歌单ID
     * @return  歌单的详细信息
     */
    @GetMapping("/{musiclistId}")
    @ApiOperation(value="根据歌单id返回歌曲列表,还需要用户id",notes="根据歌单id和用户id，组合出带收藏状态的歌单")
    @ApiImplicitParam(name = "musiclistId", value = "歌单ID", required = true)
    public ResponseEntity<?> getUserMusicList(@PathVariable(name="musiclistId") String musiclistId){
        String userId = getUserId();
        return Result.OK(musiclistService.getUserMusicList(musiclistId,userId));
    }

    /**
     * 根据歌单id返回歌单详细信息
     * @param musiclistId
     * @return
     */
    @GetMapping("/getinfo/{musiclistId}")
    @ApiOperation(value="根据歌单id返回歌单详细信息",notes="歌单信息，谁创建的  创建时间  收藏信息 tag 等")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true),
            @ApiImplicitParam(name = "musiclistId", value = "歌单ID", required = true)
    })
    public ResponseEntity<?> getMusicListInfo(@PathVariable(name = "musiclistId") String musiclistId){
        String userId = getUserId();
        return Result.OK(musiclistService.getMusicListInfo(userId,musiclistId));
    }

    /**
     * 新建歌单
     * @param musiclistVo 歌单信息实体
     * @return 添加歌单的主键
     */
    @PostMapping("/created")
    @ApiOperation(value = "新建歌单",notes="注意问题点")
    public ResponseEntity<?> addMusicList(@RequestBody @Validated({AddGroup.class}) MusicListVo musiclistVo) {
        return Result.OK(musiclistService.createMusicList(musiclistVo));
    }

    /**
     * 删除歌单(创建)
     * @param musiclistId 歌单ID
     * @return 状态
     */
    @DeleteMapping("/{delType}/{musiclistId}")
    @ApiOperation(value = "根据歌单id删除歌单",notes="注意问题点")
    @ApiImplicitParam(name = "musiclistId", value = "歌单ID", required = true)
    public ResponseEntity<?> delCreatedMusicList(@PathVariable("delType") String delType, @PathVariable("musiclistId")String musiclistId){
        musiclistService.delMusicList(getUserId(), musiclistId, delType);
        return Result.OK();
    }

    /**
     *
     * @param musiclistVo 修改的参数
     * @return 修改结果
     */
    @PatchMapping("/update")
    @ApiOperation(value = "修改歌单",notes="注意问题点")
    @ApiImplicitParam(name = "musiclistVo", value = "歌单修改实体", required = true)
    public ResponseEntity<?> updateMusicList(@Validated @RequestBody MusicListVo musiclistVo) {
        musiclistService.updateMusicList(musiclistVo);
        return Result.OK();
    }
}
