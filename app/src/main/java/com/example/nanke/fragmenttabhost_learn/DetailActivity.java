package com.example.nanke.fragmenttabhost_learn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class DetailActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        webView= (WebView) findViewById(R.id.web);
        webView.loadUrl(url);
    }
}
