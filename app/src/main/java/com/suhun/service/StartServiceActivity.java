package com.suhun.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class StartServiceActivity extends AppCompatActivity {
    private String tag = StartServiceActivity.class.getSimpleName();
    private SeekBar seekBar;
    private TextView countResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);
        initView();
    }

    private void initView(){
        seekBar = findViewById(R.id.lid_seekBar);
        countResult = findViewById(R.id.lid_counterResult);
    }

    public void startStartService(View view){
        Intent intent = new Intent(this, MyStartService.class);
        startService(intent);
    }

    public void stopStartService(View view){
        Intent intent = new Intent(this, MyStartService.class);
        stopService(intent);
    }

    public void finishStartService(View view){
        Intent intent = new Intent(this, MyStartService.class);
        stopService(intent);
        finish();
    }
}