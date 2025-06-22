package t3;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f4516a = AtomicReferenceFieldUpdater.newUpdater(r.class, Object.class, "_cur");
    private volatile Object _cur;

    public r(boolean z4) {
        this._cur = new s(8, z4);
    }

    public final boolean a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4516a;
        while (true) {
            s sVar = (s) atomicReferenceFieldUpdater.get(this);
            int a5 = sVar.a(obj);
            if (a5 == 0) {
                return true;
            }
            if (a5 == 1) {
                a.a(f4516a, this, sVar, sVar.i());
            } else if (a5 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4516a;
        while (true) {
            s sVar = (s) atomicReferenceFieldUpdater.get(this);
            if (!sVar.d()) {
                a.a(f4516a, this, sVar, sVar.i());
            } else {
                return;
            }
        }
    }

    public final int c() {
        return ((s) f4516a.get(this)).f();
    }

    public final Object d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4516a;
        while (true) {
            s sVar = (s) atomicReferenceFieldUpdater.get(this);
            Object j4 = sVar.j();
            if (j4 != s.f4520h) {
                return j4;
            }
            a.a(f4516a, this, sVar, sVar.i());
        }
    }
}
