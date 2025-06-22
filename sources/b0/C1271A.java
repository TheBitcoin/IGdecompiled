package B0;

import B0.F;

/* renamed from: B0.A  reason: case insensitive filesystem */
final class C1271A extends F.e.f {

    /* renamed from: a  reason: collision with root package name */
    private final String f5750a;

    /* renamed from: B0.A$b */
    static final class b extends F.e.f.a {

        /* renamed from: a  reason: collision with root package name */
        private String f5751a;

        b() {
        }

        public F.e.f a() {
            String str = this.f5751a;
            if (str != null) {
                return new C1271A(str);
            }
            throw new IllegalStateException("Missing required properties:" + " identifier");
        }

        public F.e.f.a b(String str) {
            if (str != null) {
                this.f5751a = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }
    }

    public String b() {
        return this.f5750a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.f) {
            return this.f5750a.equals(((F.e.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f5750a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.f5750a + "}";
    }

    private C1271A(String str) {
        this.f5750a = str;
    }
}
