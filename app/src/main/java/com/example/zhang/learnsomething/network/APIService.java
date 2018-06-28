package com.example.zhang.learnsomething.network;

import com.example.zhang.learnsomething.model.Android;
import com.example.zhang.learnsomething.model.Result;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by 12345 on 2018/3/30.
 */

public interface APIService {

    /**
     * 获取数据
     * @param type
     * @param page
     * @param num
     * @return
     */
    @GET("data/{type}/{page}/{number}")
    Observable<Result<Android>> getData(@Path("type") String type,@Path("page") int page,@Path("number") int num);


}
