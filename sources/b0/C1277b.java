package B0;

import B0.F;

/* renamed from: B0.b  reason: case insensitive filesystem */
final class C1277b extends F {

    /* renamed from: b  reason: collision with root package name */
    private final String f5921b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5922c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5923d;

    /* renamed from: e  reason: collision with root package name */
    private final String f5924e;

    /* renamed from: f  reason: collision with root package name */
    private final String f5925f;

    /* renamed from: g  reason: collision with root package name */
    private final String f5926g;

    /* renamed from: h  reason: collision with root package name */
    private final String f5927h;

    /* renamed from: i  reason: collision with root package name */
    private final String f5928i;

    /* renamed from: j  reason: collision with root package name */
    private final String f5929j;

    /* renamed from: k  reason: collision with root package name */
    private final F.e f5930k;

    /* renamed from: l  reason: collision with root package name */
    private final F.d f5931l;

    /* renamed from: m  reason: collision with root package name */
    private final F.a f5932m;

    /* renamed from: B0.b$b  reason: collision with other inner class name */
    static final class C0078b extends F.b {

        /* renamed from: a  reason: collision with root package name */
        private String f5933a;

        /* renamed from: b  reason: collision with root package name */
        private String f5934b;

        /* renamed from: c  reason: collision with root package name */
        private int f5935c;

        /* renamed from: d  reason: collision with root package name */
        private String f5936d;

        /* renamed from: e  reason: collision with root package name */
        private String f5937e;

        /* renamed from: f  reason: collision with root package name */
        private String f5938f;

        /* renamed from: g  reason: collision with root package name */
        private String f5939g;

        /* renamed from: h  reason: collision with root package name */
        private String f5940h;

        /* renamed from: i  reason: collision with root package name */
        private String f5941i;

        /* renamed from: j  reason: collision with root package name */
        private F.e f5942j;

        /* renamed from: k  reason: collision with root package name */
        private F.d f5943k;

        /* renamed from: l  reason: collision with root package name */
        private F.a f5944l;

        /* renamed from: m  reason: collision with root package name */
        private byte f5945m;

