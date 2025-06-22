package j$.time.chrono;

import j$.time.temporal.a;
import j$.time.temporal.m;
import j$.time.temporal.q;
import j$.time.temporal.u;

public enum r implements m {
    ;

    public final int getValue() {
        return 1;
    }

    public final u n(q qVar) {
        if (qVar == a.ERA) {
            return u.e(1, 1);
        }
        return j$.time.temporal.r.d(this, qVar);
    }

    public final m w(m mVar) {
        return mVar.d((long) 1, a.ERA);
    }
}
