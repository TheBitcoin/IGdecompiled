package B0;

import B0.F;

final class x extends F.e.d.C0075e.b {

    /* renamed from: a  reason: collision with root package name */
    private final String f6155a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6156b;

    static final class b extends F.e.d.C0075e.b.a {

        /* renamed from: a  reason: collision with root package name */
        private String f6157a;

        /* renamed from: b  reason: collision with root package name */
        private String f6158b;

        b() {
        }

        public F.e.d.C0075e.b a() {
            String str;
            String str2 = this.f6157a;
            if (str2 != null && (str = this.f6158b) != null) {
                return new x(str2, str);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f6157a == null) {
                sb.append(" rolloutId");
            }
            if (this.f6158b == null) {
                sb.append(" variantId");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.C0075e.b.a b(String str) {
            if (str != null) {
                this.f6157a = str;
                return this;
            }
            throw new NullPointerException("Null rolloutId");
        }

        public F.e.d.C0075e.b.a c(String str) {
            if (str != null) {
                this.f6158b = str;
                return this;
            }
            throw new NullPointerException("Null variantId");
        }
    }

    public String b() {
        return this.f6155a;
    }

    public String c() {
        return this.f6156b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.C0075e.b) {
            F.e.d.C0075e.b bVar = (F.e.d.C0075e.b) obj;
            if (!this.f6155a.equals(bVar.b()) || !this.f6156b.equals(bVar.c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f6155a.hashCode() ^ 1000003) * 1000003) ^ this.f6156b.hashCode();
    }

    public String toString() {
        return "RolloutVariant{rolloutId=" + this.f6155a + ", variantId=" + this.f6156b + "}";
    }

    private x(String str, String str2) {
        this.f6155a = str;
        this.f6156b = str2;
    }
}
