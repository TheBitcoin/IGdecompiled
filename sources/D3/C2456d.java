package D3;

import java.util.concurrent.TimeUnit;

/* renamed from: D3.d  reason: case insensitive filesystem */
public final class C2456d {

    /* renamed from: n  reason: collision with root package name */
    public static final C2456d f22916n = new a().c().a();

    /* renamed from: o  reason: collision with root package name */
    public static final C2456d f22917o = new a().e().b(Integer.MAX_VALUE, TimeUnit.SECONDS).a();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f22918a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22919b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22920c;

    /* renamed from: d  reason: collision with root package name */
    private final int f22921d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f22922e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f22923f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f22924g;

    /* renamed from: h  reason: collision with root package name */
    private final int f22925h;

    /* renamed from: i  reason: collision with root package name */
    private final int f22926i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f22927j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f22928k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f22929l;

    /* renamed from: m  reason: collision with root package name */
    String f22930m;

    /* renamed from: D3.d$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f22931a;

        /* renamed from: b  reason: collision with root package name */
        boolean f22932b;

        /* renamed from: c  reason: collision with root package name */
        int f22933c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f22934d = -1;

        /* renamed from: e  reason: collision with root package name */
        int f22935e = -1;

        /* renamed from: f  reason: collision with root package name */
        boolean f22936f;

        /* renamed from: g  reason: collision with root package name */
        boolean f22937g;

        /* renamed from: h  reason: collision with root package name */
        boolean f22938h;

        public C2456d a() {
            return new C2456d(this);
        }

        public a b(int i4, TimeUnit timeUnit) {
            int i5;
            if (i4 >= 0) {
                long seconds = timeUnit.toSeconds((long) i4);
                if (seconds > 2147483647L) {
                    i5 = Integer.MAX_VALUE;
                } else {
                    i5 = (int) seconds;
                }
                this.f22934d = i5;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i4);
        }

        public a c() {
            this.f22931a = true;
            return this;
        }

        public a d() {
            this.f22932b = true;
            return this;
        }

