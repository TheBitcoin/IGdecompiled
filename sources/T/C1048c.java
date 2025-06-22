package t;

import N0.c;

/* renamed from: t.c  reason: case insensitive filesystem */
public final class C1048c {

    /* renamed from: c  reason: collision with root package name */
    private static final C1048c f4432c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f4433a;

    /* renamed from: b  reason: collision with root package name */
    private final b f4434b;

    /* renamed from: t.c$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private long f4435a = 0;

        /* renamed from: b  reason: collision with root package name */
        private b f4436b = b.REASON_UNKNOWN;

        a() {
        }

        public C1048c a() {
            return new C1048c(this.f4435a, this.f4436b);
        }

        public a b(long j4) {
            this.f4435a = j4;
            return this;
        }

        public a c(b bVar) {
            this.f4436b = bVar;
            return this;
        }
    }

    /* renamed from: t.c$b */
    public enum b implements c {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f4445a;

        private b(int i4) {
            this.f4445a = i4;
        }

        public int getNumber() {
            return this.f4445a;
        }
    }

    C1048c(long j4, b bVar) {
        this.f4433a = j4;
        this.f4434b = bVar;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f4433a;
    }

    public b b() {
        return this.f4434b;
    }
}
