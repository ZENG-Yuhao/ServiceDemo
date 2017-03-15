package com.zeng.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;

/**
 * <p>
 * Created by ZENG Yuhao. <br>
 * Contact: enzo.zyh@gmail.com
 * </p>
 */

public abstract class BaseService extends Service {
    @Override
    public void onCreate() {
        Log.d(getTag(), "onCreate() --> ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(getTag(), "onStartCommand() --> ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(getTag(), "onDestroy() --> ");
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d(getTag(), "onConfigurationChanged() --> ");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(getTag(), "onUnbind() --> ");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(getTag(), "onRebind() --> ");
        super.onRebind(intent);
    }



    public abstract String getTag();
}
