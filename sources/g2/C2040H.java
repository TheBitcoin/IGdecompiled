package g2;

/* renamed from: g2.H  reason: case insensitive filesystem */
public final class C2040H {

    /* renamed from: a  reason: collision with root package name */
    private String f20373a;

    /* renamed from: b  reason: collision with root package name */
    private String f20374b;

    public final String a() {
        return this.f20373a;
    }

    public final String b() {
        return this.f20374b;
    }

    public final void c(String str) {
        this.f20373a = str;
    }

    public final void d(String str) {
        this.f20374b = str;
    }

    public String toString() {
        return "{query='" + this.f20373a + "', timestamp='" + this.f20374b + "'}";
    }
}
