package h2;

import N1.k;
import R2.n;
import R2.s;
import V2.d;
import V2.g;
import W2.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;

/* renamed from: h2.b  reason: case insensitive filesystem */
public final class C2070b extends BroadcastReceiver {

    /* renamed from: b  reason: collision with root package name */
    public static final a f20812b = new a((C2103g) null);

    /* renamed from: c  reason: collision with root package name */
    private static String f20813c;

    /* renamed from: d  reason: collision with root package name */
    private static long f20814d;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f20815a;

    /* renamed from: h2.b$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: h2.b$b  reason: collision with other inner class name */
    static final class C0255b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20816a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2070b f20817b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f20818c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f20819d;

        /* renamed from: h2.b$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20820a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ BroadcastReceiver.PendingResult f20821b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(BroadcastReceiver.PendingResult pendingResult, d dVar) {
                super(2, dVar);
                this.f20821b = pendingResult;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f20821b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                b.c();
                if (this.f20820a == 0) {
                    n.b(obj);
                    this.f20821b.finish();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0255b(C2070b bVar, String str, BroadcastReceiver.PendingResult pendingResult, d dVar) {
            super(2, dVar);
            this.f20817b = bVar;
            this.f20818c = str;
            this.f20819d = pendingResult;
        }

        public final d create(Object obj, d dVar) {
            return new C0255b(this.f20817b, this.f20818c, this.f20819d, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x006f, code lost:
            if (o3.U.b(200, r5) == r0) goto L_0x0106;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0073, code lost:
            r6 = N1.k.f7778g.g();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
            if (r6 == null) goto L_0x00ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x007d, code lost:
            if ((r6 instanceof com.uptodown.activities.OldVersionsActivity) == false) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x007f, code lost:
            ((com.uptodown.activities.OldVersionsActivity) r6).H3(r5.f20818c);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0089, code lost:
            if ((r6 instanceof com.uptodown.activities.AppDetailActivity) == false) goto L_0x009a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
            r1 = r5.f20818c;
            r5.f20816a = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
            if (((com.uptodown.activities.AppDetailActivity) r6).q3(r1, r5) != r0) goto L_0x00ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x009c, code lost:
            if ((r6 instanceof com.uptodown.activities.MainActivity) == false) goto L_0x00ac;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x009e, code lost:
            r1 = r5.f20818c;
            r5.f20816a = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a9, code lost:
            if (((com.uptodown.activities.MainActivity) r6).T7(r1, r5) != r0) goto L_0x00ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b0, code lost:
            if ((r6 instanceof com.uptodown.activities.MyApps) == false) goto L_0x00c0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b2, code lost:
            r1 = r5.f20818c;
            r5.f20816a = 4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bd, code lost:
            if (((com.uptodown.activities.MyApps) r6).a5("app_uninstalled", r1, r5) != r0) goto L_0x00ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c2, code lost:
            if ((r6 instanceof com.uptodown.activities.Updates) == false) goto L_0x00d2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c4, code lost:
            r1 = r5.f20818c;
            r5.f20816a = 5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cf, code lost:
            if (((com.uptodown.activities.Updates) r6).q5("app_uninstalled", r1, r5) != r0) goto L_0x00ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d4, code lost:
            if ((r6 instanceof com.uptodown.activities.FreeUpSpaceActivity) == false) goto L_0x00e4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d6, code lost:
            r1 = r5.f20818c;
            r5.f20816a = 6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e1, code lost:
            if (((com.uptodown.activities.FreeUpSpaceActivity) r6).m3("app_uninstalled", r1, r5) != r0) goto L_0x00ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e6, code lost:
            if ((r6 instanceof com.uptodown.activities.SecurityActivity) == false) goto L_0x00ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e8, code lost:
            ((com.uptodown.activities.SecurityActivity) r6).i5();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ed, code lost:
            N1.k.f7778g.O((java.lang.String) null);
            r6 = o3.Y.c();
            r1 = new h2.C2070b.C0255b.a(r5.f20819d, (V2.d) null);
            r5.f20816a = 7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0104, code lost:
            if (o3.C0977g.g(r6, r1, r5) != r0) goto L_0x0107;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0106, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0109, code lost:
            return R2.s.f8222a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r5.f20816a
                r2 = 0
                switch(r1) {
                    case 0: goto L_0x0020;
                    case 1: goto L_0x001c;
                    case 2: goto L_0x0017;
                    case 3: goto L_0x0017;
                    case 4: goto L_0x0017;
                    case 5: goto L_0x0017;
                    case 6: goto L_0x0017;
                    case 7: goto L_0x0012;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x0012:
                R2.n.b(r6)
                goto L_0x0107
            L_0x0017:
                R2.n.b(r6)
                goto L_0x00ed
            L_0x001c:
                R2.n.b(r6)
                goto L_0x0073
            L_0x0020:
                R2.n.b(r6)
                h2.b r6 = r5.f20817b
                android.content.Context r6 = r6.f20815a
                if (r6 == 0) goto L_0x0107
                u2.t$a r6 = u2.t.f21927u
                h2.b r1 = r5.f20817b
                android.content.Context r1 = r1.f20815a
                kotlin.jvm.internal.m.b(r1)
                u2.t r6 = r6.a(r1)
                r6.a()
                java.lang.String r1 = r5.f20818c
                g2.S r1 = r6.D0(r1)
                if (r1 == 0) goto L_0x0053
                h2.b r3 = r5.f20817b
                android.content.Context r3 = r3.f20815a
                kotlin.jvm.internal.m.b(r3)
                g2.s r1 = r1.b(r3)
                goto L_0x0054
            L_0x0053:
                r1 = r2
            L_0x0054:
                if (r1 == 0) goto L_0x0059
                r1.g()
            L_0x0059:
                java.lang.String r1 = r5.f20818c
                r6.R(r1)
                java.lang.String r1 = r5.f20818c
                r6.v(r1)
                r6.i()
                r6 = 1
                r5.f20816a = r6
                r3 = 200(0xc8, double:9.9E-322)
                java.lang.Object r6 = o3.U.b(r3, r5)
                if (r6 != r0) goto L_0x0073
                goto L_0x0106
            L_0x0073:
                N1.k$a r6 = N1.k.f7778g
                android.app.Activity r6 = r6.g()
                if (r6 == 0) goto L_0x00ed
                boolean r1 = r6 instanceof com.uptodown.activities.OldVersionsActivity
                if (r1 == 0) goto L_0x0087
                com.uptodown.activities.OldVersionsActivity r6 = (com.uptodown.activities.OldVersionsActivity) r6
                java.lang.String r1 = r5.f20818c
                r6.H3(r1)
                goto L_0x00ed
            L_0x0087:
                boolean r1 = r6 instanceof com.uptodown.activities.AppDetailActivity
                if (r1 == 0) goto L_0x009a
                com.uptodown.activities.AppDetailActivity r6 = (com.uptodown.activities.AppDetailActivity) r6
                java.lang.String r1 = r5.f20818c
                r3 = 2
                r5.f20816a = r3
                java.lang.Object r6 = r6.q3(r1, r5)
                if (r6 != r0) goto L_0x00ed
                goto L_0x0106
            L_0x009a:
                boolean r1 = r6 instanceof com.uptodown.activities.MainActivity
                if (r1 == 0) goto L_0x00ac
                com.uptodown.activities.MainActivity r6 = (com.uptodown.activities.MainActivity) r6
                java.lang.String r1 = r5.f20818c
                r3 = 3
                r5.f20816a = r3
                java.lang.Object r6 = r6.T7(r1, r5)
                if (r6 != r0) goto L_0x00ed
                goto L_0x0106
            L_0x00ac:
                boolean r1 = r6 instanceof com.uptodown.activities.MyApps
                java.lang.String r3 = "app_uninstalled"
                if (r1 == 0) goto L_0x00c0
                com.uptodown.activities.MyApps r6 = (com.uptodown.activities.MyApps) r6
                java.lang.String r1 = r5.f20818c
                r4 = 4
                r5.f20816a = r4
                java.lang.Object r6 = r6.a5(r3, r1, r5)
                if (r6 != r0) goto L_0x00ed
                goto L_0x0106
            L_0x00c0:
                boolean r1 = r6 instanceof com.uptodown.activities.Updates
                if (r1 == 0) goto L_0x00d2
                com.uptodown.activities.Updates r6 = (com.uptodown.activities.Updates) r6
                java.lang.String r1 = r5.f20818c
                r4 = 5
                r5.f20816a = r4
                java.lang.Object r6 = r6.q5(r3, r1, r5)
                if (r6 != r0) goto L_0x00ed
                goto L_0x0106
            L_0x00d2:
                boolean r1 = r6 instanceof com.uptodown.activities.FreeUpSpaceActivity
                if (r1 == 0) goto L_0x00e4
                com.uptodown.activities.FreeUpSpaceActivity r6 = (com.uptodown.activities.FreeUpSpaceActivity) r6
                java.lang.String r1 = r5.f20818c
                r4 = 6
                r5.f20816a = r4
                java.lang.Object r6 = r6.m3(r3, r1, r5)
                if (r6 != r0) goto L_0x00ed
                goto L_0x0106
            L_0x00e4:
                boolean r1 = r6 instanceof com.uptodown.activities.SecurityActivity
                if (r1 == 0) goto L_0x00ed
                com.uptodown.activities.SecurityActivity r6 = (com.uptodown.activities.SecurityActivity) r6
                r6.i5()
            L_0x00ed:
                N1.k$a r6 = N1.k.f7778g
                r6.O(r2)
                o3.E0 r6 = o3.Y.c()
                h2.b$b$a r1 = new h2.b$b$a
                android.content.BroadcastReceiver$PendingResult r3 = r5.f20819d
                r1.<init>(r3, r2)
                r2 = 7
                r5.f20816a = r2
                java.lang.Object r6 = o3.C0977g.g(r6, r1, r5)
                if (r6 != r0) goto L_0x0107
            L_0x0106:
                return r0
            L_0x0107:
                R2.s r6 = R2.s.f8222a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: h2.C2070b.C0255b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((C0255b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: h2.b$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20822a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2070b f20823b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f20824c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f20825d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2070b bVar, String str, BroadcastReceiver.PendingResult pendingResult, d dVar) {
            super(2, dVar);
            this.f20823b = bVar;
            this.f20824c = str;
            this.f20825d = pendingResult;
        }

        public final d create(Object obj, d dVar) {
            return new c(this.f20823b, this.f20824c, this.f20825d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20822a;
            if (i4 == 0) {
                n.b(obj);
                C2070b bVar = this.f20823b;
                String str = this.f20824c;
                BroadcastReceiver.PendingResult pendingResult = this.f20825d;
                m.b(pendingResult);
                this.f20822a = 1;
                if (bVar.c(str, pendingResult, this) == c5) {
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
    public final Object c(String str, BroadcastReceiver.PendingResult pendingResult, d dVar) {
        Object g4 = C0977g.g(Y.b(), new C0255b(this, str, pendingResult, (d) null), dVar);
        if (g4 == b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data;
        String schemeSpecificPart;
        m.e(context, "context");
        m.e(intent, "intent");
        this.f20815a = k.f7778g.a(context);
        String action = intent.getAction();
        if (action != null) {
            boolean z4 = true;
            if (m3.m.p(action, "android.intent.action.PACKAGE_REMOVED", true) && !intent.getBooleanExtra("android.intent.extra.REPLACING", false) && (data = intent.getData()) != null && (schemeSpecificPart = data.getSchemeSpecificPart()) != null) {
                String str = action + schemeSpecificPart;
                long currentTimeMillis = System.currentTimeMillis();
                if (m3.m.p(str, f20813c, true) && currentTimeMillis - f20814d <= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                    z4 = false;
                }
                f20814d = currentTimeMillis;
                f20813c = str;
                if (z4) {
                    C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (L) null, new c(this, schemeSpecificPart, goAsync(), (d) null), 3, (Object) null);
                }
            }
        }
    }
}
