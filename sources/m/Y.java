package M;

import T.e;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public abstract class Y {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f448a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f449b;

    /* renamed from: c  reason: collision with root package name */
    private static String f450c;

    /* renamed from: d  reason: collision with root package name */
    private static int f451d;

    public static int a(Context context) {
        b(context);
        return f451d;
    }

    private static void b(Context context) {
        synchronized (f448a) {
            try {
                if (!f449b) {
                    f449b = true;
                    Bundle bundle = e.a(context).c(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        f450c = bundle.getString("com.google.app.id");
                        f451d = bundle.getInt("com.google.android.gms.version");
                    }
                }
            } catch (PackageManager.NameNotFoundException e5) {
                Log.wtf("MetadataValueReader", "This should never happen.", e5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
