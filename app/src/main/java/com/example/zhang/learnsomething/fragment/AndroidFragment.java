package com.example.zhang.learnsomething.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhang.learnsomething.R;
import com.example.zhang.learnsomething.base.BaseFragment;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AndroidFragment extends BaseFragment {

    private LineChart lineChart;
    @Override
    protected void initView() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_android, container, false);
        lineChart = (LineChart) view.findViewById(R.id.lineChart);
        lineChart.getViewPortHandler().getMatrixTouch().postScale(10f, 1f);
//        lineChart.setViewPortOffsets(50,50,50,50);
//        //设置支持触控手势
//        lineChart.setTouchEnabled(true);
//        //设置缩放
//        lineChart.setDragEnabled(true);
//        //设置推动
//        lineChart.setScaleEnabled(true);
//        //设置chart是否可以触摸
//        lineChart.setTouchEnabled(true);
////设置是否可以拖拽
//        lineChart.setDragEnabled(true);
////设置是否可以缩放 x和y，默认true
//        lineChart.setScaleEnabled(false);
////是否缩放X轴
//        lineChart.setScaleXEnabled(true);
////X轴缩放比例
//        lineChart.setScaleX(1.5f);
////Y轴缩放比例
//        lineChart.setScaleY(1.5f);
////是否缩放Y轴
//        lineChart.setScaleYEnabled(true);
////设置是否可以通过双击屏幕放大图表。默认是true
//        lineChart.setDoubleTapToZoomEnabled(false);
        XAxis xAxis = lineChart.getXAxis();
        //设置X轴的文字在底部
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);//绘制网格线，默认为true
        xAxis.setGridColor(Color.BLUE);//设置该轴的网格线颜色。
        xAxis.setGridLineWidth(2f);// 设置该轴网格线的宽度。
       // xAxis.setDrawGridLines(false);//绘制网格线
        xAxis.setDrawLabels(true);//绘制该轴标签
        xAxis.setTextColor(Color.RED);// 设置轴标签的颜色。
        xAxis.setTextSize(11f);//设置轴标签的文字大小。
        xAxis.setAxisMinimum(0f);//设置最小值
        xAxis.setAxisMaximum(100f);//设置最大值
        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("1.Q"); xVals.add("2.Q"); xVals.add("3.Q"); xVals.add("4.Q");

//        xAxis.setValueFormatter(new IAxisValueFormatter() {
//            @Override
//            public String getFormattedValue(float value, AxisBase axis) {
//                int i = (int)value;
//                return "数据"+i;
//            }
//        });
//xAxis.setTypeface(Typeface tf);// 设置轴标签的 Typeface。
// set a custom value formatter

        YAxis leftAxis = lineChart.getAxisLeft();//获取左轴
        // YAxis rightAxis = chart.getAxisRight();//获取右轴
        lineChart.getAxisRight().setEnabled(false);//隐藏右轴  默认显示

        //设置Y轴最大最小值，不设置chart会自己计算
        leftAxis.setAxisMinimum(0f);//设置最小值
        leftAxis.setAxisMaximum(100f);//设置最大值
        leftAxis.setDrawGridLines(true);//绘制网格线 默认为true


        ArrayList<Entry> poitList= new ArrayList<Entry>();
        for (int i= 0;i<100;i++){
            float mult = 100 / 2f;
            float val = (float) (Math.random() * mult) +50;
            poitList.add(new Entry(i,val));
        }

        LineDataSet dataSet= new LineDataSet(poitList, "data 1");
        dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        dataSet.setHighLightColor(Color.RED); // 设置点击某个点时，横竖两条线的颜色
        dataSet.setDrawValues(true);//在点上显示数值 默认true
        dataSet.setValueTextSize(12f);//数值字体大小，同样可以设置字体颜色、自定义字体等

        LineData data = new LineData(dataSet);
        lineChart.setData(data);
        lineChart.invalidate();
// 设置x轴的LimitLine
        LimitLine yLimitLine = new LimitLine(58f,"量程最大值");
        yLimitLine.setLineColor(Color.RED);
        yLimitLine.setTextColor(Color.RED);
        leftAxis.addLimitLine(yLimitLine);
        LimitLine xLimitLine = new LimitLine(55f,"量程最小值");
        xLimitLine.setLineColor(Color.GREEN);
        xLimitLine.setTextColor(Color.GREEN);
        leftAxis.addLimitLine(xLimitLine);
        // 设置x轴的LimitLine，index是从0开始的
//        LimitLine xLimitLine = new LimitLine(4f,"量程最小值");
//        xLimitLine.setLineColor(Color.GREEN);
//        xLimitLine.setTextColor(Color.GREEN);
//        xAxis.addLimitLine(xLimitLine);
        return view;
    }
}
