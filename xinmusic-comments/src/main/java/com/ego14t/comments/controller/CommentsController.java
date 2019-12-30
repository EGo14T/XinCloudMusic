package com.ego14t.comments.controller;

import com.ego14t.comments.pojo.CommentsInfo;
import com.ego14t.comments.service.CommentsService;
import com.ego14t.comments.utils.UidUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @PostMapping("/save")
    @ResponseBody
    public String saveComments(@RequestBody CommentsInfo commentsInfo){
        commentsInfo.setId(UidUtils.genUniqueKey());
        return commentsService.saveComments(commentsInfo);
    }
}
