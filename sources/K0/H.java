package k0;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class H implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0937l f3476a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ I f3477b;

    H(I i4, C0937l lVar) {
        this.f3477b = i4;
        this.f3476a = lVar;
    }

    public final void run() {
        try {
            C0937l a5 = this.f3477b.f3479b.a(this.f3476a.j());
            if (a5 == null) {
                this.f3477b.d(new NullPointerException("Continuation returned null"));
                return;
            }
            I i4 = this.f3477b;
            Executor executor = C0939n.f3497b;
            a5.f(executor, i4);
            a5.d(executor, this.f3477b);
            a5.a(executor, this.f3477b);
        } catch (C0935j e5) {
            if (e5.getCause() instanceof Exception) {
                this.f3477b.d((Exception) e5.getCause());
            } else {
                this.f3477b.d(e5);
            }
        } catch (CancellationException unused) {
            this.f3477b.b();
        } catch (Exception e6) {
            this.f3477b.d(e6);
        }
    }
}
