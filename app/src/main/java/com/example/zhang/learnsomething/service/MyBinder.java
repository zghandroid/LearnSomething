package com.example.zhang.learnsomething.service;

import android.os.Binder;
import android.util.Log;

/**
 * Created by 12345 on 2018/7/3.
 */

public class MyBinder extends Binder {
    public void service_connect_Activity() {
        Log.e("service", "Service关联了Activity,并在Activity执行了Service的方法");
    }
}
