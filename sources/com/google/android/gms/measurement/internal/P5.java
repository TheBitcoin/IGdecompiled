package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

final class P5 implements C0862t2 {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f2689a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ List f2690b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ H5 f2691c;

    P5(H5 h5, String str, List list) {
        this.f2689a = str;
        this.f2690b = list;
        this.f2691c = h5;
    }

    public final void a(String str, int i4, Throwable th, byte[] bArr, Map map) {
        this.f2691c.L(true, i4, th, bArr, this.f2689a, this.f2690b);
    }
}
