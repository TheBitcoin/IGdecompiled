package B0;

import B0.F;
import java.util.List;

final class h extends F.e {

    /* renamed from: a  reason: collision with root package name */
    private final String f5983a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5984b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5985c;

    /* renamed from: d  reason: collision with root package name */
    private final long f5986d;

    /* renamed from: e  reason: collision with root package name */
    private final Long f5987e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f5988f;

    /* renamed from: g  reason: collision with root package name */
    private final F.e.a f5989g;

    /* renamed from: h  reason: collision with root package name */
    private final F.e.f f5990h;

    /* renamed from: i  reason: collision with root package name */
    private final F.e.C0076e f5991i;

    /* renamed from: j  reason: collision with root package name */
    private final F.e.c f5992j;

    /* renamed from: k  reason: collision with root package name */
    private final List f5993k;

    /* renamed from: l  reason: collision with root package name */
    private final int f5994l;

    static final class b extends F.e.b {

        /* renamed from: a  reason: collision with root package name */
        private String f5995a;

        /* renamed from: b  reason: collision with root package name */
        private String f5996b;

        /* renamed from: c  reason: collision with root package name */
        private String f5997c;

        /* renamed from: d  reason: collision with root package name */
        private long f5998d;

        /* renamed from: e  reason: collision with root package name */
        private Long f5999e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f6000f;

        /* renamed from: g  reason: collision with root package name */
        private F.e.a f6001g;

        /* renamed from: h  reason: collision with root package name */
        private F.e.f f6002h;

        /* renamed from: i  reason: collision with root package name */
        private F.e.C0076e f6003i;

        /* renamed from: j  reason: collision with root package name */
        private F.e.c f6004j;

        /* renamed from: k  reason: collision with root package name */
        private List f6005k;

        /* renamed from: l  reason: collision with root package name */
        private int f6006l;

        /* renamed from: m  reason: collision with root package name */
        private byte f6007m;

