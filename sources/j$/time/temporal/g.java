package j$.time.temporal;

import j$.com.android.tools.r8.a;
import j$.time.chrono.s;

/* 'enum' modifier removed */
public final class g extends h {
    public g() {
        super("WEEK_BASED_YEAR", 3);
    }

    public final u j() {
        return a.YEAR.f5014b;
    }

    public final boolean m(n nVar) {
        if (!nVar.f(a.EPOCH_DAY)) {
            return false;
        }
        h hVar = j.f5022a;
        return a.v(nVar).equals(s.f4904c);
    }

    public final long k(n nVar) {
        if (m(nVar)) {
            return (long) h.C(j$.time.g.E(nVar));
        }
        throw new RuntimeException("Unsupported field: WeekBasedYear");
    }

    public final u p(n nVar) {
        if (m(nVar)) {
            return j();
        }
        throw new RuntimeException("Unsupported field: WeekBasedYear");
    }

    public final m n(m mVar, long j4) {
        if (m(mVar)) {
            int a5 = a.YEAR.f5014b.a(j4, h.WEEK_BASED_YEAR);
            j$.time.g E4 = j$.time.g.E(mVar);
            a aVar = a.DAY_OF_WEEK;
            int k4 = E4.k(aVar);
            int w4 = h.w(E4);
            if (w4 == 53 && h.D(a5) == 52) {
                w4 = 52;
            }
            j$.time.g K4 = j$.time.g.K(a5, 1, 4);
            return mVar.m(K4.N((long) (((w4 - 1) * 7) + (k4 - K4.k(aVar)))));
        }
        throw new RuntimeException("Unsupported field: WeekBasedYear");
    }

    public final String toString() {
        return "WeekBasedYear";
    }
}
