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
import j$.time.temporal.u;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public final class C extends C1119d {
    private static final long serialVersionUID = 1300372329181994526L;

    /* renamed from: a  reason: collision with root package name */
    public final transient g f4862a;

    public final C1120e v(j jVar) {
        return new C1122g(this, jVar);
    }

    public C(g gVar) {
        Objects.requireNonNull(gVar, "isoDate");
        this.f4862a = gVar;
    }

    public final l a() {
        return A.f4860c;
    }

    public final int hashCode() {
        A.f4860c.getClass();
        return this.f4862a.hashCode() ^ -1990173233;
    }

    public final m D() {
        return J() >= 1 ? D.ROC : D.BEFORE_ROC;
    }

    public final u n(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.p(this);
        }
        if (j$.com.android.tools.r8.a.n(this, qVar)) {
            a aVar = (a) qVar;
            int i4 = B.f4861a[aVar.ordinal()];
            if (i4 == 1 || i4 == 2 || i4 == 3) {
                return this.f4862a.n(qVar);
            }
            if (i4 != 4) {
                return A.f4860c.k(aVar);
            }
            u uVar = a.YEAR.f5014b;
            return u.e(1, J() <= 0 ? (-uVar.f5039a) + 1912 : uVar.f5042d - 1911);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    public final long t(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.k(this);
        }
        int i4 = B.f4861a[((a) qVar).ordinal()];
        int i5 = 1;
        if (i4 != 4) {
            g gVar = this.f4862a;
            if (i4 == 5) {
                return ((((long) J()) * 12) + ((long) gVar.f4978b)) - 1;
            }
            if (i4 == 6) {
                return (long) J();
            }
            if (i4 != 7) {
                return gVar.t(qVar);
            }
            if (J() < 1) {
                i5 = 0;
            }
            return (long) i5;
        }
        int J4 = J();
        if (J4 < 1) {
            J4 = 1 - J4;
        }
        return (long) J4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        if (r2 != 7) goto L_0x0060;
     */
    /* renamed from: K */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.time.chrono.C d(long r9, j$.time.temporal.q r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof j$.time.temporal.a
            if (r0 == 0) goto L_0x0098
            r0 = r11
            j$.time.temporal.a r0 = (j$.time.temporal.a) r0
            long r1 = r8.t(r0)
            int r3 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r3 != 0) goto L_0x0010
            return r8
        L_0x0010:
            int[] r1 = j$.time.chrono.B.f4861a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            j$.time.g r3 = r8.f4862a
            r4 = 7
            r5 = 6
            r6 = 4
            if (r2 == r6) goto L_0x004a
            r7 = 5
            if (r2 == r7) goto L_0x0027
            if (r2 == r5) goto L_0x004a
            if (r2 == r4) goto L_0x004a
            goto L_0x0060
        L_0x0027:
            j$.time.chrono.A r11 = j$.time.chrono.A.f4860c
            j$.time.temporal.u r11 = r11.k(r0)
            r11.b(r9, r0)
            int r11 = r8.J()
            long r0 = (long) r11
            r4 = 12
            long r0 = r0 * r4
            short r11 = r3.f4978b
            long r4 = (long) r11
            long r0 = r0 + r4
            r4 = 1
            long r0 = r0 - r4
            long r9 = r9 - r0
            j$.time.g r9 = r3.O(r9)
            j$.time.chrono.C r9 = r8.L(r9)
            return r9
        L_0x004a:
            j$.time.chrono.A r2 = j$.time.chrono.A.f4860c
            j$.time.temporal.u r2 = r2.k(r0)
            int r2 = r2.a(r9, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r6) goto L_0x0083
            if (r0 == r5) goto L_0x0078
            if (r0 == r4) goto L_0x0069
        L_0x0060:
            j$.time.g r9 = r3.d(r9, r11)
            j$.time.chrono.C r9 = r8.L(r9)
            return r9
        L_0x0069:
            int r9 = r8.J()
            int r9 = 1912 - r9
            j$.time.g r9 = r3.U(r9)
            j$.time.chrono.C r9 = r8.L(r9)
            return r9
        L_0x0078:
            int r2 = r2 + 1911
            j$.time.g r9 = r3.U(r2)
            j$.time.chrono.C r9 = r8.L(r9)
            return r9
        L_0x0083:
            int r9 = r8.J()
            r10 = 1
            if (r9 < r10) goto L_0x008d
            int r2 = r2 + 1911
            goto L_0x008f
        L_0x008d:
            int r2 = 1912 - r2
        L_0x008f:
            j$.time.g r9 = r3.U(r2)
            j$.time.chrono.C r9 = r8.L(r9)
            return r9
        L_0x0098:
            j$.time.chrono.b r9 = super.d((long) r9, (j$.time.temporal.q) r11)
            j$.time.chrono.C r9 = (j$.time.chrono.C) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.C.d(long, j$.time.temporal.q):j$.time.chrono.C");
    }

    public final C1117b I(o oVar) {
        return (C) super.m(oVar);
    }

    public final m m(g gVar) {
        return (C) super.m(gVar);
    }

    public final C1117b H(long j4) {
        return L(this.f4862a.P(j4));
    }

    public final C1117b G(long j4) {
        return L(this.f4862a.O(j4));
    }

    public final C1117b F(long j4) {
        return L(this.f4862a.N(j4));
    }

    public final C1117b e(long j4, s sVar) {
        return (C) super.e(j4, sVar);
    }

    /* renamed from: e  reason: collision with other method in class */
    public final m m13e(long j4, s sVar) {
        return (C) super.e(j4, sVar);
    }

    public final C1117b E(long j4, s sVar) {
        return (C) super.j(j4, sVar);
    }

    public final m j(long j4, b bVar) {
        return (C) super.j(j4, bVar);
    }

    public final C L(g gVar) {
        return gVar.equals(this.f4862a) ? this : new C(gVar);
    }

    public final long u() {
        return this.f4862a.u();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C) {
            return this.f4862a.equals(((C) obj).f4862a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 7, this);
    }

    public final int J() {
        return this.f4862a.f4977a - 1911;
    }
}
