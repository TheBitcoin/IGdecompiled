package s0;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private final C2264F f21746a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21747b;

    /* renamed from: c  reason: collision with root package name */
    private final int f21748c;

    private r(Class cls, int i4, int i5) {
        this(C2264F.b(cls), i4, i5);
    }

    public static r a(Class cls) {
        return new r(cls, 0, 2);
    }

    private static String b(int i4) {
        if (i4 == 0) {
            return "direct";
        }
        if (i4 == 1) {
            return "provider";
        }
        if (i4 == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i4);
    }

    public static r h(Class cls) {
        return new r(cls, 0, 0);
    }

    public static r i(Class cls) {
        return new r(cls, 0, 1);
    }

    public static r j(C2264F f4) {
        return new r(f4, 0, 1);
    }

    public static r k(Class cls) {
        return new r(cls, 1, 0);
    }

    public static r l(C2264F f4) {
        return new r(f4, 1, 0);
    }

    public static r m(Class cls) {
        return new r(cls, 1, 1);
    }

    public static r n(C2264F f4) {
        return new r(f4, 1, 1);
    }

    public static r o(Class cls) {
        return new r(cls, 2, 0);
    }

    public C2264F c() {
        return this.f21746a;
    }

    public boolean d() {
        if (this.f21748c == 2) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f21748c == 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f21746a.equals(rVar.f21746a) && this.f21747b == rVar.f21747b && this.f21748c == rVar.f21748c) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean f() {
        if (this.f21747b == 1) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f21747b == 2) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f21746a.hashCode() ^ 1000003) * 1000003) ^ this.f21747b) * 1000003) ^ this.f21748c;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f21746a);
        sb.append(", type=");
        int i4 = this.f21747b;
        if (i4 == 1) {
            str = "required";
        } else if (i4 == 0) {
            str = "optional";
        } else {
            str = "set";
        }
        sb.append(str);
        sb.append(", injection=");
        sb.append(b(this.f21748c));
        sb.append("}");
        return sb.toString();
    }

    private r(C2264F f4, int i4, int i5) {
        this.f21746a = (C2264F) C2263E.c(f4, "Null dependency anInterface.");
        this.f21747b = i4;
        this.f21748c = i5;
    }
}
