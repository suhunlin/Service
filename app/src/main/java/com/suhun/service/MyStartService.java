package com.suhun.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyStartService extends Service {
    private String tag = MyStartService.class.getSimpleName();
    public MyStartService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(tag, "-----#####MyStartService onBind #####-----");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(tag, "-----#####MyStartService onCreate #####-----");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(tag, "-----#####MyStartService onStartCommand #####-----");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(tag, "-----#####MyStartService onDestroy #####-----");
    }
}