package com.example.zhang.learnsomething.customview;

import android.content.Context;
import android.view.MotionEvent;

/**
 * Created by 12345 on 2018/7/26.
 */

public abstract class BaseGestureDetector {

    protected boolean mGestureInProgress;
    protected MotionEvent mPreMotionEvent;
    protected MotionEvent mCurrentMotionEvent;
    protected Context context;

    public BaseGestureDetector(Context context) {
        this.context = context;
    }

    public boolean onTouchEvent(MotionEvent event){

        if (!mGestureInProgress) {
            handlerStartProgressEvent(event);
        }else {
            handlerInProgressEvent(event);
        }
        return true;
    }

    protected abstract void handlerInProgressEvent(MotionEvent event);

    protected abstract void handlerStartProgressEvent(MotionEvent event);

    protected abstract void updateStartProgressEvent(MotionEvent event);


    protected void resetState(){
        if(mPreMotionEvent!=null){

            mPreMotionEvent.recycle();
            mPreMotionEvent=null;
        }
        if(mCurrentMotionEvent!=null){

            mCurrentMotionEvent.recycle();
            mCurrentMotionEvent = null;
        }
        mGestureInProgress = false;
    }
}
