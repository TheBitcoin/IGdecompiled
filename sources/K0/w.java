package k0;

import java.util.concurrent.Executor;

final class w implements J {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3511a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C0928c f3512b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final O f3513c;

    public w(Executor executor, C0928c cVar, O o4) {
        this.f3511a = executor;
        this.f3512b = cVar;
        this.f3513c = o4;
    }

    public final void c(C0937l lVar) {
        this.f3511a.execute(new v(this, lVar));
    }
}
