package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import androidx.core.content.PermissionChecker;

/* renamed from: com.google.android.gms.internal.measurement.c3  reason: case insensitive filesystem */
final class C0528c3 implements C0519b3 {

    /* renamed from: c  reason: collision with root package name */
    private static C0528c3 f1774c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f1775a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentObserver f1776b;

    private C0528c3() {
        this.f1775a = null;
        this.f1776b = null;
    }

    static C0528c3 a(Context context) {
        C0528c3 c3Var;
        C0528c3 c3Var2;
        synchronized (C0528c3.class) {
            try {
                if (f1774c == null) {
                    if (PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                        c3Var2 = new C0528c3(context);
                    } else {
                        c3Var2 = new C0528c3();
                    }
                    f1774c = c3Var2;
                }
                c3Var = f1774c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c3Var;
    }

    static synchronized void b() {
        Context context;
        synchronized (C0528c3.class) {
            try {
                C0528c3 c3Var = f1774c;
                if (!(c3Var == null || (context = c3Var.f1775a) == null || c3Var.f1776b == null)) {
                    context.getContentResolver().unregisterContentObserver(f1774c.f1776b);
                }
                f1774c = null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final String c(String str) {
        Context context = this.f1775a;
        if (context != null && !S2.b(context)) {
            try {
                return (String) C0510a3.a(new C0555f3(this, str));
            } catch (IllegalStateException | NullPointerException | SecurityException e5) {
                Log.e("GservicesLoader", "Unable to read GServices for: " + str, e5);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String d(String str) {
        return I2.a(this.f1775a.getContentResolver(), str, (String) null);
    }

    private C0528c3(Context context) {
        this.f1775a = context;
        C0546e3 e3Var = new C0546e3(this, (Handler) null);
        this.f1776b = e3Var;
        context.getContentResolver().registerContentObserver(H2.f1489a, true, e3Var);
    }
}
