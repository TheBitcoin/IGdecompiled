package k0;

import java.util.concurrent.Executor;

final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0937l f3514a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ y f3515b;

    x(y yVar, C0937l lVar) {
        this.f3515b = yVar;
        this.f3514a = lVar;
    }

    public final void run() {
        try {
            C0937l lVar = (C0937l) this.f3515b.f3517b.a(this.f3514a);
            if (lVar == null) {
                this.f3515b.d(new NullPointerException("Continuation returned null"));
                return;
            }
            y yVar = this.f3515b;
            Executor executor = C0939n.f3497b;
            lVar.f(executor, yVar);
            lVar.d(executor, this.f3515b);
            lVar.a(executor, this.f3515b);
        } catch (C0935j e5) {
            if (e5.getCause() instanceof Exception) {
                this.f3515b.f3518c.q((Exception) e5.getCause());
            } else {
                this.f3515b.f3518c.q(e5);
            }
        } catch (Exception e6) {
            this.f3515b.f3518c.q(e6);
        }
    }
}
