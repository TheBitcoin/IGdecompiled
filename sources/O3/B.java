package o3;

import d3.l;
import kotlin.jvm.internal.m;

public final class B {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3638a;

    /* renamed from: b  reason: collision with root package name */
    public final l f3639b;

    public B(Object obj, l lVar) {
        this.f3638a = obj;
        this.f3639b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B)) {
            return false;
        }
        B b5 = (B) obj;
        if (m.a(this.f3638a, b5.f3638a) && m.a(this.f3639b, b5.f3639b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        Object obj = this.f3638a;
        if (obj == null) {
            i4 = 0;
        } else {
            i4 = obj.hashCode();
        }
        return (i4 * 31) + this.f3639b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f3638a + ", onCancellation=" + this.f3639b + ')';
    }
}
