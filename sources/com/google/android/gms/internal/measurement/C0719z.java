package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.z  reason: case insensitive filesystem */
public final class C0719z implements C0663s {
    public final Boolean C() {
        return Boolean.FALSE;
    }

    public final Double D() {
        return Double.valueOf(Double.NaN);
    }

    public final String E() {
        return "undefined";
    }

    public final Iterator F() {
        return null;
    }

    public final C0663s G(String str, Z2 z22, List list) {
        throw new IllegalStateException(String.format("Undefined has no function %s", new Object[]{str}));
    }

    public final C0663s b() {
        return C0663s.f2138b0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof C0719z;
    }
}
