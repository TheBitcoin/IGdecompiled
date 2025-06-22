package B0;

import B0.F;
import java.util.List;

final class p extends F.e.d.a.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f6086a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6087b;

    /* renamed from: c  reason: collision with root package name */
    private final List f6088c;

    /* renamed from: d  reason: collision with root package name */
    private final F.e.d.a.b.c f6089d;

    /* renamed from: e  reason: collision with root package name */
    private final int f6090e;

    static final class b extends F.e.d.a.b.c.C0066a {

        /* renamed from: a  reason: collision with root package name */
        private String f6091a;

        /* renamed from: b  reason: collision with root package name */
        private String f6092b;

        /* renamed from: c  reason: collision with root package name */
        private List f6093c;

        /* renamed from: d  reason: collision with root package name */
        private F.e.d.a.b.c f6094d;

        /* renamed from: e  reason: collision with root package name */
        private int f6095e;

        /* renamed from: f  reason: collision with root package name */
        private byte f6096f;

        b() {
        }

        public F.e.d.a.b.c a() {
            String str;
            List list;
            if (this.f6096f == 1 && (str = this.f6091a) != null && (list = this.f6093c) != null) {
                return new p(str, this.f6092b, list, this.f6094d, this.f6095e);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f6091a == null) {
                sb.append(" type");
            }
            if (this.f6093c == null) {
                sb.append(" frames");
            }
            if ((1 & this.f6096f) == 0) {
                sb.append(" overflowCount");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.a.b.c.C0066a b(F.e.d.a.b.c cVar) {
            this.f6094d = cVar;
            return this;
        }

        public F.e.d.a.b.c.C0066a c(List list) {
            if (list != null) {
                this.f6093c = list;
                return this;
            }
            throw new NullPointerException("Null frames");
        }

        public F.e.d.a.b.c.C0066a d(int i4) {
            this.f6095e = i4;
            this.f6096f = (byte) (this.f6096f | 1);
            return this;
        }

        public F.e.d.a.b.c.C0066a e(String str) {
            this.f6092b = str;
            return this;
        }

        public F.e.d.a.b.c.C0066a f(String str) {
            if (str != null) {
                this.f6091a = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }
    }

    public F.e.d.a.b.c b() {
        return this.f6089d;
    }

    public List c() {
        return this.f6088c;
    }

    public int d() {
        return this.f6090e;
    }

    public String e() {
        return this.f6087b;
    }

    public boolean equals(Object obj) {
        String str;
        F.e.d.a.b.c cVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.a.b.c) {
            F.e.d.a.b.c cVar2 = (F.e.d.a.b.c) obj;
            if (!this.f6086a.equals(cVar2.f()) || ((str = this.f6087b) != null ? !str.equals(cVar2.e()) : cVar2.e() != null) || !this.f6088c.equals(cVar2.c()) || ((cVar = this.f6089d) != null ? !cVar.equals(cVar2.b()) : cVar2.b() != null) || this.f6090e != cVar2.d()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String f() {
        return this.f6086a;
    }

    public int hashCode() {
        int i4;
        int hashCode = (this.f6086a.hashCode() ^ 1000003) * 1000003;
        String str = this.f6087b;
        int i5 = 0;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        int hashCode2 = (((hashCode ^ i4) * 1000003) ^ this.f6088c.hashCode()) * 1000003;
        F.e.d.a.b.c cVar = this.f6089d;
        if (cVar != null) {
            i5 = cVar.hashCode();
        }
        return ((hashCode2 ^ i5) * 1000003) ^ this.f6090e;
    }

    public String toString() {
        return "Exception{type=" + this.f6086a + ", reason=" + this.f6087b + ", frames=" + this.f6088c + ", causedBy=" + this.f6089d + ", overflowCount=" + this.f6090e + "}";
    }

    private p(String str, String str2, List list, F.e.d.a.b.c cVar, int i4) {
        this.f6086a = str;
        this.f6087b = str2;
        this.f6088c = list;
        this.f6089d = cVar;
        this.f6090e = i4;
    }
}
