package R3;

import P3.C2546b;
import P3.C2547c;
import P3.C2548d;
import P3.C2549e;
import Y3.C2611a;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* renamed from: R3.d  reason: case insensitive filesystem */
public class C2565d {

    /* renamed from: h  reason: collision with root package name */
    protected static final String f23917h = C2546b.i(C2565d.class);

    /* renamed from: a  reason: collision with root package name */
    private final C2549e f23918a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f23919b;

    /* renamed from: c  reason: collision with root package name */
    private final PackageManager f23920c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedPreferences f23921d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f23922e;

    /* renamed from: f  reason: collision with root package name */
    private String f23923f;

    /* renamed from: g  reason: collision with root package name */
    private final PackageInfo f23924g;

    /* renamed from: R3.d$a */
    public interface a {

        /* renamed from: R3.d$a$a  reason: collision with other inner class name */
        public static class C0289a implements a {
            public boolean a() {
                return false;
            }

            public String b() {
                return null;
            }
        }

        boolean a();

        String b();
    }

    public C2565d(C2549e eVar) {
        this(eVar, b(eVar.c().c()));
    }

    private static PackageInfo b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e5) {
            C2611a.b(f23917h).d(e5);
            throw new RuntimeException(e5);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(boolean z4, C2548d dVar, a aVar) {
        if (z4) {
            try {
                Thread.sleep(3000);
            } catch (Exception e5) {
                C2611a.b("ContentValues").d(e5);
            }
        }
        g(dVar, aVar);
    }

    private void g(C2548d dVar, a aVar) {
        String string;
        String str = f23917h;
        C2611a.b(str).a("Tracking app download...", new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(this.f23924g.packageName);
        sb.append(":");
        sb.append(c());
        String b5 = aVar.b();
        if (b5 != null) {
            sb.append("/");
            sb.append(b5);
        }
        String installerPackageName = this.f23920c.getInstallerPackageName(this.f23924g.packageName);
        if (installerPackageName != null && installerPackageName.length() > 200) {
            installerPackageName = installerPackageName.substring(0, 200);
        }
        if (!(installerPackageName == null || !installerPackageName.equals("com.android.vending") || (string = this.f23918a.c().g().getString("referrer.extras", (String) null)) == null)) {
            installerPackageName = installerPackageName + "/?" + string;
        }
        if (installerPackageName != null) {
            installerPackageName = "http://" + installerPackageName;
        }
        this.f23918a.k(dVar.c(C2547c.EVENT_CATEGORY, "Application").c(C2547c.EVENT_ACTION, "downloaded").c(C2547c.ACTION_NAME, "application/downloaded").c(C2547c.URL_PATH, "/application/downloaded").c(C2547c.DOWNLOAD, sb.toString()).c(C2547c.REFERRER, installerPackageName));
        C2611a.b(str).a("... app download tracked.", new Object[0]);
    }

    public String c() {
        String str = this.f23923f;
        if (str != null) {
            return str;
        }
        return Integer.toString(this.f23924g.versionCode);
    }

    public void e(String str) {
        this.f23923f = str;
    }

    public void f(C2548d dVar, a aVar) {
        boolean z4;
        if (!this.f23922e || !"com.android.vending".equals(this.f23920c.getInstallerPackageName(this.f23924g.packageName))) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            C2611a.b(f23917h).a("Google Play is install source, deferring tracking.", new Object[0]);
        }
        Thread thread = new Thread(new C2564c(this, z4, dVar, aVar));
        if (z4 || aVar.a()) {
            thread.start();
        } else {
            thread.run();
        }
    }

    public void h(C2548d dVar, a aVar) {
        String str = "downloaded:" + this.f23924g.packageName + ":" + c();
        synchronized (this.f23919b) {
            try {
                if (!this.f23921d.getBoolean(str, false)) {
                    this.f23921d.edit().putBoolean(str, true).apply();
                    f(dVar, aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public C2565d(C2549e eVar, PackageInfo packageInfo) {
        this.f23919b = new Object();
        this.f23918a = eVar;
        Context c5 = eVar.c().c();
        this.f23921d = eVar.g();
        this.f23920c = eVar.c().c().getPackageManager();
        this.f23924g = packageInfo;
        this.f23922e = packageInfo.packageName.equals(c5.getPackageName());
    }
}
