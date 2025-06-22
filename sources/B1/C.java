package b1;

import R2.s;
import S0.e;
import V2.d;
import V2.g;
import android.util.Log;
import d1.f;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import p0.C2194f;

public final class C implements com.google.firebase.sessions.b {

    /* renamed from: g  reason: collision with root package name */
    public static final a f8923g = new a((C2103g) null);

    /* renamed from: h  reason: collision with root package name */
    private static final double f8924h = Math.random();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C2194f f8925b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final e f8926c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final f f8927d;

    /* renamed from: e  reason: collision with root package name */
    private final C1626i f8928e;

    /* renamed from: f  reason: collision with root package name */
    private final g f8929f;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f8930a;

        /* renamed from: b  reason: collision with root package name */
        Object f8931b;

        /* renamed from: c  reason: collision with root package name */
        Object f8932c;

        /* renamed from: d  reason: collision with root package name */
        Object f8933d;

        /* renamed from: e  reason: collision with root package name */
        Object f8934e;

        /* renamed from: f  reason: collision with root package name */
        Object f8935f;

        /* renamed from: g  reason: collision with root package name */
        int f8936g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ C f8937h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ z f8938i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C c5, z zVar, d dVar) {
            super(2, dVar);
            this.f8937h = c5;
            this.f8938i = zVar;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f8937h, this.f8938i, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0050, code lost:
            if (r9 == r0) goto L_0x0095;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0069, code lost:
            if (r9 == r0) goto L_0x0095;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r8.f8936g
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0045
                if (r1 == r4) goto L_0x0041
                if (r1 == r3) goto L_0x003d
                if (r1 != r2) goto L_0x0035
                java.lang.Object r0 = r8.f8935f
                d1.f r0 = (d1.f) r0
                java.lang.Object r1 = r8.f8934e
                b1.z r1 = (b1.z) r1
                java.lang.Object r2 = r8.f8933d
                p0.f r2 = (p0.C2194f) r2
                java.lang.Object r3 = r8.f8932c
                b1.B r3 = (b1.C1617B) r3
                java.lang.Object r4 = r8.f8931b
                b1.C r4 = (b1.C) r4
                java.lang.Object r5 = r8.f8930a
                b1.t r5 = (b1.t) r5
                R2.n.b(r9)
                r7 = r3
                r3 = r0
                r0 = r7
                r7 = r2
                r2 = r1
                r1 = r7
            L_0x0032:
                r7 = r4
                goto L_0x009d
            L_0x0035:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x003d:
                R2.n.b(r9)
                goto L_0x006c
            L_0x0041:
                R2.n.b(r9)
                goto L_0x0053
            L_0x0045:
                R2.n.b(r9)
                b1.C r9 = r8.f8937h
                r8.f8936g = r4
                java.lang.Object r9 = r9.i(r8)
                if (r9 != r0) goto L_0x0053
                goto L_0x0095
            L_0x0053:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto L_0x00b0
                b1.t$a r9 = b1.t.f9043c
                b1.C r1 = r8.f8937h
                S0.e r1 = r1.f8926c
                r8.f8936g = r3
                java.lang.Object r9 = r9.a(r1, r8)
                if (r9 != r0) goto L_0x006c
                goto L_0x0095
            L_0x006c:
                r5 = r9
                b1.t r5 = (b1.t) r5
                b1.C r4 = r8.f8937h
                b1.B r3 = b1.C1617B.f8921a
                p0.f r9 = r4.f8925b
                b1.z r1 = r8.f8938i
                b1.C r6 = r8.f8937h
                d1.f r6 = r6.f8927d
                c1.a r7 = c1.C1648a.f9655a
                r8.f8930a = r5
                r8.f8931b = r4
                r8.f8932c = r3
                r8.f8933d = r9
                r8.f8934e = r1
                r8.f8935f = r6
                r8.f8936g = r2
                java.lang.Object r2 = r7.c(r8)
                if (r2 != r0) goto L_0x0096
            L_0x0095:
                return r0
            L_0x0096:
                r0 = r1
                r1 = r9
                r9 = r2
                r2 = r0
                r0 = r3
                r3 = r6
                goto L_0x0032
            L_0x009d:
                r4 = r9
                java.util.Map r4 = (java.util.Map) r4
                r9 = r5
                java.lang.String r5 = r9.b()
                java.lang.String r6 = r9.a()
                b1.A r9 = r0.a(r1, r2, r3, r4, r5, r6)
                r7.g(r9)
            L_0x00b0:
                R2.s r9 = R2.s.f8222a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: b1.C.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f8939a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f8940b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C f8941c;

        /* renamed from: d  reason: collision with root package name */
        int f8942d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C c5, d dVar) {
            super(dVar);
            this.f8941c = c5;
        }

        public final Object invokeSuspend(Object obj) {
            this.f8940b = obj;
            this.f8942d |= Integer.MIN_VALUE;
            return this.f8941c.i(this);
        }
    }

    public C(C2194f fVar, e eVar, f fVar2, C1626i iVar, g gVar) {
        m.e(fVar, "firebaseApp");
        m.e(eVar, "firebaseInstallations");
        m.e(fVar2, "sessionSettings");
        m.e(iVar, "eventGDTLogger");
        m.e(gVar, "backgroundDispatcher");
        this.f8925b = fVar;
        this.f8926c = eVar;
        this.f8927d = fVar2;
        this.f8928e = iVar;
        this.f8929f = gVar;
    }

    /* access modifiers changed from: private */
    public final void g(C1616A a5) {
        try {
            this.f8928e.a(a5);
            Log.d("SessionFirelogPublisher", "Successfully logged Session Start event: " + a5.c().f());
        } catch (RuntimeException e5) {
            Log.e("SessionFirelogPublisher", "Error logging Session Start event to DataTransport: ", e5);
        }
    }

    private final boolean h() {
        if (f8924h <= this.f8927d.b()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(V2.d r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof b1.C.c
            if (r0 == 0) goto L_0x0013
            r0 = r6
            b1.C$c r0 = (b1.C.c) r0
            int r1 = r0.f8942d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f8942d = r1
            goto L_0x0018
        L_0x0013:
            b1.C$c r0 = new b1.C$c
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f8940b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f8942d
            java.lang.String r3 = "SessionFirelogPublisher"
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r0 = r0.f8939a
            b1.C r0 = (b1.C) r0
            R2.n.b(r6)
            goto L_0x004d
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0037:
            R2.n.b(r6)
            java.lang.String r6 = "Data Collection is enabled for at least one Subscriber"
            android.util.Log.d(r3, r6)
            d1.f r6 = r5.f8927d
            r0.f8939a = r5
            r0.f8942d = r4
            java.lang.Object r6 = r6.g(r0)
            if (r6 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r0 = r5
        L_0x004d:
            d1.f r6 = r0.f8927d
            boolean r6 = r6.d()
            r1 = 0
            if (r6 != 0) goto L_0x0060
            java.lang.String r6 = "Sessions SDK disabled. Events will not be sent."
            android.util.Log.d(r3, r6)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.b.a(r1)
            return r6
        L_0x0060:
            boolean r6 = r0.h()
            if (r6 != 0) goto L_0x0070
            java.lang.String r6 = "Sessions SDK has dropped this session due to sampling."
            android.util.Log.d(r3, r6)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.b.a(r1)
            return r6
        L_0x0070:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.b.a(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.C.i(V2.d):java.lang.Object");
    }

    public void a(z zVar) {
        m.e(zVar, "sessionDetails");
        C1001s0 unused = C0981i.d(K.a(this.f8929f), (g) null, (L) null, new b(this, zVar, (d) null), 3, (Object) null);
    }
}
