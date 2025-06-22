package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.d5  reason: case insensitive filesystem */
final class C0539d5 implements C0638o5 {

    /* renamed from: a  reason: collision with root package name */
    private final Z4 f1804a;

    /* renamed from: b  reason: collision with root package name */
    private final E5 f1805b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1806c;

    /* renamed from: d  reason: collision with root package name */
    private final C0574h4 f1807d;

    private C0539d5(E5 e5, C0574h4 h4Var, Z4 z4) {
        this.f1805b = e5;
        this.f1806c = h4Var.d(z4);
        this.f1807d = h4Var;
        this.f1804a = z4;
    }

    static C0539d5 i(E5 e5, C0574h4 h4Var, Z4 z4) {
        return new C0539d5(e5, h4Var, z4);
    }

    public final Object A() {
        Z4 z4 = this.f1804a;
        if (z4 instanceof C0668s4) {
            return ((C0668s4) z4).z();
        }
        return z4.c().u();
    }

    public final int a(Object obj) {
        E5 e5 = this.f1805b;
        int e6 = e5.e(e5.k(obj));
        if (this.f1806c) {
            return e6 + this.f1807d.b(obj).a();
        }
        return e6;
    }

    public final boolean b(Object obj) {
        return this.f1807d.b(obj).n();
    }

    public final void c(Object obj) {
        this.f1805b.l(obj);
        this.f1807d.f(obj);
    }

    public final int d(Object obj) {
        int hashCode = this.f1805b.k(obj).hashCode();
        if (this.f1806c) {
            return (hashCode * 53) + this.f1807d.b(obj).hashCode();
        }
        return hashCode;
    }

    public final void e(Object obj, Object obj2) {
        C0654q5.n(this.f1805b, obj, obj2);
        if (this.f1806c) {
            C0654q5.l(this.f1807d, obj, obj2);
        }
    }

    public final void f(Object obj, W5 w5) {
        Iterator l4 = this.f1807d.b(obj).l();
        if (!l4.hasNext()) {
            E5 e5 = this.f1805b;
            e5.d(e5.k(obj), w5);
            return;
        }
        a.a(((Map.Entry) l4.next()).getKey());
        throw null;
    }

    public final void g(Object obj, byte[] bArr, int i4, int i5, J3 j32) {
        C0668s4 s4Var = (C0668s4) obj;
        if (s4Var.zzb == D5.k()) {
            s4Var.zzb = D5.l();
        }
        a.a(obj);
        throw null;
    }

    public final boolean h(Object obj, Object obj2) {
        if (!this.f1805b.k(obj).equals(this.f1805b.k(obj2))) {
            return false;
        }
        if (this.f1806c) {
            return this.f1807d.b(obj).equals(this.f1807d.b(obj2));
        }
        return true;
    }
}
