package com.mbridge.msdk.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.mbridge.msdk.click.i;
import com.mbridge.msdk.e.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.mbsignalcommon.b.a;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.d;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.videocommon.d.c;
import java.util.List;
import org.json.JSONObject;

public class MBridgeBTWebView extends MBridgeBTWebViewDiff {
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public String f15942p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public String f15943q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public String f15944r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f15945s = false;

    /* renamed from: t  reason: collision with root package name */
    private ImageView f15946t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f15947u = false;

    /* renamed from: v  reason: collision with root package name */
    private c f15948v;

    /* renamed from: w  reason: collision with root package name */
    private List<CampaignEx> f15949w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public WebView f15950x;

    public MBridgeBTWebView(Context context) {
        super(context);
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.webView != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", BTBaseView.f15762n);
                jSONObject2.put("id", this.f15767d);
                jSONObject2.put("eventName", str);
                jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject);
                g.a().a((WebView) this.webView, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception unused) {
                d.c().a((WebView) this.webView, "broadcast", this.f15767d);
            }
        }
    }

    public void close() {
        WebView webView = this.f15950x;
        if (webView != null) {
            BTBaseView.a(webView, "onPlayerCloseBtnClicked", this.f15767d);
        }
    }

    public void expand(String str, boolean z4) {
    }

    public List<CampaignEx> getCampaigns() {
        return this.f15949w;
    }

    public String getFilePath() {
        return this.f15943q;
    }

    public String getFileURL() {
        return this.f15942p;
    }

    public String getHtml() {
        return this.f15944r;
    }

    public CampaignEx getMraidCampaign() {
        return this.f15765b;
    }

    public c getRewardUnitSetting() {
        return this.f15948v;
    }

    public WindVaneWebView getWebView() {
        return this.webView;
    }

    public void init(Context context) {
        int i4;
        WindVaneWebView windVaneWebView = new WindVaneWebView(context);
        this.webView = windVaneWebView;
        windVaneWebView.setBackgroundColor(0);
        this.webView.setVisibility(0);
        k kVar = new k((Activity) null, this.f15765b, this.f15949w);
        this.jsCommon = kVar;
        kVar.a(this.f15766c);
        if (b.a()) {
            setChinaAlertInstallState(this.jsCommon);
        }
        this.webView.setObject(this.jsCommon);
        this.webView.setMraidObject(this);
        this.webView.setWebViewListener(new a() {
            public final void a(Object obj) {
                super.a(obj);
                try {
                    k kVar = MBridgeBTWebView.this.jsCommon;
                    String str = "";
                    String c5 = kVar != null ? kVar.c() : str;
                    if (!TextUtils.isEmpty(c5)) {
                        str = Base64.encodeToString(c5.getBytes(), 2);
                        af.a("RVWindVaneWebView", "getEndScreenInfo success");
                    } else {
                        af.a("RVWindVaneWebView", "getEndScreenInfo failed");
                    }
                    g.a().a(obj, str);
                } catch (Throwable th) {
                    af.a("RVWindVaneWebView", th.getMessage());
                }
            }

            public final void a(WebView webView, String str) {
                super.a(webView, str);
                if (MBridgeBTWebView.this.f15950x != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", MBridgeBTWebView.this.f15767d);
                        jSONObject.put("code", BTBaseView.f15762n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", MBridgeBTWebView.this.f15767d);
                        jSONObject2.put("result", 1);
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                        g.a().a(MBridgeBTWebView.this.f15950x, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e5) {
                        d.c().a(MBridgeBTWebView.this.f15950x, e5.getMessage());
                        af.a("RVWindVaneWebView", e5.getMessage());
                    }
                }
                g.a().a(MBridgeBTWebView.this.webView);
            }

            public final void a(WebView webView, int i4, String str, String str2) {
                super.a(webView, i4, str, str2);
                if (MBridgeBTWebView.this.f15950x != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", MBridgeBTWebView.this.f15767d);
                        jSONObject.put("code", BTBaseView.f15762n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", MBridgeBTWebView.this.f15767d);
                        jSONObject2.put("result", 2);
                        jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                        g.a().a(MBridgeBTWebView.this.f15950x, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e5) {
                        d.c().a(MBridgeBTWebView.this.f15950x, e5.getMessage());
                        af.a("RVWindVaneWebView", e5.getMessage());
                    }
                }
            }

            public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.a(webView, sslErrorHandler, sslError);
                if (MBridgeBTWebView.this.f15950x != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", MBridgeBTWebView.this.f15767d);
                        jSONObject.put("code", BTBaseView.f15762n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", MBridgeBTWebView.this.f15767d);
                        jSONObject2.put("result", 2);
                        jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, sslError.toString());
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                        g.a().a(MBridgeBTWebView.this.f15950x, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e5) {
                        d.c().a(MBridgeBTWebView.this.f15950x, e5.getMessage());
                        af.a("RVWindVaneWebView", e5.getMessage());
                    }
                }
            }

            public final void a(WebView webView, int i4) {
                super.a(webView, i4);
            }
        });
        addView(this.webView, new FrameLayout.LayoutParams(-1, -1));
        setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (MBridgeBTWebView.this.f15950x != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", BTBaseView.f15762n);
                        jSONObject.put("id", MBridgeBTWebView.this.f15767d);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("x", String.valueOf(view.getX()));
                        jSONObject2.put("y", String.valueOf(view.getY()));
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                        g.a().a(MBridgeBTWebView.this.f15950x, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception unused) {
                        d.c().a(MBridgeBTWebView.this.f15950x, "onClicked", MBridgeBTWebView.this.f15767d);
                    }
                }
            }
        });
        try {
            ImageView imageView = new ImageView(getContext());
            this.f15946t = imageView;
            imageView.setImageResource(findDrawable("mbridge_reward_close"));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
            layoutParams.gravity = 8388661;
            layoutParams.setMargins(30, 30, 30, 30);
            this.f15946t.setLayoutParams(layoutParams);
            ImageView imageView2 = this.f15946t;
            if (this.f15945s) {
                i4 = 4;
            } else {
                i4 = 8;
            }
            imageView2.setVisibility(i4);
            CampaignEx campaignEx = this.f15765b;
            if (campaignEx != null && campaignEx.isMraid()) {
                this.f15946t.setVisibility(4);
            }
            this.f15946t.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MBridgeBTWebView.this.close();
                }
            });
            addView(this.f15946t);
        } catch (Throwable th) {
            af.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void onBackPressed() {
        if (this.webView != null) {
            d.c().a((WebView) this.webView, "onSystemBackPressed", this.f15767d);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.webView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (configuration.orientation == 2) {
                    jSONObject.put("orientation", "landscape");
                } else {
                    jSONObject.put("orientation", "portrait");
                }
                jSONObject.put("instanceId", this.f15767d);
                g.a().a((WebView) this.webView, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public void onDestory() {
        if (!this.f15947u) {
            this.f15947u = true;
            try {
                if (this.webView != null) {
                    d.c().a((WebView) this.webView, "onSystemDestory", this.f15767d);
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        try {
                            WindVaneWebView windVaneWebView = MBridgeBTWebView.this.webView;
                            if (windVaneWebView != null) {
                                windVaneWebView.clearWebView();
                                MBridgeBTWebView.this.webView.release();
                            }
                            String unused = MBridgeBTWebView.this.f15942p = null;
                            String unused2 = MBridgeBTWebView.this.f15943q = null;
                            String unused3 = MBridgeBTWebView.this.f15944r = null;
                            if (MBridgeBTWebView.this.f15950x != null) {
                                WebView unused4 = MBridgeBTWebView.this.f15950x = null;
                            }
                        } catch (Throwable th) {
                            af.a(BTBaseView.TAG, th.getMessage());
                        }
                    }
                }, 500);
                setOnClickListener((View.OnClickListener) null);
                removeAllViews();
            } catch (Throwable th) {
                af.a(BTBaseView.TAG, th.getMessage());
            }
        }
    }

    public void onFinishRedirection(Campaign campaign, String str) {
        aj.a(campaign, this);
    }

    public void onRedirectionFailed(Campaign campaign, String str) {
        aj.a(campaign, this);
    }

    public void onStartRedirection(Campaign campaign, String str) {
        aj.b(campaign, this);
    }

    public void open(String str) {
        try {
            String clickURL = this.f15765b.getClickURL();
            if (!TextUtils.isEmpty(str)) {
                this.f15765b.setClickURL(str);
                reportOpen(str);
            }
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(getContext(), this.f15766c);
            aVar.a((i) this);
            aVar.a(this.f15765b);
            this.f15765b.setClickURL(clickURL);
        } catch (Throwable th) {
            af.b(BTBaseView.TAG, th.getMessage());
        }
    }

    public void preload() {
        if (!TextUtils.isEmpty(this.f15942p)) {
            this.webView.loadUrl(this.f15942p);
        } else if (!TextUtils.isEmpty(this.f15943q)) {
            this.webView.loadUrl(this.f15943q);
        } else if (!TextUtils.isEmpty(this.f15944r)) {
            this.webView.loadDataWithBaseURL("", this.f15944r, "text/html", C.UTF8_NAME, (String) null);
        }
    }

    public void reportOpen(String str) {
        try {
            CampaignEx mraidCampaign = getMraidCampaign();
            if (mraidCampaign != null) {
                new h(getContext()).a(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.f15766c, str, this.f15765b.isBidCampaign());
            }
        } catch (Throwable th) {
            af.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void setCampaigns(List<CampaignEx> list) {
        this.f15949w = list;
    }

    public void setCreateWebView(WebView webView) {
        this.f15950x = webView;
    }

    public void setFilePath(String str) {
        this.f15943q = str;
    }

    public void setFileURL(String str) {
        this.f15942p = str;
        if (!TextUtils.isEmpty(str)) {
            boolean contains = str.contains("play.google.com");
            setWebviewClickable(!contains);
            if (contains) {
                com.mbridge.msdk.mbsignalcommon.base.c cVar = new com.mbridge.msdk.mbsignalcommon.base.c();
                WindVaneWebView windVaneWebView = this.webView;
                if (windVaneWebView != null) {
                    windVaneWebView.setFilter(cVar);
                }
            }
        }
    }

    public void setHtml(String str) {
        this.f15944r = str;
    }

    public void setRewardUnitSetting(c cVar) {
        this.f15948v = cVar;
    }

    public void setTempTypeForMetrics(int i4) {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView != null) {
            windVaneWebView.setTempTypeForMetrics(i4);
        }
    }

    public void setWebViewLocalRequestId(String str) {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView != null) {
            windVaneWebView.setLocalRequestId(str);
        }
    }

    public void setWebViewRid(String str) {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView != null) {
            windVaneWebView.setRid(str);
        }
    }

    public void setWebviewClickable(boolean z4) {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView != null) {
            windVaneWebView.setClickable(z4);
        }
    }

    public void unload() {
        close();
    }

    public void useCustomClose(boolean z4) {
        int i4;
        try {
            ImageView imageView = this.f15946t;
            if (z4) {
                i4 = 4;
            } else {
                i4 = 0;
            }
            imageView.setVisibility(i4);
        } catch (Throwable th) {
            af.b(BTBaseView.TAG, th.getMessage());
        }
    }

    public boolean webviewGoBack() {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView == null || !windVaneWebView.canGoBack()) {
            return false;
        }
        this.webView.goBack();
        return true;
    }

    public boolean webviewGoForward() {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView == null || !windVaneWebView.canGoForward()) {
            return false;
        }
        this.webView.goForward();
        return true;
    }

    public void webviewLoad(int i4) {
        if (this.jsCommon == null) {
            this.jsCommon = new k((Activity) null, this.f15765b, this.f15949w);
        }
        CampaignEx campaignEx = this.f15765b;
        if (campaignEx != null) {
            this.jsCommon.a(campaignEx);
        } else {
            List<CampaignEx> list = this.f15949w;
            if (list != null && list.size() > 0) {
                this.jsCommon.a(this.f15949w);
                if (this.f15949w.size() == 1) {
                    this.jsCommon.a(this.f15949w.get(0));
                }
            }
        }
        c cVar = this.f15948v;
        if (cVar != null) {
            this.jsCommon.a(cVar);
        }
        this.jsCommon.a(this.f15766c);
        this.jsCommon.c(this.f15767d);
        if (b.a()) {
            setChinaAlertInstallState(this.jsCommon);
        }
        if (i4 == 1) {
            this.jsCommon.q();
        }
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView != null) {
            windVaneWebView.setObject(this.jsCommon);
        }
        CampaignEx campaignEx2 = this.f15765b;
        if (campaignEx2 != null && campaignEx2.isMraid()) {
            this.f15946t.setVisibility(4);
        }
        preload();
    }

    public boolean webviewReload() {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView == null) {
            return false;
        }
        windVaneWebView.reload();
        return true;
    }

    public MBridgeBTWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
