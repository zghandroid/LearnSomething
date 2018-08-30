package com.example.zhang.learnsomething.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhang.learnsomething.R;

import java.util.List;

/**
 * Created by 12345 on 2018/8/7.
 */

public class TestRecycleViewAdapter extends RecyclerView.Adapter<TestRecycleViewAdapter.TestViewHolder> {

    private Context context;
    private List<String> data;

    public TestRecycleViewAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @Override

    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TestViewHolder viewHolder = new TestViewHolder(LayoutInflater.from(context).inflate(R.layout.recycleview_item, parent, false));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {

        holder.tv.setText(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }

    class TestViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

         TestViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.recycleview_tv);
        }
    }
}
