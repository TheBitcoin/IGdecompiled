package o;

/* renamed from: o.c  reason: case insensitive filesystem */
public final class C0962c {

    /* renamed from: a  reason: collision with root package name */
    private final String f3618a;

    private C0962c(String str) {
        if (str != null) {
            this.f3618a = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public static C0962c b(String str) {
        return new C0962c(str);
    }

    public String a() {
        return this.f3618a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0962c)) {
            return false;
        }
        return this.f3618a.equals(((C0962c) obj).f3618a);
    }

    public int hashCode() {
        return this.f3618a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f3618a + "\"}";
    }
}
