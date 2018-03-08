package com.ruiqin.baselibrary.util;


import com.ruiqin.baselibrary.network.ApiException;

import java.net.ConnectException;


/**
 * Created by ruiqin.shen
 * 类说明：
 */

public class NetWorkErrorUtils {
    public static void error(Throwable throwable) {
        //不是自定义的异常，进行网络提示
        if (!(throwable instanceof ApiException)) {
            //连接异常
            if (throwable instanceof ConnectException) {
                ToastUtils.showShort("当前网络不可用，请检查网络设置");
            } else {
                ToastUtils.showShort("连接服务器超时，请稍后再试。。");
            }
        }
    }
}
