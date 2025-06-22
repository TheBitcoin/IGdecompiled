package l0;

/* renamed from: l0.a  reason: case insensitive filesystem */
final class C2104a extends g {

    /* renamed from: a  reason: collision with root package name */
    static final C2104a f20986a = new C2104a();

    private C2104a() {
    }

    static g e() {
        return f20986a;
    }

    public Object b() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public boolean c() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 2040732332;
    }

    public String toString() {
        return "Optional.absent()";
    }
}
