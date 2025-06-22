package X0;

public final class a {

    /* renamed from: p  reason: collision with root package name */
    private static final a f8758p = new C0125a().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f8759a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8760b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8761c;

    /* renamed from: d  reason: collision with root package name */
    private final c f8762d;

    /* renamed from: e  reason: collision with root package name */
    private final d f8763e;

    /* renamed from: f  reason: collision with root package name */
    private final String f8764f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8765g;

    /* renamed from: h  reason: collision with root package name */
    private final int f8766h;

    /* renamed from: i  reason: collision with root package name */
    private final int f8767i;

    /* renamed from: j  reason: collision with root package name */
    private final String f8768j;

    /* renamed from: k  reason: collision with root package name */
    private final long f8769k;

    /* renamed from: l  reason: collision with root package name */
    private final b f8770l;

    /* renamed from: m  reason: collision with root package name */
    private final String f8771m;

    /* renamed from: n  reason: collision with root package name */
    private final long f8772n;

    /* renamed from: o  reason: collision with root package name */
    private final String f8773o;

    /* renamed from: X0.a$a  reason: collision with other inner class name */
    public static final class C0125a {

        /* renamed from: a  reason: collision with root package name */
        private long f8774a = 0;

        /* renamed from: b  reason: collision with root package name */
        private String f8775b = "";

        /* renamed from: c  reason: collision with root package name */
        private String f8776c = "";

        /* renamed from: d  reason: collision with root package name */
        private c f8777d = c.UNKNOWN;

        /* renamed from: e  reason: collision with root package name */
        private d f8778e = d.UNKNOWN_OS;

        /* renamed from: f  reason: collision with root package name */
        private String f8779f = "";

        /* renamed from: g  reason: collision with root package name */
        private String f8780g = "";

        /* renamed from: h  reason: collision with root package name */
        private int f8781h = 0;

        /* renamed from: i  reason: collision with root package name */
        private int f8782i = 0;

        /* renamed from: j  reason: collision with root package name */
        private String f8783j = "";

        /* renamed from: k  reason: collision with root package name */
        private long f8784k = 0;

        /* renamed from: l  reason: collision with root package name */
        private b f8785l = b.UNKNOWN_EVENT;

        /* renamed from: m  reason: collision with root package name */
        private String f8786m = "";

        /* renamed from: n  reason: collision with root package name */
        private long f8787n = 0;

        /* renamed from: o  reason: collision with root package name */
        private String f8788o = "";

        C0125a() {
        }

        public a a() {
            long j4 = this.f8774a;
            String str = this.f8775b;
            String str2 = this.f8776c;
            c cVar = this.f8777d;
            d dVar = this.f8778e;
            String str3 = this.f8779f;
            String str4 = this.f8780g;
            int i4 = this.f8781h;
            int i5 = this.f8782i;
            String str5 = this.f8783j;
            long j5 = this.f8784k;
            b bVar = this.f8785l;
            String str6 = this.f8786m;
            return new a(j4, str, str2, cVar, dVar, str3, str4, i4, i5, str5, j5, bVar, str6, this.f8787n, this.f8788o);
        }

        public C0125a b(String str) {
            this.f8786m = str;
            return this;
        }

        public C0125a c(String str) {
            this.f8780g = str;
            return this;
        }

        public C0125a d(String str) {
            this.f8788o = str;
            return this;
        }

        public C0125a e(b bVar) {
            this.f8785l = bVar;
            return this;
        }

        public C0125a f(String str) {
            this.f8776c = str;
            return this;
        }

        public C0125a g(String str) {
            this.f8775b = str;
            return this;
        }

        public C0125a h(c cVar) {
            this.f8777d = cVar;
            return this;
        }

        public C0125a i(String str) {
            this.f8779f = str;
            return this;
        }

        public C0125a j(int i4) {
            this.f8781h = i4;
            return this;
        }

        public C0125a k(long j4) {
            this.f8774a = j4;
            return this;
        }

        public C0125a l(d dVar) {
            this.f8778e = dVar;
            return this;
        }

        public C0125a m(String str) {
            this.f8783j = str;
            return this;
        }

        public C0125a n(int i4) {
            this.f8782i = i4;
            return this;
        }
    }

    public enum b implements N0.c {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f8793a;

        private b(int i4) {
            this.f8793a = i4;
        }

        public int getNumber() {
            return this.f8793a;
        }
    }

    public enum c implements N0.c {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f8799a;

        private c(int i4) {
            this.f8799a = i4;
        }

        public int getNumber() {
            return this.f8799a;
        }
    }

    public enum d implements N0.c {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f8805a;

        private d(int i4) {
            this.f8805a = i4;
        }

        public int getNumber() {
            return this.f8805a;
        }
    }

    a(long j4, String str, String str2, c cVar, d dVar, String str3, String str4, int i4, int i5, String str5, long j5, b bVar, String str6, long j6, String str7) {
        this.f8759a = j4;
        this.f8760b = str;
        this.f8761c = str2;
        this.f8762d = cVar;
        this.f8763e = dVar;
        this.f8764f = str3;
        this.f8765g = str4;
        this.f8766h = i4;
        this.f8767i = i5;
        this.f8768j = str5;
        this.f8769k = j5;
        this.f8770l = bVar;
        this.f8771m = str6;
        this.f8772n = j6;
        this.f8773o = str7;
    }

    public static C0125a p() {
        return new C0125a();
    }

    public String a() {
        return this.f8771m;
    }

    public long b() {
        return this.f8769k;
    }

    public long c() {
        return this.f8772n;
    }

    public String d() {
        return this.f8765g;
    }

    public String e() {
        return this.f8773o;
    }

    public b f() {
        return this.f8770l;
    }

    public String g() {
        return this.f8761c;
    }

    public String h() {
        return this.f8760b;
    }

    public c i() {
        return this.f8762d;
    }

    public String j() {
        return this.f8764f;
    }

    public int k() {
        return this.f8766h;
    }

    public long l() {
        return this.f8759a;
    }

    public d m() {
        return this.f8763e;
    }

    public String n() {
        return this.f8768j;
    }

    public int o() {
        return this.f8767i;
    }
}
