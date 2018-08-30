package com.example.zhang.learnsomething;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.zhang.learnsomething.base.BaseActivity;
import com.example.zhang.learnsomething.customview.ImitateKeepButton;
import com.example.zhang.learnsomething.customview.LargeImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TestBitmapActivity extends BaseActivity {

    @InjectView(R.id.test_bitmap)
    ImitateKeepButton testBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_bitmap);
        ButterKnife.inject(this);
        //initView();
//        InputStream inputStream = null;
//        try {
//            inputStream = getAssets().open("world.jpg");
//            testBitmap.setInputStream(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void initView() {

//        try {
//            InputStream inputStream = getAssets().open("test_bitmap.jpg");
//            BitmapFactory.Options options = new BitmapFactory.Options();
//            options.inJustDecodeBounds=true;
//            BitmapFactory.decodeStream(inputStream, null, options);
//            int width = options.outWidth;
//            int height = options.outHeight;
//
//            BitmapRegionDecoder decoder = BitmapRegionDecoder.newInstance(inputStream, false);
//            BitmapFactory.Options options1 = new BitmapFactory.Options();
//            options1.inPreferredConfig = Bitmap.Config.RGB_565;
//            Bitmap bitmap = decoder.decodeRegion(new Rect(width / 2 - 100, height / 2 - 100, width / 2 + 100, height / 2 + 100), options1);
//            testBitmap.setImageBitmap(bitmap);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
