package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.measurement.i  reason: case insensitive filesystem */
final class C0578i implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f1923a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C0560g f1924b;

    C0578i(C0560g gVar) {
        this.f1924b = gVar;
    }

    public final boolean hasNext() {
        if (this.f1923a < this.f1924b.n()) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object next() {
        if (this.f1923a < this.f1924b.n()) {
            C0560g gVar = this.f1924b;
            int i4 = this.f1923a;
            this.f1923a = i4 + 1;
            return gVar.k(i4);
        }
        int i5 = this.f1923a;
        throw new NoSuchElementException("Out of bounds index: " + i5);
    }
}
