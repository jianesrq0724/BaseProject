package com.ruiqin.baseproject.util;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public class NetWorkErrorUtils {
    public static void error() {
        ToastUtils.showShort("当前网络不可用，请检查网络设置");
    }
}
