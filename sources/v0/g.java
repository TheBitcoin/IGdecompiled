package v0;

import android.util.Log;

public class g {

    /* renamed from: c  reason: collision with root package name */
    static final g f21975c = new g("FirebaseCrashlytics");

    /* renamed from: a  reason: collision with root package name */
    private final String f21976a;

    /* renamed from: b  reason: collision with root package name */
    private int f21977b = 4;

    public g(String str) {
        this.f21976a = str;
    }

    private boolean a(int i4) {
        if (this.f21977b <= i4 || Log.isLoggable(this.f21976a, i4)) {
            return true;
        }
        return false;
    }

    public static g f() {
        return f21975c;
    }

    public void b(String str) {
        c(str, (Throwable) null);
    }

    public void c(String str, Throwable th) {
        if (a(3)) {
            Log.d(this.f21976a, str, th);
        }
    }

    public void d(String str) {
        e(str, (Throwable) null);
    }

    public void e(String str, Throwable th) {
        if (a(6)) {
            Log.e(this.f21976a, str, th);
        }
    }

    public void g(String str) {
        h(str, (Throwable) null);
    }

    public void h(String str, Throwable th) {
        if (a(4)) {
            Log.i(this.f21976a, str, th);
        }
    }

    public void i(String str) {
        j(str, (Throwable) null);
    }

    public void j(String str, Throwable th) {
        if (a(2)) {
            Log.v(this.f21976a, str, th);
        }
    }

    public void k(String str) {
        l(str, (Throwable) null);
    }

    public void l(String str, Throwable th) {
        if (a(5)) {
            Log.w(this.f21976a, str, th);
        }
    }
}
