package com.mbridge.msdk.video.module.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.d;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.a.b;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class k extends f {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f16526a;

    /* renamed from: b  reason: collision with root package name */
    protected CampaignEx f16527b;

    /* renamed from: c  reason: collision with root package name */
    protected List<CampaignEx> f16528c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f16529d = false;

    /* renamed from: e  reason: collision with root package name */
    protected a f16530e;

    /* renamed from: f  reason: collision with root package name */
    protected c f16531f;

    /* renamed from: g  reason: collision with root package name */
    protected String f16532g;

    /* renamed from: h  reason: collision with root package name */
    protected String f16533h;

    /* renamed from: i  reason: collision with root package name */
    protected com.mbridge.msdk.video.module.a.a f16534i = new f();

    /* renamed from: j  reason: collision with root package name */
    protected int f16535j = 1;

    /* renamed from: k  reason: collision with root package name */
    private boolean f16536k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f16537l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f16538m = false;

    public k(CampaignEx campaignEx, a aVar, c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i4, boolean z4) {
        if (!z4 && campaignEx != null && ap.b(str2) && aVar != null && aVar2 != null) {
            this.f16527b = campaignEx;
            this.f16533h = str;
            this.f16532g = str2;
            this.f16530e = aVar;
            this.f16531f = cVar;
            this.f16534i = aVar2;
            this.f16526a = true;
            this.f16535j = i4;
            this.f16529d = false;
        } else if (z4 && campaignEx != null && ap.b(str2) && aVar2 != null) {
            this.f16527b = campaignEx;
            this.f16533h = str;
            this.f16532g = str2;
            this.f16530e = aVar;
            this.f16531f = cVar;
            this.f16534i = aVar2;
            this.f16526a = true;
            this.f16535j = i4;
            this.f16529d = true;
        }
    }

    public final void a(CampaignEx campaignEx) {
        this.f16527b = campaignEx;
    }

    public final void b(int i4) {
        CampaignEx campaignEx = this.f16527b;
        if (campaignEx != null) {
            String noticeUrl = campaignEx.getNoticeUrl();
            if (TextUtils.isEmpty(noticeUrl)) {
                return;
            }
            if (i4 == 1 || i4 == 2) {
                if (!noticeUrl.contains("endscreen_type")) {
                    StringBuilder sb = new StringBuilder(noticeUrl);
                    if (noticeUrl.contains("?")) {
                        sb.append("&endscreen_type=");
                        sb.append(i4);
                    } else {
                        sb.append("?endscreen_type=");
                        sb.append(i4);
                    }
                    noticeUrl = sb.toString();
                } else if (i4 == 2) {
                    if (noticeUrl.contains("endscreen_type=1")) {
                        noticeUrl = noticeUrl.replace("endscreen_type=1", "endscreen_type=2");
                    }
                } else if (noticeUrl.contains("endscreen_type=2")) {
                    noticeUrl = noticeUrl.replace("endscreen_type=2", "endscreen_type=1");
                }
                this.f16527b.setNoticeUrl(noticeUrl);
            }
        }
    }

    public final void c() {
        try {
            AnonymousClass2 r02 = new Runnable() {
                public final void run() {
                    try {
                        k kVar = k.this;
                        if (kVar.f16526a && kVar.f16527b != null && ap.b(kVar.f16532g)) {
                            com.mbridge.msdk.videocommon.a.a a5 = com.mbridge.msdk.videocommon.a.a.a();
                            k kVar2 = k.this;
                            a5.a(kVar2.f16527b, kVar2.f16532g);
                        }
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                    try {
                        com.mbridge.msdk.videocommon.a.a a6 = com.mbridge.msdk.videocommon.a.a.a();
                        k kVar3 = k.this;
                        a6.c(kVar3.f16533h, kVar3.f16527b.getAdType());
                    } catch (Exception e6) {
                        if (MBridgeConstans.DEBUG) {
                            e6.printStackTrace();
                        }
                    } catch (Throwable th) {
                        af.a("NotifyListener", th.getMessage());
                    }
                }
            };
            d.a();
            com.mbridge.msdk.foundation.same.f.a.b().execute(r02);
        } catch (Throwable th) {
            af.b("NotifyListener", th.getMessage(), th);
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        a aVar = this.f16530e;
        if (aVar != null) {
            aVar.f(true);
        }
    }

    /* access modifiers changed from: protected */
    public final void e() {
        CampaignEx campaignEx;
        Map<String, Long> map;
        String str;
        try {
            CampaignEx campaignEx2 = this.f16527b;
            if (campaignEx2 != null && campaignEx2.isDynamicView() && this.f16529d && !this.f16527b.isCampaignIsFiltered()) {
                this.f16537l = true;
            } else if (this.f16526a && (campaignEx = this.f16527b) != null && !TextUtils.isEmpty(campaignEx.getOnlyImpressionURL()) && (map = b.f13166k) != null && !map.containsKey(this.f16527b.getOnlyImpressionURL()) && !this.f16537l) {
                b.f13166k.put(this.f16527b.getOnlyImpressionURL(), Long.valueOf(System.currentTimeMillis()));
                String onlyImpressionURL = this.f16527b.getOnlyImpressionURL();
                if (this.f16527b.getSpareOfferFlag() == 1) {
                    str = onlyImpressionURL + "&to=1&cbt=" + this.f16527b.getCbt() + "&tmorl=" + this.f16535j;
                } else {
                    str = onlyImpressionURL + "&to=0&cbt=" + this.f16527b.getCbt() + "&tmorl=" + this.f16535j;
                }
                String str2 = str;
                if (!this.f16529d || this.f16527b.isCampaignIsFiltered()) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f16527b, this.f16532g, str2, false, true, com.mbridge.msdk.click.a.a.f12015h);
                    c();
                }
                this.f16537l = true;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final void f() {
        String str;
        try {
            if (this.f16526a && !this.f16536k && !TextUtils.isEmpty(this.f16527b.getImpressionURL())) {
                this.f16536k = true;
                if (this.f16527b.isBidCampaign() && this.f16527b != null) {
                    HashMap hashMap = new HashMap();
                    List<com.mbridge.msdk.foundation.entity.d> a5 = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(this.f16527b.getCampaignUnitId(), this.f16527b.getRequestId());
                    if (!(a5 == null || a5.size() <= 0 || a5.get(0) == null)) {
                        if (a5.get(0).c() == 1) {
                            hashMap.put("encrypt_p=", "encrypt_p=" + a5.get(0).b());
                            hashMap.put("irlfa=", "irlfa=" + 1);
                            for (Map.Entry entry : hashMap.entrySet()) {
                                String str2 = (String) entry.getKey();
                                String str3 = (String) entry.getValue();
                                CampaignEx campaignEx = this.f16527b;
                                campaignEx.setImpressionURL(campaignEx.getImpressionURL().replaceAll(str2, str3));
                                CampaignEx campaignEx2 = this.f16527b;
                                campaignEx2.setOnlyImpressionURL(campaignEx2.getOnlyImpressionURL().replaceAll(str2, str3));
                            }
                        }
                        af.a("BidReplaceCampignDao", "removeReplace count " + com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(this.f16527b.getRequestId()));
                    }
                }
                String impressionURL = this.f16527b.getImpressionURL();
                if (this.f16527b.getSpareOfferFlag() == 1) {
                    str = impressionURL + "&to=1&cbt=" + this.f16527b.getCbt() + "&tmorl=" + this.f16535j;
                } else {
                    str = impressionURL + "&to=0&cbt=" + this.f16527b.getCbt() + "&tmorl=" + this.f16535j;
                }
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f16527b, this.f16532g, str, false, true, com.mbridge.msdk.click.a.a.f12014g);
                com.mbridge.msdk.video.module.b.b.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f16527b);
                new Thread(new Runnable() {
                    public final void run() {
                        try {
                            j.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(k.this.f16527b.getId());
                        } catch (Throwable th) {
                            af.b("NotifyListener", th.getMessage(), th);
                        }
                    }
                }).start();
                if (this.f16526a && b.f13165j != null && !TextUtils.isEmpty(this.f16527b.getId())) {
                    b.a(this.f16532g, this.f16527b, "reward");
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        } catch (Throwable th) {
            af.b("NotifyListener", th.getMessage(), th);
        }
    }

    /* access modifiers changed from: protected */
    public final void g() {
        CampaignEx campaignEx;
        try {
            if (this.f16526a && !this.f16538m && (campaignEx = this.f16527b) != null) {
                this.f16538m = true;
                if (!campaignEx.isDynamicView() || !this.f16529d || this.f16527b.isCampaignIsFiltered()) {
                    List<String> pv_urls = this.f16527b.getPv_urls();
                    if (pv_urls != null && pv_urls.size() > 0) {
                        for (String a5 : pv_urls) {
                            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f16527b, this.f16532g, a5, false, true);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            af.b("NotifyListener", th.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void h() {
        CampaignEx campaignEx = this.f16527b;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCampaignUnitId()) && this.f16527b.getNativeVideoTracking() != null && this.f16527b.getNativeVideoTracking().o() != null) {
            Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
            CampaignEx campaignEx2 = this.f16527b;
            com.mbridge.msdk.click.a.a(c5, campaignEx2, campaignEx2.getCampaignUnitId(), this.f16527b.getNativeVideoTracking().o(), false, false);
        }
    }

    public final void a(List<CampaignEx> list) {
        this.f16528c = list;
    }

    public void a(int i4, Object obj) {
        super.a(i4, obj);
        this.f16534i.a(i4, obj);
    }

    public final void a(int i4) {
        if (this.f16527b == null) {
            return;
        }
        if (i4 == 1 || i4 == 2) {
            com.mbridge.msdk.video.module.b.b.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f16527b, i4, this.f16535j);
        }
    }

    public final void a() {
        if (this.f16526a && this.f16527b != null) {
            n nVar = new n("2000061", this.f16527b.getId(), this.f16527b.getRequestId(), this.f16527b.getRequestIdNotice(), this.f16532g, ab.m(com.mbridge.msdk.foundation.controller.c.m().c()));
            nVar.d(this.f16527b.isMraid() ? n.f13061a : n.f13062b);
            com.mbridge.msdk.foundation.same.report.g.b(nVar, com.mbridge.msdk.foundation.controller.c.m().c(), this.f16532g);
        }
    }

    public final void a(int i4, String str) {
        if (this.f16527b != null) {
            com.mbridge.msdk.foundation.same.report.g.c(new n("2000062", this.f16527b.getId(), this.f16527b.getRequestId(), this.f16527b.getRequestIdNotice(), this.f16532g, ab.m(com.mbridge.msdk.foundation.controller.c.m().c()), i4, str), com.mbridge.msdk.foundation.controller.c.m().c(), this.f16532g);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        try {
            if (this.f16527b != null) {
                e eVar = new e();
                eVar.a("url", this.f16527b.getVideoUrlEncode());
                eVar.a("reason", str);
                String noticeUrl = this.f16527b.getNoticeUrl();
                String clickURL = this.f16527b.getClickURL();
                if (!TextUtils.isEmpty(noticeUrl)) {
                    eVar.a("offer_url", noticeUrl);
                } else if (!TextUtils.isEmpty(clickURL)) {
                    eVar.a("offer_url", clickURL);
                }
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000021", this.f16527b, eVar);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void b() {
        AnonymousClass1 r02 = new Runnable() {
            public final void run() {
                try {
                    k kVar = k.this;
                    if (kVar.f16526a && kVar.f16527b != null && ap.b(kVar.f16532g) && com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                        i a5 = i.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                        com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
                        fVar.a(System.currentTimeMillis());
                        fVar.b(k.this.f16532g);
                        fVar.a(k.this.f16527b.getId());
                        a5.a(fVar);
                    }
                } catch (Throwable th) {
                    af.b("NotifyListener", th.getMessage(), th);
                }
            }
        };
        d.a();
        com.mbridge.msdk.foundation.same.f.a.b().execute(r02);
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        List<CampaignEx> list;
        if (this.f16527b != null && (list = this.f16528c) != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("camp_position")) {
                    this.f16527b = this.f16528c.get(jSONObject.getInt("camp_position"));
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("NotifyListener", e5.getMessage());
                }
            }
        }
    }
}
