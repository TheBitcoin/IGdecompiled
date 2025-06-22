package R;

import M.C0335p;
import android.content.Context;
import android.util.Log;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f611a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    public static boolean a(Context context, Throwable th) {
        try {
            C0335p.l(context);
            C0335p.l(th);
            return false;
        } catch (Exception e5) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e5);
            return false;
        }
    }
}
