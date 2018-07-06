package com.example.zhang.learnsomething.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by 12345 on 2018/7/3.
 */

public class MyIntentSevice extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentSevice() {
        super("MyIntentSevice");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String taskName=intent.getExtras().getString("taskName");
        switch (taskName){
            case "task1":
                Log.e("service", "do task1");
                break;
            case "task2":
                Log.e("service", "do task2");
                break;
            default:
                break;
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("service", "执行了onCreate");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.e("service", "执行了onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("service", "执行了onDestroy");
    }
}
