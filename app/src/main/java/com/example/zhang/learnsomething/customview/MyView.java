package com.example.zhang.learnsomething.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 12345 on 2018/7/4.
 */

public class MyView extends View {
    private Paint mPaint;
    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMySize(100,widthMeasureSpec);
        int height = getMySize(100, heightMeasureSpec);
        if(width!=height){
            width = height;
        }
        setMeasuredDimension(width, height);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r = getMeasuredWidth() / 2;//也可以是getMeasuredHeight()/2,本例中我们已经将宽高设置相等了
        //圆心的横坐标为当前的View的左边起始位置+半径
        int centerX = getLeft() + r;
        //圆心的纵坐标为当前的View的顶部起始位置+半径
        int centerY = getTop() + r;
        canvas.drawCircle(centerX, centerY, r, mPaint);
    }

    private int getMySize(int defaultSize, int measureSpec){

        int mSize=defaultSize;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
                mSize = defaultSize;
                break;
            case MeasureSpec.AT_MOST:
                mSize = size;
                break;
            case MeasureSpec.EXACTLY:
                mSize = size;
                break;
            default:
                break;
        }
        return mSize;
    }
}
