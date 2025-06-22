package com.uptodown.activities;

import R2.k;
import R2.n;
import R2.s;
import S2.C1601o;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import d3.p;
import g2.C2039G;
import g2.L;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.Y;
import org.json.JSONArray;
import org.json.JSONObject;
import r3.I;
import r3.K;
import r3.t;
import u2.E;
import u2.x;

/* renamed from: com.uptodown.activities.x  reason: case insensitive filesystem */
public final class C1848x extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f18926a;

    /* renamed from: b  reason: collision with root package name */
    private final I f18927b;

    /* renamed from: c  reason: collision with root package name */
    private t f18928c = K.a(1);

    /* renamed from: d  reason: collision with root package name */
    private boolean f18929d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18930e = true;

    /* renamed from: com.uptodown.activities.x$a */
    public enum a {
        NAME,
        DATE;

        static {
            a[] a5;
            f18934d = X2.b.a(a5);
        }
    }

    /* renamed from: com.uptodown.activities.x$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18935a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f18936b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2039G f18937c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d3.a f18938d;

        /* renamed from: com.uptodown.activities.x$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f18939a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ d3.a f18940b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d3.a aVar, V2.d dVar) {
                super(2, dVar);
                this.f18940b = aVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f18940b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f18939a == 0) {
                    n.b(obj);
                    this.f18940b.invoke();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, C2039G g4, d3.a aVar, V2.d dVar) {
            super(2, dVar);
            this.f18936b = context;
            this.f18937c = g4;
            this.f18938d = aVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f18936b, this.f18937c, this.f18938d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18935a;
            if (i4 == 0) {
                n.b(obj);
                L e5 = new u2.L(this.f18936b).e(this.f18937c.c());
                if (!e5.b() && e5.e() != null) {
                    JSONObject e6 = e5.e();
                    m.b(e6);
                    if (e6.optInt("success") == 1) {
                        Bundle bundle = new Bundle();
                        bundle.putString("type", "removed");
                        new x(this.f18936b).d("preregister", bundle);
                        this.f18937c.j(this.f18936b);
                        E0 c6 = Y.c();
                        a aVar = new a(this.f18938d, (V2.d) null);
                        this.f18935a = 1;
                        if (C0977g.g(c6, aVar, this) == c5) {
                            return c5;
                        }
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

    /* renamed from: com.uptodown.activities.x$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18941a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1848x f18942b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f18943c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f18944d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ a f18945e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f18946f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C1848x xVar, boolean z4, Context context, a aVar, boolean z5, V2.d dVar) {
            super(2, dVar);
            this.f18942b = xVar;
            this.f18943c = z4;
            this.f18944d = context;
            this.f18945e = aVar;
            this.f18946f = z5;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f18942b, this.f18943c, this.f18944d, this.f18945e, this.f18946f, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18941a;
            if (i4 == 0) {
                n.b(obj);
                this.f18942b.i(true);
                this.f18942b.h(false);
                if (this.f18943c) {
                    this.f18942b.f18926a.setValue(E.a.f21883a);
                }
                C1848x xVar = this.f18942b;
                Context context = this.f18944d;
                a aVar = this.f18945e;
                boolean z4 = this.f18946f;
                this.f18941a = 1;
                obj = xVar.g(context, aVar, z4, this);
                if (obj == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f18942b.f18926a.setValue(new E.c((ArrayList) obj));
            this.f18942b.i(false);
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.activities.x$d */
    static final class d extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f18947a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f18948b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1848x f18949c;

        /* renamed from: d  reason: collision with root package name */
        int f18950d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C1848x xVar, V2.d dVar) {
            super(dVar);
            this.f18949c = xVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f18948b = obj;
            this.f18950d |= Integer.MIN_VALUE;
            return this.f18949c.g((Context) null, (a) null, false, this);
        }
    }

    /* renamed from: com.uptodown.activities.x$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18951a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f18952b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f18953c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f18954d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f18955e;

        /* renamed from: com.uptodown.activities.x$e$a */
        public /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f18956a;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    com.uptodown.activities.x$a[] r0 = com.uptodown.activities.C1848x.a.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.uptodown.activities.x$a r1 = com.uptodown.activities.C1848x.a.DATE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.uptodown.activities.x$a r1 = com.uptodown.activities.C1848x.a.NAME     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    f18956a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.C1848x.e.a.<clinit>():void");
            }
        }

        /* renamed from: com.uptodown.activities.x$e$b */
        public static final class b implements Comparator {
            public final int compare(Object obj, Object obj2) {
                return U2.a.a(Long.valueOf(((C2039G) obj).b()), Long.valueOf(((C2039G) obj2).b()));
            }
        }

        /* renamed from: com.uptodown.activities.x$e$c */
        public static final class c implements Comparator {
            public final int compare(Object obj, Object obj2) {
                return U2.a.a(((C2039G) obj).f(), ((C2039G) obj2).f());
            }
        }

        /* renamed from: com.uptodown.activities.x$e$d */
        public static final class d implements Comparator {
            public final int compare(Object obj, Object obj2) {
                return U2.a.a(Long.valueOf(((C2039G) obj2).b()), Long.valueOf(((C2039G) obj).b()));
            }
        }

        /* renamed from: com.uptodown.activities.x$e$e  reason: collision with other inner class name */
        public static final class C0237e implements Comparator {
            public final int compare(Object obj, Object obj2) {
                return U2.a.a(((C2039G) obj2).f(), ((C2039G) obj).f());
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Context context, ArrayList arrayList, a aVar, boolean z4, V2.d dVar) {
            super(2, dVar);
            this.f18952b = context;
            this.f18953c = arrayList;
            this.f18954d = aVar;
            this.f18955e = z4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f18952b, this.f18953c, this.f18954d, this.f18955e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18951a == 0) {
                n.b(obj);
                L R4 = new u2.L(this.f18952b).R();
                if (!R4.b() && R4.e() != null) {
                    JSONObject e5 = R4.e();
                    m.b(e5);
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                            C2039G.a aVar = C2039G.f20367f;
                            m.b(optJSONObject);
                            this.f18953c.add(aVar.b(optJSONObject));
                        }
                    }
                }
                int i5 = a.f18956a[this.f18954d.ordinal()];
                if (i5 != 1) {
                    if (i5 != 2) {
                        throw new k();
                    } else if (this.f18955e) {
                        ArrayList arrayList = this.f18953c;
                        if (arrayList.size() > 1) {
                            C1601o.t(arrayList, new C0237e());
                        }
                    } else {
                        ArrayList arrayList2 = this.f18953c;
                        if (arrayList2.size() > 1) {
                            C1601o.t(arrayList2, new c());
                        }
                    }
                } else if (this.f18955e) {
                    ArrayList arrayList3 = this.f18953c;
                    if (arrayList3.size() > 1) {
                        C1601o.t(arrayList3, new d());
                    }
                } else {
                    ArrayList arrayList4 = this.f18953c;
                    if (arrayList4.size() > 1) {
                        C1601o.t(arrayList4, new b());
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1848x() {
        t a5 = K.a(E.a.f21883a);
        this.f18926a = a5;
        this.f18927b = a5;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(android.content.Context r11, com.uptodown.activities.C1848x.a r12, boolean r13, V2.d r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.uptodown.activities.C1848x.d
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.uptodown.activities.x$d r0 = (com.uptodown.activities.C1848x.d) r0
            int r1 = r0.f18950d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f18950d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.x$d r0 = new com.uptodown.activities.x$d
            r0.<init>(r10, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f18948b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f18950d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r11 = r0.f18947a
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            R2.n.b(r14)
            return r11
        L_0x002d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0035:
            R2.n.b(r14)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            o3.G r14 = o3.Y.b()
            com.uptodown.activities.x$e r4 = new com.uptodown.activities.x$e
            r9 = 0
            r5 = r11
            r7 = r12
            r8 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f18947a = r6
            r0.f18950d = r3
            java.lang.Object r11 = o3.C0977g.g(r14, r4, r0)
            if (r11 != r1) goto L_0x0055
            return r1
        L_0x0055:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.C1848x.g(android.content.Context, com.uptodown.activities.x$a, boolean, V2.d):java.lang.Object");
    }

    public final void c(Context context, C2039G g4, d3.a aVar) {
        m.e(context, "context");
        m.e(g4, "preRegister");
        m.e(aVar, "callback");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new b(context, g4, aVar, (V2.d) null), 2, (Object) null);
    }

    public final void d(Context context, a aVar, boolean z4, boolean z5) {
        m.e(context, "context");
        m.e(aVar, "sortByActive");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new c(this, z5, context, aVar, z4, (V2.d) null), 2, (Object) null);
    }

    public final I e() {
        return this.f18927b;
    }

    public final t f() {
        return this.f18928c;
    }

    public final void h(boolean z4) {
        this.f18929d = z4;
    }

    public final void i(boolean z4) {
        this.f18930e = z4;
    }
}
