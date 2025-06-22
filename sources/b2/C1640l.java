package b2;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import android.content.Context;
import d3.p;
import f2.C2027s;
import g2.C2050h;
import g2.L;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.Y;

/* renamed from: b2.l  reason: case insensitive filesystem */
public final class C1640l {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f9420a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f9421b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final C2027s f9422c;

    /* renamed from: b2.l$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9423a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1640l f9424b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C1640l lVar, d dVar) {
            super(2, dVar);
            this.f9424b = lVar;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f9424b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9423a;
            if (i4 == 0) {
                n.b(obj);
                C1640l lVar = this.f9424b;
                this.f9423a = 1;
                if (lVar.e(this) == c5) {
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

    /* renamed from: b2.l$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9425a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1640l f9426b;

        /* renamed from: b2.l$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9427a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1640l f9428b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C2050h f9429c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1640l lVar, C2050h hVar, d dVar) {
                super(2, dVar);
                this.f9428b = lVar;
                this.f9429c = hVar;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f9428b, this.f9429c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9427a == 0) {
                    n.b(obj);
                    C2027s c5 = this.f9428b.f9422c;
                    if (c5 == null) {
                        return null;
                    }
                    c5.c(this.f9429c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.l$b$b  reason: collision with other inner class name */
        static final class C0153b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9430a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1640l f9431b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f9432c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0153b(C1640l lVar, L l4, d dVar) {
                super(2, dVar);
                this.f9431b = lVar;
                this.f9432c = l4;
            }

            public final d create(Object obj, d dVar) {
                return new C0153b(this.f9431b, this.f9432c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9430a == 0) {
                    n.b(obj);
                    C2027s c5 = this.f9431b.f9422c;
                    if (c5 == null) {
                        return null;
                    }
                    c5.b(this.f9432c.f());
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((C0153b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1640l lVar, d dVar) {
            super(2, dVar);
            this.f9426b = lVar;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f9426b, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0081, code lost:
            if (o3.C0977g.g(r1, r2, r6) == r0) goto L_0x009d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x009b, code lost:
            if (o3.C0977g.g(r1, r3, r6) == r0) goto L_0x009d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r6.f9425a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x0017:
                R2.n.b(r7)
                goto L_0x009e
            L_0x001c:
                R2.n.b(r7)
                u2.L r7 = new u2.L
                b2.l r1 = r6.f9426b
                android.content.Context r1 = r1.f9420a
                r7.<init>(r1)
                b2.l r1 = r6.f9426b
                long r4 = r1.f9421b
                g2.L r7 = r7.T(r4)
                boolean r1 = r7.b()
                r4 = 0
                if (r1 != 0) goto L_0x0084
                java.lang.String r1 = r7.d()
                if (r1 == 0) goto L_0x0084
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0048
                goto L_0x0084
            L_0x0048:
                org.json.JSONObject r1 = new org.json.JSONObject
                java.lang.String r7 = r7.d()
                kotlin.jvm.internal.m.b(r7)
                r1.<init>(r7)
                java.lang.String r7 = "data"
                org.json.JSONObject r7 = r1.optJSONObject(r7)
                java.lang.String r2 = "success"
                int r1 = r1.optInt(r2)
                if (r1 != r3) goto L_0x009e
                if (r7 == 0) goto L_0x009e
                g2.h$b r1 = g2.C2050h.f20600F0
                b2.l r2 = r6.f9426b
                android.content.Context r2 = r2.f9420a
                g2.h r7 = r1.a(r7, r2)
                o3.E0 r1 = o3.Y.c()
                b2.l$b$a r2 = new b2.l$b$a
                b2.l r5 = r6.f9426b
                r2.<init>(r5, r7, r4)
                r6.f9425a = r3
                java.lang.Object r7 = o3.C0977g.g(r1, r2, r6)
                if (r7 != r0) goto L_0x009e
                goto L_0x009d
            L_0x0084:
                boolean r1 = r7.b()
                if (r1 == 0) goto L_0x009e
                o3.E0 r1 = o3.Y.c()
                b2.l$b$b r3 = new b2.l$b$b
                b2.l r5 = r6.f9426b
                r3.<init>(r5, r7, r4)
                r6.f9425a = r2
                java.lang.Object r7 = o3.C0977g.g(r1, r3, r6)
                if (r7 != r0) goto L_0x009e
            L_0x009d:
                return r0
            L_0x009e:
                R2.s r7 = R2.s.f8222a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C1640l.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1640l(Context context, long j4, C2027s sVar, J j5) {
        m.e(context, "context");
        m.e(j5, "scope");
        this.f9420a = context;
        this.f9421b = j4;
        this.f9422c = sVar;
        if (j4 > 0) {
            C1001s0 unused = C0981i.d(j5, (g) null, (o3.L) null, new a(this, (d) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final Object e(d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }
}
