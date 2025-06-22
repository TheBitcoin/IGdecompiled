package com.uptodown.activities;

import R2.n;
import R2.s;
import V2.d;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import d3.p;
import g2.N;
import g2.U;
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

public final class S extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f18338a;

    /* renamed from: b  reason: collision with root package name */
    private final I f18339b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final t f18340c;

    /* renamed from: d  reason: collision with root package name */
    private final I f18341d;

    /* renamed from: e  reason: collision with root package name */
    private final t f18342e = K.a(new U());

    /* renamed from: f  reason: collision with root package name */
    private t f18343f = K.a(Boolean.FALSE);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f18344g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f18345h;

    /* renamed from: i  reason: collision with root package name */
    private int f18346i;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final U f18347a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f18348b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f18349c;

        public a(U u4, ArrayList arrayList, boolean z4) {
            m.e(arrayList, "reviews");
            this.f18347a = u4;
            this.f18348b = arrayList;
            this.f18349c = z4;
        }

        public final ArrayList a() {
            return this.f18348b;
        }

        public final U b() {
            return this.f18347a;
        }

        public final boolean c() {
            return this.f18349c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.f18347a, aVar.f18347a) && m.a(this.f18348b, aVar.f18348b) && this.f18349c == aVar.f18349c;
        }

        public int hashCode() {
            U u4 = this.f18347a;
            return ((((u4 == null ? 0 : u4.hashCode()) * 31) + this.f18348b.hashCode()) * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f18349c);
        }

        public String toString() {
            return "UserCommentsData(user=" + this.f18347a + ", reviews=" + this.f18348b + ", userExists=" + this.f18349c + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18350a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ S f18351b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f18352c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(S s4, Context context, d dVar) {
            super(2, dVar);
            this.f18351b = s4;
            this.f18352c = context;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f18351b, this.f18352c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18350a == 0) {
                n.b(obj);
                this.f18351b.m(true);
                ArrayList arrayList = new ArrayList();
                L l4 = new L(this.f18352c);
                String g4 = ((U) this.f18351b.k().getValue()).g();
                m.b(g4);
                g2.L t02 = l4.t0(g4, 20, this.f18351b.i());
                if (!t02.b() && t02.e() != null) {
                    JSONObject e5 = t02.e();
                    m.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null) {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("user");
                        if (optJSONObject2 != null) {
                            ((U) this.f18351b.k().getValue()).k(optJSONObject2);
                        }
                        JSONArray optJSONArray = optJSONObject.optJSONArray("comments");
                        if (optJSONArray == null || optJSONArray.length() <= 0) {
                            this.f18351b.f().setValue(kotlin.coroutines.jvm.internal.b.a(true));
                        } else {
                            int length = optJSONArray.length();
                            for (int i4 = 0; i4 < length; i4++) {
                                N.b bVar = N.f20413o;
                                JSONObject jSONObject = optJSONArray.getJSONObject(i4);
                                m.d(jSONObject, "getJSONObject(...)");
                                arrayList.add(bVar.g(jSONObject));
                            }
                        }
                    }
                } else if (t02.f() == 404) {
                    this.f18351b.f18344g = false;
                }
                S s4 = this.f18351b;
                s4.n(s4.i() + arrayList.size());
                this.f18351b.f18338a.setValue(new E.c(new a((U) this.f18351b.k().getValue(), arrayList, this.f18351b.f18344g)));
                this.f18351b.m(false);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18353a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ N f18354b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f18355c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ S f18356d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(N n4, Context context, S s4, d dVar) {
            super(2, dVar);
            this.f18354b = n4;
            this.f18355c = context;
            this.f18356d = s4;
        }

        public final d create(Object obj, d dVar) {
            return new c(this.f18354b, this.f18355c, this.f18356d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18353a;
            if (i4 == 0) {
                n.b(obj);
                N.b bVar = N.f20413o;
                N n4 = this.f18354b;
                Context context = this.f18355c;
                this.f18353a = 1;
                obj = bVar.c(n4, context, this);
                if (obj == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f18356d.f18340c.setValue(new E.c(new N.c(this.f18354b, ((Number) obj).intValue())));
            return s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public S() {
        E.a aVar = E.a.f21883a;
        t a5 = K.a(aVar);
        this.f18338a = a5;
        this.f18339b = a5;
        t a6 = K.a(aVar);
        this.f18340c = a6;
        this.f18341d = a6;
    }

    public final void e(Context context) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new b(this, context, (d) null), 2, (Object) null);
    }

    public final t f() {
        return this.f18343f;
    }

    public final I g() {
        return this.f18339b;
    }

    public final boolean h() {
        return this.f18345h;
    }

    public final int i() {
        return this.f18346i;
    }

    public final I j() {
        return this.f18341d;
    }

    public final t k() {
        return this.f18342e;
    }

    public final void l(Context context, N n4) {
        m.e(context, "context");
        m.e(n4, "review");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new c(n4, context, this, (d) null), 2, (Object) null);
    }

    public final void m(boolean z4) {
        this.f18345h = z4;
    }

    public final void n(int i4) {
        this.f18346i = i4;
    }
}
