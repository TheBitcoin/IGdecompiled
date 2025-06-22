package j$.util;

public final class E {

    /* renamed from: c  reason: collision with root package name */
    public static final E f5093c = new E();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5094a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5095b;

    public E() {
        this.f5094a = false;
        this.f5095b = 0;
    }

    public E(long j4) {
        this.f5094a = true;
        this.f5095b = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof E)) {
            return false;
        }
        E e5 = (E) obj;
        boolean z4 = this.f5094a;
        return (!z4 || !e5.f5094a) ? z4 == e5.f5094a : this.f5095b == e5.f5095b;
    }

    public final int hashCode() {
        if (!this.f5094a) {
            return 0;
        }
        long j4 = this.f5095b;
        return (int) (j4 ^ (j4 >>> 32));
    }

    public final String toString() {
        if (!this.f5094a) {
            return "OptionalLong.empty";
        }
        return "OptionalLong[" + this.f5095b + "]";
    }
}
