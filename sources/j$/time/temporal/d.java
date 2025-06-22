package j$.time.temporal;

import j$.com.android.tools.r8.a;
import j$.time.chrono.s;

/* 'enum' modifier removed */
public final class d extends h {
    public final u j() {
        return u.f(90, 92);
    }

    public d() {
        super("DAY_OF_QUARTER", 0);
    }

    public final boolean m(n nVar) {
        if (!nVar.f(a.DAY_OF_YEAR) || !nVar.f(a.MONTH_OF_YEAR) || !nVar.f(a.YEAR)) {
            return false;
        }
        h hVar = j.f5022a;
        return a.v(nVar).equals(s.f4904c);
    }

    public final u p(n nVar) {
        if (m(nVar)) {
            long t4 = nVar.t(h.QUARTER_OF_YEAR);
            if (t4 == 1) {
                long t5 = nVar.t(a.YEAR);
                s.f4904c.getClass();
                return s.k(t5) ? u.e(1, 91) : u.e(1, 90);
            } else if (t4 == 2) {
                return u.e(1, 91);
            } else {
                if (t4 == 3 || t4 == 4) {
                    return u.e(1, 92);
                }
                return j();
            }
        } else {
            throw new RuntimeException("Unsupported field: DayOfQuarter");
        }
    }

    public final long k(n nVar) {
        if (m(nVar)) {
            int k4 = nVar.k(a.DAY_OF_YEAR);
            int k5 = nVar.k(a.MONTH_OF_YEAR);
            long t4 = nVar.t(a.YEAR);
            int[] iArr = h.f5018a;
            int i4 = (k5 - 1) / 3;
            s.f4904c.getClass();
            return (long) (k4 - iArr[i4 + (s.k(t4) ? 4 : 0)]);
        }
        throw new RuntimeException("Unsupported field: DayOfQuarter");
    }

    public final m n(m mVar, long j4) {
        long k4 = k(mVar);
        j().b(j4, this);
        a aVar = a.DAY_OF_YEAR;
        return mVar.d((j4 - k4) + mVar.t(aVar), aVar);
    }

    public final String toString() {
        return "DayOfQuarter";
    }
}
