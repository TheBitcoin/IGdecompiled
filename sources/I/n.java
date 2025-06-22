package I;

import java.util.concurrent.CountDownLatch;
import k0.C0931f;
import k0.C0937l;

public final /* synthetic */ class n implements C0931f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f264a;

    public /* synthetic */ n(CountDownLatch countDownLatch) {
        this.f264a = countDownLatch;
    }

    public final void a(C0937l lVar) {
        this.f264a.countDown();
    }
}
