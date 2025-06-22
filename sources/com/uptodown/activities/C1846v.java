package com.uptodown.activities;

import R2.n;
import R2.s;
import V2.d;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import d3.p;
import g2.C2036D;
import g2.L;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.Y;
import org.json.JSONArray;
import org.json.JSONObject;
import r3.I;
import r3.K;
import r3.t;
import u2.E;

/* renamed from: com.uptodown.activities.v  reason: case insensitive filesystem */
public final class C1846v extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f18897a;

    /* renamed from: b  reason: collision with root package name */
    private final I f18898b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final t f18899c = K.a(new C2036D());

    /* renamed from: d  reason: collision with root package name */
    private final t f18900d = K.a(0L);

    /* renamed from: e  reason: collision with root package name */
    private final t f18901e = K.a("");

    /* renamed from: f  reason: collision with root package name */
    private boolean f18902f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18903g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f18904h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f18905i = 2;

    /* renamed from: com.uptodown.activities.v$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final C2036D f18906a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f18907b;

        public a(C2036D d5, boolean z4) {
            m.e(d5, "organization");
            this.f18906a = d5;
            this.f18907b = z4;
        }

        public final boolean a() {
            return this.f18907b;
        }

        public final C2036D b() {
            return this.f18906a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.f18906a, aVar.f18906a) && this.f18907b == aVar.f18907b;
        }

        public int hashCode() {
            return (this.f18906a.hashCode() * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f18907b);
        }

        public String toString() {
            return "OrganizationData(organization=" + this.f18906a + ", moreDataAdded=" + this.f18907b + ')';
        }
    }

    /* renamed from: com.uptodown.activities.v$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18908a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1846v f18909b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f18910c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1846v vVar, Context context, d dVar) {
            super(2, dVar);
            this.f18909b = vVar;
            this.f18910c = context;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f18909b, this.f18910c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18908a == 0) {
                n.b(obj);
                this.f18909b.n(true);
                this.f18909b.m(false);
                L N4 = new u2.L(this.f18910c).N(((Number) this.f18909b.j().getValue()).longValue());
                if (!N4.b() && N4.e() != null) {
                    JSONObject e5 = N4.e();
                    m.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null) {
                        ((C2036D) this.f18909b.f18899c.getValue()).p(optJSONObject);
                    } else if (e5.optInt("success") == 1) {
                        this.f18909b.m(true);
                    }
                }
                this.f18909b.f18897a.setValue(new E.c(new a((C2036D) this.f18909b.f18899c.getValue(), false)));
                this.f18909b.n(false);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.activities.v$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18911a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1846v f18912b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f18913c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C1846v vVar, Context context, d dVar) {
            super(2, dVar);
            this.f18912b = vVar;
            this.f18913c = context;
        }

        public final d create(Object obj, d dVar) {
            return new c(this.f18912b, this.f18913c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18911a == 0) {
                n.b(obj);
                this.f18912b.f18897a.setValue(E.a.f21883a);
                this.f18912b.n(true);
                L M4 = new u2.L(this.f18913c).M(((Number) this.f18912b.j().getValue()).longValue(), this.f18912b.f18905i);
                if (M4.b() || M4.e() == null) {
                    this.f18912b.m(true);
                    this.f18912b.f18897a.setValue(E.b.f21884a);
                } else {
                    JSONObject e5 = M4.e();
                    m.b(e5);
                    if (!e5.isNull(DataSchemeDataSource.SCHEME_DATA)) {
                        JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                        if (optJSONArray != null) {
                            ((C2036D) this.f18912b.f18899c.getValue()).q(((C2036D) this.f18912b.f18899c.getValue()).o(optJSONArray));
                        }
                    } else if (M4.b() && M4.f() == 404) {
                        this.f18912b.m(true);
                        this.f18912b.f18897a.setValue(E.b.f21884a);
                    }
                    this.f18912b.f18897a.setValue(new E.c(new a((C2036D) this.f18912b.f18899c.getValue(), true)));
                    int a5 = this.f18912b.f18905i;
                    this.f18912b.f18905i = a5 + 1;
                    kotlin.coroutines.jvm.internal.b.b(a5);
                }
                this.f18912b.n(false);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1846v() {
        t a5 = K.a(E.a.f21883a);
        this.f18897a = a5;
        this.f18898b = a5;
    }

    public final void e(Context context) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new b(this, context, (d) null), 2, (Object) null);
    }

    public final void f(Context context) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new c(this, context, (d) null), 2, (Object) null);
    }

    public final boolean g() {
        return this.f18903g;
    }

    public final I h() {
        return this.f18898b;
    }

    public final boolean i() {
        return this.f18902f;
    }

    public final t j() {
        return this.f18900d;
    }

    public final t k() {
        return this.f18901e;
    }

    public final boolean l() {
        return this.f18904h;
    }

    public final void m(boolean z4) {
        this.f18903g = z4;
    }

    public final void n(boolean z4) {
        this.f18902f = z4;
    }

    public final void o(boolean z4) {
        this.f18904h = z4;
    }
}
