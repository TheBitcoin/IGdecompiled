package o3;

import R2.s;
import d3.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: o3.q0  reason: case insensitive filesystem */
final class C0998q0 extends C1005u0 {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f3722f = AtomicIntegerFieldUpdater.newUpdater(C0998q0.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: e  reason: collision with root package name */
    private final l f3723e;

    public C0998q0(l lVar) {
        this.f3723e = lVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        r((Throwable) obj);
        return s.f8222a;
    }

    public void r(Throwable th) {
        if (f3722f.compareAndSet(this, 0, 1)) {
            this.f3723e.invoke(th);
        }
    }
}
