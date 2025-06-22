package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

public final class d extends f implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f11500a = new ArrayList();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d) || !((d) obj).f11500a.equals(this.f11500a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f11500a.hashCode();
    }

    public Iterator iterator() {
        return this.f11500a.iterator();
    }

    public void n(f fVar) {
        if (fVar == null) {
            fVar = h.f11501a;
        }
        this.f11500a.add(fVar);
    }
}
