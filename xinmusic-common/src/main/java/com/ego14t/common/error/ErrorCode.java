package com.ego14t.common.error;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2020/12/11 10:21
 * Description:
 */
public enum ErrorCode implements ServiceErrors{

    /** 没有对参数进行序列化，不是json数据 */
    NOT_JSON_DATA(-1, "没有对参数进行序列化，不是json数据"),
    /** 数据库已存在数据 */
    EXISTS_DATA(-2, "数据库已存在数据"),
    /** 成功 */
    SUCCESS(200,"success"),
    /** 失败 */
    ERROR(500,"系统错误"),
    /** 账号或密码错误 */
    PASSWORD_CHECK_ERROR(401, "账号或密码错误"),

    MUSIC_MODULE_ERROR(1001,"音乐模块错误，请联系管理员"),
    /** 没有检索到该音乐信息 */
    NOT_FOUND_MUSICINFO(1002,"没有检索到该音乐信息"),
    /** 歌曲已存在 */
    MUSIC_IS_EXISTS(1003,"歌曲已存在"),
    /** 创建歌单不存在 */
    CREATE_MUSICLIST_IS_NOT_EXISTS(1004,"创建歌单不存在"),
    /** 歌单不存在 */
    MUSICLIST_IS_NOT_EXISTS(1005, "歌单不存在"),
    /** 歌单信息不存在 */
    MUSICLISTINFO_IS_NOT_EXISTS(1006, "歌单信息不存在"),
    /** 收藏歌单失败 */
    COLLECT_MUSICLIST_FAILED(1007, "收藏歌单失败"),
    /** 新建歌单失败 */
    CREATE_MUSICLIST_FAILED(1008, "新建歌单失败"),
    /** 默认歌单无法删除 */
    DEFAULT_MUSICLIST_CANT_DEL(1009, "默认歌单无法删除"),
    /** 修改歌单信息失败 */
    UPDATE_MUSICLISTINFO_FAILED(1010, "修改歌单信息失败"),


    /** 评论信息不存在 */
    NOT_FOUND_COMMENT(2001, "评论信息不存在"),
    /** 保存评论失败，请查看日志 */
    SAVE_COMMENTS_FAILED(2002, "保存评论失败，请查看日志"),


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
