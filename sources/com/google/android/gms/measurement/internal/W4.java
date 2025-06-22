package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.RemoteException;
import android.text.TextUtils;
import f0.C0917f;

final class W4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f2785a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ M5 f2786b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ boolean f2787c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ E f2788d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f2789e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ F4 f2790f;

    W4(F4 f4, boolean z4, M5 m5, boolean z5, E e5, String str) {
        this.f2785a = z4;
        this.f2786b = m5;
        this.f2787c = z5;
        this.f2788d = e5;
        this.f2789e = str;
        this.f2790f = f4;
    }

    public final void run() {
        long j4;
        long j5;
        E e5;
        C0917f y4 = this.f2790f.f2397d;
        if (y4 == null) {
            this.f2790f.a().G().a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f2785a) {
            C0335p.l(this.f2786b);
            F4 f4 = this.f2790f;
            if (this.f2787c) {
                e5 = null;
            } else {
                e5 = this.f2788d;
            }
            f4.O(y4, e5, this.f2786b);
        } else {
            boolean q4 = this.f2790f.b().q(G.f2415F0);
            try {
                if (TextUtils.isEmpty(this.f2789e)) {
                    C0335p.l(this.f2786b);
                    if (q4) {
                        long currentTimeMillis = this.f2790f.f3273a.B().currentTimeMillis();
                        try {
                            j4 = this.f2790f.f3273a.B().elapsedRealtime();
                            j5 = currentTimeMillis;
                        } catch (RemoteException e6) {
                            e = e6;
                            j4 = 0;
                            j5 = currentTimeMillis;
                            this.f2790f.a().G().b("Failed to send event to the service", e);
                            if (q4 && j5 != 0) {
                                C0807l2.a(this.f2790f.f3273a).b(36301, 13, j5, this.f2790f.f3273a.B().currentTimeMillis(), (int) (this.f2790f.f3273a.B().elapsedRealtime() - j4));
                            }
                            this.f2790f.m0();
                        }
                    } else {
                        j5 = 0;
                        j4 = 0;
                    }
                    try {
                        y4.i0(this.f2788d, this.f2786b);
                        if (q4) {
                            this.f2790f.a().K().a("Logging telemetry for logEvent");
                            C0807l2.a(this.f2790f.f3273a).b(36301, 0, j5, this.f2790f.f3273a.B().currentTimeMillis(), (int) (this.f2790f.f3273a.B().elapsedRealtime() - j4));
                        }
                    } catch (RemoteException e7) {
                        e = e7;
                        this.f2790f.a().G().b("Failed to send event to the service", e);
                        C0807l2.a(this.f2790f.f3273a).b(36301, 13, j5, this.f2790f.f3273a.B().currentTimeMillis(), (int) (this.f2790f.f3273a.B().elapsedRealtime() - j4));
                        this.f2790f.m0();
                    }
                } else {
                    y4.T(this.f2788d, this.f2789e, this.f2790f.a().O());
                }
            } catch (RemoteException e8) {
                e = e8;
                j5 = 0;
                j4 = 0;
            }
        }
        this.f2790f.m0();
    }
}
