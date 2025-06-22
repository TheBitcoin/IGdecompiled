package j$.time;

import j$.time.chrono.s;
import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.u;

public enum l implements n, o {
    ;
    

    /* renamed from: a  reason: collision with root package name */
    public static final l[] f4992a = null;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: j$.time.l[]} */
    /* JADX WARNING: type inference failed for: r12v0, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r13v1, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r14v1, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r15v1, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r9v2, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r8v2, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r7v2, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r6v2, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r5v2, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 11
            r1 = 10
            r2 = 9
            r3 = 8
            r4 = 7
            r5 = 6
            r6 = 5
            r7 = 4
            r8 = 3
            r9 = 2
            r10 = 1
            r11 = 0
            j$.time.l r12 = new j$.time.l
            java.lang.String r13 = "JANUARY"
            r12.<init>(r13, r11)
            JANUARY = r12
            j$.time.l r13 = new j$.time.l
            java.lang.String r14 = "FEBRUARY"
            r13.<init>(r14, r10)
            FEBRUARY = r13
            j$.time.l r14 = new j$.time.l
            java.lang.String r15 = "MARCH"
            r14.<init>(r15, r9)
            MARCH = r14
            j$.time.l r15 = new j$.time.l
            r16 = 2
            java.lang.String r9 = "APRIL"
            r15.<init>(r9, r8)
            APRIL = r15
            j$.time.l r9 = new j$.time.l
            r17 = 3
            java.lang.String r8 = "MAY"
            r9.<init>(r8, r7)
            MAY = r9
            j$.time.l r8 = new j$.time.l
            r18 = 4
            java.lang.String r7 = "JUNE"
            r8.<init>(r7, r6)
            JUNE = r8
            j$.time.l r7 = new j$.time.l
            r19 = 5
            java.lang.String r6 = "JULY"
            r7.<init>(r6, r5)
            JULY = r7
            j$.time.l r6 = new j$.time.l
            r20 = 6
            java.lang.String r5 = "AUGUST"
            r6.<init>(r5, r4)
            AUGUST = r6
            j$.time.l r5 = new j$.time.l
            r21 = 7
            java.lang.String r4 = "SEPTEMBER"
            r5.<init>(r4, r3)
            SEPTEMBER = r5
            j$.time.l r4 = new j$.time.l
            r22 = 8
            java.lang.String r3 = "OCTOBER"
            r4.<init>(r3, r2)
            OCTOBER = r4
            j$.time.l r3 = new j$.time.l
            r23 = 9
            java.lang.String r2 = "NOVEMBER"
            r3.<init>(r2, r1)
            NOVEMBER = r3
            j$.time.l r2 = new j$.time.l
            r24 = 10
            java.lang.String r1 = "DECEMBER"
            r2.<init>(r1, r0)
            DECEMBER = r2
            r1 = 12
            j$.time.l[] r1 = new j$.time.l[r1]
            r1[r11] = r12
            r1[r10] = r13
            r1[r16] = r14
            r1[r17] = r15
            r1[r18] = r9
            r1[r19] = r8
            r1[r20] = r7
            r1[r21] = r6
            r1[r22] = r5
            r1[r23] = r4
            r1[r24] = r3
            r1[r0] = r2
            f4993b = r1
            j$.time.l[] r0 = values()
            f4992a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.l.<clinit>():void");
    }

    public static l F(int i4) {
        if (i4 >= 1 && i4 <= 12) {
            return f4992a[i4 - 1];
        }
        throw new RuntimeException("Invalid value for MonthOfYear: " + i4);
    }

    public final int getValue() {
        return ordinal() + 1;
    }

    public final boolean f(q qVar) {
        return qVar instanceof a ? qVar == a.MONTH_OF_YEAR : qVar != null && qVar.m(this);
    }

    public final u n(q qVar) {
        if (qVar == a.MONTH_OF_YEAR) {
            return qVar.j();
        }
        return r.d(this, qVar);
    }

    public final int k(q qVar) {
        if (qVar == a.MONTH_OF_YEAR) {
            return getValue();
        }
        return r.a(this, qVar);
    }

    public final long t(q qVar) {
        if (qVar == a.MONTH_OF_YEAR) {
            return (long) getValue();
        }
        if (!(qVar instanceof a)) {
            return qVar.k(this);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    public final int D(boolean z4) {
        int i4 = k.f4991a[ordinal()];
        return i4 != 1 ? (i4 == 2 || i4 == 3 || i4 == 4 || i4 == 5) ? 30 : 31 : z4 ? 29 : 28;
    }

    public final int E() {
        int i4 = k.f4991a[ordinal()];
        if (i4 != 1) {
            return (i4 == 2 || i4 == 3 || i4 == 4 || i4 == 5) ? 30 : 31;
        }
        return 29;
    }

    public final int C(boolean z4) {
        switch (k.f4991a[ordinal()]) {
            case 1:
                return 32;
            case 2:
                return (z4 ? 1 : 0) + true;
            case 3:
                return z4 + true;
            case 4:
                return z4 + true;
            case 5:
                return z4 + true;
            case 6:
                return 1;
            case 7:
                return z4 + true;
            case 8:
                return z4 + true;
            case 9:
                return z4 + true;
            case 10:
                return z4 + true;
            case 11:
                return z4 + true;
            default:
                return z4 + true;
        }
    }

    public final Object p(j$.time.format.a aVar) {
        if (aVar == r.f5033b) {
            return s.f4904c;
        }
        if (aVar == r.f5034c) {
            return b.MONTHS;
        }
        return r.c(this, aVar);
    }

    public final m w(m mVar) {
        if (j$.com.android.tools.r8.a.v(mVar).equals(s.f4904c)) {
            return mVar.d((long) getValue(), a.MONTH_OF_YEAR);
        }
        throw new RuntimeException("Adjustment only supported on ISO date-time");
    }
}
