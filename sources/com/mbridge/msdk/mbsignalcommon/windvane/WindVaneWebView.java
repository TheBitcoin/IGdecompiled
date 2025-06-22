package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;
import com.mbridge.msdk.mbsignalcommon.base.b;

public class WindVaneWebView extends BaseWebView {

    /* renamed from: b  reason: collision with root package name */
    protected k f14134b;

    /* renamed from: c  reason: collision with root package name */
    protected c f14135c;

    /* renamed from: d  reason: collision with root package name */
    protected f f14136d;

    /* renamed from: e  reason: collision with root package name */
    private Object f14137e;

    /* renamed from: f  reason: collision with root package name */
    private Object f14138f;

    /* renamed from: g  reason: collision with root package name */
    private String f14139g;

    /* renamed from: h  reason: collision with root package name */
    private d f14140h;

    /* renamed from: i  reason: collision with root package name */
    private String f14141i;

    /* renamed from: j  reason: collision with root package name */
    private String f14142j;

    /* renamed from: k  reason: collision with root package name */
    private CampaignEx f14143k;

    /* renamed from: l  reason: collision with root package name */
    private int f14144l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f14145m = false;

    /* renamed from: n  reason: collision with root package name */
    private float f14146n = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    private float f14147o = 0.0f;

    public WindVaneWebView(Context context) {
        super(context);
    }

    public void clearWebView() {
        if (!this.f14145m) {
            loadUrl("about:blank");
        }
    }

    public CampaignEx getCampaignEx() {
        return this.f14143k;
    }

    public String getCampaignId() {
        return this.f14139g;
    }

    public Object getJsObject(String str) {
        f fVar = this.f14136d;
        if (fVar == null) {
            return null;
        }
        return fVar.a(str);
    }

    public String getLocalRequestId() {
        return this.f14142j;
    }

    public Object getMraidObject() {
        return this.f14138f;
    }

    public Object getObject() {
        return this.f14137e;
    }

    public String getRid() {
        return this.f14141i;
    }

    public c getSignalCommunication() {
        return this.f14135c;
    }

    public d getWebViewListener() {
        return this.f14140h;
    }

    public boolean isDestoryed() {
        return this.f14145m;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar = this.mWebViewClient;
        if (bVar != null && (bVar.b() instanceof IntentFilter)) {
            String url = getUrl();
            if (!TextUtils.isEmpty(url) && url.contains("https://play.google.com")) {
                if (motionEvent.getAction() == 0) {
                    this.f14146n = motionEvent.getRawX();
                    this.f14147o = motionEvent.getRawY();
                } else {
                    float rawX = motionEvent.getRawX() - this.f14146n;
                    float y4 = motionEvent.getY() - this.f14147o;
                    if ((rawX >= 0.0f || rawX * -1.0f <= ((float) 48)) && ((rawX <= 0.0f || rawX <= ((float) 48)) && ((y4 >= 0.0f || -1.0f * y4 <= ((float) 48)) && (y4 <= 0.0f || y4 <= ((float) 48))))) {
                        setClickable(false);
                        return true;
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void registerWindVanePlugin(Class cls) {
        f fVar = this.f14136d;
        if (fVar != null) {
            fVar.a(cls.getSimpleName(), cls);
        }
    }

    public void release() {
        try {
            if (!this.f14145m) {
                e eVar = new e();
                eVar.a("type", Integer.valueOf(this.f14144l));
                d.a().a("2000135", this.f14143k, eVar);
            }
        } catch (Exception unused) {
        }
        try {
            setVisibility(8);
            removeAllViews();
            setDownloadListener((DownloadListener) null);
            this.f14137e = null;
            int b5 = ak.b(getContext());
            if (b5 == 0) {
                this.f14145m = true;
                destroy();
                return;
            }
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    boolean unused = WindVaneWebView.this.f14145m = true;
                    WindVaneWebView.this.destroy();
                }
            }, (long) (b5 * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setApiManagerContext(Context context) {
        f fVar = this.f14136d;
        if (fVar != null) {
            fVar.a(context);
        }
    }

    public void setApiManagerJSFactory(Object obj) {
        f fVar = this.f14136d;
        if (fVar != null) {
            fVar.a(obj);
        }
    }

    public void setCampaignEx(CampaignEx campaignEx) {
        this.f14143k = campaignEx;
    }

    public void setCampaignId(String str) {
        this.f14139g = str;
    }

    public void setLocalRequestId(String str) {
        this.f14142j = str;
    }

    public void setMraidObject(Object obj) {
        this.f14138f = obj;
    }

    public void setObject(Object obj) {
        this.f14137e = obj;
    }

    public void setRid(String str) {
        this.f14141i = str;
    }

    public void setSignalCommunication(c cVar) {
        this.f14135c = cVar;
        cVar.a(this);
    }

    public void setTempTypeForMetrics(int i4) {
        this.f14144l = i4;
    }

    public void setWebViewChromeClient(k kVar) {
        this.f14134b = kVar;
        setWebChromeClient(kVar);
    }

    public void setWebViewListener(d dVar) {
        this.f14140h = dVar;
        k kVar = this.f14134b;
        if (kVar != null) {
            kVar.a(dVar);
        }
        b bVar = this.mWebViewClient;
        if (bVar != null) {
            bVar.a(dVar);
        }
    }

    public void setWebViewTransparent() {
        super.setTransparent();
    }

    /* access modifiers changed from: protected */
    public final void a() {
        super.a();
        getSettings().setSavePassword(false);
        WebSettings settings = getSettings();
        settings.setUserAgentString(getSettings().getUserAgentString() + " WindVane/3.0.2");
        if (this.f14134b == null) {
            this.f14134b = new k(this);
        }
        setWebViewChromeClient(this.f14134b);
        l lVar = new l();
        this.mWebViewClient = lVar;
        setWebViewClient(lVar);
        if (this.f14135c == null) {
            i iVar = new i(this.f14032a);
            this.f14135c = iVar;
            setSignalCommunication(iVar);
        }
        this.f14136d = new f(this.f14032a, this);
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
