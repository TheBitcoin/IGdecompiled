package k0;

final class F implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0937l f3471a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ G f3472b;

    F(G g4, C0937l lVar) {
        this.f3472b = g4;
        this.f3471a = lVar;
    }

    public final void run() {
        synchronized (this.f3472b.f3474b) {
            try {
                G g4 = this.f3472b;
                if (g4.f3475c != null) {
                    g4.f3475c.a(this.f3471a.j());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
