package com.example.nanke.fragmenttabhost_learn.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nanke.fragmenttabhost_learn.Data.JavaBean;
import com.example.nanke.fragmenttabhost_learn.R;

import java.util.List;

/**
 * Created by zt on 2017/2/23.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<JavaBean.ResultsBean> list;

    public MsgAdapter(List<JavaBean.ResultsBean> mList){
        this.list=mList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            JavaBean.ResultsBean resultsBean=list.get(position);
            ViewHolder viewHolder=holder;
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
