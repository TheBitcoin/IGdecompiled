package com.uptodown.activities;

import R2.n;
import R2.s;
import V2.d;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import d3.p;
import g2.L;
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

/* renamed from: com.uptodown.activities.w  reason: case insensitive filesystem */
public final class C1847w extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f18914a;

    /* renamed from: b  reason: collision with root package name */
    private final I f18915b;

    /* renamed from: com.uptodown.activities.w$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f18916a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f18917b;

        /* renamed from: c  reason: collision with root package name */
        private final String f18918c;

        public a(int i4, boolean z4, String str) {
            this.f18916a = i4;
            this.f18917b = z4;
            this.f18918c = str;
        }

        public final boolean a() {
            return this.f18917b;
        }

        public final String b() {
            return this.f18918c;
        }

        public final int c() {
            return this.f18916a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f18916a == aVar.f18916a && this.f18917b == aVar.f18917b && m.a(this.f18918c, aVar.f18918c);
        }

        public int hashCode() {
            int a5 = ((this.f18916a * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f18917b)) * 31;
            String str = this.f18918c;
            return a5 + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "PasswordEditData(success=" + this.f18916a + ", error=" + this.f18917b + ", regErrors=" + this.f18918c + ')';
        }
    }

    /* renamed from: com.uptodown.activities.w$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18919a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1847w f18920b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f18921c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f18922d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f18923e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C f18924f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ A f18925g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1847w wVar, Context context, String str, String str2, C c5, A a5, d dVar) {
            super(2, dVar);
            this.f18920b = wVar;
            this.f18921c = context;
            this.f18922d = str;
            this.f18923e = str2;
            this.f18924f = c5;
            this.f18925g = a5;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f18920b, this.f18921c, this.f18922d, this.f18923e, this.f18924f, this.f18925g, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f18919a == 0) {
                n.b(obj);
                this.f18920b.f18914a.setValue(E.a.f21883a);
                L f4 = new u2.L(this.f18921c).f(this.f18922d, this.f18923e);
                if (!f4.b() && f4.e() != null) {
                    JSONObject e5 = f4.e();
                    m.b(e5);
                    this.f18924f.f20968a = f4.g(e5);
                    this.f18925g.f20966a = e5.optInt("success");
                }
                this.f18920b.f18914a.setValue(new E.c(new a(this.f18925g.f20966a, f4.b(), (String) this.f18924f.f20968a)));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1847w() {
        t a5 = K.a(E.b.f21884a);
        this.f18914a = a5;
        this.f18915b = a5;
    }

    public final void b(Context context, String str, String str2) {
        m.e(context, "context");
        m.e(str, "newPassword");
        m.e(str2, "confirmNewPassword");
        A a5 = new A();
        C c5 = new C();
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new b(this, context, str, str2, c5, a5, (d) null), 2, (Object) null);
    }

    public final I c() {
        return this.f18915b;
    }
}
