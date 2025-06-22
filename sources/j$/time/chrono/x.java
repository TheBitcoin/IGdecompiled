package j$.time.chrono;

import j$.time.c;
import j$.time.g;
import j$.time.j;
import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.s;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public final class x extends C1119d {

    /* renamed from: d  reason: collision with root package name */
    public static final g f4909d = g.K(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;

    /* renamed from: a  reason: collision with root package name */
    public final transient g f4910a;

    /* renamed from: b  reason: collision with root package name */
    public final transient y f4911b;

    /* renamed from: c  reason: collision with root package name */
    public final transient int f4912c;

    public final C1120e v(j jVar) {
        return new C1122g(this, jVar);
    }

    public x(g gVar) {
        g gVar2 = f4909d;
        if (!(!c.b(gVar2) ? gVar.u() < gVar2.u() : gVar.C(gVar2) < 0)) {
            y i4 = y.i(gVar);
            this.f4911b = i4;
            this.f4912c = (gVar.f4977a - i4.f4916b.f4977a) + 1;
            this.f4910a = gVar;
            return;
        }
        throw new RuntimeException("JapaneseDate before Meiji 6 is not supported");
    }

    public final l a() {
        return v.f4907c;
    }

    public final int hashCode() {
        v.f4907c.getClass();
        return this.f4910a.hashCode() ^ -688086063;
    }

    public final m D() {
        return this.f4911b;
    }

    public final boolean f(q qVar) {
        if (qVar == a.ALIGNED_DAY_OF_WEEK_IN_MONTH || qVar == a.ALIGNED_DAY_OF_WEEK_IN_YEAR || qVar == a.ALIGNED_WEEK_OF_MONTH || qVar == a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        if (qVar instanceof a) {
            return ((a) qVar).t();
        }
        return qVar != null && qVar.m(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.time.temporal.u n(j$.time.temporal.q r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof j$.time.temporal.a
            if (r0 == 0) goto L_0x0091
            boolean r0 = r7.f(r8)
            if (r0 == 0) goto L_0x0085
            j$.time.temporal.a r8 = (j$.time.temporal.a) r8
            int[] r0 = j$.time.chrono.w.f4908a
            int r1 = r8.ordinal()
            r0 = r0[r1]
            j$.time.g r1 = r7.f4910a
            r2 = 1
            r3 = 1
            if (r0 == r2) goto L_0x007b
            j$.time.chrono.y r5 = r7.f4911b
            r6 = 2
            if (r0 == r6) goto L_0x004a
            r1 = 3
            if (r0 == r1) goto L_0x002a
            j$.time.chrono.v r0 = j$.time.chrono.v.f4907c
            j$.time.temporal.u r8 = r0.k(r8)
            return r8
        L_0x002a:
            j$.time.g r8 = r5.f4916b
            j$.time.chrono.y r0 = r5.l()
            int r8 = r8.f4977a
            if (r0 == 0) goto L_0x0040
            j$.time.g r0 = r0.f4916b
            int r0 = r0.f4977a
            int r0 = r0 - r8
            int r0 = r0 + r2
            long r0 = (long) r0
            j$.time.temporal.u r8 = j$.time.temporal.u.e(r3, r0)
            return r8
        L_0x0040:
            r0 = 999999999(0x3b9ac9ff, float:0.004723787)
            int r0 = r0 - r8
            long r0 = (long) r0
            j$.time.temporal.u r8 = j$.time.temporal.u.e(r3, r0)
            return r8
        L_0x004a:
            j$.time.chrono.y r8 = r5.l()
            if (r8 == 0) goto L_0x005e
            j$.time.g r8 = r8.f4916b
            int r0 = r1.f4977a
            int r6 = r8.f4977a
            if (r6 != r0) goto L_0x005e
            int r8 = r8.H()
            int r8 = r8 - r2
            goto L_0x0069
        L_0x005e:
            boolean r8 = r1.I()
            if (r8 == 0) goto L_0x0067
            r8 = 366(0x16e, float:5.13E-43)
            goto L_0x0069
        L_0x0067:
            r8 = 365(0x16d, float:5.11E-43)
        L_0x0069:
            int r0 = r7.f4912c
            if (r0 != r2) goto L_0x0075
            j$.time.g r0 = r5.f4916b
            int r0 = r0.H()
            int r0 = r0 - r2
            int r8 = r8 - r0
        L_0x0075:
            long r0 = (long) r8
            j$.time.temporal.u r8 = j$.time.temporal.u.e(r3, r0)
            return r8
        L_0x007b:
            int r8 = r1.J()
            long r0 = (long) r8
            j$.time.temporal.u r8 = j$.time.temporal.u.e(r3, r0)
            return r8
        L_0x0085:
            j$.time.temporal.t r0 = new j$.time.temporal.t
            java.lang.String r1 = "Unsupported field: "
            java.lang.String r8 = j$.time.c.a(r1, r8)
            r0.<init>(r8)
            throw r0
        L_0x0091:
            j$.time.temporal.u r8 = r8.p(r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.x.n(j$.time.temporal.q):j$.time.temporal.u");
    }

    public final long t(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.k(this);
        }
        int i4 = w.f4908a[((a) qVar).ordinal()];
        int i5 = this.f4912c;
        y yVar = this.f4911b;
        g gVar = this.f4910a;
        switch (i4) {
            case 2:
                if (i5 == 1) {
                    return (long) ((gVar.H() - yVar.f4916b.H()) + 1);
                }
                return (long) gVar.H();
            case 3:
                return (long) i5;
            case 4:
            case 5:
            case 6:
            case 7:
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
            case 8:
                return (long) yVar.f4915a;
            default:
                return gVar.t(qVar);
        }
    }

    /* renamed from: J */
    public final x d(long j4, q qVar) {
        if (!(qVar instanceof a)) {
            return (x) super.d(j4, qVar);
        }
        a aVar = (a) qVar;
        if (t(aVar) == j4) {
            return this;
        }
        int[] iArr = w.f4908a;
        int i4 = iArr[aVar.ordinal()];
        g gVar = this.f4910a;
        if (i4 == 3 || i4 == 8 || i4 == 9) {
            int a5 = v.f4907c.k(aVar).a(j4, aVar);
            int i5 = iArr[aVar.ordinal()];
            if (i5 == 3) {
                return L(this.f4911b, a5);
            }
            if (i5 == 8) {
                return L(y.o(a5), this.f4912c);
            }
            if (i5 == 9) {
                return K(gVar.U(a5));
            }
        }
        return K(gVar.d(j4, qVar));
    }

    public final C1117b I(o oVar) {
        return (x) super.m(oVar);
    }

    public final m m(g gVar) {
        return (x) super.m(gVar);
    }

    public final x L(y yVar, int i4) {
        v.f4907c.getClass();
        if (yVar != null) {
            int i5 = yVar.f4916b.f4977a;
            int i6 = (i5 + i4) - 1;
            if (i4 == 1 || (i6 >= -999999999 && i6 <= 999999999 && i6 >= i5 && yVar == y.i(g.K(i6, 1, 1)))) {
                return K(this.f4910a.U(i6));
            }
            throw new RuntimeException("Invalid yearOfEra value");
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    public final C1117b H(long j4) {
        return K(this.f4910a.P(j4));
    }

    public final C1117b G(long j4) {
        return K(this.f4910a.O(j4));
    }

    public final C1117b F(long j4) {
        return K(this.f4910a.N(j4));
    }

    public final C1117b e(long j4, s sVar) {
        return (x) super.e(j4, sVar);
    }

    /* renamed from: e  reason: collision with other method in class */
    public final m m16e(long j4, s sVar) {
        return (x) super.e(j4, sVar);
    }

    public final C1117b E(long j4, s sVar) {
        return (x) super.j(j4, sVar);
    }

    public final m j(long j4, b bVar) {
        return (x) super.j(j4, bVar);
    }

    public final x K(g gVar) {
        return gVar.equals(this.f4910a) ? this : new x(gVar);
    }

    public final long u() {
        return this.f4910a.u();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return this.f4910a.equals(((x) obj).f4910a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 4, this);
    }
}
