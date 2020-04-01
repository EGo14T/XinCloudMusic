package com.ego14t.xinmusicfeign.pojo;


import lombok.Data;

@Data
public class MusiclistUser {
    private Integer musiclistid;

    private Integer userid;

    private String musiclistName;

    private String createTime;

    private String tags;

    private String description;

    private String musiclistImg;

    private Integer status;


}