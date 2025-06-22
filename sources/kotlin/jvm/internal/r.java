package kotlin.jvm.internal;

public final class r implements C2100d {

    /* renamed from: a  reason: collision with root package name */
    private final Class f20983a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20984b;

    public r(Class cls, String str) {
        m.e(cls, "jClass");
        m.e(str, "moduleName");
        this.f20983a = cls;
        this.f20984b = str;
    }

    public Class d() {
        return this.f20983a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r) || !m.a(d(), ((r) obj).d())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return d().hashCode();
    }

    public String toString() {
        return d().toString() + " (Kotlin reflection is not available)";
    }
}
