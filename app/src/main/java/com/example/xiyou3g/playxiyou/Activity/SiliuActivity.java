package com.example.xiyou3g.playxiyou.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.xiyou3g.playxiyou.R;

/**
 * Created by Lance on 2017/7/23.
 */

public class SiliuActivity extends AppCompatActivity {

    private WebView siliu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        Fade fade = new Fade();
        fade.setDuration(500);
        getWindow().setEnterTransition(fade);
        setContentView(R.layout.siliu_activity);
        initWight();
    }

    private void initWight() {
        siliu = (WebView) findViewById(R.id.siliu);
        siliu.getSettings().setJavaScriptEnabled(true);
        siliu.setWebViewClient(new WebViewClient());
        siliu.loadUrl("http://cet.99sushe.com/");
    }
}
