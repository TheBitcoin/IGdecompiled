package n3;

import j3.e;
import kotlin.jvm.internal.m;

public abstract class c {
    /* access modifiers changed from: private */
    public static final long d(long j4, int i4) {
        return a.f((j4 << 1) + ((long) i4));
    }

    /* access modifiers changed from: private */
    public static final long e(long j4) {
        return a.f((j4 << 1) + 1);
    }

    private static final long f(long j4) {
        return a.f(j4 << 1);
    }

    /* access modifiers changed from: private */
    public static final long g(long j4) {
        return j4 * ((long) 1000000);
    }

    public static final long h(int i4, d dVar) {
        m.e(dVar, "unit");
        if (dVar.compareTo(d.SECONDS) <= 0) {
            return f(e.b((long) i4, dVar, d.NANOSECONDS));
        }
        return i((long) i4, dVar);
    }

    public static final long i(long j4, d dVar) {
        m.e(dVar, "unit");
        d dVar2 = d.NANOSECONDS;
        long b5 = e.b(4611686018426999999L, dVar2, dVar);
        if ((-b5) > j4 || j4 > b5) {
            return e(e.g(e.a(j4, dVar, d.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
        }
        return f(e.b(j4, dVar, dVar2));
    }
}
