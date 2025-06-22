package com.uptodown.activities;

import R2.n;
import R2.s;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.privacysandbox.ads.adservices.adselection.u;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import d3.p;
import g2.L;
import g2.V;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.Y;
import org.json.JSONObject;
import r3.I;
import r3.K;
import r3.t;
import u2.E;

public final class T extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final t f18425a = K.a(new V());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final t f18426b;

    /* renamed from: c  reason: collision with root package name */
    private final I f18427c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final t f18428d;

    /* renamed from: e  reason: collision with root package name */
    private final I f18429e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final t f18430f;

    /* renamed from: g  reason: collision with root package name */
    private final I f18431g;

    /* renamed from: h  reason: collision with root package name */
    private final t f18432h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final V f18433a;

        public a(V v4) {
            m.e(v4, "userDevice");
            this.f18433a = v4;
        }

        public final V a() {
            return this.f18433a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && m.a(this.f18433a, ((a) obj).f18433a);
        }

        public int hashCode() {
            return this.f18433a.hashCode();
        }

        public String toString() {
            return "UserDeviceData(userDevice=" + this.f18433a + ')';
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f18434a;

        /* renamed from: b  reason: collision with root package name */
        private final String f18435b;

        /* renamed from: c  reason: collision with root package name */
        private final long f18436c;

        /* renamed from: d  reason: collision with root package name */
        private final String f18437d;

        public b(int i4, String str, long j4, String str2) {
            m.e(str2, "newName");
            this.f18434a = i4;
            this.f18435b = str;
            this.f18436c = j4;
            this.f18437d = str2;
        }

        public final String a() {
            return this.f18435b;
        }

        public final String b() {
            return this.f18437d;
        }

        public final int c() {
            return this.f18434a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f18434a == bVar.f18434a && m.a(this.f18435b, bVar.f18435b) && this.f18436c == bVar.f18436c && m.a(this.f18437d, bVar.f18437d);
        }

        public int hashCode() {
            int i4 = this.f18434a * 31;
            String str = this.f18435b;
            return ((((i4 + (str == null ? 0 : str.hashCode())) * 31) + u.a(this.f18436c)) * 31) + this.f18437d.hashCode();
        }

        public String toString() {
            return "UserDeviceRenameActionData(success=" + this.f18434a + ", msg=" + this.f18435b + ", deviceID=" + this.f18436c + ", newName=" + this.f18437d + ')';
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final int f18438a;

        /* renamed from: b  reason: collision with root package name */
        private final String f18439b;

        /* renamed from: c  reason: collision with root package name */
        private final String f18440c;

        public c(int i4, String str, String str2) {
            this.f18438a = i4;
            this.f18439b = str;
            this.f18440c = str2;
        }

        public final String a() {
            return this.f18440c;
        }

        public final String b() {
            return this.f18439b;
        }

        public final int c() {
            return this.f18438a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f18438a == cVar.f18438a && m.a(this.f18439b, cVar.f18439b) && m.a(this.f18440c, cVar.f18440c);
        }

        public int hashCode() {
            int i4 = this.f18438a * 31;
            String str = this.f18439b;
            int i5 = 0;
            int hashCode = (i4 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f18440c;
            if (str2 != null) {
                i5 = str2.hashCode();
            }
            return hashCode + i5;
        }

        public String toString() {
            return "UserDeviceUnlinkActionData(success=" + this.f18438a + ", msg=" + this.f18439b + ", identifier=" + this.f18440c + ')';
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18441a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f18442b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ V f18443c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ T f18444d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, V v4, T t4, V2.d dVar) {
            super(2, dVar);
            this.f18442b = context;
            this.f18443c = v4;
            this.f18444d = t4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f18442b, this.f18443c, this.f18444d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18441a == 0) {
                n.b(obj);
                L w02 = new u2.L(this.f18442b).w0(String.valueOf(this.f18443c.b()));
                if (!w02.b() && w02.e() != null) {
                    JSONObject e5 = w02.e();
                    m.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (e5.optInt("success") == 1 && optJSONObject != null) {
                        V.f20481l.b(this.f18443c, optJSONObject);
                    }
                }
                this.f18444d.h().setValue(this.f18443c);
                this.f18444d.f18426b.setValue(new E.c(new a(this.f18443c)));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18445a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f18446b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f18447c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f18448d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ T f18449e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Context context, long j4, String str, T t4, V2.d dVar) {
            super(2, dVar);
            this.f18446b = context;
            this.f18447c = j4;
            this.f18448d = str;
            this.f18449e = t4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f18446b, this.f18447c, this.f18448d, this.f18449e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18445a == 0) {
                n.b(obj);
                L j12 = new u2.L(this.f18446b).j1(String.valueOf(this.f18447c), this.f18448d);
                if (j12.e() != null) {
                    JSONObject e5 = j12.e();
                    m.b(e5);
                    int optInt = e5.optInt("success");
                    if (j12.b()) {
                        this.f18449e.f18428d.setValue(new E.c(new b(optInt, j12.g(e5), this.f18447c, this.f18448d)));
                    } else {
                        String string = this.f18446b.getString(R.string.device_rename);
                        m.d(string, "getString(...)");
                        this.f18449e.f18428d.setValue(new E.c(new b(optInt, string, this.f18447c, this.f18448d)));
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

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18450a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f18451b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f18452c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ T f18453d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f18454e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(Context context, long j4, T t4, String str, V2.d dVar) {
            super(2, dVar);
            this.f18451b = context;
            this.f18452c = j4;
            this.f18453d = t4;
            this.f18454e = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f18451b, this.f18452c, this.f18453d, this.f18454e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18450a == 0) {
                n.b(obj);
                L i12 = new u2.L(this.f18451b).i1(String.valueOf(this.f18452c));
                if (i12.e() != null) {
                    JSONObject e5 = i12.e();
                    m.b(e5);
                    int optInt = e5.optInt("success");
                    if (i12.b()) {
                        this.f18453d.f18430f.setValue(new E.c(new c(optInt, i12.g(e5), this.f18454e)));
                    } else {
                        String string = this.f18451b.getString(R.string.unlinked_device);
                        m.d(string, "getString(...)");
                        this.f18453d.f18430f.setValue(new E.c(new c(optInt, string, this.f18454e)));
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

    public T() {
        t a5 = K.a(E.a.f21883a);
        this.f18426b = a5;
        this.f18427c = a5;
        E.b bVar = E.b.f21884a;
        t a6 = K.a(bVar);
        this.f18428d = a6;
        this.f18429e = a6;
        t a7 = K.a(bVar);
        this.f18430f = a7;
        this.f18431g = a7;
        this.f18432h = K.a(Boolean.TRUE);
    }

    public final void d(Context context, V v4) {
        m.e(context, "context");
        m.e(v4, "userDevice");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new d(context, v4, this, (V2.d) null), 2, (Object) null);
    }

    public final I e() {
        return this.f18427c;
    }

    public final I f() {
        return this.f18429e;
    }

    public final I g() {
        return this.f18431g;
    }

    public final t h() {
        return this.f18425a;
    }

    public final t i() {
        return this.f18432h;
    }

    public final void j(Context context, long j4, String str) {
        m.e(context, "context");
        m.e(str, "newName");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new e(context, j4, str, this, (V2.d) null), 2, (Object) null);
    }

    public final void k(Context context, long j4, String str) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new f(context, j4, this, str, (V2.d) null), 2, (Object) null);
    }
}
