package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0604k7;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.t3  reason: case insensitive filesystem */
final class C0863t3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ M5 f3226a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Bundle f3227b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ X2 f3228c;

    C0863t3(X2 x22, M5 m5, Bundle bundle) {
        this.f3226a = m5;
        this.f3227b = bundle;
        this.f3228c = x22;
    }

    public final /* synthetic */ Object call() {
        this.f3228c.f2792a.z0();
        H5 i4 = this.f3228c.f2792a;
        M5 m5 = this.f3226a;
        Bundle bundle = this.f3227b;
        i4.f().k();
        if (!C0604k7.a() || !i4.i0().F(m5.f2631a, G.f2421I0) || m5.f2631a == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    i4.a().G().a("Uri sources and timestamps do not match");
                } else {
                    for (int i5 = 0; i5 < intArray.length; i5++) {
                        C0797k l02 = i4.l0();
                        String str = m5.f2631a;
                        int i6 = intArray[i5];
                        long j4 = longArray[i5];
                        C0335p.f(str);
                        l02.k();
                        l02.r();
                        try {
                            int delete = l02.y().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i6), String.valueOf(j4)});
                            C0835p2 K4 = l02.a().K();
                            K4.d("Pruned " + delete + " trigger URIs. appId, source, timestamp", str, Integer.valueOf(i6), Long.valueOf(j4));
                        } catch (SQLiteException e5) {
                            l02.a().G().c("Error pruning trigger URIs. appId", C0821n2.s(str), e5);
                        }
                    }
                }
            }
        }
        return i4.l0().X0(m5.f2631a);
    }
}
