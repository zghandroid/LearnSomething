package com.example.zhang.learnsomething.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 12345 on 2018/8/6.
 */

public class ImitateKeepButton extends View {

    private Paint cyclePaint;
    private Paint ringPaint;
    private Paint textPaint;
    private boolean isChange;
    public ImitateKeepButton(Context context) {
        this(context,null);
    }

    public ImitateKeepButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ImitateKeepButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        cyclePaint = new Paint();
        cyclePaint.setColor(Color.BLUE);
        ringPaint = new Paint();
        ringPaint.setColor(Color.RED);
        textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(25);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 120, ringPaint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 100, cyclePaint);
        canvas.drawText("测试", getWidth() / 2-25, getHeight() / 2, textPaint);
        if(isChange){
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, 120, ringPaint);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, 80, cyclePaint);
            canvas.drawText("点击", getWidth() / 2-25, getHeight() / 2, textPaint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widhtMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                isChange = true;
                postInvalidate();
                break;
            case MotionEvent.ACTION_UP:
                isChange = false;
                postInvalidate();
                break;
            default:
                break;
        }
        return true;
    }
}
