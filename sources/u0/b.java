package U0;

import U0.f;

final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    private final String f8372a;

    /* renamed from: b  reason: collision with root package name */
    private final long f8373b;

    /* renamed from: c  reason: collision with root package name */
    private final f.b f8374c;

    /* renamed from: U0.b$b  reason: collision with other inner class name */
    static final class C0114b extends f.a {

        /* renamed from: a  reason: collision with root package name */
        private String f8375a;

        /* renamed from: b  reason: collision with root package name */
        private Long f8376b;

        /* renamed from: c  reason: collision with root package name */
        private f.b f8377c;

        C0114b() {
        }

        public f a() {
            String str = "";
            if (this.f8376b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.f8375a, this.f8376b.longValue(), this.f8377c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public f.a b(f.b bVar) {
            this.f8377c = bVar;
            return this;
        }

        public f.a c(String str) {
            this.f8375a = str;
            return this;
        }

        public f.a d(long j4) {
            this.f8376b = Long.valueOf(j4);
            return this;
        }
    }

    public f.b b() {
        return this.f8374c;
    }

    public String c() {
        return this.f8372a;
    }

    public long d() {
        return this.f8373b;
    }

    public boolean equals(Object obj) {
        f.b bVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            String str = this.f8372a;
            if (str != null ? str.equals(fVar.c()) : fVar.c() == null) {
                if (this.f8373b != fVar.d() || ((bVar = this.f8374c) != null ? !bVar.equals(fVar.b()) : fVar.b() != null)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i4;
        String str = this.f8372a;
        int i5 = 0;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        long j4 = this.f8373b;
        int i6 = (((i4 ^ 1000003) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        f.b bVar = this.f8374c;
        if (bVar != null) {
            i5 = bVar.hashCode();
        }
        return i6 ^ i5;
    }

    public String toString() {
        return "TokenResult{token=" + this.f8372a + ", tokenExpirationTimestamp=" + this.f8373b + ", responseCode=" + this.f8374c + "}";
    }

    private b(String str, long j4, f.b bVar) {
        this.f8372a = str;
        this.f8373b = j4;
        this.f8374c = bVar;
    }
}
