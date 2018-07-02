package com.example.zhang.learnsomething.base;

import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by 12345 on 2018/3/29.
 */

public abstract class BaseFragment extends Fragment {
    protected abstract void initView(View view);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);

    }
}
