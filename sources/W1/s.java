package W1;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.List;
import kotlin.jvm.internal.m;

public abstract class s {
    public static final ApplicationInfo a(PackageManager packageManager, String str, int i4) {
        m.e(packageManager, "<this>");
        m.e(str, "packageName");
        if (Build.VERSION.SDK_INT >= 33) {
            ApplicationInfo a5 = packageManager.getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of((long) i4));
            m.d(a5, "{\n        getApplication…of(flags.toLong()))\n    }");
            return a5;
        }
        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, i4);
        m.d(applicationInfo, "{\n        getApplication…packageName, flags)\n    }");
        return applicationInfo;
    }

    public static final List b(PackageManager packageManager, int i4) {
        m.e(packageManager, "<this>");
        if (Build.VERSION.SDK_INT >= 33) {
            List a5 = packageManager.getInstalledApplications(PackageManager.ApplicationInfoFlags.of((long) i4));
            m.d(a5, "{\n        getInstalledAp…of(flags.toLong()))\n    }");
            return a5;
        }
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(i4);
        m.d(installedApplications, "{\n        getInstalledApplications(flags)\n    }");
        return installedApplications;
    }

    public static final PackageInfo c(PackageManager packageManager, String str, int i4) {
        m.e(packageManager, "<this>");
        m.e(str, "absolutePath");
        if (Build.VERSION.SDK_INT >= 33) {
            return packageManager.getPackageArchiveInfo(str, PackageManager.PackageInfoFlags.of((long) i4));
        }
        return packageManager.getPackageArchiveInfo(str, i4);
    }

    public static final PackageInfo d(PackageManager packageManager, String str, int i4) {
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
