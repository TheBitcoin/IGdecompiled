package com.mbridge.msdk.video.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.g.a;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.videocommon.download.d;
import com.mbridge.msdk.videocommon.download.e;

public class MBridgeAlertWebview extends MBridgeH5EndCardView {
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public String f16236w;

    public MBridgeAlertWebview(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    public void preLoadData(b bVar) {
        String a5 = a();
        if (!this.f16242e || this.f16239b == null || TextUtils.isEmpty(a5)) {
            this.notifyListener.a(101, "");
            return;
        }
        a aVar = new a(this.f16239b);
        aVar.a(this.f16239b.getAppName());
        this.f16325p.setDownloadListener(aVar);
        this.f16325p.setCampaignId(this.f16239b.getId());
        setCloseVisible(8);
        this.f16325p.setApiManagerJSFactory(bVar);
        this.f16325p.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() {
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                af.b("MBridgeAlertWebview", "finish+" + str);
                g.a().a(webView);
            }

            public final void a(WebView webView, int i4, String str, String str2) {
                super.a(webView, i4, str, str2);
                af.b("MBridgeAlertWebview", "onReceivedError");
                if (!MBridgeAlertWebview.this.f16329t) {
                    af.a(MBridgeBaseView.TAG, "onReceivedError,url:" + str2);
                    MBridgeAlertWebview mBridgeAlertWebview = MBridgeAlertWebview.this;
                    i.a(mBridgeAlertWebview.f16238a, mBridgeAlertWebview.f16239b, mBridgeAlertWebview.f16236w, MBridgeAlertWebview.this.unitId, 2, str, 1);
                    MBridgeAlertWebview.this.f16329t = true;
                }
            }

            public final void a(WebView webView, int i4) {
                String str;
                super.a(webView, i4);
                af.b("MBridgeAlertWebview", "readyState  :  " + i4);
                MBridgeAlertWebview mBridgeAlertWebview = MBridgeAlertWebview.this;
                if (!mBridgeAlertWebview.f16329t) {
                    boolean z4 = true;
                    if (i4 != 1) {
                        z4 = false;
                    }
                    mBridgeAlertWebview.f16328s = z4;
                    if (z4) {
                        str = "readyState state is " + i4;
                    } else {
                        str = "";
                    }
                    String str2 = str;
                    MBridgeAlertWebview mBridgeAlertWebview2 = MBridgeAlertWebview.this;
                    i.a(mBridgeAlertWebview2.f16238a, mBridgeAlertWebview2.f16239b, mBridgeAlertWebview2.f16236w, MBridgeAlertWebview.this.unitId, i4, str2, 1);
                }
            }
        });
        setHtmlSource(e.a().b(a5));
        this.f16328s = false;
        if (TextUtils.isEmpty(this.f16327r)) {
            af.a(MBridgeBaseView.TAG, "load url:" + a5);
            this.f16325p.loadUrl(a5);
        } else {
            af.a(MBridgeBaseView.TAG, "load html...");
            this.f16325p.loadDataWithBaseURL(a5, this.f16327r, "text/html", C.UTF8_NAME, (String) null);
        }
        this.f16325p.setBackgroundColor(0);
        setBackgroundColor(0);
    }

    public void webviewshow() {
        RelativeLayout relativeLayout = this.f16323n;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(0);
        }
        super.webviewshow();
        i.a(this.f16238a, this.f16239b, this.f16236w, this.unitId, 2, 1);
    }

    public MBridgeAlertWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final String a() {
        if (TextUtils.isEmpty(this.unitId)) {
            return "";
        }
        com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), this.unitId, false);
        String str = com.mbridge.msdk.videocommon.d.c.f16988a;
        this.f16236w = str;
        if (!TextUtils.isEmpty(str)) {
            return d.a().a(this.f16236w);
        }
        return "";
    }
}
