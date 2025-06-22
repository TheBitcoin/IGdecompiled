package t;

public final class f {

    /* renamed from: c  reason: collision with root package name */
    private static final f f4456c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f4457a;

    /* renamed from: b  reason: collision with root package name */
    private final long f4458b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private long f4459a = 0;

        /* renamed from: b  reason: collision with root package name */
        private long f4460b = 0;

        a() {
        }

        public f a() {
            return new f(this.f4459a, this.f4460b);
        }

        public a b(long j4) {
            this.f4460b = j4;
            return this;
        }

        public a c(long j4) {
            this.f4459a = j4;
            return this;
        }
    }

    f(long j4, long j5) {
        this.f4457a = j4;
        this.f4458b = j5;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f4458b;
    }

    public long b() {
        return this.f4457a;
    }
}
