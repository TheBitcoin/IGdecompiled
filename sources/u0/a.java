package U0;

import U0.d;

final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f8362a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8363b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8364c;

    /* renamed from: d  reason: collision with root package name */
    private final f f8365d;

    /* renamed from: e  reason: collision with root package name */
    private final d.b f8366e;

    static final class b extends d.a {

        /* renamed from: a  reason: collision with root package name */
        private String f8367a;

        /* renamed from: b  reason: collision with root package name */
        private String f8368b;

        /* renamed from: c  reason: collision with root package name */
        private String f8369c;

        /* renamed from: d  reason: collision with root package name */
        private f f8370d;

        /* renamed from: e  reason: collision with root package name */
        private d.b f8371e;

        b() {
        }

        public d a() {
            return new a(this.f8367a, this.f8368b, this.f8369c, this.f8370d, this.f8371e);
        }

        public d.a b(f fVar) {
            this.f8370d = fVar;
            return this;
        }

        public d.a c(String str) {
            this.f8368b = str;
            return this;
        }

        public d.a d(String str) {
            this.f8369c = str;
            return this;
        }

        public d.a e(d.b bVar) {
            this.f8371e = bVar;
            return this;
        }

        public d.a f(String str) {
            this.f8367a = str;
            return this;
        }
    }

    public f b() {
        return this.f8365d;
    }

    public String c() {
        return this.f8363b;
    }

    public String d() {
        return this.f8364c;
    }

    public d.b e() {
        return this.f8366e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str = this.f8362a;
            if (str != null ? str.equals(dVar.f()) : dVar.f() == null) {
                String str2 = this.f8363b;
                if (str2 != null ? str2.equals(dVar.c()) : dVar.c() == null) {
                    String str3 = this.f8364c;
                    if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
                        f fVar = this.f8365d;
                        if (fVar != null ? fVar.equals(dVar.b()) : dVar.b() == null) {
                            d.b bVar = this.f8366e;
                            if (bVar != null ? !bVar.equals(dVar.e()) : dVar.e() != null) {
                                return false;
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String f() {
        return this.f8362a;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7;
        String str = this.f8362a;
        int i8 = 0;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        int i9 = (i4 ^ 1000003) * 1000003;
        String str2 = this.f8363b;
        if (str2 == null) {
            i5 = 0;
        } else {
            i5 = str2.hashCode();
        }
        int i10 = (i9 ^ i5) * 1000003;
        String str3 = this.f8364c;
        if (str3 == null) {
            i6 = 0;
        } else {
            i6 = str3.hashCode();
        }
        int i11 = (i10 ^ i6) * 1000003;
        f fVar = this.f8365d;
        if (fVar == null) {
            i7 = 0;
        } else {
            i7 = fVar.hashCode();
        }
        int i12 = (i11 ^ i7) * 1000003;
        d.b bVar = this.f8366e;
        if (bVar != null) {
            i8 = bVar.hashCode();
        }
        return i12 ^ i8;
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f8362a + ", fid=" + this.f8363b + ", refreshToken=" + this.f8364c + ", authToken=" + this.f8365d + ", responseCode=" + this.f8366e + "}";
    }

    private a(String str, String str2, String str3, f fVar, d.b bVar) {
        this.f8362a = str;
        this.f8363b = str2;
        this.f8364c = str3;
        this.f8365d = fVar;
        this.f8366e = bVar;
    }
}
