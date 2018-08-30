package com.example.zhang.learnsomething.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 12345 on 2018/7/26.
 */

public class LargeImageView extends View {

    private BitmapRegionDecoder decoder;

    /**
     * 图片的高度和宽度
     */
    private int imageHeight,imageWidth;

    /**
     * 绘制的区域
     */
    private volatile Rect mRect = new Rect();

    private MoveGestureDetector detector;

    private static final BitmapFactory.Options options = new BitmapFactory.Options();


    static{
        options.inPreferredConfig = Bitmap.Config.RGB_565;
    }

    public LargeImageView(Context context) {
        this(context,null);
    }

    public LargeImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LargeImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        detector = new MoveGestureDetector(getContext(), new MoveGestureDetector.SimpleMoveGestureDetector()
        {
            @Override
            public boolean onMove(MoveGestureDetector detector)
            {
                int moveX = (int) detector.getMoveX();
                int moveY = (int) detector.getMoveY();

                if (imageWidth > getWidth())
                {
                    mRect.offset(-moveX, 0);
                    checkWidth();
                    invalidate();
                }
                if (imageHeight > getHeight())
                {
                    mRect.offset(0, -moveY);
                    checkHeight();
                    invalidate();
                }

                return true;
            }
        });

    }

    public void setInputStream (InputStream is){

        try {
            decoder = BitmapRegionDecoder.newInstance(is, false);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(is, null, options);
            imageHeight = options.outHeight;
            imageWidth = options.outWidth;

            requestLayout();
            invalidate();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    private void checkWidth(){
        Rect rect = mRect;
        int width = imageWidth;
        int height = imageHeight;
        if(rect.right>width){

            rect.right = width;
            rect.left = width - getWidth();
        }

        if (rect.left<0){
            rect.left = 0;
            rect.right = getWidth();
        }
    }

    private void checkHeight(){

        Rect rect = mRect;
        int height = imageHeight;
        int width = imageWidth;
        if (rect.bottom > height) {
            rect.bottom = height;
            rect.top = height - getHeight();
        }

        if(rect.top<0){

            rect.top = 0;
            rect.bottom = getHeight();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        detector.onTouchEvent(event);
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Bitmap bitmap = decoder.decodeRegion(mRect, options);
        canvas.drawBitmap(bitmap, 0, 0, null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        int temWidth = imageWidth;
        int temHeight = imageHeight;

        mRect.left = temWidth / 2 - width / 2;
        mRect.top = temHeight / 2 - height / 2;
        mRect.right = mRect.left + width;
        mRect.left = mRect.top + height;

    }
}