        public F a() {
            if (this.f5945m == 1 && this.f5933a != null && this.f5934b != null && this.f5936d != null && this.f5940h != null && this.f5941i != null) {
                return new C1277b(this.f5933a, this.f5934b, this.f5935c, this.f5936d, this.f5937e, this.f5938f, this.f5939g, this.f5940h, this.f5941i, this.f5942j, this.f5943k, this.f5944l);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f5933a == null) {
                sb.append(" sdkVersion");
            }
            if (this.f5934b == null) {
                sb.append(" gmpAppId");
            }
            if ((1 & this.f5945m) == 0) {
                sb.append(" platform");
            }
            if (this.f5936d == null) {
                sb.append(" installationUuid");
            }
            if (this.f5940h == null) {
                sb.append(" buildVersion");
            }
            if (this.f5941i == null) {
                sb.append(" displayVersion");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.b b(F.a aVar) {
            this.f5944l = aVar;
            return this;
        }

        public F.b c(String str) {
            this.f5939g = str;
            return this;
        }

        public F.b d(String str) {
            if (str != null) {
                this.f5940h = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        public F.b e(String str) {
            if (str != null) {
                this.f5941i = str;
                return this;
            }
            throw new NullPointerException("Null displayVersion");
        }

        public F.b f(String str) {
            this.f5938f = str;
            return this;
        }

        public F.b g(String str) {
            this.f5937e = str;
            return this;
        }

        public F.b h(String str) {
            if (str != null) {
                this.f5934b = str;
                return this;
            }
            throw new NullPointerException("Null gmpAppId");
        }

        public F.b i(String str) {
            if (str != null) {
                this.f5936d = str;
                return this;
            }
            throw new NullPointerException("Null installationUuid");
        }

        public F.b j(F.d dVar) {
            this.f5943k = dVar;
            return this;
        }

        public F.b k(int i4) {
            this.f5935c = i4;
            this.f5945m = (byte) (this.f5945m | 1);
            return this;
        }

        public F.b l(String str) {
            if (str != null) {
                this.f5933a = str;
                return this;
            }
            throw new NullPointerException("Null sdkVersion");
        }

        public F.b m(F.e eVar) {
            this.f5942j = eVar;
            return this;
        }

        C0078b() {
        }

        private C0078b(F f4) {
            this.f5933a = f4.m();
            this.f5934b = f4.i();
            this.f5935c = f4.l();
            this.f5936d = f4.j();
            this.f5937e = f4.h();
            this.f5938f = f4.g();
            this.f5939g = f4.d();
            this.f5940h = f4.e();
            this.f5941i = f4.f();
            this.f5942j = f4.n();
            this.f5943k = f4.k();
            this.f5944l = f4.c();
            this.f5945m = 1;
        }
    }

    public F.a c() {
        return this.f5932m;
    }

    public String d() {
        return this.f5927h;
    }

    public String e() {
        return this.f5928i;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        F.e eVar;
        F.d dVar;
        F.a aVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F) {
            F f4 = (F) obj;
            if (!this.f5921b.equals(f4.m()) || !this.f5922c.equals(f4.i()) || this.f5923d != f4.l() || !this.f5924e.equals(f4.j()) || ((str = this.f5925f) != null ? !str.equals(f4.h()) : f4.h() != null) || ((str2 = this.f5926g) != null ? !str2.equals(f4.g()) : f4.g() != null) || ((str3 = this.f5927h) != null ? !str3.equals(f4.d()) : f4.d() != null) || !this.f5928i.equals(f4.e()) || !this.f5929j.equals(f4.f()) || ((eVar = this.f5930k) != null ? !eVar.equals(f4.n()) : f4.n() != null) || ((dVar = this.f5931l) != null ? !dVar.equals(f4.k()) : f4.k() != null) || ((aVar = this.f5932m) != null ? !aVar.equals(f4.c()) : f4.c() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String f() {
        return this.f5929j;
    }

    public String g() {
        return this.f5926g;
    }

    public String h() {
        return this.f5925f;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int hashCode = (((((((this.f5921b.hashCode() ^ 1000003) * 1000003) ^ this.f5922c.hashCode()) * 1000003) ^ this.f5923d) * 1000003) ^ this.f5924e.hashCode()) * 1000003;
        String str = this.f5925f;
        int i9 = 0;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        int i10 = (hashCode ^ i4) * 1000003;
        String str2 = this.f5926g;
        if (str2 == null) {
            i5 = 0;
        } else {
            i5 = str2.hashCode();
        }
        int i11 = (i10 ^ i5) * 1000003;
        String str3 = this.f5927h;
        if (str3 == null) {
            i6 = 0;
        } else {
            i6 = str3.hashCode();
        }
        int hashCode2 = (((((i11 ^ i6) * 1000003) ^ this.f5928i.hashCode()) * 1000003) ^ this.f5929j.hashCode()) * 1000003;
        F.e eVar = this.f5930k;
        if (eVar == null) {
            i7 = 0;
        } else {
            i7 = eVar.hashCode();
        }
        int i12 = (hashCode2 ^ i7) * 1000003;
        F.d dVar = this.f5931l;
        if (dVar == null) {
            i8 = 0;
        } else {
            i8 = dVar.hashCode();
        }
        int i13 = (i12 ^ i8) * 1000003;
        F.a aVar = this.f5932m;
        if (aVar != null) {
            i9 = aVar.hashCode();
        }
        return i13 ^ i9;
    }

    public String i() {
        return this.f5922c;
    }

    public String j() {
        return this.f5924e;
    }

    public F.d k() {
        return this.f5931l;
    }

    public int l() {
        return this.f5923d;
    }

    public String m() {
        return this.f5921b;
    }

    public F.e n() {
        return this.f5930k;
    }

    /* access modifiers changed from: protected */
    public F.b o() {
        return new C0078b(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f5921b + ", gmpAppId=" + this.f5922c + ", platform=" + this.f5923d + ", installationUuid=" + this.f5924e + ", firebaseInstallationId=" + this.f5925f + ", firebaseAuthenticationToken=" + this.f5926g + ", appQualitySessionId=" + this.f5927h + ", buildVersion=" + this.f5928i + ", displayVersion=" + this.f5929j + ", session=" + this.f5930k + ", ndkPayload=" + this.f5931l + ", appExitInfo=" + this.f5932m + "}";
    }

    private C1277b(String str, String str2, int i4, String str3, String str4, String str5, String str6, String str7, String str8, F.e eVar, F.d dVar, F.a aVar) {
        this.f5921b = str;
        this.f5922c = str2;
        this.f5923d = i4;
        this.f5924e = str3;
        this.f5925f = str4;
        this.f5926g = str5;
        this.f5927h = str6;
        this.f5928i = str7;
        this.f5929j = str8;
        this.f5930k = eVar;
        this.f5931l = dVar;
        this.f5932m = aVar;
    }
}
