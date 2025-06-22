package com.uptodown.activities;

import R2.n;
import R2.s;
import V2.d;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import d3.p;
import g2.L;
import g2.U;
import g2.Y;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import org.json.JSONArray;
import org.json.JSONObject;
import r3.I;
import r3.K;
import r3.t;
import u2.E;

public final class V extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f18614a;

    /* renamed from: b  reason: collision with root package name */
    private final I f18615b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final t f18616c;

    /* renamed from: d  reason: collision with root package name */
    private final I f18617d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f18618a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f18619b;

        /* renamed from: c  reason: collision with root package name */
        private final String f18620c;

        public a(int i4, boolean z4, String str) {
            this.f18618a = i4;
            this.f18619b = z4;
            this.f18620c = str;
        }

        public final boolean a() {
            return this.f18619b;
        }

        public final String b() {
            return this.f18620c;
        }

        public final int c() {
            return this.f18618a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f18618a == aVar.f18618a && this.f18619b == aVar.f18619b && m.a(this.f18620c, aVar.f18620c);
        }

        public int hashCode() {
            int a5 = ((this.f18618a * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f18619b)) * 31;
            String str = this.f18620c;
            return a5 + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "UsernameEditData(success=" + this.f18618a + ", error=" + this.f18619b + ", regErrors=" + this.f18620c + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18621a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ V f18622b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f18623c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f18624d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f18625e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C f18626f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ A f18627g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ U f18628h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f18629i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(V v4, Context context, String str, int i4, C c5, A a5, U u4, String str2, d dVar) {
            super(2, dVar);
            this.f18622b = v4;
            this.f18623c = context;
            this.f18624d = str;
            this.f18625e = i4;
            this.f18626f = c5;
            this.f18627g = a5;
            this.f18628h = u4;
            this.f18629i = str2;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f18622b, this.f18623c, this.f18624d, this.f18625e, this.f18626f, this.f18627g, this.f18628h, this.f18629i, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18621a == 0) {
                n.b(obj);
                this.f18622b.f18614a.setValue(E.a.f21883a);
                L g4 = new u2.L(this.f18623c).g(this.f18624d, this.f18625e);
                if (g4.e() != null) {
                    JSONObject e5 = g4.e();
                    m.b(e5);
                    this.f18626f.f20968a = g4.g(e5);
                    this.f18627g.f20966a = e5.optInt("success");
                    if (this.f18627g.f20966a == 1) {
                        U u4 = this.f18628h;
                        if (u4 != null) {
                            u4.u(this.f18624d);
                        }
                        U u5 = this.f18628h;
                        if (u5 != null) {
                            u5.x(this.f18629i);
                        }
                        U u6 = this.f18628h;
                        if (u6 != null) {
                            u6.p(this.f18623c);
                        }
                    }
                }
                this.f18622b.f18614a.setValue(new E.c(new a(this.f18627g.f20966a, g4.b(), (String) this.f18626f.f20968a)));
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
        int f18630a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f18631b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f18632c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ V f18633d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, ArrayList arrayList, V v4, d dVar) {
            super(2, dVar);
            this.f18631b = context;
            this.f18632c = arrayList;
            this.f18633d = v4;
        }

        public final d create(Object obj, d dVar) {
            return new c(this.f18631b, this.f18632c, this.f18633d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18630a == 0) {
                n.b(obj);
                L y02 = new u2.L(this.f18631b).y0();
                if (!y02.b() && y02.e() != null) {
                    JSONObject e5 = y02.e();
                    m.b(e5);
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            ArrayList arrayList = this.f18632c;
                            Y y4 = new Y();
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                            m.d(optJSONObject, "optJSONObject(...)");
                            y4.a(optJSONObject);
                            arrayList.add(y4);
                        }
                    }
                }
                this.f18633d.f18616c.setValue(this.f18632c);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public V() {
        t a5 = K.a(E.b.f21884a);
        this.f18614a = a5;
        this.f18615b = a5;
        t a6 = K.a(new ArrayList());
        this.f18616c = a6;
        this.f18617d = a6;
    }

    public final void c(Context context, String str, U u4, int i4, String str2) {
        m.e(context, "context");
        m.e(str, "newUsername");
        String str3 = str2;
        m.e(str3, "usernameFormat");
        A a5 = new A();
        C c5 = new C();
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), o3.Y.b(), (o3.L) null, new b(this, context, str, i4, c5, a5, u4, str3, (d) null), 2, (Object) null);
    }

    public final void d(Context context) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), o3.Y.b(), (o3.L) null, new c(context, new ArrayList(), this, (d) null), 2, (Object) null);
    }

    public final I e() {
        return this.f18615b;
    }

    public final I f() {
        return this.f18617d;
    }
}
