package n3;

import androidx.privacysandbox.ads.adservices.adselection.u;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class a implements Comparable {

    /* renamed from: b  reason: collision with root package name */
    public static final C0266a f21358b = new C0266a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final long f21359c = f(0);

    /* renamed from: d  reason: collision with root package name */
    private static final long f21360d = c.e(4611686018427387903L);

    /* renamed from: e  reason: collision with root package name */
    private static final long f21361e = c.e(-4611686018427387903L);

    /* renamed from: a  reason: collision with root package name */
    private final long f21362a;

    /* renamed from: n3.a$a  reason: collision with other inner class name */
    public static final class C0266a {
        public /* synthetic */ C0266a(C2103g gVar) {
            this();
        }

        public final long a() {
            return a.f21359c;
        }

        private C0266a() {
        }
    }

    private /* synthetic */ a(long j4) {
        this.f21362a = j4;
    }

    public static final long E(long j4, d dVar) {
        m.e(dVar, "unit");
        if (j4 == f21360d) {
            return Long.MAX_VALUE;
        }
        if (j4 == f21361e) {
            return Long.MIN_VALUE;
        }
        return e.a(s(j4), r(j4), dVar);
    }

    public static String F(long j4) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        if (j4 == 0) {
            return "0s";
        }
        if (j4 == f21360d) {
            return "Infinity";
        }
        if (j4 == f21361e) {
            return "-Infinity";
        }
        boolean y4 = y(j4);
        StringBuilder sb = new StringBuilder();
        if (y4) {
            sb.append('-');
        }
        long h4 = h(j4);
        long j5 = j(h4);
        int i4 = i(h4);
        int o4 = o(h4);
        long j6 = j5;
        int q4 = q(h4);
        int p4 = p(h4);
        int i5 = 0;
        if (j6 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (i4 != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (o4 != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (q4 == 0 && p4 == 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z4) {
            sb.append(j6);
            sb.append('d');
            i5 = 1;
        }
        if (z5 || (z4 && (z6 || z7))) {
            int i6 = i5 + 1;
            if (i5 > 0) {
                sb.append(' ');
            }
            sb.append(i4);
            sb.append('h');
            i5 = i6;
        }
        if (z6 || (z7 && (z5 || z4))) {
            int i7 = i5 + 1;
            if (i5 > 0) {
                sb.append(' ');
            }
            sb.append(o4);
            sb.append('m');
            i5 = i7;
        }
        if (z7) {
            int i8 = i5 + 1;
            if (i5 > 0) {
                sb.append(' ');
            }
            if (q4 != 0 || z4 || z5 || z6) {
                b(j4, sb, q4, p4, 9, "s", false);
            } else if (p4 >= 1000000) {
                b(j4, sb, p4 / 1000000, p4 % 1000000, 6, "ms", false);
            } else {
                long j7 = j4;
                if (p4 >= 1000) {
                    b(j7, sb, p4 / 1000, p4 % 1000, 3, "us", false);
                } else {
                    sb.append(p4);
                    sb.append("ns");
                }
            }
            i5 = i8;
        }
        if (y4 && i5 > 1) {
            sb.insert(1, '(').append(')');
        }
        String sb2 = sb.toString();
        m.d(sb2, "toString(...)");
        return sb2;
    }

    public static final long G(long j4) {
        return c.d(-s(j4), ((int) j4) & 1);
    }

    private static final void b(long j4, StringBuilder sb, int i4, int i5, int i6, String str, boolean z4) {
        sb.append(i4);
        if (i5 != 0) {
            sb.append('.');
            String Y4 = m3.m.Y(String.valueOf(i5), i6, '0');
            int i7 = -1;
            int length = Y4.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i8 = length - 1;
                    if (Y4.charAt(length) != '0') {
                        i7 = length;
                        break;
                    } else if (i8 < 0) {
                        break;
                    } else {
                        length = i8;
                    }
                }
            }
            int i9 = i7 + 1;
            if (z4 || i9 >= 3) {
                sb.append(Y4, 0, ((i7 + 3) / 3) * 3);
                m.d(sb, "append(...)");
            } else {
                sb.append(Y4, 0, i9);
                m.d(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    public static final /* synthetic */ a c(long j4) {
        return new a(j4);
    }

    public static int e(long j4, long j5) {
        long j6 = j4 ^ j5;
        if (j6 < 0 || (((int) j6) & 1) == 0) {
            return m.h(j4, j5);
        }
        int i4 = (((int) j4) & 1) - (((int) j5) & 1);
        if (y(j4)) {
            return -i4;
        }
        return i4;
    }

    public static long f(long j4) {
        if (!b.a()) {
            return j4;
        }
        if (w(j4)) {
            long s4 = s(j4);
            if (-4611686018426999999L <= s4 && s4 < 4611686018427000000L) {
                return j4;
            }
            throw new AssertionError(s(j4) + " ns is out of nanoseconds range");
        }
        long s5 = s(j4);
        if (-4611686018427387903L > s5 || s5 >= 4611686018427387904L) {
            throw new AssertionError(s(j4) + " ms is out of milliseconds range");
        }
        long s6 = s(j4);
        if (-4611686018426L > s6 || s6 >= 4611686018427L) {
            return j4;
        }
        throw new AssertionError(s(j4) + " ms is denormalized");
    }

    public static boolean g(long j4, Object obj) {
        if ((obj instanceof a) && j4 == ((a) obj).H()) {
            return true;
        }
        return false;
    }

    public static final long h(long j4) {
        if (y(j4)) {
            return G(j4);
        }
        return j4;
    }

    public static final int i(long j4) {
        if (x(j4)) {
            return 0;
        }
        return (int) (k(j4) % ((long) 24));
    }

    public static final long j(long j4) {
        return E(j4, d.DAYS);
    }

    public static final long k(long j4) {
        return E(j4, d.HOURS);
    }

    public static final long l(long j4) {
        if (!v(j4) || !u(j4)) {
            return E(j4, d.MILLISECONDS);
        }
        return s(j4);
    }

    public static final long m(long j4) {
        return E(j4, d.MINUTES);
    }

    public static final long n(long j4) {
        return E(j4, d.SECONDS);
    }

    public static final int o(long j4) {
        if (x(j4)) {
            return 0;
        }
        return (int) (m(j4) % ((long) 60));
    }

    public static final int p(long j4) {
        long s4;
        if (x(j4)) {
            return 0;
        }
        if (v(j4)) {
            s4 = c.g(s(j4) % ((long) 1000));
        } else {
            s4 = s(j4) % ((long) 1000000000);
        }
        return (int) s4;
    }

    public static final int q(long j4) {
        if (x(j4)) {
            return 0;
        }
        return (int) (n(j4) % ((long) 60));
    }

    private static final d r(long j4) {
        if (w(j4)) {
            return d.NANOSECONDS;
        }
        return d.MILLISECONDS;
    }

    private static final long s(long j4) {
        return j4 >> 1;
    }

    public static int t(long j4) {
        return u.a(j4);
    }

    public static final boolean u(long j4) {
        return !x(j4);
    }

    private static final boolean v(long j4) {
        if ((((int) j4) & 1) == 1) {
            return true;
        }
        return false;
    }

    private static final boolean w(long j4) {
        if ((((int) j4) & 1) == 0) {
            return true;
        }
        return false;
    }

    public static final boolean x(long j4) {
        if (j4 == f21360d || j4 == f21361e) {
            return true;
        }
        return false;
    }

    public static final boolean y(long j4) {
        if (j4 < 0) {
            return true;
        }
        return false;
    }

    public static final boolean z(long j4) {
        if (j4 > 0) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ long H() {
        return this.f21362a;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return d(((a) obj).H());
    }

    public int d(long j4) {
        return e(this.f21362a, j4);
    }

    public boolean equals(Object obj) {
        return g(this.f21362a, obj);
    }

    public int hashCode() {
        return t(this.f21362a);
    }

    public String toString() {
        return F(this.f21362a);
    }
}
