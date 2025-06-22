package y;

import y.C1095e;

/* renamed from: y.a  reason: case insensitive filesystem */
final class C1091a extends C1095e {

    /* renamed from: b  reason: collision with root package name */
    private final long f4754b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4755c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4756d;

    /* renamed from: e  reason: collision with root package name */
    private final long f4757e;

    /* renamed from: f  reason: collision with root package name */
    private final int f4758f;

    /* renamed from: y.a$b */
    static final class b extends C1095e.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f4759a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f4760b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f4761c;

        /* renamed from: d  reason: collision with root package name */
        private Long f4762d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f4763e;

        b() {
        }

        /* access modifiers changed from: package-private */
        public C1095e a() {
            String str = "";
            if (this.f4759a == null) {
                str = str + " maxStorageSizeInBytes";
            }
            if (this.f4760b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f4761c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f4762d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f4763e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new C1091a(this.f4759a.longValue(), this.f4760b.intValue(), this.f4761c.intValue(), this.f4762d.longValue(), this.f4763e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public C1095e.a b(int i4) {
            this.f4761c = Integer.valueOf(i4);
            return this;
        }

        /* access modifiers changed from: package-private */
        public C1095e.a c(long j4) {
            this.f4762d = Long.valueOf(j4);
            return this;
        }

        /* access modifiers changed from: package-private */
        public C1095e.a d(int i4) {
            this.f4760b = Integer.valueOf(i4);
            return this;
        }

        /* access modifiers changed from: package-private */
        public C1095e.a e(int i4) {
            this.f4763e = Integer.valueOf(i4);
            return this;
        }

        /* access modifiers changed from: package-private */
        public C1095e.a f(long j4) {
            this.f4759a = Long.valueOf(j4);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f4756d;
    }

    /* access modifiers changed from: package-private */
    public long c() {
        return this.f4757e;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f4755c;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f4758f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1095e) {
            C1095e eVar = (C1095e) obj;
            if (this.f4754b == eVar.f() && this.f4755c == eVar.d() && this.f4756d == eVar.b() && this.f4757e == eVar.c() && this.f4758f == eVar.e()) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public long f() {
        return this.f4754b;
    }

    public int hashCode() {
        long j4 = this.f4754b;
        long j5 = this.f4757e;
        return this.f4758f ^ ((((((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f4755c) * 1000003) ^ this.f4756d) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f4754b + ", loadBatchSize=" + this.f4755c + ", criticalSectionEnterTimeoutMs=" + this.f4756d + ", eventCleanUpAge=" + this.f4757e + ", maxBlobByteSizePerRow=" + this.f4758f + "}";
    }

    private C1091a(long j4, int i4, int i5, long j5, int i6) {
        this.f4754b = j4;
        this.f4755c = i4;
        this.f4756d = i5;
        this.f4757e = j5;
        this.f4758f = i6;
    }
}
