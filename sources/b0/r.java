package B0;

import B0.F;
import java.util.List;

final class r extends F.e.d.a.b.C0069e {

    /* renamed from: a  reason: collision with root package name */
    private final String f6104a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6105b;

    /* renamed from: c  reason: collision with root package name */
    private final List f6106c;

    static final class b extends F.e.d.a.b.C0069e.C0070a {

        /* renamed from: a  reason: collision with root package name */
        private String f6107a;

        /* renamed from: b  reason: collision with root package name */
        private int f6108b;

        /* renamed from: c  reason: collision with root package name */
        private List f6109c;

        /* renamed from: d  reason: collision with root package name */
        private byte f6110d;

        b() {
        }

        public F.e.d.a.b.C0069e a() {
            String str;
            List list;
            if (this.f6110d == 1 && (str = this.f6107a) != null && (list = this.f6109c) != null) {
                return new r(str, this.f6108b, list);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f6107a == null) {
                sb.append(" name");
            }
            if ((1 & this.f6110d) == 0) {
                sb.append(" importance");
            }
            if (this.f6109c == null) {
                sb.append(" frames");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.a.b.C0069e.C0070a b(List list) {
            if (list != null) {
                this.f6109c = list;
                return this;
            }
            throw new NullPointerException("Null frames");
        }

        public F.e.d.a.b.C0069e.C0070a c(int i4) {
            this.f6108b = i4;
            this.f6110d = (byte) (this.f6110d | 1);
            return this;
        }

        public F.e.d.a.b.C0069e.C0070a d(String str) {
            if (str != null) {
                this.f6107a = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }
    }

    public List b() {
        return this.f6106c;
    }

    public int c() {
        return this.f6105b;
    }

    public String d() {
        return this.f6104a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.a.b.C0069e) {
            F.e.d.a.b.C0069e eVar = (F.e.d.a.b.C0069e) obj;
            if (!this.f6104a.equals(eVar.d()) || this.f6105b != eVar.c() || !this.f6106c.equals(eVar.b())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f6104a.hashCode() ^ 1000003) * 1000003) ^ this.f6105b) * 1000003) ^ this.f6106c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.f6104a + ", importance=" + this.f6105b + ", frames=" + this.f6106c + "}";
    }

    private r(String str, int i4, List list) {
        this.f6104a = str;
        this.f6105b = i4;
        this.f6106c = list;
    }
}
