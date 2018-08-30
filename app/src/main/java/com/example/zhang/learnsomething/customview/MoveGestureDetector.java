package com.example.zhang.learnsomething.customview;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/**
 * Created by 12345 on 2018/7/27.
 */

public class MoveGestureDetector extends BaseGestureDetector {

    private PointF mCurrentPointer;
    private PointF mPrePointer;

    private PointF mDeletePointer = new PointF();

    private PointF mExtenalPointer = new PointF();

    private OnMoveGestureListener onMoveGestureListener;

    public MoveGestureDetector(Context context,OnMoveGestureListener listener) {
        super(context);
        onMoveGestureListener = listener;
    }

    @Override
    protected void handlerInProgressEvent(MotionEvent event) {

        int actionCode = event.getAction() & MotionEvent.ACTION_MASK;
        switch (actionCode) {
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                onMoveGestureListener.onMoveEnd(this);
                resetState();
                break;
            case MotionEvent.ACTION_MOVE:
                updateStartProgressEvent(event);
                boolean update = onMoveGestureListener.onMove(this);
                if(update){

                    mPreMotionEvent.recycle();
                    mPreMotionEvent = MotionEvent.obtain(event);
                }
                break;
        }

    }

    @Override
    protected void handlerStartProgressEvent(MotionEvent event) {

        int actionCode = event.getAction() & MotionEvent.ACTION_MASK;
        switch (actionCode) {
            case MotionEvent.ACTION_DOWN:
                resetState();
                mPreMotionEvent = MotionEvent.obtain(event);
                updateStartProgressEvent(event);
                break;
            case MotionEvent.ACTION_MOVE:
                mGestureInProgress = onMoveGestureListener.onMoveBegin(this);
                break;

        }


    }

    @Override
    protected void updateStartProgressEvent(MotionEvent event) {

        final MotionEvent prev = mPreMotionEvent;
        mPrePointer =caculateFocalPointer(prev);
        mCurrentPointer = caculateFocalPointer(event);

        boolean mSkipThisMoveEvent = prev.getPointerCount() != event.getPointerCount();

        //Log.e("TAG", "mSkipThisMoveEvent = " + mSkipThisMoveEvent);
        mExtenalPointer.x = mSkipThisMoveEvent ? 0 : mCurrentPointer.x - mPrePointer.x;
        mExtenalPointer.y = mSkipThisMoveEvent ? 0 : mCurrentPointer.y - mPrePointer.y;

    }

    /**
     * 根据event计算多指中心点
     *
     * @param event
     * @return
     */
    private PointF caculateFocalPointer(MotionEvent event)
    {
        final int count = event.getPointerCount();
        float x = 0, y = 0;
        for (int i = 0; i < count; i++)
        {
            x += event.getX(i);
            y += event.getY(i);
        }

        x /= count;
        y /= count;

        return new PointF(x, y);
    }


    public float getMoveX()
    {
        return mExtenalPointer.x;

    }

    public float getMoveY()
    {
        return mExtenalPointer.y;
    }
    public interface OnMoveGestureListener
    {
        public boolean onMoveBegin(MoveGestureDetector detector);

        public boolean onMove(MoveGestureDetector detector);

        public void onMoveEnd(MoveGestureDetector detector);
    }

    public static class SimpleMoveGestureDetector implements OnMoveGestureListener
    {

        @Override
        public boolean onMoveBegin(MoveGestureDetector detector)
        {
            return true;
        }

        @Override
        public boolean onMove(MoveGestureDetector detector)
        {
            return false;
        }

        @Override
        public void onMoveEnd(MoveGestureDetector detector)
        {
        }
    }
}
