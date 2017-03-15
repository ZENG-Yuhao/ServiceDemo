package com.zeng.servicedemo;

import android.content.Intent;
import android.media.MediaDrm.MediaDrmStateException;
import android.os.Binder;
import android.os.IBinder;

import java.util.Stack;

public class SimpleBoundService extends BaseService {
    private final IBinder mBinder = new LocalBinder();
    private final Stack<String> mStack = new Stack<>();

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

    public void upload(String msg) {
        mStack.push(msg);
    }

    public String download() {
        if (mStack.isEmpty())
            return "Stack is empty.";
        else
            return mStack.pop();
    }
}
