package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.q  reason: case insensitive filesystem */
public final class C0648q implements C0663s {
    public final Boolean C() {
        return Boolean.FALSE;
    }

    public final Double D() {
        return Double.valueOf(0.0d);
    }

    public final String E() {
        return "null";
    }

    public final Iterator F() {
        return null;
    }

    public final C0663s G(String str, Z2 z22, List list) {
        throw new IllegalStateException(String.format("null has no function %s", new Object[]{str}));
    }

    public final C0663s b() {
        return C0663s.f2139c0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof C0648q;
    }

    public final int hashCode() {
        return 1;
    }
}
