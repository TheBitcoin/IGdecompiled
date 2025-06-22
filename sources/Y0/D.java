package y0;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import k0.C0937l;
import k0.C0938m;
import p0.C2194f;
import v0.g;
import z0.C2441b;

public class D {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f22568a;

    /* renamed from: b  reason: collision with root package name */
    private final C2194f f22569b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f22570c;

    /* renamed from: d  reason: collision with root package name */
    C0938m f22571d = new C0938m();

    /* renamed from: e  reason: collision with root package name */
    boolean f22572e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22573f = false;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f22574g;

    /* renamed from: h  reason: collision with root package name */
    private final C0938m f22575h = new C0938m();

    public D(C2194f fVar) {
        Object obj = new Object();
        this.f22570c = obj;
        Context k4 = fVar.k();
        this.f22569b = fVar;
        this.f22568a = C2420j.q(k4);
        Boolean b5 = b();
        this.f22574g = b5 == null ? a(k4) : b5;
        synchronized (obj) {
            try {
                if (d()) {
                    this.f22571d.e((Object) null);
                    this.f22572e = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private Boolean a(Context context) {
        Boolean g4 = g(context);
        if (g4 == null) {
            this.f22573f = false;
            return null;
        }
        this.f22573f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(g4));
    }

    private Boolean b() {
        if (!this.f22568a.contains("firebase_crashlytics_collection_enabled")) {
            return null;
        }
        this.f22573f = false;
        return Boolean.valueOf(this.f22568a.getBoolean("firebase_crashlytics_collection_enabled", true));
    }

    private boolean e() {
        try {
            return this.f22569b.t();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    private void f(boolean z4) {
        String str;
        String str2;
        if (z4) {
            str = "ENABLED";
        } else {
            str = "DISABLED";
        }
        if (this.f22574g == null) {
            str2 = "global Firebase setting";
        } else if (this.f22573f) {
            str2 = "firebase_crashlytics_collection_enabled manifest flag";
        } else {
            str2 = "API";
        }
        g.f().b(String.format("Crashlytics automatic data collection %s by %s.", new Object[]{str, str2}));
    }

    private static Boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
        } catch (PackageManager.NameNotFoundException e5) {
            g.f().e("Could not read data collection permission from manifest", e5);
            return null;
        }
    }

    private static void i(SharedPreferences sharedPreferences, Boolean bool) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (bool != null) {
            edit.putBoolean("firebase_crashlytics_collection_enabled", bool.booleanValue());
        } else {
            edit.remove("firebase_crashlytics_collection_enabled");
        }
        edit.apply();
    }

    public void c(boolean z4) {
        if (z4) {
            this.f22575h.e((Object) null);
            return;
        }
        throw new IllegalStateException("An invalid data collection token was used.");
    }

    public synchronized boolean d() {
        boolean z4;
        try {
            Boolean bool = this.f22574g;
            if (bool != null) {
                z4 = bool.booleanValue();
            } else {
                z4 = e();
            }
            f(z4);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return z4;
    }

    public synchronized void h(Boolean bool) {
        Boolean bool2;
        if (bool != null) {
            try {
                this.f22573f = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            bool2 = bool;
        } else {
            bool2 = a(this.f22569b.k());
        }
        this.f22574g = bool2;
        i(this.f22568a, bool);
        synchronized (this.f22570c) {
            if (d()) {
                if (!this.f22572e) {
                    this.f22571d.e((Object) null);
                    this.f22572e = true;
                }
            } else if (this.f22572e) {
                this.f22571d = new C0938m();
                this.f22572e = false;
            }
        }
    }

    public C0937l j() {
        C0937l a5;
        synchronized (this.f22570c) {
            a5 = this.f22571d.a();
        }
        return a5;
    }

    public C0937l k() {
        return C2441b.b(this.f22575h.a(), j());
    }
}
