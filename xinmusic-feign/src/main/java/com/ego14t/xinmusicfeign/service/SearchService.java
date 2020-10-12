package com.ego14t.xinmusicfeign.service;

import com.ego14t.xinmusicfeign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/21
 * Description:
 */

@FeignClient(value = "xinmusic-music",configuration = FeignConfig.class)
public interface SearchService {

    @GetMapping(value = "/search/musiclist")
    List<Object> getSearchList(@RequestParam(value = "keyword")String keyword);

    @GetMapping(value = "/search/musiclist/{userID}")
    List<Object> getSearchUserList(@PathVariable(value = "userID")String userID,
                                   @RequestParam(value = "keyword")String keyword);
}
