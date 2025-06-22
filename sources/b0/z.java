package B0;

import B0.F;

final class z extends F.e.C0076e {

    /* renamed from: a  reason: collision with root package name */
    private final int f6161a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6162b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6163c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f6164d;

    static final class b extends F.e.C0076e.a {

        /* renamed from: a  reason: collision with root package name */
        private int f6165a;

        /* renamed from: b  reason: collision with root package name */
        private String f6166b;

        /* renamed from: c  reason: collision with root package name */
        private String f6167c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f6168d;

        /* renamed from: e  reason: collision with root package name */
        private byte f6169e;

        b() {
        }

        public F.e.C0076e a() {
            String str;
            String str2;
            if (this.f6169e == 3 && (str = this.f6166b) != null && (str2 = this.f6167c) != null) {
                return new z(this.f6165a, str, str2, this.f6168d);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f6169e & 1) == 0) {
                sb.append(" platform");
            }
            if (this.f6166b == null) {
                sb.append(" version");
            }
            if (this.f6167c == null) {
                sb.append(" buildVersion");
            }
            if ((this.f6169e & 2) == 0) {
                sb.append(" jailbroken");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.C0076e.a b(String str) {
            if (str != null) {
                this.f6167c = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        public F.e.C0076e.a c(boolean z4) {
            this.f6168d = z4;
            this.f6169e = (byte) (this.f6169e | 2);
            return this;
        }

        public F.e.C0076e.a d(int i4) {
            this.f6165a = i4;
            this.f6169e = (byte) (this.f6169e | 1);
            return this;
        }

        public F.e.C0076e.a e(String str) {
            if (str != null) {
                this.f6166b = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }
    }

    public String b() {
        return this.f6163c;
    }

    public int c() {
        return this.f6161a;
    }

    public String d() {
        return this.f6162b;
    }

    public boolean e() {
        return this.f6164d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.C0076e) {
            F.e.C0076e eVar = (F.e.C0076e) obj;
            if (this.f6161a != eVar.c() || !this.f6162b.equals(eVar.d()) || !this.f6163c.equals(eVar.b()) || this.f6164d != eVar.e()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int hashCode = (((((this.f6161a ^ 1000003) * 1000003) ^ this.f6162b.hashCode()) * 1000003) ^ this.f6163c.hashCode()) * 1000003;
        if (this.f6164d) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        return hashCode ^ i4;
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f6161a + ", version=" + this.f6162b + ", buildVersion=" + this.f6163c + ", jailbroken=" + this.f6164d + "}";
    }

    private z(int i4, String str, String str2, boolean z4) {
        this.f6161a = i4;
        this.f6162b = str;
        this.f6163c = str2;
        this.f6164d = z4;
    }
}
