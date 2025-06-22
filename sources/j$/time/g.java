package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.chrono.C1117b;
import j$.time.chrono.C1120e;
import j$.time.chrono.l;
import j$.time.chrono.s;
import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.u;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class g implements m, o, C1117b, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final g f4975d = K(-999999999, 1, 1);

    /* renamed from: e  reason: collision with root package name */
    public static final g f4976e = K(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;

    /* renamed from: a  reason: collision with root package name */
    public final int f4977a;

    /* renamed from: b  reason: collision with root package name */
    public final short f4978b;

    /* renamed from: c  reason: collision with root package name */
    public final short f4979c;

    static {
        K(1970, 1, 1);
    }

    public static g K(int i4, int i5, int i6) {
        a.YEAR.w((long) i4);
        a.MONTH_OF_YEAR.w((long) i5);
        a.DAY_OF_MONTH.w((long) i6);
        return D(i4, i5, i6);
    }

    public static g L(long j4) {
        long j5;
        long j6 = j4;
        a.EPOCH_DAY.w(j6);
        long j7 = 719468 + j6;
        if (j7 < 0) {
            long j8 = ((j6 + 719469) / 146097) - 1;
            j5 = j8 * 400;
            j7 += (-j8) * 146097;
        } else {
            j5 = 0;
        }
        long j9 = ((j7 * 400) + 591) / 146097;
        long j10 = j7 - ((j9 / 400) + (((j9 / 4) + (j9 * 365)) - (j9 / 100)));
        if (j10 < 0) {
            j9--;
            j10 = j7 - ((j9 / 400) + (((j9 / 4) + (365 * j9)) - (j9 / 100)));
        }
        int i4 = (int) j10;
        int i5 = ((i4 * 5) + 2) / 153;
        long j11 = j9 + j5 + ((long) (i5 / 10));
        a aVar = a.YEAR;
        return new g(aVar.f5014b.a(j11, aVar), ((i5 + 2) % 12) + 1, (i4 - (((i5 * 306) + 5) / 10)) + 1);
    }

    public static g E(n nVar) {
        Objects.requireNonNull(nVar, "temporal");
        g gVar = (g) nVar.p(r.f5037f);
        if (gVar != null) {
            return gVar;
        }
        String name = nVar.getClass().getName();
        throw new RuntimeException("Unable to obtain LocalDate from TemporalAccessor: " + nVar + " of type " + name);
    }

    public static g D(int i4, int i5, int i6) {
        int i7 = 28;
        if (i6 > 28) {
            if (i5 != 2) {
                i7 = (i5 == 4 || i5 == 6 || i5 == 9 || i5 == 11) ? 30 : 31;
            } else {
                s.f4904c.getClass();
                if (s.k((long) i4)) {
                    i7 = 29;
                }
            }
            if (i6 > i7) {
                if (i6 == 29) {
                    throw new RuntimeException("Invalid date 'February 29' as '" + i4 + "' is not a leap year");
                }
                String name = l.F(i5).name();
                throw new RuntimeException("Invalid date '" + name + " " + i6 + "'");
            }
        }
        return new g(i4, i5, i6);
    }

    public static g Q(int i4, int i5, int i6) {
        if (i5 == 2) {
            s.f4904c.getClass();
            i6 = Math.min(i6, s.k((long) i4) ? 29 : 28);
        } else if (i5 == 4 || i5 == 6 || i5 == 9 || i5 == 11) {
            i6 = Math.min(i6, 30);
        }
        return new g(i4, i5, i6);
    }

    public g(int i4, int i5, int i6) {
        this.f4977a = i4;
        this.f4978b = (short) i5;
        this.f4979c = (short) i6;
    }

    public final boolean f(q qVar) {
        return j$.com.android.tools.r8.a.n(this, qVar);
    }

    public final u n(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.p(this);
        }
        a aVar = (a) qVar;
        if (aVar.t()) {
            int i4 = f.f4923a[aVar.ordinal()];
            if (i4 == 1) {
                return u.e(1, (long) J());
            }
            if (i4 == 2) {
                return u.e(1, (long) (I() ? 366 : 365));
            } else if (i4 == 3) {
                return u.e(1, (l.F(this.f4978b) != l.FEBRUARY || I()) ? 5 : 4);
            } else if (i4 != 4) {
                return ((a) qVar).f5014b;
            } else {
                return this.f4977a <= 0 ? u.e(1, C.NANOS_PER_SECOND) : u.e(1, 999999999);
            }
        } else {
            throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
    }

    public final int k(q qVar) {
        if (qVar instanceof a) {
            return F(qVar);
        }
        return r.a(this, qVar);
    }

    public final long t(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.k(this);
        }
        if (qVar == a.EPOCH_DAY) {
            return u();
        }
        return qVar == a.PROLEPTIC_MONTH ? ((((long) this.f4977a) * 12) + ((long) this.f4978b)) - 1 : (long) F(qVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
        return r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int F(j$.time.temporal.q r5) {
        /*
            r4 = this;
            int[] r0 = j$.time.f.f4923a
            r1 = r5
            j$.time.temporal.a r1 = (j$.time.temporal.a) r1
            int r1 = r1.ordinal()
            r0 = r0[r1]
            short r1 = r4.f4979c
            int r2 = r4.f4977a
            r3 = 1
            switch(r0) {
                case 1: goto L_0x0065;
                case 2: goto L_0x0060;
                case 3: goto L_0x005c;
                case 4: goto L_0x0057;
                case 5: goto L_0x004e;
                case 6: goto L_0x0049;
                case 7: goto L_0x0040;
                case 8: goto L_0x0038;
                case 9: goto L_0x002f;
                case 10: goto L_0x002c;
                case 11: goto L_0x0024;
                case 12: goto L_0x0059;
                case 13: goto L_0x001f;
                default: goto L_0x0013;
            }
        L_0x0013:
            j$.time.temporal.t r0 = new j$.time.temporal.t
            java.lang.String r1 = "Unsupported field: "
            java.lang.String r5 = j$.time.c.a(r1, r5)
            r0.<init>(r5)
            throw r0
        L_0x001f:
            if (r2 < r3) goto L_0x0022
            return r3
        L_0x0022:
            r5 = 0
            return r5
        L_0x0024:
            j$.time.temporal.t r5 = new j$.time.temporal.t
            java.lang.String r0 = "Invalid field 'ProlepticMonth' for get() method, use getLong() instead"
            r5.<init>(r0)
            throw r5
        L_0x002c:
            short r5 = r4.f4978b
            return r5
        L_0x002f:
            int r5 = r4.H()
            int r5 = r5 - r3
            int r5 = r5 / 7
            int r5 = r5 + r3
            return r5
        L_0x0038:
            j$.time.temporal.t r5 = new j$.time.temporal.t
            java.lang.String r0 = "Invalid field 'EpochDay' for get() method, use getLong() instead"
            r5.<init>(r0)
            throw r5
        L_0x0040:
            int r5 = r4.H()
            int r5 = r5 - r3
            int r5 = r5 % 7
            int r5 = r5 + r3
            return r5
        L_0x0049:
            int r1 = r1 - r3
            int r1 = r1 % 7
        L_0x004c:
            int r1 = r1 + r3
            return r1
        L_0x004e:
            j$.time.d r5 = r4.G()
            int r5 = r5.getValue()
            return r5
        L_0x0057:
            if (r2 < r3) goto L_0x005a
        L_0x0059:
            return r2
        L_0x005a:
            int r3 = r3 - r2
            return r3
        L_0x005c:
            int r1 = r1 - r3
            int r1 = r1 / 7
            goto L_0x004c
        L_0x0060:
            int r5 = r4.H()
            return r5
        L_0x0065:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.g.F(j$.time.temporal.q):int");
    }

    public final l a() {
        return s.f4904c;
    }

    public final int H() {
        return (l.F(this.f4978b).C(I()) + this.f4979c) - 1;
    }

    public final d G() {
        return d.C(((int) j$.com.android.tools.r8.a.A(u() + 3, (long) 7)) + 1);
    }

    public final boolean I() {
        s.f4904c.getClass();
        return s.k((long) this.f4977a);
    }

    public final int J() {
        short s4 = this.f4978b;
        return s4 != 2 ? (s4 == 4 || s4 == 6 || s4 == 9 || s4 == 11) ? 30 : 31 : I() ? 29 : 28;
    }

    /* renamed from: S */
    public final g m(o oVar) {
        if (oVar instanceof g) {
            return (g) oVar;
        }
        return (g) oVar.w(this);
    }

    /* renamed from: R */
    public final g d(long j4, q qVar) {
        if (!(qVar instanceof a)) {
            return (g) qVar.n(this, j4);
        }
        a aVar = (a) qVar;
        aVar.w(j4);
        int i4 = f.f4923a[aVar.ordinal()];
        short s4 = this.f4979c;
        short s5 = this.f4978b;
        int i5 = this.f4977a;
        switch (i4) {
            case 1:
                int i6 = (int) j4;
                if (s4 != i6) {
                    return K(i5, s5, i6);
                }
                break;
            case 2:
                return T((int) j4);
            case 3:
                return N(j$.com.android.tools.r8.a.w(j4 - t(a.ALIGNED_WEEK_OF_MONTH), 7));
            case 4:
                if (i5 < 1) {
                    j4 = 1 - j4;
                }
                return U((int) j4);
            case 5:
                return N(j4 - ((long) G().getValue()));
            case 6:
                return N(j4 - t(a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return N(j4 - t(a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return L(j4);
            case 9:
                return N(j$.com.android.tools.r8.a.w(j4 - t(a.ALIGNED_WEEK_OF_YEAR), 7));
            case 10:
                int i7 = (int) j4;
                if (s5 != i7) {
                    a.MONTH_OF_YEAR.w((long) i7);
                    return Q(i5, i7, s4);
                }
                break;
            case 11:
                return O(j4 - (((((long) i5) * 12) + ((long) s5)) - 1));
            case 12:
                return U((int) j4);
            case 13:
                if (t(a.ERA) != j4) {
                    return U(1 - i5);
                }
                break;
            default:
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
        return this;
    }

    public final g U(int i4) {
        if (this.f4977a == i4) {
            return this;
        }
        a.YEAR.w((long) i4);
        return Q(i4, this.f4978b, this.f4979c);
    }

    public final g T(int i4) {
        if (H() == i4) {
            return this;
        }
        a aVar = a.YEAR;
        int i5 = this.f4977a;
        long j4 = (long) i5;
        aVar.w(j4);
        a.DAY_OF_YEAR.w((long) i4);
        s.f4904c.getClass();
        boolean k4 = s.k(j4);
        if (i4 != 366 || k4) {
            l F4 = l.F(((i4 - 1) / 31) + 1);
            if (i4 > (F4.D(k4) + F4.C(k4)) - 1) {
                l[] lVarArr = l.f4992a;
                F4 = lVarArr[((((int) 1) + 12) + F4.ordinal()) % 12];
            }
            return new g(i5, F4.getValue(), (i4 - F4.C(k4)) + 1);
        }
        throw new RuntimeException("Invalid date 'DayOfYear 366' as '" + i5 + "' is not a leap year");
    }

    /* renamed from: M */
    public final g e(long j4, j$.time.temporal.s sVar) {
        if (!(sVar instanceof b)) {
            return (g) sVar.j(this, j4);
        }
        switch (f.f4924b[((b) sVar).ordinal()]) {
            case 1:
                return N(j4);
            case 2:
                return N(j$.com.android.tools.r8.a.w(j4, 7));
            case 3:
                return O(j4);
            case 4:
                return P(j4);
            case 5:
                return P(j$.com.android.tools.r8.a.w(j4, 10));
            case 6:
                return P(j$.com.android.tools.r8.a.w(j4, 100));
            case 7:
                return P(j$.com.android.tools.r8.a.w(j4, 1000));
            case 8:
                a aVar = a.ERA;
                return d(j$.com.android.tools.r8.a.x(t(aVar), j4), aVar);
            default:
                throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    public final g P(long j4) {
        if (j4 == 0) {
            return this;
        }
        a aVar = a.YEAR;
        return Q(aVar.f5014b.a(((long) this.f4977a) + j4, aVar), this.f4978b, this.f4979c);
    }

    public final g O(long j4) {
        if (j4 == 0) {
            return this;
        }
        long j5 = (((long) this.f4977a) * 12) + ((long) (this.f4978b - 1)) + j4;
        a aVar = a.YEAR;
        long j6 = (long) 12;
        return Q(aVar.f5014b.a(j$.com.android.tools.r8.a.B(j5, j6), aVar), ((int) j$.com.android.tools.r8.a.A(j5, j6)) + 1, this.f4979c);
    }

    public final g N(long j4) {
        if (j4 == 0) {
            return this;
        }
        long j5 = ((long) this.f4979c) + j4;
        if (j5 > 0) {
            short s4 = this.f4978b;
            int i4 = this.f4977a;
            if (j5 <= 28) {
                return new g(i4, s4, (int) j5);
            }
            if (j5 <= 59) {
                long J4 = (long) J();
                if (j5 <= J4) {
                    return new g(i4, s4, (int) j5);
                }
                if (s4 < 12) {
                    return new g(i4, s4 + 1, (int) (j5 - J4));
                }
                int i5 = i4 + 1;
                a.YEAR.w((long) i5);
                return new g(i5, 1, (int) (j5 - J4));
            }
        }
        return L(j$.com.android.tools.r8.a.x(u(), j4));
    }

    public final m j(long j4, b bVar) {
        return j4 == Long.MIN_VALUE ? e(Long.MAX_VALUE, bVar).e(1, bVar) : e(-j4, bVar);
    }

    public final Object p(j$.time.format.a aVar) {
        if (aVar == r.f5037f) {
            return this;
        }
        return j$.com.android.tools.r8.a.p(this, aVar);
    }

    public final m w(m mVar) {
        return j$.com.android.tools.r8.a.a(this, mVar);
    }

    public final C1120e v(j jVar) {
        return LocalDateTime.F(this, jVar);
    }

    public final long u() {
        long j4;
        long j5 = (long) this.f4977a;
        long j6 = (long) this.f4978b;
        long j7 = 365 * j5;
        if (j5 >= 0) {
            j4 = ((j5 + 399) / 400) + (((3 + j5) / 4) - ((99 + j5) / 100)) + j7;
        } else {
            j4 = j7 - ((j5 / -400) + ((j5 / -4) - (j5 / -100)));
        }
        long j8 = (((367 * j6) - 362) / 12) + j4 + ((long) (this.f4979c - 1));
        if (j6 > 2) {
            j8 = !I() ? j8 - 2 : j8 - 1;
        }
        return j8 - 719528;
    }

    /* renamed from: z */
    public final int compareTo(C1117b bVar) {
        if (bVar instanceof g) {
            return C((g) bVar);
        }
        return j$.com.android.tools.r8.a.g(this, bVar);
    }

    public final int C(g gVar) {
        int i4 = this.f4977a - gVar.f4977a;
        if (i4 != 0) {
            return i4;
        }
        int i5 = this.f4978b - gVar.f4978b;
        return i5 == 0 ? this.f4979c - gVar.f4979c : i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && C((g) obj) == 0;
    }

    public final int hashCode() {
        int i4 = this.f4977a;
        return (((i4 << 11) + (this.f4978b << 6)) + this.f4979c) ^ (i4 & -2048);
    }

    public final String toString() {
        int i4 = this.f4977a;
        int abs = Math.abs(i4);
        StringBuilder sb = new StringBuilder(10);
        if (abs >= 1000) {
            if (i4 > 9999) {
                sb.append('+');
            }
            sb.append(i4);
        } else if (i4 < 0) {
            sb.append(i4 - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i4 + 10000);
            sb.deleteCharAt(0);
        }
        String str = "-";
        short s4 = this.f4978b;
        sb.append(s4 < 10 ? "-0" : str);
        sb.append(s4);
        short s5 = this.f4979c;
        if (s5 < 10) {
            str = "-0";
        }
        sb.append(str);
        sb.append(s5);
        return sb.toString();
    }

    private Object writeReplace() {
        return new r((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
