package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.measurement.f  reason: case insensitive filesystem */
final class C0551f implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Iterator f1889a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Iterator f1890b;

    C0551f(C0560g gVar, Iterator it, Iterator it2) {
        this.f1889a = it;
        this.f1890b = it2;
    }

    public final boolean hasNext() {
        if (this.f1889a.hasNext()) {
            return true;
        }
        return this.f1890b.hasNext();
    }

    public final /* synthetic */ Object next() {
        if (this.f1889a.hasNext()) {
            return new C0679u(((Integer) this.f1889a.next()).toString());
        }
        if (this.f1890b.hasNext()) {
            return new C0679u((String) this.f1890b.next());
        }
        throw new NoSuchElementException();
    }
}
