package B0;

import B0.F;

final class u extends F.e.d.c {

    /* renamed from: a  reason: collision with root package name */
    private final Double f6131a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6132b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f6133c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6134d;

    /* renamed from: e  reason: collision with root package name */
    private final long f6135e;

    /* renamed from: f  reason: collision with root package name */
    private final long f6136f;

    static final class b extends F.e.d.c.a {

        /* renamed from: a  reason: collision with root package name */
        private Double f6137a;

        /* renamed from: b  reason: collision with root package name */
        private int f6138b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f6139c;

        /* renamed from: d  reason: collision with root package name */
        private int f6140d;

        /* renamed from: e  reason: collision with root package name */
        private long f6141e;

        /* renamed from: f  reason: collision with root package name */
        private long f6142f;

        /* renamed from: g  reason: collision with root package name */
        private byte f6143g;

        b() {
        }

        public F.e.d.c a() {
            if (this.f6143g == 31) {
                return new u(this.f6137a, this.f6138b, this.f6139c, this.f6140d, this.f6141e, this.f6142f);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f6143g & 1) == 0) {
                sb.append(" batteryVelocity");
            }
            if ((this.f6143g & 2) == 0) {
                sb.append(" proximityOn");
            }
            if ((this.f6143g & 4) == 0) {
                sb.append(" orientation");
            }
            if ((this.f6143g & 8) == 0) {
                sb.append(" ramUsed");
            }
            if ((this.f6143g & 16) == 0) {
                sb.append(" diskUsed");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.c.a b(Double d5) {
            this.f6137a = d5;
            return this;
        }

        public F.e.d.c.a c(int i4) {
            this.f6138b = i4;
            this.f6143g = (byte) (this.f6143g | 1);
            return this;
        }

        public F.e.d.c.a d(long j4) {
            this.f6142f = j4;
            this.f6143g = (byte) (this.f6143g | 16);
            return this;
        }

        public F.e.d.c.a e(int i4) {
            this.f6140d = i4;
            this.f6143g = (byte) (this.f6143g | 4);
            return this;
        }

        public F.e.d.c.a f(boolean z4) {
            this.f6139c = z4;
            this.f6143g = (byte) (this.f6143g | 2);
            return this;
        }

        public F.e.d.c.a g(long j4) {
            this.f6141e = j4;
            this.f6143g = (byte) (this.f6143g | 8);
            return this;
        }
    }

    public Double b() {
        return this.f6131a;
    }

    public int c() {
        return this.f6132b;
    }

    public long d() {
        return this.f6136f;
    }

    public int e() {
        return this.f6134d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.c) {
            F.e.d.c cVar = (F.e.d.c) obj;
            Double d5 = this.f6131a;
            if (d5 != null ? d5.equals(cVar.b()) : cVar.b() == null) {
                if (this.f6132b == cVar.c() && this.f6133c == cVar.g() && this.f6134d == cVar.e() && this.f6135e == cVar.f() && this.f6136f == cVar.d()) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public long f() {
        return this.f6135e;
    }

    public boolean g() {
        return this.f6133c;
    }

    public int hashCode() {
        int i4;
        int i5;
        Double d5 = this.f6131a;
        if (d5 == null) {
            i4 = 0;
        } else {
            i4 = d5.hashCode();
        }
        int i6 = (((i4 ^ 1000003) * 1000003) ^ this.f6132b) * 1000003;
        if (this.f6133c) {
            i5 = 1231;
        } else {
            i5 = 1237;
        }
        long j4 = this.f6135e;
        long j5 = this.f6136f;
        return ((((((i6 ^ i5) * 1000003) ^ this.f6134d) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f6131a + ", batteryVelocity=" + this.f6132b + ", proximityOn=" + this.f6133c + ", orientation=" + this.f6134d + ", ramUsed=" + this.f6135e + ", diskUsed=" + this.f6136f + "}";
    }

    private u(Double d5, int i4, boolean z4, int i5, long j4, long j5) {
        this.f6131a = d5;
        this.f6132b = i4;
        this.f6133c = z4;
        this.f6134d = i5;
        this.f6135e = j4;
        this.f6136f = j5;
    }
}
