package com.example.nanke.fragmenttabhost_learn.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nanke.fragmenttabhost_learn.Data.DbStorge;
import com.example.nanke.fragmenttabhost_learn.Data.JavaBean;
import com.example.nanke.fragmenttabhost_learn.DbOperator.MyDataBaseHelper;
import com.example.nanke.fragmenttabhost_learn.DetailActivity;
import com.example.nanke.fragmenttabhost_learn.R;

import java.util.Date;
import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * Created by zt on 2017/2/23.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<JavaBean.ResultsBean> list;
    private Context mContext;
    private MyDataBaseHelper dbHelper;
    public MsgAdapter(List<JavaBean.ResultsBean> mList) {
        this.list = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.msg_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        dbHelper=new MyDataBaseHelper(mContext,"Sdata.db",null,1);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ViewHolder viewHolder = holder;
        holder.title.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                addDb(position);
                Toasty.success(mContext, "收藏成功", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("url", list.get(position).getUrl());
                mContext.startActivity(intent);
            }
        });
        JavaBean.ResultsBean resultsBean = list.get(position);

        viewHolder.title.setText(resultsBean.getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
    //将用户选中的数据存入数据库
    public void addDb(int index){
        JavaBean.ResultsBean mResult = list.get(index);
        Date now=new Date();//获取当前收藏的时间

        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("desc",mResult.getDesc());
        values.put("url",mResult.getUrl());
        values.put("storge_time",now.toString());
        values.put("createdAt",mResult.getCreatedAt());
        values.put("type",mResult.getType());

        db.insert("Sdata",null,values);
        values.clear();
    }
}
