package com.ego14t.xinmusic.newentity;

/**
 * @author wangfx
 * @date 2020/11/13 12:02
 */
public class MusicListEntity extends BaseEntity{

    private static final long serialVersionUID = 3491993984019699982L;

    /**
     * 歌单ID
     */
    private String musiclistId;

    /**
     * 创建者ID
     */
    private String createUserId;

    /**
     * 歌单名称
     */
    private String musiclistName;

    /**
     * 歌单tags
     */
    private String tags;

    /**
     * 歌单描述
     */
    private String description;

    /**
     * 歌单封面图
     */
    private String musiclistImg;

    /**
     * 歌单状态 0-默认歌单（不能删除） 1-正常歌单 2-隐私歌单
     */
    private Integer status;

    public String getMusiclistId() {
        return musiclistId;
    }

    public void setMusiclistId(String musiclistId) {
        this.musiclistId = musiclistId;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getMusiclistName() {
        return musiclistName;
    }

    public void setMusiclistName(String musiclistName) {
        this.musiclistName = musiclistName;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMusiclistImg() {
        return musiclistImg;
    }

    public void setMusiclistImg(String musiclistImg) {
        this.musiclistImg = musiclistImg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
