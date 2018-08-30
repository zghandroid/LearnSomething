package com.example.zhang.learnsomething;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;
import com.example.zhang.learnsomething.adapter.VPAdapter;
import com.example.zhang.learnsomething.base.BaseActivity;
import com.example.zhang.learnsomething.base.MyApplication;
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
        MyApplication.getInstance().addActiovity(this);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initView();

        startActivity(new Intent(this,TestBitmapActivity.class));
//        testIntentService();
//        testContentProivder();
    }

    private void testContentProivder() {
        /**
         * 对user表进行操作
         */

        // 设置URI
        Uri uri_user = Uri.parse("content://cn.zhang.test/user");

        // 插入表中数据
        ContentValues values = new ContentValues();
        values.put("_id", 3);
        values.put("name", "Iverson");


        // 获取ContentResolver
        ContentResolver resolver =  getContentResolver();
        // 通过ContentResolver 根据URI 向ContentProvider中插入数据
        resolver.insert(uri_user,values);

        // 通过ContentResolver 向ContentProvider中查询数据
        Cursor cursor = resolver.query(uri_user, new String[]{"_id","name"}, null, null, null);
        while (cursor.moveToNext()){
            Log.e("content","query book:" + cursor.getInt(0) +" "+ cursor.getString(1));
            // 将表中数据全部输出
        }
        cursor.close();
        // 关闭游标

        /**
         * 对job表进行操作
         */
        // 和上述类似,只是URI需要更改,从而匹配不同的URI CODE,从而找到不同的数据资源
        Uri uri_job = Uri.parse("content://cn.zhang.test/job");

        // 插入表中数据
        ContentValues values2 = new ContentValues();
        values2.put("_id", 3);
        values2.put("job", "NBA Player");

        // 获取ContentResolver
        ContentResolver resolver2 =  getContentResolver();
        // 通过ContentResolver 根据URI 向ContentProvider中插入数据
        resolver2.insert(uri_job,values2);

        // 通过ContentResolver 向ContentProvider中查询数据
        Cursor cursor2 = resolver2.query(uri_job, new String[]{"_id","job"}, null, null, null);
        while (cursor2.moveToNext()){
            Log.e("content","query job:" + cursor2.getInt(0) +" "+ cursor2.getString(1));
            // 将表中数据全部输出
        }
        cursor2.close();
        // 关闭游标
    }

    private void testIntentService() {
        // 请求1
        Intent i = new Intent("cn.scu.finch");
        Bundle bundle = new Bundle();
        bundle.putString("taskName", "task1");
        i.putExtras(bundle);
      //  startService(i);

        // 请求2
        Intent i2 = new Intent("cn.scu.finch");
        Bundle bundle2 = new Bundle();
        bundle2.putString("taskName", "task2");
        i2.putExtras(bundle2);
       // startService(i2);

       // startService(i);  //多次启动
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
