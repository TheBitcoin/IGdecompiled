package com.mbridge.msdk.reward.c.a;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.videocommon.d.b;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f15355a;

    private a() {
    }

    public static a a() {
        if (f15355a == null) {
            synchronized (a.class) {
                try {
                    if (f15355a == null) {
                        f15355a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f15355a;
    }

    public final void a(String str, c cVar) {
        List<CampaignEx> h4;
        c cVar2;
        if (cVar == null) {
            try {
                cVar2 = new c();
            } catch (Exception e5) {
                try {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                } catch (Exception e6) {
                    if (MBridgeConstans.DEBUG) {
                        e6.printStackTrace();
                        return;
                    }
                    return;
                }
            }
        } else {
            cVar2 = cVar;
        }
        com.mbridge.msdk.videocommon.d.a b5 = b.a().b();
        if (b5 != null) {
            cVar2.h(b5.b());
            cVar2.f(b5.c());
        }
        if (cVar != null) {
            try {
                int j4 = cVar.j();
                String i4 = cVar.i();
                boolean z4 = false;
                if (TextUtils.isEmpty(i4) && (h4 = cVar.h()) != null && h4.size() > 0 && h4.get(0) != null) {
                    i4 = h4.get(0).getCampaignUnitId();
                    j4 = h4.get(0).getAdType();
                    cVar.b(j4);
                    cVar.d(i4);
                }
                if (j4 == 287) {
                    z4 = true;
                }
                com.mbridge.msdk.videocommon.d.c a5 = b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), i4, z4);
                if (a5 != null) {
                    cVar.g(a5.l());
                    cVar.n(a5.k());
                }
            } catch (Exception e7) {
                if (MBridgeConstans.DEBUG) {
                    e7.printStackTrace();
                }
            }
        }
        d.a().a(cVar);
        d.a().a(str, cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
    }
}
