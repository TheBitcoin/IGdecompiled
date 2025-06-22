package K;

import K.a;
import L.C0317a;
import L.C0318b;
import L.g;
import L.k;
import L.p;
import L.x;
import M.C0322c;
import M.C0323d;
import M.C0335p;
import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.C0503b;
import com.google.android.gms.common.api.internal.C0504c;
import com.google.android.gms.common.api.internal.C0505d;
import com.google.android.gms.common.api.internal.h;
import com.google.android.gms.common.api.internal.n;
import java.util.Collections;
import k0.C0937l;
import k0.C0938m;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private final Context f364a;

    /* renamed from: b  reason: collision with root package name */
    private final String f365b;

    /* renamed from: c  reason: collision with root package name */
    private final a f366c;

    /* renamed from: d  reason: collision with root package name */
    private final a.d f367d;

    /* renamed from: e  reason: collision with root package name */
    private final C0318b f368e;

    /* renamed from: f  reason: collision with root package name */
    private final Looper f369f;

    /* renamed from: g  reason: collision with root package name */
    private final int f370g;

    /* renamed from: h  reason: collision with root package name */
    private final f f371h;

    /* renamed from: i  reason: collision with root package name */
    private final k f372i;

    /* renamed from: j  reason: collision with root package name */
    protected final C0504c f373j;

    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final a f374c = new C0002a().a();

        /* renamed from: a  reason: collision with root package name */
        public final k f375a;

        /* renamed from: b  reason: collision with root package name */
        public final Looper f376b;

        /* renamed from: K.e$a$a  reason: collision with other inner class name */
        public static class C0002a {

            /* renamed from: a  reason: collision with root package name */
            private k f377a;

            /* renamed from: b  reason: collision with root package name */
            private Looper f378b;

            public a a() {
                if (this.f377a == null) {
                    this.f377a = new C0317a();
                }
                if (this.f378b == null) {
                    this.f378b = Looper.getMainLooper();
                }
                return new a(this.f377a, this.f378b);
            }

            public C0002a b(k kVar) {
                C0335p.m(kVar, "StatusExceptionMapper must not be null.");
                this.f377a = kVar;
                return this;
            }
        }

        private a(k kVar, Account account, Looper looper) {
            this.f375a = kVar;
            this.f376b = looper;
        }
    }

    private e(Context context, Activity activity, a aVar, a.d dVar, a aVar2) {
        String str;
        C0335p.m(context, "Null context is not permitted.");
        C0335p.m(aVar, "Api must not be null.");
        C0335p.m(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context2 = (Context) C0335p.m(context.getApplicationContext(), "The provided context did not have an application context.");
        this.f364a = context2;
        if (Build.VERSION.SDK_INT >= 30) {
            str = context.getAttributionTag();
        } else {
            str = f(context);
        }
        this.f365b = str;
        this.f366c = aVar;
        this.f367d = dVar;
        this.f369f = aVar2.f376b;
        C0318b a5 = C0318b.a(aVar, dVar, str);
        this.f368e = a5;
        this.f371h = new p(this);
        C0504c u4 = C0504c.u(context2);
        this.f373j = u4;
        this.f370g = u4.l();
        this.f372i = aVar2.f375a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            h.u(activity, u4, a5);
        }
        u4.F(this);
    }

    private final C0503b o(int i4, C0503b bVar) {
        bVar.i();
        this.f373j.A(this, i4, bVar);
        return bVar;
    }

    private final C0937l p(int i4, C0505d dVar) {
        C0938m mVar = new C0938m();
        this.f373j.B(this, i4, dVar, mVar, this.f372i);
        return mVar.a();
    }

    public f b() {
        return this.f371h;
    }

    /* access modifiers changed from: protected */
    public C0323d.a c() {
        C0323d.a aVar = new C0323d.a();
        aVar.d((Account) null);
        aVar.c(Collections.EMPTY_SET);
        aVar.e(this.f364a.getClass().getName());
        aVar.b(this.f364a.getPackageName());
        return aVar;
    }

    public C0937l d(C0505d dVar) {
        return p(2, dVar);
    }

    public C0503b e(C0503b bVar) {
        o(1, bVar);
        return bVar;
    }

    /* access modifiers changed from: protected */
    public String f(Context context) {
        return null;
    }

    public final C0318b g() {
        return this.f368e;
    }

    public a.d h() {
        return this.f367d;
    }

    public Context i() {
        return this.f364a;
    }

    /* access modifiers changed from: protected */
    public String j() {
        return this.f365b;
    }

    public Looper k() {
        return this.f369f;
    }

    public final int l() {
        return this.f370g;
    }

    public final a.f m(Looper looper, n nVar) {
        Looper looper2 = looper;
        a.f a5 = ((a.C0001a) C0335p.l(this.f366c.a())).a(this.f364a, looper2, c().a(), this.f367d, nVar, nVar);
        String j4 = j();
        if (j4 != null && (a5 instanceof C0322c)) {
            ((C0322c) a5).P(j4);
        }
        if (j4 == null || !(a5 instanceof g)) {
            return a5;
        }
        android.support.v4.media.a.a(a5);
        throw null;
    }

    public final x n(Context context, Handler handler) {
        return new x(context, handler, c().a());
    }

    public e(Context context, a aVar, a.d dVar, a aVar2) {
        this(context, (Activity) null, aVar, dVar, aVar2);
    }
}
