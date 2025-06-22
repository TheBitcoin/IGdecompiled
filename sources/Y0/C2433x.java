package y0;

import A0.C1269e;
import A0.m;
import E0.g;
import G0.j;
import H0.C1300a;
import H0.C1302c;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k0.C0937l;
import p0.C2194f;
import v0.C2327a;
import v0.l;
import w0.C2333a;
import x0.C2348b;
import z0.C2446g;

/* renamed from: y0.x  reason: case insensitive filesystem */
public class C2433x {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22714a;

    /* renamed from: b  reason: collision with root package name */
    private final C2194f f22715b;

    /* renamed from: c  reason: collision with root package name */
    private final D f22716c;

    /* renamed from: d  reason: collision with root package name */
    private final N f22717d = new N();

    /* renamed from: e  reason: collision with root package name */
    private final long f22718e = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    private C2434y f22719f;

    /* renamed from: g  reason: collision with root package name */
    private C2434y f22720g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f22721h;

    /* renamed from: i  reason: collision with root package name */
    private C2427q f22722i;

    /* renamed from: j  reason: collision with root package name */
    private final I f22723j;

    /* renamed from: k  reason: collision with root package name */
    private final g f22724k;

    /* renamed from: l  reason: collision with root package name */
    public final C2348b f22725l;

    /* renamed from: m  reason: collision with root package name */
    private final C2333a f22726m;

    /* renamed from: n  reason: collision with root package name */
    private final C2424n f22727n;

    /* renamed from: o  reason: collision with root package name */
    private final C2327a f22728o;

    /* renamed from: p  reason: collision with root package name */
    private final l f22729p;

    /* renamed from: q  reason: collision with root package name */
    private final C2446g f22730q;

    public C2433x(C2194f fVar, I i4, C2327a aVar, D d5, C2348b bVar, C2333a aVar2, g gVar, C2424n nVar, l lVar, C2446g gVar2) {
        this.f22715b = fVar;
        this.f22716c = d5;
        this.f22714a = fVar.k();
        this.f22723j = i4;
        this.f22728o = aVar;
        this.f22725l = bVar;
        this.f22726m = aVar2;
        this.f22724k = gVar;
        this.f22727n = nVar;
        this.f22729p = lVar;
        this.f22730q = gVar2;
    }

    private void f() {
        try {
            this.f22721h = Boolean.TRUE.equals((Boolean) this.f22730q.f22851a.c().submit(new C2428s(this)).get(3, TimeUnit.SECONDS));
        } catch (Exception unused) {
            this.f22721h = false;
        }
    }

    /* access modifiers changed from: private */
    public void h(j jVar) {
        C2446g.c();
        o();
        try {
            this.f22725l.a(new C2430u(this));
            this.f22722i.Q();
            if (jVar.b().f6522b.f6529a) {
                if (!this.f22722i.y(jVar)) {
                    v0.g.f().k("Previous sessions could not be finalized.");
                }
                this.f22722i.S(jVar.a());
                n();
                return;
            }
            v0.g.f().b("Collection of crash reports disabled in Crashlytics settings.");
            throw new RuntimeException("Collection of crash reports disabled in Crashlytics settings.");
        } catch (Exception e5) {
            v0.g.f().e("Crashlytics encountered a problem during asynchronous initialization.", e5);
            n();
        } catch (Throwable th) {
            n();
            throw th;
        }
    }

