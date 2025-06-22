package t;

/* renamed from: t.e  reason: case insensitive filesystem */
public final class C1050e {

    /* renamed from: c  reason: collision with root package name */
    private static final C1050e f4451c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f4452a;

    /* renamed from: b  reason: collision with root package name */
    private final long f4453b;

    /* renamed from: t.e$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private long f4454a = 0;

        /* renamed from: b  reason: collision with root package name */
        private long f4455b = 0;

        a() {
        }

        public C1050e a() {
            return new C1050e(this.f4454a, this.f4455b);
        }

        public a b(long j4) {
            this.f4454a = j4;
            return this;
        }

        public a c(long j4) {
            this.f4455b = j4;
            return this;
        }
    }

    C1050e(long j4, long j5) {
        this.f4452a = j4;
        this.f4453b = j5;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f4452a;
    }

    public long b() {
        return this.f4453b;
    }
}
