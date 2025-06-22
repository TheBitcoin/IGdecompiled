package com.uptodown.activities;

import R2.n;
import R2.s;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import d3.p;
import f2.Q;
import g2.C2050h;
import g2.L;
import g2.N;
import g2.U;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.Y;
import org.json.JSONArray;
import org.json.JSONObject;
import r3.I;
import r3.K;
import r3.t;
import u2.E;

public final class E extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f17575a;

    /* renamed from: b  reason: collision with root package name */
    private final I f17576b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final t f17577c;

    /* renamed from: d  reason: collision with root package name */
    private final I f17578d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final t f17579e;

    /* renamed from: f  reason: collision with root package name */
    private final I f17580f;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f17581a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f17582b;

        public a(ArrayList arrayList, ArrayList arrayList2) {
            m.e(arrayList, "recommendedApps");
            m.e(arrayList2, "userReviews");
            this.f17581a = arrayList;
            this.f17582b = arrayList2;
        }

        public final ArrayList a() {
            return this.f17581a;
        }

        public final ArrayList b() {
            return this.f17582b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.f17581a, aVar.f17581a) && m.a(this.f17582b, aVar.f17582b);
        }

        public int hashCode() {
            return (this.f17581a.hashCode() * 31) + this.f17582b.hashCode();
        }

        public String toString() {
            return "PublicProfileData(recommendedApps=" + this.f17581a + ", userReviews=" + this.f17582b + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f17583a;

        /* renamed from: b  reason: collision with root package name */
        int f17584b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f17585c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f17586d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ E f17587e;

        public static final class a implements Q {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ E f17588a;

            a(E e5) {
                this.f17588a = e5;
            }

            public void a() {
            }

            public void e(ArrayList arrayList) {
                m.e(arrayList, "userList");
                this.f17588a.f17577c.setValue(new E.c(arrayList));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, String str, E e5, V2.d dVar) {
            super(2, dVar);
            this.f17585c = context;
            this.f17586d = str;
            this.f17587e = e5;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f17585c, this.f17586d, this.f17587e, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0060, code lost:
            if (r6 == r0) goto L_0x0075;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r5.f17584b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0022
                if (r1 == r3) goto L_0x001e
                if (r1 != r2) goto L_0x0016
                java.lang.Object r0 = r5.f17583a
                java.util.ArrayList r0 = (java.util.ArrayList) r0
                R2.n.b(r6)
                goto L_0x0078
            L_0x0016:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x001e:
                R2.n.b(r6)
                goto L_0x0063
            L_0x0022:
                R2.n.b(r6)
                g2.U$b r6 = g2.U.f20468m
                android.content.Context r1 = r5.f17585c
                g2.U r6 = r6.e(r1)
                java.lang.String r1 = r5.f17586d
                if (r6 == 0) goto L_0x0036
                java.lang.String r6 = r6.g()
                goto L_0x0037
            L_0x0036:
                r6 = 0
            L_0x0037:
                boolean r6 = kotlin.jvm.internal.m.a(r1, r6)
                if (r6 == 0) goto L_0x0054
                b2.x r6 = new b2.x
                android.content.Context r1 = r5.f17585c
                com.uptodown.activities.E r4 = r5.f17587e
                o3.J r4 = androidx.lifecycle.ViewModelKt.getViewModelScope(r4)
                r6.<init>(r1, r4)
                com.uptodown.activities.E$b$a r1 = new com.uptodown.activities.E$b$a
                com.uptodown.activities.E r4 = r5.f17587e
                r1.<init>(r4)
                r6.i(r1)
            L_0x0054:
                com.uptodown.activities.E r6 = r5.f17587e
                android.content.Context r1 = r5.f17585c
                java.lang.String r4 = r5.f17586d
                r5.f17584b = r3
                java.lang.Object r6 = r6.j(r1, r4, r5)
                if (r6 != r0) goto L_0x0063
                goto L_0x0075
            L_0x0063:
                java.util.ArrayList r6 = (java.util.ArrayList) r6
                com.uptodown.activities.E r1 = r5.f17587e
                android.content.Context r3 = r5.f17585c
                java.lang.String r4 = r5.f17586d
                r5.f17583a = r6
                r5.f17584b = r2
                java.lang.Object r1 = r1.i(r3, r4, r5)
                if (r1 != r0) goto L_0x0076
            L_0x0075:
                return r0
            L_0x0076:
                r0 = r6
                r6 = r1
            L_0x0078:
                java.util.ArrayList r6 = (java.util.ArrayList) r6
                com.uptodown.activities.E r1 = r5.f17587e
                r3.t r1 = r1.f17575a
                u2.E$c r2 = new u2.E$c
                com.uptodown.activities.E$a r3 = new com.uptodown.activities.E$a
                r3.<init>(r6, r0)
                r2.<init>(r3)
                r1.setValue(r2)
                R2.s r6 = R2.s.f8222a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.E.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17589a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f17590b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17591c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, String str, V2.d dVar) {
            super(2, dVar);
            this.f17590b = context;
            this.f17591c = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f17590b, this.f17591c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            W2.b.c();
            if (this.f17589a == 0) {
                n.b(obj);
                ArrayList arrayList = new ArrayList();
                L Y4 = new u2.L(this.f17590b).Y(this.f17591c, 20, 0);
                if (!(Y4.b() || (d5 = Y4.d()) == null || d5.length() == 0)) {
                    String d6 = Y4.d();
                    m.b(d6);
                    JSONArray optJSONArray = new JSONObject(d6).optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            C2050h.b bVar = C2050h.f20600F0;
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                            m.d(optJSONObject, "optJSONObject(...)");
                            arrayList.add(C2050h.b.b(bVar, optJSONObject, (Context) null, 2, (Object) null));
                        }
                    }
                }
                return arrayList;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17592a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f17593b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17594c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, String str, V2.d dVar) {
            super(2, dVar);
            this.f17593b = context;
            this.f17594c = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f17593b, this.f17594c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            U u4;
            JSONArray jSONArray;
            String str;
            W2.b.c();
            if (this.f17592a == 0) {
                n.b(obj);
                ArrayList arrayList = new ArrayList();
                L t02 = new u2.L(this.f17593b).t0(this.f17594c, 10, 0);
                if (!t02.b() && t02.e() != null) {
                    JSONObject e5 = t02.e();
                    m.b(e5);
                    if (!e5.isNull(DataSchemeDataSource.SCHEME_DATA)) {
                        JSONObject jSONObject = e5.getJSONObject(DataSchemeDataSource.SCHEME_DATA);
                        if (!jSONObject.isNull("user")) {
                            u4 = new U();
                            JSONObject jSONObject2 = jSONObject.getJSONObject("user");
                            m.d(jSONObject2, "getJSONObject(...)");
                            u4.k(jSONObject2);
                        } else {
                            u4 = null;
                        }
                        if (!jSONObject.isNull("comments")) {
                            jSONArray = jSONObject.getJSONArray("comments");
                        } else {
                            jSONArray = null;
                        }
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int length = jSONArray.length();
                            for (int i4 = 0; i4 < length; i4++) {
                                N.b bVar = N.f20413o;
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i4);
                                m.d(jSONObject3, "getJSONObject(...)");
                                N g4 = bVar.g(jSONObject3);
                                if (u4 != null) {
                                    str = u4.h();
                                } else {
                                    str = null;
                                }
                                if (!(str == null || str.length() == 0)) {
                                    m.b(u4);
                                    g4.B(u4.h());
                                    if (u4.o()) {
                                        g4.z(1);
                                    }
                                }
                                arrayList.add(g4);
                            }
                        }
                    }
                }
                return arrayList;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17595a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ N f17596b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f17597c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ E f17598d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(N n4, Context context, E e5, V2.d dVar) {
            super(2, dVar);
            this.f17596b = n4;
            this.f17597c = context;
            this.f17598d = e5;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f17596b, this.f17597c, this.f17598d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17595a;
            if (i4 == 0) {
                n.b(obj);
                N.b bVar = N.f20413o;
                N n4 = this.f17596b;
                Context context = this.f17597c;
                this.f17595a = 1;
                obj = bVar.c(n4, context, this);
                if (obj == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f17598d.f17579e.setValue(new E.c(new N.c(this.f17596b, ((Number) obj).intValue())));
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public E() {
        t a5 = K.a(E.b.f21884a);
        this.f17575a = a5;
        this.f17576b = a5;
        E.a aVar = E.a.f21883a;
        t a6 = K.a(aVar);
        this.f17577c = a6;
        this.f17578d = a6;
        t a7 = K.a(aVar);
        this.f17579e = a7;
        this.f17580f = a7;
    }

    /* access modifiers changed from: private */
    public final Object i(Context context, String str, V2.d dVar) {
        return C0977g.g(Y.b(), new c(context, str, (V2.d) null), dVar);
    }

    /* access modifiers changed from: private */
    public final Object j(Context context, String str, V2.d dVar) {
        return C0977g.g(Y.b(), new d(context, str, (V2.d) null), dVar);
    }

    public final void f(Context context, String str) {
        m.e(context, "context");
        m.e(str, "userID");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new b(context, str, this, (V2.d) null), 2, (Object) null);
    }

    public final I g() {
        return this.f17580f;
    }

    public final I h() {
        return this.f17576b;
    }

    public final I k() {
        return this.f17578d;
    }

    public final void l(Context context, N n4) {
        m.e(context, "context");
        m.e(n4, "review");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new e(n4, context, this, (V2.d) null), 2, (Object) null);
    }
}
