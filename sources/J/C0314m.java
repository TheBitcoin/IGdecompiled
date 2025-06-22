package J;

import M.C0335p;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;

/* renamed from: J.m  reason: case insensitive filesystem */
public class C0314m {

    /* renamed from: c  reason: collision with root package name */
    private static C0314m f347c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f348a;

    /* renamed from: b  reason: collision with root package name */
    private volatile String f349b;

    public C0314m(Context context) {
        this.f348a = context.getApplicationContext();
    }

    public static C0314m a(Context context) {
        C0335p.l(context);
        synchronized (C0314m.class) {
            try {
                if (f347c == null) {
                    D.d(context);
                    f347c = new C0314m(context);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return f347c;
    }

    static final z d(PackageInfo packageInfo, z... zVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            A a5 = new A(packageInfo.signatures[0].toByteArray());
            for (int i4 = 0; i4 < zVarArr.length; i4++) {
                if (zVarArr[i4].equals(a5)) {
                    return zVarArr[i4];
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0047 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean e(android.content.pm.PackageInfo r4, boolean r5) {
        /*
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x0027
            if (r4 == 0) goto L_0x0029
            java.lang.String r2 = "com.android.vending"
            java.lang.String r3 = r4.packageName
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x001a
            java.lang.String r2 = r4.packageName
            java.lang.String r3 = "com.google.android.gms"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0027
        L_0x001a:
            android.content.pm.ApplicationInfo r5 = r4.applicationInfo
            if (r5 != 0) goto L_0x0020
        L_0x001e:
            r5 = 0
            goto L_0x0027
        L_0x0020:
            int r5 = r5.flags
            r5 = r5 & 129(0x81, float:1.81E-43)
            if (r5 == 0) goto L_0x001e
            r5 = 1
        L_0x0027:
            r2 = r4
            goto L_0x002a
        L_0x0029:
            r2 = 0
        L_0x002a:
            if (r4 == 0) goto L_0x0048
            android.content.pm.Signature[] r4 = r2.signatures
            if (r4 == 0) goto L_0x0048
            if (r5 == 0) goto L_0x0039
            J.z[] r4 = J.C.f292a
            J.z r4 = d(r2, r4)
            goto L_0x0045
        L_0x0039:
            J.z[] r4 = J.C.f292a
            r4 = r4[r1]
            J.z[] r5 = new J.z[r0]
            r5[r1] = r4
            J.z r4 = d(r2, r5)
        L_0x0045:
            if (r4 == 0) goto L_0x0048
            return r0
        L_0x0048:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: J.C0314m.e(android.content.pm.PackageInfo, boolean):boolean");
    }

    private final N f(String str, boolean z4, boolean z5) {
        N n4;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return N.c("null pkg");
        }
        if (str.equals(this.f349b)) {
            return N.b();
        }
        if (D.e()) {
            n4 = D.b(str, C0313l.f(this.f348a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f348a.getPackageManager().getPackageInfo(str, 64);
                boolean f4 = C0313l.f(this.f348a);
                if (packageInfo == null) {
                    n4 = N.c("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        n4 = N.c("single cert required");
                    } else {
                        A a5 = new A(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        N a6 = D.a(str2, a5, f4, false);
                        if (!a6.f316a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !D.a(str2, a5, false, true).f316a) {
                            n4 = a6;
                        } else {
                            n4 = N.c("debuggable release cert app rejected");
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e5) {
                return N.d("no pkg ".concat(str), e5);
            }
        }
        if (n4.f316a) {
            this.f349b = str;
        }
        return n4;
    }

    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (e(packageInfo, false)) {
            return true;
        }
        if (e(packageInfo, true)) {
            if (C0313l.f(this.f348a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean c(int i4) {
        N n4;
        int length;
        String[] packagesForUid = this.f348a.getPackageManager().getPackagesForUid(i4);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            n4 = null;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    C0335p.l(n4);
                    break;
                }
                n4 = f(packagesForUid[i5], false, false);
                if (n4.f316a) {
                    break;
                }
                i5++;
            }
        } else {
            n4 = N.c("no pkgs");
        }
        n4.e();
        return n4.f316a;
    }
}
