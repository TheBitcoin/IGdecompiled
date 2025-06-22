package p0;

/* renamed from: p0.a  reason: case insensitive filesystem */
final class C2189a extends p {

    /* renamed from: a  reason: collision with root package name */
    private final long f21430a;

    /* renamed from: b  reason: collision with root package name */
    private final long f21431b;

    /* renamed from: c  reason: collision with root package name */
    private final long f21432c;

    C2189a(long j4, long j5, long j6) {
        this.f21430a = j4;
        this.f21431b = j5;
        this.f21432c = j6;
    }

    public long b() {
        return this.f21431b;
    }

    public long c() {
        return this.f21430a;
    }

    public long d() {
        return this.f21432c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f21430a == pVar.c() && this.f21431b == pVar.b() && this.f21432c == pVar.d()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f21430a;
        long j5 = this.f21431b;
        long j6 = this.f21432c;
        return ((int) (j6 ^ (j6 >>> 32))) ^ ((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f21430a + ", elapsedRealtime=" + this.f21431b + ", uptimeMillis=" + this.f21432c + "}";
    }
}
