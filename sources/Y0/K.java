package y0;

import android.content.Context;

class K {

    /* renamed from: a  reason: collision with root package name */
    private String f22603a;

    K() {
    }

    private static String b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        if (installerPackageName == null) {
            return "";
        }
        return installerPackageName;
    }

    /* access modifiers changed from: package-private */
    public synchronized String a(Context context) {
        String str;
        try {
            if (this.f22603a == null) {
                this.f22603a = b(context);
            }
            if ("".equals(this.f22603a)) {
                str = null;
            } else {
                str = this.f22603a;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return str;
    }
}
