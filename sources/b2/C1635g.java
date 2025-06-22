package b2;

import R2.n;
import R2.s;
import V2.g;
import android.content.Context;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import d3.p;
import f2.C2025p;
import g2.C2053k;
import g2.Q;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
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

/* renamed from: b2.g  reason: case insensitive filesystem */
public final class C1635g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f9273a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2025p f9274b;

    /* renamed from: c  reason: collision with root package name */
    private final J f9275c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f9276d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public C2053k f9277e = new C2053k(523, "Games", (String) null, 4, (C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ArrayList f9278f = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ArrayList f9279g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ArrayList f9280h = new ArrayList();

    /* renamed from: b2.g$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9281a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1635g f9282b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C1635g gVar, V2.d dVar) {
            super(2, dVar);
            this.f9282b = gVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f9282b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9281a;
            if (i4 == 0) {
                n.b(obj);
                C1635g gVar = this.f9282b;
                this.f9281a = 1;
                if (gVar.r(this) == c5) {
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

    /* renamed from: b2.g$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9283a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ L f9284b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1635g f9285c;

        /* renamed from: b2.g$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9286a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1635g f9287b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1635g gVar, V2.d dVar) {
                super(2, dVar);
                this.f9287b = gVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9287b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9286a == 0) {
                    n.b(obj);
                    C2025p g4 = this.f9287b.f9274b;
                    if (g4 == null) {
                        return null;
                    }
                    g4.b(this.f9287b.f9279g);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(L l4, C1635g gVar, V2.d dVar) {
            super(2, dVar);
            this.f9284b = l4;
            this.f9285c = gVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f9284b, this.f9285c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9283a;
            if (i4 == 0) {
                n.b(obj);
                g2.L r4 = this.f9284b.r(this.f9285c.f9277e.b());
                this.f9285c.f9279g = new ArrayList();
                if (!r4.b() && r4.e() != null) {
                    JSONObject e5 = r4.e();
                    m.b(e5);
                    if (e5.optInt("success") == 1) {
                        JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i5 = 0; i5 < length; i5++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                                C2053k kVar = new C2053k(0, (String) null, (String) null, 7, (C2103g) null);
                                m.b(optJSONObject);
                                kVar.l(optJSONObject, this.f9285c.f9277e.b());
                                this.f9285c.f9279g.add(kVar);
                            }
                            E0 c6 = Y.c();
                            a aVar = new a(this.f9285c, (V2.d) null);
                            this.f9283a = 1;
                            if (C0977g.g(c6, aVar, this) == c5) {
                                return c5;
                            }
                        }
                    } else {
                        int d5 = this.f9285c.f9276d;
                        this.f9285c.f9276d = d5 + 1;
                        kotlin.coroutines.jvm.internal.b.b(d5);
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

    /* renamed from: b2.g$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9288a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1635g f9289b;

        /* renamed from: b2.g$c$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9290a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1635g f9291b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f9292c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1635g gVar, L l4, V2.d dVar) {
                super(2, dVar);
                this.f9291b = gVar;
                this.f9292c = l4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9291b, this.f9292c, dVar);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
                if (b2.C1635g.m(r8, r1, r7) == r0) goto L_0x0076;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
                if (b2.C1635g.a(r8, r1, r7) == r0) goto L_0x0076;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
                if (b2.C1635g.j(r8, r1, r7) == r0) goto L_0x0076;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
                if (b2.C1635g.k(r8, r1, r7) == r0) goto L_0x0076;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0074, code lost:
                if (b2.C1635g.l(r8, r1, r7) == r0) goto L_0x0076;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x0076, code lost:
                return r0;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = W2.b.c()
                    int r1 = r7.f9290a
                    r2 = 5
                    r3 = 4
                    r4 = 3
                    r5 = 2
                    r6 = 1
                    if (r1 == 0) goto L_0x0033
                    if (r1 == r6) goto L_0x002f
                    if (r1 == r5) goto L_0x002b
                    if (r1 == r4) goto L_0x0027
                    if (r1 == r3) goto L_0x0023
                    if (r1 != r2) goto L_0x001b
                    R2.n.b(r8)
                    goto L_0x0077
                L_0x001b:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L_0x0023:
                    R2.n.b(r8)
                    goto L_0x006a
                L_0x0027:
                    R2.n.b(r8)
                    goto L_0x005d
                L_0x002b:
                    R2.n.b(r8)
                    goto L_0x0050
                L_0x002f:
                    R2.n.b(r8)
                    goto L_0x0043
                L_0x0033:
                    R2.n.b(r8)
                    b2.g r8 = r7.f9291b
                    u2.L r1 = r7.f9292c
                    r7.f9290a = r6
                    java.lang.Object r8 = r8.w(r1, r7)
                    if (r8 != r0) goto L_0x0043
                    goto L_0x0076
                L_0x0043:
                    b2.g r8 = r7.f9291b
                    u2.L r1 = r7.f9292c
                    r7.f9290a = r5
                    java.lang.Object r8 = r8.q(r1, r7)
                    if (r8 != r0) goto L_0x0050
                    goto L_0x0076
                L_0x0050:
                    b2.g r8 = r7.f9291b
                    u2.L r1 = r7.f9292c
                    r7.f9290a = r4
                    java.lang.Object r8 = r8.s(r1, r7)
                    if (r8 != r0) goto L_0x005d
                    goto L_0x0076
                L_0x005d:
                    b2.g r8 = r7.f9291b
                    u2.L r1 = r7.f9292c
                    r7.f9290a = r3
                    java.lang.Object r8 = r8.u(r1, r7)
                    if (r8 != r0) goto L_0x006a
                    goto L_0x0076
                L_0x006a:
                    b2.g r8 = r7.f9291b
                    u2.L r1 = r7.f9292c
                    r7.f9290a = r2
                    java.lang.Object r8 = r8.v(r1, r7)
                    if (r8 != r0) goto L_0x0077
                L_0x0076:
                    return r0
                L_0x0077:
                    R2.s r8 = R2.s.f8222a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: b2.C1635g.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.g$c$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9293a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1635g f9294b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C1635g gVar, V2.d dVar) {
                super(2, dVar);
                this.f9294b = gVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f9294b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9293a == 0) {
                    n.b(obj);
                    C2025p g4 = this.f9294b.f9274b;
                    if (g4 == null) {
                        return null;
                    }
                    g4.c(this.f9294b.f9280h, this.f9294b.f9279g, this.f9294b.f9278f, this.f9294b.f9276d);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C1635g gVar, V2.d dVar) {
            super(2, dVar);
            this.f9289b = gVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f9289b, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
            if (r12.g(r11) == r0) goto L_0x005e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r11.f9288a
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001f
                if (r1 == r4) goto L_0x001b
                if (r1 != r3) goto L_0x0013
                R2.n.b(r12)
                return r12
            L_0x0013:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x001b:
                R2.n.b(r12)
                goto L_0x004b
            L_0x001f:
                R2.n.b(r12)
                u2.L r12 = new u2.L
                b2.g r1 = r11.f9289b
                android.content.Context r1 = r1.f9273a
                r12.<init>(r1)
                b2.g r1 = r11.f9289b
                o3.J r5 = r1.t()
                b2.g$c$a r8 = new b2.g$c$a
                b2.g r1 = r11.f9289b
                r8.<init>(r1, r12, r2)
                r9 = 3
                r10 = 0
                r6 = 0
                r7 = 0
                o3.s0 r12 = o3.C0981i.d(r5, r6, r7, r8, r9, r10)
                r11.f9288a = r4
                java.lang.Object r12 = r12.g(r11)
                if (r12 != r0) goto L_0x004b
                goto L_0x005e
            L_0x004b:
                o3.E0 r12 = o3.Y.c()
                b2.g$c$b r1 = new b2.g$c$b
                b2.g r4 = r11.f9289b
                r1.<init>(r4, r2)
                r11.f9288a = r3
                java.lang.Object r12 = o3.C0977g.g(r12, r1, r11)
                if (r12 != r0) goto L_0x005f
            L_0x005e:
                return r0
            L_0x005f:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C1635g.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.g$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9295a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ L f9296b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1635g f9297c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(L l4, C1635g gVar, V2.d dVar) {
            super(2, dVar);
            this.f9296b = l4;
            this.f9297c = gVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f9296b, this.f9297c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            String str;
            W2.b.c();
            if (this.f9295a == 0) {
                n.b(obj);
                g2.L W4 = this.f9296b.W(this.f9297c.f9277e.b(), 10, 0);
                if (W4.b() || (d5 = W4.d()) == null || d5.length() == 0) {
                    int d6 = this.f9297c.f9276d;
                    this.f9297c.f9276d = d6 + 1;
                    return kotlin.coroutines.jvm.internal.b.b(d6);
                }
                ArrayList Q02 = this.f9296b.Q0(W4);
                try {
                    str = this.f9297c.f9273a.getString(R.string.the_latest_title);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    str = "The latest";
                }
                C2053k kVar = new C2053k(-2, str, (String) null, 4, (C2103g) null);
                kVar.t(this.f9297c.f9277e.b());
                Q q4 = new Q(kVar, Q02, 0, 4, (C2103g) null);
                q4.f(1);
                return kotlin.coroutines.jvm.internal.b.a(this.f9297c.f9278f.add(q4));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.g$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9298a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1635g f9299b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f9300c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(C1635g gVar, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9299b = gVar;
            this.f9300c = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f9299b, this.f9300c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            int i4;
            String str;
            W2.b.c();
            if (this.f9298a == 0) {
                n.b(obj);
                if (this.f9299b.f9277e.b() == 523) {
                    i4 = 8;
                } else {
                    i4 = 10;
                }
                g2.L i02 = this.f9300c.i0(this.f9299b.f9277e.b(), i4, 0);
                if (i02.b() || i02.e() == null) {
                    int d5 = this.f9299b.f9276d;
                    this.f9299b.f9276d = d5 + 1;
                    return kotlin.coroutines.jvm.internal.b.b(d5);
                }
                ArrayList Q02 = this.f9300c.Q0(i02);
                try {
                    str = this.f9299b.f9273a.getString(R.string.top_downloads_title);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    str = "Top Downloads";
                }
                C2053k kVar = new C2053k(-1, str, (String) null, 4, (C2103g) null);
                kVar.t(this.f9299b.f9277e.b());
                Q q4 = new Q(kVar, Q02, 0, 4, (C2103g) null);
                if (this.f9299b.f9277e.b() != 523 || UptodownApp.f17422D.Q()) {
                    q4.f(5);
                } else {
                    q4.f(4);
                }
                return kotlin.coroutines.jvm.internal.b.a(this.f9299b.f9278f.add(q4));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.g$f */
    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9301a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1635g f9302b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f9303c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(C1635g gVar, L l4, V2.d dVar) {
            super(2, dVar);
            this.f9302b = gVar;
            this.f9303c = l4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f9302b, this.f9303c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            int i4;
            W2.b.c();
            if (this.f9301a == 0) {
                n.b(obj);
                Iterator it = this.f9302b.f9279g.iterator();
                m.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    C2053k kVar = (C2053k) next;
                    if (kVar.b() == 648 || kVar.b() == 567 || kVar.b() == 563) {
                        i4 = 12;
                    } else {
                        i4 = 10;
                    }
                    g2.L j02 = this.f9303c.j0(kVar.b(), i4, 0);
                    if (j02.b() || j02.e() == null) {
                        int d5 = this.f9302b.f9276d;
                        this.f9302b.f9276d = d5 + 1;
                        kotlin.coroutines.jvm.internal.b.b(d5);
                    } else {
                        Q q4 = new Q(kVar, this.f9303c.Q0(j02), 0, 4, (C2103g) null);
                        if (this.f9302b.f9277e.b() == 523) {
                            int b5 = kVar.b();
                            if (!(b5 == 568 || b5 == 593 || b5 == 645)) {
                                switch (b5) {
                                    case 558:
                                    case 559:
                                    case 560:
                                    case 562:
                                        q4.f(5);
                                        break;
                                    case 561:
                                        break;
                                    default:
                                        switch (b5) {
                                            case 564:
                                            case 565:
                                            case 566:
                                                break;
                                            default:
                                                q4.f(6);
                                                break;
                                        }
                                        q4.f(5);
                                        break;
                                }
                            }
                            q4.f(1);
                        } else {
                            q4.f(1);
                        }
                        kotlin.coroutines.jvm.internal.b.a(this.f9302b.f9278f.add(q4));
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: b2.g$g  reason: collision with other inner class name */
    static final class C0148g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9304a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ L f9305b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1635g f9306c;

        /* renamed from: b2.g$g$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9307a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1635g f9308b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1635g gVar, V2.d dVar) {
                super(2, dVar);
                this.f9308b = gVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9308b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9307a == 0) {
                    n.b(obj);
                    C2025p g4 = this.f9308b.f9274b;
                    if (g4 == null) {
                        return null;
                    }
                    g4.a(this.f9308b.f9280h);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0148g(L l4, C1635g gVar, V2.d dVar) {
            super(2, dVar);
            this.f9305b = l4;
            this.f9306c = gVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new C0148g(this.f9305b, this.f9306c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9304a;
            if (i4 == 0) {
                n.b(obj);
                g2.L l02 = this.f9305b.l0(this.f9306c.f9277e.b(), 10, 0);
                if (l02.b() || l02.e() == null) {
                    int d5 = this.f9306c.f9276d;
                    this.f9306c.f9276d = d5 + 1;
                    return kotlin.coroutines.jvm.internal.b.b(d5);
                }
                this.f9306c.f9280h = this.f9305b.Q0(l02);
                E0 c6 = Y.c();
                a aVar = new a(this.f9306c, (V2.d) null);
                this.f9304a = 1;
                Object g4 = C0977g.g(c6, aVar, this);
                if (g4 == c5) {
                    return c5;
                }
                return g4;
            } else if (i4 == 1) {
                n.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((C0148g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1635g(Context context, C2025p pVar, J j4) {
        m.e(context, "context");
        m.e(j4, "scope");
        this.f9273a = context;
        this.f9274b = pVar;
        this.f9275c = j4;
        C1001s0 unused = C0981i.d(j4, (g) null, (o3.L) null, new a(this, (V2.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object q(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(l4, this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object r(V2.d dVar) {
        return C0977g.g(Y.b(), new c(this, (V2.d) null), dVar);
    }

    /* access modifiers changed from: private */
    public final Object s(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new d(l4, this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object u(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new e(this, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object v(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new f(this, l4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object w(L l4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new C0148g(l4, this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public final J t() {
        return this.f9275c;
    }
}
