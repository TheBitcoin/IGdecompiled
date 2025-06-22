package b1;

import android.util.Base64;
import m3.m;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static final x f9061a = new x();

    /* renamed from: b  reason: collision with root package name */
    private static final String f9062b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f9063c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f9064d;

    static {
        String encodeToString = Base64.encodeToString(m.m(w.f9060a.e()), 10);
        f9062b = encodeToString;
        f9063c = "firebase_session_" + encodeToString + "_data";
        f9064d = "firebase_session_" + encodeToString + "_settings";
    }

    private x() {
    }

    public final String a() {
        return f9063c;
    }

    public final String b() {
        return f9064d;
    }
}
