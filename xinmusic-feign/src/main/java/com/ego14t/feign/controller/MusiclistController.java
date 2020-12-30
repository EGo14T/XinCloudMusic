package com.ego14t.feign.controller;

import com.ego14t.common.constant.vaildator.group.AddGroup;
import com.ego14t.common.controller.AbstractController;
import com.ego14t.feign.service.MusicListService;
import com.ego14t.feign.vo.MusicListVo;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/musiclist")
public class MusiclistController extends AbstractController {

    @Resource
    MusicListService musicListService;

    /**
     * 检索用户的歌单列表(创建&默认)
     * @param userId 用户ID
     * @return 返回歌单列表
     */
    @GetMapping("/created/{userId}")
    public ResponseEntity<?> getCreateMusicListInfo(@PathVariable("userId") String userId){
        return musicListService.getCreateMusicListInfo(userId);
    }

    /**
     * 检索用户的歌单列表(收藏)
     * @param userId 用户ID
     * @return 返回歌单列表
     */
    @GetMapping("/collected/{userId}")
    public ResponseEntity<?> getCollectMusicListInfo(@PathVariable("userId") String userId){
        return musicListService.getCollectMusicListInfo(userId);
    }

    /**
     * 推荐歌单
     * @return 返回歌单列表
     */
    @GetMapping("/discover")
    public ResponseEntity<?> getDiscoverMusicListInfo(){
        return musicListService.getDiscoverMusicListInfo();
    }

    /**
     * 收藏歌单操作
     * @param musicListId
     * @return
     */
    @PostMapping("/collect/{musicListId}")
    public ResponseEntity<?> collectMusicList(@PathVariable(name="musicListId") String musicListId){
        return musicListService.collectMusicList(musicListId);
    }


    /**
     * 根据歌单ID查询带状态的歌单歌曲列表
     * @param musicListId 歌单ID
     * @return  歌单的详细信息
     */
    @GetMapping("/{musicListId}")
    public ResponseEntity<?> getUserMusicList(@PathVariable(name="musicListId") String musicListId){
        return musicListService.getUserMusicList(musicListId);
    }

    /**
     * 根据歌单id返回歌单详细信息
     * @param musicListId
     * @return
     */
    @GetMapping("/getinfo/{musicListId}")
    public ResponseEntity<?> getMusicListInfo(@PathVariable(name = "musicListId") String musicListId){
        return musicListService.getMusicListInfo(musicListId);
    }

    /**
     * 新建歌单
     * @param musicListVo 歌单信息实体
     * @return 添加歌单的主键
     */
    @PostMapping("/created")
    public ResponseEntity<?> addMusicList(@RequestBody MusicListVo musicListVo) {
        return musicListService.createMusicList(musicListVo);
    }

    /**
     * 删除歌单
     * @param musiclistId 歌单ID
     * @return 状态
     */
    @DeleteMapping("/{musiclistId}")
    public ResponseEntity<?> delMusicList(@PathVariable("musiclistId")String musiclistId){
        return musicListService.delMusicList(musiclistId);
    }

    /**
     *
     * @param musicListVo 修改的参数
     * @return 修改结果
     */
    @PatchMapping("/update")
    public ResponseEntity<?> updateMusicList(@RequestBody MusicListVo musicListVo) {
        return musicListService.updateMusicList(musicListVo);
    }
}
