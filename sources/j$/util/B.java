package j$.util;

public final class B {

    /* renamed from: b  reason: collision with root package name */
    public static final B f5085b = new B();

    /* renamed from: a  reason: collision with root package name */
    public final Object f5086a;

    public B() {
        this.f5086a = null;
    }

    public B(Object obj) {
        this.f5086a = Objects.requireNonNull(obj);
    }

    public final int hashCode() {
        Object obj = this.f5086a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B)) {
            return false;
        }
        return Objects.equals(this.f5086a, ((B) obj).f5086a);
    }

    public final String toString() {
        Object obj = this.f5086a;
        if (obj == null) {
            return "Optional.empty";
        }
        return String.format("Optional[%s]", new Object[]{obj});
    }
}
