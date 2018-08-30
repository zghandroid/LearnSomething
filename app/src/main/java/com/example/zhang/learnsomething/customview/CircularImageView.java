package com.example.zhang.learnsomething.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by 12345 on 2018/7/16.
 */

public class CircularImageView extends View {
    public CircularImageView(Context context) {
        this(context,null);
    }

    public CircularImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, null,0);
    }

    public CircularImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
