package g0;

import J.C0309h;
import J.C0310i;
import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final C0309h f3390a = C0309h.f();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3391b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static Method f3392c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Method f3393d = null;

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r15) {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            r3 = 3
            java.lang.String r4 = "Context must not be null"
            M.C0335p.m(r15, r4)
            J.h r4 = f3390a
            r5 = 11925000(0xb5f608, float:1.6710484E-38)
            r4.k(r15, r5)
            java.lang.Object r4 = f3391b
            monitor-enter(r4)
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0026 }
            r7 = 0
            com.google.android.gms.dynamite.DynamiteModule$b r8 = com.google.android.gms.dynamite.DynamiteModule.f1374f     // Catch:{ a -> 0x0029 }
            java.lang.String r9 = "com.google.android.gms.providerinstaller.dynamite"
            com.google.android.gms.dynamite.DynamiteModule r8 = com.google.android.gms.dynamite.DynamiteModule.e(r15, r8, r9)     // Catch:{ a -> 0x0029 }
            android.content.Context r8 = r8.b()     // Catch:{ a -> 0x0029 }
            goto L_0x003e
        L_0x0026:
            r15 = move-exception
            goto L_0x00af
        L_0x0029:
            r8 = move-exception
            java.lang.String r9 = "ProviderInstaller"
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x0026 }
            java.lang.String r10 = "Failed to load providerinstaller module: "
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0026 }
            java.lang.String r8 = r10.concat(r8)     // Catch:{ all -> 0x0026 }
            android.util.Log.w(r9, r8)     // Catch:{ all -> 0x0026 }
            r8 = r7
        L_0x003e:
            if (r8 == 0) goto L_0x0047
            java.lang.String r0 = "com.google.android.gms.providerinstaller.ProviderInstallerImpl"
            c(r8, r15, r0)     // Catch:{ all -> 0x0026 }
            monitor-exit(r4)     // Catch:{ all -> 0x0026 }
            goto L_0x009f
        L_0x0047:
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0026 }
            android.content.Context r10 = J.C0313l.d(r15)     // Catch:{ all -> 0x0026 }
            if (r10 == 0) goto L_0x0097
            java.lang.reflect.Method r11 = f3393d     // Catch:{ Exception -> 0x006c }
            if (r11 != 0) goto L_0x006e
            java.lang.String r11 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            java.lang.String r12 = "reportRequestStats"
            java.lang.Class[] r13 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x006c }
            java.lang.Class<android.content.Context> r14 = android.content.Context.class
            r13[r2] = r14     // Catch:{ Exception -> 0x006c }
            java.lang.Class r14 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x006c }
            r13[r1] = r14     // Catch:{ Exception -> 0x006c }
            r13[r0] = r14     // Catch:{ Exception -> 0x006c }
            java.lang.reflect.Method r11 = b(r10, r11, r12, r13)     // Catch:{ Exception -> 0x006c }
            f3393d = r11     // Catch:{ Exception -> 0x006c }
            goto L_0x006e
        L_0x006c:
            r0 = move-exception
            goto L_0x0084
        L_0x006e:
            java.lang.reflect.Method r11 = f3393d     // Catch:{ Exception -> 0x006c }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x006c }
            java.lang.Long r6 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x006c }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x006c }
            r3[r2] = r15     // Catch:{ Exception -> 0x006c }
            r3[r1] = r5     // Catch:{ Exception -> 0x006c }
            r3[r0] = r6     // Catch:{ Exception -> 0x006c }
            r11.invoke(r7, r3)     // Catch:{ Exception -> 0x006c }
            goto L_0x0097
        L_0x0084:
            java.lang.String r1 = "ProviderInstaller"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0026 }
            java.lang.String r2 = "Failed to report request stats: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0026 }
            java.lang.String r0 = r2.concat(r0)     // Catch:{ all -> 0x0026 }
            android.util.Log.w(r1, r0)     // Catch:{ all -> 0x0026 }
        L_0x0097:
            if (r10 == 0) goto L_0x00a0
            java.lang.String r0 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            c(r10, r15, r0)     // Catch:{ all -> 0x0026 }
            monitor-exit(r4)     // Catch:{ all -> 0x0026 }
        L_0x009f:
            return
        L_0x00a0:
            java.lang.String r15 = "ProviderInstaller"
            java.lang.String r0 = "Failed to get remote context"
            android.util.Log.e(r15, r0)     // Catch:{ all -> 0x0026 }
            J.i r15 = new J.i     // Catch:{ all -> 0x0026 }
            r0 = 8
            r15.<init>(r0)     // Catch:{ all -> 0x0026 }
            throw r15     // Catch:{ all -> 0x0026 }
        L_0x00af:
            monitor-exit(r4)     // Catch:{ all -> 0x0026 }
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.a.a(android.content.Context):void");
    }

    private static Method b(Context context, String str, String str2, Class[] clsArr) {
        return context.getClassLoader().loadClass(str).getMethod(str2, clsArr);
    }

    private static void c(Context context, Context context2, String str) {
        String str2;
        try {
            if (f3392c == null) {
                f3392c = b(context, str, "insertProvider", new Class[]{Context.class});
            }
            f3392c.invoke((Object) null, new Object[]{context});
        } catch (Exception e5) {
            Throwable cause = e5.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                if (cause == null) {
                    str2 = e5.getMessage();
                } else {
                    str2 = cause.getMessage();
                }
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(str2)));
            }
            throw new C0310i(8);
        }
    }
}
