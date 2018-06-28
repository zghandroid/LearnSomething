package com.example.zhang.learnsomething.reciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by 12345 on 2018/6/4.
 */

public class MyReciver extends BroadcastReceiver {
    private static final String TAG = "MyReciver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "network state changed.");
        if (!isNetworkAvailable(context)) {
            Toast.makeText(context, "网络关闭", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * 网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager mgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info = mgr.getAllNetworkInfo();
        if (info != null) {
            for (int i = 0; i < info.length; i++) {
                if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }
}
