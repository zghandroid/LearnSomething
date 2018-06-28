package com.example.zhang.learnsomething.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.zhang.learnsomething.R;
import com.example.zhang.learnsomething.base.BaseFragment;
import com.example.zhang.learnsomething.model.Android;
import com.example.zhang.learnsomething.network.BaseObserver;
import com.example.zhang.learnsomething.network.HTTPCall;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AllFragment extends BaseFragment {

    @InjectView(R.id.iv)
    ImageView iv;

    @Override
    protected void initView() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        ButterKnife.inject(this, view);
        HTTPCall call=new HTTPCall();
        call.getData("all", 20, 2, new BaseObserver<Android>(getContext(),false) {
            @Override
            public void onSuccess(List<Android> data) {
//               Glide.with(getContext()).load(android.getUrl()).into(iv);

            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
