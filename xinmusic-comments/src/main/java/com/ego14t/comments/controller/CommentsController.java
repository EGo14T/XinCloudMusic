package com.ego14t.comments.controller;

import com.ego14t.comments.entity.CommentsResponseResult;
import com.ego14t.comments.pojo.Comments;
import com.ego14t.comments.service.CommentsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping(value = "/comments")
public class CommentsController {

    @Resource
    private CommentsService commentsService;

    /**
     * 添加评论 相对于资源来说  每首歌曲下面的评论
     * @param comments 评论实体
     * @return  评论信息 包括用户昵称和用户头像
     */
    @PostMapping(value = "/saveComments")
    public CommentsResponseResult saveComments(@RequestBody Comments comments){
        return commentsService.saveComments(comments);
    }

    @GetMapping(value = "/getComments/{showId}/{page}/{total}")
    @ResponseBody
    public List<CommentsResponseResult> getComments(@PathVariable(value = "showId")String showId,
                                                    @PathVariable(value = "page")Integer page,
                                                    @PathVariable(value = "total")Integer total){
        return commentsService.getComments(showId,page,total);
    }


}
