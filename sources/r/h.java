package R;

import J.C0313l;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f613a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f614b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f615c;

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f616d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f616d == null) {
            boolean z4 = false;
            if (k.h() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z4 = true;
            }
            f616d = Boolean.valueOf(z4);
        }
        return f616d.booleanValue();
    }

    public static boolean b() {
        int i4 = C0313l.f342a;
        return "user".equals(Build.TYPE);
    }

    public static boolean c(Context context) {
        return g(context.getPackageManager());
    }

    public static boolean d(Context context) {
        if (c(context) && !k.g()) {
            return true;
        }
        if (!e(context)) {
            return false;
        }
        if (!k.h() || k.k()) {
            return true;
        }
        return false;
    }

    public static boolean e(Context context) {
        if (f614b == null) {
            boolean z4 = false;
            if (k.f() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z4 = true;
            }
            f614b = Boolean.valueOf(z4);
        }
        return f614b.booleanValue();
    }

    public static boolean f(Context context) {
        if (f615c == null) {
            boolean z4 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z4 = false;
            }
            f615c = Boolean.valueOf(z4);
        }
        return f615c.booleanValue();
    }

    public static boolean g(PackageManager packageManager) {
        if (f613a == null) {
            boolean z4 = false;
            if (k.e() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z4 = true;
            }
            f613a = Boolean.valueOf(z4);
        }
        return f613a.booleanValue();
    }
}
