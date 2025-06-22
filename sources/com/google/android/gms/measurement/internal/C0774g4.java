package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.U0;

/* renamed from: com.google.android.gms.measurement.internal.g4  reason: case insensitive filesystem */
final class C0774g4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ U0 f3004a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F3 f3005b;

    C0774g4(F3 f32, U0 u02) {
        this.f3004a = u02;
        this.f3005b = f32;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0069 A[SYNTHETIC, Splitter:B:12:0x0069] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.F3 r0 = r7.f3005b
            com.google.android.gms.measurement.internal.p5 r0 = r0.r()
            com.google.android.gms.measurement.internal.z2 r1 = r0.e()
            com.google.android.gms.measurement.internal.A3 r1 = r1.M()
            boolean r1 = r1.z()
            r2 = 0
            if (r1 != 0) goto L_0x0024
            com.google.android.gms.measurement.internal.n2 r0 = r0.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.M()
            java.lang.String r1 = "Analytics storage consent denied; will not get session id"
            r0.a(r1)
        L_0x0022:
            r0 = r2
            goto L_0x0055
        L_0x0024:
            com.google.android.gms.measurement.internal.z2 r1 = r0.e()
            R.d r3 = r0.B()
            long r3 = r3.currentTimeMillis()
            boolean r1 = r1.w(r3)
            if (r1 != 0) goto L_0x0022
            com.google.android.gms.measurement.internal.z2 r1 = r0.e()
            com.google.android.gms.measurement.internal.A2 r1 = r1.f3334s
            long r3 = r1.a()
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0047
            goto L_0x0022
        L_0x0047:
            com.google.android.gms.measurement.internal.z2 r0 = r0.e()
            com.google.android.gms.measurement.internal.A2 r0 = r0.f3334s
            long r0 = r0.a()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L_0x0055:
            if (r0 == 0) goto L_0x0069
            com.google.android.gms.measurement.internal.F3 r1 = r7.f3005b
            com.google.android.gms.measurement.internal.S2 r1 = r1.f3273a
            com.google.android.gms.measurement.internal.d6 r1 = r1.L()
            com.google.android.gms.internal.measurement.U0 r2 = r7.f3004a
            long r3 = r0.longValue()
            r1.Q(r2, r3)
            return
        L_0x0069:
            com.google.android.gms.internal.measurement.U0 r0 = r7.f3004a     // Catch:{ RemoteException -> 0x006f }
            r0.f(r2)     // Catch:{ RemoteException -> 0x006f }
            return
        L_0x006f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.F3 r1 = r7.f3005b
            com.google.android.gms.measurement.internal.S2 r1 = r1.f3273a
            com.google.android.gms.measurement.internal.n2 r1 = r1.a()
            com.google.android.gms.measurement.internal.p2 r1 = r1.G()
            java.lang.String r2 = "getSessionId failed with exception"
            r1.b(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0774g4.run():void");
    }
}
