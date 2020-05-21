package com.ego14t.xinmusicfeign.controller;

import com.ego14t.xinmusicfeign.pojo.ResponseJsonResult;
import com.ego14t.xinmusicfeign.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/21
 * Description:
 */
@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @Resource
    private SearchService searchService;

    /**
     * 歌曲查询功能(未登录)
     * @return
     */
    @GetMapping(value = "/musiclist")
    @ResponseBody
    public ResponseEntity<?> getSearchList(@RequestParam(value = "keyword")String keyword){

        return ResponseJsonResult.OK(searchService.getSearchList(keyword),"获取成功");
    }

    /**
     * 歌曲查询功能
     * @return
     */
    @GetMapping(value = "/musiclist/{userID}")
    @ResponseBody
    public ResponseEntity<?> getSearchUserList(@PathVariable(value = "userID")String userID,
                                               @RequestParam(value = "keyword")String keyword){

        return ResponseJsonResult.OK(searchService.getSearchUserList(userID,keyword),"获取成功");
    }
}
