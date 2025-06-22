package com.mbridge.msdk.mbbanner.a;

import android.text.TextUtils;
import android.view.View;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.j;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.as;
import com.mbridge.msdk.mbbanner.common.b.b;
import com.mbridge.msdk.mbbanner.common.c.c;
import com.mbridge.msdk.out.BannerAdListener;
import com.mbridge.msdk.out.BannerSize;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.List;

public final class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static String f13832a = "BannerController";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f13833b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f13834c;

    /* renamed from: d  reason: collision with root package name */
    private String f13835d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public MBridgeIds f13836e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13837f;

    /* renamed from: g  reason: collision with root package name */
    private int f13838g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public MBBannerView f13839h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f13840i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f13841j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f13842k;

    /* renamed from: l  reason: collision with root package name */
    private int f13843l = -1;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public BannerAdListener f13844m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public CampaignUnit f13845n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public c f13846o;

    /* renamed from: p  reason: collision with root package name */
    private k f13847p;

    /* renamed from: q  reason: collision with root package name */
    private j f13848q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f13849r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f13850s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f13851t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public boolean f13852u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public boolean f13853v;

    /* renamed from: w  reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.b.c f13854w = new com.mbridge.msdk.mbbanner.common.b.c() {
        public final void a(List<CampaignEx> list) {
            af.b(a.f13832a, "onShowSuccessed:");
            if (a.this.f13844m != null) {
                a.this.f13844m.onLoadSuccessed(a.this.f13836e);
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.c a5 = com.mbridge.msdk.mbbanner.common.d.a.a(a.this.f13833b, list.get(0).getLocalRequestId());
                a5.b(list);
                int i4 = 1;
                a5.g(1);
                if (TextUtils.isEmpty(list.get(0).getBannerUrl())) {
                    i4 = 2;
                }
                a5.f(i4);
                com.mbridge.msdk.mbbanner.common.d.a.a("2000048", a5, (e) null);
            } catch (Exception e5) {
                af.b(a.f13832a, e5.getMessage());
            }
        }

        public final void b() {
            if (a.this.f13844m != null) {
                a.this.f13844m.onLeaveApp(a.this.f13836e);
            }
        }

        public final void c() {
            if (a.this.f13844m != null) {
                a.this.f13844m.showFullScreen(a.this.f13836e);
                boolean unused = a.this.f13853v = true;
                com.mbridge.msdk.mbbanner.common.c.a.a().a(2, a.this.f13834c, a.this.f13833b, (com.mbridge.msdk.mbbanner.common.a.a) null, (b) null);
            }
        }

        public final void d() {
            if (a.this.f13844m != null) {
                a.this.f13844m.closeFullScreen(a.this.f13836e);
                boolean unused = a.this.f13853v = false;
                com.mbridge.msdk.mbbanner.common.c.a a5 = com.mbridge.msdk.mbbanner.common.c.a.a();
                String f4 = a.this.f13834c;
                String c5 = a.this.f13833b;
                a5.a(3, f4, c5, new com.mbridge.msdk.mbbanner.common.a.a(a.this.f13841j + "x" + a.this.f13840i, a.this.f13842k * 1000), a.this.f13855x);
            }
        }

        public final void e() {
            if (a.this.f13844m != null) {
                a.this.f13844m.onCloseBanner(a.this.f13836e);
            }
        }

        public final void a(CampaignEx campaignEx) {
            a.this.d();
            if (a.this.f13844m != null) {
                a.this.f13844m.onLogImpression(a.this.f13836e);
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.c a5 = com.mbridge.msdk.mbbanner.common.d.a.a(a.this.f13833b, campaignEx.getLocalRequestId());
                a5.a(campaignEx);
                a5.i(campaignEx.isBidCampaign() ? "1" : "2");
                int i4 = 1;
                a5.g(a.this.f13846o != null ? a.this.f13846o.b() : 1);
                if (a.this.f13842k != 0) {
                    i4 = 2;
                }
                a5.d(i4);
                a5.e(a.this.f13842k);
                com.mbridge.msdk.mbbanner.common.d.a.a("2000128", a5, (e) null);
                com.mbridge.msdk.mbbanner.common.d.a.a("2000130", a5, (e) null);
            } catch (Exception e5) {
                af.b(a.f13832a, e5.getMessage());
            }
        }

        public final void a(com.mbridge.msdk.foundation.c.b bVar) {
            a.this.a(bVar);
        }

        public final void a() {
            if (a.this.f13844m != null) {
                a.this.f13844m.onClick(a.this.f13836e);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public b f13855x = new b() {
        public final void a(String str, CampaignUnit campaignUnit, boolean z4) {
            CampaignUnit unused = a.this.f13845n = campaignUnit;
            a.a(a.this, 1, (com.mbridge.msdk.foundation.c.b) null);
        }

        public final void b(com.mbridge.msdk.foundation.c.b bVar) {
            a.this.a(bVar.f(), bVar);
            a.this.d();
        }

        public final void a(com.mbridge.msdk.foundation.c.b bVar) {
            a.a(a.this, 2, bVar);
            a.this.a(bVar.f(), bVar);
            a.this.d();
        }

        public final void a(String str, int i4, boolean z4) {
            if (a.this.f13839h != null) {
                boolean unused = a.this.f13852u = true;
                a.this.i();
            }
        }
    };

    public a(MBBannerView mBBannerView, BannerSize bannerSize, String str, String str2) {
        this.f13839h = mBBannerView;
        if (bannerSize != null) {
            this.f13840i = bannerSize.getHeight();
            this.f13841j = bannerSize.getWidth();
        }
        this.f13833b = str2;
        str = TextUtils.isEmpty(str) ? "" : str;
        this.f13834c = str;
        this.f13836e = new MBridgeIds(str, this.f13833b);
        String k4 = com.mbridge.msdk.foundation.controller.c.m().k();
        String b5 = com.mbridge.msdk.foundation.controller.c.m().b();
        if (this.f13848q == null) {
            this.f13848q = new j();
        }
        this.f13848q.a(com.mbridge.msdk.foundation.controller.c.m().c(), k4, b5, this.f13833b);
        h();
    }

    private int b(int i4) {
        if (i4 > 0) {
            if (i4 < 10) {
                return 10;
            }
            if (i4 > 180) {
                return SubsamplingScaleImageView.ORIENTATION_180;
            }
        }
        return i4;
    }

    private void h() {
        k d5 = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f13833b);
        this.f13847p = d5;
        if (d5 == null) {
            this.f13847p = k.d(this.f13833b);
        }
        if (this.f13843l == -1) {
            this.f13842k = b(this.f13847p.q());
        }
        if (this.f13838g == 0) {
            boolean z4 = true;
            if (this.f13847p.f() != 1) {
                z4 = false;
            }
            this.f13837f = z4;
            c cVar = this.f13846o;
            if (cVar != null) {
                cVar.a(z4);
            }
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        if (!this.f13851t && this.f13852u) {
            MBBannerView mBBannerView = this.f13839h;
            if (this.f13845n != null) {
                if (this.f13846o == null) {
                    this.f13846o = new c(mBBannerView, this.f13854w, this.f13834c, this.f13833b, this.f13837f, this.f13847p);
                }
                this.f13846o.a(this.f13835d);
                this.f13846o.b(this.f13849r);
                this.f13846o.c(this.f13850s);
                this.f13846o.a(this.f13837f, this.f13838g);
                this.f13846o.a(this.f13845n);
            } else {
                a(new com.mbridge.msdk.foundation.c.b(880043));
            }
            this.f13852u = false;
        }
    }

    private void j() {
        MBBannerView mBBannerView = this.f13839h;
        if (mBBannerView != null) {
            if (!this.f13849r || !this.f13850s || this.f13853v || as.a((View) mBBannerView, 1)) {
                com.mbridge.msdk.mbbanner.common.c.a.a().a(2, this.f13834c, this.f13833b, (com.mbridge.msdk.mbbanner.common.a.a) null, (b) null);
            } else {
                com.mbridge.msdk.mbbanner.common.c.a a5 = com.mbridge.msdk.mbbanner.common.c.a.a();
                String str = this.f13834c;
                String str2 = this.f13833b;
                a5.a(3, str, str2, new com.mbridge.msdk.mbbanner.common.a.a(this.f13841j + "x" + this.f13840i, this.f13842k * 1000), this.f13855x);
            }
            if (!this.f13849r) {
                com.mbridge.msdk.mbbanner.common.c.a.a().a(4, this.f13834c, this.f13833b, (com.mbridge.msdk.mbbanner.common.a.a) null, (b) null);
                com.mbridge.msdk.mbbanner.common.c.a.a().a(this.f13833b);
            }
        }
    }

    private void k() {
        j();
        c cVar = this.f13846o;
        if (cVar != null) {
            cVar.b(this.f13849r);
            this.f13846o.c(this.f13850s);
        }
    }

    public final void c() {
        this.f13851t = true;
        if (this.f13844m != null) {
            this.f13844m = null;
        }
        if (this.f13855x != null) {
            this.f13855x = null;
        }
        if (this.f13854w != null) {
            this.f13854w = null;
        }
        if (this.f13839h != null) {
            this.f13839h = null;
        }
        com.mbridge.msdk.mbbanner.common.c.a.a().a(4, this.f13834c, this.f13833b, (com.mbridge.msdk.mbbanner.common.a.a) null, (b) null);
        com.mbridge.msdk.mbbanner.common.c.a.a().a(this.f13833b);
        com.mbridge.msdk.mbbanner.common.c.a.a().b();
        c cVar = this.f13846o;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void d() {
        if (!this.f13851t) {
            j();
            h();
            com.mbridge.msdk.mbbanner.common.a.a aVar = new com.mbridge.msdk.mbbanner.common.a.a(this.f13841j + "x" + this.f13840i, this.f13842k * 1000);
            aVar.b(this.f13834c);
            aVar.a(true);
            aVar.c(com.mbridge.msdk.mbbanner.common.d.a.a(""));
            com.mbridge.msdk.mbbanner.common.c.a.a().b(this.f13834c, this.f13833b, aVar, this.f13855x);
        }
    }

    public final void e() {
        com.mbridge.msdk.mbbanner.common.c.a a5 = com.mbridge.msdk.mbbanner.common.c.a.a();
        String str = this.f13834c;
        String str2 = this.f13833b;
        a5.a(4, str, str2, new com.mbridge.msdk.mbbanner.common.a.a(this.f13841j + "x" + this.f13840i, this.f13842k * 1000), this.f13855x);
    }

    public final void f() {
        com.mbridge.msdk.mbbanner.common.c.a a5 = com.mbridge.msdk.mbbanner.common.c.a.a();
        String str = this.f13834c;
        String str2 = this.f13833b;
        a5.a(3, str, str2, new com.mbridge.msdk.mbbanner.common.a.a(this.f13841j + "x" + this.f13840i, this.f13842k * 1000), this.f13855x);
    }

    public final String b() {
        CampaignUnit campaignUnit = this.f13845n;
        if (campaignUnit != null) {
            return com.mbridge.msdk.foundation.same.c.a((List<CampaignEx>) campaignUnit.getAds());
        }
        return "";
    }

    public final String a() {
        CampaignUnit campaignUnit = this.f13845n;
        if (campaignUnit == null || campaignUnit.getRequestId() == null) {
            return "";
        }
        return this.f13845n.getRequestId();
    }

    public final void b(boolean z4) {
        this.f13849r = z4;
        k();
        i();
    }

    /* access modifiers changed from: private */
    public void a(String str, com.mbridge.msdk.foundation.c.b bVar) {
        CampaignUnit campaignUnit;
        String str2 = "";
        if (bVar != null) {
            try {
                str2 = bVar.b();
                if (TextUtils.isEmpty(str)) {
                    str = bVar.f();
                }
            } catch (Throwable th) {
                af.b(f13832a, th.getMessage());
            }
        }
        if (TextUtils.isEmpty(str) && (campaignUnit = this.f13845n) != null) {
            str = campaignUnit.getLocalRequestId();
        }
        com.mbridge.msdk.foundation.same.report.d.c a5 = com.mbridge.msdk.mbbanner.common.d.a.a(this.f13833b, str);
        CampaignUnit campaignUnit2 = this.f13845n;
        a5.b((List<CampaignEx>) campaignUnit2 != null ? campaignUnit2.getAds() : null);
        a5.a(bVar);
        CampaignUnit campaignUnit3 = this.f13845n;
        if (campaignUnit3 != null && !campaignUnit3.getAds().isEmpty()) {
            a5.f(TextUtils.isEmpty(this.f13845n.getAds().get(0).getBannerUrl()) ? 1 : 2);
        }
        a5.c(true);
        com.mbridge.msdk.mbbanner.common.d.a.a("2000047", a5, (e) null);
        BannerAdListener bannerAdListener = this.f13844m;
        if (bannerAdListener != null) {
            bannerAdListener.onLoadFailed(this.f13836e, str2);
        }
    }

    public final void c(boolean z4) {
        this.f13850s = z4;
        k();
    }

    public final void a(BannerSize bannerSize) {
        if (bannerSize != null) {
            this.f13840i = bannerSize.getHeight();
            this.f13841j = bannerSize.getWidth();
        }
    }

    public final void a(int i4) {
        int b5 = b(i4);
        this.f13843l = b5;
        this.f13842k = b5;
    }

    public final void a(boolean z4) {
        this.f13837f = z4;
        this.f13838g = z4 ? 1 : 2;
    }

    public final void a(String str, String str2) {
        boolean z4;
        if (this.f13840i < 1 || this.f13841j < 1) {
            a(str2, new com.mbridge.msdk.foundation.c.b(880037));
            return;
        }
        try {
            z4 = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.a(com.mbridge.msdk.foundation.controller.c.m().c());
        } catch (Exception e5) {
            af.b(f13832a, e5.getMessage());
            z4 = false;
        }
        if (!z4) {
            a(str2, new com.mbridge.msdk.foundation.c.b(880029));
            return;
        }
        this.f13835d = str2;
        com.mbridge.msdk.mbbanner.common.a.a aVar = new com.mbridge.msdk.mbbanner.common.a.a(this.f13841j + "x" + this.f13840i, this.f13842k * 1000);
        aVar.a(str);
        aVar.b(this.f13834c);
        aVar.c(str2);
        com.mbridge.msdk.mbbanner.common.c.a.a().a(this.f13834c, this.f13833b, aVar, this.f13855x);
        com.mbridge.msdk.mbbanner.common.c.a.a().a(1, this.f13834c, this.f13833b, aVar, this.f13855x);
    }

    public final void a(BannerAdListener bannerAdListener) {
        this.f13844m = bannerAdListener;
    }

    /* access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.c.b bVar) {
        a(this.f13835d, bVar);
        d();
    }

    public final void a(int i4, int i5, int i6, int i7) {
        c cVar = this.f13846o;
        if (cVar != null) {
            cVar.a(i4, i5, i6, i7);
        }
    }

    static /* synthetic */ void a(a aVar, int i4, com.mbridge.msdk.foundation.c.b bVar) {
        try {
            com.mbridge.msdk.foundation.same.report.d.c a5 = com.mbridge.msdk.mbbanner.common.d.a.a(aVar.f13833b, bVar == null ? aVar.f13845n.getLocalRequestId() : bVar.f());
            e eVar = new e();
            eVar.a("result", Integer.valueOf(i4));
            CampaignUnit campaignUnit = aVar.f13845n;
            if (campaignUnit != null && !campaignUnit.getAds().isEmpty()) {
                CampaignEx campaignEx = aVar.f13845n.getAds().get(0);
                if (campaignEx != null) {
                    a5.f(TextUtils.isEmpty(campaignEx.getBannerUrl()) ? 2 : 1);
                }
                a5.b((List<CampaignEx>) aVar.f13845n.getAds());
            }
            if (bVar != null) {
                a5.a(bVar);
            }
            com.mbridge.msdk.mbbanner.common.d.a.a("2000126", a5, eVar);
        } catch (Exception e5) {
            af.b(f13832a, e5.getMessage());
        }
    }
}
