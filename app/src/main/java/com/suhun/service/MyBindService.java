package com.suhun.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBindService extends Service {
    private String tag = MyBindService.class.getSimpleName();

    public final Binder mBinder = new LocalBindService();
    public boolean isBinder = false;

    public class LocalBindService extends Binder{
        MyBindService getService(){
            Log.d(tag, "-----#####MyBindService getService #####-----");
            return MyBindService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(tag, "-----#####MyBindService onBind #####-----");
        isBinder = true;
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(tag, "-----#####MyBindService onUnbind #####-----");
        isBinder = false;
        return super.onUnbind(intent);
    }

    public void getName(){
        Log.d(tag, "-----Success!My name is Happy-----") ;
    }
}