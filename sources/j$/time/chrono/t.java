package j$.time.chrono;

import j$.time.temporal.a;
import j$.time.temporal.m;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.u;

public enum t implements m {
    ;

    public final int getValue() {
        return ordinal();
    }

    public final u n(q qVar) {
        return r.d(this, qVar);
    }

    public final m w(m mVar) {
        return mVar.d((long) getValue(), a.ERA);
    }
}
