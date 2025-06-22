package T;

import R.k;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;

public class d {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f637a;

    public d(Context context) {
        this.f637a = context;
    }

    public int a(String str) {
        return this.f637a.checkCallingOrSelfPermission(str);
    }

    public int b(String str, String str2) {
        return this.f637a.getPackageManager().checkPermission(str, str2);
    }

    public ApplicationInfo c(String str, int i4) {
        return this.f637a.getPackageManager().getApplicationInfo(str, i4);
    }

    public CharSequence d(String str) {
        Context context = this.f637a;
        return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 0));
    }

    public PackageInfo e(String str, int i4) {
        return this.f637a.getPackageManager().getPackageInfo(str, i4);
    }

    public boolean f() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return b.a(this.f637a);
        }
        if (!k.h() || (nameForUid = this.f637a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f637a.getPackageManager().isInstantApp(nameForUid);
    }

    public final boolean g(int i4, String str) {
        if (k.d()) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) this.f637a.getSystemService("appops");
                if (appOpsManager != null) {
                    appOpsManager.checkPackage(i4, str);
                    return true;
                }
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            } catch (SecurityException unused) {
                return false;
            }
        } else {
            String[] packagesForUid = this.f637a.getPackageManager().getPackagesForUid(i4);
            if (!(str == null || packagesForUid == null)) {
                for (String equals : packagesForUid) {
                    if (str.equals(equals)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
