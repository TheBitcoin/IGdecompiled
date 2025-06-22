package B0;

import B0.F;

final class t extends F.e.d.a.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f6122a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6123b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6124c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f6125d;

    static final class b extends F.e.d.a.c.C0073a {

        /* renamed from: a  reason: collision with root package name */
        private String f6126a;

        /* renamed from: b  reason: collision with root package name */
        private int f6127b;

        /* renamed from: c  reason: collision with root package name */
        private int f6128c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f6129d;

        /* renamed from: e  reason: collision with root package name */
        private byte f6130e;

        b() {
        }

        public F.e.d.a.c a() {
            String str;
            if (this.f6130e == 7 && (str = this.f6126a) != null) {
                return new t(str, this.f6127b, this.f6128c, this.f6129d);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f6126a == null) {
                sb.append(" processName");
            }
            if ((this.f6130e & 1) == 0) {
                sb.append(" pid");
            }
            if ((this.f6130e & 2) == 0) {
                sb.append(" importance");
            }
            if ((this.f6130e & 4) == 0) {
                sb.append(" defaultProcess");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.a.c.C0073a b(boolean z4) {
            this.f6129d = z4;
            this.f6130e = (byte) (this.f6130e | 4);
            return this;
        }

        public F.e.d.a.c.C0073a c(int i4) {
            this.f6128c = i4;
            this.f6130e = (byte) (this.f6130e | 2);
            return this;
        }

        public F.e.d.a.c.C0073a d(int i4) {
            this.f6127b = i4;
            this.f6130e = (byte) (this.f6130e | 1);
            return this;
        }

        public F.e.d.a.c.C0073a e(String str) {
            if (str != null) {
                this.f6126a = str;
                return this;
            }
            throw new NullPointerException("Null processName");
        }
    }

    public int b() {
        return this.f6124c;
    }

    public int c() {
        return this.f6123b;
    }

    public String d() {
        return this.f6122a;
    }

    public boolean e() {
        return this.f6125d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.a.c) {
            F.e.d.a.c cVar = (F.e.d.a.c) obj;
            if (this.f6122a.equals(cVar.d()) && this.f6123b == cVar.c() && this.f6124c == cVar.b() && this.f6125d == cVar.e()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int hashCode = (((((this.f6122a.hashCode() ^ 1000003) * 1000003) ^ this.f6123b) * 1000003) ^ this.f6124c) * 1000003;
        if (this.f6125d) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        return hashCode ^ i4;
    }

    public String toString() {
        return "ProcessDetails{processName=" + this.f6122a + ", pid=" + this.f6123b + ", importance=" + this.f6124c + ", defaultProcess=" + this.f6125d + "}";
    }

    private t(String str, int i4, int i5, boolean z4) {
        this.f6122a = str;
        this.f6123b = i4;
        this.f6124c = i5;
        this.f6125d = z4;
    }
}
