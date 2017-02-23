package com.example.nanke.fragmenttabhost_learn.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nanke.fragmenttabhost_learn.Adapter.MsgAdapter;
import com.example.nanke.fragmenttabhost_learn.Data.JavaBean;
import com.example.nanke.fragmenttabhost_learn.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zt on 2017/2/22.
 */

public class fragment4 extends Fragment {
    private RecyclerView recyclerView;
    private Context context;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LinearLayoutManager layoutManager=new LinearLayoutManager(context);
             MsgAdapter adapter=new MsgAdapter((List<JavaBean.ResultsBean>) msg.obj);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment4,null);
        recyclerView= (RecyclerView) view.findViewById(R.id.recycler_view4);
        this.context=container.getContext();
        getJson();
        return view;
    }
    public void getJson(){

        OkHttpClient okHttpClient=new OkHttpClient();

        final Request request=new Request.Builder()
                .url("http://gank.io/api/data/Android/30/0")
                .build();

        Call call=okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                if(response.isSuccessful()){

                    String str=response.body().string();

                    System.out.println("***********"+str);

                    Gson gson=new Gson();//数据解析

                    JavaBean result=gson.fromJson(str, JavaBean.class);

                    List<JavaBean.ResultsBean> newses=result.getResults();

                    Message msg=new Message();
                    msg.obj=newses;
                    handler.sendMessage(msg);
                }
            }
        });
    }
}
