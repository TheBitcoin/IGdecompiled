package com.mbridge.msdk.newreward.function.e;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.b.i;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public List<Integer> f14899a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private b f14900b;

    /* renamed from: c  reason: collision with root package name */
    private b f14901c;

    private static final class a implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: a  reason: collision with root package name */
        private e f14902a;

        /* renamed from: b  reason: collision with root package name */
        private d f14903b;

        /* renamed from: c  reason: collision with root package name */
        private com.mbridge.msdk.newreward.a.b.b f14904c;

        /* renamed from: d  reason: collision with root package name */
        private int f14905d;

        public a(e eVar, d dVar, com.mbridge.msdk.newreward.a.b.b bVar, int i4) {
            this.f14902a = eVar;
            this.f14903b = dVar;
            this.f14904c = bVar;
            this.f14905d = i4;
        }

        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            com.mbridge.msdk.newreward.a.b.b bVar2 = this.f14904c;
            if (bVar2 != null) {
                try {
                    bVar2.reqFailed(bVar);
                } catch (Exception e5) {
                    af.b("MoreOfferCampaignModel", "reqFailed: ", e5);
                }
            }
        }

        public final void reqSuccessful(Object obj) {
            try {
                b bVar = (b) obj;
                bVar.b(this.f14902a.G());
                int Q4 = (int) (((double) this.f14902a.Q()) * 1.2d);
                bVar.f(Q4);
                bVar.g(Q4);
                bVar.b(Math.max(this.f14902a.T(), bVar.p()));
                int i4 = this.f14905d;
                if (i4 == 1) {
                    this.f14903b.a(bVar);
                } else if (i4 == 2) {
                    this.f14903b.b(bVar);
                }
                if (!TextUtils.isEmpty(bVar.k())) {
                    MBridgeGlobalCommon.SESSION_ID = bVar.k();
                }
                com.mbridge.msdk.newreward.a.b.b bVar2 = this.f14904c;
                if (bVar2 != null) {
                    bVar2.reqSuccessful(obj);
                }
            } catch (Exception e5) {
                af.b("MoreOfferCampaignModel", "reqSuccessful: ", e5);
                com.mbridge.msdk.newreward.a.b.b bVar3 = this.f14904c;
                if (bVar3 != null) {
                    bVar3.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e5.getMessage()));
                }
            }
        }
    }

    public final void a(b bVar) {
        this.f14900b = bVar;
    }

    public final void b(b bVar) {
        this.f14901c = bVar;
    }

    public final void a(int i4, e eVar, CampaignEx campaignEx, com.mbridge.msdk.newreward.function.f.a aVar, com.mbridge.msdk.newreward.a.b.b bVar) {
        if (campaignEx != null) {
            try {
                try {
                    new i(eVar).a(aVar, new a(eVar, this, bVar, i4));
                } catch (IOException e5) {
                    if (bVar != null) {
                        bVar.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e5.getMessage()));
                    }
                }
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    e6.printStackTrace();
                }
            }
        } else if (bVar != null) {
            bVar.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, "more_offer MainCampaign is null"));
        }
    }

    public final b b() {
        return this.f14901c;
    }

    public final b a() {
        return this.f14900b;
    }
}
