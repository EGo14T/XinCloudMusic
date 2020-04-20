package com.ego14t.xinmusicfeign.pojo;


import lombok.Data;

@Data
public class Music {
    private Integer id;

    private Integer musicID;

    private String name;

    private String singer;

    private String album;

    private String length;
}