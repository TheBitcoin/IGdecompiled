package com.mbridge.msdk.newreward.function.c.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.function.c.c.d;
import com.mbridge.msdk.newreward.function.c.c.f;
import com.mbridge.msdk.newreward.function.c.c.g;
import com.mbridge.msdk.newreward.function.c.c.h;
import com.mbridge.msdk.newreward.function.c.c.j;
import com.mbridge.msdk.newreward.function.c.c.k;
import com.mbridge.msdk.newreward.function.c.c.l;
import com.mbridge.msdk.newreward.function.c.c.m;
import com.mbridge.msdk.newreward.function.c.c.n;
import com.mbridge.msdk.newreward.function.h.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f14478a;

    /* renamed from: b  reason: collision with root package name */
    private CampaignEx f14479b;

    /* renamed from: c  reason: collision with root package name */
    private String f14480c;

    /* renamed from: d  reason: collision with root package name */
    private String f14481d;

    /* renamed from: e  reason: collision with root package name */
    private String f14482e;

    /* renamed from: f  reason: collision with root package name */
    private d<?> f14483f;

    /* renamed from: g  reason: collision with root package name */
    private n f14484g;

    /* renamed from: h  reason: collision with root package name */
    private d<?> f14485h;

    /* renamed from: i  reason: collision with root package name */
    private l f14486i;

    /* renamed from: j  reason: collision with root package name */
    private h f14487j;

    /* renamed from: k  reason: collision with root package name */
    private m f14488k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14489l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f14490m = false;

    public a(b bVar) {
        this.f14478a = bVar;
    }

    public final m a() {
        CampaignEx.c rewardTemplateMode;
        m mVar = this.f14488k;
        if (mVar != null) {
            return mVar;
        }
        CampaignEx campaignEx = this.f14479b;
        if (campaignEx == null || (rewardTemplateMode = campaignEx.getRewardTemplateMode()) == null) {
            return null;
        }
        String c5 = rewardTemplateMode.c();
        if (TextUtils.isEmpty(c5)) {
            return null;
        }
        if (this.f14488k == null) {
            this.f14488k = new m(this.f14478a, this, c5);
        }
        return this.f14488k;
    }

    public final h b() {
        h hVar = this.f14487j;
        if (hVar != null) {
            return hVar;
        }
        CampaignEx campaignEx = this.f14479b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getEndScreenUrl())) {
            return null;
        }
        if (this.f14487j == null) {
            this.f14487j = new h(this.f14478a, this);
        }
        return this.f14487j;
    }

    public final d<?> c() {
        d<?> dVar = this.f14483f;
        if (dVar != null) {
            return dVar;
        }
        CampaignEx campaignEx = this.f14479b;
        if (campaignEx == null || campaignEx.getRewardTemplateMode() == null) {
            return null;
        }
        String e5 = campaignEx.getRewardTemplateMode().e();
        if (TextUtils.isEmpty(e5)) {
            return null;
        }
        if (this.f14483f == null) {
            if (c.b(e5)) {
                this.f14483f = new g(this.f14478a, this);
            } else {
                this.f14483f = new k(this.f14478a, this);
            }
        }
        return this.f14483f;
    }

    public final n d() {
        n nVar = this.f14484g;
        if (nVar != null) {
            return nVar;
        }
        CampaignEx campaignEx = this.f14479b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            return null;
        }
        if (this.f14484g == null) {
            this.f14484g = new n(this.f14478a, this);
        }
        return this.f14484g;
    }

    public final l e() {
        l lVar = this.f14486i;
        if (lVar != null) {
            return lVar;
        }
        CampaignEx campaignEx = this.f14479b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getMraid())) {
            return null;
        }
        if (this.f14486i == null) {
            this.f14486i = new l(this.f14478a, this);
        }
        return this.f14486i;
    }

    public final d<?> f() {
        d<?> dVar = this.f14485h;
        if (dVar != null) {
            return dVar;
        }
        CampaignEx campaignEx = this.f14479b;
        if (campaignEx == null) {
            return null;
        }
        String str = campaignEx.getendcard_url();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f14485h == null) {
            if (!c.b(str)) {
                this.f14485h = new j(this.f14478a, this);
            } else if (ak.l(str)) {
                this.f14485h = new j(this.f14478a, this);
            } else {
                this.f14485h = new f(this.f14478a, this);
            }
        }
        return this.f14485h;
    }

    public final String g() {
        return this.f14482e;
    }

    public final CampaignEx h() {
        return this.f14479b;
    }

    public final b i() {
        return this.f14478a;
    }

    public final boolean j() {
        CampaignEx campaignEx = this.f14479b;
        if (campaignEx != null) {
            return campaignEx.isMraid();
        }
        return false;
    }

    public final boolean k() {
        return this.f14489l;
    }

    public final boolean l() {
        return this.f14490m;
    }

    public final void b(String str) {
        this.f14481d = str;
    }

    public final void a(String str) {
        this.f14480c = str;
    }

    public final void b(boolean z4) {
        this.f14490m = z4;
    }

    public final void a(CampaignEx campaignEx) {
        this.f14479b = campaignEx;
    }

    public final void a(boolean z4) {
        this.f14489l = z4;
    }

    public final void c(String str) {
        this.f14482e = str;
    }
}
