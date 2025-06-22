package R2;

import java.io.Serializable;
import kotlin.jvm.internal.m;

public final class l implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final Object f8214a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f8215b;

    public l(Object obj, Object obj2) {
        this.f8214a = obj;
        this.f8215b = obj2;
    }

    public final Object a() {
        return this.f8214a;
    }

    public final Object b() {
        return this.f8215b;
    }

    public final Object c() {
        return this.f8214a;
    }

    public final Object d() {
        return this.f8215b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (m.a(this.f8214a, lVar.f8214a) && m.a(this.f8215b, lVar.f8215b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        Object obj = this.f8214a;
        int i5 = 0;
        if (obj == null) {
            i4 = 0;
        } else {
            i4 = obj.hashCode();
        }
        int i6 = i4 * 31;
        Object obj2 = this.f8215b;
        if (obj2 != null) {
            i5 = obj2.hashCode();
        }
        return i6 + i5;
    }

    public String toString() {
        return '(' + this.f8214a + ", " + this.f8215b + ')';
    }
}
