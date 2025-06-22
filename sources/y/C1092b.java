package y;

import q.i;
import q.p;

/* renamed from: y.b  reason: case insensitive filesystem */
final class C1092b extends C1101k {

    /* renamed from: a  reason: collision with root package name */
    private final long f4764a;

    /* renamed from: b  reason: collision with root package name */
    private final p f4765b;

    /* renamed from: c  reason: collision with root package name */
    private final i f4766c;

    C1092b(long j4, p pVar, i iVar) {
        this.f4764a = j4;
        if (pVar != null) {
            this.f4765b = pVar;
            if (iVar != null) {
                this.f4766c = iVar;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    public i b() {
        return this.f4766c;
    }

    public long c() {
        return this.f4764a;
    }

    public p d() {
        return this.f4765b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1101k) {
            C1101k kVar = (C1101k) obj;
            if (this.f4764a != kVar.c() || !this.f4765b.equals(kVar.d()) || !this.f4766c.equals(kVar.b())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f4764a;
        return this.f4766c.hashCode() ^ ((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f4765b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f4764a + ", transportContext=" + this.f4765b + ", event=" + this.f4766c + "}";
    }
}
