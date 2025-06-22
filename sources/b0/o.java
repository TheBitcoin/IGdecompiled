package B0;

import B0.F;

final class o extends F.e.d.a.b.C0063a {

    /* renamed from: a  reason: collision with root package name */
    private final long f6077a;

    /* renamed from: b  reason: collision with root package name */
    private final long f6078b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6079c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6080d;

    static final class b extends F.e.d.a.b.C0063a.C0064a {

        /* renamed from: a  reason: collision with root package name */
        private long f6081a;

        /* renamed from: b  reason: collision with root package name */
        private long f6082b;

        /* renamed from: c  reason: collision with root package name */
        private String f6083c;

        /* renamed from: d  reason: collision with root package name */
        private String f6084d;

        /* renamed from: e  reason: collision with root package name */
        private byte f6085e;

        b() {
        }

        public F.e.d.a.b.C0063a a() {
            String str;
            if (this.f6085e == 3 && (str = this.f6083c) != null) {
                return new o(this.f6081a, this.f6082b, str, this.f6084d);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f6085e & 1) == 0) {
                sb.append(" baseAddress");
            }
            if ((this.f6085e & 2) == 0) {
                sb.append(" size");
            }
            if (this.f6083c == null) {
                sb.append(" name");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.a.b.C0063a.C0064a b(long j4) {
            this.f6081a = j4;
            this.f6085e = (byte) (this.f6085e | 1);
            return this;
        }

        public F.e.d.a.b.C0063a.C0064a c(String str) {
            if (str != null) {
                this.f6083c = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }

        public F.e.d.a.b.C0063a.C0064a d(long j4) {
            this.f6082b = j4;
            this.f6085e = (byte) (this.f6085e | 2);
            return this;
        }

        public F.e.d.a.b.C0063a.C0064a e(String str) {
            this.f6084d = str;
            return this;
        }
    }

    public long b() {
        return this.f6077a;
    }

    public String c() {
        return this.f6079c;
    }

    public long d() {
        return this.f6078b;
    }

    public String e() {
        return this.f6080d;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.a.b.C0063a) {
            F.e.d.a.b.C0063a aVar = (F.e.d.a.b.C0063a) obj;
            if (this.f6077a != aVar.b() || this.f6078b != aVar.d() || !this.f6079c.equals(aVar.c()) || ((str = this.f6080d) != null ? !str.equals(aVar.e()) : aVar.e() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        long j4 = this.f6077a;
        long j5 = this.f6078b;
        int hashCode = (((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ this.f6079c.hashCode()) * 1000003;
        String str = this.f6080d;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        return i4 ^ hashCode;
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.f6077a + ", size=" + this.f6078b + ", name=" + this.f6079c + ", uuid=" + this.f6080d + "}";
    }

    private o(long j4, long j5, String str, String str2) {
        this.f6077a = j4;
        this.f6078b = j5;
        this.f6079c = str;
        this.f6080d = str2;
    }
}
