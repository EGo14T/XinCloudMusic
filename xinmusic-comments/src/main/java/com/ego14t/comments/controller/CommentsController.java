package com.ego14t.comments.controller;

import com.ego14t.comments.entity.CommentsInfoEntity;
import com.ego14t.comments.entity.ReplyEntity;
import com.ego14t.comments.pojo.CommentsInfo;
import com.ego14t.comments.pojo.CommentsReply;
import com.ego14t.comments.service.CommentsService;
import com.ego14t.comments.utils.BeanCopyUtils;
import com.ego14t.comments.utils.UidUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2019/12/30 15:34
 * Description: 评论接口
 */

@RestController
@RequestMapping(value = "/comments")
public class CommentsController {

    @Resource
    private CommentsService commentsService;


    /**
     * 添加新评论，相对于资源来说
     * @param commentsInfo 评论实体
     * @return 返回评论的主键ID
     */
    @PostMapping("/saveComments")
    @ResponseBody
    public String saveComments(@RequestBody CommentsInfo commentsInfo){
        commentsInfo.setId(UidUtils.genUniqueKey());
        return commentsService.saveComments(commentsInfo);
    }


    /**
     * 根据ownerId获取评论
     * @param ownerId ownerId
     * @return 评论
     */
    @GetMapping("/get/{ownerId}")
    @ResponseBody
    public List<CommentsInfoEntity> getComments(@PathVariable(value = "ownerId")String ownerId){
        List<CommentsInfo> commentsInfos = commentsService.findByOwnerId(ownerId);
        List<CommentsInfoEntity> entities = commentsInfos
                .stream().map(info -> {
                    CommentsInfoEntity entity = new CommentsInfoEntity();
                    BeanCopyUtils.copy(info,entity);
                    entity.setDate(info.getCreateTime());
                    entity.setReply(commentsService.getReply(entity.getId()));
                    return entity;
                }).collect(Collectors.toList());
        return entities ;
    }

    @PostMapping("/saveReply")
    @ResponseBody
    public String saveReplay(@RequestBody CommentsReply commentsReply){
        return commentsService.saveReplay(commentsReply);
    }

    @GetMapping("/getReply/{commentId}")
    @ResponseBody
    public List<ReplyEntity> getReply(@PathVariable(value = "commentId") String commentId){
        return commentsService.getReply(commentId);
    }
}
