package com.angus.gjun_android_edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MyWebView extends AppCompatActivity {
    WebView wv1;
    Button btn7;
    EditText et13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_view);
        wv1 = (WebView) findViewById(R.id.webview1);
        btn7 = (Button) findViewById(R.id.button7);
        et13 = (EditText) findViewById(R.id.editText13);
        int start = "http://".toString().length();
        int stop = et13.getText().toString().length();
        et13.setSelection(start, stop);
        WebSettings ws = wv1.getSettings();
        ws.setJavaScriptEnabled(true);
//        wv1.loadUrl("http://www.591.com.tw");
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = et13.getText().toString();
                wv1.loadUrl(url);
            }
        });
        wv1.setWebViewClient(new MyWebViewClient());
    }
    public class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && wv1.canGoBack())
            wv1.goBack();
        return super.onKeyDown(keyCode, event);
    }
}
