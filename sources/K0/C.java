package k0;

import java.util.concurrent.Executor;

final class C implements J {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3463a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f3464b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C0931f f3465c;

    public C(Executor executor, C0931f fVar) {
        this.f3463a = executor;
        this.f3465c = fVar;
    }

    public final void c(C0937l lVar) {
        synchronized (this.f3464b) {
            try {
                if (this.f3465c != null) {
                    this.f3463a.execute(new B(this, lVar));
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }
}
