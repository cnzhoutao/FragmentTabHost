package com.example.nanke.fragmenttabhost_learn.Fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nanke.fragmenttabhost_learn.Adapter.StorgeAdapter;
import com.example.nanke.fragmenttabhost_learn.Data.DbStorge;
import com.example.nanke.fragmenttabhost_learn.DbOperator.MyDataBaseHelper;
import com.example.nanke.fragmenttabhost_learn.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zt on 2017/2/22.
 */

public class fragment5 extends Fragment {

    private MyDataBaseHelper dbHelper;
    private List<DbStorge> mData=new ArrayList<>();
    private RecyclerView storge_reView;
    private Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment5,null);
        storge_reView= (RecyclerView) view.findViewById(R.id.storege_review);
       // LinearLayoutManager layoutManager=new LinearLayoutManager(this.getActivity());
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        StorgeAdapter adapter=new StorgeAdapter(mData);
        storge_reView.setLayoutManager(layoutManager);
        storge_reView.setAdapter(adapter);
        toolbar= (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("我的收藏");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dbHelper=new MyDataBaseHelper(this.getActivity(),"Sdata.db",null,1);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        //从数据库中读取收藏的数据
        Cursor cursor=db.query("Sdata",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do {
                DbStorge dbStorge=new DbStorge();
                dbStorge.setTitle(cursor.getString(cursor.getColumnIndex("desc")));
                dbStorge.setUrl(cursor.getString(cursor.getColumnIndex("url")));
                dbStorge.setStorge_time(cursor.getString(cursor.getColumnIndex("storge_time")));
                dbStorge.setCreatedAt(cursor.getString(cursor.getColumnIndex("createdAt")));
                dbStorge.setType(cursor.getString(cursor.getColumnIndex("type")));
                mData.add(dbStorge);
            }while (cursor.moveToNext());
        }
        cursor.close();
    }
}
