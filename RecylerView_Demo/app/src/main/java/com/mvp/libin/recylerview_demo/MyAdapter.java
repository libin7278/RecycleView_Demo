package com.mvp.libin.recylerview_demo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by libin on 16/11/17.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<NameBean> mData;
    OnItemClickListener onItemClickListener;

    public MyAdapter(List<NameBean> mData) {
        this.mData = mData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new DataViewHolder(itemView);
    }

    //绑定每一项的数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof DataViewHolder){
            BindViewForDate(holder,position);
        }
    }

    private void BindViewForDate(RecyclerView.ViewHolder holder, final int position) {
        DataViewHolder dataViewHolder = (DataViewHolder) holder;
        final NameBean name = getItem(position);
        dataViewHolder.textview.setText(name.getName());

        dataViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.onClick(v,position);
                }
            }
        });

    }

    protected NameBean getItem(int position){
        return mData.get(position);
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class DataViewHolder extends RecyclerView.ViewHolder {
        private TextView textview;

        public DataViewHolder(View itemView) {
            super(itemView);

            textview = (TextView) itemView.findViewById(R.id.textview);
        }
    }

    public interface OnItemClickListener{
        public void onClick(View View,int position);
    }

}
