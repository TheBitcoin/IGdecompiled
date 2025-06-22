package com.uptodown.activities;

import R2.n;
import R2.s;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import d3.p;
import g2.C2050h;
import g2.N;
import java.util.ArrayList;
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
import u2.L;

public final class G extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f17675a;

    /* renamed from: b  reason: collision with root package name */
    private final I f17676b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final t f17677c;

    /* renamed from: d  reason: collision with root package name */
    private final I f17678d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final t f17679e;

    /* renamed from: f  reason: collision with root package name */
    private final I f17680f;

    /* renamed from: g  reason: collision with root package name */
    private t f17681g = K.a((Object) null);

    /* renamed from: h  reason: collision with root package name */
    private t f17682h = K.a((Object) null);

    /* renamed from: i  reason: collision with root package name */
    private t f17683i = K.a("date");

    /* renamed from: j  reason: collision with root package name */
    private t f17684j = K.a(-1);

    /* renamed from: k  reason: collision with root package name */
    private boolean f17685k = true;

    /* renamed from: l  reason: collision with root package name */
    private boolean f17686l;

    /* renamed from: m  reason: collision with root package name */
    private int f17687m;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f17688a;

        public a(ArrayList arrayList) {
            m.e(arrayList, "reviews");
            this.f17688a = arrayList;
        }

        public final ArrayList a() {
            return this.f17688a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && m.a(this.f17688a, ((a) obj).f17688a);
        }

        public int hashCode() {
            return this.f17688a.hashCode();
        }

        public String toString() {
            return "ReviewsData(reviews=" + this.f17688a + ')';
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f17689a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17690b;

        public b(int i4, int i5) {
            this.f17689a = i4;
            this.f17690b = i5;
        }

        public final int a() {
            return this.f17690b;
        }

        public final int b() {
            return this.f17689a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f17689a == bVar.f17689a && this.f17690b == bVar.f17690b;
        }

        public int hashCode() {
            return (this.f17689a * 31) + this.f17690b;
        }

        public String toString() {
            return "SendReviewData(success=" + this.f17689a + ", statusCode=" + this.f17690b + ')';
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17691a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ G f17692b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f17693c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(G g4, Context context, V2.d dVar) {
            super(2, dVar);
            this.f17692b = g4;
            this.f17693c = context;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f17692b, this.f17693c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17691a == 0) {
                n.b(obj);
                this.f17692b.f17675a.setValue(E.a.f21883a);
                ArrayList arrayList = new ArrayList();
                L l4 = new L(this.f17693c);
                Object value = this.f17692b.e().getValue();
                m.b(value);
                g2.L c02 = l4.c0(((C2050h) value).e(), 20, this.f17692b.j(), (String) this.f17692b.k().getValue());
                if (c02.b() || c02.e() == null) {
                    this.f17692b.q(false);
                } else {
                    JSONObject e5 = c02.e();
                    m.b(e5);
                    int optInt = e5.optInt("success");
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (optInt == 1 && optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            N.b bVar = N.f20413o;
                            JSONObject jSONObject = optJSONArray.getJSONObject(i4);
                            m.d(jSONObject, "getJSONObject(...)");
                            arrayList.add(bVar.a(jSONObject));
                        }
                    }
                }
                this.f17692b.f17675a.setValue(new E.c(new a(arrayList)));
                G g4 = this.f17692b;
                g4.s(g4.j() + arrayList.size());
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17694a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ N f17695b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f17696c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ G f17697d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(N n4, Context context, G g4, V2.d dVar) {
            super(2, dVar);
            this.f17695b = n4;
            this.f17696c = context;
            this.f17697d = g4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f17695b, this.f17696c, this.f17697d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17694a;
            if (i4 == 0) {
                n.b(obj);
                N.b bVar = N.f20413o;
                N n4 = this.f17695b;
                Context context = this.f17696c;
                this.f17694a = 1;
                obj = bVar.c(n4, context, this);
                if (obj == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f17697d.f17679e.setValue(new E.c(new N.c(this.f17695b, ((Number) obj).intValue())));
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17698a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f17699b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17700c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ G f17701d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Context context, String str, G g4, V2.d dVar) {
            super(2, dVar);
            this.f17699b = context;
            this.f17700c = str;
            this.f17701d = g4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f17699b, this.f17700c, this.f17701d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            int i4;
            W2.b.c();
            if (this.f17698a == 0) {
                n.b(obj);
                N.b bVar = N.f20413o;
                int i5 = 0;
                if (!bVar.b(this.f17699b, this.f17700c)) {
                    bVar.f(this.f17699b, this.f17700c, String.valueOf(System.currentTimeMillis()));
                    L l4 = new L(this.f17699b);
                    N n4 = new N();
                    n4.x(this.f17700c);
                    n4.w(((Number) this.f17701d.m().getValue()).intValue());
                    Object value = this.f17701d.e().getValue();
                    m.b(value);
                    g2.L T02 = l4.T0(((C2050h) value).e(), n4);
                    i4 = T02.f();
                    if (!T02.b() && T02.e() != null) {
                        JSONObject e5 = T02.e();
                        m.b(e5);
                        i5 = e5.optInt("success");
                    }
                } else {
                    i4 = 0;
                }
                this.f17701d.f17677c.setValue(new E.c(new b(i5, i4)));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public G() {
        t a5 = K.a(E.a.f21883a);
        this.f17675a = a5;
        this.f17676b = a5;
        E.b bVar = E.b.f21884a;
        t a6 = K.a(bVar);
        this.f17677c = a6;
        this.f17678d = a6;
        t a7 = K.a(bVar);
        this.f17679e = a7;
        this.f17680f = a7;
    }

    public final void d(Context context) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new c(this, context, (V2.d) null), 2, (Object) null);
    }

    public final t e() {
        return this.f17681g;
    }

    public final I f() {
        return this.f17676b;
    }

    public final boolean g() {
        return this.f17685k;
    }

    public final boolean h() {
        return this.f17686l;
    }

    public final t i() {
        return this.f17682h;
    }

    public final int j() {
        return this.f17687m;
    }

    public final t k() {
        return this.f17683i;
    }

    public final I l() {
        return this.f17680f;
    }

    public final t m() {
        return this.f17684j;
    }

    public final I n() {
        return this.f17678d;
    }

    public final void o(Context context, N n4) {
        m.e(context, "context");
        m.e(n4, "review");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new d(n4, context, this, (V2.d) null), 2, (Object) null);
    }

    public final void p(Context context, String str) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new e(context, str, this, (V2.d) null), 2, (Object) null);
    }

    public final void q(boolean z4) {
        this.f17685k = z4;
    }

    public final void r(boolean z4) {
        this.f17686l = z4;
    }

    public final void s(int i4) {
        this.f17687m = i4;
    }
}
