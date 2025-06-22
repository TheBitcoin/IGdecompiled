package j$.time;

import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.u;

public enum d implements n, o {
    ;
    

    /* renamed from: a  reason: collision with root package name */
    public static final d[] f4919a = null;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: j$.time.d[]} */
    /* JADX WARNING: type inference failed for: r7v0, types: [java.lang.Enum, j$.time.d] */
    /* JADX WARNING: type inference failed for: r8v1, types: [java.lang.Enum, j$.time.d] */
    /* JADX WARNING: type inference failed for: r9v1, types: [java.lang.Enum, j$.time.d] */
    /* JADX WARNING: type inference failed for: r10v1, types: [java.lang.Enum, j$.time.d] */
    /* JADX WARNING: type inference failed for: r11v1, types: [java.lang.Enum, j$.time.d] */
    /* JADX WARNING: type inference failed for: r12v1, types: [java.lang.Enum, j$.time.d] */
    /* JADX WARNING: type inference failed for: r13v1, types: [java.lang.Enum, j$.time.d] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 6
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            j$.time.d r7 = new j$.time.d
            java.lang.String r8 = "MONDAY"
            r7.<init>(r8, r6)
            MONDAY = r7
            j$.time.d r8 = new j$.time.d
            java.lang.String r9 = "TUESDAY"
            r8.<init>(r9, r5)
            TUESDAY = r8
            j$.time.d r9 = new j$.time.d
            java.lang.String r10 = "WEDNESDAY"
            r9.<init>(r10, r4)
            WEDNESDAY = r9
            j$.time.d r10 = new j$.time.d
            java.lang.String r11 = "THURSDAY"
            r10.<init>(r11, r3)
            THURSDAY = r10
            j$.time.d r11 = new j$.time.d
            java.lang.String r12 = "FRIDAY"
            r11.<init>(r12, r2)
            FRIDAY = r11
            j$.time.d r12 = new j$.time.d
            java.lang.String r13 = "SATURDAY"
            r12.<init>(r13, r1)
            SATURDAY = r12
            j$.time.d r13 = new j$.time.d
            java.lang.String r14 = "SUNDAY"
            r13.<init>(r14, r0)
            SUNDAY = r13
            r14 = 7
            j$.time.d[] r14 = new j$.time.d[r14]
            r14[r6] = r7
            r14[r5] = r8
            r14[r4] = r9
            r14[r3] = r10
            r14[r2] = r11
            r14[r1] = r12
            r14[r0] = r13
            f4920b = r14
            j$.time.d[] r0 = values()
            f4919a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.d.<clinit>():void");
    }

    public static d C(int i4) {
        if (i4 >= 1 && i4 <= 7) {
            return f4919a[i4 - 1];
        }
        throw new RuntimeException("Invalid value for DayOfWeek: " + i4);
    }

    public final int getValue() {
        return ordinal() + 1;
    }

    public final boolean f(q qVar) {
        return qVar instanceof a ? qVar == a.DAY_OF_WEEK : qVar != null && qVar.m(this);
    }

    public final u n(q qVar) {
        if (qVar == a.DAY_OF_WEEK) {
            return qVar.j();
        }
        return r.d(this, qVar);
    }

    public final int k(q qVar) {
        if (qVar == a.DAY_OF_WEEK) {
            return getValue();
        }
        return r.a(this, qVar);
    }

    public final long t(q qVar) {
        if (qVar == a.DAY_OF_WEEK) {
            return (long) getValue();
        }
        if (!(qVar instanceof a)) {
            return qVar.k(this);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    public final Object p(j$.time.format.a aVar) {
        if (aVar == r.f5034c) {
            return b.DAYS;
        }
        return r.c(this, aVar);
    }

    public final m w(m mVar) {
        return mVar.d((long) getValue(), a.DAY_OF_WEEK);
    }
}
