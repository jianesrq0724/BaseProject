package com.ruiqin.baselibrary.util;

import android.content.Context;

import com.ruiqin.baselibrary.crash.CrashHandler;
import com.tencent.smtt.sdk.QbSdk;

/**
 * @author Carl
 * @version 1.0
 * @since 2018/3/8
 */

public class Utils {
    private static Context sContext;

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...baseLibray");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        Utils.sContext = context.getApplicationContext();
        initCrashHandler(context);
        //x5内核初始化接口
        initX5Environment(context);
    }

    private static void initCrashHandler(Context context) {
        //设置该CrashHandler为程序的默认处理器
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(context);
    }


    /**
     * x5内核初始化接口
     */
    private static void initX5Environment(Context context) {
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                LogUtils.e("myApplication", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(context, cb);
    }


    public static Context getContext() {
        if (sContext != null) {
            return sContext;
        }
        throw new NullPointerException("u should init first baseLibray");
    }
}
