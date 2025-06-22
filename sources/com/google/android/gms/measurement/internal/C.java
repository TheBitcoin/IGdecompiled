package com.google.android.gms.measurement.internal;

import java.util.Iterator;

final class C implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private Iterator f2335a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ D f2336b;

    C(D d5) {
        this.f2336b = d5;
        this.f2335a = d5.f2344a.keySet().iterator();
    }

    public final boolean hasNext() {
        return this.f2335a.hasNext();
    }

    public final /* synthetic */ Object next() {
        return (String) this.f2335a.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
