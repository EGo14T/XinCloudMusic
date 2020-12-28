package com.ego14t.feign.controller;

import com.ego14t.feign.pojo.Comments;
import com.ego14t.feign.pojo.ResponseJsonResult;
import com.ego14t.feign.service.CommentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/3/24
 * Description:
 */

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Resource
    private CommentsService commentsService;


    @GetMapping(value = "/getComments/{showId}/{page}/{total}")
    @ResponseBody
    public ResponseEntity<?> getComments(@PathVariable(value = "showId")String showId,
                                                    @PathVariable(value = "page")Integer page,
                                                    @PathVariable(value = "total")Integer total){
        return ResponseJsonResult.OK(commentsService.getComments(showId,page,total),"获取评论成功");
    }

    /**
     * 添加评论 相对于资源来说  每首歌曲下面的评论
     * @param comments 评论实体
     * @return  评论信息 包括用户昵称和用户头像
     */
    @PostMapping(value = "/saveComments")
    public ResponseEntity<?> saveComments(@RequestBody Comments comments){
        return ResponseJsonResult.CREATED(commentsService.saveComments(comments),"添加评论成功");
    }
}
