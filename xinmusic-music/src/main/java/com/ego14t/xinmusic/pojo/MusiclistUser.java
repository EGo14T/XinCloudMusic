package com.ego14t.xinmusic.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MusiclistUser {
    private Integer musiclistid;

    private Integer userid;

    private String musiclistName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate createTime;

    private String tags;

    private String description;

    private String musiclistImg;

    private Integer status;

    private Integer iscollecting;
}