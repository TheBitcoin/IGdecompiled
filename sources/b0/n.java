package B0;

import B0.F;
import java.util.List;

final class n extends F.e.d.a.b {

    /* renamed from: a  reason: collision with root package name */
    private final List f6067a;

    /* renamed from: b  reason: collision with root package name */
    private final F.e.d.a.b.c f6068b;

    /* renamed from: c  reason: collision with root package name */
    private final F.a f6069c;

    /* renamed from: d  reason: collision with root package name */
    private final F.e.d.a.b.C0067d f6070d;

    /* renamed from: e  reason: collision with root package name */
    private final List f6071e;

    static final class b extends F.e.d.a.b.C0065b {

        /* renamed from: a  reason: collision with root package name */
        private List f6072a;

        /* renamed from: b  reason: collision with root package name */
        private F.e.d.a.b.c f6073b;

        /* renamed from: c  reason: collision with root package name */
        private F.a f6074c;

        /* renamed from: d  reason: collision with root package name */
        private F.e.d.a.b.C0067d f6075d;

        /* renamed from: e  reason: collision with root package name */
        private List f6076e;

        b() {
        }

        public F.e.d.a.b a() {
            List list;
            F.e.d.a.b.C0067d dVar = this.f6075d;
            if (dVar != null && (list = this.f6076e) != null) {
                return new n(this.f6072a, this.f6073b, this.f6074c, dVar, list);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f6075d == null) {
                sb.append(" signal");
            }
            if (this.f6076e == null) {
                sb.append(" binaries");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.a.b.C0065b b(F.a aVar) {
            this.f6074c = aVar;
            return this;
        }

        public F.e.d.a.b.C0065b c(List list) {
            if (list != null) {
                this.f6076e = list;
                return this;
            }
            throw new NullPointerException("Null binaries");
        }

        public F.e.d.a.b.C0065b d(F.e.d.a.b.c cVar) {
            this.f6073b = cVar;
            return this;
        }

        public F.e.d.a.b.C0065b e(F.e.d.a.b.C0067d dVar) {
            if (dVar != null) {
                this.f6075d = dVar;
                return this;
            }
            throw new NullPointerException("Null signal");
        }

        public F.e.d.a.b.C0065b f(List list) {
            this.f6072a = list;
            return this;
        }
    }

    public F.a b() {
        return this.f6069c;
    }

    public List c() {
        return this.f6071e;
    }

    public F.e.d.a.b.c d() {
        return this.f6068b;
    }

    public F.e.d.a.b.C0067d e() {
        return this.f6070d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.a.b) {
            F.e.d.a.b bVar = (F.e.d.a.b) obj;
            List list = this.f6067a;
            if (list != null ? list.equals(bVar.f()) : bVar.f() == null) {
                F.e.d.a.b.c cVar = this.f6068b;
                if (cVar != null ? cVar.equals(bVar.d()) : bVar.d() == null) {
                    F.a aVar = this.f6069c;
                    if (aVar != null ? aVar.equals(bVar.b()) : bVar.b() == null) {
                        if (!this.f6070d.equals(bVar.e()) || !this.f6071e.equals(bVar.c())) {
                            return false;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List f() {
        return this.f6067a;
    }

    public int hashCode() {
        int i4;
        int i5;
        List list = this.f6067a;
        int i6 = 0;
        if (list == null) {
            i4 = 0;
        } else {
            i4 = list.hashCode();
        }
        int i7 = (i4 ^ 1000003) * 1000003;
        F.e.d.a.b.c cVar = this.f6068b;
        if (cVar == null) {
            i5 = 0;
        } else {
            i5 = cVar.hashCode();
        }
        int i8 = (i7 ^ i5) * 1000003;
        F.a aVar = this.f6069c;
        if (aVar != null) {
            i6 = aVar.hashCode();
        }
        return ((((i8 ^ i6) * 1000003) ^ this.f6070d.hashCode()) * 1000003) ^ this.f6071e.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f6067a + ", exception=" + this.f6068b + ", appExitInfo=" + this.f6069c + ", signal=" + this.f6070d + ", binaries=" + this.f6071e + "}";
    }

    private n(List list, F.e.d.a.b.c cVar, F.a aVar, F.e.d.a.b.C0067d dVar, List list2) {
        this.f6067a = list;
        this.f6068b = cVar;
        this.f6069c = aVar;
        this.f6070d = dVar;
        this.f6071e = list2;
    }
}
