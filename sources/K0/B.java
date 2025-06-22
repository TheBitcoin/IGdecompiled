package k0;

final class B implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0937l f3461a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C f3462b;

    B(C c5, C0937l lVar) {
        this.f3462b = c5;
        this.f3461a = lVar;
    }

    public final void run() {
        synchronized (this.f3462b.f3464b) {
            try {
                C c5 = this.f3462b;
                if (c5.f3465c != null) {
                    c5.f3465c.a(this.f3461a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
