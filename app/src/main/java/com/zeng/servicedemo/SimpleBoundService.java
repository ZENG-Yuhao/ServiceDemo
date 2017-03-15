package com.zeng.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class SimpleBoundService extends Service {
    private final IBinder mBinder = new LocalBinder();

    public SimpleBoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class LocalBinder extends Binder {
        SimpleBoundService getService() {
            return SimpleBoundService.this;
        }
    }

}
