package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

final class L5 implements C0862t2 {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f2617a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ List f2618b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ H5 f2619c;

    L5(H5 h5, String str, List list) {
        this.f2617a = str;
        this.f2618b = list;
        this.f2619c = h5;
    }

    public final void a(String str, int i4, Throwable th, byte[] bArr, Map map) {
        this.f2619c.L(true, i4, th, bArr, this.f2617a, this.f2618b);
    }
}
