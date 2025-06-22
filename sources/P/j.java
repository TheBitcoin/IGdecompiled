package p;

import java.util.Arrays;
import p.t;

final class j extends t {

    /* renamed from: a  reason: collision with root package name */
    private final long f3828a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f3829b;

    /* renamed from: c  reason: collision with root package name */
    private final p f3830c;

    /* renamed from: d  reason: collision with root package name */
    private final long f3831d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f3832e;

    /* renamed from: f  reason: collision with root package name */
    private final String f3833f;

    /* renamed from: g  reason: collision with root package name */
    private final long f3834g;

    /* renamed from: h  reason: collision with root package name */
    private final w f3835h;

    /* renamed from: i  reason: collision with root package name */
    private final q f3836i;

    static final class b extends t.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f3837a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f3838b;

        /* renamed from: c  reason: collision with root package name */
        private p f3839c;

        /* renamed from: d  reason: collision with root package name */
        private Long f3840d;

        /* renamed from: e  reason: collision with root package name */
        private byte[] f3841e;

        /* renamed from: f  reason: collision with root package name */
        private String f3842f;

        /* renamed from: g  reason: collision with root package name */
        private Long f3843g;

        /* renamed from: h  reason: collision with root package name */
        private w f3844h;

        /* renamed from: i  reason: collision with root package name */
        private q f3845i;

        b() {
        }

        public t a() {
            String str = "";
            if (this.f3837a == null) {
                str = str + " eventTimeMs";
            }
            if (this.f3840d == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f3843g == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new j(this.f3837a.longValue(), this.f3838b, this.f3839c, this.f3840d.longValue(), this.f3841e, this.f3842f, this.f3843g.longValue(), this.f3844h, this.f3845i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public t.a b(p pVar) {
            this.f3839c = pVar;
            return this;
        }

        public t.a c(Integer num) {
            this.f3838b = num;
            return this;
        }

        public t.a d(long j4) {
            this.f3837a = Long.valueOf(j4);
            return this;
        }

        public t.a e(long j4) {
            this.f3840d = Long.valueOf(j4);
            return this;
        }

        public t.a f(q qVar) {
            this.f3845i = qVar;
            return this;
        }

        public t.a g(w wVar) {
            this.f3844h = wVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        public t.a h(byte[] bArr) {
            this.f3841e = bArr;
            return this;
        }

        /* access modifiers changed from: package-private */
        public t.a i(String str) {
            this.f3842f = str;
            return this;
        }

        public t.a j(long j4) {
            this.f3843g = Long.valueOf(j4);
            return this;
        }
    }

    public p b() {
        return this.f3830c;
    }

    public Integer c() {
        return this.f3829b;
    }

    public long d() {
        return this.f3828a;
    }

    public long e() {
        return this.f3831d;
    }

    public boolean equals(Object obj) {
        Integer num;
        p pVar;
        byte[] bArr;
        String str;
        w wVar;
        q qVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (this.f3828a == tVar.d() && ((num = this.f3829b) != null ? num.equals(tVar.c()) : tVar.c() == null) && ((pVar = this.f3830c) != null ? pVar.equals(tVar.b()) : tVar.b() == null) && this.f3831d == tVar.e()) {
                byte[] bArr2 = this.f3832e;
                if (tVar instanceof j) {
                    bArr = ((j) tVar).f3832e;
                } else {
                    bArr = tVar.h();
                }
                if (!Arrays.equals(bArr2, bArr) || ((str = this.f3833f) != null ? !str.equals(tVar.i()) : tVar.i() != null) || this.f3834g != tVar.j() || ((wVar = this.f3835h) != null ? !wVar.equals(tVar.g()) : tVar.g() != null) || ((qVar = this.f3836i) != null ? !qVar.equals(tVar.f()) : tVar.f() != null)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public q f() {
        return this.f3836i;
    }

    public w g() {
        return this.f3835h;
    }

    public byte[] h() {
        return this.f3832e;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7;
        long j4 = this.f3828a;
        int i8 = (((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f3829b;
        int i9 = 0;
        if (num == null) {
            i4 = 0;
        } else {
            i4 = num.hashCode();
        }
        int i10 = (i8 ^ i4) * 1000003;
        p pVar = this.f3830c;
        if (pVar == null) {
            i5 = 0;
        } else {
            i5 = pVar.hashCode();
        }
        long j5 = this.f3831d;
        int hashCode = (((((i10 ^ i5) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f3832e)) * 1000003;
        String str = this.f3833f;
        if (str == null) {
            i6 = 0;
        } else {
            i6 = str.hashCode();
        }
        long j6 = this.f3834g;
        int i11 = (((hashCode ^ i6) * 1000003) ^ ((int) ((j6 >>> 32) ^ j6))) * 1000003;
        w wVar = this.f3835h;
        if (wVar == null) {
            i7 = 0;
        } else {
            i7 = wVar.hashCode();
        }
        int i12 = (i11 ^ i7) * 1000003;
        q qVar = this.f3836i;
        if (qVar != null) {
            i9 = qVar.hashCode();
        }
        return i12 ^ i9;
    }

    public String i() {
        return this.f3833f;
    }

    public long j() {
        return this.f3834g;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f3828a + ", eventCode=" + this.f3829b + ", complianceData=" + this.f3830c + ", eventUptimeMs=" + this.f3831d + ", sourceExtension=" + Arrays.toString(this.f3832e) + ", sourceExtensionJsonProto3=" + this.f3833f + ", timezoneOffsetSeconds=" + this.f3834g + ", networkConnectionInfo=" + this.f3835h + ", experimentIds=" + this.f3836i + "}";
    }

    private j(long j4, Integer num, p pVar, long j5, byte[] bArr, String str, long j6, w wVar, q qVar) {
        this.f3828a = j4;
        this.f3829b = num;
        this.f3830c = pVar;
        this.f3831d = j5;
        this.f3832e = bArr;
        this.f3833f = str;
        this.f3834g = j6;
        this.f3835h = wVar;
        this.f3836i = qVar;
    }
}
