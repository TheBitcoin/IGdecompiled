package B0;

import B0.F;

final class v extends F.e.d.C0074d {

    /* renamed from: a  reason: collision with root package name */
    private final String f6144a;

    static final class b extends F.e.d.C0074d.a {

        /* renamed from: a  reason: collision with root package name */
        private String f6145a;

        b() {
        }

        public F.e.d.C0074d a() {
            String str = this.f6145a;
            if (str != null) {
                return new v(str);
            }
            throw new IllegalStateException("Missing required properties:" + " content");
        }

        public F.e.d.C0074d.a b(String str) {
            if (str != null) {
                this.f6145a = str;
                return this;
            }
            throw new NullPointerException("Null content");
        }
    }

    public String b() {
        return this.f6144a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.C0074d) {
            return this.f6144a.equals(((F.e.d.C0074d) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f6144a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.f6144a + "}";
    }

    private v(String str) {
        this.f6144a = str;
    }
}
