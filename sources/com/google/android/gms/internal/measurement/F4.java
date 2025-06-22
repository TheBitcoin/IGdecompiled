package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class F4 implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private Iterator f1460a;

    public F4(Iterator it) {
        this.f1460a = it;
    }

    public final boolean hasNext() {
        return this.f1460a.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.f1460a.next();
        entry.getValue();
        return entry;
    }

    public final void remove() {
        this.f1460a.remove();
    }
}
