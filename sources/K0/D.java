package k0;

import M.C0335p;

final class D implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0937l f3466a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ E f3467b;

    D(E e5, C0937l lVar) {
        this.f3467b = e5;
        this.f3466a = lVar;
    }

    public final void run() {
        synchronized (this.f3467b.f3469b) {
            try {
                E e5 = this.f3467b;
                if (e5.f3470c != null) {
                    e5.f3470c.d((Exception) C0335p.l(this.f3466a.i()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
