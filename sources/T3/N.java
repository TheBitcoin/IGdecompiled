package t3;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.m;

public class N {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f4480b = AtomicIntegerFieldUpdater.newUpdater(N.class, "_size");
    private volatile int _size;

    /* renamed from: a  reason: collision with root package name */
    private O[] f4481a;

    private final O[] f() {
        O[] oArr = this.f4481a;
        if (oArr == null) {
            O[] oArr2 = new O[4];
            this.f4481a = oArr2;
            return oArr2;
        } else if (c() < oArr.length) {
            return oArr;
        } else {
            Object[] copyOf = Arrays.copyOf(oArr, c() * 2);
            m.d(copyOf, "copyOf(this, newSize)");
            O[] oArr3 = (O[]) copyOf;
            this.f4481a = oArr3;
            return oArr3;
        }
    }

    private final void j(int i4) {
        f4480b.set(this, i4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0028, code lost:
        if (((java.lang.Comparable) r3).compareTo(r4) < 0) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void k(int r6) {
        /*
            r5 = this;
        L_0x0000:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.c()
            if (r1 < r2) goto L_0x000b
            goto L_0x003e
        L_0x000b:
            t3.O[] r2 = r5.f4481a
            kotlin.jvm.internal.m.b(r2)
            int r0 = r0 + 2
            int r3 = r5.c()
            if (r0 >= r3) goto L_0x002b
            r3 = r2[r0]
            kotlin.jvm.internal.m.b(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            kotlin.jvm.internal.m.b(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r0 = r1
        L_0x002c:
            r1 = r2[r6]
            kotlin.jvm.internal.m.b(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            kotlin.jvm.internal.m.b(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L_0x003f
        L_0x003e:
            return
        L_0x003f:
            r5.m(r6, r0)
            r6 = r0
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.N.k(int):void");
    }

    private final void l(int i4) {
        while (i4 > 0) {
            O[] oArr = this.f4481a;
            m.b(oArr);
            int i5 = (i4 - 1) / 2;
            O o4 = oArr[i5];
            m.b(o4);
            O o5 = oArr[i4];
            m.b(o5);
            if (((Comparable) o4).compareTo(o5) > 0) {
                m(i4, i5);
                i4 = i5;
            } else {
                return;
            }
        }
    }

    private final void m(int i4, int i5) {
        O[] oArr = this.f4481a;
        m.b(oArr);
        O o4 = oArr[i5];
        m.b(o4);
        O o5 = oArr[i4];
        m.b(o5);
        oArr[i4] = o4;
        oArr[i5] = o5;
        o4.setIndex(i4);
        o5.setIndex(i5);
    }

    public final void a(O o4) {
        o4.c(this);
        O[] f4 = f();
        int c5 = c();
        j(c5 + 1);
        f4[c5] = o4;
        o4.setIndex(c5);
        l(c5);
    }

    public final O b() {
        O[] oArr = this.f4481a;
        if (oArr != null) {
            return oArr[0];
        }
        return null;
    }

    public final int c() {
        return f4480b.get(this);
    }

    public final boolean d() {
        if (c() == 0) {
            return true;
        }
        return false;
    }

    public final O e() {
        O b5;
        synchronized (this) {
            b5 = b();
        }
        return b5;
    }

    public final boolean g(O o4) {
        boolean z4;
        synchronized (this) {
            if (o4.b() == null) {
                z4 = false;
            } else {
                h(o4.d());
                z4 = true;
            }
        }
        return z4;
    }

    public final O h(int i4) {
        O[] oArr = this.f4481a;
        m.b(oArr);
        j(c() - 1);
        if (i4 < c()) {
            m(i4, c());
            int i5 = (i4 - 1) / 2;
            if (i4 > 0) {
                O o4 = oArr[i4];
                m.b(o4);
                O o5 = oArr[i5];
                m.b(o5);
                if (((Comparable) o4).compareTo(o5) < 0) {
                    m(i4, i5);
                    l(i5);
                }
            }
            k(i4);
        }
        O o6 = oArr[c()];
        m.b(o6);
        o6.c((N) null);
        o6.setIndex(-1);
        oArr[c()] = null;
        return o6;
    }

    public final O i() {
        O o4;
        synchronized (this) {
            if (c() > 0) {
                o4 = h(0);
            } else {
                o4 = null;
            }
        }
        return o4;
    }
}
