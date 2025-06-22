package com.google.gson;

import com.google.gson.internal.g;
import java.util.Set;

public final class i extends f {

    /* renamed from: a  reason: collision with root package name */
    private final g f11502a = new g(false);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i) || !((i) obj).f11502a.equals(this.f11502a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f11502a.hashCode();
    }

    public void n(String str, f fVar) {
        g gVar = this.f11502a;
        if (fVar == null) {
            fVar = h.f11501a;
        }
        gVar.put(str, fVar);
    }

    public Set o() {
        return this.f11502a.entrySet();
    }
}
