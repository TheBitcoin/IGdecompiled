package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.measurement.x1  reason: case insensitive filesystem */
public final class C0705x1 {

    /* renamed from: a  reason: collision with root package name */
    private final E f2247a;

    /* renamed from: b  reason: collision with root package name */
    final Z2 f2248b;

    /* renamed from: c  reason: collision with root package name */
    final Z2 f2249c;

    /* renamed from: d  reason: collision with root package name */
    private final W4 f2250d;

    public C0705x1() {
        E e5 = new E();
        this.f2247a = e5;
        Z2 z22 = new Z2((Z2) null, e5);
        this.f2249c = z22;
        this.f2248b = z22.d();
        W4 w4 = new W4();
        this.f2250d = w4;
        z22.h("require", new N7(w4));
        w4.b("internal.platform", new C0562g1());
        z22.h("runtime.counter", new C0596k(Double.valueOf(0.0d)));
    }

    public final C0663s a(Z2 z22, C2... c2Arr) {
        C0663s sVar = C0663s.f2138b0;
        for (C2 a5 : c2Arr) {
            sVar = C0511a4.a(a5);
            C0690v2.b(this.f2249c);
            if ((sVar instanceof C0687v) || (sVar instanceof C0671t)) {
                sVar = this.f2247a.a(z22, sVar);
            }
        }
        return sVar;
    }

    public final void b(String str, Callable callable) {
        this.f2250d.b(str, callable);
    }
}
