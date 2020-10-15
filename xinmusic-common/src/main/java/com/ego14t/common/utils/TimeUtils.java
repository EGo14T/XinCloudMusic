package com.ego14t.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create By 王富昕
 * Date ：Created in 2019/8/28 14:50
 * Description：
 */
public class TimeUtils {

    public String TimeFormatForDatabase(String timeFromOuter) throws ParseException {

        Date sentTime = new SimpleDateFormat("yyyyMMddHHmmss").parse(timeFromOuter);
        //把yyyyMMddHHmmss-->yyyy-MM-dd HH:mm:ss  方便存放数据库
        DateFormat myformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return myformat.format(sentTime);
    }


    public Date TimeFormatForOAuth(String timeFromOuter) throws ParseException {
        return new SimpleDateFormat("yyyyMMddHHmmss").parse(timeFromOuter);
    }

    /**
     * @param formatting 格式  yyy-MM-dd HH:mm:ss
     *                         yyy-MM-dd HH:mm
     *                         yyy-MM-dd
     * @return 传入数据库的当前时间
     * @return 传入数据库的当前时间
     */
    public String nowTimeFormatForDatabase(String formatting){
        DateFormat myformat = new SimpleDateFormat(formatting);
        Date date = new Date();
        return myformat.format(date);
    }

}
