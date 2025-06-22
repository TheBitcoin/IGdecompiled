package B0;

import B0.F;

final class s extends F.e.d.a.b.C0069e.C0071b {

    /* renamed from: a  reason: collision with root package name */
    private final long f6111a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6112b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6113c;

    /* renamed from: d  reason: collision with root package name */
    private final long f6114d;

    /* renamed from: e  reason: collision with root package name */
    private final int f6115e;

    static final class b extends F.e.d.a.b.C0069e.C0071b.C0072a {

        /* renamed from: a  reason: collision with root package name */
        private long f6116a;

        /* renamed from: b  reason: collision with root package name */
        private String f6117b;

        /* renamed from: c  reason: collision with root package name */
        private String f6118c;

        /* renamed from: d  reason: collision with root package name */
        private long f6119d;

        /* renamed from: e  reason: collision with root package name */
        private int f6120e;

        /* renamed from: f  reason: collision with root package name */
        private byte f6121f;

        b() {
        }

        public F.e.d.a.b.C0069e.C0071b a() {
            String str;
            if (this.f6121f == 7 && (str = this.f6117b) != null) {
                return new s(this.f6116a, str, this.f6118c, this.f6119d, this.f6120e);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f6121f & 1) == 0) {
                sb.append(" pc");
            }
            if (this.f6117b == null) {
                sb.append(" symbol");
            }
            if ((this.f6121f & 2) == 0) {
                sb.append(" offset");
            }
            if ((this.f6121f & 4) == 0) {
                sb.append(" importance");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.a.b.C0069e.C0071b.C0072a b(String str) {
            this.f6118c = str;
            return this;
        }

        public F.e.d.a.b.C0069e.C0071b.C0072a c(int i4) {
            this.f6120e = i4;
            this.f6121f = (byte) (this.f6121f | 4);
            return this;
        }

        public F.e.d.a.b.C0069e.C0071b.C0072a d(long j4) {
            this.f6119d = j4;
            this.f6121f = (byte) (this.f6121f | 2);
            return this;
        }

        public F.e.d.a.b.C0069e.C0071b.C0072a e(long j4) {
            this.f6116a = j4;
            this.f6121f = (byte) (this.f6121f | 1);
            return this;
        }

        public F.e.d.a.b.C0069e.C0071b.C0072a f(String str) {
            if (str != null) {
                this.f6117b = str;
                return this;
            }
            throw new NullPointerException("Null symbol");
        }
    }

    public String b() {
        return this.f6113c;
    }

    public int c() {
        return this.f6115e;
    }

    public long d() {
        return this.f6114d;
    }

    public long e() {
        return this.f6111a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.a.b.C0069e.C0071b) {
            F.e.d.a.b.C0069e.C0071b bVar = (F.e.d.a.b.C0069e.C0071b) obj;
            if (this.f6111a == bVar.e() && this.f6112b.equals(bVar.f()) && ((str = this.f6113c) != null ? str.equals(bVar.b()) : bVar.b() == null) && this.f6114d == bVar.d() && this.f6115e == bVar.c()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String f() {
        return this.f6112b;
    }

    public int hashCode() {
        int i4;
        long j4 = this.f6111a;
        int hashCode = (((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f6112b.hashCode()) * 1000003;
        String str = this.f6113c;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        long j5 = this.f6114d;
        return this.f6115e ^ ((((hashCode ^ i4) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "Frame{pc=" + this.f6111a + ", symbol=" + this.f6112b + ", file=" + this.f6113c + ", offset=" + this.f6114d + ", importance=" + this.f6115e + "}";
    }

    private s(long j4, String str, String str2, long j5, int i4) {
        this.f6111a = j4;
        this.f6112b = str;
        this.f6113c = str2;
        this.f6114d = j5;
        this.f6115e = i4;
    }
}
