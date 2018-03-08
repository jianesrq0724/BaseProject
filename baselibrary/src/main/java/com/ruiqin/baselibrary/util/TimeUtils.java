package com.ruiqin.baselibrary.util;

import java.text.SimpleDateFormat;

/**
 * ===============================================
 * <p>
 * 类描述:
 * <p>
 * 创建人: Eric_Huang
 * <p>
 * 创建时间: 2016/9/21 17:55
 * <p>
 * 修改人:Eric_Huang
 * <p>
 * 修改时间: 2016/9/21 17:55
 * <p>
 * 修改备注:
 * <p>
 * ===============================================
 */
public class TimeUtils {

    /**
     * @param millisecond 毫秒值
     * @return 转化成的时间
     */
    public static String getTotalTimeDHM(long millisecond) {
        return "";
    }

    /**
     * 毫秒转化成日时分
     */
    public static String formatTime(long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;

        StringBuilder sb = new StringBuilder();
        if (day > 0) {
            sb.append(day).append("天");
        }
        if (hour > 0) {
            sb.append(hour).append("时");
        }
        if (minute > 0) {
            sb.append(minute).append("分");
        }
        return sb.toString();
    }


    public static String TimeFormat3Date(long millisecond) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        return simpleDateFormat.format(millisecond);
    }

    public static String TimeFormat2DataV2(long millisecond) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(millisecond);
    }

    public static String TimeFormat2DataV3(long millisecond) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(millisecond);
    }

    /**
     * 转换成小时分钟
     */
    public static String TimeFormat2HM(long millisecond) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        return simpleDateFormat.format(millisecond);
    }

    public static String TimeFormat2MS(long millisecond) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        return simpleDateFormat.format(millisecond);
    }

}
