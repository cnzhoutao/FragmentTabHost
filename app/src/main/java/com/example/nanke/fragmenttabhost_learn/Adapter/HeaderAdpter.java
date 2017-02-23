package com.example.nanke.fragmenttabhost_learn.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nanke.fragmenttabhost_learn.Model.Meizi;
import com.example.nanke.fragmenttabhost_learn.R;

import java.util.List;

/**
 * Created by zt on 2017/2/23.
 */

public class HeaderAdpter extends RecyclerView.Adapter<HeaderAdpter.ViewHolder> {

    private List<Meizi> mList;


    public HeaderAdpter(List<Meizi> meizi){
        this.mList=meizi;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reccycler_item,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=viewHolder.getAdapterPosition();
                Meizi meizi=mList.get(position);
                Toast.makeText(parent.getContext(), "点击成功,"+meizi.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            ViewHolder viewHolder=holder;
        Meizi meizi=mList.get(position);
        viewHolder.icon.setImageResource(meizi.getImageId());
        viewHolder.tv_title.setText(meizi.getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView tv_title;

        public ViewHolder(View itemView) {
            super(itemView);
            icon= (ImageView) itemView.findViewById(R.id.icon);
            tv_title= (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
