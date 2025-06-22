package R;

import J.C0314m;
import T.e;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

public abstract class o {
    public static boolean a(Context context, int i4) {
        if (!b(context, i4, "com.google.android.gms")) {
            return false;
        }
        try {
            return C0314m.a(context).b(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (PackageManager.NameNotFoundException unused) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return false;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return false;
        }
    }

    public static boolean b(Context context, int i4, String str) {
        return e.a(context).g(i4, str);
    }
}
