package b2;

import R2.n;
import R2.s;
import S2.C1601o;
import android.content.Context;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import d3.p;
import f2.C2024o;
import g2.C2050h;
import g2.C2053k;
import g2.M;
import g2.Q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.Y;
import org.json.JSONObject;
import u2.L;
import u2.t;

/* renamed from: b2.f  reason: case insensitive filesystem */
public final class C1634f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f9167a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2024o f9168b;

    /* renamed from: c  reason: collision with root package name */
    private final J f9169c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f9170d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f9171e;

    /* renamed from: b2.f$a */
    static final class a extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9172a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1634f f9173b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C1634f fVar, V2.d dVar) {
            super(2, dVar);
            this.f9173b = fVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f9173b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9172a;
            if (i4 == 0) {
                n.b(obj);
                C1634f fVar = this.f9173b;
                this.f9172a = 1;
                if (fVar.t(this) == c5) {
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

    /* renamed from: b2.f$b */
    static final class b extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9174a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1634f f9175b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f9176c;

        /* renamed from: b2.f$b$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9177a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1634f f9178b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C f9179c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ L f9180d;

            /* renamed from: b2.f$b$a$a  reason: collision with other inner class name */
            static final class C0143a extends kotlin.coroutines.jvm.internal.l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f9181a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ C1634f f9182b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ L f9183c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ C f9184d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0143a(C1634f fVar, L l4, C c5, V2.d dVar) {
                    super(2, dVar);
                    this.f9182b = fVar;
                    this.f9183c = l4;
                    this.f9184d = c5;
                }

                public final V2.d create(Object obj, V2.d dVar) {
                    return new C0143a(this.f9182b, this.f9183c, this.f9184d, dVar);
                }

                public final Object invokeSuspend(Object obj) {
                    Object c5 = W2.b.c();
                    int i4 = this.f9181a;
                    if (i4 == 0) {
                        n.b(obj);
                        this.f9181a = 1;
                        if (this.f9182b.D(this.f9183c, (ArrayList) this.f9184d.f20968a, this) == c5) {
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
                    return ((C0143a) create(j4, dVar)).invokeSuspend(s.f8222a);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1634f fVar, C c5, L l4, V2.d dVar) {
                super(2, dVar);
                this.f9178b = fVar;
                this.f9179c = c5;
                this.f9180d = l4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9178b, this.f9179c, this.f9180d, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9177a == 0) {
                    n.b(obj);
                    this.f9178b.f9168b.l((ArrayList) this.f9179c.f20968a);
                    return C0981i.d(this.f9178b.A(), (V2.g) null, (o3.L) null, new C0143a(this.f9178b, this.f9180d, this.f9179c, (V2.d) null), 3, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1634f fVar, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9175b = fVar;
            this.f9176c = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f9175b, this.f9176c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9174a;
            if (i4 == 0) {
                n.b(obj);
                C c6 = new C();
                c6.f20968a = new ArrayList();
                t a5 = t.f21927u.a(this.f9175b.f9167a);
                a5.a();
                M C02 = a5.C0("categories");
                if (C02 == null || !C02.a()) {
                    g2.L q4 = this.f9176c.q();
                    if (!q4.b() && q4.d() != null) {
                        C2053k.b bVar = C2053k.f20690g;
                        String d5 = q4.d();
                        m.b(d5);
                        c6.f20968a = C2053k.b.b(bVar, d5, 0, 2, (Object) null);
                        String d6 = q4.d();
                        m.b(d6);
                        M m4 = new M("categories", d6);
                        a5.Q("categories");
                        a5.W0(m4);
                    }
                } else {
                    c6.f20968a = C2053k.b.b(C2053k.f20690g, C02.b(), 0, 2, (Object) null);
                }
                a5.i();
                if (!((Collection) c6.f20968a).isEmpty()) {
                    this.f9175b.f9171e = this.f9175b.f9171e + 1;
                    E0 c7 = Y.c();
                    a aVar = new a(this.f9175b, c6, this.f9176c, (V2.d) null);
                    this.f9174a = 1;
                    if (C0977g.g(c7, aVar, this) == c5) {
                        return c5;
                    }
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.f$c */
    static final class c extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f9185a;

        /* renamed from: b  reason: collision with root package name */
        int f9186b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1634f f9187c;

        /* renamed from: b2.f$c$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9188a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1634f f9189b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f9190c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1634f fVar, L l4, V2.d dVar) {
                super(2, dVar);
                this.f9189b = fVar;
                this.f9190c = l4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9189b, this.f9190c, dVar);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
                if (b2.C1634f.e(r7, r1, r6) == r0) goto L_0x0062;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
                if (b2.C1634f.a(r7, r1, r6) == r0) goto L_0x0062;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
                if (b2.C1634f.d(r7, r1, r6) == r0) goto L_0x0062;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
                if (b2.C1634f.k(r7, r1, r6) == r0) goto L_0x0062;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
                return r0;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = W2.b.c()
                    int r1 = r6.f9188a
                    r2 = 4
                    r3 = 3
                    r4 = 2
                    r5 = 1
                    if (r1 == 0) goto L_0x002c
                    if (r1 == r5) goto L_0x0028
                    if (r1 == r4) goto L_0x0024
                    if (r1 == r3) goto L_0x0020
                    if (r1 != r2) goto L_0x0018
                    R2.n.b(r7)
                    goto L_0x0063
                L_0x0018:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L_0x0020:
                    R2.n.b(r7)
                    goto L_0x0056
                L_0x0024:
                    R2.n.b(r7)
                    goto L_0x0049
                L_0x0028:
                    R2.n.b(r7)
                    goto L_0x003c
                L_0x002c:
                    R2.n.b(r7)
                    b2.f r7 = r6.f9189b
                    u2.L r1 = r6.f9190c
                    r6.f9188a = r5
                    java.lang.Object r7 = r7.v(r1, r6)
                    if (r7 != r0) goto L_0x003c
                    goto L_0x0062
                L_0x003c:
                    b2.f r7 = r6.f9189b
                    u2.L r1 = r6.f9190c
                    r6.f9188a = r4
                    java.lang.Object r7 = r7.s(r1, r6)
                    if (r7 != r0) goto L_0x0049
                    goto L_0x0062
                L_0x0049:
                    b2.f r7 = r6.f9189b
                    u2.L r1 = r6.f9190c
                    r6.f9188a = r3
                    java.lang.Object r7 = r7.u(r1, r6)
                    if (r7 != r0) goto L_0x0056
                    goto L_0x0062
                L_0x0056:
                    b2.f r7 = r6.f9189b
                    u2.L r1 = r6.f9190c
                    r6.f9188a = r2
                    java.lang.Object r7 = r7.y(r1, r6)
                    if (r7 != r0) goto L_0x0063
                L_0x0062:
                    return r0
                L_0x0063:
                    R2.s r7 = R2.s.f8222a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: b2.C1634f.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.f$c$b */
        static final class b extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9191a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1634f f9192b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C1634f fVar, V2.d dVar) {
                super(2, dVar);
                this.f9192b = fVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f9192b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9191a == 0) {
                    n.b(obj);
                    this.f9192b.f9168b.h();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.f$c$c  reason: collision with other inner class name */
        static final class C0144c extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9193a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1634f f9194b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f9195c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0144c(C1634f fVar, L l4, V2.d dVar) {
                super(2, dVar);
                this.f9194b = fVar;
                this.f9195c = l4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0144c(this.f9194b, this.f9195c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object c5 = W2.b.c();
                int i4 = this.f9193a;
                if (i4 == 0) {
                    n.b(obj);
                    C1634f fVar = this.f9194b;
                    L l4 = this.f9195c;
                    this.f9193a = 1;
                    if (fVar.w(l4, this) == c5) {
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
                return ((C0144c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.f$c$d */
        static final class d extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9196a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1634f f9197b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f9198c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(C1634f fVar, L l4, V2.d dVar) {
                super(2, dVar);
                this.f9197b = fVar;
                this.f9198c = l4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new d(this.f9197b, this.f9198c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object c5 = W2.b.c();
                int i4 = this.f9196a;
                if (i4 == 0) {
                    n.b(obj);
                    C1634f fVar = this.f9197b;
                    L l4 = this.f9198c;
                    this.f9196a = 1;
                    if (fVar.z(l4, this) == c5) {
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
                return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.f$c$e */
        static final class e extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9199a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1634f f9200b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f9201c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(C1634f fVar, L l4, V2.d dVar) {
                super(2, dVar);
                this.f9200b = fVar;
                this.f9201c = l4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new e(this.f9200b, this.f9201c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object c5 = W2.b.c();
                int i4 = this.f9199a;
                if (i4 == 0) {
                    n.b(obj);
                    C1634f fVar = this.f9200b;
                    L l4 = this.f9201c;
                    this.f9199a = 1;
                    if (fVar.C(l4, this) == c5) {
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
                return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.f$c$f  reason: collision with other inner class name */
        static final class C0145f extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9202a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1634f f9203b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f9204c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0145f(C1634f fVar, L l4, V2.d dVar) {
                super(2, dVar);
                this.f9203b = fVar;
                this.f9204c = l4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0145f(this.f9203b, this.f9204c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object c5 = W2.b.c();
                int i4 = this.f9202a;
                if (i4 == 0) {
                    n.b(obj);
                    C1634f fVar = this.f9203b;
                    L l4 = this.f9204c;
                    this.f9202a = 1;
                    if (fVar.x(l4, this) == c5) {
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
                return ((C0145f) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C1634f fVar, V2.d dVar) {
            super(2, dVar);
            this.f9187c = fVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f9187c, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0059, code lost:
            if (r1.g(r11) == r0) goto L_0x0071;
         */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x007b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r11.f9186b
                r2 = 1
                r3 = 2
                r4 = 0
                if (r1 == 0) goto L_0x0028
                if (r1 == r2) goto L_0x001f
                if (r1 != r3) goto L_0x0017
                java.lang.Object r0 = r11.f9185a
                u2.L r0 = (u2.L) r0
                R2.n.b(r12)
                goto L_0x0073
            L_0x0017:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x001f:
                java.lang.Object r1 = r11.f9185a
                u2.L r1 = (u2.L) r1
                R2.n.b(r12)
                r12 = r1
                goto L_0x005c
            L_0x0028:
                R2.n.b(r12)
                b2.f r12 = r11.f9187c
                r1 = 0
                r12.f9171e = r1
                u2.L r12 = new u2.L
                b2.f r1 = r11.f9187c
                android.content.Context r1 = r1.f9167a
                r12.<init>(r1)
                b2.f r1 = r11.f9187c
                o3.J r5 = r1.A()
                b2.f$c$a r8 = new b2.f$c$a
                b2.f r1 = r11.f9187c
                r8.<init>(r1, r12, r4)
                r9 = 3
                r10 = 0
                r6 = 0
                r7 = 0
                o3.s0 r1 = o3.C0981i.d(r5, r6, r7, r8, r9, r10)
                r11.f9185a = r12
                r11.f9186b = r2
                java.lang.Object r1 = r1.g(r11)
                if (r1 != r0) goto L_0x005c
                goto L_0x0071
            L_0x005c:
                o3.E0 r1 = o3.Y.c()
                b2.f$c$b r2 = new b2.f$c$b
                b2.f r5 = r11.f9187c
                r2.<init>(r5, r4)
                r11.f9185a = r12
                r11.f9186b = r3
                java.lang.Object r1 = o3.C0977g.g(r1, r2, r11)
                if (r1 != r0) goto L_0x0072
            L_0x0071:
                return r0
            L_0x0072:
                r0 = r12
            L_0x0073:
                b2.f r12 = r11.f9187c
                int r12 = r12.f9171e
                if (r12 < r3) goto L_0x00bf
                b2.f r12 = r11.f9187c
                o3.J r5 = r12.A()
                b2.f$c$c r8 = new b2.f$c$c
                b2.f r12 = r11.f9187c
                r8.<init>(r12, r0, r4)
                r9 = 3
                r10 = 0
                r6 = 0
                r7 = 0
                o3.C1001s0 unused = o3.C0981i.d(r5, r6, r7, r8, r9, r10)
                b2.f r12 = r11.f9187c
                o3.J r5 = r12.A()
                b2.f$c$d r8 = new b2.f$c$d
                b2.f r12 = r11.f9187c
                r8.<init>(r12, r0, r4)
                o3.C1001s0 unused = o3.C0981i.d(r5, r6, r7, r8, r9, r10)
                b2.f r12 = r11.f9187c
                o3.J r5 = r12.A()
                b2.f$c$e r8 = new b2.f$c$e
                b2.f r12 = r11.f9187c
                r8.<init>(r12, r0, r4)
                o3.C1001s0 unused = o3.C0981i.d(r5, r6, r7, r8, r9, r10)
                b2.f r12 = r11.f9187c
                o3.J r5 = r12.A()
                b2.f$c$f r8 = new b2.f$c$f
                b2.f r12 = r11.f9187c
                r8.<init>(r12, r0, r4)
                o3.C1001s0 unused = o3.C0981i.d(r5, r6, r7, r8, r9, r10)
            L_0x00bf:
                R2.s r12 = R2.s.f8222a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C1634f.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.f$d */
    static final class d extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f9205a;

        /* renamed from: b  reason: collision with root package name */
        int f9206b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1634f f9207c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ L f9208d;

        /* renamed from: b2.f$d$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9209a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1634f f9210b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Q f9211c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ L f9212d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ C f9213e;

            /* renamed from: b2.f$d$a$a  reason: collision with other inner class name */
            static final class C0146a extends kotlin.coroutines.jvm.internal.l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f9214a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ C1634f f9215b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ L f9216c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ C f9217d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0146a(C1634f fVar, L l4, C c5, V2.d dVar) {
                    super(2, dVar);
                    this.f9215b = fVar;
                    this.f9216c = l4;
                    this.f9217d = c5;
                }

                public final V2.d create(Object obj, V2.d dVar) {
                    return new C0146a(this.f9215b, this.f9216c, this.f9217d, dVar);
                }

                public final Object invokeSuspend(Object obj) {
                    Object c5 = W2.b.c();
                    int i4 = this.f9214a;
                    if (i4 == 0) {
                        n.b(obj);
                        this.f9214a = 1;
                        if (this.f9215b.E(this.f9216c, (ArrayList) this.f9217d.f20968a, this) == c5) {
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
                    return ((C0146a) create(j4, dVar)).invokeSuspend(s.f8222a);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1634f fVar, Q q4, L l4, C c5, V2.d dVar) {
                super(2, dVar);
                this.f9210b = fVar;
                this.f9211c = q4;
                this.f9212d = l4;
                this.f9213e = c5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9210b, this.f9211c, this.f9212d, this.f9213e, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9209a == 0) {
                    n.b(obj);
                    this.f9210b.f9168b.f(this.f9211c);
                    return C0981i.d(this.f9210b.A(), (V2.g) null, (o3.L) null, new C0146a(this.f9210b, this.f9212d, this.f9213e, (V2.d) null), 3, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C1634f fVar, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9207c = fVar;
            this.f9208d = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f9207c, this.f9208d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            t tVar;
            t tVar2;
            Object c5 = W2.b.c();
            int i4 = this.f9206b;
            if (i4 == 0) {
                n.b(obj);
                C c6 = new C();
                c6.f20968a = new ArrayList();
                tVar = t.f21927u.a(this.f9207c.f9167a);
                tVar.a();
                M C02 = tVar.C0("floating_categories");
                if (C02 == null || !C02.a()) {
                    g2.L x4 = this.f9208d.x();
                    if (!x4.b() && x4.e() != null) {
                        C2053k.b bVar = C2053k.f20690g;
                        JSONObject e5 = x4.e();
                        m.b(e5);
                        c6.f20968a = bVar.e(e5);
                        String d5 = x4.d();
                        m.b(d5);
                        M m4 = new M("floating_categories", d5);
                        tVar.Q("floating_categories");
                        tVar.W0(m4);
                    }
                } else {
                    c6.f20968a = C2053k.f20690g.d(C02.b());
                }
                if (!((Collection) c6.f20968a).isEmpty()) {
                    Q m5 = this.f9207c.B((C2053k) C1601o.H((List) c6.f20968a), this.f9208d, tVar);
                    E0 c7 = Y.c();
                    a aVar = new a(this.f9207c, m5, this.f9208d, c6, (V2.d) null);
                    this.f9205a = tVar;
                    this.f9206b = 1;
                    if (C0977g.g(c7, aVar, this) == c5) {
                        return c5;
                    }
                    tVar2 = tVar;
                }
                tVar.i();
                return s.f8222a;
            } else if (i4 == 1) {
                tVar2 = (t) this.f9205a;
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            tVar = tVar2;
            tVar.i();
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.f$e */
    static final class e extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9218a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1634f f9219b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f9220c;

        /* renamed from: b2.f$e$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9221a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1634f f9222b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C f9223c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1634f fVar, C c5, V2.d dVar) {
                super(2, dVar);
                this.f9222b = fVar;
                this.f9223c = c5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9222b, this.f9223c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9221a == 0) {
                    n.b(obj);
                    this.f9222b.f9168b.d((ArrayList) this.f9223c.f20968a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(C1634f fVar, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9219b = fVar;
            this.f9220c = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f9219b, this.f9220c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9218a;
            if (i4 == 0) {
                n.b(obj);
                C c6 = new C();
                c6.f20968a = new ArrayList();
                t a5 = t.f21927u.a(this.f9219b.f9167a);
                a5.a();
                M C02 = a5.C0("home_features");
                if (C02 == null || !C02.a()) {
                    g2.L A4 = this.f9220c.A();
                    if (!A4.b()) {
                        c6.f20968a = this.f9220c.Q0(A4);
                        String d5 = A4.d();
                        m.b(d5);
                        M m4 = new M("home_features", d5);
                        a5.Q("home_features");
                        a5.W0(m4);
                    }
                } else {
                    c6.f20968a = this.f9220c.Q0(C02.c());
                }
                a5.i();
                if (!((Collection) c6.f20968a).isEmpty()) {
                    this.f9219b.f9171e = this.f9219b.f9171e + 1;
                    this.f9219b.f9170d = -1;
                    int i5 = 0;
                    for (C2050h Q4 : (Iterable) c6.f20968a) {
                        int i6 = i5 + 1;
                        if (m3.m.p(Q4.Q(), this.f9219b.f9167a.getPackageName(), true)) {
                            this.f9219b.f9170d = i5;
                        }
                        i5 = i6;
                    }
                    if (this.f9219b.f9170d > -1 && this.f9219b.f9170d < ((ArrayList) c6.f20968a).size()) {
                        ((ArrayList) c6.f20968a).remove(this.f9219b.f9170d);
                    }
                }
                E0 c7 = Y.c();
                a aVar = new a(this.f9219b, c6, (V2.d) null);
                this.f9218a = 1;
                if (C0977g.g(c7, aVar, this) == c5) {
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
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.f$f  reason: collision with other inner class name */
    static final class C0147f extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9224a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1634f f9225b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f9226c;

        /* renamed from: b2.f$f$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9227a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1634f f9228b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Q f9229c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1634f fVar, Q q4, V2.d dVar) {
                super(2, dVar);
                this.f9228b = fVar;
                this.f9229c = q4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9228b, this.f9229c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9227a == 0) {
                    n.b(obj);
                    this.f9228b.f9168b.i(this.f9229c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0147f(C1634f fVar, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9225b = fVar;
            this.f9226c = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new C0147f(this.f9225b, this.f9226c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9224a;
            if (i4 == 0) {
                n.b(obj);
                ArrayList arrayList = new ArrayList();
                t a5 = t.f21927u.a(this.f9225b.f9167a);
                a5.a();
                M C02 = a5.C0("last_updates");
                if (C02 == null || !C02.a()) {
                    g2.L H4 = this.f9226c.H(20, 0);
                    if (!H4.b() && H4.e() != null) {
                        arrayList = this.f9226c.Q0(H4);
                        String d5 = H4.d();
                        m.b(d5);
                        M m4 = new M("last_updates", d5);
                        a5.Q("last_updates");
                        a5.W0(m4);
                    }
                } else {
                    arrayList = this.f9226c.Q0(C02.c());
                }
                ArrayList arrayList2 = arrayList;
                a5.i();
                String string = this.f9225b.f9167a.getString(R.string.latest_updates);
                m.d(string, "getString(...)");
                Q q4 = new Q(new C2053k(-3, string, (String) null, 4, (C2103g) null), arrayList2, 0, 4, (C2103g) null);
                q4.f(1);
                E0 c6 = Y.c();
                a aVar = new a(this.f9225b, q4, (V2.d) null);
                this.f9224a = 1;
                if (C0977g.g(c6, aVar, this) == c5) {
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
            return ((C0147f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.f$g */
    static final class g extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9230a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1634f f9231b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f9232c;

        /* renamed from: b2.f$g$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9233a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C f9234b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C1634f f9235c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C c5, C1634f fVar, V2.d dVar) {
                super(2, dVar);
                this.f9234b = c5;
                this.f9235c = fVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9234b, this.f9235c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9233a == 0) {
                    n.b(obj);
                    if (this.f9234b.f20968a != null) {
                        this.f9235c.f9168b.e((C2050h) this.f9234b.f20968a);
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(C1634f fVar, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9231b = fVar;
            this.f9232c = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f9231b, this.f9232c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9230a;
            if (i4 == 0) {
                n.b(obj);
                C c6 = new C();
                t a5 = t.f21927u.a(this.f9231b.f9167a);
                a5.a();
                M C02 = a5.C0("main_app");
                if (C02 == null || !C02.a()) {
                    g2.L L02 = this.f9232c.L0();
                    if (!L02.b() && L02.e() != null) {
                        JSONObject e5 = L02.e();
                        m.b(e5);
                        JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                        if (optJSONObject != null) {
                            C2050h hVar = new C2050h();
                            c6.f20968a = hVar;
                            C2050h.b(hVar, optJSONObject, (Context) null, 2, (Object) null);
                        }
                        String d5 = L02.d();
                        m.b(d5);
                        M m4 = new M("main_app", d5);
                        a5.Q("main_app");
                        a5.W0(m4);
                    }
                } else {
                    JSONObject optJSONObject2 = new JSONObject(C02.b()).optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject2 != null) {
                        C2050h hVar2 = new C2050h();
                        c6.f20968a = hVar2;
                        C2050h.b(hVar2, optJSONObject2, (Context) null, 2, (Object) null);
                    }
                }
                a5.i();
                E0 c7 = Y.c();
                a aVar = new a(c6, this.f9231b, (V2.d) null);
                this.f9230a = 1;
                if (C0977g.g(c7, aVar, this) == c5) {
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
            return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.f$h */
    static final class h extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9236a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1634f f9237b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f9238c;

        /* renamed from: b2.f$h$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9239a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1634f f9240b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Q f9241c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1634f fVar, Q q4, V2.d dVar) {
                super(2, dVar);
                this.f9240b = fVar;
                this.f9241c = q4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9240b, this.f9241c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9239a == 0) {
                    n.b(obj);
                    this.f9240b.f9168b.c(this.f9241c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(C1634f fVar, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9237b = fVar;
            this.f9238c = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new h(this.f9237b, this.f9238c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            Object c5 = W2.b.c();
            int i4 = this.f9236a;
            if (i4 == 0) {
                n.b(obj);
                t a5 = t.f21927u.a(this.f9237b.f9167a);
                a5.a();
                M C02 = a5.C0("new_releases");
                if (C02 == null || !C02.a()) {
                    g2.L L4 = this.f9238c.L(20, 0);
                    if (L4.b() || L4.e() == null) {
                        arrayList = null;
                    } else {
                        ArrayList Q02 = this.f9238c.Q0(L4);
                        String d5 = L4.d();
                        m.b(d5);
                        M m4 = new M("new_releases", d5);
                        a5.Q("new_releases");
                        a5.W0(m4);
                        arrayList = Q02;
                    }
                } else {
                    arrayList = this.f9238c.Q0(C02.c());
                }
                a5.i();
                if (arrayList != null && !arrayList.isEmpty()) {
                    String string = this.f9237b.f9167a.getString(R.string.new_releases);
                    m.d(string, "getString(...)");
                    Q q4 = new Q(new C2053k(-2, string, (String) null, 4, (C2103g) null), arrayList, 0, 4, (C2103g) null);
                    q4.f(1);
                    E0 c6 = Y.c();
                    a aVar = new a(this.f9237b, q4, (V2.d) null);
                    this.f9236a = 1;
                    if (C0977g.g(c6, aVar, this) == c5) {
                        return c5;
                    }
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((h) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.f$i */
    static final class i extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9242a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1634f f9243b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f9244c;

        /* renamed from: b2.f$i$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9245a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1634f f9246b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C f9247c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1634f fVar, C c5, V2.d dVar) {
                super(2, dVar);
                this.f9246b = fVar;
                this.f9247c = c5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9246b, this.f9247c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9245a == 0) {
                    n.b(obj);
                    this.f9246b.f9168b.j((ArrayList) this.f9247c.f20968a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(C1634f fVar, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9243b = fVar;
            this.f9244c = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new i(this.f9243b, this.f9244c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9242a;
            if (i4 == 0) {
                n.b(obj);
                C c6 = new C();
                t a5 = t.f21927u.a(this.f9243b.f9167a);
                a5.a();
                M C02 = a5.C0("recent_featured");
                if (C02 == null || !C02.a()) {
                    g2.L X4 = this.f9244c.X(1, 0);
                    if (!X4.b() && X4.e() != null) {
                        c6.f20968a = this.f9244c.Q0(X4);
                        String d5 = X4.d();
                        m.b(d5);
                        M m4 = new M("recent_featured", d5);
                        a5.Q("recent_featured");
                        a5.W0(m4);
                    }
                } else {
                    c6.f20968a = this.f9244c.Q0(C02.c());
                }
                a5.i();
                Collection collection = (Collection) c6.f20968a;
                if (collection != null && !collection.isEmpty()) {
                    E0 c7 = Y.c();
                    a aVar = new a(this.f9243b, c6, (V2.d) null);
                    this.f9242a = 1;
                    if (C0977g.g(c7, aVar, this) == c5) {
                        return c5;
                    }
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((i) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.f$j */
    static final class j extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f9248a;

        /* renamed from: b  reason: collision with root package name */
        Object f9249b;

        /* renamed from: c  reason: collision with root package name */
        int f9250c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C1634f f9251d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ L f9252e;

        /* renamed from: b2.f$j$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9253a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1634f f9254b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Q f9255c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1634f fVar, Q q4, V2.d dVar) {
                super(2, dVar);
                this.f9254b = fVar;
                this.f9255c = q4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9254b, this.f9255c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9253a == 0) {
                    n.b(obj);
                    this.f9254b.f9168b.a(this.f9255c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.f$j$b */
        static final class b extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9256a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1634f f9257b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C f9258c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C1634f fVar, C c5, V2.d dVar) {
                super(2, dVar);
                this.f9257b = fVar;
                this.f9258c = c5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f9257b, this.f9258c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9256a == 0) {
                    n.b(obj);
                    this.f9257b.f9168b.g((C2050h) this.f9258c.f20968a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(C1634f fVar, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9251d = fVar;
            this.f9252e = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new j(this.f9251d, this.f9252e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            t tVar;
            t tVar2;
            ArrayList arrayList;
            t tVar3;
            Object c5 = W2.b.c();
            int i4 = this.f9250c;
            if (i4 == 0) {
                n.b(obj);
                ArrayList arrayList2 = new ArrayList();
                tVar = t.f21927u.a(this.f9251d.f9167a);
                tVar.a();
                M C02 = tVar.C0("top_downloads");
                if (C02 == null || !C02.a()) {
                    g2.L h02 = this.f9252e.h0(20, 0);
                    if (!h02.b() && h02.e() != null) {
                        arrayList2 = this.f9252e.Q0(h02);
                        String d5 = h02.d();
                        m.b(d5);
                        M m4 = new M("top_downloads", d5);
                        tVar.Q("top_downloads");
                        tVar.W0(m4);
                    }
                } else {
                    arrayList2 = this.f9252e.Q0(C02.c());
                }
                ArrayList arrayList3 = arrayList2;
                if (!arrayList3.isEmpty()) {
                    String string = this.f9251d.f9167a.getString(R.string.top_downloads_title);
                    m.d(string, "getString(...)");
                    Q q4 = new Q(new C2053k(-1, string, (String) null, 4, (C2103g) null), arrayList3, 0, 4, (C2103g) null);
                    q4.f(8);
                    E0 c6 = Y.c();
                    a aVar = new a(this.f9251d, q4, (V2.d) null);
                    this.f9248a = arrayList3;
                    this.f9249b = tVar;
                    this.f9250c = 1;
                    if (C0977g.g(c6, aVar, this) != c5) {
                        tVar3 = tVar;
                        arrayList = arrayList3;
                    }
                    return c5;
                }
                tVar.i();
                return s.f8222a;
            } else if (i4 == 1) {
                tVar3 = (t) this.f9249b;
                arrayList = (ArrayList) this.f9248a;
                n.b(obj);
            } else if (i4 == 2) {
                tVar2 = (t) this.f9248a;
                n.b(obj);
                tVar = tVar2;
                tVar.i();
                return s.f8222a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (this.f9251d.f9170d > -1) {
                C c7 = new C();
                Iterator it = arrayList.iterator();
                m.d(it, "iterator(...)");
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    m.d(next, "next(...)");
                    C2050h hVar = (C2050h) next;
                    if (!m3.m.p(hVar.Q(), this.f9251d.f9167a.getPackageName(), true)) {
                        c7.f20968a = hVar;
                        break;
                    }
                }
                if (c7.f20968a != null) {
                    E0 c8 = Y.c();
                    b bVar = new b(this.f9251d, c7, (V2.d) null);
                    this.f9248a = tVar3;
                    this.f9249b = null;
                    this.f9250c = 2;
                    if (C0977g.g(c8, bVar, this) != c5) {
                        tVar2 = tVar3;
                        tVar = tVar2;
                        tVar.i();
                        return s.f8222a;
                    }
                    return c5;
                }
            }
            tVar = tVar3;
            tVar.i();
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((j) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.f$k */
    static final class k extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9259a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1634f f9260b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f9261c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ L f9262d;

        /* renamed from: b2.f$k$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9263a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1634f f9264b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f9265c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1634f fVar, ArrayList arrayList, V2.d dVar) {
                super(2, dVar);
                this.f9264b = fVar;
                this.f9265c = arrayList;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9264b, this.f9265c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9263a == 0) {
                    n.b(obj);
                    this.f9264b.f9168b.b(this.f9265c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(C1634f fVar, ArrayList arrayList, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9260b = fVar;
            this.f9261c = arrayList;
            this.f9262d = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new k(this.f9260b, this.f9261c, this.f9262d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9259a;
            if (i4 == 0) {
                n.b(obj);
                ArrayList arrayList = new ArrayList();
                t a5 = t.f21927u.a(this.f9260b.f9167a);
                a5.a();
                Iterator it = this.f9261c.iterator();
                m.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    arrayList.add(this.f9260b.B((C2053k) next, this.f9262d, a5));
                }
                a5.i();
                E0 c6 = Y.c();
                a aVar = new a(this.f9260b, arrayList, (V2.d) null);
                this.f9259a = 1;
                if (C0977g.g(c6, aVar, this) == c5) {
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
            return ((k) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.f$l */
    static final class l extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9266a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f9267b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1634f f9268c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ L f9269d;

        /* renamed from: b2.f$l$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9270a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1634f f9271b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f9272c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1634f fVar, ArrayList arrayList, V2.d dVar) {
                super(2, dVar);
                this.f9271b = fVar;
                this.f9272c = arrayList;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9271b, this.f9272c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9270a == 0) {
                    n.b(obj);
                    this.f9271b.f9168b.k(this.f9272c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(ArrayList arrayList, C1634f fVar, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9267b = arrayList;
            this.f9268c = fVar;
            this.f9269d = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new l(this.f9267b, this.f9268c, this.f9269d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9266a;
            if (i4 == 0) {
                n.b(obj);
                if (!this.f9267b.isEmpty()) {
                    t a5 = t.f21927u.a(this.f9268c.f9167a);
                    a5.a();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = this.f9267b.iterator();
                    m.d(it, "iterator(...)");
                    while (it.hasNext()) {
                        Object next = it.next();
                        m.d(next, "next(...)");
                        arrayList.add(this.f9268c.B((C2053k) next, this.f9269d, a5));
                    }
                    a5.i();
                    E0 c6 = Y.c();
                    a aVar = new a(this.f9268c, arrayList, (V2.d) null);
                    this.f9266a = 1;
                    if (C0977g.g(c6, aVar, this) == c5) {
                        return c5;
                    }
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((l) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1634f(Context context, C2024o oVar, J j4) {
        m.e(context, "context");
        m.e(oVar, "listener");
        m.e(j4, "scope");
        this.f9167a = context;
        this.f9168b = oVar;
        this.f9169c = j4;
        C1001s0 unused = C0981i.d(j4, (V2.g) null, (o3.L) null, new a(this, (V2.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Q B(C2053k kVar, L l4, t tVar) {
        String str;
        g2.L l5;
        int i4 = 5;
        int i5 = 20;
        if (kVar.h()) {
            str = "floating_category_top_" + kVar.b();
        } else {
            str = "category_top_" + kVar.b();
            int b5 = kVar.b();
            if (b5 != 521) {
                if (b5 == 523) {
                    if (!UptodownApp.f17422D.Q()) {
                        i4 = 4;
                    }
                    i5 = 8;
                } else if (b5 != 524) {
                    i5 = 12;
                    i4 = 6;
                }
            }
            i4 = 1;
        }
        ArrayList arrayList = new ArrayList();
        M C02 = tVar.C0(str);
        if (C02 == null || !C02.a()) {
            if (kVar.h()) {
                l5 = l4.k0(kVar.b(), i5, 0);
            } else {
                l5 = l4.i0(kVar.b(), i5, 0);
            }
            if (!l5.b() && l5.e() != null) {
                arrayList = l4.Q0(l5);
                String d5 = l5.d();
                m.b(d5);
                M m4 = new M(str, d5);
                tVar.Q(str);
                tVar.W0(m4);
            }
        } else {
            arrayList = l4.Q0(C02.c());
        }
        Q q4 = new Q(kVar, arrayList, 0, 4, (C2103g) null);
        q4.f(i4);
        return q4;
    }

    /* access modifiers changed from: private */
    public final Object C(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new j(this, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object D(L l4, ArrayList arrayList, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new k(this, arrayList, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object E(L l4, ArrayList arrayList, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new l(arrayList, this, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object s(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object t(V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new c(this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object u(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new d(this, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object v(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new e(this, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object w(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new C0147f(this, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object x(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new g(this, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object y(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new h(this, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object z(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new i(this, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public final J A() {
        return this.f9169c;
    }
}
