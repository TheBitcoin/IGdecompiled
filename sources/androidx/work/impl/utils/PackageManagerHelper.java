package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.work.Logger;

public class PackageManagerHelper {
    private static final String TAG = Logger.tagWithPrefix("PackageManagerHelper");

    private PackageManagerHelper() {
    }

    private static int getComponentEnabledSetting(@NonNull Context context, @NonNull String str) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, str));
    }

    private static boolean isComponentEnabled(int i4, boolean z4) {
        return i4 == 0 ? z4 : i4 == 1;
    }

    public static boolean isComponentExplicitlyEnabled(@NonNull Context context, @NonNull Class<?> cls) {
        return isComponentEnabled(getComponentEnabledSetting(context, cls.getName()), false);
    }

    public static void setComponentEnabled(@NonNull Context context, @NonNull Class<?> cls, boolean z4) {
        int i4;
        String str;
        String str2 = "disabled";
        try {
            if (z4 == isComponentEnabled(getComponentEnabledSetting(context, cls.getName()), false)) {
                Logger logger = Logger.get();
                String str3 = TAG;
                logger.debug(str3, "Skipping component enablement for " + cls.getName());
                return;
            }
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, cls.getName());
            if (z4) {
                i4 = 1;
            } else {
                i4 = 2;
            }
            packageManager.setComponentEnabledSetting(componentName, i4, 1);
            Logger logger2 = Logger.get();
            String str4 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(" ");
            if (z4) {
                str = "enabled";
            } else {
                str = str2;
            }
            sb.append(str);
            logger2.debug(str4, sb.toString());
        } catch (Exception e5) {
            Logger logger3 = Logger.get();
            String str5 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append("could not be ");
            if (z4) {
                str2 = "enabled";
            }
            sb2.append(str2);
            logger3.debug(str5, sb2.toString(), e5);
        }
    }

    public static boolean isComponentExplicitlyEnabled(@NonNull Context context, @NonNull String str) {
        return getComponentEnabledSetting(context, str) == 1;
    }
}
