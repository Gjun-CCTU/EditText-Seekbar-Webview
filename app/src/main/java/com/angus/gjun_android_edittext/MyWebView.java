package com.angus.gjun_android_edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MyWebView extends AppCompatActivity {
    WebView wv1;
    Button btn7;
    EditText et11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_view);
        wv1 = (WebView) findViewById(R.id.webview1);
        btn7 = (Button) findViewById(R.id.button7);
        et11 = (EditText) findViewById(R.id.editText11);
        int start = "http://".toString().length();
        int stop = et11.getText().toString().length();
        et11.setSelection(start, stop);
        WebSettings ws = wv1.getSettings();
        ws.setJavaScriptEnabled(true);
        wv1.loadUrl("http://www.591.com.tw");
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = et11.getText().toString();
                wv1.loadUrl(url);
            }
        });
    }
}
