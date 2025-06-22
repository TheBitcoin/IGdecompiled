package x;

import java.util.Set;
import x.f;

/* renamed from: x.c  reason: case insensitive filesystem */
final class C1083c extends f.b {

    /* renamed from: a  reason: collision with root package name */
    private final long f4612a;

    /* renamed from: b  reason: collision with root package name */
    private final long f4613b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f4614c;

    /* renamed from: x.c$b */
    static final class b extends f.b.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f4615a;

        /* renamed from: b  reason: collision with root package name */
        private Long f4616b;

        /* renamed from: c  reason: collision with root package name */
        private Set f4617c;

        b() {
        }

        public f.b a() {
            String str = "";
            if (this.f4615a == null) {
                str = str + " delta";
            }
            if (this.f4616b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f4617c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new C1083c(this.f4615a.longValue(), this.f4616b.longValue(), this.f4617c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public f.b.a b(long j4) {
            this.f4615a = Long.valueOf(j4);
            return this;
        }

        public f.b.a c(Set set) {
            if (set != null) {
                this.f4617c = set;
                return this;
            }
            throw new NullPointerException("Null flags");
        }

        public f.b.a d(long j4) {
            this.f4616b = Long.valueOf(j4);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public long b() {
        return this.f4612a;
    }

    /* access modifiers changed from: package-private */
    public Set c() {
        return this.f4614c;
    }

    /* access modifiers changed from: package-private */
    public long d() {
        return this.f4613b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f.b) {
            f.b bVar = (f.b) obj;
            if (this.f4612a == bVar.b() && this.f4613b == bVar.d() && this.f4614c.equals(bVar.c())) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f4612a;
        long j5 = this.f4613b;
        return this.f4614c.hashCode() ^ ((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f4612a + ", maxAllowedDelay=" + this.f4613b + ", flags=" + this.f4614c + "}";
    }

    private C1083c(long j4, long j5, Set set) {
        this.f4612a = j4;
        this.f4613b = j5;
        this.f4614c = set;
    }
}