    private void j(j jVar) {
        Future<?> submit = this.f22730q.f22851a.c().submit(new C2429t(this, jVar));
        v0.g.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException e5) {
            v0.g.f().e("Crashlytics was interrupted during initialization.", e5);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e6) {
            v0.g.f().e("Crashlytics encountered a problem during initialization.", e6);
        } catch (TimeoutException e7) {
            v0.g.f().e("Crashlytics timed out during initialization.", e7);
        }
    }

    public static String k() {
        return "19.2.1";
    }

    static boolean l(String str, boolean z4) {
        if (!z4) {
            v0.g.f().i("Configured not to require a build ID.");
            return true;
        } else if (!TextUtils.isEmpty(str)) {
            return true;
        } else {
            Log.e("FirebaseCrashlytics", ".");
            Log.e("FirebaseCrashlytics", ".     |  | ");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".   \\ |  | /");
            Log.e("FirebaseCrashlytics", ".    \\    /");
            Log.e("FirebaseCrashlytics", ".     \\  /");
            Log.e("FirebaseCrashlytics", ".      \\/");
            Log.e("FirebaseCrashlytics", ".");
            Log.e("FirebaseCrashlytics", "The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
            Log.e("FirebaseCrashlytics", ".");
            Log.e("FirebaseCrashlytics", ".      /\\");
            Log.e("FirebaseCrashlytics", ".     /  \\");
            Log.e("FirebaseCrashlytics", ".    /    \\");
            Log.e("FirebaseCrashlytics", ".   / |  | \\");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.f22719f.c();
    }

    public C0937l i(j jVar) {
        return this.f22730q.f22851a.d(new r(this, jVar));
    }

    public void m(String str) {
        this.f22730q.f22851a.d(new C2431v(this, System.currentTimeMillis() - this.f22718e, str));
    }

    /* access modifiers changed from: package-private */
    public void n() {
        C2446g.c();
        try {
            if (!this.f22719f.d()) {
                v0.g.f().k("Initialization marker file was not properly removed.");
            }
        } catch (Exception e5) {
            v0.g.f().e("Problem encountered deleting Crashlytics initialization marker.", e5);
        }
    }

    /* access modifiers changed from: package-private */
    public void o() {
        C2446g.c();
        this.f22719f.a();
        v0.g.f().i("Initialization marker file was created.");
    }

    public boolean p(C2412b bVar, j jVar) {
        C2412b bVar2 = bVar;
        if (l(bVar2.f22619b, C2420j.i(this.f22714a, "com.crashlytics.RequireBuildId", true))) {
            String c5 = new C2419i().c();
            try {
                this.f22720g = new C2434y("crash_marker", this.f22724k);
                this.f22719f = new C2434y("initialization_marker", this.f22724k);
                m mVar = new m(c5, this.f22724k, this.f22730q);
                C1269e eVar = new C1269e(this.f22724k);
                C1300a aVar = new C1300a(1024, new C1302c(10));
                this.f22729p.b(mVar);
                j jVar2 = jVar;
                Z i4 = Z.i(this.f22714a, this.f22723j, this.f22724k, bVar2, eVar, mVar, aVar, jVar2, this.f22717d, this.f22727n, this.f22730q);
                m mVar2 = mVar;
                Context context = this.f22714a;
                I i5 = this.f22723j;
                D d5 = this.f22716c;
                g gVar = this.f22724k;
                C2434y yVar = this.f22720g;
                Context context2 = context;
                I i6 = i5;
                D d6 = d5;
                g gVar2 = gVar;
                C2434y yVar2 = yVar;
                this.f22722i = new C2427q(context2, i6, d6, gVar2, yVar2, bVar, mVar2, eVar, i4, this.f22728o, this.f22726m, this.f22727n, this.f22730q);
                boolean g4 = g();
                f();
                this.f22722i.w(c5, Thread.getDefaultUncaughtExceptionHandler(), jVar2);
                if (!g4 || !C2420j.d(this.f22714a)) {
                    v0.g.f().b("Successfully configured exception handler.");
                    return true;
                }
                v0.g.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                j(jVar2);
                return false;
            } catch (Exception e5) {
                v0.g.f().e("Crashlytics was not started due to an exception during initialization", e5);
                this.f22722i = null;
                return false;
            }
        } else {
            throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        }
    }

    public void q(Boolean bool) {
        this.f22716c.h(bool);
    }
}
