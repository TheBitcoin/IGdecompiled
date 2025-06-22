package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class Z2 {

    /* renamed from: a  reason: collision with root package name */
    private final Z2 f1734a;

    /* renamed from: b  reason: collision with root package name */
    private E f1735b;

    /* renamed from: c  reason: collision with root package name */
    private Map f1736c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Map f1737d = new HashMap();

    public Z2(Z2 z22, E e5) {
        this.f1734a = z22;
        this.f1735b = e5;
    }

    public final C0663s a(C0560g gVar) {
        C0663s sVar = C0663s.f2138b0;
        Iterator s4 = gVar.s();
        while (s4.hasNext()) {
            sVar = this.f1735b.a(this, gVar.k(((Integer) s4.next()).intValue()));
            if (sVar instanceof C0605l) {
                break;
            }
        }
        return sVar;
    }

    public final C0663s b(C0663s sVar) {
        return this.f1735b.a(this, sVar);
    }

    public final C0663s c(String str) {
        Z2 z22 = this;
        while (!z22.f1736c.containsKey(str)) {
            z22 = z22.f1734a;
            if (z22 == null) {
                throw new IllegalArgumentException(String.format("%s is not defined", new Object[]{str}));
            }
        }
        return (C0663s) z22.f1736c.get(str);
    }

    public final Z2 d() {
        return new Z2(this, this.f1735b);
    }

    public final void e(String str, C0663s sVar) {
        if (this.f1737d.containsKey(str)) {
            return;
        }
        if (sVar == null) {
            this.f1736c.remove(str);
        } else {
            this.f1736c.put(str, sVar);
        }
    }

    public final void f(String str, C0663s sVar) {
        e(str, sVar);
        this.f1737d.put(str, Boolean.TRUE);
    }

    public final boolean g(String str) {
        Z2 z22 = this;
        while (!z22.f1736c.containsKey(str)) {
            z22 = z22.f1734a;
            if (z22 == null) {
                return false;
            }
        }
        return true;
    }

    public final void h(String str, C0663s sVar) {
        Z2 z22 = this;
        while (!z22.f1736c.containsKey(str) && (r1 = z22.f1734a) != null && r1.g(str)) {
            z22 = z22.f1734a;
        }
        if (z22.f1737d.containsKey(str)) {
            return;
        }
        if (sVar == null) {
            z22.f1736c.remove(str);
        } else {
            z22.f1736c.put(str, sVar);
        }
    }
}
