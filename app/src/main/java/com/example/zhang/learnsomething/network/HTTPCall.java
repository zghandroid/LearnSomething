package com.example.zhang.learnsomething.network;

import android.content.Context;
import android.util.Log;

import com.example.zhang.learnsomething.base.BaseFragment;
import com.example.zhang.learnsomething.model.Android;
import com.example.zhang.learnsomething.model.Result;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 12345 on 2018/3/30.
 */

public class HTTPCall {
    public static final String BASE_URL = "http://gank.io/api/";

    private static Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    public  void getData(String type,int page,int number,BaseObserver<Android> baseObserver){
        APIService service = retrofit.create(APIService.class);
        service.getData(type,page,number)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseObserver);
    }
}
