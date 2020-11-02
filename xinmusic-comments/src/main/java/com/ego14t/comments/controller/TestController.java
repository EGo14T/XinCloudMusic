package com.ego14t.comments.controller;


import com.ego14t.comments.entity.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/en")
    public R test(@RequestBody String s){
        System.out.println(s);

        Map<String, String> resMap = new HashMap<>();
        resMap.put("test","test");
        return R.ok().put("test","test");
    }

    private class Hello{

        private String k;

        public String getK() {
            return k;
        }

        public void setK(String k) {
            this.k = k;
        }
    }
}
