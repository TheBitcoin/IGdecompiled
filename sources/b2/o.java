package b2;

import R2.n;
import R2.s;
import V2.d;
import android.content.Context;
import d3.p;
import f2.K;
import g2.U;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;

public final class o {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f9450a;

    /* renamed from: b  reason: collision with root package name */
    private final J f9451b;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9452a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f9453b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f9454c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ K f9455d;

        /* renamed from: b2.o$a$a  reason: collision with other inner class name */
        static final class C0154a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9456a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ K f9457b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ U f9458c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0154a(K k4, U u4, d dVar) {
                super(2, dVar);
                this.f9457b = k4;
                this.f9458c = u4;
            }

            public final d create(Object obj, d dVar) {
                return new C0154a(this.f9457b, this.f9458c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9456a == 0) {
                    n.b(obj);
                    this.f9457b.a(this.f9458c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((C0154a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9459a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ K f9460b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(K k4, d dVar) {
                super(2, dVar);
                this.f9460b = k4;
            }

            public final d create(Object obj, d dVar) {
                return new b(this.f9460b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9459a == 0) {
                    n.b(obj);
                    this.f9460b.b();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(o oVar, String str, K k4, d dVar) {
            super(2, dVar);
            this.f9453b = oVar;
            this.f9454c = str;
            this.f9455d = k4;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f9453b, this.f9454c, this.f9455d, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x006b, code lost:
            if (o3.C0977g.g(r1, r2, r6) == r0) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x007f, code lost:
            if (o3.C0977g.g(r7, r1, r6) == r0) goto L_0x0081;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r6.f9452a
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
                goto L_0x0082
            L_0x001b:
                R2.n.b(r7)
                g2.U r7 = new g2.U
                r7.<init>()
                u2.L r1 = new u2.L
                b2.o r4 = r6.f9453b
                android.content.Context r4 = r4.f9450a
                r1.<init>(r4)
                java.lang.String r4 = r6.f9454c
                g2.L r1 = r1.v0(r4)
                boolean r4 = r1.b()
                r5 = 0
                if (r4 != 0) goto L_0x006e
                org.json.JSONObject r4 = r1.e()
                if (r4 == 0) goto L_0x006e
                org.json.JSONObject r1 = r1.e()
                kotlin.jvm.internal.m.b(r1)
                java.lang.String r2 = "data"
                boolean r4 = r1.isNull(r2)
                if (r4 != 0) goto L_0x0082
                org.json.JSONObject r1 = r1.getJSONObject(r2)
                kotlin.jvm.internal.m.b(r1)
                r7.k(r1)
                o3.E0 r1 = o3.Y.c()
                b2.o$a$a r2 = new b2.o$a$a
                f2.K r4 = r6.f9455d
                r2.<init>(r4, r7, r5)
                r6.f9452a = r3
                java.lang.Object r7 = o3.C0977g.g(r1, r2, r6)
                if (r7 != r0) goto L_0x0082
                goto L_0x0081
            L_0x006e:
                o3.E0 r7 = o3.Y.c()
                b2.o$a$b r1 = new b2.o$a$b
                f2.K r3 = r6.f9455d
                r1.<init>(r3, r5)
                r6.f9452a = r2
                java.lang.Object r7 = o3.C0977g.g(r7, r1, r6)
                if (r7 != r0) goto L_0x0082
            L_0x0081:
                return r0
            L_0x0082:
                R2.s r7 = R2.s.f8222a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.o.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public o(Context context, J j4) {
        m.e(context, "context");
        m.e(j4, "scope");
        this.f9450a = context;
        this.f9451b = j4;
    }

    public final void b(String str, K k4) {
        m.e(str, "userID");
        m.e(k4, "listener");
        C1001s0 unused = C0981i.d(this.f9451b, Y.b(), (L) null, new a(this, str, k4, (d) null), 2, (Object) null);
    }
}
