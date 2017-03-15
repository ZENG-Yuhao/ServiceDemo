package com.zeng.servicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class SimpleIntentService extends IntentService {

    public SimpleIntentService() {
        super("SimpleIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String sender = "null";
        if (intent != null) {
            sender = intent.getStringExtra("sender");
        }
        Log.d("SimpleIntentService", "Request from " + sender + " is being handled...");
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("SimpleIntentService", "Thread slept " + i + "s");
        }
        Log.d("SimpleIntentService", "Request from " + sender + " is done.");
    }
}
