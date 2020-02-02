package com.ego14t.xinmusic.pojo;

import lombok.Data;

import java.util.Date;


@Data
public class UserInfo {
    private Integer id;

    private String name;

    private Integer gender;

    private String introduce;

    private Date birth;

    private String area;
}