package L;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class n implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f399a;

    public /* synthetic */ n(Handler handler) {
        this.f399a = handler;
    }

    public final void execute(Runnable runnable) {
        this.f399a.post(runnable);
    }
}
