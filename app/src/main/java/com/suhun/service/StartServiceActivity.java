package com.suhun.service;

import androidx.appcompat.app.AppCompatActivity;

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

    }

    public void stopStartService(View view){

    }

    public void finishStartService(View view){
        finish();
    }
}