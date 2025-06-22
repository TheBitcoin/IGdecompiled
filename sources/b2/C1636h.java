package b2;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import android.content.Context;
import d3.p;
import f2.C2026q;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;

/* renamed from: b2.h  reason: case insensitive filesystem */
public final class C1636h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f9309a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2026q f9310b;

    /* renamed from: b2.h$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9311a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1636h f9312b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C1636h hVar, d dVar) {
            super(2, dVar);
            this.f9312b = hVar;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f9312b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9311a;
            if (i4 == 0) {
                n.b(obj);
                C1636h hVar = this.f9312b;
                this.f9311a = 1;
                if (hVar.d(this) == c5) {
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

    /* renamed from: b2.h$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9313a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1636h f9314b;

        /* renamed from: b2.h$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9315a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1636h f9316b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1636h hVar, V2.d dVar) {
                super(2, dVar);
                this.f9316b = hVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9316b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9315a == 0) {
                    n.b(obj);
                    this.f9316b.f9310b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.h$b$b  reason: collision with other inner class name */
        static final class C0149b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9317a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1636h f9318b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0149b(C1636h hVar, V2.d dVar) {
                super(2, dVar);
                this.f9318b = hVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0149b(this.f9318b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9317a == 0) {
                    n.b(obj);
                    this.f9318b.f9310b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0149b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.h$b$c */
        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9319a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1636h f9320b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(C1636h hVar, V2.d dVar) {
                super(2, dVar);
                this.f9320b = hVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new c(this.f9320b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9319a == 0) {
                    n.b(obj);
                    this.f9320b.f9310b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.h$b$d */
        static final class d extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9321a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1636h f9322b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(C1636h hVar, V2.d dVar) {
                super(2, dVar);
                this.f9322b = hVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new d(this.f9322b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9321a == 0) {
                    n.b(obj);
                    this.f9322b.f9310b.b();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.h$b$e */
        static final class e extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9323a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1636h f9324b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(C1636h hVar, V2.d dVar) {
                super(2, dVar);
                this.f9324b = hVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new e(this.f9324b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9323a == 0) {
                    n.b(obj);
                    this.f9324b.f9310b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.h$b$f */
        static final class f extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9325a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1636h f9326b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(C1636h hVar, V2.d dVar) {
                super(2, dVar);
                this.f9326b = hVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new f(this.f9326b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9325a == 0) {
                    n.b(obj);
                    this.f9326b.f9310b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.h$b$g */
        static final class g extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9327a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1636h f9328b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(C1636h hVar, V2.d dVar) {
                super(2, dVar);
                this.f9328b = hVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new g(this.f9328b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9327a == 0) {
                    n.b(obj);
                    this.f9328b.f9310b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.h$b$h  reason: collision with other inner class name */
        static final class C0150h extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9329a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1636h f9330b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0150h(C1636h hVar, V2.d dVar) {
                super(2, dVar);
                this.f9330b = hVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0150h(this.f9330b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9329a == 0) {
                    n.b(obj);
                    this.f9330b.f9310b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0150h) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.h$b$i */
        static final class i extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9331a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1636h f9332b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            i(C1636h hVar, V2.d dVar) {
                super(2, dVar);
                this.f9332b = hVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new i(this.f9332b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9331a == 0) {
                    n.b(obj);
                    this.f9332b.f9310b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((i) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.h$b$j */
        static final class j extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9333a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1636h f9334b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            j(C1636h hVar, V2.d dVar) {
                super(2, dVar);
                this.f9334b = hVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new j(this.f9334b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9333a == 0) {
                    n.b(obj);
                    this.f9334b.f9310b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((j) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1636h hVar, V2.d dVar) {
            super(2, dVar);
            this.f9314b = hVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f9314b, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0042, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x01ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0134, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x01ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x014a, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x01ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0160, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x01ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0176, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x01ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x018c, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x01ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x01a1, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x01ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x01c0, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x01ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x01d6, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x01ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x01fd, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x01ff;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                r17 = this;
                r0 = r17
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f9313a
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
                goto L_0x0200
            L_0x0018:
                R2.n.b(r18)
                g2.x$a r2 = g2.C2065x.f20781n
                b2.h r3 = r0.f9314b
                android.content.Context r3 = r3.f9309a
                g2.x r3 = r2.d(r3)
                r4 = 1
                r5 = 0
                if (r3 == 0) goto L_0x0046
                boolean r6 = r3.d()
                if (r6 != 0) goto L_0x0046
                o3.E0 r2 = o3.Y.c()
                b2.h$b$b r3 = new b2.h$b$b
                b2.h r6 = r0.f9314b
                r3.<init>(r6, r5)
                r0.f9313a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0200
                goto L_0x01ff
            L_0x0046:
                u2.L r6 = new u2.L
                b2.h r7 = r0.f9314b
                android.content.Context r7 = r7.f9309a
                r6.<init>(r7)
                g2.L r7 = r6.B()
                boolean r8 = r7.b()
                if (r8 != 0) goto L_0x01d9
                org.json.JSONObject r8 = r7.e()
                if (r8 == 0) goto L_0x01d9
                org.json.JSONObject r7 = r7.e()
                kotlin.jvm.internal.m.b(r7)
                java.lang.String r8 = "success"
                boolean r9 = r7.isNull(r8)
                if (r9 != 0) goto L_0x01c3
                int r9 = r7.optInt(r8)
                if (r9 != r4) goto L_0x01a4
                java.lang.String r9 = "data"
                org.json.JSONObject r7 = r7.optJSONObject(r9)
                if (r7 == 0) goto L_0x018f
                g2.x r7 = r2.c(r7)
                if (r7 == 0) goto L_0x017a
                long r10 = java.lang.System.currentTimeMillis()
                r12 = 1000(0x3e8, float:1.401E-42)
                long r12 = (long) r12
                long r10 = r10 / r12
                r7.y(r10)
                if (r3 != 0) goto L_0x009b
                b2.h r3 = r0.f9314b
                android.content.Context r3 = r3.f9309a
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
                long r10 = java.lang.System.currentTimeMillis()
                long r10 = r10 / r12
                r3.y(r10)
                java.lang.String r10 = r7.n()
                r3.A(r10)
                b2.h r10 = r0.f9314b
                android.content.Context r10 = r10.f9309a
                r3.t(r10)
                goto L_0x00e1
            L_0x00ce:
                b2.h r3 = r0.f9314b
                android.content.Context r3 = r3.f9309a
                r7.t(r3)
                goto L_0x00e1
            L_0x00d8:
                b2.h r3 = r0.f9314b
                android.content.Context r3 = r3.f9309a
                r7.t(r3)
            L_0x00e1:
                long r10 = r7.k()
                g2.L r3 = r6.T(r10)
                boolean r6 = r3.b()
                if (r6 != 0) goto L_0x0164
                java.lang.String r6 = r3.d()
                if (r6 == 0) goto L_0x0164
                org.json.JSONObject r6 = new org.json.JSONObject
                java.lang.String r3 = r3.d()
                kotlin.jvm.internal.m.b(r3)
                r6.<init>(r3)
                org.json.JSONObject r3 = r6.optJSONObject(r9)
                int r6 = r6.optInt(r8)
                if (r6 != r4) goto L_0x014e
                if (r3 == 0) goto L_0x014e
                g2.h$b r4 = g2.C2050h.f20600F0
                r6 = 2
                g2.h r3 = g2.C2050h.b.b(r4, r3, r5, r6, r5)
                boolean r3 = r3.B0()
                if (r3 != 0) goto L_0x0138
                b2.h r3 = r0.f9314b
                android.content.Context r3 = r3.f9309a
                r2.a(r3)
                o3.E0 r2 = o3.Y.c()
                b2.h$b$c r3 = new b2.h$b$c
                b2.h r4 = r0.f9314b
                r3.<init>(r4, r5)
                r0.f9313a = r6
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0200
                goto L_0x01ff
            L_0x0138:
                o3.E0 r2 = o3.Y.c()
                b2.h$b$d r3 = new b2.h$b$d
                b2.h r4 = r0.f9314b
                r3.<init>(r4, r5)
                r4 = 3
                r0.f9313a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0200
                goto L_0x01ff
            L_0x014e:
                o3.E0 r2 = o3.Y.c()
                b2.h$b$e r3 = new b2.h$b$e
                b2.h r4 = r0.f9314b
                r3.<init>(r4, r5)
                r4 = 4
                r0.f9313a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0200
                goto L_0x01ff
            L_0x0164:
                o3.E0 r2 = o3.Y.c()
                b2.h$b$f r3 = new b2.h$b$f
                b2.h r4 = r0.f9314b
                r3.<init>(r4, r5)
                r4 = 5
                r0.f9313a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0200
                goto L_0x01ff
            L_0x017a:
                o3.E0 r2 = o3.Y.c()
                b2.h$b$g r3 = new b2.h$b$g
                b2.h r4 = r0.f9314b
                r3.<init>(r4, r5)
                r4 = 6
                r0.f9313a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0200
                goto L_0x01ff
            L_0x018f:
                o3.E0 r2 = o3.Y.c()
                b2.h$b$h r3 = new b2.h$b$h
                b2.h r4 = r0.f9314b
                r3.<init>(r4, r5)
                r4 = 7
                r0.f9313a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0200
                goto L_0x01ff
            L_0x01a4:
                b2.h r3 = r0.f9314b
                android.content.Context r3 = r3.f9309a
                r2.a(r3)
                o3.E0 r2 = o3.Y.c()
                b2.h$b$i r3 = new b2.h$b$i
                b2.h r4 = r0.f9314b
                r3.<init>(r4, r5)
                r4 = 8
                r0.f9313a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0200
                goto L_0x01ff
            L_0x01c3:
                o3.E0 r2 = o3.Y.c()
                b2.h$b$j r3 = new b2.h$b$j
                b2.h r4 = r0.f9314b
                r3.<init>(r4, r5)
                r4 = 9
                r0.f9313a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0200
                goto L_0x01ff
            L_0x01d9:
                int r3 = r7.f()
                r4 = 404(0x194, float:5.66E-43)
                if (r3 != r4) goto L_0x01ea
                b2.h r3 = r0.f9314b
                android.content.Context r3 = r3.f9309a
                r2.a(r3)
            L_0x01ea:
                o3.E0 r2 = o3.Y.c()
                b2.h$b$a r3 = new b2.h$b$a
                b2.h r4 = r0.f9314b
                r3.<init>(r4, r5)
                r4 = 10
                r0.f9313a = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0200
            L_0x01ff:
                return r1
            L_0x0200:
                R2.s r1 = R2.s.f8222a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C1636h.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1636h(Context context, C2026q qVar, J j4) {
        m.e(context, "context");
        m.e(qVar, "listener");
        m.e(j4, "scope");
        this.f9309a = context;
        this.f9310b = qVar;
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
