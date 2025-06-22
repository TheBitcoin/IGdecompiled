package b2;

import R2.n;
import R2.s;
import V2.g;
import android.content.Context;
import d3.p;
import f2.z;
import g2.C2039G;
import g2.C2050h;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;

public final class r {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f9488a;

    /* renamed from: b  reason: collision with root package name */
    private final J f9489b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final z f9490c;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9491a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ r f9492b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2039G f9493c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(r rVar, C2039G g4, V2.d dVar) {
            super(2, dVar);
            this.f9492b = rVar;
            this.f9493c = g4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f9492b, this.f9493c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9491a;
            if (i4 == 0) {
                n.b(obj);
                r rVar = this.f9492b;
                C2039G g4 = this.f9493c;
                this.f9491a = 1;
                if (rVar.f(g4, this) == c5) {
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
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9494a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ r f9495b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2039G f9496c;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9497a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ r f9498b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(r rVar, V2.d dVar) {
                super(2, dVar);
                this.f9498b = rVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9498b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9497a == 0) {
                    n.b(obj);
                    this.f9498b.f9490c.b();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.r$b$b  reason: collision with other inner class name */
        static final class C0157b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9499a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ r f9500b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0157b(r rVar, V2.d dVar) {
                super(2, dVar);
                this.f9500b = rVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0157b(this.f9500b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9499a == 0) {
                    n.b(obj);
                    this.f9500b.f9490c.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0157b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9501a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ r f9502b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(r rVar, V2.d dVar) {
                super(2, dVar);
                this.f9502b = rVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new c(this.f9502b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9501a == 0) {
                    n.b(obj);
                    this.f9502b.f9490c.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(r rVar, C2039G g4, V2.d dVar) {
            super(2, dVar);
            this.f9495b = rVar;
            this.f9496c = g4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f9495b, this.f9496c, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x008b, code lost:
            if (o3.C0977g.g(r8, r1, r7) == r0) goto L_0x00b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x009f, code lost:
            if (o3.C0977g.g(r8, r1, r7) == r0) goto L_0x00b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x00b3, code lost:
            if (o3.C0977g.g(r8, r1, r7) == r0) goto L_0x00b5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r7.f9494a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001f
                if (r1 == r4) goto L_0x001a
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                goto L_0x001a
            L_0x0012:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001a:
                R2.n.b(r8)
                goto L_0x00b6
            L_0x001f:
                R2.n.b(r8)
                u2.L r8 = new u2.L
                b2.r r1 = r7.f9495b
                android.content.Context r1 = r1.f9488a
                r8.<init>(r1)
                g2.G r1 = r7.f9496c
                long r5 = r1.c()
                g2.L r8 = r8.e(r5)
                boolean r1 = r8.b()
                r5 = 0
                if (r1 != 0) goto L_0x00a2
                org.json.JSONObject r1 = r8.e()
                if (r1 == 0) goto L_0x00a2
                org.json.JSONObject r8 = r8.e()
                kotlin.jvm.internal.m.b(r8)
                java.lang.String r1 = "success"
                int r8 = r8.optInt(r1)
                if (r8 != r4) goto L_0x008e
                android.os.Bundle r8 = new android.os.Bundle
                r8.<init>()
                java.lang.String r1 = "type"
                java.lang.String r2 = "removed"
                r8.putString(r1, r2)
                u2.x r1 = new u2.x
                b2.r r2 = r7.f9495b
                android.content.Context r2 = r2.f9488a
                r1.<init>(r2)
                java.lang.String r2 = "preregister"
                r1.d(r2, r8)
                g2.G r8 = r7.f9496c
                b2.r r1 = r7.f9495b
                android.content.Context r1 = r1.f9488a
                r8.j(r1)
                o3.E0 r8 = o3.Y.c()
                b2.r$b$a r1 = new b2.r$b$a
                b2.r r2 = r7.f9495b
                r1.<init>(r2, r5)
                r7.f9494a = r4
                java.lang.Object r8 = o3.C0977g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x00b6
                goto L_0x00b5
            L_0x008e:
                o3.E0 r8 = o3.Y.c()
                b2.r$b$b r1 = new b2.r$b$b
                b2.r r2 = r7.f9495b
                r1.<init>(r2, r5)
                r7.f9494a = r3
                java.lang.Object r8 = o3.C0977g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x00b6
                goto L_0x00b5
            L_0x00a2:
                o3.E0 r8 = o3.Y.c()
                b2.r$b$c r1 = new b2.r$b$c
                b2.r r3 = r7.f9495b
                r1.<init>(r3, r5)
                r7.f9494a = r2
                java.lang.Object r8 = o3.C0977g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x00b6
            L_0x00b5:
                return r0
            L_0x00b6:
                R2.s r8 = R2.s.f8222a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.r.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9503a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ r f9504b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2050h f9505c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(r rVar, C2050h hVar, V2.d dVar) {
            super(2, dVar);
            this.f9504b = rVar;
            this.f9505c = hVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f9504b, this.f9505c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9503a;
            if (i4 == 0) {
                n.b(obj);
                r rVar = this.f9504b;
                C2050h hVar = this.f9505c;
                this.f9503a = 1;
                if (rVar.h(hVar, this) == c5) {
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
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9506a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2050h f9507b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ r f9508c;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9509a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ r f9510b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(r rVar, V2.d dVar) {
                super(2, dVar);
                this.f9510b = rVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9510b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9509a == 0) {
                    n.b(obj);
                    this.f9510b.f9490c.c();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9511a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ r f9512b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(r rVar, V2.d dVar) {
                super(2, dVar);
                this.f9512b = rVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f9512b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9511a == 0) {
                    n.b(obj);
                    this.f9512b.f9490c.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9513a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ r f9514b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(r rVar, V2.d dVar) {
                super(2, dVar);
                this.f9514b = rVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new c(this.f9514b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9513a == 0) {
                    n.b(obj);
                    this.f9514b.f9490c.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C2050h hVar, r rVar, V2.d dVar) {
            super(2, dVar);
            this.f9507b = hVar;
            this.f9508c = rVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f9507b, this.f9508c, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00bc, code lost:
            if (o3.C0977g.g(r14, r1, r13) == r0) goto L_0x00e6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d0, code lost:
            if (o3.C0977g.g(r14, r1, r13) == r0) goto L_0x00e6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e4, code lost:
            if (o3.C0977g.g(r14, r1, r13) == r0) goto L_0x00e6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r13.f9506a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001f
                if (r1 == r4) goto L_0x001a
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                goto L_0x001a
            L_0x0012:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L_0x001a:
                R2.n.b(r14)
                goto L_0x00e7
            L_0x001f:
                R2.n.b(r14)
                g2.h r14 = r13.f9507b
                java.lang.String r14 = r14.L()
                if (r14 == 0) goto L_0x0035
                g2.h r14 = r13.f9507b
                java.lang.String r14 = r14.L()
                kotlin.jvm.internal.m.b(r14)
            L_0x0033:
                r8 = r14
                goto L_0x003f
            L_0x0035:
                g2.h r14 = r13.f9507b
                java.lang.String r14 = r14.Q()
                kotlin.jvm.internal.m.b(r14)
                goto L_0x0033
            L_0x003f:
                g2.G r5 = new g2.G
                g2.h r14 = r13.f9507b
                long r6 = r14.e()
                g2.h r14 = r13.f9507b
                java.lang.String r9 = r14.E()
                r10 = 1
                long r11 = java.lang.System.currentTimeMillis()
                r5.<init>(r6, r8, r9, r10, r11)
                u2.L r14 = new u2.L
                b2.r r1 = r13.f9508c
                android.content.Context r1 = r1.f9488a
                r14.<init>(r1)
                g2.h r1 = r13.f9507b
                long r6 = r1.e()
                g2.L r14 = r14.a(r6)
                boolean r1 = r14.b()
                r6 = 0
                if (r1 != 0) goto L_0x00d3
                org.json.JSONObject r1 = r14.e()
                if (r1 == 0) goto L_0x00d3
                org.json.JSONObject r14 = r14.e()
                kotlin.jvm.internal.m.b(r14)
                java.lang.String r1 = "success"
                int r14 = r14.optInt(r1)
                if (r14 != r4) goto L_0x00bf
                android.os.Bundle r14 = new android.os.Bundle
                r14.<init>()
                java.lang.String r1 = "type"
                java.lang.String r2 = "added"
                r14.putString(r1, r2)
                u2.x r1 = new u2.x
                b2.r r2 = r13.f9508c
                android.content.Context r2 = r2.f9488a
                r1.<init>(r2)
                java.lang.String r2 = "preregister"
                r1.d(r2, r14)
                b2.r r14 = r13.f9508c
                android.content.Context r14 = r14.f9488a
                r5.i(r14)
                o3.E0 r14 = o3.Y.c()
                b2.r$d$a r1 = new b2.r$d$a
                b2.r r2 = r13.f9508c
                r1.<init>(r2, r6)
                r13.f9506a = r4
                java.lang.Object r14 = o3.C0977g.g(r14, r1, r13)
                if (r14 != r0) goto L_0x00e7
                goto L_0x00e6
            L_0x00bf:
                o3.E0 r14 = o3.Y.c()
                b2.r$d$b r1 = new b2.r$d$b
                b2.r r2 = r13.f9508c
                r1.<init>(r2, r6)
                r13.f9506a = r3
                java.lang.Object r14 = o3.C0977g.g(r14, r1, r13)
                if (r14 != r0) goto L_0x00e7
                goto L_0x00e6
            L_0x00d3:
                o3.E0 r14 = o3.Y.c()
                b2.r$d$c r1 = new b2.r$d$c
                b2.r r3 = r13.f9508c
                r1.<init>(r3, r6)
                r13.f9506a = r2
                java.lang.Object r14 = o3.C0977g.g(r14, r1, r13)
                if (r14 != r0) goto L_0x00e7
            L_0x00e6:
                return r0
            L_0x00e7:
                R2.s r14 = R2.s.f8222a
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.r.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public r(Context context, J j4, z zVar) {
        m.e(context, "context");
        m.e(j4, "scope");
        m.e(zVar, "listener");
        this.f9488a = context;
        this.f9489b = j4;
        this.f9490c = zVar;
    }

    /* access modifiers changed from: private */
    public final Object f(C2039G g4, V2.d dVar) {
        Object g5 = C0977g.g(Y.b(), new b(this, g4, (V2.d) null), dVar);
        if (g5 == W2.b.c()) {
            return g5;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object h(C2050h hVar, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new d(hVar, this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public final void e(C2039G g4) {
        m.e(g4, "preRegister");
        C1001s0 unused = C0981i.d(this.f9489b, (g) null, (L) null, new a(this, g4, (V2.d) null), 3, (Object) null);
    }

    public final void g(C2050h hVar) {
        m.e(hVar, "appInfo");
        C1001s0 unused = C0981i.d(this.f9489b, (g) null, (L) null, new c(this, hVar, (V2.d) null), 3, (Object) null);
    }
}
