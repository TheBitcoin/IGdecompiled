package B0;

import B0.F;

final class q extends F.e.d.a.b.C0067d {

    /* renamed from: a  reason: collision with root package name */
    private final String f6097a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6098b;

    /* renamed from: c  reason: collision with root package name */
    private final long f6099c;

    static final class b extends F.e.d.a.b.C0067d.C0068a {

        /* renamed from: a  reason: collision with root package name */
        private String f6100a;

        /* renamed from: b  reason: collision with root package name */
        private String f6101b;

        /* renamed from: c  reason: collision with root package name */
        private long f6102c;

        /* renamed from: d  reason: collision with root package name */
        private byte f6103d;

        b() {
        }

        public F.e.d.a.b.C0067d a() {
            String str;
            String str2;
            if (this.f6103d == 1 && (str = this.f6100a) != null && (str2 = this.f6101b) != null) {
                return new q(str, str2, this.f6102c);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f6100a == null) {
                sb.append(" name");
            }
            if (this.f6101b == null) {
                sb.append(" code");
            }
            if ((1 & this.f6103d) == 0) {
                sb.append(" address");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.a.b.C0067d.C0068a b(long j4) {
            this.f6102c = j4;
            this.f6103d = (byte) (this.f6103d | 1);
            return this;
        }

        public F.e.d.a.b.C0067d.C0068a c(String str) {
            if (str != null) {
                this.f6101b = str;
                return this;
            }
            throw new NullPointerException("Null code");
        }

        public F.e.d.a.b.C0067d.C0068a d(String str) {
            if (str != null) {
                this.f6100a = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }
    }

    public long b() {
        return this.f6099c;
    }

    public String c() {
        return this.f6098b;
    }

    public String d() {
        return this.f6097a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.a.b.C0067d) {
            F.e.d.a.b.C0067d dVar = (F.e.d.a.b.C0067d) obj;
            if (!this.f6097a.equals(dVar.d()) || !this.f6098b.equals(dVar.c()) || this.f6099c != dVar.b()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f6099c;
        return ((((this.f6097a.hashCode() ^ 1000003) * 1000003) ^ this.f6098b.hashCode()) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.f6097a + ", code=" + this.f6098b + ", address=" + this.f6099c + "}";
    }

    private q(String str, String str2, long j4) {
        this.f6097a = str;
        this.f6098b = str2;
        this.f6099c = j4;
    }
}
