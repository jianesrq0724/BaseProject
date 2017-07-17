package com.ruiqin.baseproject;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.blankj.utilcode.util.Utils;
import com.ruiqin.baseproject.crash.CrashHandler;
import com.ruiqin.baseproject.greendao.gen.DaoMaster;
import com.ruiqin.baseproject.greendao.gen.DaoSession;
import com.ruiqin.baseproject.util.LogUtils;
import com.tencent.smtt.sdk.QbSdk;

import org.greenrobot.greendao.database.Database;

import retrofit2.http.HEAD;

/**
 * Created by Ruiqin on 2017/6/26.
 */

public class App extends Application {
    private static Context mContext;
    private static App app;
    private DaoSession daoSession;
    public static String mobileNum;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        mContext = getApplicationContext();
        Utils.init(mContext);

        /**
         * 初始化数据库
         */
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(mContext, "test-db");
        Database writableDb = devOpenHelper.getWritableDb();
        daoSession = new DaoMaster(writableDb).newSession();

<<<<<<<HEAD
        initCrashHandler();
=======
        initX5Environment();//x5内核初始化接口
>>>>>>> remotes/origin/develop
    }

    /**
     * x5内核初始化接口
     */
    private void initX5Environment() {
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                LogUtils.e("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }


    public static final Context getContext() {
        return mContext;
    }

    public static final App getApp() {
        return app;
    }

    private void initCrashHandler() {
        //设置该CrashHandler为程序的默认处理器
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
    }

}
