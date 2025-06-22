package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.r5  reason: case insensitive filesystem */
final class C0661r5 implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f2133a;

    /* renamed from: b  reason: collision with root package name */
    private Iterator f2134b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ C0646p5 f2135c;

    private final Iterator a() {
        if (this.f2134b == null) {
            this.f2134b = this.f2135c.f2106f.entrySet().iterator();
        }
        return this.f2134b;
    }

    public final boolean hasNext() {
        int i4 = this.f2133a;
        if ((i4 <= 0 || i4 > this.f2135c.f2102b) && !a().hasNext()) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ Object next() {
        if (a().hasNext()) {
            return (Map.Entry) a().next();
        }
        Object[] p4 = this.f2135c.f2101a;
        int i4 = this.f2133a - 1;
        this.f2133a = i4;
        return (C0677t5) p4[i4];
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private C0661r5(C0646p5 p5Var) {
        this.f2135c = p5Var;
        this.f2133a = p5Var.f2102b;
    }
}
