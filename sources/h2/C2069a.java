package h2;

import N1.k;
import R2.n;
import R2.s;
import V2.d;
import V2.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import d3.p;
import g2.C2033A;
import g2.C2035C;
import g2.C2048f;
import g2.C2052j;
import g2.C2054l;
import g2.C2060s;
import g2.C2065x;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;
import u2.C2313C;
import u2.q;
import u2.t;
import u2.w;
import u2.x;
import u2.y;

/* renamed from: h2.a  reason: case insensitive filesystem */
public final class C2069a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final C0253a f20797a = new C0253a((C2103g) null);

    /* renamed from: b  reason: collision with root package name */
    private static String f20798b;

    /* renamed from: c  reason: collision with root package name */
    private static long f20799c;

    /* renamed from: h2.a$a  reason: collision with other inner class name */
    public static final class C0253a {
        public /* synthetic */ C0253a(C2103g gVar) {
            this();
        }

        private C0253a() {
        }
    }

    /* renamed from: h2.a$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20800a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f20801b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f20802c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2069a f20803d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f20804e;

        /* renamed from: h2.a$b$a  reason: collision with other inner class name */
        static final class C0254a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20805a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ BroadcastReceiver.PendingResult f20806b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0254a(BroadcastReceiver.PendingResult pendingResult, d dVar) {
                super(2, dVar);
                this.f20806b = pendingResult;
            }

            public final d create(Object obj, d dVar) {
                return new C0254a(this.f20806b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f20805a == 0) {
                    n.b(obj);
                    this.f20806b.finish();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((C0254a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, String str, C2069a aVar, BroadcastReceiver.PendingResult pendingResult, d dVar) {
            super(2, dVar);
            this.f20801b = context;
            this.f20802c = str;
            this.f20803d = aVar;
            this.f20804e = pendingResult;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f20801b, this.f20802c, this.f20803d, this.f20804e, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0073, code lost:
            if (r10.Q0(r1, false, r9) == r0) goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x008e, code lost:
            if (o3.C0977g.g(r10, r1, r9) == r0) goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0090, code lost:
            return r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r9.f20800a
                r2 = 0
                r3 = 0
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L_0x0021
                if (r1 == r5) goto L_0x001d
                if (r1 != r4) goto L_0x0015
                R2.n.b(r10)
                goto L_0x0091
            L_0x0015:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001d:
                R2.n.b(r10)
                goto L_0x0076
            L_0x0021:
                R2.n.b(r10)
                u2.m r10 = new u2.m
                r10.<init>()
                android.content.Context r1 = r9.f20801b
                java.lang.String r6 = r9.f20802c
                java.lang.String r10 = r10.h(r1, r6)
                android.content.Context r1 = r9.f20801b
                java.lang.String r1 = r1.getPackageName()
                boolean r1 = m3.m.p(r1, r10, r5)
                if (r1 != 0) goto L_0x0053
                if (r10 != 0) goto L_0x0053
                N1.k$a r10 = N1.k.f7778g
                T1.a r10 = r10.i()
                if (r10 == 0) goto L_0x004c
                java.lang.String r10 = r10.b()
                goto L_0x004d
            L_0x004c:
                r10 = r3
            L_0x004d:
                java.lang.String r1 = r9.f20802c
                boolean r1 = m3.m.p(r10, r1, r5)
            L_0x0053:
                u2.m r10 = new u2.m
                r10.<init>()
                android.content.Context r6 = r9.f20801b
                java.lang.String r7 = r9.f20802c
                g2.f r10 = r10.A(r6, r7)
                h2.a r6 = r9.f20803d
                java.lang.String r7 = r9.f20802c
                android.content.Context r8 = r9.f20801b
                r6.e(r1, r10, r7, r8)
                com.uptodown.UptodownApp$a r10 = com.uptodown.UptodownApp.f17422D
                java.lang.String r1 = r9.f20802c
                r9.f20800a = r5
                java.lang.Object r10 = r10.Q0(r1, r2, r9)
                if (r10 != r0) goto L_0x0076
                goto L_0x0090
            L_0x0076:
                com.uptodown.UptodownApp$a r10 = com.uptodown.UptodownApp.f17422D
                android.content.Context r1 = r9.f20801b
                com.uptodown.UptodownApp.a.P0(r10, r1, r2, r4, r3)
                o3.E0 r10 = o3.Y.c()
                h2.a$b$a r1 = new h2.a$b$a
                android.content.BroadcastReceiver$PendingResult r2 = r9.f20804e
                r1.<init>(r2, r3)
                r9.f20800a = r4
                java.lang.Object r10 = o3.C0977g.g(r10, r1, r9)
                if (r10 != r0) goto L_0x0091
            L_0x0090:
                return r0
            L_0x0091:
                R2.s r10 = R2.s.f8222a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: h2.C2069a.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: h2.a$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20807a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2069a f20808b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f20809c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f20810d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f20811e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2069a aVar, String str, BroadcastReceiver.PendingResult pendingResult, Context context, d dVar) {
            super(2, dVar);
            this.f20808b = aVar;
            this.f20809c = str;
            this.f20810d = pendingResult;
            this.f20811e = context;
        }

        public final d create(Object obj, d dVar) {
            return new c(this.f20808b, this.f20809c, this.f20810d, this.f20811e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f20807a;
            if (i4 == 0) {
                n.b(obj);
                C2069a aVar = this.f20808b;
                String str = this.f20809c;
                BroadcastReceiver.PendingResult pendingResult = this.f20810d;
                m.b(pendingResult);
                Context context = this.f20811e;
                this.f20807a = 1;
                if (aVar.c(str, pendingResult, context, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public final Object c(String str, BroadcastReceiver.PendingResult pendingResult, Context context, d dVar) {
        Context context2 = context;
        Object g4 = C0977g.g(Y.b(), new b(context2, str, this, pendingResult, (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    private final void d(Context context, String str, Bundle bundle) {
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.m() != null) {
            C2054l m4 = aVar.m();
            m.b(m4);
            String i4 = new w().i(m4.c());
            if (i4 != null && m3.m.p(i4, str, true)) {
                bundle.putString("source", "deeplink");
                aVar.u0((C2054l) null);
                new q().h(context, str, i4);
                return;
            }
            return;
        }
        C2033A b5 = C2033A.f20327f.b(context);
        if (b5 != null && m3.m.p(b5.d(), str, true)) {
            bundle.putString("source", "notification_fcm");
        }
    }

    /* access modifiers changed from: private */
    public final void e(boolean z4, C2048f fVar, String str, Context context) {
        Long l4;
        long j4;
        long j5;
        if (z4) {
            Bundle bundle = new Bundle();
            bundle.putString("packagename", str);
            d(context, str, bundle);
            C2035C.f20340i.b(context, fVar, bundle);
            if (fVar != null) {
                l4 = Long.valueOf(fVar.A());
            } else {
                l4 = null;
            }
            if (l4 != null) {
                t a5 = t.f21927u.a(context);
                a5.a();
                C2060s i02 = a5.i0(str, fVar.A());
                if (i02 == null || i02.o().isEmpty()) {
                    j5 = 0;
                    j4 = 0;
                } else {
                    j5 = ((C2060s.c) i02.o().get(0)).d();
                    j4 = i02.y();
                    if (a.f18818a.P(context)) {
                        a5.z(i02);
                        i02.g();
                    }
                    f(context, str, i02, bundle);
                }
                a5.i();
            } else {
                j5 = 0;
                j4 = 0;
            }
            bundle.putString("type", "success");
            bundle.putInt("update", 0);
            if (j4 > 0) {
                bundle.putString("size", y.f21955a.e(j4));
            }
            if (j5 > 0) {
                bundle.putString("fileId", String.valueOf(j5));
            }
            new x(context).d("install", bundle);
            C2313C.f21882a.l(context, str);
        }
    }

    private final void f(Context context, String str, C2060s sVar, Bundle bundle) {
        C2052j d5 = C2052j.f20686n.d(context);
        if (d5 == null || !m3.m.p(d5.r(), str, true) || d5.m() != sVar.q()) {
            C2065x d6 = C2065x.f20781n.d(context);
            if (d6 != null && m3.m.p(d6.r(), str, true) && d6.m() == sVar.q()) {
                d6.i(context);
                bundle.putString("source", d6.s());
                return;
            }
            return;
        }
        d5.i(context);
        bundle.putString("source", d5.s());
    }

    public void onReceive(Context context, Intent intent) {
        Uri data;
        m.e(context, "context");
        m.e(intent, "intent");
        Context a5 = k.f7778g.a(context);
        String action = intent.getAction();
        if (action != null) {
            boolean z4 = true;
            if (m3.m.p(action, "android.intent.action.PACKAGE_ADDED", true) && (data = intent.getData()) != null) {
                String schemeSpecificPart = data.getSchemeSpecificPart();
                boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                if (schemeSpecificPart != null && !booleanExtra) {
                    String str = action + schemeSpecificPart;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (m3.m.p(str, f20798b, true) && currentTimeMillis - f20799c <= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                        z4 = false;
                    }
                    f20799c = currentTimeMillis;
                    f20798b = str;
                    if (z4) {
                        C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (L) null, new c(this, schemeSpecificPart, goAsync(), a5, (d) null), 3, (Object) null);
                    }
                }
            }
        }
    }
}
