package j$.util;

public final class D {

    /* renamed from: c  reason: collision with root package name */
    public static final D f5090c = new D();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5091a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5092b;

    public D() {
        this.f5091a = false;
        this.f5092b = 0;
    }

    public D(int i4) {
        this.f5091a = true;
        this.f5092b = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        D d5 = (D) obj;
        boolean z4 = this.f5091a;
        return (!z4 || !d5.f5091a) ? z4 == d5.f5091a : this.f5092b == d5.f5092b;
    }

    public final int hashCode() {
        if (this.f5091a) {
            return this.f5092b;
        }
        return 0;
    }

    public final String toString() {
        if (!this.f5091a) {
            return "OptionalInt.empty";
        }
        return "OptionalInt[" + this.f5092b + "]";
    }
}
