package com.ego14t.feign.controller;

import com.ego14t.common.entity.Result;
import com.ego14t.feign.service.CommentsService;
import com.ego14t.feign.vo.CreateCommentsVo;
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


    /**
     * 添加评论 相对于资源来说  每首歌曲下面的评论
     * @param createCommentsVo 评论实体
     * @return  评论信息 包括用户昵称和用户头像
     */
    @PostMapping(value = "/saveComments")
    public ResponseEntity<?> saveComments(@RequestBody CreateCommentsVo createCommentsVo){
        return commentsService.saveComments(createCommentsVo);
    }

    @GetMapping("/getComment/{commentId}")
    public ResponseEntity<?> getComment(@PathVariable(value = "commentId")String commentId) {
        return commentsService.getComment(commentId);
    }

    @GetMapping(value = "/getAllComments/{showId}/{page}/{total}")
    public ResponseEntity<?> getComments(@PathVariable(value = "showId")String showId,
                                         @PathVariable(value = "page")Integer page,
                                         @PathVariable(value = "total")Integer total){
        return commentsService.getAllComments(showId,page,total);
    }
}
