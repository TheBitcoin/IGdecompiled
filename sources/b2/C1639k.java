package b2;

import R2.n;
import R2.s;
import android.content.Context;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import d3.p;
import f2.r;
import g2.C2050h;
import g2.C2053k;
import g2.M;
import g2.Q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.Y;
import org.json.JSONArray;
import org.json.JSONObject;
import u2.L;
import u2.t;

/* renamed from: b2.k  reason: case insensitive filesystem */
public final class C1639k {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f9348a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final r f9349b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final C2053k f9350c;

    /* renamed from: d  reason: collision with root package name */
    private final J f9351d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f9352e = -1;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f9353f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ArrayList f9354g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public C2050h f9355h;

    /* renamed from: b2.k$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9356a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1639k f9357b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C1639k kVar, V2.d dVar) {
            super(2, dVar);
            this.f9357b = kVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f9357b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9356a;
            if (i4 == 0) {
                n.b(obj);
                C1639k kVar = this.f9357b;
                this.f9356a = 1;
                if (kVar.u(this) == c5) {
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

    /* renamed from: b2.k$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9358a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1639k f9359b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f9360c;

        /* renamed from: b2.k$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9361a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1639k f9362b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C f9363c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1639k kVar, C c5, V2.d dVar) {
                super(2, dVar);
                this.f9362b = kVar;
                this.f9363c = c5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9362b, this.f9363c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9361a == 0) {
                    n.b(obj);
                    this.f9362b.f9349b.c((ArrayList) this.f9363c.f20968a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1639k kVar, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9359b = kVar;
            this.f9360c = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f9359b, this.f9360c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9358a;
            if (i4 == 0) {
                n.b(obj);
                C c6 = new C();
                c6.f20968a = new ArrayList();
                t a5 = t.f21927u.a(this.f9359b.f9348a);
                a5.a();
                String str = "features_by_category_" + this.f9359b.f9350c.b();
                M C02 = a5.C0(str);
                int i5 = 0;
                if (C02 == null || !C02.a()) {
                    g2.L l02 = this.f9360c.l0(this.f9359b.f9350c.b(), 6, 0);
                    if (!l02.b() && l02.e() != null) {
                        c6.f20968a = this.f9360c.Q0(l02);
                        String d5 = l02.d();
                        m.b(d5);
                        M m4 = new M(str, d5);
                        a5.Q(str);
                        a5.W0(m4);
                    }
                } else {
                    c6.f20968a = this.f9360c.Q0(C02.c());
                }
                a5.i();
                if (!((Collection) c6.f20968a).isEmpty()) {
                    this.f9359b.f9353f = this.f9359b.f9353f + 1;
                    this.f9359b.f9352e = -1;
                    for (C2050h Q4 : (Iterable) c6.f20968a) {
                        int i6 = i5 + 1;
                        if (m3.m.p(Q4.Q(), this.f9359b.f9348a.getPackageName(), true)) {
                            this.f9359b.f9352e = i5;
                        }
                        i5 = i6;
                    }
                    if (this.f9359b.f9352e > -1 && this.f9359b.f9352e < ((ArrayList) c6.f20968a).size()) {
                        ((ArrayList) c6.f20968a).remove(this.f9359b.f9352e);
                    }
                    if (((ArrayList) c6.f20968a).size() > 5) {
                        this.f9359b.f9355h = (C2050h) ((ArrayList) c6.f20968a).remove(5);
                        r j4 = this.f9359b.f9349b;
                        C2050h a6 = this.f9359b.f9355h;
                        m.b(a6);
                        j4.h(a6);
                    }
                }
                E0 c7 = Y.c();
                a aVar = new a(this.f9359b, c6, (V2.d) null);
                this.f9358a = 1;
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
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.k$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f9364a;

        /* renamed from: b  reason: collision with root package name */
        int f9365b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1639k f9366c;

