package com.ego14t.xinmusic.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2019/10/14 14:39
 * Description:
 */
@Data
public class MusicListInfo {
    private Integer musiclistid;
    private String musiclistName;
    private Integer status;
    private Integer iscollecting;


}
