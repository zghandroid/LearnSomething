package com.example.zhang.learnsomething.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zhang.learnsomething.R;
import com.example.zhang.learnsomething.adapter.BanAdapter;
import com.example.zhang.learnsomething.base.BaseFragment;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class FuliFragment extends BaseFragment {
    @InjectView(R.id.test_banner)
     Banner banner;
    @Override
    protected void initView(View view) {


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fuli, container, false);
        ButterKnife.inject(this, view);
        initView(view);
        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("http://ww1.sinaimg.cn/large/0065oQSqly1frsllc19gfj30k80tfah5.jpg");
        imageUrls.add("http://ww1.sinaimg.cn/large/0065oQSqly1frslibvijrj30k80q678q.jpg");
        imageUrls.add("http://ww1.sinaimg.cn/large/0065oQSqly1frrifts8l5j30j60ojq6u.jpg");
        List<String> titles = new ArrayList<>();
        titles.add("你要的福利1");
        titles.add("你要的福利2");
        titles.add("你要的福利3");
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {

                Glide.with(context).load(path).into(imageView);
            }
        });
        banner.setImages(imageUrls);
        banner.setBannerTitles(titles);
        banner.setIndicatorGravity(BannerConfig.CENTER);//设置指示器位置
        banner.setDelayTime(2000);//设置轮播时间
        banner.start();

        return view;
    }


}
