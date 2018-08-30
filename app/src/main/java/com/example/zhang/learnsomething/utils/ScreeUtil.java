package com.example.zhang.learnsomething.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by 12345 on 2018/7/9.
 */

public class ScreeUtil {


    /**
     * 获取屏幕相关参数
     * @param context
     * @return
     */
    public static DisplayMetrics getScreenSize(Context context){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(displayMetrics);
        return displayMetrics;
    }

    /**
     * 获取屏幕density
     * @param context
     * @return
     */
    public static float getDeviceDensity(Context context) {
        DisplayMetrics displayMetrics=getScreenSize(context);
        return displayMetrics.density;
    }
}
