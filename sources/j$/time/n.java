package j$.time;

import j$.time.chrono.s;
import j$.time.format.t;
import j$.time.temporal.a;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

public final class n implements j$.time.temporal.n, o, Comparable, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f4995c = 0;
    private static final long serialVersionUID = -939150713474957432L;

    /* renamed from: a  reason: collision with root package name */
    public final int f4996a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4997b;

    public final int compareTo(Object obj) {
        n nVar = (n) obj;
        int i4 = this.f4996a - nVar.f4996a;
        return i4 == 0 ? this.f4997b - nVar.f4997b : i4;
    }

    static {
        j$.time.format.n nVar = new j$.time.format.n();
        nVar.d("--");
        nVar.g(a.MONTH_OF_YEAR, 2);
        nVar.c('-');
        nVar.g(a.DAY_OF_MONTH, 2);
        nVar.l(Locale.getDefault(), t.SMART, (s) null);
    }

    public n(int i4, int i5) {
        this.f4996a = i4;
        this.f4997b = i5;
    }

    public final boolean f(q qVar) {
        return qVar instanceof a ? qVar == a.MONTH_OF_YEAR || qVar == a.DAY_OF_MONTH : qVar != null && qVar.m(this);
    }

    public final u n(q qVar) {
        if (qVar == a.MONTH_OF_YEAR) {
            return qVar.j();
        }
        if (qVar != a.DAY_OF_MONTH) {
            return r.d(this, qVar);
        }
        int i4 = this.f4996a;
        l F4 = l.F(i4);
        F4.getClass();
        int i5 = k.f4991a[F4.ordinal()];
        return u.f((long) (i5 != 1 ? (i5 == 2 || i5 == 3 || i5 == 4 || i5 == 5) ? 30 : 31 : 28), (long) l.F(i4).E());
    }

    public final int k(q qVar) {
        return n(qVar).a(t(qVar), qVar);
    }

    public final long t(q qVar) {
        int i4;
        if (!(qVar instanceof a)) {
            return qVar.k(this);
        }
        int i5 = m.f4994a[((a) qVar).ordinal()];
        if (i5 == 1) {
            i4 = this.f4997b;
        } else if (i5 == 2) {
            i4 = this.f4996a;
        } else {
            throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
        return (long) i4;
    }

    public final Object p(j$.time.format.a aVar) {
        if (aVar == r.f5033b) {
            return s.f4904c;
        }
        return r.c(this, aVar);
    }

    public final m w(m mVar) {
        if (j$.com.android.tools.r8.a.v(mVar).equals(s.f4904c)) {
            m d5 = mVar.d((long) this.f4996a, a.MONTH_OF_YEAR);
            a aVar = a.DAY_OF_MONTH;
            return d5.d(Math.min(d5.n(aVar).f5042d, (long) this.f4997b), aVar);
        }
        throw new RuntimeException("Adjustment only supported on ISO date-time");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        r5 = (j$.time.n) r5;
        r1 = r5.f4996a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof j$.time.n
            r2 = 0
            if (r1 == 0) goto L_0x0018
            j$.time.n r5 = (j$.time.n) r5
            int r1 = r5.f4996a
            int r3 = r4.f4996a
            if (r3 != r1) goto L_0x0018
            int r1 = r4.f4997b
            int r5 = r5.f4997b
            if (r1 != r5) goto L_0x0018
            return r0
        L_0x0018:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.n.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return (this.f4996a << 6) + this.f4997b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        int i4 = this.f4996a;
        sb.append(i4 < 10 ? "0" : "");
        sb.append(i4);
        int i5 = this.f4997b;
        sb.append(i5 < 10 ? "-0" : "-");
        sb.append(i5);
        return sb.toString();
    }

    private Object writeReplace() {
        return new r((byte) 13, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
