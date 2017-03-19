package com.huan.administrator.petparadise;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/3/18.
 */
public class MyApp extends Application {
    public static Context mcontext;

    @Override
    public void onCreate() {
        mcontext = this;
        super.onCreate();
    }

}
