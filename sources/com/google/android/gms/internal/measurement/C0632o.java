package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.measurement.o  reason: case insensitive filesystem */
final class C0632o implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Iterator f2072a;

    C0632o(Iterator it) {
        this.f2072a = it;
    }

    public final boolean hasNext() {
        return this.f2072a.hasNext();
    }

    public final /* synthetic */ Object next() {
        return new C0679u((String) this.f2072a.next());
    }
}
