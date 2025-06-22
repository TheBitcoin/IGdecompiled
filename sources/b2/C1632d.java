package b2;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import android.content.Context;
import d3.p;
import f2.C2022m;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.B;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.z;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;

/* renamed from: b2.d  reason: case insensitive filesystem */
public final class C1632d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f9123a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f9124b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C2022m f9125c;

    /* renamed from: d  reason: collision with root package name */
    private final J f9126d;

    /* renamed from: b2.d$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9127a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1632d f9128b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C1632d dVar, d dVar2) {
            super(2, dVar2);
            this.f9128b = dVar;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f9128b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9127a;
            if (i4 == 0) {
                n.b(obj);
                C1632d dVar = this.f9128b;
                this.f9127a = 1;
                if (dVar.e(this) == c5) {
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

    /* renamed from: b2.d$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9129a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1632d f9130b;

        /* renamed from: b2.d$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9131a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1632d f9132b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ B f9133c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ B f9134d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ C f9135e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ B f9136f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ z f9137g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1632d dVar, B b5, B b6, C c5, B b7, z zVar, d dVar2) {
                super(2, dVar2);
                this.f9132b = dVar;
                this.f9133c = b5;
                this.f9134d = b6;
                this.f9135e = c5;
                this.f9136f = b7;
                this.f9137g = zVar;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f9132b, this.f9133c, this.f9134d, this.f9135e, this.f9136f, this.f9137g, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9131a == 0) {
                    n.b(obj);
                    this.f9132b.f9125c.a(this.f9133c.f20967a, this.f9134d.f20967a, (String) this.f9135e.f20968a, this.f9136f.f20967a, this.f9137g.f20985a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.d$b$b  reason: collision with other inner class name */
        static final class C0140b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9138a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1632d f9139b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0140b(C1632d dVar, d dVar2) {
                super(2, dVar2);
                this.f9139b = dVar;
            }

            public final d create(Object obj, d dVar) {
                return new C0140b(this.f9139b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9138a == 0) {
                    n.b(obj);
                    this.f9139b.f9125c.b();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((C0140b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1632d dVar, d dVar2) {
            super(2, dVar2);
            this.f9130b = dVar;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f9130b, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d5, code lost:
            if (o3.C0977g.g(r13, r4, r12) == r0) goto L_0x00ec;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ea, code lost:
            if (o3.C0977g.g(r13, r1, r12) == r0) goto L_0x00ec;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r12.f9129a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x0017:
                R2.n.b(r13)
                goto L_0x00ed
            L_0x001c:
                R2.n.b(r13)
                u2.L r13 = new u2.L
                b2.d r1 = r12.f9130b
                android.content.Context r1 = r1.f9123a
                r13.<init>(r1)
                b2.d r1 = r12.f9130b
                java.lang.String r1 = r1.f9124b
                g2.L r13 = r13.n(r1)
                boolean r1 = r13.b()
                if (r1 != 0) goto L_0x00d8
                java.lang.String r1 = r13.d()
                if (r1 == 0) goto L_0x00d8
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0048
                goto L_0x00d8
            L_0x0048:
                org.json.JSONObject r1 = new org.json.JSONObject
                java.lang.String r13 = r13.d()
                kotlin.jvm.internal.m.b(r13)
                r1.<init>(r13)
                java.lang.String r13 = "data"
                org.json.JSONObject r13 = r1.optJSONObject(r13)
                if (r13 == 0) goto L_0x00ed
                kotlin.jvm.internal.B r6 = new kotlin.jvm.internal.B
                r6.<init>()
                r4 = -1
                r6.f20967a = r4
                kotlin.jvm.internal.B r7 = new kotlin.jvm.internal.B
                r7.<init>()
                r7.f20967a = r4
                kotlin.jvm.internal.C r8 = new kotlin.jvm.internal.C
                r8.<init>()
                kotlin.jvm.internal.B r9 = new kotlin.jvm.internal.B
                r9.<init>()
                r9.f20967a = r4
                kotlin.jvm.internal.z r10 = new kotlin.jvm.internal.z
                r10.<init>()
                java.lang.String r2 = "appID"
                boolean r4 = r13.isNull(r2)
                if (r4 != 0) goto L_0x008b
                long r4 = r13.optLong(r2)
                r6.f20967a = r4
            L_0x008b:
                java.lang.String r2 = "fileID"
                boolean r4 = r13.isNull(r2)
                if (r4 != 0) goto L_0x0099
                long r4 = r13.optLong(r2)
                r7.f20967a = r4
            L_0x0099:
                java.lang.String r2 = "sha256"
                boolean r4 = r13.isNull(r2)
                if (r4 != 0) goto L_0x00a7
                java.lang.String r2 = r13.optString(r2)
                r8.f20968a = r2
            L_0x00a7:
                java.lang.String r2 = "versionCode"
                boolean r4 = r13.isNull(r2)
                if (r4 != 0) goto L_0x00b5
                long r4 = r13.optLong(r2)
                r9.f20967a = r4
            L_0x00b5:
                java.lang.String r2 = "deepLink"
                boolean r13 = r13.isNull(r2)
                if (r13 != 0) goto L_0x00c3
                boolean r13 = r1.optBoolean(r2)
                r10.f20985a = r13
            L_0x00c3:
                o3.E0 r13 = o3.Y.c()
                b2.d$b$a r4 = new b2.d$b$a
                b2.d r5 = r12.f9130b
                r11 = 0
                r4.<init>(r5, r6, r7, r8, r9, r10, r11)
                r12.f9129a = r3
                java.lang.Object r13 = o3.C0977g.g(r13, r4, r12)
                if (r13 != r0) goto L_0x00ed
                goto L_0x00ec
            L_0x00d8:
                o3.E0 r13 = o3.Y.c()
                b2.d$b$b r1 = new b2.d$b$b
                b2.d r3 = r12.f9130b
                r4 = 0
                r1.<init>(r3, r4)
                r12.f9129a = r2
                java.lang.Object r13 = o3.C0977g.g(r13, r1, r12)
                if (r13 != r0) goto L_0x00ed
            L_0x00ec:
                return r0
            L_0x00ed:
                R2.s r13 = R2.s.f8222a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C1632d.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1632d(Context context, String str, C2022m mVar, J j4) {
        m.e(context, "context");
        m.e(str, "downloadURL");
        m.e(mVar, "listener");
        m.e(j4, "scope");
        this.f9123a = context;
        this.f9124b = str;
        this.f9125c = mVar;
        this.f9126d = j4;
        C1001s0 unused = C0981i.d(j4, (g) null, (L) null, new a(this, (d) null), 3, (Object) null);
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
