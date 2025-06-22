package com.uptodown.activities;

import J1.I;
import N1.k;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class CustomWebView extends C1826a {

    /* renamed from: L  reason: collision with root package name */
    public static final a f17571L = new a((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private String f17572J;

    /* renamed from: K  reason: collision with root package name */
    private String f17573K;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            m.e(webResourceRequest, "request");
            return false;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            m.e(webView, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            m.e(str, "url");
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static final void b3(CustomWebView customWebView, View view) {
        customWebView.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.custom_web_view);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey(CampaignEx.JSON_KEY_TITLE)) {
                this.f17572J = extras.getString(CampaignEx.JSON_KEY_TITLE);
            }
            if (extras.containsKey("url")) {
                this.f17573K = extras.getString("url");
            }
        }
        ((ImageView) findViewById(R.id.iv_back_custom_web_view)).setOnClickListener(new I(this));
        TextView textView = (TextView) findViewById(R.id.tv_title_custom_web_view);
        textView.setTypeface(k.f7778g.x());
        textView.setText(this.f17572J);
        WebView webView = (WebView) findViewById(R.id.wv_custom_web_view);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setSupportZoom(true);
        webView.setScrollBarStyle(33554432);
        webView.setScrollbarFadingEnabled(true);
        webView.setInitialScale(80);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.setWebViewClient(new b());
        String str = this.f17573K;
        if (str != null) {
            m.b(str);
            webView.loadUrl(str);
        }
    }
}
