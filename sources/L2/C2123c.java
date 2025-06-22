package l2;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import kotlin.jvm.internal.m;

/* renamed from: l2.c  reason: case insensitive filesystem */
public abstract class C2123c {
    public static final PackageInfo a(PackageManager packageManager, String str, int i4) {
        m.e(packageManager, "<this>");
        m.e(str, "packageName");
        if (Build.VERSION.SDK_INT >= 33) {
            PackageInfo a5 = packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of((long) i4));
            m.d(a5, "{\n        getPackageInfo…of(flags.toLong()))\n    }");
            return a5;
        }
        PackageInfo packageInfo = packageManager.getPackageInfo(str, i4);
        m.d(packageInfo, "{\n        getPackageInfo(packageName, flags)\n    }");
        return packageInfo;
    }
}
