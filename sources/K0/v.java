package k0;

final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0937l f3509a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ w f3510b;

    v(w wVar, C0937l lVar) {
        this.f3510b = wVar;
        this.f3509a = lVar;
    }

    public final void run() {
        if (this.f3509a.l()) {
            this.f3510b.f3513c.s();
            return;
        }
        try {
            this.f3510b.f3513c.r(this.f3510b.f3512b.a(this.f3509a));
        } catch (C0935j e5) {
            if (e5.getCause() instanceof Exception) {
                this.f3510b.f3513c.q((Exception) e5.getCause());
            } else {
                this.f3510b.f3513c.q(e5);
            }
        } catch (Exception e6) {
            this.f3510b.f3513c.q(e6);
        }
    }
}
