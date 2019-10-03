package com.crazy4web.webviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button staticBtn, dynamicBtn;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        staticBtn = findViewById(R.id.staticWebView);
        dynamicBtn = findViewById(R.id.dynamicWebView);

        web = findViewById(R.id.webView);

        staticBtn.setOnClickListener(this);
        dynamicBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.staticWebView:

               String customHtml = "<html><body><h2>Abey</h2><br><h3>OO</h3><br><h4>Chutiye</h4></body></html>";
               web.loadData(customHtml,"text/html","UTF-8");

               break;

            case R.id.dynamicWebView:

                web.setWebViewClient(new MyWebViewClient());
                String url = "https://www.google.ca/";

                web.getSettings().setJavaScriptEnabled(true);
                web.loadUrl(url);
                break;


        }


    }


    private class MyWebViewClient extends WebViewClient {


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    }



}
