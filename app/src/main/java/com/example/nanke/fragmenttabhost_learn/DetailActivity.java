package com.example.nanke.fragmenttabhost_learn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

public class DetailActivity extends AppCompatActivity {
    private WebView webView;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("详情展示");


        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        webView= (WebView) findViewById(R.id.web);
        webView.loadUrl(url);
    }
}
