package com.mbridge.msdk.mbbanner.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;
import com.mbridge.msdk.mbsignalcommon.base.b;
import java.util.List;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    String f14022a;

    /* renamed from: b  reason: collision with root package name */
    List<CampaignEx> f14023b;

    /* renamed from: c  reason: collision with root package name */
    com.mbridge.msdk.mbbanner.common.b.a f14024c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14025d = "BannerWebViewClient";

    public a(String str, List<CampaignEx> list, com.mbridge.msdk.mbbanner.common.b.a aVar) {
        this.f14022a = str;
        this.f14023b = list;
        this.f14024c = aVar;
    }

    private void a(WebView webView, String str) {
        webView.evaluateJavascript(str, new ValueCallback<String>() {
            public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                String str = (String) obj;
            }
        });
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        CampaignEx campaignEx;
        super.onPageStarted(webView, str, bitmap);
        try {
            a(webView, "javascript:" + com.mbridge.msdk.c.b.a.a().b());
            List<CampaignEx> list = this.f14023b;
            if (list != null && !list.isEmpty() && (campaignEx = this.f14023b.get(0)) != null && campaignEx.isActiveOm()) {
                a(webView, "javascript:" + MBridgeConstans.OMID_JS_SERVICE_CONTENT);
            }
        } catch (Throwable th) {
            af.b("BannerWebViewClient", "onPageStarted", th);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            af.b("BannerWebViewClient", "Use html to open url.");
            BaseWebView baseWebView = (BaseWebView) webView;
            if (System.currentTimeMillis() - baseWebView.lastTouchTime > ((long) com.mbridge.msdk.click.b.a.f12045c) && com.mbridge.msdk.click.b.a.a(this.f14023b.get(0), baseWebView.getUrl(), com.mbridge.msdk.click.b.a.f12044b)) {
                return false;
            }
            if (this.f14023b.size() > 1) {
                c.m().c().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                str = null;
            }
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.f14024c;
            if (aVar != null) {
                aVar.a(false, str);
            }
            return true;
        } catch (Throwable th) {
            af.b("BannerWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }
}
