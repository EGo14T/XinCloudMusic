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


    MUSIC_MODULE_ERROR(1001,"音乐模块错误，请联系管理员"),
    /** 没有检索到该音乐信息 */
    NOTFOUNDMUSICINFO(1002,"没有检索到该音乐信息"),
    /** 歌曲已存在 */
    MUSIC_IS_EXISTS(1003,"歌曲已存在"),
    /** 创建歌单不存在 */
    CREATE_MUSICLIST_IS_NOT_EXISTS(1004,"创建歌单不存在"),


    /** 用户模块错误，请联系管理员 */
    USER_MODULE_ERROR(3001,"用户模块错误，请联系管理员"),
    /** 用户信息不存在 */
    USER_IS_NOT_EXISTS(3002,"用户信息不存在"),
    /** 用户信息更新失败，请联系管理员 */
    USERINFO_UPDATE_FAILURE(3003,"用户信息更新失败，请联系管理员"),



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
