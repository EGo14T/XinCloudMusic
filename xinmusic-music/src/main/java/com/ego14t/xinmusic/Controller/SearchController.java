package com.ego14t.xinmusic.Controller;

import com.ego14t.xinmusic.entity.MusicList;
import com.ego14t.xinmusic.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/19
 * Description:
 */

@Controller
@RequestMapping(value = "/search")
@CrossOrigin
@Api(value = "搜索Controller",tags = {"搜索功能父接口"})
public class SearchController {

    @Resource
    private SearchService searchService;

    /**
     * 歌曲查询功能(未登录)
     * @return
     */
    @GetMapping(value = "/musiclist")
    @ResponseBody
    @ApiOperation(value="搜索歌曲",notes="根据关键字")
    @ApiImplicitParam(name = "keyword", value = "关键字", required = true, dataType = "String")
    public List<MusicList> getSearchList(@RequestParam(value = "keyword")String keyword){
        return searchService.getSearchList(keyword);
    }

    /**
     * 歌曲查询功能(未登录)
     * @return
     */
    @GetMapping(value = "/musiclist/{userID}")
    @ResponseBody
    @ApiOperation(value="搜索歌曲",notes="根据关键字")
    @ApiImplicitParam(name = "keyword", value = "关键字", required = true, dataType = "String")
    public List<MusicList> getSearchUserList(@PathVariable(value = "userID")String userID,
                                             @RequestParam(value = "keyword")String keyword){
        return searchService.getSearchUserList(userID,keyword);
    }
}
