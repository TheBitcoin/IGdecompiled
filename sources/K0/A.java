package k0;

import java.util.concurrent.Executor;

final class A implements J {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3458a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f3459b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C0930e f3460c;

    public A(Executor executor, C0930e eVar) {
        this.f3458a = executor;
        this.f3460c = eVar;
    }

    public final void c(C0937l lVar) {
        if (lVar.l()) {
            synchronized (this.f3459b) {
                try {
                    if (this.f3460c != null) {
                        this.f3458a.execute(new z(this));
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
