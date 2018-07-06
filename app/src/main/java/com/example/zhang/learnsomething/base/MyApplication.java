package com.example.zhang.learnsomething.base;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 12345 on 2018/7/2.
 */

public class MyApplication extends Application {
    private List<Activity> activitys = new LinkedList<>();

    private static MyApplication instance;
    public MyApplication(){
    }
    public static MyApplication getInstance(){
        if(instance==null){
            instance = new MyApplication();
        }
        return instance;
    }

    public void addActiovity(Activity activity){
        activitys.add(activity);
    }

    public void exit(){
        for(Activity activity:activitys){
            activity.finish();
        }
        System.exit(0);
    }

}
