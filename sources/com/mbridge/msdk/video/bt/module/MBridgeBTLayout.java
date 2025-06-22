package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Base64;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.d;
import org.json.JSONObject;

public class MBridgeBTLayout extends BTBaseView {

    /* renamed from: p  reason: collision with root package name */
    private WebView f15867p;

    public MBridgeBTLayout(Context context) {
        super(context);
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.f15867p != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", BTBaseView.f15762n);
                jSONObject2.put("id", getInstanceId());
                jSONObject2.put("eventName", str);
                jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject);
                g.a().a(this.f15867p, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception unused) {
                d.c().a(this.f15867p, "broadcast", getInstanceId());
            }
        }
    }

    public WebView getBtWebView() {
        return this.f15867p;
    }

    public void init(Context context) {
    }

    public void notifyEvent(String str) {
        WebView webView = this.f15867p;
        if (webView != null) {
            BTBaseView.a(webView, str, this.f15767d);
        }
    }

    public void onBackPressed() {
        if (this.f15867p != null) {
            d.c().a(this.f15867p, "onSystemBackPressed", this.f15767d);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.f15867p != null) {
            try {
                CampaignEx campaignEx = this.f15765b;
                if (campaignEx == null || !campaignEx.isDynamicView()) {
                    JSONObject jSONObject = new JSONObject();
                    if (configuration.orientation == 2) {
                        jSONObject.put("orientation", "landscape");
                    } else {
                        jSONObject.put("orientation", "portrait");
                    }
                    jSONObject.put("instanceId", this.f15767d);
                    g.a().a(this.f15867p, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public void onDestory() {
    }

    public void setWebView(WebView webView) {
        this.f15867p = webView;
    }

    public MBridgeBTLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