        public a e() {
            this.f22936f = true;
            return this;
        }
    }

    private C2456d(boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, int i6, int i7, boolean z9, boolean z10, boolean z11, String str) {
        this.f22918a = z4;
        this.f22919b = z5;
        this.f22920c = i4;
        this.f22921d = i5;
        this.f22922e = z6;
        this.f22923f = z7;
        this.f22924g = z8;
        this.f22925h = i6;
        this.f22926i = i7;
        this.f22927j = z9;
        this.f22928k = z10;
        this.f22929l = z11;
        this.f22930m = str;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f22918a) {
            sb.append("no-cache, ");
        }
        if (this.f22919b) {
            sb.append("no-store, ");
        }
        if (this.f22920c != -1) {
            sb.append("max-age=");
            sb.append(this.f22920c);
            sb.append(", ");
        }
        if (this.f22921d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f22921d);
            sb.append(", ");
        }
        if (this.f22922e) {
            sb.append("private, ");
        }
        if (this.f22923f) {
            sb.append("public, ");
        }
        if (this.f22924g) {
            sb.append("must-revalidate, ");
        }
        if (this.f22925h != -1) {
            sb.append("max-stale=");
            sb.append(this.f22925h);
            sb.append(", ");
        }
        if (this.f22926i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f22926i);
            sb.append(", ");
        }
        if (this.f22927j) {
            sb.append("only-if-cached, ");
        }
        if (this.f22928k) {
            sb.append("no-transform, ");
        }
        if (this.f22929l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static D3.C2456d l(D3.C2469q r23) {
        /*
            r0 = r23
            int r1 = r0.e()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x001a:
            if (r6 >= r1) goto L_0x0148
            java.lang.String r2 = r0.c(r6)
            r22 = 1
            java.lang.String r4 = r0.f(r6)
            java.lang.String r5 = "Cache-Control"
            boolean r5 = r2.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0034
            if (r8 == 0) goto L_0x0032
        L_0x0030:
            r7 = 0
            goto L_0x003d
        L_0x0032:
            r8 = r4
            goto L_0x003d
        L_0x0034:
            java.lang.String r5 = "Pragma"
            boolean r2 = r2.equalsIgnoreCase(r5)
            if (r2 == 0) goto L_0x0141
            goto L_0x0030
        L_0x003d:
            r2 = 0
        L_0x003e:
            int r5 = r4.length()
            if (r2 >= r5) goto L_0x0141
            java.lang.String r5 = "=,;"
            int r5 = H3.e.h(r4, r2, r5)
            java.lang.String r2 = r4.substring(r2, r5)
            java.lang.String r2 = r2.trim()
            int r3 = r4.length()
            if (r5 == r3) goto L_0x009b
            char r3 = r4.charAt(r5)
            r0 = 44
            if (r3 == r0) goto L_0x009b
            char r0 = r4.charAt(r5)
            r3 = 59
            if (r0 != r3) goto L_0x0069
            goto L_0x009b
        L_0x0069:
            int r5 = r5 + 1
            int r0 = H3.e.i(r4, r5)
            int r3 = r4.length()
            if (r0 >= r3) goto L_0x008c
            char r3 = r4.charAt(r0)
            r5 = 34
            if (r3 != r5) goto L_0x008c
            int r0 = r0 + 1
            java.lang.String r3 = "\""
            int r3 = H3.e.h(r4, r0, r3)
            java.lang.String r0 = r4.substring(r0, r3)
            int r3 = r3 + 1
            goto L_0x009f
        L_0x008c:
            java.lang.String r3 = ",;"
            int r3 = H3.e.h(r4, r0, r3)
            java.lang.String r0 = r4.substring(r0, r3)
            java.lang.String r0 = r0.trim()
            goto L_0x009f
        L_0x009b:
            int r5 = r5 + 1
            r3 = r5
            r0 = 0
        L_0x009f:
            java.lang.String r5 = "no-cache"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00ab
            r5 = -1
            r9 = 1
            goto L_0x013c
        L_0x00ab:
            java.lang.String r5 = "no-store"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00b7
            r5 = -1
            r10 = 1
            goto L_0x013c
        L_0x00b7:
            java.lang.String r5 = "max-age"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00c7
            r5 = -1
            int r0 = H3.e.f(r0, r5)
            r11 = r0
            goto L_0x013c
        L_0x00c7:
            java.lang.String r5 = "s-maxage"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00d7
            r5 = -1
            int r0 = H3.e.f(r0, r5)
            r12 = r0
            goto L_0x013c
        L_0x00d7:
            java.lang.String r5 = "private"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00e2
            r5 = -1
            r13 = 1
            goto L_0x013c
        L_0x00e2:
            java.lang.String r5 = "public"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00ed
            r5 = -1
            r14 = 1
            goto L_0x013c
        L_0x00ed:
            java.lang.String r5 = "must-revalidate"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00f8
            r5 = -1
            r15 = 1
            goto L_0x013c
        L_0x00f8:
            java.lang.String r5 = "max-stale"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x010b
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r0 = H3.e.f(r0, r2)
            r16 = r0
            r5 = -1
            goto L_0x013c
        L_0x010b:
            java.lang.String r5 = "min-fresh"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x011b
            r5 = -1
            int r0 = H3.e.f(r0, r5)
            r17 = r0
            goto L_0x013c
        L_0x011b:
            r5 = -1
            java.lang.String r0 = "only-if-cached"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0127
            r18 = 1
            goto L_0x013c
        L_0x0127:
            java.lang.String r0 = "no-transform"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0132
            r19 = 1
            goto L_0x013c
        L_0x0132:
            java.lang.String r0 = "immutable"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x013c
            r20 = 1
        L_0x013c:
            r0 = r23
            r2 = r3
            goto L_0x003e
        L_0x0141:
            r5 = -1
            int r6 = r6 + 1
            r0 = r23
            goto L_0x001a
        L_0x0148:
            if (r7 != 0) goto L_0x014d
            r21 = 0
            goto L_0x014f
        L_0x014d:
            r21 = r8
        L_0x014f:
            D3.d r8 = new D3.d
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: D3.C2456d.l(D3.q):D3.d");
    }

    public boolean b() {
        return this.f22929l;
    }

    public boolean c() {
        return this.f22922e;
    }

    public boolean d() {
        return this.f22923f;
    }

    public int e() {
        return this.f22920c;
    }

    public int f() {
        return this.f22925h;
    }

    public int g() {
        return this.f22926i;
    }

    public boolean h() {
        return this.f22924g;
    }

    public boolean i() {
        return this.f22918a;
    }

    public boolean j() {
        return this.f22919b;
    }

    public boolean k() {
        return this.f22927j;
    }

    public String toString() {
        String str = this.f22930m;
        if (str != null) {
            return str;
        }
        String a5 = a();
        this.f22930m = a5;
        return a5;
    }

    C2456d(a aVar) {
        this.f22918a = aVar.f22931a;
        this.f22919b = aVar.f22932b;
        this.f22920c = aVar.f22933c;
        this.f22921d = -1;
        this.f22922e = false;
        this.f22923f = false;
        this.f22924g = false;
        this.f22925h = aVar.f22934d;
        this.f22926i = aVar.f22935e;
        this.f22927j = aVar.f22936f;
        this.f22928k = aVar.f22937g;
        this.f22929l = aVar.f22938h;
    }
}
