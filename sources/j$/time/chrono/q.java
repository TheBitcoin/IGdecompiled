package j$.time.chrono;

import j$.time.c;
import j$.time.g;
import j$.time.j;
import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.s;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public final class q extends C1119d {
    private static final long serialVersionUID = -5207853542612002020L;

    /* renamed from: a  reason: collision with root package name */
    public final transient o f4899a;

    /* renamed from: b  reason: collision with root package name */
    public final transient int f4900b;

    /* renamed from: c  reason: collision with root package name */
    public final transient int f4901c;

    /* renamed from: d  reason: collision with root package name */
    public final transient int f4902d;

    public final C1120e v(j jVar) {
        return new C1122g(this, jVar);
    }

    public q(o oVar, int i4, int i5, int i6) {
        oVar.n(i4, i5, i6);
        this.f4899a = oVar;
        this.f4900b = i4;
        this.f4901c = i5;
        this.f4902d = i6;
    }

    public q(o oVar, long j4) {
        int i4 = (int) j4;
        oVar.k();
        if (i4 < oVar.f4891e || i4 >= oVar.f4892f) {
            throw new RuntimeException("Hijrah date out of range");
        }
        int binarySearch = Arrays.binarySearch(oVar.f4890d, i4);
        binarySearch = binarySearch < 0 ? (-binarySearch) - 2 : binarySearch;
        int i5 = oVar.f4893g;
        int[] iArr = {(binarySearch + i5) / 12, ((i5 + binarySearch) % 12) + 1, (i4 - oVar.f4890d[binarySearch]) + 1};
        this.f4899a = oVar;
        this.f4900b = iArr[0];
        this.f4901c = iArr[1];
        this.f4902d = iArr[2];
    }

    public final l a() {
        return this.f4899a;
    }

    public final m D() {
        return r.AH;
    }

    public final int hashCode() {
        this.f4899a.getClass();
        int i4 = this.f4900b;
        return (((i4 << 11) + (this.f4901c << 6)) + this.f4902d) ^ ((i4 & -2048) ^ 2100100019);
    }

    public final u n(j$.time.temporal.q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.p(this);
        }
        if (j$.com.android.tools.r8.a.n(this, qVar)) {
            a aVar = (a) qVar;
            int i4 = p.f4898a[aVar.ordinal()];
            int i5 = this.f4900b;
            o oVar = this.f4899a;
            if (i4 == 1) {
                return u.e(1, (long) oVar.p(i5, this.f4901c));
            }
            if (i4 == 2) {
                return u.e(1, (long) oVar.C(i5, 12));
            }
            if (i4 != 3) {
                return oVar.w(aVar);
            }
            return u.e(1, 5);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    public final long t(j$.time.temporal.q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.k(this);
        }
        int i4 = p.f4898a[((a) qVar).ordinal()];
        int i5 = this.f4901c;
        int i6 = 1;
        int i7 = this.f4902d;
        int i8 = this.f4900b;
        switch (i4) {
            case 1:
                return (long) i7;
            case 2:
                return (long) J();
            case 3:
                return (long) (((i7 - 1) / 7) + 1);
            case 4:
                return (long) (((int) j$.com.android.tools.r8.a.A(u() + 3, (long) 7)) + 1);
            case 5:
                return (long) (((i7 - 1) % 7) + 1);
            case 6:
                return (long) (((J() - 1) % 7) + 1);
            case 7:
                return u();
            case 8:
                return (long) (((J() - 1) / 7) + 1);
            case 9:
                return (long) i5;
            case 10:
                return ((((long) i8) * 12) + ((long) i5)) - 1;
            case 11:
                return (long) i8;
            case 12:
                return (long) i8;
            case 13:
                if (i8 <= 1) {
                    i6 = 0;
                }
                return (long) i6;
            default:
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
    }

    /* renamed from: N */
    public final q d(long j4, j$.time.temporal.q qVar) {
        if (!(qVar instanceof a)) {
            return (q) super.d(j4, qVar);
        }
        a aVar = (a) qVar;
        o oVar = this.f4899a;
        oVar.w(aVar).b(j4, aVar);
        int i4 = (int) j4;
        int i5 = p.f4898a[aVar.ordinal()];
        int i6 = this.f4902d;
        int i7 = this.f4901c;
        int i8 = this.f4900b;
        switch (i5) {
            case 1:
                return M(i8, i7, i4);
            case 2:
                return F((long) (Math.min(i4, oVar.C(i8, 12)) - J()));
            case 3:
                return F((j4 - t(a.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                return F(j4 - ((long) (((int) j$.com.android.tools.r8.a.A(u() + 3, (long) 7)) + 1)));
            case 5:
                return F(j4 - t(a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 6:
                return F(j4 - t(a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 7:
                return new q(oVar, j4);
            case 8:
                return F((j4 - t(a.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 9:
                return M(i8, i4, i6);
            case 10:
                return G(j4 - (((((long) i8) * 12) + ((long) i7)) - 1));
            case 11:
                if (i8 < 1) {
                    i4 = 1 - i4;
                }
                return M(i4, i7, i6);
            case 12:
                return M(i4, i7, i6);
            case 13:
                return M(1 - i8, i7, i6);
            default:
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
    }

    public final q M(int i4, int i5, int i6) {
        o oVar = this.f4899a;
        int p4 = oVar.p(i4, i5);
        if (i6 > p4) {
            i6 = p4;
        }
        return new q(oVar, i4, i5, i6);
    }

    public final C1117b I(o oVar) {
        return (q) super.m(oVar);
    }

    public final m m(g gVar) {
        return (q) super.m(gVar);
    }

    public final long u() {
        return this.f4899a.n(this.f4900b, this.f4901c, this.f4902d);
    }

    public final C1117b H(long j4) {
        if (j4 == 0) {
            return this;
        }
        long j5 = ((long) this.f4900b) + ((long) ((int) j4));
        int i4 = (int) j5;
        if (j5 == ((long) i4)) {
            return M(i4, this.f4901c, this.f4902d);
        }
        throw new ArithmeticException();
    }

    /* renamed from: L */
    public final q G(long j4) {
        if (j4 == 0) {
            return this;
        }
        long j5 = (((long) this.f4900b) * 12) + ((long) (this.f4901c - 1)) + j4;
        long B4 = j$.com.android.tools.r8.a.B(j5, 12);
        o oVar = this.f4899a;
        int i4 = oVar.f4893g;
        if (B4 >= ((long) (i4 / 12)) && B4 <= ((long) ((((oVar.f4890d.length - 1) + i4) / 12) - 1))) {
            return M((int) B4, ((int) j$.com.android.tools.r8.a.A(j5, 12)) + 1, this.f4902d);
        }
        throw new RuntimeException("Invalid Hijrah year: " + B4);
    }

    /* renamed from: K */
    public final q F(long j4) {
        return new q(this.f4899a, u() + j4);
    }

    public final C1117b e(long j4, s sVar) {
        return (q) super.e(j4, sVar);
    }

    /* renamed from: e  reason: collision with other method in class */
    public final m m15e(long j4, s sVar) {
        return (q) super.e(j4, sVar);
    }

    public final C1117b E(long j4, s sVar) {
        return (q) super.j(j4, sVar);
    }

    public final m j(long j4, b bVar) {
        return (q) super.j(j4, bVar);
    }

    public final int J() {
        return this.f4899a.C(this.f4900b, this.f4901c - 1) + this.f4902d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        r5 = (j$.time.chrono.q) r5;
        r1 = r5.f4900b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof j$.time.chrono.q
            r2 = 0
            if (r1 == 0) goto L_0x0028
            j$.time.chrono.q r5 = (j$.time.chrono.q) r5
            int r1 = r5.f4900b
            int r3 = r4.f4900b
            if (r3 != r1) goto L_0x0028
            int r1 = r4.f4901c
            int r3 = r5.f4901c
            if (r1 != r3) goto L_0x0028
            int r1 = r4.f4902d
            int r3 = r5.f4902d
            if (r1 != r3) goto L_0x0028
            j$.time.chrono.o r1 = r4.f4899a
            j$.time.chrono.o r5 = r5.f4899a
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0028
            return r0
        L_0x0028:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.q.equals(java.lang.Object):boolean");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 6, this);
    }
}
