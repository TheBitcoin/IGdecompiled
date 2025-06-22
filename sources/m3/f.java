package m3;

import j3.d;
import kotlin.jvm.internal.m;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final String f21176a;

    /* renamed from: b  reason: collision with root package name */
    private final d f21177b;

    public f(String str, d dVar) {
        m.e(str, "value");
        m.e(dVar, "range");
        this.f21176a = str;
        this.f21177b = dVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (m.a(this.f21176a, fVar.f21176a) && m.a(this.f21177b, fVar.f21177b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f21176a.hashCode() * 31) + this.f21177b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f21176a + ", range=" + this.f21177b + ')';
    }
}
