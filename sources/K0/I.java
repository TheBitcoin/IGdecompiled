package k0;

import java.util.concurrent.Executor;

final class I implements C0933h, C0932g, C0930e, J {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3478a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C0936k f3479b;

    /* renamed from: c  reason: collision with root package name */
    private final O f3480c;

    public I(Executor executor, C0936k kVar, O o4) {
        this.f3478a = executor;
        this.f3479b = kVar;
        this.f3480c = o4;
    }

    public final void a(Object obj) {
        this.f3480c.r(obj);
    }

    public final void b() {
        this.f3480c.s();
    }

    public final void c(C0937l lVar) {
        this.f3478a.execute(new H(this, lVar));
    }

    public final void d(Exception exc) {
        this.f3480c.q(exc);
    }
}
