package com.zeng.servicedemo;

import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class SimpleStartedService extends BaseService {
    private boolean isStopRequest = false;

    public SimpleStartedService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        Log.d(getTag(), "onStartCommand() --> startId : " + startId);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d(getTag(), "Thread" + startId + " slept " + i + "s");
                    if (isStopRequest)
                        break;
                }
                Log.d(getTag(), "Thread" + startId + " is going to stop");
                stopSelf(startId);
            }
        }).start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public String getTag() {
        return "SimpleStartedService";
    }
}
