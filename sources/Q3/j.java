package q3;

import V2.g;
import d3.l;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.m;
import o3.W0;
import t3.C;
import t3.F;
import t3.x;

public final class j extends C {

    /* renamed from: e  reason: collision with root package name */
    private final b f4095e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReferenceArray f4096f = new AtomicReferenceArray(c.f4068b * 2);

    public j(long j4, j jVar, b bVar, int i4) {
        super(j4, jVar, i4);
        this.f4095e = bVar;
    }

    private final void z(int i4, Object obj) {
        this.f4096f.lazySet(i4 * 2, obj);
    }

    public final void A(int i4, Object obj) {
        this.f4096f.set((i4 * 2) + 1, obj);
    }

    public final void B(int i4, Object obj) {
        z(i4, obj);
    }

    public int n() {
        return c.f4068b;
    }

    public void o(int i4, Throwable th, g gVar) {
        boolean z4;
        F f4;
        l lVar;
        l lVar2;
        int i5 = c.f4068b;
        if (i4 >= i5) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            i4 -= i5;
        }
        Object v4 = v(i4);
        while (true) {
            Object w4 = w(i4);
            if ((w4 instanceof W0) || (w4 instanceof w)) {
                if (z4) {
                    f4 = c.f4076j;
                } else {
                    f4 = c.f4077k;
                }
                if (r(i4, w4, f4)) {
                    s(i4);
                    x(i4, !z4);
                    if (z4 && (lVar = u().f4049b) != null) {
                        x.b(lVar, v4, gVar);
                        return;
                    }
                    return;
                }
            } else if (w4 == c.f4076j || w4 == c.f4077k) {
                s(i4);
            } else if (!(w4 == c.f4073g || w4 == c.f4072f)) {
                if (w4 != c.f4075i && w4 != c.f4070d && w4 != c.z()) {
                    throw new IllegalStateException(("unexpected state: " + w4).toString());
                }
                return;
            }
        }
        s(i4);
        if (z4 && (lVar2 = u().f4049b) != null) {
            x.b(lVar2, v4, gVar);
        }
    }

    public final boolean r(int i4, Object obj, Object obj2) {
        return i.a(this.f4096f, (i4 * 2) + 1, obj, obj2);
    }

    public final void s(int i4) {
        z(i4, (Object) null);
    }

    public final Object t(int i4, Object obj) {
        return this.f4096f.getAndSet((i4 * 2) + 1, obj);
    }

    public final b u() {
        b bVar = this.f4095e;
        m.b(bVar);
        return bVar;
    }

    public final Object v(int i4) {
        return this.f4096f.get(i4 * 2);
    }

    public final Object w(int i4) {
        return this.f4096f.get((i4 * 2) + 1);
    }

    public final void x(int i4, boolean z4) {
        if (z4) {
            u().N0((this.f4463c * ((long) c.f4068b)) + ((long) i4));
        }
        p();
    }

    public final Object y(int i4) {
        Object v4 = v(i4);
        s(i4);
        return v4;
    }
}
