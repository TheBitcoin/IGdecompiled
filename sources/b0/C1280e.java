package B0;

import B0.F;

/* renamed from: B0.e  reason: case insensitive filesystem */
final class C1280e extends F.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f5971a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5972b;

    /* renamed from: B0.e$b */
    static final class b extends F.c.a {

        /* renamed from: a  reason: collision with root package name */
        private String f5973a;

        /* renamed from: b  reason: collision with root package name */
        private String f5974b;

        b() {
        }

        public F.c a() {
            String str;
            String str2 = this.f5973a;
            if (str2 != null && (str = this.f5974b) != null) {
                return new C1280e(str2, str);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f5973a == null) {
                sb.append(" key");
            }
            if (this.f5974b == null) {
                sb.append(" value");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.c.a b(String str) {
            if (str != null) {
                this.f5973a = str;
                return this;
            }
            throw new NullPointerException("Null key");
        }

        public F.c.a c(String str) {
            if (str != null) {
                this.f5974b = str;
                return this;
            }
            throw new NullPointerException("Null value");
        }
    }

    public String b() {
        return this.f5971a;
    }

    public String c() {
        return this.f5972b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.c) {
            F.c cVar = (F.c) obj;
            if (!this.f5971a.equals(cVar.b()) || !this.f5972b.equals(cVar.c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f5971a.hashCode() ^ 1000003) * 1000003) ^ this.f5972b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.f5971a + ", value=" + this.f5972b + "}";
    }

    private C1280e(String str, String str2) {
        this.f5971a = str;
        this.f5972b = str2;
    }
}
