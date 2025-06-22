package r;

import r.C1024g;

/* renamed from: r.b  reason: case insensitive filesystem */
final class C1019b extends C1024g {

    /* renamed from: a  reason: collision with root package name */
    private final C1024g.a f4114a;

    /* renamed from: b  reason: collision with root package name */
    private final long f4115b;

    C1019b(C1024g.a aVar, long j4) {
        if (aVar != null) {
            this.f4114a = aVar;
            this.f4115b = j4;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public long b() {
        return this.f4115b;
    }

    public C1024g.a c() {
        return this.f4114a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1024g) {
            C1024g gVar = (C1024g) obj;
            if (!this.f4114a.equals(gVar.c()) || this.f4115b != gVar.b()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f4115b;
        return ((this.f4114a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f4114a + ", nextRequestWaitMillis=" + this.f4115b + "}";
    }
}
