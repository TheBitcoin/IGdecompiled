package p;

import p.p;

final class f extends p {

    /* renamed from: a  reason: collision with root package name */
    private final s f3816a;

    /* renamed from: b  reason: collision with root package name */
    private final p.b f3817b;

    static final class b extends p.a {

        /* renamed from: a  reason: collision with root package name */
        private s f3818a;

        /* renamed from: b  reason: collision with root package name */
        private p.b f3819b;

        b() {
        }

        public p a() {
            return new f(this.f3818a, this.f3819b);
        }

        public p.a b(s sVar) {
            this.f3818a = sVar;
            return this;
        }

        public p.a c(p.b bVar) {
            this.f3819b = bVar;
            return this;
        }
    }

    public s b() {
        return this.f3816a;
    }

    public p.b c() {
        return this.f3817b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            s sVar = this.f3816a;
            if (sVar != null ? sVar.equals(pVar.b()) : pVar.b() == null) {
                p.b bVar = this.f3817b;
                if (bVar != null ? !bVar.equals(pVar.c()) : pVar.c() != null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i4;
        s sVar = this.f3816a;
        int i5 = 0;
        if (sVar == null) {
            i4 = 0;
        } else {
            i4 = sVar.hashCode();
        }
        int i6 = (i4 ^ 1000003) * 1000003;
        p.b bVar = this.f3817b;
        if (bVar != null) {
            i5 = bVar.hashCode();
        }
        return i6 ^ i5;
    }

    public String toString() {
        return "ComplianceData{privacyContext=" + this.f3816a + ", productIdOrigin=" + this.f3817b + "}";
    }

    private f(s sVar, p.b bVar) {
        this.f3816a = sVar;
        this.f3817b = bVar;
    }
}
