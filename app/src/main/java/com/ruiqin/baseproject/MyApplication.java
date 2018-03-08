package com.ruiqin.baseproject;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.ruiqin.baselibrary.util.Utils;
import com.ruiqin.baseproject.greendao.gen.DaoMaster;
import com.ruiqin.baseproject.greendao.gen.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Ruiqin on 2017/6/26.
 */

public class MyApplication extends Application {
    private static Context mContext;
    private DaoSession daoSession;

//    {
//        PlatformConfig.setWeixin("wx4ce204c32f3c2181", "e5f37f10f34601a3e2d8516e8c09c834");
//        PlatformConfig.setQQZone("1106116934", "dcPiNHxCFboZmfuj");
//    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        Utils.init(mContext);


        //友盟初始化
//        UMShareAPI.get(this);

        /**
         * 初始化数据库
         */
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(mContext, "test-db");
        Database writableDb = devOpenHelper.getWritableDb();
        daoSession = new DaoMaster(writableDb).newSession();

    }


    /**
     * 获得上下文
     */
    public static Context getAppContext() {
        return mContext;
    }


}
