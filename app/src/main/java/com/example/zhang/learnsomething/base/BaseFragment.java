package com.example.zhang.learnsomething.base;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by 12345 on 2018/3/29.
 */

public abstract class BaseFragment extends Fragment {
    protected abstract void initView(View view);
    private Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    public Activity getmActivity() {
        return mActivity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);

    }
}
