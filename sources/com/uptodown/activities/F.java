package com.uptodown.activities;

import R2.n;
import R2.s;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.privacysandbox.ads.adservices.adselection.u;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import d3.p;
import g2.C2042J;
import g2.L;
import g2.N;
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

public final class F extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f17599a;

    /* renamed from: b  reason: collision with root package name */
    private final I f17600b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final t f17601c;

    /* renamed from: d  reason: collision with root package name */
    private final I f17602d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final t f17603e;

    /* renamed from: f  reason: collision with root package name */
    private final I f17604f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final t f17605g;

    /* renamed from: h  reason: collision with root package name */
    private final I f17606h;

    /* renamed from: i  reason: collision with root package name */
    private t f17607i = K.a("");

    /* renamed from: j  reason: collision with root package name */
    private t f17608j = K.a("");

    /* renamed from: k  reason: collision with root package name */
    private t f17609k = K.a((Object) null);

    /* renamed from: l  reason: collision with root package name */
    private boolean f17610l = true;

    /* renamed from: m  reason: collision with root package name */
    private boolean f17611m;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f17612a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f17613b;

        public a(ArrayList arrayList, boolean z4) {
            m.e(arrayList, "replies");
            this.f17612a = arrayList;
            this.f17613b = z4;
        }

        public final boolean a() {
            return this.f17613b;
        }

        public final ArrayList b() {
            return this.f17612a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.f17612a, aVar.f17612a) && this.f17613b == aVar.f17613b;
        }

        public int hashCode() {
            return (this.f17612a.hashCode() * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f17613b);
        }

        public String toString() {
            return "RepliesData(replies=" + this.f17612a + ", moreDataAdded=" + this.f17613b + ')';
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final C2042J f17614a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17615b;

        public b(C2042J j4, int i4) {
            m.e(j4, "reply");
            this.f17614a = j4;
            this.f17615b = i4;
        }

        public final int a() {
            return this.f17615b;
        }

        public final C2042J b() {
            return this.f17614a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return m.a(this.f17614a, bVar.f17614a) && this.f17615b == bVar.f17615b;
        }

        public int hashCode() {
            return (this.f17614a.hashCode() * 31) + this.f17615b;
        }

        public String toString() {
            return "ReplyLikedData(reply=" + this.f17614a + ", likedSuccess=" + this.f17615b + ')';
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final int f17616a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17617b;

        /* renamed from: c  reason: collision with root package name */
        private final String f17618c;

        /* renamed from: d  reason: collision with root package name */
        private final long f17619d;

        /* renamed from: e  reason: collision with root package name */
        private final String f17620e;

        public c(int i4, int i5, String str, long j4, String str2) {
            m.e(str, MimeTypes.BASE_TYPE_TEXT);
            this.f17616a = i4;
            this.f17617b = i5;
            this.f17618c = str;
            this.f17619d = j4;
            this.f17620e = str2;
        }

        public final String a() {
            return this.f17620e;
        }

        public final int b() {
            return this.f17617b;
        }

        public final int c() {
            return this.f17616a;
        }

        public final String d() {
            return this.f17618c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f17616a == cVar.f17616a && this.f17617b == cVar.f17617b && m.a(this.f17618c, cVar.f17618c) && this.f17619d == cVar.f17619d && m.a(this.f17620e, cVar.f17620e);
        }

        public int hashCode() {
            int hashCode = ((((((this.f17616a * 31) + this.f17617b) * 31) + this.f17618c.hashCode()) * 31) + u.a(this.f17619d)) * 31;
            String str = this.f17620e;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "SendReplyData(success=" + this.f17616a + ", statusCode=" + this.f17617b + ", text=" + this.f17618c + ", reviewID=" + this.f17619d + ", msg=" + this.f17620e + ')';
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17621a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ F f17622b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f17623c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f17624d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(F f4, Context context, long j4, V2.d dVar) {
            super(2, dVar);
            this.f17622b = f4;
            this.f17623c = context;
            this.f17624d = j4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f17622b, this.f17623c, this.f17624d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            d dVar;
            Object c5 = W2.b.c();
            int i4 = this.f17621a;
            if (i4 == 0) {
                n.b(obj);
                this.f17622b.u(false);
                F f4 = this.f17622b;
                Context context = this.f17623c;
                long j4 = this.f17624d;
                this.f17621a = 1;
                dVar = this;
                obj = f4.n(context, j4, 0, dVar);
                if (obj == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
                dVar = this;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dVar.f17622b.f17599a.setValue(new E.c(new a((ArrayList) obj, false)));
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17625a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ F f17626b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f17627c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f17628d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f17629e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(F f4, Context context, long j4, int i4, V2.d dVar) {
            super(2, dVar);
            this.f17626b = f4;
            this.f17627c = context;
            this.f17628d = j4;
            this.f17629e = i4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f17626b, this.f17627c, this.f17628d, this.f17629e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            e eVar;
            Object c5 = W2.b.c();
            int i4 = this.f17625a;
            if (i4 == 0) {
                n.b(obj);
                F f4 = this.f17626b;
                Context context = this.f17627c;
                long j4 = this.f17628d;
                int i5 = this.f17629e;
                this.f17625a = 1;
                eVar = this;
                obj = f4.n(context, j4, i5, eVar);
                if (obj == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
                eVar = this;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ArrayList arrayList = (ArrayList) obj;
            if (!arrayList.isEmpty()) {
                eVar.f17626b.f17599a.setValue(new E.c(new a(arrayList, true)));
            } else {
                eVar.f17626b.f17599a.setValue(E.b.f21884a);
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17630a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ F f17631b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f17632c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f17633d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f17634e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(F f4, Context context, long j4, int i4, V2.d dVar) {
            super(2, dVar);
            this.f17631b = f4;
            this.f17632c = context;
            this.f17633d = j4;
            this.f17634e = i4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f17631b, this.f17632c, this.f17633d, this.f17634e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17630a == 0) {
                n.b(obj);
                this.f17631b.v(true);
                this.f17631b.f17599a.setValue(E.a.f21883a);
                ArrayList arrayList = new ArrayList();
                L b02 = new u2.L(this.f17632c).b0(this.f17633d, 10, this.f17634e);
                if (b02.b() || b02.e() == null) {
                    this.f17631b.u(true);
                } else {
                    JSONObject e5 = b02.e();
                    m.b(e5);
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (e5.optInt("success") == 1 && optJSONArray != null) {
                        arrayList.addAll(C2042J.f20379l.c(optJSONArray));
                        if (optJSONArray.length() == 0) {
                            this.f17631b.u(true);
                        }
                    }
                }
                this.f17631b.v(false);
                return arrayList;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17635a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2042J f17636b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f17637c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ F f17638d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(C2042J j4, Context context, F f4, V2.d dVar) {
            super(2, dVar);
            this.f17636b = j4;
            this.f17637c = context;
            this.f17638d = f4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f17636b, this.f17637c, this.f17638d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17635a;
            if (i4 == 0) {
                n.b(obj);
                C2042J.b bVar = C2042J.f20379l;
                C2042J j4 = this.f17636b;
                Context context = this.f17637c;
                this.f17635a = 1;
                obj = bVar.b(j4, context, this);
                if (obj == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f17638d.f17603e.setValue(new E.c(new b(this.f17636b, ((Number) obj).intValue())));
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17639a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ N f17640b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f17641c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ F f17642d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(N n4, Context context, F f4, V2.d dVar) {
            super(2, dVar);
            this.f17640b = n4;
            this.f17641c = context;
            this.f17642d = f4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new h(this.f17640b, this.f17641c, this.f17642d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17639a;
            if (i4 == 0) {
                n.b(obj);
                N.b bVar = N.f20413o;
                N n4 = this.f17640b;
                Context context = this.f17641c;
                this.f17639a = 1;
                obj = bVar.c(n4, context, this);
                if (obj == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f17642d.f17601c.setValue(new E.c(new N.c(this.f17640b, ((Number) obj).intValue())));
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((h) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class i extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17643a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f17644b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17645c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f17646d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ F f17647e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(Context context, String str, long j4, F f4, V2.d dVar) {
            super(2, dVar);
            this.f17644b = context;
            this.f17645c = str;
            this.f17646d = j4;
            this.f17647e = f4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new i(this.f17644b, this.f17645c, this.f17646d, this.f17647e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            int i4;
            W2.b.c();
            if (this.f17643a == 0) {
                n.b(obj);
                N.f20413o.f(this.f17644b, this.f17645c, String.valueOf(System.currentTimeMillis()));
                L S02 = new u2.L(this.f17644b).S0(this.f17646d, this.f17645c);
                String str2 = null;
                if (S02.b() || S02.e() == null) {
                    str = null;
                    i4 = 0;
                } else {
                    JSONObject e5 = S02.e();
                    m.b(e5);
                    int optInt = e5.optInt("success");
                    if (optInt == 0) {
                        str2 = S02.g(e5);
                    }
                    str = str2;
                    i4 = optInt;
                }
                this.f17647e.f17605g.setValue(new E.c(new c(i4, S02.f(), this.f17645c, this.f17646d, str)));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((i) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public F() {
        E.a aVar = E.a.f21883a;
        t a5 = K.a(aVar);
        this.f17599a = a5;
        this.f17600b = a5;
        t a6 = K.a(aVar);
        this.f17601c = a6;
        this.f17602d = a6;
        t a7 = K.a(aVar);
        this.f17603e = a7;
        this.f17604f = a7;
        t a8 = K.a(aVar);
        this.f17605g = a8;
        this.f17606h = a8;
    }

    /* access modifiers changed from: private */
    public final Object n(Context context, long j4, int i4, V2.d dVar) {
        return C0977g.g(Y.b(), new f(this, context, j4, i4, (V2.d) null), dVar);
    }

    public final void f(Context context, long j4) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new d(this, context, j4, (V2.d) null), 2, (Object) null);
    }

    public final void g(Context context, long j4, int i4) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new e(this, context, j4, i4, (V2.d) null), 2, (Object) null);
    }

    public final boolean h() {
        return this.f17611m;
    }

    public final t i() {
        return this.f17607i;
    }

    public final I j() {
        return this.f17600b;
    }

    public final I k() {
        return this.f17604f;
    }

    public final I l() {
        return this.f17602d;
    }

    public final boolean m() {
        return this.f17610l;
    }

    public final t o() {
        return this.f17609k;
    }

    public final I p() {
        return this.f17606h;
    }

    public final t q() {
        return this.f17608j;
    }

    public final void r(Context context, C2042J j4) {
        m.e(context, "context");
        m.e(j4, "reply");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new g(j4, context, this, (V2.d) null), 2, (Object) null);
    }

    public final void s(Context context, N n4) {
        m.e(context, "context");
        m.e(n4, "review");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new h(n4, context, this, (V2.d) null), 2, (Object) null);
    }

    public final void t(Context context, String str, long j4) {
        m.e(context, "context");
        m.e(str, MimeTypes.BASE_TYPE_TEXT);
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new i(context, str, j4, this, (V2.d) null), 2, (Object) null);
    }

    public final void u(boolean z4) {
        this.f17611m = z4;
    }

    public final void v(boolean z4) {
        this.f17610l = z4;
    }
}
