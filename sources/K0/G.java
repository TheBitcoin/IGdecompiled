package k0;

import java.util.concurrent.Executor;

final class G implements J {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3473a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f3474b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C0933h f3475c;

    public G(Executor executor, C0933h hVar) {
        this.f3473a = executor;
        this.f3475c = hVar;
    }

    public final void c(C0937l lVar) {
        if (lVar.n()) {
            synchronized (this.f3474b) {
                try {
                    if (this.f3475c != null) {
                        this.f3473a.execute(new F(this, lVar));
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
