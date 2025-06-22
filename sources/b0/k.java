package B0;

import B0.F;

final class k extends F.e.c {

    /* renamed from: a  reason: collision with root package name */
    private final int f6020a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6021b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6022c;

    /* renamed from: d  reason: collision with root package name */
    private final long f6023d;

    /* renamed from: e  reason: collision with root package name */
    private final long f6024e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f6025f;

    /* renamed from: g  reason: collision with root package name */
    private final int f6026g;

    /* renamed from: h  reason: collision with root package name */
    private final String f6027h;

    /* renamed from: i  reason: collision with root package name */
    private final String f6028i;

    static final class b extends F.e.c.a {

        /* renamed from: a  reason: collision with root package name */
        private int f6029a;

        /* renamed from: b  reason: collision with root package name */
        private String f6030b;

        /* renamed from: c  reason: collision with root package name */
        private int f6031c;

        /* renamed from: d  reason: collision with root package name */
        private long f6032d;

        /* renamed from: e  reason: collision with root package name */
        private long f6033e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f6034f;

        /* renamed from: g  reason: collision with root package name */
        private int f6035g;

        /* renamed from: h  reason: collision with root package name */
        private String f6036h;

        /* renamed from: i  reason: collision with root package name */
        private String f6037i;

        /* renamed from: j  reason: collision with root package name */
        private byte f6038j;

        b() {
        }

        public F.e.c a() {
            String str;
            String str2;
            String str3;
            if (this.f6038j == 63 && (str = this.f6030b) != null && (str2 = this.f6036h) != null && (str3 = this.f6037i) != null) {
                return new k(this.f6029a, str, this.f6031c, this.f6032d, this.f6033e, this.f6034f, this.f6035g, str2, str3);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f6038j & 1) == 0) {
                sb.append(" arch");
            }
            if (this.f6030b == null) {
                sb.append(" model");
            }
            if ((this.f6038j & 2) == 0) {
                sb.append(" cores");
            }
            if ((this.f6038j & 4) == 0) {
                sb.append(" ram");
            }
            if ((this.f6038j & 8) == 0) {
                sb.append(" diskSpace");
            }
            if ((this.f6038j & 16) == 0) {
                sb.append(" simulator");
            }
            if ((this.f6038j & 32) == 0) {
                sb.append(" state");
            }
            if (this.f6036h == null) {
                sb.append(" manufacturer");
            }
            if (this.f6037i == null) {
                sb.append(" modelClass");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.c.a b(int i4) {
            this.f6029a = i4;
            this.f6038j = (byte) (this.f6038j | 1);
            return this;
        }

        public F.e.c.a c(int i4) {
            this.f6031c = i4;
            this.f6038j = (byte) (this.f6038j | 2);
            return this;
        }

        public F.e.c.a d(long j4) {
            this.f6033e = j4;
            this.f6038j = (byte) (this.f6038j | 8);
            return this;
        }

        public F.e.c.a e(String str) {
            if (str != null) {
                this.f6036h = str;
                return this;
            }
            throw new NullPointerException("Null manufacturer");
        }

        public F.e.c.a f(String str) {
            if (str != null) {
                this.f6030b = str;
                return this;
            }
            throw new NullPointerException("Null model");
        }

        public F.e.c.a g(String str) {
            if (str != null) {
                this.f6037i = str;
                return this;
            }
            throw new NullPointerException("Null modelClass");
        }

        public F.e.c.a h(long j4) {
            this.f6032d = j4;
            this.f6038j = (byte) (this.f6038j | 4);
            return this;
        }

        public F.e.c.a i(boolean z4) {
            this.f6034f = z4;
            this.f6038j = (byte) (this.f6038j | 16);
            return this;
        }

        public F.e.c.a j(int i4) {
            this.f6035g = i4;
            this.f6038j = (byte) (this.f6038j | 32);
            return this;
        }
    }

    public int b() {
        return this.f6020a;
    }

    public int c() {
        return this.f6022c;
    }

    public long d() {
        return this.f6024e;
    }

    public String e() {
        return this.f6027h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.c) {
            F.e.c cVar = (F.e.c) obj;
            if (this.f6020a == cVar.b() && this.f6021b.equals(cVar.f()) && this.f6022c == cVar.c() && this.f6023d == cVar.h() && this.f6024e == cVar.d() && this.f6025f == cVar.j() && this.f6026g == cVar.i() && this.f6027h.equals(cVar.e()) && this.f6028i.equals(cVar.g())) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String f() {
        return this.f6021b;
    }

    public String g() {
        return this.f6028i;
    }

    public long h() {
        return this.f6023d;
    }

    public int hashCode() {
        int i4;
        long j4 = this.f6023d;
        long j5 = this.f6024e;
        int hashCode = (((((((((this.f6020a ^ 1000003) * 1000003) ^ this.f6021b.hashCode()) * 1000003) ^ this.f6022c) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        if (this.f6025f) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        return ((((((hashCode ^ i4) * 1000003) ^ this.f6026g) * 1000003) ^ this.f6027h.hashCode()) * 1000003) ^ this.f6028i.hashCode();
    }

    public int i() {
        return this.f6026g;
    }

    public boolean j() {
        return this.f6025f;
    }

    public String toString() {
        return "Device{arch=" + this.f6020a + ", model=" + this.f6021b + ", cores=" + this.f6022c + ", ram=" + this.f6023d + ", diskSpace=" + this.f6024e + ", simulator=" + this.f6025f + ", state=" + this.f6026g + ", manufacturer=" + this.f6027h + ", modelClass=" + this.f6028i + "}";
    }

    private k(int i4, String str, int i5, long j4, long j5, boolean z4, int i6, String str2, String str3) {
        this.f6020a = i4;
        this.f6021b = str;
        this.f6022c = i5;
        this.f6023d = j4;
        this.f6024e = j5;
        this.f6025f = z4;
        this.f6026g = i6;
        this.f6027h = str2;
        this.f6028i = str3;
    }
}
