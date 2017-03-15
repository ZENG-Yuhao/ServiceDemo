package com.zeng.servicedemo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zeng.servicedemo.SimpleBoundService.LocalBinder;

public class SimpleBoundServiceActivity extends AppCompatActivity {
    private Button btn_upload, btn_download;
    private EditText input;
    private TextView output;

    private boolean isServiceBound = false;
    private ServiceConnection mServiceConnection = new MyServiceConnection();
    private SimpleBoundService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_bound_service);

        btn_upload = (Button) findViewById(R.id.btn_upload);
        btn_download = (Button) findViewById(R.id.btn_download);
        input = (EditText) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);

        btn_upload.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String strIn = input.getText().toString();
                if (isServiceBound) {
                    mService.upload(strIn);
                    append(strIn + " uploaded.");
                }
            }
        });

        btn_download.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isServiceBound) {
                    append(mService.download() + " downloaded.");
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent serviceIntent = new Intent(this, SimpleBoundService.class);
        bindService(serviceIntent, mServiceConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(mServiceConnection);
    }

    private void append(String text) {
        String str = output.getText().toString();
        str += "\n" + text;
        output.setText(str);
    }

    private class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mService = ((LocalBinder) iBinder).getService();
            isServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isServiceBound = false;
            mService = null;
        }
    }
}
