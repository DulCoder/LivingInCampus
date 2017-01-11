package com.fafu.zhengxianyou.livingincampus;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BannerInfoActivity extends Activity {
    private WebView wb_banner_info_more;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_info);

        url = getIntent().getStringExtra("url");

        setWebView(url);
    }

    /**
     * 设置WebView内容
     * @param url
     */
    private void setWebView(String url) {
        wb_banner_info_more = (WebView) findViewById(R.id.wb_banner_info_more);
        if (url != null){
            wb_banner_info_more.loadUrl(url);

            // 覆盖WebView 默认使用第三方或系统默认浏览器打开网页的行为，使网页 用 WebView 打开
            wb_banner_info_more.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    // 返回值是 true的时候控制去 WebView 打开，为 false 调用系统 浏览器或第三方浏览器
                    view.loadUrl(url);
                    return true;
                }
            });


            //设置支持JavaScript
            WebSettings settings = wb_banner_info_more.getSettings();
            settings.setJavaScriptEnabled(true);

            //设置大小适应屏幕
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);

            //设置字体大小
            settings.setSupportZoom(true);
            settings.setTextZoom(230);

            //优先使用缓存
            wb_banner_info_more.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wb_banner_info_more.canGoBack()) {
            wb_banner_info_more.goBack();                                            //设置WebView返回栈
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
