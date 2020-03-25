package com.ego14t.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/3/25
 * Description:
 */
@RestController
public class TestController {
    @GetMapping(value = "/test")
    @ResponseBody
    public String test(){
        return "123";
    }
}
