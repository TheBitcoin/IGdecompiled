package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import l0.g;

/* renamed from: com.google.android.gms.internal.measurement.i3  reason: case insensitive filesystem */
public abstract class C0582i3 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile g f1933a = g.a();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f1934b = new Object();

    private static boolean a(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & TsExtractor.TS_STREAM_TYPE_AC3) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        if ("com.google.android.gms".equals(r0.packageName) != false) goto L_0x0081;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(android.content.Context r5, android.net.Uri r6) {
        /*
            java.lang.String r6 = r6.getAuthority()
            java.lang.String r0 = "com.google.android.gms.phenotype"
            boolean r0 = r0.equals(r6)
            r1 = 0
            if (r0 != 0) goto L_0x0024
            java.lang.String r5 = "PhenotypeClientHelper"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r6 = " is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            android.util.Log.e(r5, r6)
            return r1
        L_0x0024:
            l0.g r6 = f1933a
            boolean r6 = r6.c()
            if (r6 == 0) goto L_0x0039
            l0.g r5 = f1933a
            java.lang.Object r5 = r5.b()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        L_0x0039:
            java.lang.Object r6 = f1934b
            monitor-enter(r6)
            l0.g r0 = f1933a     // Catch:{ all -> 0x0052 }
            boolean r0 = r0.c()     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0054
            l0.g r5 = f1933a     // Catch:{ all -> 0x0052 }
            java.lang.Object r5 = r5.b()     // Catch:{ all -> 0x0052 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x0052 }
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x0052 }
            monitor-exit(r6)     // Catch:{ all -> 0x0052 }
            return r5
        L_0x0052:
            r5 = move-exception
            goto L_0x00a0
        L_0x0054:
            java.lang.String r0 = "com.google.android.gms"
            java.lang.String r2 = r5.getPackageName()     // Catch:{ all -> 0x0052 }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0061
            goto L_0x0081
        L_0x0061:
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch:{ all -> 0x0052 }
            java.lang.String r2 = "com.google.android.gms.phenotype"
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0052 }
            r4 = 29
            if (r3 >= r4) goto L_0x006f
            r3 = 0
            goto L_0x0071
        L_0x006f:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0071:
            android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r2, r3)     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0088
            java.lang.String r2 = "com.google.android.gms"
            java.lang.String r0 = r0.packageName     // Catch:{ all -> 0x0052 }
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0088
        L_0x0081:
            boolean r5 = a(r5)     // Catch:{ all -> 0x0052 }
            if (r5 == 0) goto L_0x0088
            r1 = 1
        L_0x0088:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0052 }
            l0.g r5 = l0.g.d(r5)     // Catch:{ all -> 0x0052 }
            f1933a = r5     // Catch:{ all -> 0x0052 }
            monitor-exit(r6)     // Catch:{ all -> 0x0052 }
            l0.g r5 = f1933a
            java.lang.Object r5 = r5.b()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        L_0x00a0:
            monitor-exit(r6)     // Catch:{ all -> 0x0052 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C0582i3.b(android.content.Context, android.net.Uri):boolean");
    }
}
