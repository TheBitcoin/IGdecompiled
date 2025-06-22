package j$.time.temporal;

import j$.com.android.tools.r8.a;
import j$.time.chrono.s;
import j$.time.g;

/* 'enum' modifier removed */
public final class f extends h {
    public final u j() {
        return u.f(52, 53);
    }

    public f() {
        super("WEEK_OF_WEEK_BASED_YEAR", 2);
    }

    public final boolean m(n nVar) {
        if (!nVar.f(a.EPOCH_DAY)) {
            return false;
        }
        h hVar = j.f5022a;
        return a.v(nVar).equals(s.f4904c);
    }

    public final u p(n nVar) {
        if (m(nVar)) {
            return u.e(1, (long) h.D(h.C(g.E(nVar))));
        }
        throw new RuntimeException("Unsupported field: WeekOfWeekBasedYear");
    }

    public final long k(n nVar) {
        if (m(nVar)) {
            return (long) h.w(g.E(nVar));
        }
        throw new RuntimeException("Unsupported field: WeekOfWeekBasedYear");
    }

    public final m n(m mVar, long j4) {
        j().b(j4, this);
        return mVar.e(a.C(j4, k(mVar)), b.WEEKS);
    }

    public final String toString() {
        return "WeekOfWeekBasedYear";
    }
}
