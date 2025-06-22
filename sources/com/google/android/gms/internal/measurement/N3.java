package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

final class N3 extends P3 {

    /* renamed from: a  reason: collision with root package name */
    private int f1578a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f1579b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ K3 f1580c;

    N3(K3 k32) {
        this.f1580c = k32;
        this.f1579b = k32.q();
    }

    public final byte A() {
        int i4 = this.f1578a;
        if (i4 < this.f1579b) {
            this.f1578a = i4 + 1;
            return this.f1580c.p(i4);
        }
        throw new NoSuchElementException();
    }

    public final boolean hasNext() {
        if (this.f1578a < this.f1579b) {
            return true;
        }
        return false;
    }
}
