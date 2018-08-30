package com.example.zhang.learnsomething.fragment;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zhang.learnsomething.R;
import com.example.zhang.learnsomething.adapter.TestRecycleViewAdapter;
import com.example.zhang.learnsomething.base.BaseFragment;
import com.example.zhang.learnsomething.customview.DividerItemDecoration;
import com.example.zhang.learnsomething.model.Android;
import com.example.zhang.learnsomething.network.BaseObserver;
import com.example.zhang.learnsomething.network.HTTPCall;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AllFragment extends BaseFragment {

    @InjectView(R.id.iv)
    RecyclerView iv;
    private List<String> data;
    private TestRecycleViewAdapter adapter;

    @Override
    protected void initView(View view) {


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        ButterKnife.inject(this, view);
        initData();

        iv.setLayoutManager(new LinearLayoutManager(getmActivity()));
        iv.setAdapter(adapter=new TestRecycleViewAdapter(getmActivity(), data));
        iv.addItemDecoration(new DividerItemDecoration(getmActivity(), DividerItemDecoration.VERTICAL_LIST));

//        HTTPCall call=new HTTPCall();
//        call.getData("福利", 20, 2, new BaseObserver<Android>(getContext(),false) {
//            @Override
//            public void onSuccess(List<Android> data) {
//                Glide.with(getContext()).load(data.get(0).getUrl()).into(iv);
//
//            }
//        });
        return view;
    }

    private void initData() {
        data = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++)
        {
            data.add("" + (char) i);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
