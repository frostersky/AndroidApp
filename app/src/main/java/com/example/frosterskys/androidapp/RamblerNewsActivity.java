package com.example.frosterskys.androidapp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by evbe0615 on 21-Dec-17.
 */

public class RamblerNewsActivity extends Activity {

    private WebView mWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rambler_page);

        mWebView = (WebView) findViewById(R.id.ramblerNewsWebPage);
        // включаем поддержку JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);

        String url = getIntent().getStringExtra("newsRef");
        mWebView.loadUrl(url);
    }
}
