package j$.util;

public final class C {

    /* renamed from: c  reason: collision with root package name */
    public static final C f5087c = new C();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5088a;

    /* renamed from: b  reason: collision with root package name */
    public final double f5089b;

    public C() {
        this.f5088a = false;
        this.f5089b = Double.NaN;
    }

    public C(double d5) {
        this.f5088a = true;
        this.f5089b = d5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C)) {
            return false;
        }
        C c5 = (C) obj;
        boolean z4 = this.f5088a;
        return (!z4 || !c5.f5088a) ? z4 == c5.f5088a : Double.compare(this.f5089b, c5.f5089b) == 0;
    }

    public final int hashCode() {
        if (!this.f5088a) {
            return 0;
        }
        long doubleToLongBits = Double.doubleToLongBits(this.f5089b);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public final String toString() {
        if (!this.f5088a) {
            return "OptionalDouble.empty";
        }
        return "OptionalDouble[" + this.f5089b + "]";
    }
}
