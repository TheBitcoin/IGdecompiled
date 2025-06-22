package p;

import p.w;

final class m extends w {

    /* renamed from: a  reason: collision with root package name */
    private final w.c f3861a;

    /* renamed from: b  reason: collision with root package name */
    private final w.b f3862b;

    static final class b extends w.a {

        /* renamed from: a  reason: collision with root package name */
        private w.c f3863a;

        /* renamed from: b  reason: collision with root package name */
        private w.b f3864b;

        b() {
        }

        public w a() {
            return new m(this.f3863a, this.f3864b);
        }

        public w.a b(w.b bVar) {
            this.f3864b = bVar;
            return this;
        }

        public w.a c(w.c cVar) {
            this.f3863a = cVar;
            return this;
        }
    }

    public w.b b() {
        return this.f3862b;
    }

    public w.c c() {
        return this.f3861a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            w.c cVar = this.f3861a;
            if (cVar != null ? cVar.equals(wVar.c()) : wVar.c() == null) {
                w.b bVar = this.f3862b;
                if (bVar != null ? !bVar.equals(wVar.b()) : wVar.b() != null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i4;
        w.c cVar = this.f3861a;
        int i5 = 0;
        if (cVar == null) {
            i4 = 0;
        } else {
            i4 = cVar.hashCode();
        }
        int i6 = (i4 ^ 1000003) * 1000003;
        w.b bVar = this.f3862b;
        if (bVar != null) {
            i5 = bVar.hashCode();
        }
        return i6 ^ i5;
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f3861a + ", mobileSubtype=" + this.f3862b + "}";
    }

    private m(w.c cVar, w.b bVar) {
        this.f3861a = cVar;
        this.f3862b = bVar;
    }
}
