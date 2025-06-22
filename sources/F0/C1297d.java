package F0;

import java.util.concurrent.CountDownLatch;

/* renamed from: F0.d  reason: case insensitive filesystem */
public final /* synthetic */ class C1297d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1298e f6431a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f6432b;

    public /* synthetic */ C1297d(C1298e eVar, CountDownLatch countDownLatch) {
        this.f6431a = eVar;
        this.f6432b = countDownLatch;
    }

    public final void run() {
        C1298e.b(this.f6431a, this.f6432b);
    }
}
