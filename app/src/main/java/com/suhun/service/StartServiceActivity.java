package com.suhun.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class StartServiceActivity extends AppCompatActivity {
    private String tag = StartServiceActivity.class.getSimpleName();
    private SeekBar seekBar;
    private TextView countResult;
    private MyReceiver myReceiver = new MyReceiver();

    private class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            int maxSeekBare = intent.getIntExtra("maxCountValue", -1);
            int counterValue = intent.getIntExtra("counterValue", -1);
            int setCounterZero = intent.getIntExtra("setCounterZero", -1);
            if(maxSeekBare>0){
                seekBar.setMax(maxSeekBare);
            }
            if(counterValue>-1){
                seekBar.setProgress(counterValue);
                countResult.setText(""+counterValue);
            }
            if(setCounterZero>-1){
                seekBar.setProgress(setCounterZero);
                countResult.setText(""+setCounterZero);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("suhun");
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
    }

    private void initView(){
        seekBar = findViewById(R.id.lid_seekBar);
        countResult = findViewById(R.id.lid_counterResult);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    Intent intent = new Intent(StartServiceActivity.this, MyStartService.class);
                    intent.putExtra("userChange", progress);
                    startService(intent);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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