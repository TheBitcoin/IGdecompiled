package com.mbridge.msdk.tracker;

import android.util.Log;
import com.mbridge.msdk.tracker.network.ad;
import com.mbridge.msdk.tracker.network.g;
import com.mbridge.msdk.tracker.network.u;
import com.mbridge.msdk.tracker.network.v;
import com.mbridge.msdk.tracker.network.w;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class n {

    /* renamed from: a  reason: collision with root package name */
    private q f15495a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15496b;

    /* renamed from: c  reason: collision with root package name */
    private final o f15497c;

    /* renamed from: d  reason: collision with root package name */
    private final v f15498d;

    /* renamed from: e  reason: collision with root package name */
    private final int f15499e;

    /* renamed from: f  reason: collision with root package name */
    private v f15500f;

    /* renamed from: g  reason: collision with root package name */
    private final Executor f15501g;

    private static final class a implements w.a {

        /* renamed from: a  reason: collision with root package name */
        private final q f15503a;

        /* renamed from: b  reason: collision with root package name */
        private final s f15504b;

        public a(q qVar, s sVar) {
            this.f15503a = qVar;
            this.f15504b = sVar;
        }

        public final void a(ad adVar) {
            if (y.b((Object) this.f15503a)) {
                try {
                    this.f15503a.a(this.f15504b, 0, adVar.getMessage());
                } catch (Exception e5) {
                    if (a.f15435a) {
                        Log.e("TrackManager", "onErrorResponse error", e5);
                    }
                }
            }
        }
    }

    private static final class b implements w.b {

        /* renamed from: a  reason: collision with root package name */
        private final q f15505a;

        /* renamed from: b  reason: collision with root package name */
        private final s f15506b;

        public b(q qVar, s sVar) {
            this.f15505a = qVar;
            this.f15506b = sVar;
        }

        public final void a(Object obj) {
            if (y.b((Object) this.f15505a)) {
                try {
                    this.f15505a.a(this.f15506b);
                } catch (Exception e5) {
                    if (a.f15435a) {
                        Log.e("TrackManager", "onResponse error", e5);
                    }
                }
            }
        }
    }

    public n(int i4, o oVar, v vVar, int i5) {
        this.f15496b = i4;
        this.f15497c = oVar;
        this.f15498d = vVar;
        this.f15499e = i5;
        int i6 = i4;
        this.f15501g = new ThreadPoolExecutor(i6, i4, 20, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "MBridgeReportResponseThread");
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    public final void a(q qVar) {
        this.f15495a = qVar;
    }

    public final void a(s sVar, Map<String, String> map, boolean z4) {
        u uVar;
        if (y.a((Object) map)) {
            q qVar = this.f15495a;
            if (qVar != null) {
                try {
                    qVar.a(sVar, 0, "params is null");
                } catch (Exception e5) {
                    if (a.f15435a) {
                        Log.e("TrackManager", "send error", e5);
                    }
                }
            }
        } else {
            try {
                if (!y.b((Object) this.f15500f)) {
                    v a5 = com.mbridge.msdk.tracker.network.toolbox.n.a(new com.mbridge.msdk.tracker.network.toolbox.b(this.f15497c.c()), new g(this.f15501g), this.f15496b, (com.mbridge.msdk.tracker.network.b) null);
                    this.f15500f = a5;
                    a5.a();
                }
                if (this.f15499e == 1) {
                    uVar = new u(this.f15497c.b(), 1, this.f15497c.a());
                } else {
                    uVar = new u(this.f15497c.b(), 1);
                }
                uVar.a(map);
                uVar.b(false);
                uVar.c(true);
                uVar.d(true);
                uVar.a(this.f15498d);
                uVar.a(z4 ? u.b.HIGH : u.b.NORMAL);
                uVar.a(new b(this.f15495a, sVar));
                uVar.a((w.a) new a(this.f15495a, sVar));
                this.f15500f.a(uVar);
            } catch (Exception e6) {
                if (a.f15435a) {
                    Log.e("TrackManager", "send error", e6);
                }
                if (y.b((Object) this.f15495a)) {
                    this.f15495a.a(sVar, 0, e6.getMessage());
                }
            }
        }
    }
}
