package com.example.zhang.learnsomething.network;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.zhang.learnsomething.model.Result;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract class BaseObserver<T> implements Observer<Result<T>> {
    private final String TAG = BaseObserver.class.getSimpleName();
    private final int RESPONSE_CODE_OK = 0;       //自定义的业务逻辑，成功返回积极数据
    private final int RESPONSE_CODE_FAILED = -1;  //返回数据失败,严重的错误
    private Context mContext;
    private static Gson gson = new Gson();
    private int errorCode;
    private String errorMsg = "未知的错误！";

    /**
     * 根据具体的Api 业务逻辑去重写 onSuccess 方法！Error 是选择重写，but 必须Super ！
     *
     */
    public abstract void onSuccess(List<T> data);

    /**
     * @param mContext
     * @param showProgress 默认需要显示进程，不要的话请传 false
     */
    public  BaseObserver(Context mContext, boolean showProgress) {
        this.mContext = mContext;
        if (showProgress) {
            //HttpUiTips.showDialog(mContext, true, null);
        }
    }
    @Override
    public final void onSubscribe(Disposable d) {
        //dddddddddddddd
    }

    @Override
    public final void onNext(Result<T> response) {
//        HttpUiTips.dismissDialog(mContext);
        if (!response.isError()) {
            onSuccess(response.getResults());
        } else {
            onFailure(!response.isError());
        }
    }

    @Override
    public final void onError(Throwable t) {
//        HttpUiTips.dismissDialog(mContext);
//        if (t instanceof HttpException) {
//            HttpException httpException = (HttpException) t;
//            errorCode = httpException.code();
//            errorMsg = httpException.getMessage();
//            getErrorMsg(httpException);
//        } else if SocketTimeoutException) {  //VPN open
//            errorCode = RESPONSE_CODE_FAILED;
//            errorMsg = "服务器响应超时";
//        }

        // .....其他的异常处理
        onFailure(true);
    }

    /**
     * 简单的把Dialog 处理掉
     */
    @Override
    public final void onComplete() {
    }

    /**
     * Default error dispose!
     * 一般的就是 AlertDialog 或 SnackBar
     *
     */
    @CallSuper  //if overwrite,you should let it run.
    public void onFailure(boolean isError) {
        if (isError) {
            //HttpUiTips.alertTip(mContext, message, code);
            Toast.makeText(mContext, "请求失败",Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 对通用问题的统一拦截处理
     * @param code
     */
    private final void disposeEorCode(String message, int code) {
        switch (code) {
            case 101:
            case 401:
                //退回到登录页面
//                Intent intent = new Intent();
//                intent.setClass(mContext, LoginActivity.class);
//                mContext.startActivity(intent);
                break;
        }
        Toast.makeText(mContext, message + "   code=" + code, Toast.LENGTH_SHORT).show();
    }


    /**
     * 获取详细的错误的信息 errorCode,errorMsg ,   这里和Api 结构有关，这里和Api 结构有关 ！
     * 以登录的时候的Grant_type 故意写错为例子,http 应该是直接的返回401=httpException.code()
     * 但是是怎么导致401的？我们的服务器会在respose.errorBody 中的content 中说明
     */
    private final void getErrorMsg(HttpException httpException) {
        String errorBodyStr = "";
//        try {   //我们的项目需要的UniCode转码，不是必须要的！
//            errorBodyStr = TextUtils.convertUnicode(httpException.response().errorBody().string());
//        } catch (IOException ioe) {
//            Log.e("errorBodyStr ioe:", ioe.toString());
//        }
//        try {
//            HttpResponse errorResponse = gson.fromJson(errorBodyStr, HttpResponse.class);
//            if (null != errorResponse) {
//                errorCode = errorResponse.getCode();
//                errorMsg = errorResponse.getError();
//            } else {
//                errorCode = RESPONSE_CODE_FAILED;
//                errorMsg = "ErrorResponse is null";
//            }
//        } catch (Exception jsonException) {
//            errorCode = RESPONSE_CODE_FAILED;
//            errorMsg = "http请求错误Json 信息异常";
//            jsonException.printStackTrace();
//        }
    }

}