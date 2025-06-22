package J;

import java.util.concurrent.Callable;

final class L extends N {

    /* renamed from: f  reason: collision with root package name */
    private final Callable f314f;

    /* synthetic */ L(Callable callable, K k4) {
        super(false, 1, 5, (String) null, (Throwable) null, (M) null);
        this.f314f = callable;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        try {
            return (String) this.f314f.call();
        } catch (Exception e5) {
            throw new RuntimeException(e5);
        }
    }
}
