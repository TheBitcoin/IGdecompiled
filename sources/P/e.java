package p;

import p.o;

final class e extends o {

    /* renamed from: a  reason: collision with root package name */
    private final o.b f3812a;

    /* renamed from: b  reason: collision with root package name */
    private final C1015a f3813b;

    static final class b extends o.a {

        /* renamed from: a  reason: collision with root package name */
        private o.b f3814a;

        /* renamed from: b  reason: collision with root package name */
        private C1015a f3815b;

        b() {
        }

        public o a() {
            return new e(this.f3814a, this.f3815b);
        }

        public o.a b(C1015a aVar) {
            this.f3815b = aVar;
            return this;
        }

        public o.a c(o.b bVar) {
            this.f3814a = bVar;
            return this;
        }
    }

    public C1015a b() {
        return this.f3813b;
    }

    public o.b c() {
        return this.f3812a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            o.b bVar = this.f3812a;
            if (bVar != null ? bVar.equals(oVar.c()) : oVar.c() == null) {
                C1015a aVar = this.f3813b;
                if (aVar != null ? !aVar.equals(oVar.b()) : oVar.b() != null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i4;
        o.b bVar = this.f3812a;
        int i5 = 0;
        if (bVar == null) {
            i4 = 0;
        } else {
            i4 = bVar.hashCode();
        }
        int i6 = (i4 ^ 1000003) * 1000003;
        C1015a aVar = this.f3813b;
        if (aVar != null) {
            i5 = aVar.hashCode();
        }
        return i6 ^ i5;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f3812a + ", androidClientInfo=" + this.f3813b + "}";
    }

    private e(o.b bVar, C1015a aVar) {
        this.f3812a = bVar;
        this.f3813b = aVar;
    }
}