        public F.e a() {
            String str;
            String str2;
            F.e.a aVar;
            if (this.f6007m == 7 && (str = this.f5995a) != null && (str2 = this.f5996b) != null && (aVar = this.f6001g) != null) {
                return new h(str, str2, this.f5997c, this.f5998d, this.f5999e, this.f6000f, aVar, this.f6002h, this.f6003i, this.f6004j, this.f6005k, this.f6006l);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f5995a == null) {
                sb.append(" generator");
            }
            if (this.f5996b == null) {
                sb.append(" identifier");
            }
            if ((this.f6007m & 1) == 0) {
                sb.append(" startedAt");
            }
            if ((this.f6007m & 2) == 0) {
                sb.append(" crashed");
            }
            if (this.f6001g == null) {
                sb.append(" app");
            }
            if ((this.f6007m & 4) == 0) {
                sb.append(" generatorType");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.b b(F.e.a aVar) {
            if (aVar != null) {
                this.f6001g = aVar;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public F.e.b c(String str) {
            this.f5997c = str;
            return this;
        }

        public F.e.b d(boolean z4) {
            this.f6000f = z4;
            this.f6007m = (byte) (this.f6007m | 2);
            return this;
        }

        public F.e.b e(F.e.c cVar) {
            this.f6004j = cVar;
            return this;
        }

        public F.e.b f(Long l4) {
            this.f5999e = l4;
            return this;
        }

        public F.e.b g(List list) {
            this.f6005k = list;
            return this;
        }

        public F.e.b h(String str) {
            if (str != null) {
                this.f5995a = str;
                return this;
            }
            throw new NullPointerException("Null generator");
        }

        public F.e.b i(int i4) {
            this.f6006l = i4;
            this.f6007m = (byte) (this.f6007m | 4);
            return this;
        }

        public F.e.b j(String str) {
            if (str != null) {
                this.f5996b = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public F.e.b l(F.e.C0076e eVar) {
            this.f6003i = eVar;
            return this;
        }

        public F.e.b m(long j4) {
            this.f5998d = j4;
            this.f6007m = (byte) (this.f6007m | 1);
            return this;
        }

        public F.e.b n(F.e.f fVar) {
            this.f6002h = fVar;
            return this;
        }

        b() {
        }

        private b(F.e eVar) {
            this.f5995a = eVar.g();
            this.f5996b = eVar.i();
            this.f5997c = eVar.c();
            this.f5998d = eVar.l();
            this.f5999e = eVar.e();
            this.f6000f = eVar.n();
            this.f6001g = eVar.b();
            this.f6002h = eVar.m();
            this.f6003i = eVar.k();
            this.f6004j = eVar.d();
            this.f6005k = eVar.f();
            this.f6006l = eVar.h();
            this.f6007m = 7;
        }
    }

    public F.e.a b() {
        return this.f5989g;
    }

    public String c() {
        return this.f5985c;
    }

    public F.e.c d() {
        return this.f5992j;
    }

    public Long e() {
        return this.f5987e;
    }

    public boolean equals(Object obj) {
        String str;
        Long l4;
        F.e.f fVar;
        F.e.C0076e eVar;
        F.e.c cVar;
        List list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e) {
            F.e eVar2 = (F.e) obj;
            if (!this.f5983a.equals(eVar2.g()) || !this.f5984b.equals(eVar2.i()) || ((str = this.f5985c) != null ? !str.equals(eVar2.c()) : eVar2.c() != null) || this.f5986d != eVar2.l() || ((l4 = this.f5987e) != null ? !l4.equals(eVar2.e()) : eVar2.e() != null) || this.f5988f != eVar2.n() || !this.f5989g.equals(eVar2.b()) || ((fVar = this.f5990h) != null ? !fVar.equals(eVar2.m()) : eVar2.m() != null) || ((eVar = this.f5991i) != null ? !eVar.equals(eVar2.k()) : eVar2.k() != null) || ((cVar = this.f5992j) != null ? !cVar.equals(eVar2.d()) : eVar2.d() != null) || ((list = this.f5993k) != null ? !list.equals(eVar2.f()) : eVar2.f() != null) || this.f5994l != eVar2.h()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public List f() {
        return this.f5993k;
    }

    public String g() {
        return this.f5983a;
    }

    public int h() {
        return this.f5994l;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int hashCode = (((this.f5983a.hashCode() ^ 1000003) * 1000003) ^ this.f5984b.hashCode()) * 1000003;
        String str = this.f5985c;
        int i10 = 0;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        long j4 = this.f5986d;
        int i11 = (((hashCode ^ i4) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        Long l4 = this.f5987e;
        if (l4 == null) {
            i5 = 0;
        } else {
            i5 = l4.hashCode();
        }
        int i12 = (i11 ^ i5) * 1000003;
        if (this.f5988f) {
            i6 = 1231;
        } else {
            i6 = 1237;
        }
        int hashCode2 = (((i12 ^ i6) * 1000003) ^ this.f5989g.hashCode()) * 1000003;
        F.e.f fVar = this.f5990h;
        if (fVar == null) {
            i7 = 0;
        } else {
            i7 = fVar.hashCode();
        }
        int i13 = (hashCode2 ^ i7) * 1000003;
        F.e.C0076e eVar = this.f5991i;
        if (eVar == null) {
            i8 = 0;
        } else {
            i8 = eVar.hashCode();
        }
        int i14 = (i13 ^ i8) * 1000003;
        F.e.c cVar = this.f5992j;
        if (cVar == null) {
            i9 = 0;
        } else {
            i9 = cVar.hashCode();
        }
        int i15 = (i14 ^ i9) * 1000003;
        List list = this.f5993k;
        if (list != null) {
            i10 = list.hashCode();
        }
        return ((i15 ^ i10) * 1000003) ^ this.f5994l;
    }

    public String i() {
        return this.f5984b;
    }

    public F.e.C0076e k() {
        return this.f5991i;
    }

    public long l() {
        return this.f5986d;
    }

    public F.e.f m() {
        return this.f5990h;
    }

    public boolean n() {
        return this.f5988f;
    }

    public F.e.b o() {
        return new b(this);
    }

    public String toString() {
        return "Session{generator=" + this.f5983a + ", identifier=" + this.f5984b + ", appQualitySessionId=" + this.f5985c + ", startedAt=" + this.f5986d + ", endedAt=" + this.f5987e + ", crashed=" + this.f5988f + ", app=" + this.f5989g + ", user=" + this.f5990h + ", os=" + this.f5991i + ", device=" + this.f5992j + ", events=" + this.f5993k + ", generatorType=" + this.f5994l + "}";
    }

    private h(String str, String str2, String str3, long j4, Long l4, boolean z4, F.e.a aVar, F.e.f fVar, F.e.C0076e eVar, F.e.c cVar, List list, int i4) {
        this.f5983a = str;
        this.f5984b = str2;
        this.f5985c = str3;
        this.f5986d = j4;
        this.f5987e = l4;
        this.f5988f = z4;
        this.f5989g = aVar;
        this.f5990h = fVar;
        this.f5991i = eVar;
        this.f5992j = cVar;
        this.f5993k = list;
        this.f5994l = i4;
    }
}
