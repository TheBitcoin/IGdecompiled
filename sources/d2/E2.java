package d2;

import R2.n;
import R2.s;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import d3.p;
import g2.C2060s;
import g2.L;
import g2.S;
import g2.U;
import java.util.ArrayList;
import java.util.Iterator;
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
import u2.q;

public final class E2 extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f19684a;

    /* renamed from: b  reason: collision with root package name */
    private final I f19685b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final t f19686c;

    /* renamed from: d  reason: collision with root package name */
    private final I f19687d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final t f19688e;

    /* renamed from: f  reason: collision with root package name */
    private final I f19689f;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f19690a;

        /* renamed from: b  reason: collision with root package name */
        private final int f19691b;

        public a(int i4, int i5) {
            this.f19690a = i4;
            this.f19691b = i5;
        }

        public final int a() {
            return this.f19690a;
        }

        public final int b() {
            return this.f19691b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f19690a == aVar.f19690a && this.f19691b == aVar.f19691b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f19690a * 31) + this.f19691b;
        }

        public String toString() {
            return "UserNotifiersData(downloadsCount=" + this.f19690a + ", updatesCount=" + this.f19691b + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19692a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f19693b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, V2.d dVar) {
            super(2, dVar);
            this.f19693b = context;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f19693b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19692a == 0) {
                n.b(obj);
                U.f20468m.a(this.f19693b);
                AccountManager accountManager = AccountManager.get(this.f19693b);
                String string = this.f19693b.getString(R.string.account);
                m.d(string, "getString(...)");
                Account[] accountsByType = accountManager.getAccountsByType(string);
                m.d(accountsByType, "getAccountsByType(...)");
                for (Account account : accountsByType) {
                    if (m3.m.p(account.type, string, true)) {
                        if (Build.VERSION.SDK_INT >= 22) {
                            AccountManagerFuture unused = accountManager.removeAccount(account, (Activity) null, (AccountManagerCallback) null, (Handler) null);
                        } else {
                            accountManager.removeAccount(account, (AccountManagerCallback) null, (Handler) null);
                        }
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19694a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f19695b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ E2 f19696c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, E2 e22, V2.d dVar) {
            super(2, dVar);
            this.f19695b = context;
            this.f19696c = e22;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f19695b, this.f19696c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19694a == 0) {
                n.b(obj);
                int a5 = S.f20455j.a(this.f19695b);
                u2.t a6 = u2.t.f21927u.a(this.f19695b);
                a6.a();
                ArrayList m02 = a6.m0();
                a6.i();
                Iterator it = m02.iterator();
                m.d(it, "iterator(...)");
                int i4 = 0;
                while (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    C2060s sVar = (C2060s) next;
                    if (sVar.N() && sVar.k() == 0 && sVar.f()) {
                        i4++;
                    }
                }
                this.f19696c.f19684a.setValue(new E.c(new a(i4, a5)));
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
        int f19697a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f19698b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ E2 f19699c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, E2 e22, V2.d dVar) {
            super(2, dVar);
            this.f19698b = context;
            this.f19699c = e22;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f19698b, this.f19699c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19697a == 0) {
                n.b(obj);
                L U4 = new u2.L(this.f19698b).U();
                if (!U4.b() && U4.e() != null) {
                    JSONObject e5 = U4.e();
                    m.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null && !optJSONObject.isNull("url")) {
                        this.f19699c.f19688e.setValue(new E.c(optJSONObject.optString("url")));
                    }
                }
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
        int f19700a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f19701b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ E2 f19702c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Context context, E2 e22, V2.d dVar) {
            super(2, dVar);
            this.f19701b = context;
            this.f19702c = e22;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f19701b, this.f19702c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String g4;
            String d5;
            W2.b.c();
            if (this.f19700a == 0) {
                n.b(obj);
                u2.L l4 = new u2.L(this.f19701b);
                U e5 = U.f20468m.e(this.f19701b);
                if (e5 == null || (g4 = e5.g()) == null || g4.length() == 0 || !e5.n()) {
                    this.f19702c.f19686c.setValue(new E.c(new q().c(u2.L.f21898b.c(this.f19701b))));
                } else {
                    String g5 = e5.g();
                    m.b(g5);
                    L g02 = l4.g0(g5);
                    if (!(g02.b() || (d5 = g02.d()) == null || d5.length() == 0)) {
                        String d6 = g02.d();
                        m.b(d6);
                        JSONObject optJSONObject = new JSONObject(d6).optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                        if (optJSONObject != null && !optJSONObject.isNull("url")) {
                            this.f19702c.f19686c.setValue(new E.c(optJSONObject.optString("url")));
                        }
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

    public E2() {
        t a5 = K.a(E.b.f21884a);
        this.f19684a = a5;
        this.f19685b = a5;
        E.a aVar = E.a.f21883a;
        t a6 = K.a(aVar);
        this.f19686c = a6;
        this.f19687d = a6;
        t a7 = K.a(aVar);
        this.f19688e = a7;
        this.f19689f = a7;
    }

    public final void d(Context context) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new b(context, (V2.d) null), 2, (Object) null);
    }

    public final void e(Context context) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new c(context, this, (V2.d) null), 2, (Object) null);
    }

    public final I f() {
        return this.f19689f;
    }

    public final void g(Context context) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new d(context, this, (V2.d) null), 2, (Object) null);
    }

    public final I h() {
        return this.f19687d;
    }

    public final void i(Context context) {
        m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new e(context, this, (V2.d) null), 2, (Object) null);
    }

    public final I j() {
        return this.f19685b;
    }
}
