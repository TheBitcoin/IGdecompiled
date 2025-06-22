package b1;

import K0.C1492a;
import M0.d;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import c1.C1649b;
import d1.f;
import java.util.Map;
import kotlin.jvm.internal.m;
import p0.C2194f;

/* renamed from: b1.B  reason: case insensitive filesystem */
public final class C1617B {

    /* renamed from: a  reason: collision with root package name */
    public static final C1617B f8921a = new C1617B();

    /* renamed from: b  reason: collision with root package name */
    private static final C1492a f8922b;

    static {
        C1492a i4 = new d().j(C1620c.f8981a).k(true).i();
        m.d(i4, "JsonDataEncoderBuilder()…lues(true)\n      .build()");
        f8922b = i4;
    }

    private C1617B() {
    }

    private final C1621d d(C1649b bVar) {
        if (bVar == null) {
            return C1621d.COLLECTION_SDK_NOT_INSTALLED;
        }
        if (bVar.a()) {
            return C1621d.COLLECTION_ENABLED;
        }
        return C1621d.COLLECTION_DISABLED;
    }

    public final C1616A a(C2194f fVar, z zVar, f fVar2, Map map, String str, String str2) {
        D d5;
        Map map2 = map;
        m.e(fVar, "firebaseApp");
        m.e(zVar, "sessionDetails");
        m.e(fVar2, "sessionsSettings");
        m.e(map2, "subscribers");
        String str3 = str;
        m.e(str3, "firebaseInstallationId");
        String str4 = str2;
        m.e(str4, "firebaseAuthenticationToken");
        C1627j jVar = C1627j.SESSION_START;
        new D(zVar.b(), zVar.a(), zVar.c(), zVar.d(), new C1623f(d((C1649b) map2.get(C1649b.a.PERFORMANCE)), d((C1649b) map2.get(C1649b.a.CRASHLYTICS)), fVar2.b()), str3, str4);
        return new C1616A(jVar, d5, b(fVar));
    }

    public final C1619b b(C2194f fVar) {
        String valueOf;
        String str;
        m.e(fVar, "firebaseApp");
        Context k4 = fVar.k();
        m.d(k4, "firebaseApp.applicationContext");
        String packageName = k4.getPackageName();
        PackageInfo packageInfo = k4.getPackageManager().getPackageInfo(packageName, 0);
        if (Build.VERSION.SDK_INT >= 28) {
            valueOf = String.valueOf(packageInfo.getLongVersionCode());
        } else {
            valueOf = String.valueOf(packageInfo.versionCode);
        }
        String str2 = valueOf;
        String c5 = fVar.n().c();
        m.d(c5, "firebaseApp.options.applicationId");
        String str3 = Build.MODEL;
        m.d(str3, "MODEL");
        String str4 = c5;
        String str5 = Build.VERSION.RELEASE;
        m.d(str5, "RELEASE");
        String str6 = str3;
        u uVar = u.LOG_ENVIRONMENT_PROD;
        m.d(packageName, "packageName");
        String str7 = packageInfo.versionName;
        if (str7 == null) {
            str = str2;
        } else {
            str = str7;
        }
        String str8 = Build.MANUFACTURER;
        m.d(str8, "MANUFACTURER");
        w wVar = w.f9060a;
        Context k5 = fVar.k();
        m.d(k5, "firebaseApp.applicationContext");
        v d5 = wVar.d(k5);
        Context k6 = fVar.k();
        m.d(k6, "firebaseApp.applicationContext");
        return new C1619b(str4, str6, "2.0.6", str5, uVar, new C1618a(packageName, str, str2, str8, d5, wVar.c(k6)));
    }

    public final C1492a c() {
        return f8922b;
    }
}
