package j$.time.temporal;

import j$.com.android.tools.r8.a;
import j$.time.chrono.s;

/* 'enum' modifier removed */
public final class e extends h {
    public e() {
        super("QUARTER_OF_YEAR", 1);
    }

    public final u j() {
        return u.e(1, 4);
    }

    public final boolean m(n nVar) {
        if (!nVar.f(a.MONTH_OF_YEAR)) {
            return false;
        }
        h hVar = j.f5022a;
        return a.v(nVar).equals(s.f4904c);
    }

    public final long k(n nVar) {
        if (m(nVar)) {
            return (nVar.t(a.MONTH_OF_YEAR) + 2) / 3;
        }
        throw new RuntimeException("Unsupported field: QuarterOfYear");
    }

    public final u p(n nVar) {
        if (m(nVar)) {
            return j();
        }
        throw new RuntimeException("Unsupported field: QuarterOfYear");
    }

    public final m n(m mVar, long j4) {
        long k4 = k(mVar);
        j().b(j4, this);
        a aVar = a.MONTH_OF_YEAR;
        return mVar.d(((j4 - k4) * 3) + mVar.t(aVar), aVar);
    }

    public final String toString() {
        return "QuarterOfYear";
    }
}
