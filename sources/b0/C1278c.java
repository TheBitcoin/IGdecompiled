package B0;

import B0.F;
import java.util.List;

/* renamed from: B0.c  reason: case insensitive filesystem */
final class C1278c extends F.a {

    /* renamed from: a  reason: collision with root package name */
    private final int f5946a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5947b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5948c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5949d;

    /* renamed from: e  reason: collision with root package name */
    private final long f5950e;

    /* renamed from: f  reason: collision with root package name */
    private final long f5951f;

    /* renamed from: g  reason: collision with root package name */
    private final long f5952g;

    /* renamed from: h  reason: collision with root package name */
    private final String f5953h;

    /* renamed from: i  reason: collision with root package name */
    private final List f5954i;

    /* renamed from: B0.c$b */
    static final class b extends F.a.b {

        /* renamed from: a  reason: collision with root package name */
        private int f5955a;

        /* renamed from: b  reason: collision with root package name */
        private String f5956b;

        /* renamed from: c  reason: collision with root package name */
        private int f5957c;

        /* renamed from: d  reason: collision with root package name */
        private int f5958d;

        /* renamed from: e  reason: collision with root package name */
        private long f5959e;

        /* renamed from: f  reason: collision with root package name */
        private long f5960f;

        /* renamed from: g  reason: collision with root package name */
        private long f5961g;

        /* renamed from: h  reason: collision with root package name */
        private String f5962h;

        /* renamed from: i  reason: collision with root package name */
        private List f5963i;

        /* renamed from: j  reason: collision with root package name */
        private byte f5964j;

        b() {
        }

        public F.a a() {
            String str;
            if (this.f5964j == 63 && (str = this.f5956b) != null) {
                return new C1278c(this.f5955a, str, this.f5957c, this.f5958d, this.f5959e, this.f5960f, this.f5961g, this.f5962h, this.f5963i);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f5964j & 1) == 0) {
                sb.append(" pid");
            }
            if (this.f5956b == null) {
                sb.append(" processName");
            }
            if ((this.f5964j & 2) == 0) {
                sb.append(" reasonCode");
            }
            if ((this.f5964j & 4) == 0) {
                sb.append(" importance");
            }
            if ((this.f5964j & 8) == 0) {
                sb.append(" pss");
            }
            if ((this.f5964j & 16) == 0) {
                sb.append(" rss");
            }
            if ((this.f5964j & 32) == 0) {
                sb.append(" timestamp");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.a.b b(List list) {
            this.f5963i = list;
            return this;
        }

        public F.a.b c(int i4) {
            this.f5958d = i4;
            this.f5964j = (byte) (this.f5964j | 4);
            return this;
        }

        public F.a.b d(int i4) {
            this.f5955a = i4;
            this.f5964j = (byte) (this.f5964j | 1);
            return this;
        }

        public F.a.b e(String str) {
            if (str != null) {
                this.f5956b = str;
                return this;
            }
            throw new NullPointerException("Null processName");
        }

        public F.a.b f(long j4) {
            this.f5959e = j4;
            this.f5964j = (byte) (this.f5964j | 8);
            return this;
        }

        public F.a.b g(int i4) {
            this.f5957c = i4;
            this.f5964j = (byte) (this.f5964j | 2);
            return this;
        }

        public F.a.b h(long j4) {
            this.f5960f = j4;
            this.f5964j = (byte) (this.f5964j | 16);
            return this;
        }

        public F.a.b i(long j4) {
            this.f5961g = j4;
            this.f5964j = (byte) (this.f5964j | 32);
            return this;
        }

        public F.a.b j(String str) {
            this.f5962h = str;
            return this;
        }
    }

    public List b() {
        return this.f5954i;
    }

    public int c() {
        return this.f5949d;
    }

    public int d() {
        return this.f5946a;
    }

    public String e() {
        return this.f5947b;
    }

    public boolean equals(Object obj) {
        String str;
        List list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.a) {
            F.a aVar = (F.a) obj;
            if (this.f5946a == aVar.d() && this.f5947b.equals(aVar.e()) && this.f5948c == aVar.g() && this.f5949d == aVar.c() && this.f5950e == aVar.f() && this.f5951f == aVar.h() && this.f5952g == aVar.i() && ((str = this.f5953h) != null ? str.equals(aVar.j()) : aVar.j() == null) && ((list = this.f5954i) != null ? list.equals(aVar.b()) : aVar.b() == null)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public long f() {
        return this.f5950e;
    }

    public int g() {
        return this.f5948c;
    }

    public long h() {
        return this.f5951f;
    }

    public int hashCode() {
        int i4;
        long j4 = this.f5950e;
        long j5 = this.f5951f;
        long j6 = this.f5952g;
        int hashCode = (((((((((((((this.f5946a ^ 1000003) * 1000003) ^ this.f5947b.hashCode()) * 1000003) ^ this.f5948c) * 1000003) ^ this.f5949d) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        String str = this.f5953h;
        int i5 = 0;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        int i6 = (hashCode ^ i4) * 1000003;
        List list = this.f5954i;
        if (list != null) {
            i5 = list.hashCode();
        }
        return i6 ^ i5;
    }

    public long i() {
        return this.f5952g;
    }

    public String j() {
        return this.f5953h;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.f5946a + ", processName=" + this.f5947b + ", reasonCode=" + this.f5948c + ", importance=" + this.f5949d + ", pss=" + this.f5950e + ", rss=" + this.f5951f + ", timestamp=" + this.f5952g + ", traceFile=" + this.f5953h + ", buildIdMappingForArch=" + this.f5954i + "}";
    }

    private C1278c(int i4, String str, int i5, int i6, long j4, long j5, long j6, String str2, List list) {
        this.f5946a = i4;
        this.f5947b = str;
        this.f5948c = i5;
        this.f5949d = i6;
        this.f5950e = j4;
        this.f5951f = j5;
        this.f5952g = j6;
        this.f5953h = str2;
        this.f5954i = list;
    }
}
