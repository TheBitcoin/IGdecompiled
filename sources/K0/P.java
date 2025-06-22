package k0;

import java.util.concurrent.Callable;

final class P implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ O f3492a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Callable f3493b;

    P(O o4, Callable callable) {
        this.f3492a = o4;
        this.f3493b = callable;
    }

    public final void run() {
        try {
            this.f3492a.r(this.f3493b.call());
        } catch (Exception e5) {
            this.f3492a.q(e5);
        } catch (Throwable th) {
            this.f3492a.q(new RuntimeException(th));
        }
    }
}
