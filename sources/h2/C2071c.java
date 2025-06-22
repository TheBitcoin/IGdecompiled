package h2;

import N1.k;
import R2.n;
import R2.s;
import V2.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.uptodown.UptodownApp;
import d3.p;
import g2.C2033A;
import g2.C2044b;
import g2.C2048f;
import g2.C2054l;
import g2.C2060s;
import g2.S;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;
import u2.C2313C;
import u2.m;
import u2.q;
import u2.t;
import u2.w;
import u2.x;
import u2.y;

/* renamed from: h2.c  reason: case insensitive filesystem */
public final class C2071c extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final a f20826a = new a((C2103g) null);

    /* renamed from: b  reason: collision with root package name */
    private static String f20827b;

    /* renamed from: c  reason: collision with root package name */
    private static long f20828c;

    /* renamed from: h2.c$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: h2.c$b */
    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f20829a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f20830b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2071c f20831c;

        /* renamed from: d  reason: collision with root package name */
        int f20832d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2071c cVar, V2.d dVar) {
            super(dVar);
            this.f20831c = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f20830b = obj;
            this.f20832d |= Integer.MIN_VALUE;
            return this.f20831c.c((String) null, (BroadcastReceiver.PendingResult) null, (Context) null, this);
        }
    }

    /* renamed from: h2.c$c  reason: collision with other inner class name */
    static final class C0256c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20833a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f20834b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f20835c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2071c f20836d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0256c(Context context, String str, C2071c cVar, V2.d dVar) {
            super(2, dVar);
            this.f20834b = context;
            this.f20835c = str;
            this.f20836d = cVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new C0256c(this.f20834b, this.f20835c, this.f20836d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            long j4;
            String str;
            String str2;
            C2060s b5;
            String str3;
            Object c5 = W2.b.c();
            int i4 = this.f20833a;
            if (i4 == 0) {
                n.b(obj);
                t a5 = t.f21927u.a(this.f20834b);
                a5.a();
                S D02 = a5.D0(this.f20835c);
                if (D02 == null || (b5 = D02.b(this.f20834b)) == null) {
                    j4 = 0;
                    str = null;
                } else {
                    if (b5.o().size() == 1) {
                        str3 = String.valueOf(((C2060s.c) b5.o().get(0)).d());
                    } else {
                        str3 = null;
                    }
                    j4 = b5.z();
                    if (com.uptodown.activities.preferences.a.f18818a.P(this.f20834b)) {
                        b5.g();
                    }
                    a5.R(this.f20835c);
                    a5.z(b5);
                    str = str3;
                }
                long j5 = j4;
                a5.i();
                String h4 = new m().h(this.f20834b, this.f20835c);
                boolean p4 = m3.m.p(this.f20834b.getPackageName(), h4, true);
                if (!p4 && h4 == null) {
                    T1.a i5 = k.f7778g.i();
                    if (i5 != null) {
                        str2 = i5.b();
                    } else {
                        str2 = null;
                    }
                    p4 = m3.m.p(str2, this.f20835c, true);
                }
                C2048f A4 = new m().A(this.f20834b, this.f20835c);
                if (p4) {
                    this.f20836d.e(A4, this.f20835c, this.f20834b, j5, str);
                } else {
                    kotlin.coroutines.jvm.internal.b.a(UptodownApp.a.P0(UptodownApp.f17422D, this.f20834b, false, 2, (Object) null));
                }
                UptodownApp.a aVar = UptodownApp.f17422D;
                String str4 = this.f20835c;
                this.f20833a = 1;
                if (aVar.Q0(str4, true, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C2313C.f21882a.f(this.f20834b);
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((C0256c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: h2.c$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20837a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f20838b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(BroadcastReceiver.PendingResult pendingResult, V2.d dVar) {
            super(2, dVar);
            this.f20838b = pendingResult;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f20838b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f20837a == 0) {
                n.b(obj);
                this.f20838b.finish();
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: h2.c$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20839a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2071c f20840b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f20841c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f20842d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f20843e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(C2071c cVar, String str, BroadcastReceiver.PendingResult pendingResult, Context context, V2.d dVar) {
            super(2, dVar);
            this.f20840b = cVar;
            this.f20841c = str;
            this.f20842d = pendingResult;
            this.f20843e = context;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f20840b, this.f20841c, this.f20842d, this.f20843e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f20839a;
            if (i4 == 0) {
                n.b(obj);
                C2071c cVar = this.f20840b;
                String str = this.f20841c;
                BroadcastReceiver.PendingResult pendingResult = this.f20842d;
                kotlin.jvm.internal.m.b(pendingResult);
                Context context = this.f20843e;
                this.f20839a = 1;
                if (cVar.c(str, pendingResult, context, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: android.content.BroadcastReceiver$PendingResult} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        if (o3.C0977g.g(r10, r2, r0) == r1) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        if (o3.C0977g.g(r7, r9, r0) != r1) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
        return r1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(java.lang.String r7, android.content.BroadcastReceiver.PendingResult r8, android.content.Context r9, V2.d r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof h2.C2071c.b
            if (r0 == 0) goto L_0x0013
            r0 = r10
            h2.c$b r0 = (h2.C2071c.b) r0
            int r1 = r0.f20832d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f20832d = r1
            goto L_0x0018
        L_0x0013:
            h2.c$b r0 = new h2.c$b
            r0.<init>(r6, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f20830b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f20832d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            R2.n.b(r10)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.f20829a
            r8 = r7
            android.content.BroadcastReceiver$PendingResult r8 = (android.content.BroadcastReceiver.PendingResult) r8
            R2.n.b(r10)
            goto L_0x0055
        L_0x003e:
            R2.n.b(r10)
            o3.G r10 = o3.Y.b()
            h2.c$c r2 = new h2.c$c
            r2.<init>(r9, r7, r6, r5)
            r0.f20829a = r8
            r0.f20832d = r4
            java.lang.Object r7 = o3.C0977g.g(r10, r2, r0)
            if (r7 != r1) goto L_0x0055
            goto L_0x0068
        L_0x0055:
            o3.E0 r7 = o3.Y.c()
            h2.c$d r9 = new h2.c$d
            r9.<init>(r8, r5)
            r0.f20829a = r5
            r0.f20832d = r3
            java.lang.Object r7 = o3.C0977g.g(r7, r9, r0)
            if (r7 != r1) goto L_0x0069
        L_0x0068:
            return r1
        L_0x0069:
            R2.s r7 = R2.s.f8222a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.C2071c.c(java.lang.String, android.content.BroadcastReceiver$PendingResult, android.content.Context, V2.d):java.lang.Object");
    }

    private final void d(Context context, String str, Bundle bundle) {
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.m() != null) {
            C2054l m4 = aVar.m();
            kotlin.jvm.internal.m.b(m4);
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
    public final void e(C2048f fVar, String str, Context context, long j4, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("packagename", str);
        d(context, str, bundle);
        bundle.putString("type", "success");
        bundle.putInt("update", 1);
        if (j4 > 0) {
            bundle.putString("size", y.f21955a.e(j4));
        }
        if (!(str2 == null || str2.length() == 0)) {
            bundle.putString("fileId", str2);
        }
        new x(context).d("install", bundle);
        f(context, fVar);
    }

    private final void f(Context context, C2048f fVar) {
        if (fVar != null) {
            C2044b bVar = new C2044b();
            t a5 = t.f21927u.a(context);
            a5.a();
            bVar.k(fVar, a5);
            a5.i();
        }
    }

    public void onReceive(Context context, Intent intent) {
        Uri data;
        kotlin.jvm.internal.m.e(context, "context");
        kotlin.jvm.internal.m.e(intent, "intent");
        Context a5 = k.f7778g.a(context);
        String action = intent.getAction();
        if (action != null) {
            boolean z4 = true;
            if (m3.m.p(action, "android.intent.action.PACKAGE_REPLACED", true) && (data = intent.getData()) != null) {
                String schemeSpecificPart = data.getSchemeSpecificPart();
                boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                if (schemeSpecificPart != null && booleanExtra) {
                    String str = action + schemeSpecificPart;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (m3.m.p(str, f20827b, true) && currentTimeMillis - f20828c <= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                        z4 = false;
                    }
                    f20828c = currentTimeMillis;
                    f20827b = str;
                    if (z4) {
                        C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (L) null, new e(this, schemeSpecificPart, goAsync(), a5, (V2.d) null), 3, (Object) null);
                    }
                }
            }
        }
    }
}
