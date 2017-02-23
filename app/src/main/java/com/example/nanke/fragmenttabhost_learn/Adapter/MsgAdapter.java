package com.example.nanke.fragmenttabhost_learn.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nanke.fragmenttabhost_learn.Data.JavaBean;
import com.example.nanke.fragmenttabhost_learn.DetailActivity;
import com.example.nanke.fragmenttabhost_learn.R;

import java.util.List;

/**
 * Created by zt on 2017/2/23.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<JavaBean.ResultsBean> list;
    private Context mContext;
    public MsgAdapter(List<JavaBean.ResultsBean> mList){
        this.list=mList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.mContext=parent.getContext();
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.msg_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
            ViewHolder viewHolder=holder;
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, DetailActivity.class);
                intent.putExtra("url",list.get(position).getUrl());
                mContext.startActivity(intent);
            }
        });
            JavaBean.ResultsBean resultsBean=list.get(position);

            viewHolder.title.setText(resultsBean.getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.title);
        }
    }

}
