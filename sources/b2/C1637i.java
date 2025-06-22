package b2;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import android.content.Context;
import d3.p;
import f2.y;
import g2.C2035C;
import g2.C2050h;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;

/* renamed from: b2.i  reason: case insensitive filesystem */
public final class C1637i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f9335a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2050h f9336b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final y f9337c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f9338d;

    /* renamed from: b2.i$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9339a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1637i f9340b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C1637i iVar, d dVar) {
            super(2, dVar);
            this.f9340b = iVar;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f9340b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9339a;
            if (i4 == 0) {
                n.b(obj);
                C1637i iVar = this.f9340b;
                this.f9339a = 1;
                if (iVar.f(this) == c5) {
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

    /* renamed from: b2.i$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9341a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1637i f9342b;

        /* renamed from: b2.i$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9343a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1637i f9344b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f9345c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1637i iVar, ArrayList arrayList, d dVar) {
                super(2, dVar);
                this.f9344b = iVar;
                this.f9345c = arrayList;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f9344b, this.f9345c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9343a == 0) {
                    n.b(obj);
                    this.f9344b.f9337c.a(this.f9345c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.i$b$b  reason: collision with other inner class name */
        static final class C0151b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9346a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1637i f9347b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0151b(C1637i iVar, d dVar) {
                super(2, dVar);
                this.f9347b = iVar;
            }

            public final d create(Object obj, d dVar) {
                return new C0151b(this.f9347b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9346a == 0) {
                    n.b(obj);
                    this.f9347b.f9337c.b();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((C0151b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1637i iVar, d dVar) {
            super(2, dVar);
            this.f9342b = iVar;
        }

        /* access modifiers changed from: private */
        public static final int j(C2035C c5, C2035C c6) {
            if (c5 == null || c6 == null) {
                return 0;
            }
            long g4 = c6.g() - c5.g();
            if (!(g4 != 0 || c5.a() == null || c6.a() == null)) {
                String a5 = c6.a();
                m.b(a5);
                long parseLong = Long.parseLong(a5);
                String a6 = c5.a();
                m.b(a6);
                g4 = parseLong - Long.parseLong(a6);
            }
            return (int) g4;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f9342b, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x007b, code lost:
            if (o3.C0977g.g(r2, r4, r7) == r0) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x008f, code lost:
            if (o3.C0977g.g(r8, r3, r7) == r0) goto L_0x0091;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r7.f9341a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x0017:
                R2.n.b(r8)
                goto L_0x0092
            L_0x001c:
                R2.n.b(r8)
                u2.L r8 = new u2.L
                b2.i r1 = r7.f9342b
                android.content.Context r1 = r1.f9335a
                r8.<init>(r1)
                b2.i r1 = r7.f9342b
                g2.h r1 = r1.f9336b
                long r4 = r1.e()
                b2.i r1 = r7.f9342b
                int r1 = r1.f9338d
                r6 = 20
                g2.L r8 = r8.M0(r4, r6, r1)
                boolean r1 = r8.b()
                if (r1 != 0) goto L_0x0092
                org.json.JSONObject r1 = r8.e()
                if (r1 == 0) goto L_0x0092
                g2.C$b r1 = g2.C2035C.f20340i
                org.json.JSONObject r8 = r8.e()
                kotlin.jvm.internal.m.b(r8)
                java.util.ArrayList r8 = r1.a(r8)
                r1 = 0
                if (r8 == 0) goto L_0x007e
                int r4 = r8.size()
                if (r4 <= 0) goto L_0x007e
                b2.j r2 = new b2.j
                r2.<init>()
                S2.C1601o.t(r8, r2)
                o3.E0 r2 = o3.Y.c()
                b2.i$b$a r4 = new b2.i$b$a
                b2.i r5 = r7.f9342b
                r4.<init>(r5, r8, r1)
                r7.f9341a = r3
                java.lang.Object r8 = o3.C0977g.g(r2, r4, r7)
                if (r8 != r0) goto L_0x0092
                goto L_0x0091
            L_0x007e:
                o3.E0 r8 = o3.Y.c()
                b2.i$b$b r3 = new b2.i$b$b
                b2.i r4 = r7.f9342b
                r3.<init>(r4, r1)
                r7.f9341a = r2
                java.lang.Object r8 = o3.C0977g.g(r8, r3, r7)
                if (r8 != r0) goto L_0x0092
            L_0x0091:
                return r0
            L_0x0092:
                R2.s r8 = R2.s.f8222a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C1637i.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1637i(J j4, Context context, C2050h hVar, y yVar, int i4) {
        m.e(j4, "scope");
        m.e(context, "context");
        m.e(hVar, "appInfo");
        m.e(yVar, "listener");
        this.f9335a = context;
        this.f9336b = hVar;
        this.f9337c = yVar;
        this.f9338d = i4;
        C1001s0 unused = C0981i.d(j4, (g) null, (L) null, new a(this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object f(d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }
}
