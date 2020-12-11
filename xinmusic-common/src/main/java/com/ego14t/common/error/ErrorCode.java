package com.ego14t.common.error;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2020/12/11 10:21
 * Description:
 */
public enum ErrorCode implements ServiceErrors{

    /** 成功 */
    SUCCESS(200,"success"),
    /** 失败 */
    ERROR(500,"系统错误"),

    /** 没有检索到该音乐信息 */
    NOTFOUNDMUSICINFO(1001,"没有检索到该音乐信息"),

    /** 歌曲已存在 */
    MUSIC_IS_EXISTS(1002,"歌曲已存在"),

    /** 创建歌单不存在 */
    CREATE_MUSICLIST_IS_NOT_EXISTS(1003,"创建歌单不存在"),

    ;

    private Integer code;

    private String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
