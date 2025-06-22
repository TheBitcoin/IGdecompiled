package x;

import A.a;
import java.util.Map;

/* renamed from: x.b  reason: case insensitive filesystem */
final class C1082b extends f {

    /* renamed from: a  reason: collision with root package name */
    private final a f4610a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f4611b;

    C1082b(a aVar, Map map) {
        if (aVar != null) {
            this.f4610a = aVar;
            if (map != null) {
                this.f4611b = map;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    /* access modifiers changed from: package-private */
    public a e() {
        return this.f4610a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (!this.f4610a.equals(fVar.e()) || !this.f4611b.equals(fVar.h())) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Map h() {
        return this.f4611b;
    }

    public int hashCode() {
        return ((this.f4610a.hashCode() ^ 1000003) * 1000003) ^ this.f4611b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f4610a + ", values=" + this.f4611b + "}";
    }
}
