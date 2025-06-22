package o3;

import V2.d;
import V2.g;
import W2.b;
import d3.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import t3.B;
import t3.C1061k;

public final class V extends B {

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f3678e = AtomicIntegerFieldUpdater.newUpdater(V.class, "_decision");
    private volatile int _decision;

    public V(g gVar, d dVar) {
        super(gVar, dVar);
    }

    private final boolean Q0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f3678e;
        do {
            int i4 = atomicIntegerFieldUpdater.get(this);
            if (i4 != 0) {
                if (i4 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f3678e.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean R0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f3678e;
        do {
            int i4 = atomicIntegerFieldUpdater.get(this);
            if (i4 != 0) {
                if (i4 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f3678e.compareAndSet(this, 0, 1));
        return true;
    }

    /* access modifiers changed from: protected */
    public void J(Object obj) {
        L0(obj);
    }

    /* access modifiers changed from: protected */
    public void L0(Object obj) {
        if (!Q0()) {
            C1061k.c(b.b(this.f4461d), E.a(obj, this.f4461d), (l) null, 2, (Object) null);
        }
    }

    public final Object P0() {
        if (R0()) {
            return b.c();
        }
        Object h4 = B0.h(f0());
        if (!(h4 instanceof A)) {
            return h4;
        }
        throw ((A) h4).f3624a;
    }
}
