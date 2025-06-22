package k0;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class r implements s {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f3499a = new CountDownLatch(1);

    /* synthetic */ r(q qVar) {
    }

    public final void a(Object obj) {
        this.f3499a.countDown();
    }

    public final void b() {
        this.f3499a.countDown();
    }

    public final void c() {
        this.f3499a.await();
    }

    public final void d(Exception exc) {
        this.f3499a.countDown();
    }

    public final boolean e(long j4, TimeUnit timeUnit) {
        return this.f3499a.await(j4, timeUnit);
    }
}
