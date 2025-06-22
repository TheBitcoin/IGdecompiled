package B0;

import B0.F;

final class w extends F.e.d.C0075e {

    /* renamed from: a  reason: collision with root package name */
    private final F.e.d.C0075e.b f6146a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6147b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6148c;

    /* renamed from: d  reason: collision with root package name */
    private final long f6149d;

    static final class b extends F.e.d.C0075e.a {

        /* renamed from: a  reason: collision with root package name */
        private F.e.d.C0075e.b f6150a;

        /* renamed from: b  reason: collision with root package name */
        private String f6151b;

        /* renamed from: c  reason: collision with root package name */
        private String f6152c;

        /* renamed from: d  reason: collision with root package name */
        private long f6153d;

        /* renamed from: e  reason: collision with root package name */
        private byte f6154e;

        b() {
        }

        public F.e.d.C0075e a() {
            F.e.d.C0075e.b bVar;
            String str;
            String str2;
            if (this.f6154e == 1 && (bVar = this.f6150a) != null && (str = this.f6151b) != null && (str2 = this.f6152c) != null) {
                return new w(bVar, str, str2, this.f6153d);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f6150a == null) {
                sb.append(" rolloutVariant");
            }
            if (this.f6151b == null) {
                sb.append(" parameterKey");
            }
            if (this.f6152c == null) {
                sb.append(" parameterValue");
            }
            if ((1 & this.f6154e) == 0) {
                sb.append(" templateVersion");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.C0075e.a b(String str) {
            if (str != null) {
                this.f6151b = str;
                return this;
            }
            throw new NullPointerException("Null parameterKey");
        }

        public F.e.d.C0075e.a c(String str) {
            if (str != null) {
                this.f6152c = str;
                return this;
            }
            throw new NullPointerException("Null parameterValue");
        }

        public F.e.d.C0075e.a d(F.e.d.C0075e.b bVar) {
            if (bVar != null) {
                this.f6150a = bVar;
                return this;
            }
            throw new NullPointerException("Null rolloutVariant");
        }

        public F.e.d.C0075e.a e(long j4) {
            this.f6153d = j4;
            this.f6154e = (byte) (this.f6154e | 1);
            return this;
        }
    }

    public String b() {
        return this.f6147b;
    }

    public String c() {
        return this.f6148c;
    }

    public F.e.d.C0075e.b d() {
        return this.f6146a;
    }

    public long e() {
        return this.f6149d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.C0075e) {
            F.e.d.C0075e eVar = (F.e.d.C0075e) obj;
            if (!this.f6146a.equals(eVar.d()) || !this.f6147b.equals(eVar.b()) || !this.f6148c.equals(eVar.c()) || this.f6149d != eVar.e()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f6149d;
        return ((((((this.f6146a.hashCode() ^ 1000003) * 1000003) ^ this.f6147b.hashCode()) * 1000003) ^ this.f6148c.hashCode()) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutVariant=" + this.f6146a + ", parameterKey=" + this.f6147b + ", parameterValue=" + this.f6148c + ", templateVersion=" + this.f6149d + "}";
    }

    private w(F.e.d.C0075e.b bVar, String str, String str2, long j4) {
        this.f6146a = bVar;
        this.f6147b = str;
        this.f6148c = str2;
        this.f6149d = j4;
    }
}
