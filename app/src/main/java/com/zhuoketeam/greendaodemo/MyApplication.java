package com.zhuoketeam.greendaodemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by Long
 * on 2016/12/1.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        GreenDaoManager.getInstance();
    }

    public static Context getContext() {
        return mContext;
    }
}
