package B0;

import B0.F;
import java.util.List;

final class m extends F.e.d.a {

    /* renamed from: a  reason: collision with root package name */
    private final F.e.d.a.b f6052a;

    /* renamed from: b  reason: collision with root package name */
    private final List f6053b;

    /* renamed from: c  reason: collision with root package name */
    private final List f6054c;

    /* renamed from: d  reason: collision with root package name */
    private final Boolean f6055d;

    /* renamed from: e  reason: collision with root package name */
    private final F.e.d.a.c f6056e;

    /* renamed from: f  reason: collision with root package name */
    private final List f6057f;

    /* renamed from: g  reason: collision with root package name */
    private final int f6058g;

    static final class b extends F.e.d.a.C0062a {

        /* renamed from: a  reason: collision with root package name */
        private F.e.d.a.b f6059a;

        /* renamed from: b  reason: collision with root package name */
        private List f6060b;

        /* renamed from: c  reason: collision with root package name */
        private List f6061c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f6062d;

        /* renamed from: e  reason: collision with root package name */
        private F.e.d.a.c f6063e;

        /* renamed from: f  reason: collision with root package name */
        private List f6064f;

        /* renamed from: g  reason: collision with root package name */
        private int f6065g;

        /* renamed from: h  reason: collision with root package name */
        private byte f6066h;

        public F.e.d.a a() {
            F.e.d.a.b bVar;
            if (this.f6066h == 1 && (bVar = this.f6059a) != null) {
                return new m(bVar, this.f6060b, this.f6061c, this.f6062d, this.f6063e, this.f6064f, this.f6065g);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f6059a == null) {
                sb.append(" execution");
            }
            if ((1 & this.f6066h) == 0) {
                sb.append(" uiOrientation");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.a.C0062a b(List list) {
            this.f6064f = list;
            return this;
        }

        public F.e.d.a.C0062a c(Boolean bool) {
            this.f6062d = bool;
            return this;
        }

        public F.e.d.a.C0062a d(F.e.d.a.c cVar) {
            this.f6063e = cVar;
            return this;
        }

        public F.e.d.a.C0062a e(List list) {
            this.f6060b = list;
            return this;
        }

        public F.e.d.a.C0062a f(F.e.d.a.b bVar) {
            if (bVar != null) {
                this.f6059a = bVar;
                return this;
            }
            throw new NullPointerException("Null execution");
        }

        public F.e.d.a.C0062a g(List list) {
            this.f6061c = list;
            return this;
        }

        public F.e.d.a.C0062a h(int i4) {
            this.f6065g = i4;
            this.f6066h = (byte) (this.f6066h | 1);
            return this;
        }

        b() {
        }

        private b(F.e.d.a aVar) {
            this.f6059a = aVar.f();
            this.f6060b = aVar.e();
            this.f6061c = aVar.g();
            this.f6062d = aVar.c();
            this.f6063e = aVar.d();
            this.f6064f = aVar.b();
            this.f6065g = aVar.h();
            this.f6066h = 1;
        }
    }

    public List b() {
        return this.f6057f;
    }

    public Boolean c() {
        return this.f6055d;
    }

    public F.e.d.a.c d() {
        return this.f6056e;
    }

    public List e() {
        return this.f6053b;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        Boolean bool;
        F.e.d.a.c cVar;
        List list3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.a) {
            F.e.d.a aVar = (F.e.d.a) obj;
            if (!this.f6052a.equals(aVar.f()) || ((list = this.f6053b) != null ? !list.equals(aVar.e()) : aVar.e() != null) || ((list2 = this.f6054c) != null ? !list2.equals(aVar.g()) : aVar.g() != null) || ((bool = this.f6055d) != null ? !bool.equals(aVar.c()) : aVar.c() != null) || ((cVar = this.f6056e) != null ? !cVar.equals(aVar.d()) : aVar.d() != null) || ((list3 = this.f6057f) != null ? !list3.equals(aVar.b()) : aVar.b() != null) || this.f6058g != aVar.h()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public F.e.d.a.b f() {
        return this.f6052a;
    }

    public List g() {
        return this.f6054c;
    }

    public int h() {
        return this.f6058g;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7;
        int hashCode = (this.f6052a.hashCode() ^ 1000003) * 1000003;
        List list = this.f6053b;
        int i8 = 0;
        if (list == null) {
            i4 = 0;
        } else {
            i4 = list.hashCode();
        }
        int i9 = (hashCode ^ i4) * 1000003;
        List list2 = this.f6054c;
        if (list2 == null) {
            i5 = 0;
        } else {
            i5 = list2.hashCode();
        }
        int i10 = (i9 ^ i5) * 1000003;
        Boolean bool = this.f6055d;
        if (bool == null) {
            i6 = 0;
        } else {
            i6 = bool.hashCode();
        }
        int i11 = (i10 ^ i6) * 1000003;
        F.e.d.a.c cVar = this.f6056e;
        if (cVar == null) {
            i7 = 0;
        } else {
            i7 = cVar.hashCode();
        }
        int i12 = (i11 ^ i7) * 1000003;
        List list3 = this.f6057f;
        if (list3 != null) {
            i8 = list3.hashCode();
        }
        return ((i12 ^ i8) * 1000003) ^ this.f6058g;
    }

    public F.e.d.a.C0062a i() {
        return new b(this);
    }

    public String toString() {
        return "Application{execution=" + this.f6052a + ", customAttributes=" + this.f6053b + ", internalKeys=" + this.f6054c + ", background=" + this.f6055d + ", currentProcessDetails=" + this.f6056e + ", appProcessDetails=" + this.f6057f + ", uiOrientation=" + this.f6058g + "}";
    }

    private m(F.e.d.a.b bVar, List list, List list2, Boolean bool, F.e.d.a.c cVar, List list3, int i4) {
        this.f6052a = bVar;
        this.f6053b = list;
        this.f6054c = list2;
        this.f6055d = bool;
        this.f6056e = cVar;
        this.f6057f = list3;
        this.f6058g = i4;
    }
}
