package com.ego14t.feign.service;

import com.ego14t.feign.pojo.Comments;
import com.ego14t.feign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/3/24
 * Description: 调用评论模块
 */
@FeignClient(value = "xinmusic-comments",configuration = FeignConfig.class)
public interface CommentsService {
    /**
     * @param showId 资源ID
     * @param page  页码
     * @param total 每页显示总数
     * @return 评论信息
     */
    @GetMapping(value = "/comments/getComments/{showId}/{page}/{total}")
    List<Object> getComments(@PathVariable(value = "showId")String showId,
                             @PathVariable(value = "page")Integer page,
                             @PathVariable(value = "total")Integer total);

    /**
     * 添加评论
     * @param comments 评论实体
     * @return 评论信息
     */
    @PostMapping(value = "/comments/saveComments")
    Object saveComments(@RequestBody Comments comments);

}
