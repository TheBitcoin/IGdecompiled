package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.h  reason: case insensitive filesystem */
public final class C0569h implements C0663s {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1913a;

    public C0569h(Boolean bool) {
        if (bool == null) {
            this.f1913a = false;
        } else {
            this.f1913a = bool.booleanValue();
        }
    }

    public final Boolean C() {
        return Boolean.valueOf(this.f1913a);
    }

    public final Double D() {
        double d5;
        if (this.f1913a) {
            d5 = 1.0d;
        } else {
            d5 = 0.0d;
        }
        return Double.valueOf(d5);
    }

    public final String E() {
        return Boolean.toString(this.f1913a);
    }

    public final Iterator F() {
        return null;
    }

    public final C0663s G(String str, Z2 z22, List list) {
        if ("toString".equals(str)) {
            return new C0679u(Boolean.toString(this.f1913a));
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[]{Boolean.toString(this.f1913a), str}));
    }

    public final C0663s b() {
        return new C0569h(Boolean.valueOf(this.f1913a));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof C0569h) && this.f1913a == ((C0569h) obj).f1913a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.f1913a).hashCode();
    }

    public final String toString() {
        return String.valueOf(this.f1913a);
    }
}
