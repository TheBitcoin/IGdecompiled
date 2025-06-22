package com.google.android.gms.measurement.internal;

import java.util.Map;

final class O5 implements C0862t2 {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f2671a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ V5 f2672b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ H5 f2673c;

    O5(H5 h5, String str, V5 v5) {
        this.f2671a = str;
        this.f2672b = v5;
        this.f2673c = h5;
    }

    public final void a(String str, int i4, Throwable th, byte[] bArr, Map map) {
        this.f2673c.y(this.f2671a, i4, th, bArr, this.f2672b);
    }
}
