package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.n  reason: case insensitive filesystem */
public abstract class C0623n implements C0614m, C0663s {

    /* renamed from: a  reason: collision with root package name */
    protected final String f2065a;

    /* renamed from: b  reason: collision with root package name */
    protected final Map f2066b = new HashMap();

    public C0623n(String str) {
        this.f2065a = str;
    }

    public final Boolean C() {
        return Boolean.TRUE;
    }

    public final Double D() {
        return Double.valueOf(Double.NaN);
    }

    public final String E() {
        return this.f2065a;
    }

    public final Iterator F() {
        return C0640p.b(this.f2066b);
    }

    public final C0663s G(String str, Z2 z22, List list) {
        if ("toString".equals(str)) {
            return new C0679u(this.f2065a);
        }
        return C0640p.a(this, new C0679u(str), z22, list);
    }

    public abstract C0663s a(Z2 z22, List list);

    public C0663s b() {
        return this;
    }

    public final C0663s c(String str) {
        if (this.f2066b.containsKey(str)) {
            return (C0663s) this.f2066b.get(str);
        }
        return C0663s.f2138b0;
    }

    public final String d() {
        return this.f2065a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0623n)) {
            return false;
        }
        C0623n nVar = (C0623n) obj;
        String str = this.f2065a;
        if (str != null) {
            return str.equals(nVar.f2065a);
        }
        return false;
    }

    public final boolean g(String str) {
        return this.f2066b.containsKey(str);
    }

    public final void h(String str, C0663s sVar) {
        if (sVar == null) {
            this.f2066b.remove(str);
        } else {
            this.f2066b.put(str, sVar);
        }
    }

    public int hashCode() {
        String str = this.f2065a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
