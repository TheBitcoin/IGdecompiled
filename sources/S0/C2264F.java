package s0;

/* renamed from: s0.F  reason: case insensitive filesystem */
public final class C2264F {

    /* renamed from: a  reason: collision with root package name */
    private final Class f21689a;

    /* renamed from: b  reason: collision with root package name */
    private final Class f21690b;

    /* renamed from: s0.F$a */
    private @interface a {
    }

    public C2264F(Class cls, Class cls2) {
        this.f21689a = cls;
        this.f21690b = cls2;
    }

    public static C2264F a(Class cls, Class cls2) {
        return new C2264F(cls, cls2);
    }

    public static C2264F b(Class cls) {
        return new C2264F(a.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2264F.class != obj.getClass()) {
            return false;
        }
        C2264F f4 = (C2264F) obj;
        if (!this.f21690b.equals(f4.f21690b)) {
            return false;
        }
        return this.f21689a.equals(f4.f21689a);
    }

    public int hashCode() {
        return (this.f21690b.hashCode() * 31) + this.f21689a.hashCode();
    }

    public String toString() {
        if (this.f21689a == a.class) {
            return this.f21690b.getName();
        }
        return "@" + this.f21689a.getName() + " " + this.f21690b.getName();
    }
}
