package com.suhun.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MyStartService extends Service {
    private String tag = MyStartService.class.getSimpleName();
    private Timer timer;
    private int counter, maxValue;
    private class MyTask extends TimerTask{
        @Override
        public void run() {
            if(counter < maxValue){
                counter++;
                Log.d(tag, "-----#####MyStartService counter #####-----"+counter);
                Intent intent = new Intent("suhun");
                intent.putExtra("counterValue", counter);
                sendBroadcast(intent);
            }else {
                cancel();
            }
        }
    }
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
        timer = new Timer();
        counter = 0;
        maxValue = 100;
        Intent intent = new Intent("suhun");
        intent.putExtra("maxCountValue", maxValue);
        sendBroadcast(intent);
        timer.schedule(new MyTask(), 100, 100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(tag, "-----#####MyStartService onStartCommand #####-----");
        int userChange = intent.getIntExtra("userChange", -1);
        if(userChange>0){
            counter = userChange;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(tag, "-----#####MyStartService onDestroy #####-----");
        if(timer!=null){
            timer.cancel();
            timer.purge();
            timer =null;
            counter = 0;
            Intent intent = new Intent("suhun");
            intent.putExtra("setCounterZero", 0);
            sendBroadcast(intent);
        }
    }
}