package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.chrono.s;
import j$.time.format.n;
import j$.time.format.t;
import j$.time.format.u;
import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

public final class v implements m, o, Comparable, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f5045c = 0;
    private static final long serialVersionUID = 4183400860270640070L;

    /* renamed from: a  reason: collision with root package name */
    public final int f5046a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5047b;

    public final int compareTo(Object obj) {
        v vVar = (v) obj;
        int i4 = this.f5046a - vVar.f5046a;
        return i4 == 0 ? this.f5047b - vVar.f5047b : i4;
    }

    static {
        n nVar = new n();
        nVar.h(a.YEAR, 4, 10, u.EXCEEDS_PAD);
        nVar.c('-');
        nVar.g(a.MONTH_OF_YEAR, 2);
        nVar.l(Locale.getDefault(), t.SMART, (s) null);
    }

    public v(int i4, int i5) {
        this.f5046a = i4;
        this.f5047b = i5;
    }

    public final v G(int i4, int i5) {
        if (this.f5046a == i4 && this.f5047b == i5) {
            return this;
        }
        return new v(i4, i5);
    }

    public final boolean f(q qVar) {
        return qVar instanceof a ? qVar == a.YEAR || qVar == a.MONTH_OF_YEAR || qVar == a.PROLEPTIC_MONTH || qVar == a.YEAR_OF_ERA || qVar == a.ERA : qVar != null && qVar.m(this);
    }

    public final j$.time.temporal.u n(q qVar) {
        if (qVar != a.YEAR_OF_ERA) {
            return r.d(this, qVar);
        }
        return j$.time.temporal.u.e(1, this.f5046a <= 0 ? C.NANOS_PER_SECOND : 999999999);
    }

    public final int k(q qVar) {
        return n(qVar).a(t(qVar), qVar);
    }

    public final long t(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.k(this);
        }
        int i4 = u.f5043a[((a) qVar).ordinal()];
        int i5 = 1;
        if (i4 == 1) {
            return (long) this.f5047b;
        }
        if (i4 == 2) {
            return C();
        }
        int i6 = this.f5046a;
        if (i4 == 3) {
            if (i6 < 1) {
                i6 = 1 - i6;
            }
            return (long) i6;
        } else if (i4 == 4) {
            return (long) i6;
        } else {
            if (i4 == 5) {
                if (i6 < 1) {
                    i5 = 0;
                }
                return (long) i5;
            }
            throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
    }

    public final long C() {
        return ((((long) this.f5046a) * 12) + ((long) this.f5047b)) - 1;
    }

    /* renamed from: H */
    public final v d(long j4, q qVar) {
        if (!(qVar instanceof a)) {
            return (v) qVar.n(this, j4);
        }
        a aVar = (a) qVar;
        aVar.w(j4);
        int i4 = u.f5043a[aVar.ordinal()];
        int i5 = this.f5046a;
        if (i4 == 1) {
            int i6 = (int) j4;
            a.MONTH_OF_YEAR.w((long) i6);
            return G(i5, i6);
        } else if (i4 == 2) {
            return E(j4 - C());
        } else {
            int i7 = this.f5047b;
            if (i4 == 3) {
                if (i5 < 1) {
                    j4 = 1 - j4;
                }
                int i8 = (int) j4;
                a.YEAR.w((long) i8);
                return G(i8, i7);
            } else if (i4 == 4) {
                int i9 = (int) j4;
                a.YEAR.w((long) i9);
                return G(i9, i7);
            } else if (i4 != 5) {
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
            } else if (t(a.ERA) == j4) {
                return this;
            } else {
                int i10 = 1 - i5;
                a.YEAR.w((long) i10);
                return G(i10, i7);
            }
        }
    }

    /* renamed from: D */
    public final v e(long j4, j$.time.temporal.s sVar) {
        if (!(sVar instanceof b)) {
            return (v) sVar.j(this, j4);
        }
        switch (u.f5044b[((b) sVar).ordinal()]) {
            case 1:
                return E(j4);
            case 2:
                return F(j4);
            case 3:
                return F(j$.com.android.tools.r8.a.w(j4, 10));
            case 4:
                return F(j$.com.android.tools.r8.a.w(j4, 100));
            case 5:
                return F(j$.com.android.tools.r8.a.w(j4, 1000));
            case 6:
                a aVar = a.ERA;
                return d(j$.com.android.tools.r8.a.x(t(aVar), j4), aVar);
            default:
                throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    public final v F(long j4) {
        if (j4 == 0) {
            return this;
        }
        a aVar = a.YEAR;
        return G(aVar.f5014b.a(((long) this.f5046a) + j4, aVar), this.f5047b);
    }

    public final v E(long j4) {
        if (j4 == 0) {
            return this;
        }
        long j5 = (((long) this.f5046a) * 12) + ((long) (this.f5047b - 1)) + j4;
        a aVar = a.YEAR;
        long j6 = (long) 12;
        return G(aVar.f5014b.a(j$.com.android.tools.r8.a.B(j5, j6), aVar), ((int) j$.com.android.tools.r8.a.A(j5, j6)) + 1);
    }

    public final m j(long j4, b bVar) {
        return j4 == Long.MIN_VALUE ? e(Long.MAX_VALUE, bVar).e(1, bVar) : e(-j4, bVar);
    }

    public final Object p(j$.time.format.a aVar) {
        if (aVar == r.f5033b) {
            return s.f4904c;
        }
        if (aVar == r.f5034c) {
            return b.MONTHS;
        }
        return r.c(this, aVar);
    }

    public final m w(m mVar) {
        if (j$.com.android.tools.r8.a.v(mVar).equals(s.f4904c)) {
            return mVar.d(C(), a.PROLEPTIC_MONTH);
        }
        throw new RuntimeException("Adjustment only supported on ISO date-time");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        r5 = (j$.time.v) r5;
        r1 = r5.f5046a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof j$.time.v
            r2 = 0
            if (r1 == 0) goto L_0x0018
            j$.time.v r5 = (j$.time.v) r5
            int r1 = r5.f5046a
            int r3 = r4.f5046a
            if (r3 != r1) goto L_0x0018
            int r1 = r4.f5047b
            int r5 = r5.f5047b
            if (r1 != r5) goto L_0x0018
            return r0
        L_0x0018:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.v.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return (this.f5047b << 27) ^ this.f5046a;
    }

    public final String toString() {
        int i4 = this.f5046a;
        int abs = Math.abs(i4);
        StringBuilder sb = new StringBuilder(9);
        if (abs >= 1000) {
            sb.append(i4);
        } else if (i4 < 0) {
            sb.append(i4 - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i4 + 10000);
            sb.deleteCharAt(0);
        }
        int i5 = this.f5047b;
        sb.append(i5 < 10 ? "-0" : "-");
        sb.append(i5);
        return sb.toString();
    }

    private Object writeReplace() {
        return new r((byte) 12, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final m m(g gVar) {
        return (v) j$.com.android.tools.r8.a.a(gVar, this);
    }
}
