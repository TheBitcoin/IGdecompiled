package k0;

import java.util.concurrent.Executor;

final class y implements C0933h, C0932g, C0930e, J {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3516a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C0928c f3517b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final O f3518c;

    public y(Executor executor, C0928c cVar, O o4) {
        this.f3516a = executor;
        this.f3517b = cVar;
        this.f3518c = o4;
    }

    public final void a(Object obj) {
        this.f3518c.r(obj);
    }

    public final void b() {
        this.f3518c.s();
    }

    public final void c(C0937l lVar) {
        this.f3516a.execute(new x(this, lVar));
    }

    public final void d(Exception exc) {
        this.f3518c.q(exc);
    }
}
