package b2;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import android.content.Context;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import f2.W;
import g2.K;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import org.json.JSONObject;

public final class p {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f9461a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f9462b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f9463c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final W f9464d;

    static final class a extends l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f9465a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f9466b;

        /* renamed from: b2.p$a$a  reason: collision with other inner class name */
        static final class C0155a extends l implements d3.p {

            /* renamed from: a  reason: collision with root package name */
            int f9467a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ p f9468b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0155a(p pVar, d dVar) {
                super(2, dVar);
                this.f9468b = pVar;
            }

            public final d create(Object obj, d dVar) {
                return new C0155a(this.f9468b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9467a == 0) {
                    n.b(obj);
                    this.f9468b.f9464d.b();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((C0155a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(p pVar, d dVar) {
            super(2, dVar);
            this.f9466b = pVar;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f9466b, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
            if (b2.p.f(r6, r5) == r0) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0071, code lost:
            if (b2.p.g(r6, r5) == r0) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0086, code lost:
            if (o3.C0977g.g(r6, r1, r5) == r0) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
            return r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r5.f9465a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 == r4) goto L_0x001a
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                goto L_0x001a
            L_0x0012:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x001a:
                R2.n.b(r6)
                goto L_0x0089
            L_0x001e:
                R2.n.b(r6)
                b2.p r6 = r5.f9466b
                java.lang.String r6 = r6.f9462b
                if (r6 == 0) goto L_0x0052
                b2.p r6 = r5.f9466b
                java.lang.String r6 = r6.f9462b
                kotlin.jvm.internal.m.b(r6)
                int r6 = r6.length()
                if (r6 <= 0) goto L_0x0052
                b2.p r6 = r5.f9466b
                java.lang.String r6 = r6.f9462b
                kotlin.jvm.internal.m.b(r6)
                int r6 = java.lang.Integer.parseInt(r6)
                if (r6 <= 0) goto L_0x0052
                b2.p r6 = r5.f9466b
                r5.f9465a = r4
                java.lang.Object r6 = r6.i(r5)
                if (r6 != r0) goto L_0x0089
                goto L_0x0088
            L_0x0052:
                b2.p r6 = r5.f9466b
                java.lang.String r6 = r6.f9463c
                if (r6 == 0) goto L_0x0074
                b2.p r6 = r5.f9466b
                java.lang.String r6 = r6.f9463c
                kotlin.jvm.internal.m.b(r6)
                int r6 = r6.length()
                if (r6 <= 0) goto L_0x0074
                b2.p r6 = r5.f9466b
                r5.f9465a = r3
                java.lang.Object r6 = r6.j(r5)
                if (r6 != r0) goto L_0x0089
                goto L_0x0088
            L_0x0074:
                o3.E0 r6 = o3.Y.c()
                b2.p$a$a r1 = new b2.p$a$a
                b2.p r3 = r5.f9466b
                r4 = 0
                r1.<init>(r3, r4)
                r5.f9465a = r2
                java.lang.Object r6 = o3.C0977g.g(r6, r1, r5)
                if (r6 != r0) goto L_0x0089
            L_0x0088:
                return r0
            L_0x0089:
                R2.s r6 = R2.s.f8222a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.p.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f9469a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f9470b;

        static final class a extends l implements d3.p {

            /* renamed from: a  reason: collision with root package name */
            int f9471a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ p f9472b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ K f9473c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(p pVar, K k4, d dVar) {
                super(2, dVar);
                this.f9472b = pVar;
                this.f9473c = k4;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f9472b, this.f9473c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9471a == 0) {
                    n.b(obj);
                    this.f9472b.f9464d.a(this.f9473c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.p$b$b  reason: collision with other inner class name */
        static final class C0156b extends l implements d3.p {

            /* renamed from: a  reason: collision with root package name */
            int f9474a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ p f9475b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0156b(p pVar, d dVar) {
                super(2, dVar);
                this.f9475b = pVar;
            }

            public final d create(Object obj, d dVar) {
                return new C0156b(this.f9475b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9474a == 0) {
                    n.b(obj);
                    this.f9475b.f9464d.b();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((C0156b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(p pVar, d dVar) {
            super(2, dVar);
            this.f9470b = pVar;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f9470b, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0063, code lost:
            if (o3.C0977g.g(r1, r2, r6) == r0) goto L_0x0079;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0077, code lost:
            if (o3.C0977g.g(r7, r1, r6) == r0) goto L_0x0079;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r6.f9469a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001b
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
                goto L_0x007a
            L_0x001b:
                R2.n.b(r7)
                u2.L r7 = new u2.L
                b2.p r1 = r6.f9470b
                android.content.Context r1 = r1.f9461a
                r7.<init>(r1)
                b2.p r1 = r6.f9470b
                java.lang.String r1 = r1.f9462b
                kotlin.jvm.internal.m.b(r1)
                g2.L r7 = r7.A0(r1)
                boolean r1 = r7.b()
                r4 = 0
                if (r1 != 0) goto L_0x0066
                org.json.JSONObject r1 = r7.e()
                if (r1 == 0) goto L_0x0066
                b2.p r1 = r6.f9470b
                org.json.JSONObject r7 = r7.e()
                kotlin.jvm.internal.m.b(r7)
                g2.K r7 = r1.h(r7)
                if (r7 == 0) goto L_0x007a
                o3.E0 r1 = o3.Y.c()
                b2.p$b$a r2 = new b2.p$b$a
                b2.p r5 = r6.f9470b
                r2.<init>(r5, r7, r4)
                r6.f9469a = r3
                java.lang.Object r7 = o3.C0977g.g(r1, r2, r6)
                if (r7 != r0) goto L_0x007a
                goto L_0x0079
            L_0x0066:
                o3.E0 r7 = o3.Y.c()
                b2.p$b$b r1 = new b2.p$b$b
                b2.p r3 = r6.f9470b
                r1.<init>(r3, r4)
                r6.f9469a = r2
                java.lang.Object r7 = o3.C0977g.g(r7, r1, r6)
                if (r7 != r0) goto L_0x007a
            L_0x0079:
                return r0
            L_0x007a:
                R2.s r7 = R2.s.f8222a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.p.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f9476a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f9477b;

        static final class a extends l implements d3.p {

            /* renamed from: a  reason: collision with root package name */
            int f9478a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ p f9479b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ K f9480c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(p pVar, K k4, d dVar) {
                super(2, dVar);
                this.f9479b = pVar;
                this.f9480c = k4;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f9479b, this.f9480c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9478a == 0) {
                    n.b(obj);
                    this.f9479b.f9464d.a(this.f9480c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class b extends l implements d3.p {

            /* renamed from: a  reason: collision with root package name */
            int f9481a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ p f9482b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(p pVar, d dVar) {
                super(2, dVar);
                this.f9482b = pVar;
            }

            public final d create(Object obj, d dVar) {
                return new b(this.f9482b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9481a == 0) {
                    n.b(obj);
                    this.f9482b.f9464d.b();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(p pVar, d dVar) {
            super(2, dVar);
            this.f9477b = pVar;
        }

        public final d create(Object obj, d dVar) {
            return new c(this.f9477b, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0063, code lost:
            if (o3.C0977g.g(r1, r2, r6) == r0) goto L_0x0079;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0077, code lost:
            if (o3.C0977g.g(r7, r1, r6) == r0) goto L_0x0079;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r6.f9476a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001b
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
                goto L_0x007a
            L_0x001b:
                R2.n.b(r7)
                u2.L r7 = new u2.L
                b2.p r1 = r6.f9477b
                android.content.Context r1 = r1.f9461a
                r7.<init>(r1)
                b2.p r1 = r6.f9477b
                java.lang.String r1 = r1.f9463c
                kotlin.jvm.internal.m.b(r1)
                g2.L r7 = r7.B0(r1)
                boolean r1 = r7.b()
                r4 = 0
                if (r1 != 0) goto L_0x0066
                org.json.JSONObject r1 = r7.e()
                if (r1 == 0) goto L_0x0066
                b2.p r1 = r6.f9477b
                org.json.JSONObject r7 = r7.e()
                kotlin.jvm.internal.m.b(r7)
                g2.K r7 = r1.h(r7)
                if (r7 == 0) goto L_0x007a
                o3.E0 r1 = o3.Y.c()
                b2.p$c$a r2 = new b2.p$c$a
                b2.p r5 = r6.f9477b
                r2.<init>(r5, r7, r4)
                r6.f9476a = r3
                java.lang.Object r7 = o3.C0977g.g(r1, r2, r6)
                if (r7 != r0) goto L_0x007a
                goto L_0x0079
            L_0x0066:
                o3.E0 r7 = o3.Y.c()
                b2.p$c$b r1 = new b2.p$c$b
                b2.p r3 = r6.f9477b
                r1.<init>(r3, r4)
                r6.f9476a = r2
                java.lang.Object r7 = o3.C0977g.g(r7, r1, r6)
                if (r7 != r0) goto L_0x007a
            L_0x0079:
                return r0
            L_0x007a:
                R2.s r7 = R2.s.f8222a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.p.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public p(Context context, String str, String str2, W w4, J j4) {
        m.e(context, "context");
        m.e(w4, "listener");
        m.e(j4, "scope");
        this.f9461a = context;
        this.f9462b = str;
        this.f9463c = str2;
        this.f9464d = w4;
        C1001s0 unused = C0981i.d(j4, (g) null, (L) null, new a(this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final K h(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
        if (jSONObject.optInt("success") != 1 || optJSONObject == null) {
            return null;
        }
        K k4 = new K();
        k4.a(optJSONObject);
        return k4;
    }

    /* access modifiers changed from: private */
    public final Object i(d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object j(d dVar) {
        Object g4 = C0977g.g(Y.b(), new c(this, (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }
}
