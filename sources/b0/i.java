package B0;

import B0.F;

final class i extends F.e.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f6008a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6009b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6010c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6011d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6012e;

    /* renamed from: f  reason: collision with root package name */
    private final String f6013f;

    static final class b extends F.e.a.C0061a {

        /* renamed from: a  reason: collision with root package name */
        private String f6014a;

        /* renamed from: b  reason: collision with root package name */
        private String f6015b;

        /* renamed from: c  reason: collision with root package name */
        private String f6016c;

        /* renamed from: d  reason: collision with root package name */
        private String f6017d;

        /* renamed from: e  reason: collision with root package name */
        private String f6018e;

        /* renamed from: f  reason: collision with root package name */
        private String f6019f;

        b() {
        }

        public F.e.a a() {
            String str;
            String str2 = this.f6014a;
            if (str2 != null && (str = this.f6015b) != null) {
                return new i(str2, str, this.f6016c, (F.e.a.b) null, this.f6017d, this.f6018e, this.f6019f);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f6014a == null) {
                sb.append(" identifier");
            }
            if (this.f6015b == null) {
                sb.append(" version");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.a.C0061a b(String str) {
            this.f6018e = str;
            return this;
        }

        public F.e.a.C0061a c(String str) {
            this.f6019f = str;
            return this;
        }

        public F.e.a.C0061a d(String str) {
            this.f6016c = str;
            return this;
        }

        public F.e.a.C0061a e(String str) {
            if (str != null) {
                this.f6014a = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public F.e.a.C0061a f(String str) {
            this.f6017d = str;
            return this;
        }

        public F.e.a.C0061a g(String str) {
            if (str != null) {
                this.f6015b = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }
    }

    public String b() {
        return this.f6012e;
    }

    public String c() {
        return this.f6013f;
    }

    public String d() {
        return this.f6010c;
    }

    public String e() {
        return this.f6008a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.a) {
            F.e.a aVar = (F.e.a) obj;
            if (this.f6008a.equals(aVar.e()) && this.f6009b.equals(aVar.h()) && ((str = this.f6010c) != null ? str.equals(aVar.d()) : aVar.d() == null)) {
                aVar.g();
                String str2 = this.f6011d;
                if (str2 != null ? str2.equals(aVar.f()) : aVar.f() == null) {
                    String str3 = this.f6012e;
                    if (str3 != null ? str3.equals(aVar.b()) : aVar.b() == null) {
                        String str4 = this.f6013f;
                        if (str4 != null ? !str4.equals(aVar.c()) : aVar.c() != null) {
                            return false;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String f() {
        return this.f6011d;
    }

    public F.e.a.b g() {
        return null;
    }

    public String h() {
        return this.f6009b;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int hashCode = (((this.f6008a.hashCode() ^ 1000003) * 1000003) ^ this.f6009b.hashCode()) * 1000003;
        String str = this.f6010c;
        int i7 = 0;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        int i8 = (hashCode ^ i4) * -721379959;
        String str2 = this.f6011d;
        if (str2 == null) {
            i5 = 0;
        } else {
            i5 = str2.hashCode();
        }
        int i9 = (i8 ^ i5) * 1000003;
        String str3 = this.f6012e;
        if (str3 == null) {
            i6 = 0;
        } else {
            i6 = str3.hashCode();
        }
        int i10 = (i9 ^ i6) * 1000003;
        String str4 = this.f6013f;
        if (str4 != null) {
            i7 = str4.hashCode();
        }
        return i10 ^ i7;
    }

    public String toString() {
        return "Application{identifier=" + this.f6008a + ", version=" + this.f6009b + ", displayVersion=" + this.f6010c + ", organization=" + null + ", installationUuid=" + this.f6011d + ", developmentPlatform=" + this.f6012e + ", developmentPlatformVersion=" + this.f6013f + "}";
    }

    private i(String str, String str2, String str3, F.e.a.b bVar, String str4, String str5, String str6) {
        this.f6008a = str;
        this.f6009b = str2;
        this.f6010c = str3;
        this.f6011d = str4;
        this.f6012e = str5;
        this.f6013f = str6;
    }
}
