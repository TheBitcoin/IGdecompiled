package T0;

import T0.c;
import T0.d;

final class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private final String f8254b;

    /* renamed from: c  reason: collision with root package name */
    private final c.a f8255c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8256d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8257e;

    /* renamed from: f  reason: collision with root package name */
    private final long f8258f;

    /* renamed from: g  reason: collision with root package name */
    private final long f8259g;

    /* renamed from: h  reason: collision with root package name */
    private final String f8260h;

    static final class b extends d.a {

        /* renamed from: a  reason: collision with root package name */
        private String f8261a;

        /* renamed from: b  reason: collision with root package name */
        private c.a f8262b;

        /* renamed from: c  reason: collision with root package name */
        private String f8263c;

        /* renamed from: d  reason: collision with root package name */
        private String f8264d;

        /* renamed from: e  reason: collision with root package name */
        private Long f8265e;

        /* renamed from: f  reason: collision with root package name */
        private Long f8266f;

        /* renamed from: g  reason: collision with root package name */
        private String f8267g;

        public d a() {
            String str = "";
            if (this.f8262b == null) {
                str = str + " registrationStatus";
            }
            if (this.f8265e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f8266f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.f8261a, this.f8262b, this.f8263c, this.f8264d, this.f8265e.longValue(), this.f8266f.longValue(), this.f8267g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public d.a b(String str) {
            this.f8263c = str;
            return this;
        }

        public d.a c(long j4) {
            this.f8265e = Long.valueOf(j4);
            return this;
        }

        public d.a d(String str) {
            this.f8261a = str;
            return this;
        }

        public d.a e(String str) {
            this.f8267g = str;
            return this;
        }

        public d.a f(String str) {
            this.f8264d = str;
            return this;
        }

        public d.a g(c.a aVar) {
            if (aVar != null) {
                this.f8262b = aVar;
                return this;
            }
            throw new NullPointerException("Null registrationStatus");
        }

        public d.a h(long j4) {
            this.f8266f = Long.valueOf(j4);
            return this;
        }

        b() {
        }

        private b(d dVar) {
            this.f8261a = dVar.d();
            this.f8262b = dVar.g();
            this.f8263c = dVar.b();
            this.f8264d = dVar.f();
            this.f8265e = Long.valueOf(dVar.c());
            this.f8266f = Long.valueOf(dVar.h());
            this.f8267g = dVar.e();
        }
    }

    public String b() {
        return this.f8256d;
    }

    public long c() {
        return this.f8258f;
    }

    public String d() {
        return this.f8254b;
    }

    public String e() {
        return this.f8260h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str4 = this.f8254b;
            if (str4 != null ? str4.equals(dVar.d()) : dVar.d() == null) {
                if (!this.f8255c.equals(dVar.g()) || ((str = this.f8256d) != null ? !str.equals(dVar.b()) : dVar.b() != null) || ((str2 = this.f8257e) != null ? !str2.equals(dVar.f()) : dVar.f() != null) || this.f8258f != dVar.c() || this.f8259g != dVar.h() || ((str3 = this.f8260h) != null ? !str3.equals(dVar.e()) : dVar.e() != null)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.f8257e;
    }

    public c.a g() {
        return this.f8255c;
    }

    public long h() {
        return this.f8259g;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        String str = this.f8254b;
        int i7 = 0;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        int hashCode = (((i4 ^ 1000003) * 1000003) ^ this.f8255c.hashCode()) * 1000003;
        String str2 = this.f8256d;
        if (str2 == null) {
            i5 = 0;
        } else {
            i5 = str2.hashCode();
        }
        int i8 = (hashCode ^ i5) * 1000003;
        String str3 = this.f8257e;
        if (str3 == null) {
            i6 = 0;
        } else {
            i6 = str3.hashCode();
        }
        long j4 = this.f8258f;
        long j5 = this.f8259g;
        int i9 = (((((i8 ^ i6) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        String str4 = this.f8260h;
        if (str4 != null) {
            i7 = str4.hashCode();
        }
        return i9 ^ i7;
    }

    public d.a n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f8254b + ", registrationStatus=" + this.f8255c + ", authToken=" + this.f8256d + ", refreshToken=" + this.f8257e + ", expiresInSecs=" + this.f8258f + ", tokenCreationEpochInSecs=" + this.f8259g + ", fisError=" + this.f8260h + "}";
    }

    private a(String str, c.a aVar, String str2, String str3, long j4, long j5, String str4) {
        this.f8254b = str;
        this.f8255c = aVar;
        this.f8256d = str2;
        this.f8257e = str3;
        this.f8258f = j4;
        this.f8259g = j5;
        this.f8260h = str4;
    }
}
