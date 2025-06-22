package com.mbridge.msdk.foundation.same.net.f;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.same.net.b;
import com.mbridge.msdk.foundation.same.net.d;
import com.mbridge.msdk.foundation.same.net.d.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.tracker.network.ad;
import com.mbridge.msdk.tracker.network.h;
import com.mbridge.msdk.tracker.network.k;
import com.mbridge.msdk.tracker.network.r;
import com.mbridge.msdk.tracker.network.w;
import java.util.List;

public final class i<T> implements k<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b<T> f13352a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f13353b = new Handler(Looper.getMainLooper());

    public i(b<T> bVar) {
        this.f13352a = bVar;
    }

    public final void b(com.mbridge.msdk.tracker.network.i<T> iVar, final w<T> wVar, final r rVar) {
        af.a("MBridgeRequestListenerWrapper", "onResponseError: " + wVar.f15667c.a() + " " + wVar.f15667c.getMessage());
        this.f13353b.post(new Runnable() {
            public final void run() {
                a aVar;
                com.mbridge.msdk.foundation.same.net.a.a aVar2;
                try {
                    if (i.this.f13352a != null) {
                        b a5 = i.this.f13352a;
                        ad adVar = wVar.f15667c;
                        r rVar = rVar;
                        com.mbridge.msdk.foundation.same.net.a.a aVar3 = null;
                        if (adVar != null) {
                            if (rVar != null) {
                                aVar = new a(rVar.f15600a, rVar.f15601b, rVar.f15603d);
                            } else {
                                aVar = new a(0, (byte[]) null, (List<h>) null);
                            }
                            if (adVar.a() == 0) {
                                aVar2 = new com.mbridge.msdk.foundation.same.net.a.a(2, aVar, adVar.getMessage());
                            } else if (adVar.a() == 1) {
                                aVar2 = new com.mbridge.msdk.foundation.same.net.a.a(6, aVar, adVar.getMessage());
                            } else if (adVar.a() == 2) {
                                aVar2 = new com.mbridge.msdk.foundation.same.net.a.a(8, aVar, adVar.getMessage());
                            } else if (adVar.a() == 4) {
                                aVar2 = new com.mbridge.msdk.foundation.same.net.a.a(880041, aVar, adVar.getMessage());
                            } else if (adVar.a() == 5) {
                                aVar2 = new com.mbridge.msdk.foundation.same.net.a.a(8, aVar, adVar.getMessage());
                            } else if (adVar.a() == 6) {
                                aVar2 = new com.mbridge.msdk.foundation.same.net.a.a(15, aVar, adVar.getMessage());
                            } else if (adVar.a() == 7) {
                                aVar2 = new com.mbridge.msdk.foundation.same.net.a.a(7, aVar, adVar.getMessage());
                            } else if (adVar.a() == 8) {
                                aVar2 = new com.mbridge.msdk.foundation.same.net.a.a(10, aVar, adVar.getMessage());
                            } else if (adVar.a() == 9) {
                                aVar2 = new com.mbridge.msdk.foundation.same.net.a.a(4, aVar, adVar.getMessage());
                            } else {
                                aVar2 = new com.mbridge.msdk.foundation.same.net.a.a(2, aVar, adVar.getMessage());
                            }
                            aVar3 = aVar2;
                        }
                        a5.onError(aVar3);
                    }
                } catch (Exception e5) {
                    af.b("MBridgeRequestListenerWrapper", "onResponseError error", e5);
                }
            }
        });
    }

    public final void a(com.mbridge.msdk.tracker.network.i<T> iVar, final w<T> wVar, final r rVar) {
        af.a("MBridgeRequestListenerWrapper", "onResponseSuccess: " + wVar.f15665a);
        this.f13353b.post(new Runnable() {
            public final void run() {
                d dVar;
                try {
                    if (i.this.f13352a != null) {
                        b a5 = i.this.f13352a;
                        w wVar = wVar;
                        r rVar = rVar;
                        if (wVar == null) {
                            dVar = null;
                        } else {
                            dVar = d.a(wVar.f15665a, new a(rVar.f15600a, rVar.f15601b, rVar.f15603d));
                        }
                        a5.onSuccess(dVar);
                    }
                } catch (Exception e5) {
                    af.b("MBridgeRequestListenerWrapper", "onResponseSuccess error", e5);
                }
            }
        });
    }
}
