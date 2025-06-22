package j$.time.temporal;

import j$.time.c;
import j$.time.format.a;
import j$.util.Objects;

public abstract class r {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5032a = new a(1);

    /* renamed from: b  reason: collision with root package name */
    public static final a f5033b = new a(2);

    /* renamed from: c  reason: collision with root package name */
    public static final a f5034c = new a(3);

    /* renamed from: d  reason: collision with root package name */
    public static final a f5035d = new a(4);

    /* renamed from: e  reason: collision with root package name */
    public static final a f5036e = new a(5);

    /* renamed from: f  reason: collision with root package name */
    public static final a f5037f = new a(6);

    /* renamed from: g  reason: collision with root package name */
    public static final a f5038g = new a(7);

    public static u d(n nVar, q qVar) {
        if (!(qVar instanceof a)) {
            Objects.requireNonNull(qVar, "field");
            return qVar.p(nVar);
        } else if (nVar.f(qVar)) {
            return ((a) qVar).f5014b;
        } else {
            throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
    }

    public static int a(n nVar, q qVar) {
        u n4 = nVar.n(qVar);
        if (n4.f5039a < -2147483648L || n4.f5042d > 2147483647L) {
            throw new RuntimeException("Invalid field " + qVar + " for get() method, use getLong() instead");
        }
        long t4 = nVar.t(qVar);
        if (n4.d(t4)) {
            return (int) t4;
        }
        throw new RuntimeException("Invalid value for " + qVar + " (valid values " + n4 + "): " + t4);
    }

    public static Object c(n nVar, a aVar) {
        if (aVar == f5032a || aVar == f5033b || aVar == f5034c) {
            return null;
        }
        return aVar.a(nVar);
    }

    public static m b(m mVar, long j4, s sVar) {
        long j5;
        if (j4 == Long.MIN_VALUE) {
            mVar = mVar.e(Long.MAX_VALUE, sVar);
            j5 = 1;
        } else {
            j5 = -j4;
        }
        return mVar.e(j5, sVar);
    }
}
