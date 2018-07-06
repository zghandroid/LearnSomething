package com.example.zhang.learnsomething.animation;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Point;

import static android.R.attr.animation;

/**
 * Created by 12345 on 2018/7/5.
 */

public class PointSinEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;

        float x = startPoint.x + fraction * (endPoint.x - startPoint.x);
        float y = (float) (Math.sin(x * Math.PI / 180) * 100) + endPoint.y / 2;
        Point point = new Point((int)x, (int)y);
        return point;
    }



}
