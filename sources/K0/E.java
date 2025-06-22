package k0;

import java.util.concurrent.Executor;

final class E implements J {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3468a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f3469b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C0932g f3470c;

    public E(Executor executor, C0932g gVar) {
        this.f3468a = executor;
        this.f3470c = gVar;
    }

    public final void c(C0937l lVar) {
        if (!lVar.n() && !lVar.l()) {
            synchronized (this.f3469b) {
                try {
                    if (this.f3470c != null) {
                        this.f3468a.execute(new D(this, lVar));
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }
}
