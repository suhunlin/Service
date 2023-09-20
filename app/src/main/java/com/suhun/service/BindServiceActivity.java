package com.suhun.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class BindServiceActivity extends AppCompatActivity {
    private String tag = BindServiceActivity.class.getSimpleName();
    private MyBindService myBindService;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(tag, "-----@@@@@BindServiceActivity onServiceConnected @@@@@-----");
            MyBindService.LocalBindService binder = (MyBindService.LocalBindService)service;
            myBindService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(tag, "-----@@@@@BindServiceActivity onServiceDisconnected @@@@@-----");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
    }

    public void startBindServiceFun(View view){
        Intent intent = new Intent(this, MyBindService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void stopBindServiceFun(View view){
        unbindService(serviceConnection);
    }

    public void getNameFromBindServiceFun(View view){
        myBindService.getName();
    }

    public void finishBindServiceFun(View view){
        finish();
    }
}