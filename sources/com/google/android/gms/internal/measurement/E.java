package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class E {

    /* renamed from: a  reason: collision with root package name */
    private Map f1450a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private U f1451b = new U();

    public E() {
        b(new C0711y());
        b(new D());
        b(new F());
        b(new J());
        b(new L());
        b(new S());
        b(new X());
    }

    private final void b(A a5) {
        for (Z z4 : a5.f1393a) {
            this.f1450a.put(z4.toString(), a5);
        }
    }

    public final C0663s a(Z2 z22, C0663s sVar) {
        A a5;
        C0690v2.b(z22);
        if (!(sVar instanceof C0687v)) {
            return sVar;
        }
        C0687v vVar = (C0687v) sVar;
        ArrayList c5 = vVar.c();
        String a6 = vVar.a();
        if (this.f1450a.containsKey(a6)) {
            a5 = (A) this.f1450a.get(a6);
        } else {
            a5 = this.f1451b;
        }
        return a5.b(a6, z22, c5);
    }
}
