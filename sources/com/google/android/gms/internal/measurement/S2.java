package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

public abstract class S2 {

    /* renamed from: a  reason: collision with root package name */
    private static UserManager f1611a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f1612b = (!a());

    public static boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    public static boolean b(Context context) {
        if (!a() || d(context)) {
            return false;
        }
        return true;
    }

    public static boolean c(Context context) {
        if (!a() || d(context)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001a, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean d(android.content.Context r3) {
        /*
            boolean r0 = f1612b
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.Class<com.google.android.gms.internal.measurement.S2> r0 = com.google.android.gms.internal.measurement.S2.class
            monitor-enter(r0)
            boolean r2 = f1612b     // Catch:{ all -> 0x000f }
            if (r2 == 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r1
        L_0x000f:
            r3 = move-exception
            goto L_0x001b
        L_0x0011:
            boolean r3 = e(r3)     // Catch:{ all -> 0x000f }
            if (r3 == 0) goto L_0x0019
            f1612b = r3     // Catch:{ all -> 0x000f }
        L_0x0019:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r3
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.S2.d(android.content.Context):boolean");
    }

    private static boolean e(Context context) {
        boolean z4;
        boolean z5 = true;
        int i4 = 1;
        while (true) {
            z4 = false;
            if (i4 > 2) {
                break;
            }
            if (f1611a == null) {
                f1611a = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = f1611a;
            if (userManager == null) {
                return true;
            }
            try {
                if (!userManager.isUserUnlocked() && userManager.isUserRunning(Process.myUserHandle())) {
                    z5 = false;
                }
                z4 = z5;
            } catch (NullPointerException e5) {
                Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e5);
                f1611a = null;
                i4++;
            }
        }
        if (z4) {
            f1611a = null;
        }
        return z4;
    }
}
