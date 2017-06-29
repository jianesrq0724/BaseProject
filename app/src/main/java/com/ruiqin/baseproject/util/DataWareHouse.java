package com.ruiqin.baseproject.util;

import com.ruiqin.baseproject.App;

/**
 * Created by ruiqin.shen
 * 类说明：数据仓库
 */

public class DataWareHouse {

    /**
     * 设置手机号码
     *
     * @param mobileNum
     */
    public static void setMobileNum(String mobileNum) {
        App.mobileNum = mobileNum;
    }

    /**
     * 获取手机号码
     */
    public static String getMobileNum() {
        return App.mobileNum;
    }

}
