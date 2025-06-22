package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.x5  reason: case insensitive filesystem */
final class C0709x5 implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f2252a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2253b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator f2254c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ C0646p5 f2255d;

    private final Iterator a() {
        if (this.f2254c == null) {
            this.f2254c = this.f2255d.f2103c.entrySet().iterator();
        }
        return this.f2254c;
    }

    public final boolean hasNext() {
        if (this.f2252a + 1 < this.f2255d.f2102b || (!this.f2255d.f2103c.isEmpty() && a().hasNext())) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object next() {
        this.f2253b = true;
        int i4 = this.f2252a + 1;
        this.f2252a = i4;
        if (i4 < this.f2255d.f2102b) {
            return (C0677t5) this.f2255d.f2101a[this.f2252a];
        }
        return (Map.Entry) a().next();
    }

    public final void remove() {
        if (this.f2253b) {
            this.f2253b = false;
            this.f2255d.r();
            if (this.f2252a < this.f2255d.f2102b) {
                C0646p5 p5Var = this.f2255d;
                int i4 = this.f2252a;
                this.f2252a = i4 - 1;
                Object unused = p5Var.i(i4);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private C0709x5(C0646p5 p5Var) {
        this.f2255d = p5Var;
        this.f2252a = -1;
    }
}
