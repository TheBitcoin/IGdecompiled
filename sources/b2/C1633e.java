package b2;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import android.content.Context;
import d3.p;
import f2.C2023n;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;

/* renamed from: b2.e  reason: case insensitive filesystem */
public final class C1633e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f9140a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2023n f9141b;

    /* renamed from: c  reason: collision with root package name */
    private final J f9142c;

    /* renamed from: b2.e$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9143a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1633e f9144b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C1633e eVar, d dVar) {
            super(2, dVar);
            this.f9144b = eVar;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f9144b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9143a;
            if (i4 == 0) {
                n.b(obj);
                C1633e eVar = this.f9144b;
                this.f9143a = 1;
                if (eVar.d(this) == c5) {
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

    /* renamed from: b2.e$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9145a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1633e f9146b;

        /* renamed from: b2.e$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9147a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1633e f9148b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1633e eVar, V2.d dVar) {
                super(2, dVar);
                this.f9148b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9148b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9147a == 0) {
                    n.b(obj);
                    this.f9148b.f9141b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.e$b$b  reason: collision with other inner class name */
        static final class C0141b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9149a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1633e f9150b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0141b(C1633e eVar, V2.d dVar) {
                super(2, dVar);
                this.f9150b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0141b(this.f9150b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9149a == 0) {
                    n.b(obj);
                    this.f9150b.f9141b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0141b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.e$b$c */
        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9151a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1633e f9152b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(C1633e eVar, V2.d dVar) {
                super(2, dVar);
                this.f9152b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new c(this.f9152b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9151a == 0) {
                    n.b(obj);
                    this.f9152b.f9141b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.e$b$d */
        static final class d extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9153a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1633e f9154b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(C1633e eVar, V2.d dVar) {
                super(2, dVar);
                this.f9154b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new d(this.f9154b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9153a == 0) {
                    n.b(obj);
                    this.f9154b.f9141b.b();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.e$b$e  reason: collision with other inner class name */
        static final class C0142e extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9155a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1633e f9156b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0142e(C1633e eVar, V2.d dVar) {
                super(2, dVar);
                this.f9156b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0142e(this.f9156b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9155a == 0) {
                    n.b(obj);
                    this.f9156b.f9141b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0142e) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.e$b$f */
        static final class f extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9157a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1633e f9158b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(C1633e eVar, V2.d dVar) {
                super(2, dVar);
                this.f9158b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new f(this.f9158b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9157a == 0) {
                    n.b(obj);
                    this.f9158b.f9141b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.e$b$g */
        static final class g extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9159a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1633e f9160b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(C1633e eVar, V2.d dVar) {
                super(2, dVar);
                this.f9160b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new g(this.f9160b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9159a == 0) {
                    n.b(obj);
                    this.f9160b.f9141b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.e$b$h */
        static final class h extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9161a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1633e f9162b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            h(C1633e eVar, V2.d dVar) {
                super(2, dVar);
                this.f9162b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new h(this.f9162b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9161a == 0) {
                    n.b(obj);
                    this.f9162b.f9141b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((h) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.e$b$i */
        static final class i extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9163a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1633e f9164b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            i(C1633e eVar, V2.d dVar) {
                super(2, dVar);
                this.f9164b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new i(this.f9164b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9163a == 0) {
                    n.b(obj);
                    this.f9164b.f9141b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((i) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.e$b$j */
        static final class j extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9165a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1633e f9166b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            j(C1633e eVar, V2.d dVar) {
                super(2, dVar);
                this.f9166b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new j(this.f9166b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9165a == 0) {
                    n.b(obj);
                    this.f9166b.f9141b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((j) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1633e eVar, V2.d dVar) {
            super(2, dVar);
            this.f9146b = eVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f9146b, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0042, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x0206;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x013b, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x0206;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0151, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x0206;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0167, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x0206;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x017d, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x0206;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0193, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x0206;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x01a8, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x0206;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x01c7, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x0206;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x01dd, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x0206;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0204, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x0206;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                r17 = this;
                r0 = r17
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f9145a
                switch(r2) {
                    case 0: goto L_0x0018;
                    case 1: goto L_0x0013;
                    case 2: goto L_0x0013;
                    case 3: goto L_0x0013;
                    case 4: goto L_0x0013;
                    case 5: goto L_0x0013;
                    case 6: goto L_0x0013;
                    case 7: goto L_0x0013;
                    case 8: goto L_0x0013;
                    case 9: goto L_0x0013;
                    case 10: goto L_0x0013;
                    default: goto L_0x000b;
                }
            L_0x000b:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0013:
                R2.n.b(r18)
                goto L_0x0207
            L_0x0018:
                R2.n.b(r18)
                g2.j$a r2 = g2.C2052j.f20686n
                b2.e r3 = r0.f9146b
                android.content.Context r3 = r3.f9140a
                g2.j r3 = r2.d(r3)
                r4 = 1
                r5 = 0
                if (r3 == 0) goto L_0x0046
                boolean r6 = r3.d()
                if (r6 != 0) goto L_0x0046
                o3.E0 r2 = o3.Y.c()
                b2.e$b$b r3 = new b2.e$b$b
                b2.e r6 = r0.f9146b
                r3.<init>(r6, r5)
                r0.f9145a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0207
                goto L_0x0206
            L_0x0046:
                u2.L r6 = new u2.L
                b2.e r7 = r0.f9146b
                android.content.Context r7 = r7.f9140a
                r6.<init>(r7)
                g2.L r7 = r6.p()
                boolean r8 = r7.b()
                if (r8 != 0) goto L_0x01e0
                org.json.JSONObject r8 = r7.e()
                if (r8 == 0) goto L_0x01e0
                org.json.JSONObject r7 = r7.e()
                kotlin.jvm.internal.m.b(r7)
                java.lang.String r8 = "success"
                boolean r9 = r7.isNull(r8)
                if (r9 != 0) goto L_0x01ca
                int r9 = r7.optInt(r8)
                if (r9 != r4) goto L_0x01ab
                java.lang.String r9 = "data"
                org.json.JSONObject r7 = r7.optJSONObject(r9)
                if (r7 == 0) goto L_0x0196
                g2.j r7 = r2.c(r7)
                if (r7 == 0) goto L_0x0181
                long r10 = java.lang.System.currentTimeMillis()
                r12 = 1000(0x3e8, float:1.401E-42)
                long r12 = (long) r12
                long r10 = r10 / r12
                r7.y(r10)
                if (r3 != 0) goto L_0x009b
                b2.e r3 = r0.f9146b
                android.content.Context r3 = r3.f9140a
                r7.t(r3)
                goto L_0x00e1
            L_0x009b:
                long r10 = r7.k()
                long r14 = r3.k()
                int r16 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
                if (r16 != 0) goto L_0x00d8
                java.lang.String r10 = r7.n()
                java.lang.String r11 = r3.n()
                boolean r10 = m3.m.p(r10, r11, r4)
                if (r10 != 0) goto L_0x00ce
                java.lang.String r10 = r7.n()
                r3.A(r10)
                long r10 = java.lang.System.currentTimeMillis()
                long r10 = r10 / r12
                r3.y(r10)
                b2.e r10 = r0.f9146b
                android.content.Context r10 = r10.f9140a
                r3.t(r10)
                goto L_0x00e1
            L_0x00ce:
                b2.e r3 = r0.f9146b
                android.content.Context r3 = r3.f9140a
                r7.t(r3)
                goto L_0x00e1
            L_0x00d8:
                b2.e r3 = r0.f9146b
                android.content.Context r3 = r3.f9140a
                r7.t(r3)
            L_0x00e1:
                long r10 = r7.k()
                g2.L r3 = r6.T(r10)
                boolean r6 = r3.b()
                if (r6 != 0) goto L_0x016b
                java.lang.String r6 = r3.d()
                if (r6 == 0) goto L_0x016b
                int r6 = r6.length()
                if (r6 != 0) goto L_0x00fc
                goto L_0x016b
            L_0x00fc:
                org.json.JSONObject r6 = new org.json.JSONObject
                java.lang.String r3 = r3.d()
                kotlin.jvm.internal.m.b(r3)
                r6.<init>(r3)
                int r3 = r6.optInt(r8)
                org.json.JSONObject r6 = r6.optJSONObject(r9)
                if (r3 != r4) goto L_0x0155
                if (r6 == 0) goto L_0x0155
                g2.h$b r3 = g2.C2050h.f20600F0
                r4 = 2
                g2.h r3 = g2.C2050h.b.b(r3, r6, r5, r4, r5)
                boolean r3 = r3.B0()
                if (r3 != 0) goto L_0x013f
                b2.e r3 = r0.f9146b
                android.content.Context r3 = r3.f9140a
                r2.a(r3)
                o3.E0 r2 = o3.Y.c()
                b2.e$b$c r3 = new b2.e$b$c
                b2.e r6 = r0.f9146b
                r3.<init>(r6, r5)
                r0.f9145a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0207
                goto L_0x0206
            L_0x013f:
                o3.E0 r2 = o3.Y.c()
                b2.e$b$d r3 = new b2.e$b$d
                b2.e r4 = r0.f9146b
                r3.<init>(r4, r5)
                r4 = 3
                r0.f9145a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0207
                goto L_0x0206
            L_0x0155:
                o3.E0 r2 = o3.Y.c()
                b2.e$b$e r3 = new b2.e$b$e
                b2.e r4 = r0.f9146b
                r3.<init>(r4, r5)
                r4 = 4
                r0.f9145a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0207
                goto L_0x0206
            L_0x016b:
                o3.E0 r2 = o3.Y.c()
                b2.e$b$f r3 = new b2.e$b$f
                b2.e r4 = r0.f9146b
                r3.<init>(r4, r5)
                r4 = 5
                r0.f9145a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0207
                goto L_0x0206
            L_0x0181:
                o3.E0 r2 = o3.Y.c()
                b2.e$b$g r3 = new b2.e$b$g
                b2.e r4 = r0.f9146b
                r3.<init>(r4, r5)
                r4 = 6
                r0.f9145a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0207
                goto L_0x0206
            L_0x0196:
                o3.E0 r2 = o3.Y.c()
                b2.e$b$h r3 = new b2.e$b$h
                b2.e r4 = r0.f9146b
                r3.<init>(r4, r5)
                r4 = 7
                r0.f9145a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0207
                goto L_0x0206
            L_0x01ab:
                b2.e r3 = r0.f9146b
                android.content.Context r3 = r3.f9140a
                r2.a(r3)
                o3.E0 r2 = o3.Y.c()
                b2.e$b$i r3 = new b2.e$b$i
                b2.e r4 = r0.f9146b
                r3.<init>(r4, r5)
                r4 = 8
                r0.f9145a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0207
                goto L_0x0206
            L_0x01ca:
                o3.E0 r2 = o3.Y.c()
                b2.e$b$j r3 = new b2.e$b$j
                b2.e r4 = r0.f9146b
                r3.<init>(r4, r5)
                r4 = 9
                r0.f9145a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0207
                goto L_0x0206
            L_0x01e0:
                int r3 = r7.f()
                r4 = 404(0x194, float:5.66E-43)
                if (r3 != r4) goto L_0x01f1
                b2.e r3 = r0.f9146b
                android.content.Context r3 = r3.f9140a
                r2.a(r3)
            L_0x01f1:
                o3.E0 r2 = o3.Y.c()
                b2.e$b$a r3 = new b2.e$b$a
                b2.e r4 = r0.f9146b
                r3.<init>(r4, r5)
                r4 = 10
                r0.f9145a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0207
            L_0x0206:
                return r1
            L_0x0207:
                R2.s r1 = R2.s.f8222a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C1633e.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1633e(Context context, C2023n nVar, J j4) {
        m.e(context, "context");
        m.e(nVar, "listener");
        m.e(j4, "scope");
        this.f9140a = context;
        this.f9141b = nVar;
        this.f9142c = j4;
        C1001s0 unused = C0981i.d(j4, (g) null, (L) null, new a(this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object d(d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }
}
