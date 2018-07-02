package com.example.zhang.learnsomething.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhang.learnsomething.R;
import com.example.zhang.learnsomething.adapter.BanAdapter;
import com.example.zhang.learnsomething.base.BaseFragment;

public class FuliFragment extends BaseFragment {

    @Override
    protected void initView() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fuli, container, false);
        return view;
    }


}
