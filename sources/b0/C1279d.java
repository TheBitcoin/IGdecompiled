package B0;

import B0.F;

/* renamed from: B0.d  reason: case insensitive filesystem */
final class C1279d extends F.a.C0059a {

    /* renamed from: a  reason: collision with root package name */
    private final String f5965a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5966b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5967c;

    /* renamed from: B0.d$b */
    static final class b extends F.a.C0059a.C0060a {

        /* renamed from: a  reason: collision with root package name */
        private String f5968a;

        /* renamed from: b  reason: collision with root package name */
        private String f5969b;

        /* renamed from: c  reason: collision with root package name */
        private String f5970c;

        b() {
        }

        public F.a.C0059a a() {
            String str;
            String str2;
            String str3 = this.f5968a;
            if (str3 != null && (str = this.f5969b) != null && (str2 = this.f5970c) != null) {
                return new C1279d(str3, str, str2);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f5968a == null) {
                sb.append(" arch");
            }
            if (this.f5969b == null) {
                sb.append(" libraryName");
            }
            if (this.f5970c == null) {
                sb.append(" buildId");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.a.C0059a.C0060a b(String str) {
            if (str != null) {
                this.f5968a = str;
                return this;
            }
            throw new NullPointerException("Null arch");
        }

        public F.a.C0059a.C0060a c(String str) {
            if (str != null) {
                this.f5970c = str;
                return this;
            }
            throw new NullPointerException("Null buildId");
        }

        public F.a.C0059a.C0060a d(String str) {
            if (str != null) {
                this.f5969b = str;
                return this;
            }
            throw new NullPointerException("Null libraryName");
        }
    }

    public String b() {
        return this.f5965a;
    }

    public String c() {
        return this.f5967c;
    }

    public String d() {
        return this.f5966b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.a.C0059a) {
            F.a.C0059a aVar = (F.a.C0059a) obj;
            if (!this.f5965a.equals(aVar.b()) || !this.f5966b.equals(aVar.d()) || !this.f5967c.equals(aVar.c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f5965a.hashCode() ^ 1000003) * 1000003) ^ this.f5966b.hashCode()) * 1000003) ^ this.f5967c.hashCode();
    }

    public String toString() {
        return "BuildIdMappingForArch{arch=" + this.f5965a + ", libraryName=" + this.f5966b + ", buildId=" + this.f5967c + "}";
    }

    private C1279d(String str, String str2, String str3) {
        this.f5965a = str;
        this.f5966b = str2;
        this.f5967c = str3;
    }
}
