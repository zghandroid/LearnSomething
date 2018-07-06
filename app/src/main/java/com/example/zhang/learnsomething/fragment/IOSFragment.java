package com.example.zhang.learnsomething.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.zhang.learnsomething.R;
import com.example.zhang.learnsomething.base.BaseFragment;
import com.example.zhang.learnsomething.service.MyBinder;
import com.example.zhang.learnsomething.service.MyService;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static android.content.Context.BIND_AUTO_CREATE;

public class IOSFragment extends BaseFragment implements View.OnClickListener {

    @InjectView(R.id.start_service)
     Button startSevice;
    @InjectView(R.id.stop_service)
     Button stopSevice;
    @InjectView(R.id.bind_service)
    Button bindService;
    @InjectView(R.id.unbind_service)
    Button unbindService;
    private MyBinder binder;

    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            binder= (MyBinder) service;
            binder.service_connect_Activity();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void initView(View view) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_io, container, false);
        ButterKnife.inject(this,view);
        startSevice.setOnClickListener(this);
        stopSevice.setOnClickListener(this);
        bindService.setOnClickListener(this);
        unbindService.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_service:
                Intent startIntent=new Intent(getmActivity(), MyService.class);
                getmActivity().startService(startIntent);
                break;
            case R.id.stop_service:
                Intent stopIntent=new Intent(getmActivity(), MyService.class);
                getmActivity().stopService(stopIntent);
                break;
            case R.id.bind_service:
                Intent bindIntent=new Intent(getmActivity(), MyService.class);
                getmActivity().bindService(bindIntent,connection,BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                getmActivity().unbindService(connection);
                break;

        }
    }
}
