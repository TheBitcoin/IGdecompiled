package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.Handler;
import com.google.android.gms.internal.measurement.N0;

/* renamed from: com.google.android.gms.measurement.internal.t  reason: case insensitive filesystem */
abstract class C0859t {

    /* renamed from: d  reason: collision with root package name */
    private static volatile Handler f3222d;

    /* renamed from: a  reason: collision with root package name */
    private final C0898y3 f3223a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f3224b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public volatile long f3225c;

    C0859t(C0898y3 y3Var) {
        C0335p.l(y3Var);
        this.f3223a = y3Var;
        this.f3224b = new C0880w(this, y3Var);
    }

    private final Handler f() {
        Handler handler;
        if (f3222d != null) {
            return f3222d;
        }
        synchronized (C0859t.class) {
            try {
                if (f3222d == null) {
                    f3222d = new N0(this.f3223a.A().getMainLooper());
                }
                handler = f3222d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f3225c = 0;
        f().removeCallbacks(this.f3224b);
    }

    public final void b(long j4) {
        a();
        if (j4 >= 0) {
            this.f3225c = this.f3223a.B().currentTimeMillis();
            if (!f().postDelayed(this.f3224b, j4)) {
                this.f3223a.a().G().b("Failed to schedule delayed post. time", Long.valueOf(j4));
            }
        }
    }

    public abstract void d();

    public final boolean e() {
        if (this.f3225c != 0) {
            return true;
        }
        return false;
    }
}
