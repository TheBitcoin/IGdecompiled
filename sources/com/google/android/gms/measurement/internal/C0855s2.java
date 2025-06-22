package com.google.android.gms.measurement.internal;

import M.C0335p;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.s2  reason: case insensitive filesystem */
final class C0855s2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final C0862t2 f3210a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3211b;

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f3212c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f3213d;

    /* renamed from: e  reason: collision with root package name */
    private final String f3214e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f3215f;

    public final void run() {
        this.f3210a.a(this.f3214e, this.f3211b, this.f3212c, this.f3213d, this.f3215f);
    }

    private C0855s2(String str, C0862t2 t2Var, int i4, Throwable th, byte[] bArr, Map map) {
        C0335p.l(t2Var);
        this.f3210a = t2Var;
        this.f3211b = i4;
        this.f3212c = th;
        this.f3213d = bArr;
        this.f3214e = str;
        this.f3215f = map;
    }
}
