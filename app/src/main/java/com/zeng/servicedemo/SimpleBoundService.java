package com.zeng.servicedemo;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class SimpleBoundService extends BaseService {
    private final IBinder mBinder = new LocalBinder();

    public SimpleBoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public String getTag() {
        return "SimpleBoundService";
    }

    public class LocalBinder extends Binder {
        SimpleBoundService getService() {
            return SimpleBoundService.this;
        }
    }

}
