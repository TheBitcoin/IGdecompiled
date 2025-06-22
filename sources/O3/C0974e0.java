package o3;

import java.util.concurrent.locks.LockSupport;
import o3.C0972d0;

/* renamed from: o3.e0  reason: case insensitive filesystem */
public abstract class C0974e0 extends C0970c0 {
    /* access modifiers changed from: protected */
    public abstract Thread Q();

    /* access modifiers changed from: protected */
    public void R(long j4, C0972d0.b bVar) {
        O.f3668g.b0(j4, bVar);
    }

    /* access modifiers changed from: protected */
    public final void S() {
        Thread Q4 = Q();
        if (Thread.currentThread() != Q4) {
            C0969c.a();
            LockSupport.unpark(Q4);
        }
    }
}
