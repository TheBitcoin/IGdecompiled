package y0;

import java.util.concurrent.CountDownLatch;
import k0.C0928c;
import k0.C0937l;

public final /* synthetic */ class b0 implements C0928c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f22626a;

    public /* synthetic */ b0(CountDownLatch countDownLatch) {
        this.f22626a = countDownLatch;
    }

    public final Object a(C0937l lVar) {
        return this.f22626a.countDown();
    }
}
