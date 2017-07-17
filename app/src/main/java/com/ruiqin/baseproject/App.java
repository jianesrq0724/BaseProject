package com.ruiqin.baseproject;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.blankj.utilcode.util.Utils;
import com.ruiqin.baseproject.crash.CrashHandler;
import com.ruiqin.baseproject.greendao.gen.DaoMaster;
import com.ruiqin.baseproject.greendao.gen.DaoSession;

import org.greenrobot.greendao.database.Database;

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

        initCrashHandler();
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
