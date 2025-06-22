package R1;

import R2.n;
import R2.s;
import S1.m;
import V2.d;
import V2.g;
import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.z;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;

public final class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f8180a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f8181b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final m f8182c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final boolean f8183d;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8184a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f8185b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(c cVar, d dVar) {
            super(2, dVar);
            this.f8185b = cVar;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f8185b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f8184a;
            if (i4 == 0) {
                n.b(obj);
                c cVar = this.f8185b;
                this.f8184a = 1;
                if (cVar.f(this) == c5) {
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
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8186a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f8187b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ z f8188c;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8189a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ c f8190b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, d dVar) {
                super(2, dVar);
                this.f8190b = cVar;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f8190b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8189a == 0) {
                    n.b(obj);
                    this.f8190b.f8182c.f();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: R1.c$b$b  reason: collision with other inner class name */
        static final class C0104b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8191a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ c f8192b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0104b(c cVar, d dVar) {
                super(2, dVar);
                this.f8192b = cVar;
            }

            public final d create(Object obj, d dVar) {
                return new C0104b(this.f8192b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8191a == 0) {
                    n.b(obj);
                    this.f8192b.f8182c.i();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((C0104b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar, z zVar, d dVar) {
            super(2, dVar);
            this.f8187b = cVar;
            this.f8188c = zVar;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f8187b, this.f8188c, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a7, code lost:
            if (r15.g(r1, r5, r2, r14) == r0) goto L_0x00da;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c4, code lost:
            if (o3.C0977g.g(r15, r2, r14) == r0) goto L_0x00da;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d8, code lost:
            if (o3.C0977g.g(r15, r3, r14) == r0) goto L_0x00da;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r14.f8186a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001f
                if (r1 == r4) goto L_0x001a
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                goto L_0x001a
            L_0x0012:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x001a:
                R2.n.b(r15)
                goto L_0x00db
            L_0x001f:
                R2.n.b(r15)
                N1.k$a r15 = N1.k.f7778g
                R1.c r1 = r14.f8187b
                java.lang.String r1 = r1.f8181b
                r15.c(r1)
                W1.h r15 = new W1.h
                r15.<init>()
                R1.c r1 = r14.f8187b
                android.content.Context r1 = r1.f8180a
                java.io.File r15 = r15.g(r1)
                java.io.File r1 = new java.io.File
                R1.c r5 = r14.f8187b
                java.lang.String r5 = r5.f8181b
                r1.<init>(r5)
                java.io.File r5 = new java.io.File
                java.lang.String r6 = r1.getName()
                java.lang.String r7 = "fileZipped.name"
                kotlin.jvm.internal.m.d(r6, r7)
                java.lang.String r8 = r1.getName()
                kotlin.jvm.internal.m.d(r8, r7)
                r12 = 6
                r13 = 0
                java.lang.String r9 = "."
                r10 = 0
                r11 = 0
                int r7 = m3.m.R(r8, r9, r10, r11, r12, r13)
                r8 = 0
                java.lang.String r6 = r6.substring(r8, r7)
                java.lang.String r7 = "this as java.lang.String…ing(startIndex, endIndex)"
                kotlin.jvm.internal.m.d(r6, r7)
                r5.<init>(r15, r6)
                boolean r15 = r5.exists()
                if (r15 != 0) goto L_0x0079
                r5.mkdirs()
            L_0x0079:
                W1.G r15 = new W1.G
                r15.<init>()
                boolean r6 = r15.c(r1)
                if (r6 == 0) goto L_0x0095
                W1.h r6 = new W1.h
                r6.<init>()
                java.io.File r6 = r6.e()
                kotlin.jvm.internal.z r7 = r14.f8188c
                boolean r6 = r6.canWrite()
                r7.f20985a = r6
            L_0x0095:
                kotlin.jvm.internal.z r6 = r14.f8188c
                boolean r6 = r6.f20985a
                if (r6 == 0) goto L_0x00aa
                R1.c r2 = r14.f8187b
                S1.m r2 = r2.f8182c
                r14.f8186a = r4
                java.lang.Object r15 = r15.g(r1, r5, r2, r14)
                if (r15 != r0) goto L_0x00db
                goto L_0x00da
            L_0x00aa:
                R1.c r15 = r14.f8187b
                boolean r15 = r15.f8183d
                r1 = 0
                if (r15 == 0) goto L_0x00c7
                o3.E0 r15 = o3.Y.c()
                R1.c$b$a r2 = new R1.c$b$a
                R1.c r4 = r14.f8187b
                r2.<init>(r4, r1)
                r14.f8186a = r3
                java.lang.Object r15 = o3.C0977g.g(r15, r2, r14)
                if (r15 != r0) goto L_0x00db
                goto L_0x00da
            L_0x00c7:
                o3.E0 r15 = o3.Y.c()
                R1.c$b$b r3 = new R1.c$b$b
                R1.c r4 = r14.f8187b
                r3.<init>(r4, r1)
                r14.f8186a = r2
                java.lang.Object r15 = o3.C0977g.g(r15, r3, r14)
                if (r15 != r0) goto L_0x00db
            L_0x00da:
                return r0
            L_0x00db:
                R2.s r15 = R2.s.f8222a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.c.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public c(Context context, String str, m mVar, boolean z4) {
        kotlin.jvm.internal.m.e(context, "context");
        kotlin.jvm.internal.m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        kotlin.jvm.internal.m.e(mVar, "xapkProcesationListener");
        this.f8180a = context;
        this.f8181b = str;
        this.f8182c = mVar;
        this.f8183d = z4;
        C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (L) null, new a(this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object f(d dVar) {
        z zVar = new z();
        zVar.f20985a = true;
        Object g4 = C0977g.g(Y.b(), new b(this, zVar, (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }
}
