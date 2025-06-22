package B0;

import B0.F;

final class l extends F.e.d {

    /* renamed from: a  reason: collision with root package name */
    private final long f6039a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6040b;

    /* renamed from: c  reason: collision with root package name */
    private final F.e.d.a f6041c;

    /* renamed from: d  reason: collision with root package name */
    private final F.e.d.c f6042d;

    /* renamed from: e  reason: collision with root package name */
    private final F.e.d.C0074d f6043e;

    /* renamed from: f  reason: collision with root package name */
    private final F.e.d.f f6044f;

    static final class b extends F.e.d.b {

        /* renamed from: a  reason: collision with root package name */
        private long f6045a;

        /* renamed from: b  reason: collision with root package name */
        private String f6046b;

        /* renamed from: c  reason: collision with root package name */
        private F.e.d.a f6047c;

        /* renamed from: d  reason: collision with root package name */
        private F.e.d.c f6048d;

        /* renamed from: e  reason: collision with root package name */
        private F.e.d.C0074d f6049e;

        /* renamed from: f  reason: collision with root package name */
        private F.e.d.f f6050f;

        /* renamed from: g  reason: collision with root package name */
        private byte f6051g;

        public F.e.d a() {
            String str;
            F.e.d.a aVar;
            F.e.d.c cVar;
            if (this.f6051g == 1 && (str = this.f6046b) != null && (aVar = this.f6047c) != null && (cVar = this.f6048d) != null) {
                return new l(this.f6045a, str, aVar, cVar, this.f6049e, this.f6050f);
            }
            StringBuilder sb = new StringBuilder();
            if ((1 & this.f6051g) == 0) {
                sb.append(" timestamp");
            }
            if (this.f6046b == null) {
                sb.append(" type");
            }
            if (this.f6047c == null) {
                sb.append(" app");
            }
            if (this.f6048d == null) {
                sb.append(" device");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.b b(F.e.d.a aVar) {
            if (aVar != null) {
                this.f6047c = aVar;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public F.e.d.b c(F.e.d.c cVar) {
            if (cVar != null) {
                this.f6048d = cVar;
                return this;
            }
            throw new NullPointerException("Null device");
        }

        public F.e.d.b d(F.e.d.C0074d dVar) {
            this.f6049e = dVar;
            return this;
        }

        public F.e.d.b e(F.e.d.f fVar) {
            this.f6050f = fVar;
            return this;
        }

        public F.e.d.b f(long j4) {
            this.f6045a = j4;
            this.f6051g = (byte) (this.f6051g | 1);
            return this;
        }

        public F.e.d.b g(String str) {
            if (str != null) {
                this.f6046b = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        b() {
        }

        private b(F.e.d dVar) {
            this.f6045a = dVar.f();
            this.f6046b = dVar.g();
            this.f6047c = dVar.b();
            this.f6048d = dVar.c();
            this.f6049e = dVar.d();
            this.f6050f = dVar.e();
            this.f6051g = 1;
        }
    }

    public F.e.d.a b() {
        return this.f6041c;
    }

    public F.e.d.c c() {
        return this.f6042d;
    }

    public F.e.d.C0074d d() {
        return this.f6043e;
    }

    public F.e.d.f e() {
        return this.f6044f;
    }

    public boolean equals(Object obj) {
        F.e.d.C0074d dVar;
        F.e.d.f fVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d) {
            F.e.d dVar2 = (F.e.d) obj;
            if (this.f6039a != dVar2.f() || !this.f6040b.equals(dVar2.g()) || !this.f6041c.equals(dVar2.b()) || !this.f6042d.equals(dVar2.c()) || ((dVar = this.f6043e) != null ? !dVar.equals(dVar2.d()) : dVar2.d() != null) || ((fVar = this.f6044f) != null ? !fVar.equals(dVar2.e()) : dVar2.e() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public long f() {
        return this.f6039a;
    }

    public String g() {
        return this.f6040b;
    }

    public F.e.d.b h() {
        return new b(this);
    }

    public int hashCode() {
        int i4;
        long j4 = this.f6039a;
        int hashCode = (((((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f6040b.hashCode()) * 1000003) ^ this.f6041c.hashCode()) * 1000003) ^ this.f6042d.hashCode()) * 1000003;
        F.e.d.C0074d dVar = this.f6043e;
        int i5 = 0;
        if (dVar == null) {
            i4 = 0;
        } else {
            i4 = dVar.hashCode();
        }
        int i6 = (hashCode ^ i4) * 1000003;
        F.e.d.f fVar = this.f6044f;
        if (fVar != null) {
            i5 = fVar.hashCode();
        }
        return i6 ^ i5;
    }

    public String toString() {
        return "Event{timestamp=" + this.f6039a + ", type=" + this.f6040b + ", app=" + this.f6041c + ", device=" + this.f6042d + ", log=" + this.f6043e + ", rollouts=" + this.f6044f + "}";
    }

    private l(long j4, String str, F.e.d.a aVar, F.e.d.c cVar, F.e.d.C0074d dVar, F.e.d.f fVar) {
        this.f6039a = j4;
        this.f6040b = str;
        this.f6041c = aVar;
        this.f6042d = cVar;
        this.f6043e = dVar;
        this.f6044f = fVar;
    }
}
