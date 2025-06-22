package k0;

import android.os.Handler;
import android.os.Looper;
import d0.a;
import java.util.concurrent.Executor;

final class N implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f3485a = new a(Looper.getMainLooper());

    public final void execute(Runnable runnable) {
        this.f3485a.post(runnable);
    }
}
