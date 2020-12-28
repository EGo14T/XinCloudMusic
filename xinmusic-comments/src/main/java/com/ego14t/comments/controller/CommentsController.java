package com.ego14t.comments.controller;

import com.ego14t.comments.vo.CommentsResponseVo;
import com.ego14t.comments.service.CommentsService;
import com.ego14t.comments.vo.CreateCommentsVo;
import com.ego14t.common.entity.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping(value = "/comments")
public class CommentsController extends AbstractController{

    @Resource
    private CommentsService commentsService;

    /**
     * 添加评论 相对于资源来说  每首歌曲下面的评论
     * @param createCommentsVo 评论实体
     * @return  评论信息 包括用户昵称和用户头像
     */
    @PostMapping(value = "/saveComments")
    public Result<?> saveComments(@RequestBody CreateCommentsVo createCommentsVo){
        return Result.OK(commentsService.saveComments(createCommentsVo,getUserId()));
    }

    @GetMapping("/getComment/{commentId}")
    public Result<?> getComment(@PathVariable(value = "commentId")String commentId) {
        return Result.OK(commentsService.getComment(commentId, getUserId()));
    }


    @GetMapping(value = "/getAllComments/{showId}/{page}/{total}")
    @ResponseBody
    public Result<?> getAllComments(@PathVariable(value = "showId")String showId,
                                                   @PathVariable(value = "page")Integer page,
                                                   @PathVariable(value = "total")Integer total){
        return Result.OK(commentsService.getAllComments(showId,page,total));
    }


}
