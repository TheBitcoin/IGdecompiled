package com.uptodown.activities;

import R2.n;
import R2.s;
import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import d3.p;
import g2.L;
import g2.U;
import java.util.regex.Pattern;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.Y;
import org.json.JSONObject;
import r3.I;
import r3.K;
import r3.t;
import u2.E;
import u2.x;

/* renamed from: com.uptodown.activities.l  reason: case insensitive filesystem */
public final class C1837l extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f18777a;

    /* renamed from: b  reason: collision with root package name */
    private final I f18778b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final t f18779c;

    /* renamed from: d  reason: collision with root package name */
    private final I f18780d;

    /* renamed from: com.uptodown.activities.l$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f18781a;

        /* renamed from: b  reason: collision with root package name */
        private final String f18782b;

        /* renamed from: c  reason: collision with root package name */
        private final String f18783c;

        public a(int i4, String str, String str2) {
            this.f18781a = i4;
            this.f18782b = str;
            this.f18783c = str2;
        }

        public final String a() {
            return this.f18782b;
        }

        public final String b() {
            return this.f18783c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f18781a == aVar.f18781a && m.a(this.f18782b, aVar.f18782b) && m.a(this.f18783c, aVar.f18783c);
        }

        public int hashCode() {
            int i4 = this.f18781a * 31;
            String str = this.f18782b;
            int i5 = 0;
            int hashCode = (i4 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f18783c;
            if (str2 != null) {
                i5 = str2.hashCode();
            }
            return hashCode + i5;
        }

        public String toString() {
            return "LoginData(loginResult=" + this.f18781a + ", loginMessage=" + this.f18782b + ", regErrors=" + this.f18783c + ')';
        }
    }

    /* renamed from: com.uptodown.activities.l$b */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f18784a;

        /* renamed from: b  reason: collision with root package name */
        private final String f18785b;

        /* renamed from: c  reason: collision with root package name */
        private final String f18786c;

        public b(int i4, String str, String str2) {
            this.f18784a = i4;
            this.f18785b = str;
            this.f18786c = str2;
        }

        public final String a() {
            return this.f18786c;
        }

        public final String b() {
            return this.f18785b;
        }

        public final int c() {
            return this.f18784a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f18784a == bVar.f18784a && m.a(this.f18785b, bVar.f18785b) && m.a(this.f18786c, bVar.f18786c);
        }

        public int hashCode() {
            int i4 = this.f18784a * 31;
            String str = this.f18785b;
            int i5 = 0;
            int hashCode = (i4 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f18786c;
            if (str2 != null) {
                i5 = str2.hashCode();
            }
            return hashCode + i5;
        }

        public String toString() {
            return "SignUpData(success=" + this.f18784a + ", signUpMessage=" + this.f18785b + ", regErrors=" + this.f18786c + ')';
        }
    }

    /* renamed from: com.uptodown.activities.l$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18787a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1837l f18788b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f18789c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f18790d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f18791e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C f18792f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ A f18793g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ C f18794h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ C f18795i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C1837l lVar, Context context, String str, String str2, C c5, A a5, C c6, C c7, V2.d dVar) {
            super(2, dVar);
            this.f18788b = lVar;
            this.f18789c = context;
            this.f18790d = str;
            this.f18791e = str2;
            this.f18792f = c5;
            this.f18793g = a5;
            this.f18794h = c6;
            this.f18795i = c7;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f18788b, this.f18789c, this.f18790d, this.f18791e, this.f18792f, this.f18793g, this.f18794h, this.f18795i, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18787a == 0) {
                n.b(obj);
                this.f18788b.f18777a.setValue(E.a.f21883a);
                L K02 = new u2.L(this.f18789c).K0(this.f18790d, this.f18791e);
                if (K02.e() != null) {
                    JSONObject e5 = K02.e();
                    m.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null) {
                        C c5 = this.f18792f;
                        U u4 = new U();
                        u4.e(this.f18789c, optJSONObject);
                        c5.f20968a = u4;
                        String J4 = com.uptodown.activities.preferences.a.f18818a.J(this.f18789c);
                        if (J4 == null || J4.length() == 0) {
                            U.f20468m.b(this.f18789c);
                        } else {
                            U u5 = (U) this.f18792f.f20968a;
                            if (u5 != null) {
                                u5.p(this.f18789c);
                            }
                            this.f18793g.f20966a = 1;
                        }
                        if (!optJSONObject.isNull("message")) {
                            this.f18794h.f20968a = optJSONObject.optString("message");
                        }
                    }
                    this.f18795i.f20968a = K02.g(e5);
                }
                if (this.f18792f.f20968a != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("type", "success");
                    bundle.putString("loginSource", "signin");
                    new x(this.f18789c).d("login", bundle);
                } else {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("responseCode", String.valueOf(K02.f()));
                    String c6 = K02.c();
                    if (!(c6 == null || c6.length() == 0)) {
                        String c7 = K02.c();
                        m.b(c7);
                        bundle2.putString("exception", c7);
                    }
                    bundle2.putString("type", "fail");
                    bundle2.putString("loginSource", "signin");
                    new x(this.f18789c).d("login", bundle2);
                }
                this.f18788b.f18777a.setValue(new E.c(new a(this.f18793g.f20966a, (String) this.f18794h.f20968a, (String) this.f18795i.f20968a)));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.activities.l$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18796a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1837l f18797b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f18798c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f18799d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f18800e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f18801f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ A f18802g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ C f18803h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ C f18804i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C1837l lVar, Context context, String str, String str2, String str3, A a5, C c5, C c6, V2.d dVar) {
            super(2, dVar);
            this.f18797b = lVar;
            this.f18798c = context;
            this.f18799d = str;
            this.f18800e = str2;
            this.f18801f = str3;
            this.f18802g = a5;
            this.f18803h = c5;
            this.f18804i = c6;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f18797b, this.f18798c, this.f18799d, this.f18800e, this.f18801f, this.f18802g, this.f18803h, this.f18804i, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18796a == 0) {
                n.b(obj);
                this.f18797b.f18779c.setValue(E.a.f21883a);
                L f12 = new u2.L(this.f18798c).f1(this.f18799d, this.f18800e, this.f18801f);
                if (f12.e() != null) {
                    JSONObject e5 = f12.e();
                    m.b(e5);
                    if (!e5.isNull("success")) {
                        this.f18802g.f20966a = e5.optInt("success");
                    }
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null && !optJSONObject.isNull("message")) {
                        this.f18803h.f20968a = optJSONObject.optString("message");
                    }
                    this.f18804i.f20968a = f12.g(e5);
                }
                if (this.f18802g.f20966a == 1) {
                    Bundle bundle = new Bundle();
                    bundle.putString("type", "success");
                    bundle.putString("loginSource", "signup");
                    new x(this.f18798c).d("login", bundle);
                } else {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("type", "fail");
                    bundle2.putString("loginSource", "signup");
                    bundle2.putString("responseCode", String.valueOf(f12.f()));
                    if (f12.c() != null) {
                        String c5 = f12.c();
                        m.b(c5);
                        bundle2.putString("exception", c5);
                    }
                    new x(this.f18798c).d("login", bundle2);
                }
                this.f18797b.f18779c.setValue(new E.c(new b(this.f18802g.f20966a, (String) this.f18803h.f20968a, (String) this.f18804i.f20968a)));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1837l() {
        E.b bVar = E.b.f21884a;
        t a5 = K.a(bVar);
        this.f18777a = a5;
        this.f18778b = a5;
        t a6 = K.a(bVar);
        this.f18779c = a6;
        this.f18780d = a6;
    }

    public final void c(Context context, String str, String str2) {
        m.e(context, "context");
        m.e(str, "username");
        m.e(str2, "password");
        A a5 = new A();
        a5.f20966a = -2;
        C c5 = new C();
        C c6 = new C();
        C c7 = new C();
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new c(this, context, str, str2, c7, a5, c5, c6, (V2.d) null), 2, (Object) null);
    }

    public final void d(Context context, String str, String str2, String str3) {
        m.e(context, "context");
        m.e(str, "username");
        m.e(str2, NotificationCompat.CATEGORY_EMAIL);
        String str4 = str3;
        m.e(str4, "pass");
        C c5 = new C();
        A a5 = new A();
        C c6 = new C();
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new d(this, context, str, str4, str2, a5, c5, c6, (V2.d) null), 2, (Object) null);
    }

    public final I e() {
        return this.f18778b;
    }

    public final I f() {
        return this.f18780d;
    }

    public final boolean g(String str, String str2) {
        m.e(str, "username");
        m.e(str2, "password");
        if (str.length() <= 0 || str2.length() <= 0) {
            return false;
        }
        return true;
    }

    public final boolean h(String str, String str2, String str3) {
        m.e(str, "username");
        m.e(str2, NotificationCompat.CATEGORY_EMAIL);
        m.e(str3, "password");
        if (str.length() <= 0 || str2.length() <= 0 || str3.length() <= 5) {
            return false;
        }
        return true;
    }

    public final boolean i(String str) {
        m.e(str, NotificationCompat.CATEGORY_EMAIL);
        return Pattern.compile("^(([^<>()\\[\\]\\\\.,;:\\s@“]+(\\.[^<>()\\[\\]\\\\.,;:\\s@“]+)*)|(“.+“))@((\\[\\d{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").matcher(str).matches();
    }
}
