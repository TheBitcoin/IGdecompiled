package b1;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final String f9042a;

    public m(String str) {
        this.f9042a = str;
    }

    public final String a() {
        return this.f9042a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof m) && kotlin.jvm.internal.m.a(this.f9042a, ((m) obj).f9042a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f9042a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "FirebaseSessionsData(sessionId=" + this.f9042a + ')';
    }
}
