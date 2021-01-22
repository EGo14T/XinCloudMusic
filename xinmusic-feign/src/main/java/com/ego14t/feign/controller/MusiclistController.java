package com.ego14t.feign.controller;

import com.ego14t.common.controller.AbstractController;
import com.ego14t.feign.service.MusicListService;
import com.ego14t.feign.vo.MusicListVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/musiclist")
public class MusiclistController extends AbstractController {

    @Resource
    MusicListService musiclistService;

    /**
     * 检索用户的歌单列表(创建&默认)
     * @param userId 用户ID
     * @return 返回歌单列表
     */
    @GetMapping("/created/{userId}")
    public ResponseEntity<?> getCreateMusicListInfo(@PathVariable("userId") String userId){
        return musiclistService.getCreateMusicListInfo(userId);
    }

    /**
     * 检索用户的歌单列表(收藏)
     * @param userId 用户ID
     * @return 返回歌单列表
     */
    @GetMapping("/collected/{userId}")
    public ResponseEntity<?> getCollectMusicListInfo(@PathVariable("userId") String userId){
        return musiclistService.getCollectMusicListInfo(userId);
    }

    /**
     * 推荐歌单
     * @return 返回歌单列表
     */
    @GetMapping("/discover")
    public ResponseEntity<?> getDiscoverMusicListInfo(){
        return musiclistService.getDiscoverMusicListInfo();
    }

    /**
     * 收藏歌单操作
     * @param musiclistId
     * @return
     */
    @PostMapping("/collect/{musiclistId}")
    public ResponseEntity<?> collectMusicList(@PathVariable(name="musiclistId") String musiclistId){
        return musiclistService.collectMusicList(musiclistId);
    }

    /**
     * 取消收藏歌单操作
     * @param musiclistId
     * @return
     */
    @PostMapping("/unCollect/{musiclistId}")
    public ResponseEntity<?> unCollectMusicList(@PathVariable(name="musiclistId") String musiclistId){
        return musiclistService.unCollectMusicList(musiclistId);
    }

    /**
     * 根据歌单ID查询带状态的歌单歌曲列表
     * @param musiclistId 歌单ID
     * @return  歌单的详细信息
     */
    @GetMapping("/{musiclistId}")
    public ResponseEntity<?> getUserMusicList(@PathVariable(name="musiclistId") String musiclistId){
        return musiclistService.getUserMusicList(musiclistId);
    }

    /**
     * 根据歌单id返回歌单详细信息
     * @param musiclistId
     * @return
     */
    @GetMapping("/getinfo/{musiclistId}")
    public ResponseEntity<?> getMusicListInfo(@PathVariable(name = "musiclistId") String musiclistId){
        return musiclistService.getMusicListInfo(musiclistId);
    }

    /**
     * 新建歌单
     * @param musiclistVo 歌单信息实体
     * @return 添加歌单的主键
     */
    @PostMapping("/created")
    public ResponseEntity<?> addMusicList(@RequestBody MusicListVo musiclistVo) {
        return musiclistService.createMusicList(musiclistVo);
    }

    /**
     * 删除歌单
     * @param musiclistId 歌单ID
     * @return 状态
     */
    @DeleteMapping("/{delType}/{musiclistId}")
    public ResponseEntity<?> delMusicList(@PathVariable("delType") String delType, @PathVariable("musiclistId")String musiclistId){
        return musiclistService.delMusicList(delType, musiclistId);
    }

    /**
     *
     * @param musiclistVo 修改的参数
     * @return 修改结果
     */
    @PatchMapping("/update")
    public ResponseEntity<?> updateMusicList(@RequestBody MusicListVo musiclistVo) {
        return musiclistService.updateMusicList(musiclistVo);
    }
}
