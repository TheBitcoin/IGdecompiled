package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicReference;

public final class Q0 extends T0 {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference f1595a = new AtomicReference();

    /* renamed from: b  reason: collision with root package name */
    private boolean f1596b;

    public static Object k(Bundle bundle, Class cls) {
        Object obj;
        if (bundle == null || (obj = bundle.get(CampaignEx.JSON_KEY_AD_R)) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e5) {
            String canonicalName = cls.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            Log.w("AM", String.format("Unexpected object type. Expected, Received" + ": %s, %s", new Object[]{canonicalName, canonicalName2}), e5);
            throw e5;
        }
    }

    public final void f(Bundle bundle) {
        synchronized (this.f1595a) {
            try {
                this.f1595a.set(bundle);
                this.f1596b = true;
                this.f1595a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle i(long r3) {
        /*
            r2 = this;
            java.util.concurrent.atomic.AtomicReference r0 = r2.f1595a
            monitor-enter(r0)
            boolean r1 = r2.f1596b     // Catch:{ all -> 0x000d }
            if (r1 != 0) goto L_0x0012
            java.util.concurrent.atomic.AtomicReference r1 = r2.f1595a     // Catch:{ InterruptedException -> 0x000f }
            r1.wait(r3)     // Catch:{ InterruptedException -> 0x000f }
            goto L_0x0012
        L_0x000d:
            r3 = move-exception
            goto L_0x001c
        L_0x000f:
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            r3 = 0
            return r3
        L_0x0012:
            java.util.concurrent.atomic.AtomicReference r3 = r2.f1595a     // Catch:{ all -> 0x000d }
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x000d }
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch:{ all -> 0x000d }
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            return r3
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.Q0.i(long):android.os.Bundle");
    }

    public final Long l0(long j4) {
        return (Long) k(i(j4), Long.class);
    }

    public final String m0(long j4) {
        return (String) k(i(j4), String.class);
    }
}
