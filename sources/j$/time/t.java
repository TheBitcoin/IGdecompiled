package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.chrono.s;
import j$.time.format.n;
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

public final class t implements m, o, Comparable, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f5010b = 0;
    private static final long serialVersionUID = -23038383694477807L;

    /* renamed from: a  reason: collision with root package name */
    public final int f5011a;

    public final int compareTo(Object obj) {
        return this.f5011a - ((t) obj).f5011a;
    }

    static {
        n nVar = new n();
        nVar.h(a.YEAR, 4, 10, u.EXCEEDS_PAD);
        nVar.l(Locale.getDefault(), j$.time.format.t.SMART, (s) null);
    }

    public static t C(int i4) {
        a.YEAR.w((long) i4);
        return new t(i4);
    }

    public t(int i4) {
        this.f5011a = i4;
    }

    public final boolean f(q qVar) {
        return qVar instanceof a ? qVar == a.YEAR || qVar == a.YEAR_OF_ERA || qVar == a.ERA : qVar != null && qVar.m(this);
    }

    public final j$.time.temporal.u n(q qVar) {
        if (qVar != a.YEAR_OF_ERA) {
            return r.d(this, qVar);
        }
        return j$.time.temporal.u.e(1, this.f5011a <= 0 ? C.NANOS_PER_SECOND : 999999999);
    }

    public final int k(q qVar) {
        return n(qVar).a(t(qVar), qVar);
    }

    public final long t(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.k(this);
        }
        int i4 = s.f5008a[((a) qVar).ordinal()];
        int i5 = this.f5011a;
        int i6 = 1;
        if (i4 == 1) {
            if (i5 < 1) {
                i5 = 1 - i5;
            }
            return (long) i5;
        } else if (i4 == 2) {
            return (long) i5;
        } else {
            if (i4 == 3) {
                if (i5 < 1) {
                    i6 = 0;
                }
                return (long) i6;
            }
            throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
    }

    /* renamed from: F */
    public final t d(long j4, q qVar) {
        if (!(qVar instanceof a)) {
            return (t) qVar.n(this, j4);
        }
        a aVar = (a) qVar;
        aVar.w(j4);
        int i4 = s.f5008a[aVar.ordinal()];
        int i5 = this.f5011a;
        if (i4 == 1) {
            if (i5 < 1) {
                j4 = 1 - j4;
            }
            return C((int) j4);
        } else if (i4 == 2) {
            return C((int) j4);
        } else {
            if (i4 == 3) {
                return t(a.ERA) == j4 ? this : C(1 - i5);
            }
            throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
    }

    /* renamed from: D */
    public final t e(long j4, j$.time.temporal.s sVar) {
        if (!(sVar instanceof b)) {
            return (t) sVar.j(this, j4);
        }
        int i4 = s.f5009b[((b) sVar).ordinal()];
        if (i4 == 1) {
            return E(j4);
        }
        if (i4 == 2) {
            return E(j$.com.android.tools.r8.a.w(j4, 10));
        }
        if (i4 == 3) {
            return E(j$.com.android.tools.r8.a.w(j4, 100));
        }
        if (i4 == 4) {
            return E(j$.com.android.tools.r8.a.w(j4, 1000));
        }
        if (i4 == 5) {
            a aVar = a.ERA;
            return d(j$.com.android.tools.r8.a.x(t(aVar), j4), aVar);
        }
        throw new RuntimeException("Unsupported unit: " + sVar);
    }

    public final t E(long j4) {
        if (j4 == 0) {
            return this;
        }
        a aVar = a.YEAR;
        return C(aVar.f5014b.a(((long) this.f5011a) + j4, aVar));
    }

    public final m j(long j4, b bVar) {
        return j4 == Long.MIN_VALUE ? e(Long.MAX_VALUE, bVar).e(1, bVar) : e(-j4, bVar);
    }

    public final Object p(j$.time.format.a aVar) {
        if (aVar == r.f5033b) {
            return s.f4904c;
        }
        if (aVar == r.f5034c) {
            return b.YEARS;
        }
        return r.c(this, aVar);
    }

    public final m w(m mVar) {
        if (j$.com.android.tools.r8.a.v(mVar).equals(s.f4904c)) {
            return mVar.d((long) this.f5011a, a.YEAR);
        }
        throw new RuntimeException("Adjustment only supported on ISO date-time");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        r4 = ((j$.time.t) r4).f5011a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 1
            if (r3 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r4 instanceof j$.time.t
            r2 = 0
            if (r1 == 0) goto L_0x0012
            j$.time.t r4 = (j$.time.t) r4
            int r4 = r4.f5011a
            int r1 = r3.f5011a
            if (r1 != r4) goto L_0x0012
            return r0
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.t.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return this.f5011a;
    }

    public final String toString() {
        return Integer.toString(this.f5011a);
    }

    private Object writeReplace() {
        return new r((byte) 11, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final m m(g gVar) {
        return (t) j$.com.android.tools.r8.a.a(gVar, this);
    }
}
