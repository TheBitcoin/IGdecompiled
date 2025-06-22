package p;

final class l extends v {

    /* renamed from: a  reason: collision with root package name */
    private final long f3860a;

    l(long j4) {
        this.f3860a = j4;
    }

    public long c() {
        return this.f3860a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v) || this.f3860a != ((v) obj).c()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j4 = this.f3860a;
        return 1000003 ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f3860a + "}";
    }
}
