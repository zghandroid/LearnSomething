package com.example.zhang.learnsomething;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.zhang.learnsomething.base.BaseActivity;
import com.example.zhang.learnsomething.base.MyApplication;
import com.example.zhang.learnsomething.utils.ScreeUtil;

import butterknife.ButterKnife;

/**
 * Created by 12345 on 2018/7/9.
 */

public class WelcomeActivity extends BaseActivity {
    @Override
    public void initView() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        MyApplication.getInstance().addActiovity(this);
        setContentView(R.layout.title_layout);
        ButterKnife.inject(this);
        initView();
    }
    private void popupShow(View view){
        int density = (int) ScreeUtil.getDeviceDensity(this);

    }
}
