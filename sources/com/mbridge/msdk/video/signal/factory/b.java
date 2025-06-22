package com.mbridge.msdk.video.signal.factory;

import android.app.Activity;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.a;
import com.mbridge.msdk.video.signal.a.i;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.a.m;
import com.mbridge.msdk.video.signal.a.n;
import com.mbridge.msdk.video.signal.a.o;
import com.mbridge.msdk.video.signal.a.q;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.g;
import java.util.List;

public final class b extends a {

    /* renamed from: h  reason: collision with root package name */
    private Activity f16928h;

    /* renamed from: i  reason: collision with root package name */
    private WebView f16929i;

    /* renamed from: j  reason: collision with root package name */
    private MBridgeVideoView f16930j;

    /* renamed from: k  reason: collision with root package name */
    private MBridgeContainerView f16931k;

    /* renamed from: l  reason: collision with root package name */
    private CampaignEx f16932l;

    /* renamed from: m  reason: collision with root package name */
    private MBridgeBTContainer f16933m;

    /* renamed from: n  reason: collision with root package name */
    private a.C0206a f16934n;

    /* renamed from: o  reason: collision with root package name */
    private String f16935o;

    /* renamed from: p  reason: collision with root package name */
    private List<CampaignEx> f16936p;

    public b(Activity activity) {
        this.f16928h = activity;
    }

    public final void a(k kVar) {
        this.f16922b = kVar;
    }

    public final com.mbridge.msdk.video.signal.b getActivityProxy() {
        WebView webView = this.f16929i;
        if (webView == null) {
            return super.getActivityProxy();
        }
        if (this.f16921a == null) {
            this.f16921a = new i(webView);
        }
        return this.f16921a;
    }

    public final com.mbridge.msdk.video.signal.i getIJSRewardVideoV1() {
        Activity activity;
        MBridgeContainerView mBridgeContainerView = this.f16931k;
        if (mBridgeContainerView == null || (activity = this.f16928h) == null) {
            return super.getIJSRewardVideoV1();
        }
        if (this.f16926f == null) {
            this.f16926f = new o(activity, mBridgeContainerView);
        }
        return this.f16926f;
    }

    public final c getJSBTModule() {
        if (this.f16928h == null || this.f16933m == null) {
            return super.getJSBTModule();
        }
        if (this.f16927g == null) {
            this.f16927g = new j(this.f16928h, this.f16933m);
        }
        return this.f16927g;
    }

    public final d getJSCommon() {
        CampaignEx campaignEx;
        List<CampaignEx> list;
        Activity activity = this.f16928h;
        if (activity == null || (campaignEx = this.f16932l) == null) {
            return super.getJSCommon();
        }
        if (this.f16922b == null) {
            this.f16922b = new k(activity, campaignEx);
        }
        if (this.f16932l.getDynamicTempCode() == 5 && (list = this.f16936p) != null) {
            d dVar = this.f16922b;
            if (dVar instanceof k) {
                ((k) dVar).a(list);
            }
        }
        this.f16922b.a(this.f16928h);
        this.f16922b.a(this.f16935o);
        this.f16922b.a(this.f16934n);
        return this.f16922b;
    }

    public final f getJSContainerModule() {
        MBridgeContainerView mBridgeContainerView = this.f16931k;
        if (mBridgeContainerView == null) {
            return super.getJSContainerModule();
        }
        if (this.f16925e == null) {
            this.f16925e = new m(mBridgeContainerView);
        }
        return this.f16925e;
    }

    public final g getJSNotifyProxy() {
        WebView webView = this.f16929i;
        if (webView == null) {
            return super.getJSNotifyProxy();
        }
        if (this.f16924d == null) {
            this.f16924d = new n(webView);
        }
        return this.f16924d;
    }

    public final com.mbridge.msdk.video.signal.j getJSVideoModule() {
        MBridgeVideoView mBridgeVideoView = this.f16930j;
        if (mBridgeVideoView == null) {
            return super.getJSVideoModule();
        }
        if (this.f16923c == null) {
            this.f16923c = new q(mBridgeVideoView);
        }
        return this.f16923c;
    }

    public final void a(List<CampaignEx> list) {
        this.f16936p = list;
    }

    public b(Activity activity, MBridgeBTContainer mBridgeBTContainer, WebView webView) {
        this.f16928h = activity;
        this.f16933m = mBridgeBTContainer;
        this.f16929i = webView;
    }

    public b(Activity activity, WebView webView, MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, a.C0206a aVar) {
        this.f16928h = activity;
        this.f16929i = webView;
        this.f16930j = mBridgeVideoView;
        this.f16931k = mBridgeContainerView;
        this.f16932l = campaignEx;
        this.f16934n = aVar;
        this.f16935o = mBridgeVideoView.getUnitId();
    }
}
