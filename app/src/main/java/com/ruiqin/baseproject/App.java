package com.ruiqin.baseproject;

import android.app.Application;
import android.content.Context;

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

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        app = this;

        /**
         * 初始化数据库
         */
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(mContext, "test-db");
        Database writableDb = devOpenHelper.getWritableDb();
        daoSession = new DaoMaster(writableDb).newSession();
    }

    protected static final Context getContext() {
        return mContext;
    }

    public static final App getApp() {
        return app;
    }

//    public static
}
