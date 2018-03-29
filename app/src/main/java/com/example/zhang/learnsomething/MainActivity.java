package com.example.zhang.learnsomething;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.zhang.learnsomething.adapter.VPAdapter;
import com.example.zhang.learnsomething.base.BaseActivity;
import com.example.zhang.learnsomething.fragment.AllFragment;
import com.example.zhang.learnsomething.fragment.AndroidFragment;
import com.example.zhang.learnsomething.fragment.FuliFragment;
import com.example.zhang.learnsomething.fragment.IOSFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends BaseActivity {

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
    @InjectView(R.id.rg)
    RadioGroup rg;

    private List<Fragment> fragments;
    private VPAdapter vpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initView();
    }

    @Override
    public void initView() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.all:
                        vp.setCurrentItem(0, false);
                        break;
                    case R.id.android:
                        vp.setCurrentItem(1, false);
                        break;
                    case R.id.ios:
                        vp.setCurrentItem(2, false);
                        break;
                    case R.id.fuli:
                        vp.setCurrentItem(3, false);
                        break;
                }
            }
        });
        fragments = new ArrayList<>();
        fragments.add(new AllFragment());
        fragments.add(new AndroidFragment());
        fragments.add(new IOSFragment());
        fragments.add(new FuliFragment());
        vpAdapter = new VPAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(vpAdapter);
        vp.setCurrentItem(0);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    switch (position){
                        case 0:
                            all.setChecked(true);
                            break;
                        case 1:
                            android.setChecked(true);
                            break;
                        case 2:
                            ios.setChecked(true);
                            break;
                        case 3:
                            fuli.setChecked(true);
                            break;
                    }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
