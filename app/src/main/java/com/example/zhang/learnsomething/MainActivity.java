package com.example.zhang.learnsomething;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.vp)
    ViewPager vp;
    @InjectView(R.id.all)
    RadioButton all;
    @InjectView(R.id.android)
    RadioButton android;
    @InjectView(R.id.ios)
    RadioButton ios;
    @InjectView(R.id.fuli)
    RadioButton fuli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }
}
