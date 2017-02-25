package com.example.nanke.fragmenttabhost_learn.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nanke.fragmenttabhost_learn.Adapter.HeaderAdpter;
import com.example.nanke.fragmenttabhost_learn.Model.Meizi;
import com.example.nanke.fragmenttabhost_learn.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zt on 2017/2/22.
 */

public class fragment1 extends Fragment {

    List<Meizi> list=new ArrayList<>();
    private Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment1,null);
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.recyvler_view);
        initData();
        HeaderAdpter adpter=new HeaderAdpter(list);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
       // LinearLayoutManager layoutManager=new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adpter);
        toolbar= (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("轻松一刻");
        return view;
    }

  public void initData(){
      Meizi meizi1=new Meizi(R.drawable.mei1,"ahai");
      list.add(meizi1);
      Meizi meizi2=new Meizi(R.drawable.mei2,"home");
      list.add(meizi2);
      Meizi meizi3=new Meizi(R.drawable.mei3,"msg");
      list.add(meizi3);
      Meizi meizi4=new Meizi(R.drawable.mei4,"more");
      list.add(meizi4);

      list.add(meizi1);
      list.add(meizi2);
      Meizi meizi5=new Meizi(R.drawable.mei5,"more");
      list.add(meizi5);
      list.add(meizi1);
      list.add(meizi5);
      list.add(meizi2);
      list.add(meizi5);
      list.add(meizi1);
      list.add(meizi2);
      Meizi meizi6=new Meizi(R.drawable.mei6,"more");
      list.add(meizi6);
      list.add(meizi1);
      list.add(meizi2);
      Meizi meizi7=new Meizi(R.drawable.mei7,"more");
      list.add(meizi7);
      list.add(meizi1);
      list.add(meizi2);
      list.add(meizi5);
      list.add(meizi5);
      list.add(meizi1);
      list.add(meizi2);
  }
}
