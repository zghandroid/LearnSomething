package com.example.zhang.learnsomething.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.zhang.learnsomething.MainActivity;
import com.example.zhang.learnsomething.R;
import com.example.zhang.learnsomething.fragment.IOSFragment;

/**
 * Created by 12345 on 2018/7/2.
 */

public class MyService extends Service {
    private MyBinder binder=new MyBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("service", "执行了onBind");
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("service", "执行了onCreate");
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification.Builder builder = new Notification.Builder(this);
        Notification.Builder builer = new Notification.Builder(this);
        builer.setContentTitle("前台服务通知的标题");//设置通知的标题
        builer.setContentText("前台服务通知的内容");//设置通知的内容
        builer.setSmallIcon(R.mipmap.ic_launcher);//设置通知的图标
        builer.setContentIntent(pendingIntent);//设置点击通知后的操作
        Notification notification=builder.getNotification();
        startForeground(1, notification);


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("service", "执行了onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("service", "执行了onDestroy");

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("service", "执行了onUnbind()");
        return super.onUnbind(intent);
    }
}
