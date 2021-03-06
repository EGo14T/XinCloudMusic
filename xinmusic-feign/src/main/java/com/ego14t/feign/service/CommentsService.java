package com.ego14t.feign.service;

import com.ego14t.feign.config.FeignConfig;
import com.ego14t.feign.vo.CreateCommentsVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/3/24
 * Description: 调用评论模块
 */
@FeignClient(value = "XinMusic-Comments",configuration = FeignConfig.class)
public interface CommentsService {
    /**
     * 添加评论
     * @param createCommentsVo 评论实体
     * @return 评论信息
     */
    @PostMapping("/comments/saveComments")
    ResponseEntity<?> saveComments(@RequestBody CreateCommentsVo createCommentsVo);

    /**
     * 获取评论
     * @param commentId 评论id
     * @return 评论信息
     */
    @GetMapping("/comments/getComment/{commentId}")
    ResponseEntity<?> getComment(@PathVariable("commentId") String commentId);

    /**
     * @param showId 资源ID
     * @param page  页码
     * @param total 每页显示总数
     * @return 评论信息
     */
    @GetMapping("/comments/getAllComments/{showId}/{page}/{total}")
    ResponseEntity<?> getAllComments(@PathVariable("showId")String showId,
                                     @PathVariable("page")Integer page,
                                     @PathVariable("total")Integer total);
}
