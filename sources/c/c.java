package C;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f105a;

    /* renamed from: b  reason: collision with root package name */
    private final long f106b;

    /* renamed from: c  reason: collision with root package name */
    final CountDownLatch f107c = new CountDownLatch(1);

    /* renamed from: d  reason: collision with root package name */
    boolean f108d = false;

    public c(a aVar, long j4) {
        this.f105a = new WeakReference(aVar);
        this.f106b = j4;
        start();
    }

    private final void a() {
        a aVar = (a) this.f105a.get();
        if (aVar != null) {
            aVar.c();
            this.f108d = true;
        }
    }

    public final void run() {
        try {
            if (!this.f107c.await(this.f106b, TimeUnit.MILLISECONDS)) {
                a();
            }
        } catch (InterruptedException unused) {
            a();
        }
    }
}
