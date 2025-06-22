package p;

import java.util.List;
import p.u;

final class k extends u {

    /* renamed from: a  reason: collision with root package name */
    private final long f3846a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3847b;

    /* renamed from: c  reason: collision with root package name */
    private final o f3848c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f3849d;

    /* renamed from: e  reason: collision with root package name */
    private final String f3850e;

    /* renamed from: f  reason: collision with root package name */
    private final List f3851f;

    /* renamed from: g  reason: collision with root package name */
    private final x f3852g;

    static final class b extends u.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f3853a;

        /* renamed from: b  reason: collision with root package name */
        private Long f3854b;

        /* renamed from: c  reason: collision with root package name */
        private o f3855c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f3856d;

        /* renamed from: e  reason: collision with root package name */
        private String f3857e;

        /* renamed from: f  reason: collision with root package name */
        private List f3858f;

        /* renamed from: g  reason: collision with root package name */
        private x f3859g;

        b() {
        }

        public u a() {
            String str = "";
            if (this.f3853a == null) {
                str = str + " requestTimeMs";
            }
            if (this.f3854b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new k(this.f3853a.longValue(), this.f3854b.longValue(), this.f3855c, this.f3856d, this.f3857e, this.f3858f, this.f3859g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public u.a b(o oVar) {
            this.f3855c = oVar;
            return this;
        }

        public u.a c(List list) {
            this.f3858f = list;
            return this;
        }

        /* access modifiers changed from: package-private */
        public u.a d(Integer num) {
            this.f3856d = num;
            return this;
        }

        /* access modifiers changed from: package-private */
        public u.a e(String str) {
            this.f3857e = str;
            return this;
        }

        public u.a f(x xVar) {
            this.f3859g = xVar;
            return this;
        }

        public u.a g(long j4) {
            this.f3853a = Long.valueOf(j4);
            return this;
        }

        public u.a h(long j4) {
            this.f3854b = Long.valueOf(j4);
            return this;
        }
    }

    public o b() {
        return this.f3848c;
    }

    public List c() {
        return this.f3851f;
    }

    public Integer d() {
        return this.f3849d;
    }

    public String e() {
        return this.f3850e;
    }

    public boolean equals(Object obj) {
        o oVar;
        Integer num;
        String str;
        List list;
        x xVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f3846a != uVar.g() || this.f3847b != uVar.h() || ((oVar = this.f3848c) != null ? !oVar.equals(uVar.b()) : uVar.b() != null) || ((num = this.f3849d) != null ? !num.equals(uVar.d()) : uVar.d() != null) || ((str = this.f3850e) != null ? !str.equals(uVar.e()) : uVar.e() != null) || ((list = this.f3851f) != null ? !list.equals(uVar.c()) : uVar.c() != null) || ((xVar = this.f3852g) != null ? !xVar.equals(uVar.f()) : uVar.f() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public x f() {
        return this.f3852g;
    }

    public long g() {
        return this.f3846a;
    }

    public long h() {
        return this.f3847b;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7;
        long j4 = this.f3846a;
        long j5 = this.f3847b;
        int i8 = (((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        o oVar = this.f3848c;
        int i9 = 0;
        if (oVar == null) {
            i4 = 0;
        } else {
            i4 = oVar.hashCode();
        }
        int i10 = (i8 ^ i4) * 1000003;
        Integer num = this.f3849d;
        if (num == null) {
            i5 = 0;
        } else {
            i5 = num.hashCode();
        }
        int i11 = (i10 ^ i5) * 1000003;
        String str = this.f3850e;
        if (str == null) {
            i6 = 0;
        } else {
            i6 = str.hashCode();
        }
        int i12 = (i11 ^ i6) * 1000003;
        List list = this.f3851f;
        if (list == null) {
            i7 = 0;
        } else {
            i7 = list.hashCode();
        }
        int i13 = (i12 ^ i7) * 1000003;
        x xVar = this.f3852g;
        if (xVar != null) {
            i9 = xVar.hashCode();
        }
        return i13 ^ i9;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f3846a + ", requestUptimeMs=" + this.f3847b + ", clientInfo=" + this.f3848c + ", logSource=" + this.f3849d + ", logSourceName=" + this.f3850e + ", logEvents=" + this.f3851f + ", qosTier=" + this.f3852g + "}";
    }

    private k(long j4, long j5, o oVar, Integer num, String str, List list, x xVar) {
        this.f3846a = j4;
        this.f3847b = j5;
        this.f3848c = oVar;
        this.f3849d = num;
        this.f3850e = str;
        this.f3851f = list;
        this.f3852g = xVar;
    }
}
