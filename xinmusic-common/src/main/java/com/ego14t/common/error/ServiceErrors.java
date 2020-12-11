package com.ego14t.common.error;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2020/12/11 10:19
 * Description:
 */
public interface ServiceErrors {

    /**
     * 获取状态码
     * @return Integer
     */
    Integer getCode();

    /**
     * 获取状态信息
     * @return String
     */
    String getMessage();

}
