package com.example.nanke.fragmenttabhost_learn;


import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.nanke.fragmenttabhost_learn.Fragment.fragment1;
import com.example.nanke.fragmenttabhost_learn.Fragment.fragment2;
import com.example.nanke.fragmenttabhost_learn.Fragment.fragment3;
import com.example.nanke.fragmenttabhost_learn.Fragment.fragment4;
import com.example.nanke.fragmenttabhost_learn.Fragment.fragment5;

public class MainActivity extends FragmentActivity {
    private int[] image = {R.drawable.tab_square,
            R.drawable.tab_measssge,
            R.drawable.tab_home,
            R.drawable.tab_selfinfo,
            R.drawable.tab_more};

    private Class mFragment[] = {
            fragment1.class,
            fragment4.class,
            fragment2.class,
            fragment3.class,
            fragment5.class
    };
    private String[] title = {
            "首页",
            "搜索",
            "消息",
            "好友",
            "更多"
    };
    private com.example.nanke.fragmenttabhost_learn.FragmentTabHost mTabHost;
    private LayoutInflater mLayoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        mLayoutInflater = LayoutInflater.from(this);

        mTabHost = (com.example.nanke.fragmenttabhost_learn.FragmentTabHost)
                findViewById(android.R.id.tabhost);

        mTabHost.setup(this, getSupportFragmentManager(), R.id.fram);

        int count = mFragment.length;
        for (int i = 0; i < count; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(title[i])
                    .setIndicator(getTabItemVIew(i));

            mTabHost.addTab(tabSpec, mFragment[i], null);
            mTabHost.getTabWidget().getChildAt(i)
                    .setBackgroundResource(R.drawable.selector_tab_background);

        }

    }

    public View getTabItemVIew(int index) {
        View view = mLayoutInflater.inflate(R.layout.tab_itemview, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(image[index]);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(title[index]);
        return view;
    }
}
