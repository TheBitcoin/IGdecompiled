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

public final class I extends C1119d {
    private static final long serialVersionUID = -8722293800195731463L;

    /* renamed from: a  reason: collision with root package name */
    public final transient g f4869a;

    public final C1120e v(j jVar) {
        return new C1122g(this, jVar);
    }

    public I(g gVar) {
        Objects.requireNonNull(gVar, "isoDate");
        this.f4869a = gVar;
    }

    public final l a() {
        return G.f4867c;
    }

    public final int hashCode() {
        G.f4867c.getClass();
        return this.f4869a.hashCode() ^ 146118545;
    }

    public final m D() {
        return J() >= 1 ? J.BE : J.BEFORE_BE;
    }

    public final u n(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.p(this);
        }
        if (j$.com.android.tools.r8.a.n(this, qVar)) {
            a aVar = (a) qVar;
            int i4 = H.f4868a[aVar.ordinal()];
            if (i4 == 1 || i4 == 2 || i4 == 3) {
                return this.f4869a.n(qVar);
            }
            if (i4 != 4) {
                return G.f4867c.k(aVar);
            }
            u uVar = a.YEAR.f5014b;
            return u.e(1, J() <= 0 ? (-(uVar.f5039a + 543)) + 1 : 543 + uVar.f5042d);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    public final long t(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.k(this);
        }
        int i4 = H.f4868a[((a) qVar).ordinal()];
        int i5 = 1;
        if (i4 != 4) {
            g gVar = this.f4869a;
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
    public final j$.time.chrono.I d(long r9, j$.time.temporal.q r11) {
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
            int[] r1 = j$.time.chrono.H.f4868a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            j$.time.g r3 = r8.f4869a
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
            j$.time.chrono.G r11 = j$.time.chrono.G.f4867c
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
            j$.time.chrono.I r9 = r8.L(r9)
            return r9
        L_0x004a:
            j$.time.chrono.G r2 = j$.time.chrono.G.f4867c
            j$.time.temporal.u r2 = r2.k(r0)
            int r2 = r2.a(r9, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r6) goto L_0x0083
            if (r0 == r5) goto L_0x0078
            if (r0 == r4) goto L_0x0069
        L_0x0060:
            j$.time.g r9 = r3.d(r9, r11)
            j$.time.chrono.I r9 = r8.L(r9)
            return r9
        L_0x0069:
            int r9 = r8.J()
            int r9 = -542 - r9
            j$.time.g r9 = r3.U(r9)
            j$.time.chrono.I r9 = r8.L(r9)
            return r9
        L_0x0078:
            int r2 = r2 + -543
            j$.time.g r9 = r3.U(r2)
            j$.time.chrono.I r9 = r8.L(r9)
            return r9
        L_0x0083:
            int r9 = r8.J()
            r10 = 1
            if (r9 < r10) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            int r2 = 1 - r2
        L_0x008d:
            int r2 = r2 + -543
            j$.time.g r9 = r3.U(r2)
            j$.time.chrono.I r9 = r8.L(r9)
            return r9
        L_0x0098:
            j$.time.chrono.b r9 = super.d((long) r9, (j$.time.temporal.q) r11)
            j$.time.chrono.I r9 = (j$.time.chrono.I) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.I.d(long, j$.time.temporal.q):j$.time.chrono.I");
    }

    public final C1117b I(o oVar) {
        return (I) super.m(oVar);
    }

    public final m m(g gVar) {
        return (I) super.m(gVar);
    }

    public final C1117b H(long j4) {
        return L(this.f4869a.P(j4));
    }

    public final C1117b G(long j4) {
        return L(this.f4869a.O(j4));
    }

    public final C1117b F(long j4) {
        return L(this.f4869a.N(j4));
    }

    public final C1117b e(long j4, s sVar) {
        return (I) super.e(j4, sVar);
    }

    /* renamed from: e  reason: collision with other method in class */
    public final m m14e(long j4, s sVar) {
        return (I) super.e(j4, sVar);
    }

    public final C1117b E(long j4, s sVar) {
        return (I) super.j(j4, sVar);
    }

    public final m j(long j4, b bVar) {
        return (I) super.j(j4, bVar);
    }

    public final I L(g gVar) {
        return gVar.equals(this.f4869a) ? this : new I(gVar);
    }

    public final long u() {
        return this.f4869a.u();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof I) {
            return this.f4869a.equals(((I) obj).f4869a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 8, this);
    }

    public final int J() {
        return this.f4869a.f4977a + 543;
    }
}
