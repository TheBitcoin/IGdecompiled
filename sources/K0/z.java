package k0;

final class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ A f3519a;

    z(A a5) {
        this.f3519a = a5;
    }

    public final void run() {
        synchronized (this.f3519a.f3459b) {
            try {
                A a5 = this.f3519a;
                if (a5.f3460c != null) {
                    a5.f3460c.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
