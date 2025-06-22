package o3;

import R2.s;
import java.util.concurrent.Future;

/* renamed from: o3.j  reason: case insensitive filesystem */
final class C0983j extends C0985k {

    /* renamed from: a  reason: collision with root package name */
    private final Future f3709a;

    public C0983j(Future future) {
        this.f3709a = future;
    }

    public void a(Throwable th) {
        if (th != null) {
            this.f3709a.cancel(false);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return s.f8222a;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f3709a + ']';
    }
}
