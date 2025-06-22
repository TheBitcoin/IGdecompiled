package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import j0.a;
import java.util.concurrent.TimeUnit;

abstract class i0 {

    /* renamed from: a  reason: collision with root package name */
    static final long f11396a = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: b  reason: collision with root package name */
    private static final Object f11397b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static a f11398c;

    private static void b(Context context) {
        if (f11398c == null) {
            a aVar = new a(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            f11398c = aVar;
            aVar.d(true);
        }
    }

    /* access modifiers changed from: package-private */
    public static void c(Intent intent) {
        synchronized (f11397b) {
            try {
                if (f11398c != null && d(intent)) {
                    f(intent, false);
                    f11398c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static boolean d(Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    static void e(Context context, n0 n0Var, Intent intent) {
        synchronized (f11397b) {
            try {
                b(context);
                boolean d5 = d(intent);
                f(intent, true);
                if (!d5) {
                    f11398c.a(f11396a);
                }
                n0Var.d(intent).c(new h0(intent));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void f(Intent intent, boolean z4) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.content.ComponentName g(android.content.Context r3, android.content.Intent r4) {
        /*
            java.lang.Object r0 = f11397b
            monitor-enter(r0)
            b(r3)     // Catch:{ all -> 0x0017 }
            boolean r1 = d(r4)     // Catch:{ all -> 0x0017 }
            r2 = 1
            f(r4, r2)     // Catch:{ all -> 0x0017 }
            android.content.ComponentName r3 = r3.startService(r4)     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x0019
            r3 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return r3
        L_0x0017:
            r3 = move-exception
            goto L_0x0024
        L_0x0019:
            if (r1 != 0) goto L_0x0022
            j0.a r4 = f11398c     // Catch:{ all -> 0x0017 }
            long r1 = f11396a     // Catch:{ all -> 0x0017 }
            r4.a(r1)     // Catch:{ all -> 0x0017 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return r3
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.i0.g(android.content.Context, android.content.Intent):android.content.ComponentName");
    }
}
