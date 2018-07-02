package com.example.zhang.learnsomething.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 12345 on 2018/6/29.
 */

public class BanAdapter extends PagerAdapter {
    private List<View> views;

    public BanAdapter(List<View> views){
        this.views = views;
    }
    @Override
    public int getCount() {
        return views!=null?views.size():0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(views.get(position));
    }
}
