package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.measurement.x  reason: case insensitive filesystem */
final class C0703x implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f2241a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C0679u f2242b;

    C0703x(C0679u uVar) {
        this.f2242b = uVar;
    }

    public final boolean hasNext() {
        if (this.f2241a < this.f2242b.f2190a.length()) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object next() {
        if (this.f2241a < this.f2242b.f2190a.length()) {
            int i4 = this.f2241a;
            this.f2241a = i4 + 1;
            return new C0679u(String.valueOf(i4));
        }
        throw new NoSuchElementException();
    }
}
