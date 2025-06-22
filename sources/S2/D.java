package S2;

import kotlin.jvm.internal.m;

public final class D {

    /* renamed from: a  reason: collision with root package name */
    private final int f8234a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f8235b;

    public D(int i4, Object obj) {
        this.f8234a = i4;
        this.f8235b = obj;
    }

    public final int a() {
        return this.f8234a;
    }

    public final Object b() {
        return this.f8235b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        D d5 = (D) obj;
        if (this.f8234a == d5.f8234a && m.a(this.f8235b, d5.f8235b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int i5 = this.f8234a * 31;
        Object obj = this.f8235b;
        if (obj == null) {
            i4 = 0;
        } else {
            i4 = obj.hashCode();
        }
        return i5 + i4;
    }

    public String toString() {
        return "IndexedValue(index=" + this.f8234a + ", value=" + this.f8235b + ')';
    }
}
