package j$.time.chrono;

import j$.com.android.tools.r8.a;
import j$.time.c;
import j$.time.j;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.time.temporal.u;
import java.io.Serializable;

/* renamed from: j$.time.chrono.d  reason: case insensitive filesystem */
public abstract class C1119d implements C1117b, m, o, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    public abstract C1117b F(long j4);

    public abstract C1117b G(long j4);

    public abstract C1117b H(long j4);

    public /* synthetic */ boolean f(q qVar) {
        return a.n(this, qVar);
    }

    public final /* synthetic */ int k(q qVar) {
        return r.a(this, qVar);
    }

    public /* synthetic */ u n(q qVar) {
        return r.d(this, qVar);
    }

    public final /* synthetic */ Object p(j$.time.format.a aVar) {
        return a.p(this, aVar);
    }

    public final /* synthetic */ m w(m mVar) {
        return a.a(this, mVar);
    }

    /* renamed from: z */
    public final /* synthetic */ int compareTo(C1117b bVar) {
        return a.g(this, bVar);
    }

    public static C1117b C(l lVar, m mVar) {
        C1117b bVar = (C1117b) mVar;
        if (lVar.equals(bVar.a())) {
            return bVar;
        }
        String i4 = lVar.i();
        String i5 = bVar.a().i();
        throw new ClassCastException("Chronology mismatch, expected: " + i4 + ", actual: " + i5);
    }

    public C1120e v(j jVar) {
        return new C1122g(this, jVar);
    }

    public C1117b e(long j4, s sVar) {
        boolean z4 = sVar instanceof b;
        if (z4) {
            switch (C1118c.f4873a[((b) sVar).ordinal()]) {
                case 1:
                    return F(j4);
                case 2:
                    return F(a.w(j4, 7));
                case 3:
                    return G(j4);
                case 4:
                    return H(j4);
                case 5:
                    return H(a.w(j4, 10));
                case 6:
                    return H(a.w(j4, 100));
                case 7:
                    return H(a.w(j4, 1000));
                case 8:
                    j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                    return d(a.x(t(aVar), j4), (q) aVar);
                default:
                    throw new RuntimeException("Unsupported unit: " + sVar);
            }
        } else if (!z4) {
            return C(a(), sVar.j(this, j4));
        } else {
            throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    public m D() {
        return a().A(r.a(this, j$.time.temporal.a.ERA));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1117b) && a.g(this, (C1117b) obj) == 0;
    }

    public int hashCode() {
        long u4 = u();
        return a().hashCode() ^ ((int) (u4 ^ (u4 >>> 32)));
    }

    /* renamed from: I */
    public C1117b m(o oVar) {
        return C(a(), oVar.w(this));
    }

    public final String toString() {
        long t4 = t(j$.time.temporal.a.YEAR_OF_ERA);
        long t5 = t(j$.time.temporal.a.MONTH_OF_YEAR);
        long t6 = t(j$.time.temporal.a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(a().toString());
        sb.append(" ");
        sb.append(D());
        sb.append(" ");
        sb.append(t4);
        String str = "-";
        sb.append(t5 < 10 ? "-0" : str);
        sb.append(t5);
        if (t6 < 10) {
            str = "-0";
        }
        sb.append(str);
        sb.append(t6);
        return sb.toString();
    }

    public C1117b d(long j4, q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return C(a(), qVar.n(this, j4));
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    /* renamed from: E */
    public C1117b j(long j4, s sVar) {
        return C(a(), r.b(this, j4, sVar));
    }

    public long u() {
        return t(j$.time.temporal.a.EPOCH_DAY);
    }
}
