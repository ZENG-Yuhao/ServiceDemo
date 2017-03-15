package com.zeng.servicedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent simpleService = new Intent(MainActivity.this, SimpleStartedService.class);
        Button btn_start_simple = (Button) findViewById(R.id.btn_start_simple);
        btn_start_simple.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(simpleService);
            }
        });

        Button btn_stop_simple = (Button) findViewById(R.id.btn_stop_simple);
        btn_stop_simple.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(simpleService);
            }
        });

        final Intent intentService = new Intent(MainActivity.this, SimpleIntentService.class);
        Button btn_start_intent = (Button) findViewById(R.id.btn_start_intent);
        btn_start_intent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                intentService.putExtra("sender", "Sender" + ++count);
                startService(intentService);
            }
        });

        Button btn_stop_intent = (Button) findViewById(R.id.btn_stop_intent);
        btn_stop_intent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intentService);
            }
        });

        Button btn_simple_bound = (Button) findViewById(R.id.btn_simple_bound);
        btn_simple_bound.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SimpleBoundServiceActivity.class);
                startActivity(intent);
            }
        });
    }
}
