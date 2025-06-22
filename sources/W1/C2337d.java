package w1;

import android.text.TextUtils;
import android.util.Log;
import p1.c;

/* renamed from: w1.d  reason: case insensitive filesystem */
public abstract class C2337d {
    public static void a(String str) {
        if (c.f21460a.booleanValue() && !TextUtils.isEmpty(str)) {
            Log.i("OMIDLIB", str);
        }
    }

    public static void b(String str, Exception exc) {
        if ((c.f21460a.booleanValue() && !TextUtils.isEmpty(str)) || exc != null) {
            Log.e("OMIDLIB", str, exc);
        }
    }
}
