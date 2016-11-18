package com.example.mytool.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.mytool.R;
import com.example.mytool.uitil.API;
import com.example.mytool.uitil.StackManager;

public class H5MovieActivity extends BaseActivity {
    private WebView mWebView;
    private TextView mTextView;
    private WebSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5_movie);
        StackManager.onActivityCreated(this);
        initView();
    }

    private void initView() {
        mWebView = (WebView) findViewById(R.id.my_webview);
        mTextView = (TextView) findViewById(R.id.text_title);
        settings = mWebView.getSettings();
        mWebView.setScrollContainer(true);
        settings.setSupportZoom(false);
        mWebView.setBackgroundColor(Color.WHITE);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);
        settings.setJavaScriptEnabled(true);
        settings.setDefaultFontSize(14);
        mWebView.loadUrl(API.H5MOVIE);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(API.H5MOVIE);
                return true;
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                mTextView.setText(title);
            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        StackManager.onActivityDestory(this);
        mWebView = null;
    }
}
