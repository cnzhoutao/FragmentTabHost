package com.example.nanke.fragmenttabhost_learn.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nanke.fragmenttabhost_learn.Data.DbStorge;
import com.example.nanke.fragmenttabhost_learn.DbOperator.MyDataBaseHelper;
import com.example.nanke.fragmenttabhost_learn.DetailActivity;
import com.example.nanke.fragmenttabhost_learn.R;

import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * Created by zt on 2017/2/25.
 */

public class StorgeAdapter extends RecyclerView.Adapter<StorgeAdapter.ViewHolder> {
    private List<DbStorge> list;
    private Context mContext;
    private MyDataBaseHelper dbHelper;
    public StorgeAdapter(List<DbStorge> mList) {
        this.list = mList;
    }

    @Override
    public StorgeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        this.mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.msg_item, parent, false);

        final StorgeAdapter.ViewHolder viewHolder = new StorgeAdapter.ViewHolder(view);
        dbHelper=new MyDataBaseHelper(mContext,"Sdata.db",null,1);

        viewHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                int index=viewHolder.getAdapterPosition();
                        intent.putExtra("url", list.get(index).getUrl());
                mContext.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        StorgeAdapter.ViewHolder viewHolder = holder;
        DbStorge resultsBean = list.get(position);
        viewHolder.title.setText(resultsBean.getTitle());
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


}