        /* renamed from: b2.k$c$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9367a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1639k f9368b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f9369c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1639k kVar, L l4, V2.d dVar) {
                super(2, dVar);
                this.f9368b = kVar;
                this.f9369c = l4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9368b, this.f9369c, dVar);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
                if (b2.C1639k.b(r7, r1, r6) == r0) goto L_0x0062;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
                if (b2.C1639k.i(r7, r1, r6) == r0) goto L_0x0062;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
                if (b2.C1639k.l(r7, r1, r6) == r0) goto L_0x0062;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
                if (b2.C1639k.m(r7, r1, r6) == r0) goto L_0x0062;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
                return r0;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = W2.b.c()
                    int r1 = r6.f9367a
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
                    b2.k r7 = r6.f9368b
                    u2.L r1 = r6.f9369c
                    r6.f9367a = r5
                    java.lang.Object r7 = r7.t(r1, r6)
                    if (r7 != r0) goto L_0x003c
                    goto L_0x0062
                L_0x003c:
                    b2.k r7 = r6.f9368b
                    u2.L r1 = r6.f9369c
                    r6.f9367a = r4
                    java.lang.Object r7 = r7.w(r1, r6)
                    if (r7 != r0) goto L_0x0049
                    goto L_0x0062
                L_0x0049:
                    b2.k r7 = r6.f9368b
                    u2.L r1 = r6.f9369c
                    r6.f9367a = r3
                    java.lang.Object r7 = r7.x(r1, r6)
                    if (r7 != r0) goto L_0x0056
                    goto L_0x0062
                L_0x0056:
                    b2.k r7 = r6.f9368b
                    u2.L r1 = r6.f9369c
                    r6.f9367a = r2
                    java.lang.Object r7 = r7.z(r1, r6)
                    if (r7 != r0) goto L_0x0063
                L_0x0062:
                    return r0
                L_0x0063:
                    R2.s r7 = R2.s.f8222a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: b2.C1639k.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.k$c$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9370a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1639k f9371b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C1639k kVar, V2.d dVar) {
                super(2, dVar);
                this.f9371b = kVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f9371b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9370a == 0) {
                    n.b(obj);
                    this.f9371b.f9349b.g();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.k$c$c  reason: collision with other inner class name */
        static final class C0152c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9372a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1639k f9373b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f9374c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0152c(C1639k kVar, L l4, V2.d dVar) {
                super(2, dVar);
                this.f9373b = kVar;
                this.f9374c = l4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0152c(this.f9373b, this.f9374c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object c5 = W2.b.c();
                int i4 = this.f9372a;
                if (i4 == 0) {
                    n.b(obj);
                    C1639k kVar = this.f9373b;
                    L l4 = this.f9374c;
                    ArrayList h4 = kVar.f9354g;
                    this.f9372a = 1;
                    if (kVar.B(l4, h4, this) == c5) {
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
                return ((C0152c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C1639k kVar, V2.d dVar) {
            super(2, dVar);
            this.f9366c = kVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f9366c, dVar);
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
                int r1 = r11.f9365b
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L_0x0028
                if (r1 == r4) goto L_0x001f
                if (r1 != r2) goto L_0x0017
                java.lang.Object r0 = r11.f9364a
                u2.L r0 = (u2.L) r0
                R2.n.b(r12)
                goto L_0x0073
            L_0x0017:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x001f:
                java.lang.Object r1 = r11.f9364a
                u2.L r1 = (u2.L) r1
                R2.n.b(r12)
                r12 = r1
                goto L_0x005c
            L_0x0028:
                R2.n.b(r12)
                b2.k r12 = r11.f9366c
                r1 = 0
                r12.f9353f = r1
                u2.L r12 = new u2.L
                b2.k r1 = r11.f9366c
                android.content.Context r1 = r1.f9348a
                r12.<init>(r1)
                b2.k r1 = r11.f9366c
                o3.J r5 = r1.y()
                b2.k$c$a r8 = new b2.k$c$a
                b2.k r1 = r11.f9366c
                r8.<init>(r1, r12, r3)
                r9 = 3
                r10 = 0
                r6 = 0
                r7 = 0
                o3.s0 r1 = o3.C0981i.d(r5, r6, r7, r8, r9, r10)
                r11.f9364a = r12
                r11.f9365b = r4
                java.lang.Object r1 = r1.g(r11)
                if (r1 != r0) goto L_0x005c
                goto L_0x0071
            L_0x005c:
                o3.E0 r1 = o3.Y.c()
                b2.k$c$b r5 = new b2.k$c$b
                b2.k r6 = r11.f9366c
                r5.<init>(r6, r3)
                r11.f9364a = r12
                r11.f9365b = r2
                java.lang.Object r1 = o3.C0977g.g(r1, r5, r11)
                if (r1 != r0) goto L_0x0072
            L_0x0071:
                return r0
            L_0x0072:
                r0 = r12
            L_0x0073:
                b2.k r12 = r11.f9366c
                int r12 = r12.f9353f
                if (r12 < r4) goto L_0x008f
                b2.k r12 = r11.f9366c
                o3.J r4 = r12.y()
                b2.k$c$c r7 = new b2.k$c$c
                b2.k r12 = r11.f9366c
                r7.<init>(r12, r0, r3)
                r8 = 3
                r9 = 0
                r5 = 0
                r6 = 0
                o3.C1001s0 unused = o3.C0981i.d(r4, r5, r6, r7, r8, r9)
            L_0x008f:
                R2.s r12 = R2.s.f8222a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C1639k.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.k$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9375a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ L f9376b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1639k f9377c;

        /* renamed from: b2.k$d$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9378a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ArrayList f9379b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C1639k f9380c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(ArrayList arrayList, C1639k kVar, V2.d dVar) {
                super(2, dVar);
                this.f9379b = arrayList;
                this.f9380c = kVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9379b, this.f9380c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9378a == 0) {
                    n.b(obj);
                    if (!this.f9379b.isEmpty()) {
                        this.f9380c.f9349b.d(this.f9379b);
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
        d(L l4, C1639k kVar, V2.d dVar) {
            super(2, dVar);
            this.f9376b = l4;
            this.f9377c = kVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f9376b, this.f9377c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9375a;
            if (i4 == 0) {
                n.b(obj);
                ArrayList arrayList = new ArrayList();
                g2.L z4 = this.f9376b.z(this.f9377c.f9350c.b());
                if (!z4.b() && z4.e() != null) {
                    JSONObject e5 = z4.e();
                    m.b(e5);
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (e5.optInt("success") == 1 && optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i5 = 0; i5 < length; i5++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                            C2053k kVar = new C2053k(0, (String) null, (String) null, 7, (C2103g) null);
                            m.b(optJSONObject);
                            kVar.m(optJSONObject);
                            arrayList.add(kVar);
                        }
                    }
                }
                E0 c6 = Y.c();
                a aVar = new a(arrayList, this.f9377c, (V2.d) null);
                this.f9375a = 1;
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
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.k$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9381a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1639k f9382b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f9383c;

        /* renamed from: b2.k$e$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9384a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1639k f9385b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1639k kVar, V2.d dVar) {
                super(2, dVar);
                this.f9385b = kVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9385b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9384a == 0) {
                    n.b(obj);
                    this.f9385b.f9349b.i(this.f9385b.f9354g);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(C1639k kVar, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9382b = kVar;
            this.f9383c = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f9382b, this.f9383c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9381a;
            if (i4 == 0) {
                n.b(obj);
                t a5 = t.f21927u.a(this.f9382b.f9348a);
                a5.a();
                String str = "leaf_categories_" + this.f9382b.f9350c.b();
                M C02 = a5.C0(str);
                if (C02 == null || !C02.a()) {
                    g2.L r4 = this.f9383c.r(this.f9382b.f9350c.b());
                    if (!r4.b() && r4.e() != null) {
                        C1639k kVar = this.f9382b;
                        C2053k.b bVar = C2053k.f20690g;
                        JSONObject e5 = r4.e();
                        m.b(e5);
                        kVar.f9354g = bVar.c(e5, this.f9382b.f9350c.b());
                        String d5 = r4.d();
                        m.b(d5);
                        M m4 = new M(str, d5);
                        a5.Q(str);
                        a5.W0(m4);
                    }
                } else {
                    this.f9382b.f9354g = C2053k.f20690g.a(C02.b(), this.f9382b.f9350c.b());
                }
                a5.i();
                if (!this.f9382b.f9354g.isEmpty()) {
                    this.f9382b.f9353f = this.f9382b.f9353f + 1;
                    E0 c6 = Y.c();
                    a aVar = new a(this.f9382b, (V2.d) null);
                    this.f9381a = 1;
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
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.k$f */
    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9386a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1639k f9387b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f9388c;

        /* renamed from: b2.k$f$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9389a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1639k f9390b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Q f9391c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1639k kVar, Q q4, V2.d dVar) {
                super(2, dVar);
                this.f9390b = kVar;
                this.f9391c = q4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9390b, this.f9391c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9389a == 0) {
                    n.b(obj);
                    this.f9390b.f9349b.j(this.f9391c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(C1639k kVar, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9387b = kVar;
            this.f9388c = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f9387b, this.f9388c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            String d5;
            Object c5 = W2.b.c();
            int i4 = this.f9386a;
            if (i4 == 0) {
                n.b(obj);
                t a5 = t.f21927u.a(this.f9387b.f9348a);
                a5.a();
                String str = "recent_by_category_" + this.f9387b.f9350c.b();
                M C02 = a5.C0(str);
                if (C02 == null || !C02.a()) {
                    g2.L W4 = this.f9388c.W(this.f9387b.f9350c.b(), 20, 0);
                    if (W4.b() || (d5 = W4.d()) == null || d5.length() == 0) {
                        arrayList = null;
                    } else {
                        ArrayList Q02 = this.f9388c.Q0(W4);
                        String d6 = W4.d();
                        m.b(d6);
                        M m4 = new M(str, d6);
                        a5.Q(str);
                        a5.W0(m4);
                        arrayList = Q02;
                    }
                } else {
                    arrayList = this.f9388c.Q0(C02.c());
                }
                a5.i();
                if (arrayList != null && !arrayList.isEmpty()) {
                    String string = this.f9387b.f9348a.getString(R.string.the_latest_title);
                    m.d(string, "getString(...)");
                    C2053k kVar = new C2053k(-2, string, (String) null, 4, (C2103g) null);
                    kVar.t(this.f9387b.f9350c.b());
                    Q q4 = new Q(kVar, arrayList, 0, 4, (C2103g) null);
                    q4.f(1);
                    E0 c6 = Y.c();
                    a aVar = new a(this.f9387b, q4, (V2.d) null);
                    this.f9386a = 1;
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
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.k$g */
    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f9392a;

        /* renamed from: b  reason: collision with root package name */
        Object f9393b;

        /* renamed from: c  reason: collision with root package name */
        int f9394c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C1639k f9395d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ L f9396e;

        /* renamed from: b2.k$g$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9397a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1639k f9398b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Q f9399c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1639k kVar, Q q4, V2.d dVar) {
                super(2, dVar);
                this.f9398b = kVar;
                this.f9399c = q4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9398b, this.f9399c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9397a == 0) {
                    n.b(obj);
                    this.f9398b.f9349b.a(this.f9399c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.k$g$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9400a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1639k f9401b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C f9402c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C1639k kVar, C c5, V2.d dVar) {
                super(2, dVar);
                this.f9401b = kVar;
                this.f9402c = c5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f9401b, this.f9402c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9400a == 0) {
                    n.b(obj);
                    this.f9401b.f9349b.f((C2050h) this.f9402c.f20968a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(C1639k kVar, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9395d = kVar;
            this.f9396e = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f9395d, this.f9396e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            t tVar;
            t tVar2;
            ArrayList arrayList;
            Object c5 = W2.b.c();
            int i4 = this.f9394c;
            if (i4 == 0) {
                n.b(obj);
                ArrayList arrayList2 = new ArrayList();
                tVar = t.f21927u.a(this.f9395d.f9348a);
                tVar.a();
                String str = "top_downloads_" + this.f9395d.f9350c.b();
                M C02 = tVar.C0(str);
                if (C02 == null || !C02.a()) {
                    g2.L i02 = this.f9396e.i0(this.f9395d.f9350c.b(), 20, 0);
                    if (!i02.b() && i02.e() != null) {
                        arrayList2 = this.f9396e.Q0(i02);
                        String d5 = i02.d();
                        m.b(d5);
                        M m4 = new M(str, d5);
                        tVar.Q(str);
                        tVar.W0(m4);
                    }
                } else {
                    arrayList2 = this.f9396e.Q0(C02.c());
                }
                ArrayList arrayList3 = arrayList2;
                if (!arrayList3.isEmpty()) {
                    String string = this.f9395d.f9348a.getString(R.string.top_downloads_title);
                    m.d(string, "getString(...)");
                    Q q4 = new Q(this.f9395d.f9350c, arrayList3, 0, 4, (C2103g) null);
                    q4.b().s(string);
                    if (this.f9395d.f9350c.b() != 523 || UptodownApp.f17422D.Q()) {
                        q4.f(5);
                    } else {
                        q4.f(4);
                    }
                    E0 c6 = Y.c();
                    a aVar = new a(this.f9395d, q4, (V2.d) null);
                    this.f9392a = arrayList3;
                    this.f9393b = tVar;
                    this.f9394c = 1;
                    if (C0977g.g(c6, aVar, this) != c5) {
                        arrayList = arrayList3;
                    }
                    return c5;
                }
                tVar.i();
                return s.f8222a;
            } else if (i4 == 1) {
                tVar = (t) this.f9393b;
                arrayList = (ArrayList) this.f9392a;
                n.b(obj);
            } else if (i4 == 2) {
                tVar2 = (t) this.f9392a;
                n.b(obj);
                tVar = tVar2;
                tVar.i();
                return s.f8222a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (this.f9395d.f9352e > -1) {
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
                    if (!m3.m.p(hVar.Q(), this.f9395d.f9348a.getPackageName(), true)) {
                        c7.f20968a = hVar;
                        break;
                    }
                }
                if (c7.f20968a != null) {
                    E0 c8 = Y.c();
                    b bVar = new b(this.f9395d, c7, (V2.d) null);
                    this.f9392a = tVar;
                    this.f9393b = null;
                    this.f9394c = 2;
                    if (C0977g.g(c8, bVar, this) != c5) {
                        tVar2 = tVar;
                        tVar = tVar2;
                    }
                    return c5;
                }
            }
            tVar.i();
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.k$h */
    static final class h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f9403a;

        /* renamed from: b  reason: collision with root package name */
        Object f9404b;

        /* renamed from: c  reason: collision with root package name */
        Object f9405c;

        /* renamed from: d  reason: collision with root package name */
        int f9406d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C1639k f9407e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f9408f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ L f9409g;

        /* renamed from: b2.k$h$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9410a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1639k f9411b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Q f9412c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1639k kVar, Q q4, V2.d dVar) {
                super(2, dVar);
                this.f9411b = kVar;
                this.f9412c = q4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9411b, this.f9412c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9410a == 0) {
                    n.b(obj);
                    if (this.f9411b.f9350c.b() != 523) {
                        this.f9411b.f9349b.e(this.f9412c);
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.k$h$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9413a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1639k f9414b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f9415c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ L f9416d;

            /* renamed from: b2.k$h$b$a */
            static final class a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f9417a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ C1639k f9418b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ L f9419c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(C1639k kVar, L l4, V2.d dVar) {
                    super(2, dVar);
                    this.f9418b = kVar;
                    this.f9419c = l4;
                }

                public final V2.d create(Object obj, V2.d dVar) {
                    return new a(this.f9418b, this.f9419c, dVar);
                }

                public final Object invokeSuspend(Object obj) {
                    Object c5 = W2.b.c();
                    int i4 = this.f9417a;
                    if (i4 == 0) {
                        n.b(obj);
                        C1639k kVar = this.f9418b;
                        L l4 = this.f9419c;
                        this.f9417a = 1;
                        if (kVar.v(l4, this) == c5) {
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

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C1639k kVar, ArrayList arrayList, L l4, V2.d dVar) {
                super(2, dVar);
                this.f9414b = kVar;
                this.f9415c = arrayList;
                this.f9416d = l4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f9414b, this.f9415c, this.f9416d, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9413a == 0) {
                    n.b(obj);
                    if (this.f9414b.f9350c.b() == 523) {
                        this.f9414b.f9349b.b(this.f9415c);
                    }
                    return C0981i.d(this.f9414b.y(), (V2.g) null, (o3.L) null, new a(this.f9414b, this.f9416d, (V2.d) null), 3, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(C1639k kVar, ArrayList arrayList, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9407e = kVar;
            this.f9408f = arrayList;
            this.f9409g = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new h(this.f9407e, this.f9408f, this.f9409g, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            t tVar;
            Iterator it;
            Object c5 = W2.b.c();
            int i4 = this.f9406d;
            if (i4 == 0) {
                n.b(obj);
                ArrayList arrayList2 = new ArrayList();
                t a5 = t.f21927u.a(this.f9407e.f9348a);
                a5.a();
                Iterator it2 = this.f9408f.iterator();
                m.d(it2, "iterator(...)");
                Iterator it3 = it2;
                tVar = a5;
                it = it3;
                arrayList = arrayList2;
            } else if (i4 == 1) {
                it = (Iterator) this.f9405c;
                tVar = (t) this.f9404b;
                arrayList = (ArrayList) this.f9403a;
                n.b(obj);
            } else if (i4 == 2) {
                n.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (true) {
                if (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    Q n4 = this.f9407e.A((C2053k) next, this.f9409g, tVar);
                    arrayList.add(n4);
                    E0 c6 = Y.c();
                    a aVar = new a(this.f9407e, n4, (V2.d) null);
                    this.f9403a = arrayList;
                    this.f9404b = tVar;
                    this.f9405c = it;
                    this.f9406d = 1;
                    if (C0977g.g(c6, aVar, this) == c5) {
                        break;
                    }
                } else {
                    tVar.i();
                    E0 c7 = Y.c();
                    b bVar = new b(this.f9407e, arrayList, this.f9409g, (V2.d) null);
                    this.f9403a = null;
                    this.f9404b = null;
                    this.f9405c = null;
                    this.f9406d = 2;
                    Object g4 = C0977g.g(c7, bVar, this);
                    if (g4 == c5) {
                        return c5;
                    }
                    return g4;
                }
            }
            return c5;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((h) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1639k(Context context, r rVar, C2053k kVar, J j4) {
        m.e(context, "context");
        m.e(rVar, "listener");
        m.e(kVar, "category");
        m.e(j4, "scope");
        this.f9348a = context;
        this.f9349b = rVar;
        this.f9350c = kVar;
        this.f9351d = j4;
        C1001s0 unused = C0981i.d(j4, (V2.g) null, (o3.L) null, new a(this, (V2.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Q A(C2053k kVar, L l4, t tVar) {
        String str = "category_top_" + kVar.b();
        int c5 = kVar.c();
        int f4 = kVar.f();
        ArrayList arrayList = new ArrayList();
        M C02 = tVar.C0(str);
        if (C02 == null || !C02.a()) {
            g2.L j02 = l4.j0(kVar.b(), c5, 0);
            if (!j02.b() && j02.e() != null) {
                arrayList = l4.Q0(j02);
                String d5 = j02.d();
                m.b(d5);
                M m4 = new M(str, d5);
                tVar.Q(str);
                tVar.W0(m4);
            }
        } else {
            arrayList = l4.Q0(C02.c());
        }
        Q q4 = new Q(kVar, arrayList, 0, 4, (C2103g) null);
        q4.f(f4);
        return q4;
    }

    /* access modifiers changed from: private */
    public final Object B(L l4, ArrayList arrayList, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new h(this, arrayList, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object t(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object u(V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new c(this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object v(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new d(l4, this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object w(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new e(this, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object x(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new f(this, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object z(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new g(this, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public final J y() {
        return this.f9351d;
    }
}
