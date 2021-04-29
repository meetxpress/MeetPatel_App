package com.example.meetpatel;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView wb = findViewById(R.id.MainWeb);
        wb.setWebViewClient(new MyBrowser());

        String url = "https://meetxpress.000webhostapp.com";
        wb.getSettings().setLoadsImagesAutomatically(true);
        wb.getSettings().setJavaScriptEnabled(true);
        //wb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        if (18 < Build.VERSION.SDK_INT) {
            wb.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        }
        wb.loadUrl("https://meetxpress.000webhostapp.com");
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}